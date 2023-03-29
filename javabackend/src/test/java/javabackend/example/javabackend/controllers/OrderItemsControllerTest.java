package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.Service.OrderItemsService;
import javabackend.example.javabackend.models.order_items;
import javabackend.example.javabackend.repositories.ordersItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

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
    }

    @Test
    public void testGetOrdersItems() {
        List<order_items> orderItems = new ArrayList<>();
        orderItems.add(new order_items(1, 1, "Product 1", 10));
        orderItems.add(new order_items(2, 1, "Product 2", 20));
        when(ordersItemRepository.findAll()).thenReturn(orderItems);

        String viewName = orderItemsController.getOrdersItems(model);

        assertThat(viewName).isEqualTo("Orders-Item");

        List<order_items> actualItems = (List<order_items>) model.asMap().get("order_items");
        assertThat(actualItems).isEqualTo(orderItems);
        assertThat(actualItems.size()).isEqualTo(orderItems.size());
    }

    @Test
    public void testGetSpecificItem() {
        List<order_items> orderItems = new ArrayList<>();
        orderItems.add(new order_items(1, 1, "Product 1", 10));
        orderItems.add(new order_items(2, 1, "Product 2", 20));
        orderItems.add(new order_items(3, 2, "Product 3", 30));
        when(ordersItemRepository.findAll()).thenReturn(orderItems);

        String viewName = orderItemsController.getSpecificItem(1, model);

        assertThat(viewName).isEqualTo("Orders-Item");

        List<order_items> actualItems = (List<order_items>) model.asMap().get("order_items");
        assertThat(actualItems).extracting(order_items::getOrder_id).containsOnly(1);
    }
}

