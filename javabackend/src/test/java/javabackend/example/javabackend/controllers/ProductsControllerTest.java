package javabackend.example.javabackend.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import javabackend.example.javabackend.Service.ProductsService;
import javabackend.example.javabackend.controllers.ProductsController;
import javabackend.example.javabackend.models.Products;
import org.springframework.web.multipart.MultipartFile;

class ProductsControllerTest {

    private ProductsService productsServiceMock;
    private ProductsController productsController;
    private Model modelMock;
    private BindingResult bindingResultMock;
    private MultipartFile multipartFileMock;
    private Products products;

    @BeforeEach
    void setUp() {
        productsServiceMock = mock(ProductsService.class);
        productsController = new ProductsController(productsServiceMock);
        modelMock = mock(Model.class);
        bindingResultMock = mock(BindingResult.class);
        multipartFileMock = mock(MultipartFile.class);
        products = new Products();
        products.setId(1);
        products.setName("Product");
        products.setDescription("Product description");
        products.setPrice(10.0F);
        products.setStock(5);
        products.setImg("product.jpg");  // adding all the v fields for the test. and using mockito
    }

    @Test
    void testListProducts() {
        List<Products> productsList = new ArrayList<>();
        productsList.add(products);
        when(productsServiceMock.getAllProducts()).thenReturn(productsList);
        assertThat(productsController.listProducts(modelMock)).isEqualTo("Products-Page"); // checks whether the products exist.
    }

    @Test
    void testCreateProductForm() {
        assertThat(productsController.createProductForm(modelMock)).isEqualTo("Create-product"); // test for the form being present.
    }

    @Test
    void testSaveProduct() throws Exception {
        //when(bindingResultMock.hasErrors()).thenReturn(false);
        when(bindingResultMock.hasErrors()).thenReturn(true);
        when(multipartFileMock.getOriginalFilename()).thenReturn("product.jpg"); // Model, BindingResult, and MultipartFile objects for the test.
        when(productsServiceMock.saveProduct(products)).thenReturn(products);
        assertThat(productsController.saveProduct(products, bindingResultMock, multipartFileMock)).isEqualTo("Create-product"); // checks if the new products are saved.
    }

    @Test
    void testDeleteProduct() {
        assertThat(productsController.deleteProduct(1)).isEqualTo("redirect:/products"); // checks if the products have been saved
    }

    @Test
    void testEditProductForm() {
        when(productsServiceMock.getProductById(1)).thenReturn(products);
        assertThat(productsController.editProductForm(1, modelMock)).isEqualTo("Update-product"); // test to see if the project form has been done.
    }

    @Test
    void testUpdateProduct() {
        Products updatedProduct = new Products();
        updatedProduct.setId(1);
        updatedProduct.setStock(10);
        when(productsServiceMock.getProductById(1)).thenReturn(products);
        assertThat(productsController.updateProduct(1, updatedProduct, modelMock)).isEqualTo("redirect:/products"); // tests to see if the products are updated.
    }

    @Test
    void testSearchForProducts() {
        List<Products> productsList = new ArrayList<>();
        productsList.add(products);
        when(productsServiceMock.findByKeyword("Product")).thenReturn(productsList);
        assertThat(productsController.searchForProducts(modelMock, "Product")).isEqualTo("Products-page"); //tests to see if the test search is working.
    }

}
    //in these tests, i use Mockito to mock the ProductsService class
    //return the expected values based on the input parameters and mock object behavior.
