package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.Service.ProductsService;
import javabackend.example.javabackend.models.Products;
import javabackend.example.javabackend.repositories.ProductsRepository;
import javabackend.example.javabackend.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;


import javax.swing.text.Document;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


@Controller
public class ReportPDFController {

    private final ProductsRepository productsRepository;
    private final ProductsService productsService;

    @Autowired
    public ReportPDFController(ProductsRepository productsRepository, ProductsService productsService) {
        super();
        this.productsRepository = productsRepository;
        this.productsService = productsService;
    }




//    This is for the stock report pdfs....
    @GetMapping("/Report/Stock/pdf")
    public ResponseEntity<byte[]> generateStockReportPdf() throws IOException {
        // Fetch data from repository
        List<Products> products = productsRepository.findAll();

        // Create PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Add content to the PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        contentStream.newLineAtOffset(25, 750);
        contentStream.showText("Stock Report");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(25, 725);
        contentStream.showText("Date: " + java.time.LocalDate.now());
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Time: " + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")));
        contentStream.endText();

        // Create table header
        float tableTopY = 650;
        float tableBottomY = 50;
        float tableWidth = page.getMediaBox().getWidth() - (2 * 25);
        float columnWidth = tableWidth / 2f;
        float[] columnCoordinates = {25, 25 + columnWidth};
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(25, tableTopY);
        contentStream.lineTo(25 + tableWidth, tableTopY);
        contentStream.stroke();
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(columnCoordinates[0], tableTopY - 20);
        contentStream.showText("Product Name");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Stock");
        contentStream.endText();

        // Fill table with data
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        float currentY = tableTopY - 40;
        for (Products product : products) {
            contentStream.beginText();
            contentStream.newLineAtOffset(columnCoordinates[0], currentY);
            contentStream.showText(product.getName());
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(Integer.toString(product.getStock()));
            contentStream.endText();
            currentY -= 20;
            if (currentY < tableBottomY) {
                // Start new page if table row would fall off current page
                contentStream.close();
                PDPage newPage = new PDPage(page.getMediaBox());
                document.addPage(newPage);
                contentStream = new PDPageContentStream(document, newPage);
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                contentStream.newLineAtOffset(25, 750);
                contentStream.showText("Stock Report");
                contentStream.endText();
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(25, 725);
                contentStream.showText("Date: " + java.time.LocalDate.now());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Time: " + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")));
                contentStream.endText();
                currentY = newPage.getMediaBox().getHeight() - 40;
            }
        }

        contentStream.close();

        // Write PDF to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();
        byte[] bytes = baos.toByteArray();

        // Send PDF as response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "Stock-Report.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(bytes, headers, HttpStatus.OK);

        return response;
    }

}
