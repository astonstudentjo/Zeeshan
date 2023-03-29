package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.Service.ProductsService;
import javabackend.example.javabackend.models.*;

import javabackend.example.javabackend.repositories.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class ReportPDFController {

    private final ProductsRepository productsRepository;
    private final ProductsService productsService;
    private final UsersRepository UsersRepository;
    private final ordersRepository orderRepository;
    private final ordersItemRepository orderItemRepository;


    @Autowired
    public ReportPDFController(ProductsRepository productsRepository, ProductsService productsService, UsersRepository usersRepository, ordersRepository orderRepository, ordersItemRepository orderItemRepository) {
        super();
        this.productsRepository = productsRepository;
        this.productsService = productsService;
        this.UsersRepository = usersRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
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

//    for the users report

    @GetMapping("/Report/Users/pdf")
    public ResponseEntity<byte[]> generateUsersReportPdf() throws IOException {
        // Fetch data from repositories
        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<users> users = (List<users>) UsersRepository.findAll();

        // Create PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Add content to the PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        contentStream.newLineAtOffset(25, 750);
        contentStream.showText("User Report");
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
        float columnWidth = tableWidth / 4f;
        float[] columnCoordinates = {25, 25 + columnWidth, 25 + (2 * columnWidth), 25 + (3 * columnWidth)};
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(25, tableTopY);
        contentStream.lineTo(25 + tableWidth, tableTopY);
        contentStream.stroke();
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(columnCoordinates[0], tableTopY - 20);
        contentStream.showText("User ID");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("User Name");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Order Count");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Items Bought");
        contentStream.endText();

        // Fill table with data
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        float currentY = tableTopY - 40;
        for (Map<String, Object> userOrder : getUserOrderData()) {
            users user = (users) userOrder.get("user");
            int numOrders = (int) userOrder.get("numOrders");
            int numItems = (int) userOrder.get("numItems");
            contentStream.beginText();
            contentStream.newLineAtOffset(columnCoordinates[0], currentY);
            contentStream.showText(Integer.toString(user.getId()));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(user.getName());
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(Integer.toString(numOrders));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(Integer.toString(numItems));
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
                contentStream.showText("User Report");
                contentStream.endText();
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(25, 725);
                contentStream.showText("Date: " + java.time.LocalDate.now());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Time: " + java.time.LocalTime.now().format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss")));
                contentStream.endText();
                currentY = tableTopY;
                // Create table header on new page
                contentStream.setLineWidth(0.5f);
                contentStream.moveTo(25, currentY);
                contentStream.lineTo(25 + tableWidth, currentY);
                contentStream.stroke();
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.newLineAtOffset(columnCoordinates[0], currentY - 20);
                contentStream.showText("User ID");
                contentStream.newLineAtOffset(columnWidth, 0);
                contentStream.showText("User Name");
                contentStream.newLineAtOffset(columnWidth, 0);
                contentStream.showText("Order Count");
                contentStream.newLineAtOffset(columnWidth, 0);
                contentStream.showText("Items Bought");
                contentStream.endText();
                currentY -= 40;
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
        headers.setContentDispositionFormData("inline", "User-Report.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(bytes, headers, HttpStatus.OK);

        return response;
    }


    private List<Map<String, Object>> getUserOrderData() {
        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<users> users = (List<javabackend.example.javabackend.models.users>) UsersRepository.findAll();

        Map<Integer, Integer> userOrders = new HashMap<>();
        for (orders order : orders) {
            int userId = order.getUser_id();
            userOrders.put(userId, userOrders.getOrDefault(userId, 0) + 1);
        }

        List<Map<String, Object>> userOrderData = new ArrayList<>();
        for (users user : users) {
            Map<String, Object> userOrder = new HashMap<>();
            userOrder.put("user", user);
            int numOrders = userOrders.getOrDefault(user.getId(), 0);
            int numItems = 0;
            for (order_items order_item : order_items) {
                if (orders.stream().filter(o -> o.getId() == order_item.getOrder_id())
                        .anyMatch(o -> o.getUser_id() == user.getId())) {
                    numItems += order_item.getQuantity();

                }
            }
            userOrder.put("numOrders", numOrders);
            userOrder.put("numItems", numItems);
            userOrderData.add(userOrder);
        }
        return userOrderData;
    }


    // for the orders report
    @GetMapping("/Report/Orders/pdf")
    public ResponseEntity<byte[]> ordersReport() throws IOException {
        List<orders> orders = orderRepository.findAll();
        List<order_items> orderItems = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        int totalOrders = 0;

        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            if (order.getStatus().equals("pending") || order.getStatus().equals("Processing") || order.getStatus().equals("Shipped") || order.getStatus().equals("Cancelled") || order.getStatus().equals("Delivered")) {
                filteredOrders.add(order);
            }
        }

        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items orderItem : orderItems) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == orderItem.getOrder_id())) {
                filteredOrderItems.add(orderItem);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();
        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        // build order data
        List<Map<String, Object>> orderData = new ArrayList<>();
        for (orders order : filteredOrders) {
            Map<String, Object> orderItem = new HashMap<>();
            orderItem.put("id", order.getId());
            orderItem.put("dateCreated", order.getCreated_at());
            orderItem.put("dateUpdated", order.getUpdated_at());
            orderItem.put("status", order.getStatus());

            List<String> productNames = new ArrayList<>();
            List<Integer> quantities = new ArrayList<>();
            for (order_items orderItem_item : filteredOrderItems) {
                if (orderItem_item.getOrder_id() == order.getId()) {
                    int productId = orderItem_item.getProduct_id();
                    int quantity = orderItem_item.getQuantity();
                    quantities.add(quantity);

                    String productName = filteredProducts.stream()
                            .filter(p -> p.getId() == productId)
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Could not find product with id " + productId))
                            .getName();
                    productNames.add(productName);
                }
            }

            orderItem.put("productName", String.join("<br>", productNames));
            orderItem.put("quantity", quantities.stream().map(Object::toString).collect(Collectors.joining("<br>")));
            orderData.add(orderItem);
        }
        String Title = "Orders Report";

        // Create PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Add content to the PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        contentStream.newLineAtOffset(25, 750);
        contentStream.showText(Title);
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
        float columnWidth = tableWidth / 5f;
        float[] columnCoordinates = {25, 25 + columnWidth, 25 + (2 * columnWidth), 25 + (3 * columnWidth), 25 + (4 * columnWidth)};
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(25, tableTopY);
        contentStream.lineTo(25 + tableWidth, tableTopY);
        contentStream.stroke();
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(columnCoordinates[0], tableTopY - 20);
        contentStream.showText("Order ID");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Date Created");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Date Updated");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Status");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Product Name");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Quantity");
        contentStream.endText();

        // Fill table with data
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        float currentY = tableTopY - 40;
        for (Map<String, Object> item : orderData) {
            contentStream.beginText();
            contentStream.newLineAtOffset(columnCoordinates[0], currentY);
            contentStream.showText(String.valueOf(item.get("id")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("dateCreated")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("dateUpdated")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("status")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("productName")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("quantity")));
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
                contentStream.endText();
                currentY = newPage.getMediaBox().getHeight() - 40;
            }
        }

        // Create footer
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(25, 40);
        contentStream.showText("Total Orders: " + String.valueOf(filteredOrders.size()));
        contentStream.endText();

        contentStream.close();

        // Write PDF to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();
        byte[] bytes = baos.toByteArray();

        // Send PDF as response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename("orders.pdf").build());
        return ResponseEntity.ok().headers(headers).body(bytes);



    }



    //    for the todays sales report
    @GetMapping("/Report/Sales/Today/pdf")
    public ResponseEntity<byte[]> todaysSalesReport() throws IOException {
        LocalDateTime startDate = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endDate = LocalDateTime.now().with(LocalTime.MAX);
        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        double totalSales = 0;
        int totalQuantity = 0;
        String Title = "Today's Sales Report for " + LocalDate.now();
        String url = "/Report/Sales/Today/pdf";


        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            if (order.getCreated_at().after(Timestamp.valueOf(startDate)) && order.getCreated_at().before(Timestamp.valueOf(endDate))) {
                filteredOrders.add(order);
            }
        }


        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items order_item : order_items) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == order_item.getOrder_id())) {
                filteredOrderItems.add(order_item);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();

        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        for (order_items order_item : filteredOrderItems) {
            totalSales += order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice();
            totalQuantity += order_item.getQuantity();
        }

        List<Map<String, Object>> sale = new ArrayList<>();
        for (order_items order_item : filteredOrderItems) {
            Map<String, Object> saleItem = new HashMap<>();
            saleItem.put("order_id", order_item.getOrder_id());
            saleItem.put("product_name", filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getName());
            saleItem.put("quantity", order_item.getQuantity());
            saleItem.put("total_price", order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice());
            saleItem.put("created_at", filteredOrders.stream().filter(o -> o.getId() == order_item.getOrder_id()).findFirst().get().getCreated_at());
            sale.add(saleItem);
        }

        // Create PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Add content to the PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        contentStream.newLineAtOffset(25, 750);
        contentStream.showText(Title);
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
        float columnWidth = tableWidth / 5f;
        float[] columnCoordinates = {25, 25 + columnWidth, 25 + (2 * columnWidth), 25 + (3 * columnWidth), 25 + (4 * columnWidth)};
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(25, tableTopY);
        contentStream.lineTo(25 + tableWidth, tableTopY);
        contentStream.stroke();
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(columnCoordinates[0], tableTopY - 20);
        contentStream.showText("Order ID");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Product Name");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Quantity");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Profit");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Date");
        contentStream.endText();

        // Fill table with data
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        float currentY = tableTopY - 40;
        for (Map<String, Object> item : sale) {
            contentStream.beginText();
            contentStream.newLineAtOffset(columnCoordinates[0], currentY);
            contentStream.showText(String.valueOf(item.get("order_id")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("product_name")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("quantity")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.format("%.2f", item.get("total_price")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("created_at")));
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
                contentStream.endText();
                currentY = newPage.getMediaBox().getHeight() - 40;
            }

        }

            // Create footer
            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.newLineAtOffset(25, 40);
            contentStream.showText("Total Sales: " + String.format("%.2f", totalSales));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText("Total Quantity: " + totalQuantity);
            contentStream.endText();

            contentStream.close();

            // Write PDF to byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            document.save(baos);
            document.close();
            byte[] bytes = baos.toByteArray();

            // Send PDF as response
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "Daily-Sales-Report.pdf");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<>(bytes, headers, HttpStatus.OK);

            return response;


    }



    //    for the ThisWeeks sales report
    @GetMapping("/Report/Sales/ThisWeek/pdf")
    public ResponseEntity<byte[]> weeklySalesReport() throws IOException {
        LocalDateTime startDate = LocalDateTime.now().minusDays(7);
        LocalDateTime endDate = LocalDateTime.now();

        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        double totalSales = 0;
        int totalQuantity = 0;
        String Title = "This Weeks Sales Report for " + startDate.toLocalDate() + " to " + endDate.toLocalDate();
        String url = "/Report/Sales/ThisWeek/pdf";




        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            if (order.getCreated_at().after(Timestamp.valueOf(startDate)) && order.getCreated_at().before(Timestamp.valueOf(endDate))) {
                filteredOrders.add(order);
            }
        }


        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items order_item : order_items) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == order_item.getOrder_id())) {
                filteredOrderItems.add(order_item);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();

        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        for (order_items order_item : filteredOrderItems) {
            totalSales += order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice();
            totalQuantity += order_item.getQuantity();
        }

        List<Map<String, Object>> sale = new ArrayList<>();
        for (order_items order_item : filteredOrderItems) {
            Map<String, Object> saleItem = new HashMap<>();
            saleItem.put("order_id", order_item.getOrder_id());
            saleItem.put("product_name", filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getName());
            saleItem.put("quantity", order_item.getQuantity());
            saleItem.put("total_price", order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice());
            saleItem.put("created_at", filteredOrders.stream().filter(o -> o.getId() == order_item.getOrder_id()).findFirst().get().getCreated_at());
            sale.add(saleItem);
        }

        // Create PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Add content to the PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        contentStream.newLineAtOffset(25, 750);
        contentStream.showText(Title);
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
        float columnWidth = tableWidth / 5f;
        float[] columnCoordinates = {25, 25 + columnWidth, 25 + (2 * columnWidth), 25 + (3 * columnWidth), 25 + (4 * columnWidth)};
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(25, tableTopY);
        contentStream.lineTo(25 + tableWidth, tableTopY);
        contentStream.stroke();
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(columnCoordinates[0], tableTopY - 20);
        contentStream.showText("Order ID");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Product Name");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Quantity");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Profit");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Date");
        contentStream.endText();

        // Fill table with data
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        float currentY = tableTopY - 40;
        for (Map<String, Object> item : sale) {
            contentStream.beginText();
            contentStream.newLineAtOffset(columnCoordinates[0], currentY);
            contentStream.showText(String.valueOf(item.get("order_id")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("product_name")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("quantity")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.format("%.2f", item.get("total_price")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("created_at")));
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
                contentStream.endText();
                currentY = newPage.getMediaBox().getHeight() - 40;
            }

        }

        // Create footer
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(25, 40);
        contentStream.showText("Total Sales: " + String.format("%.2f", totalSales));
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Total Quantity: " + totalQuantity);
        contentStream.endText();

        contentStream.close();

        // Write PDF to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();
        byte[] bytes = baos.toByteArray();

        // Send PDF as response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "Weekly-Sales-Report.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(bytes, headers, HttpStatus.OK);

        return response;
    }



    //    for the ThisMonths sales report
    @GetMapping("/Report/Sales/ThisMonth/pdf")
    public ResponseEntity<byte[]> MonthlySalesReport() throws IOException {
        LocalDateTime startDate = LocalDateTime.now().minusDays(30);
        LocalDateTime endDate = LocalDateTime.now();

        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        double totalSales = 0;
        int totalQuantity = 0;
        String Title = "This Months Sales Report for " + startDate.toLocalDate() + " to " + endDate.toLocalDate();
        String url = "/Report/Sales/ThisMonth/pdf";



        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            if (order.getCreated_at().after(Timestamp.valueOf(startDate)) && order.getCreated_at().before(Timestamp.valueOf(endDate))) {
                filteredOrders.add(order);
            }
        }


        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items order_item : order_items) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == order_item.getOrder_id())) {
                filteredOrderItems.add(order_item);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();

        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        for (order_items order_item : filteredOrderItems) {
            totalSales += order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice();
            totalQuantity += order_item.getQuantity();
        }

        List<Map<String, Object>> sale = new ArrayList<>();
        for (order_items order_item : filteredOrderItems) {
            Map<String, Object> saleItem = new HashMap<>();
            saleItem.put("order_id", order_item.getOrder_id());
            saleItem.put("product_name", filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getName());
            saleItem.put("quantity", order_item.getQuantity());
            saleItem.put("total_price", order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice());
            saleItem.put("created_at", filteredOrders.stream().filter(o -> o.getId() == order_item.getOrder_id()).findFirst().get().getCreated_at());
            sale.add(saleItem);
        }

        // Create PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Add content to the PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        contentStream.newLineAtOffset(25, 750);
        contentStream.showText(Title);
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
        float columnWidth = tableWidth / 5f;
        float[] columnCoordinates = {25, 25 + columnWidth, 25 + (2 * columnWidth), 25 + (3 * columnWidth), 25 + (4 * columnWidth)};
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(25, tableTopY);
        contentStream.lineTo(25 + tableWidth, tableTopY);
        contentStream.stroke();
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(columnCoordinates[0], tableTopY - 20);
        contentStream.showText("Order ID");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Product Name");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Quantity");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Profit");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Date");
        contentStream.endText();

        // Fill table with data
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        float currentY = tableTopY - 40;
        for (Map<String, Object> item : sale) {
            contentStream.beginText();
            contentStream.newLineAtOffset(columnCoordinates[0], currentY);
            contentStream.showText(String.valueOf(item.get("order_id")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("product_name")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("quantity")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.format("%.2f", item.get("total_price")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("created_at")));
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
                contentStream.endText();
                currentY = newPage.getMediaBox().getHeight() - 40;
            }

        }

        // Create footer
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(25, 40);
        contentStream.showText("Total Sales: " + String.format("%.2f", totalSales));
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Total Quantity: " + totalQuantity);
        contentStream.endText();

        contentStream.close();

        // Write PDF to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();
        byte[] bytes = baos.toByteArray();

        // Send PDF as response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "Monthly-Sales-Report.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(bytes, headers, HttpStatus.OK);

        return response;
    }


    //    for the ThisWeeks sales report
    @GetMapping("/Report/Sales/pdf")
    public ResponseEntity<byte[]> FullSalesReport() throws IOException {
        List<orders> orders = orderRepository.findAll();
        List<order_items> order_items = orderItemRepository.findAll();
        List<Products> products = productsRepository.findAll();

        double totalSales = 0;
        int totalQuantity = 0;
        String Title = "Full Sales Report";
        String url = "/Report/Sales/pdf";




        List<orders> filteredOrders = new ArrayList<>();
        for (orders order : orders) {
            filteredOrders.add(order);
        }


        List<order_items> filteredOrderItems = new ArrayList<>();
        for (order_items order_item : order_items) {
            if (filteredOrders.stream().anyMatch(o -> o.getId() == order_item.getOrder_id())) {
                filteredOrderItems.add(order_item);
            }
        }

        List<Products> filteredProducts = new ArrayList<>();

        for (Products product : products) {
            if (filteredOrderItems.stream().anyMatch(o -> o.getProduct_id() == product.getId())) {
                filteredProducts.add(product);
            }
        }

        for (order_items order_item : filteredOrderItems) {
            totalSales += order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice();
            totalQuantity += order_item.getQuantity();
        }

        List<Map<String, Object>> sale = new ArrayList<>();
        for (order_items order_item : filteredOrderItems) {
            Map<String, Object> saleItem = new HashMap<>();
            saleItem.put("order_id", order_item.getOrder_id());
            saleItem.put("product_name", filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getName());
            saleItem.put("quantity", order_item.getQuantity());
            saleItem.put("total_price", order_item.getQuantity() * filteredProducts.stream().filter(p -> p.getId() == order_item.getProduct_id()).findFirst().get().getPrice());
            saleItem.put("created_at", filteredOrders.stream().filter(o -> o.getId() == order_item.getOrder_id()).findFirst().get().getCreated_at());
            sale.add(saleItem);
        }


        // Create PDF document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        // Add content to the PDF
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
        contentStream.newLineAtOffset(25, 750);
        contentStream.showText(Title);
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
        float columnWidth = tableWidth / 5f;
        float[] columnCoordinates = {25, 25 + columnWidth, 25 + (2 * columnWidth), 25 + (3 * columnWidth), 25 + (4 * columnWidth)};
        contentStream.setLineWidth(0.5f);
        contentStream.moveTo(25, tableTopY);
        contentStream.lineTo(25 + tableWidth, tableTopY);
        contentStream.stroke();
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(columnCoordinates[0], tableTopY - 20);
        contentStream.showText("Order ID");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Product Name");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Quantity");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Profit");
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Date");
        contentStream.endText();

        // Fill table with data
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        float currentY = tableTopY - 40;
        for (Map<String, Object> item : sale) {
            contentStream.beginText();
            contentStream.newLineAtOffset(columnCoordinates[0], currentY);
            contentStream.showText(String.valueOf(item.get("order_id")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("product_name")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("quantity")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.format("%.2f", item.get("total_price")));
            contentStream.newLineAtOffset(columnWidth, 0);
            contentStream.showText(String.valueOf(item.get("created_at")));
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
                contentStream.endText();
                currentY = newPage.getMediaBox().getHeight() - 40;
            }

        }

        // Create footer
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(25, 40);
        contentStream.showText("Total Sales: " + String.format("%.2f", totalSales));
        contentStream.newLineAtOffset(columnWidth, 0);
        contentStream.showText("Total Quantity: " + totalQuantity);
        contentStream.endText();

        contentStream.close();

        // Write PDF to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();
        byte[] bytes = baos.toByteArray();

        // Send PDF as response
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("inline", "Full-Sales-Report.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(bytes, headers, HttpStatus.OK);

        return response;
    }

}












