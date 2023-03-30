package javabackend.example.javabackend.controllers;

//C:\Users\giftg\Documents\GitHub\Event-Tick\javabackend\src\main\java\javabackend\example\javabackend\repositories\OrdersRepository.java

import javabackend.example.javabackend.Service.OrdersService;
import javabackend.example.javabackend.models.orders;
import javabackend.example.javabackend.repositories.OrdersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    OrdersRepository ordersRepository;

    @Mock
    OrdersService ordersService;

    @Mock
    Model model;

    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderController = new OrderController(ordersService);
        orderController.ordersRepository = ordersRepository;
    }

    @Test
    void getOrders() {
        List<orders> orders = new ArrayList<>();
        orders.add(new orders(1, "Pending"));
        orders.add(new orders(2, "Processing"));
        when(ordersRepository.findAll()).thenReturn(orders);

        String result = orderController.getOrders(model);
        Assertions.assertEquals("Orders-Page", result, "They are both the same value");
        verify(ordersRepository, times(1)).findAll();
        verify(model, times(1)).addAttribute("orders", orders);
    }

    @Test
    void updateStatusWithValidOrderId() {
        int orderId = 1;
        orders expectedOrder = new orders(orderId, "Pending");
        when(ordersRepository.findById(orderId)).thenReturn(Optional.of(expectedOrder));

        String result = orderController.updateStatus(orderId, model);
        Assertions.assertEquals("Orders-Status", result, "they are both the same value");
        verify(ordersRepository, times(1)).findById(orderId);
        verify(model, times(1)).addAttribute("orderId", orderId);
        verify(model, times(1)).addAttribute("currentStatus", expectedOrder.getStatus());
    }

    @Test
    void updateStatusWithInvalidOrderId() {
        int orderId = 1;
        when(ordersRepository.findById(orderId)).thenReturn(Optional.empty());

        String result = orderController.updateStatus(orderId, model);
        Assertions.assertEquals("Error-Page", result, "they are both the same value");
        verify(ordersRepository, times(1)).findById(orderId);
        verify(model, never()).addAttribute(anyString(), any());
    }

    @Test
    void updateStatusPost() {
        int orderId = 1;
        orders preExistingOrder = new orders(orderId, "Pending");
        orders updatedOrder = new orders(orderId, "Processing");
        when(ordersService.getOrdersById(orderId)).thenReturn(preExistingOrder);

        String result = orderController.updateStatus(orderId, updatedOrder, model);
        Assertions.assertEquals("redirect:/Orders", result, "they both match to the same value");
        verify(ordersService, times(1)).getOrdersById(orderId);
        verify(ordersService, times(1)).updateOrders(preExistingOrder);
        Assertions.assertEquals("Processing", preExistingOrder.getStatus(), "they both match to the same value");
    }

    @Test
    void filterOrdersAll() {
        List<orders> orders = new ArrayList<>();
        orders.add(new orders(1, "Pending"));
        orders.add(new orders(2, "Processing"));
        when(ordersRepository.findAll()).thenReturn(orders);

        String result = orderController.filterOrders("all", model);
        Assertions.assertEquals("Orders-Page", result, "they both match to the same value");
        verify(ordersRepository, times(2)).findAll();
        verify(model, times(1)).addAttribute("orders", orders);
    }

    @Test
    void filterOrdersPending() {
        List<orders> expected;
    }
}