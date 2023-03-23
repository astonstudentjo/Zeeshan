package javabackend.example.javabackend.controllers;

import static org.junit.jupiter.api.Assertions.*;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

        import java.util.ArrayList;
        import java.util.List;

import javabackend.example.javabackend.Service.ProductsService;
import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;
        import org.springframework.ui.Model;

        import javabackend.example.javabackend.models.order_items;
        import javabackend.example.javabackend.repositories.ordersItemRepository;
        import javabackend.example.javabackend.Service.OrderItemsService;

public class OrderItemsControllerTest {

    @Mock
    private OrderItemsService orderItemsService;

    @Mock
    private ordersItemRepository ordersItemRepository;

    @Mock
    private Model model;

    private OrderItemsController orderItemsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderItemsController = new OrderItemsController(orderItemsService);
        //orderItemsControllerMock = mock(ProductsService.class);
    }

    @Test
    public void testGetOrdersItems() {

        List<order_items> orderItems = new ArrayList<>();
        orderItems.add(new order_items(1, 1, "Product 1", 10));
        orderItems.add(new order_items(2, 1, "Product 2", 20));

        when(ordersItemRepository.findAll()).thenReturn(orderItems);
        //when(model.getClass().);
        //when(orderItemsController.getOrdersItems(model)).thenReturn(model.toString());

        String viewName = orderItemsController.getOrdersItems(model);
        assertThat(viewName).isEqualTo("Orders-Item");

        List<order_items> actualItems = (List<order_items>) model.asMap().get("order_items");
        assertThat(actualItems).isEqualTo(orderItems);
    }
    @Test
    public void testGetSpecificItem() {
        int orderId = 1;

        List<order_items> orderItems = new ArrayList<>();
        orderItems.add(new order_items(1, 1, "Product 1", 10));
        orderItems.add(new order_items(2, 1, "Product 2", 20));
        orderItems.add(new order_items(3, 2, "Product 3", 30)); // test data

        when(ordersItemRepository.findAll()).thenReturn(orderItems);

        String viewName = orderItemsController.getSpecificItem(orderId, OrderItemsController.model);
        assertThat(viewName).isEqualTo("Orders-Item");

        List<order_items> expectedItems = new ArrayList<>();
        expectedItems.add(new order_items(1, 1, "Product 1", 10));
        expectedItems.add(new order_items(2, 1, "Product 2", 20));

        List<order_items> actualItems = (List<order_items>) model.asMap().get("order_items");
        assertThat(actualItems).isEqualTo(expectedItems); // if gets specific item this should assert.
    }





}

