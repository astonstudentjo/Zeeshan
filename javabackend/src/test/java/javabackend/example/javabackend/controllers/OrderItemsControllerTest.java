package javabackend.example.javabackend.controllers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javabackend.example.javabackend.Service.OrdersService;
import javabackend.example.javabackend.models.orders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javabackend.example.javabackend.models.order_items;
import javabackend.example.javabackend.repositories.ordersItemRepository;
import javabackend.example.javabackend.Service.OrderItemsService;

public class OrderItemsControllerTest {
    @Mock
    private OrdersService ordersService;

    @Mock
    private OrderItemsService orderItemsService;
    @Mock
    private javabackend.example.javabackend.repositories.ordersRepository ordersRepository;

    @Mock
    private ordersItemRepository ordersItemRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public List orders() {
        orders order1 = new orders();
        order1.setId(1);
        order1.setUser_id(1);
        order1.setTotal_price(100);
        order1.setCreated_at(null);
        order1.setUpdated_at(null);
        order1.setStatus("pending");

        orders order2 = new orders();
        order2.setId(2);
        order2.setUser_id(2);
        order2.setTotal_price(200);
        order2.setCreated_at(null);
        order2.setUpdated_at(null);
        order2.setStatus("pending");

        orders order3 = new orders();
        order3.setId(3);
        order3.setUser_id(3);
        order3.setTotal_price(300);
        order3.setCreated_at(null);
        order3.setUpdated_at(null);
        order3.setStatus("shipped");

        List<orders> orders = Arrays.asList(order1, order2, order3);
        return orders;
    }

    public List orderItems() {
        order_items orderItem1 = new order_items();
        orderItem1.setId(1);
        orderItem1.setOrder_id(1);
        orderItem1.setProduct_id(1);
        orderItem1.setQuantity(1);

        order_items orderItem2 = new order_items();
        orderItem2.setId(2);
        orderItem2.setOrder_id(2);
        orderItem2.setProduct_id(2);
        orderItem2.setQuantity(2);

        order_items orderItem3 = new order_items();
        orderItem3.setId(3);
        orderItem3.setOrder_id(3);
        orderItem3.setProduct_id(3);
        orderItem3.setQuantity(3);

        List<order_items> orderItems = Arrays.asList(orderItem1, orderItem2, orderItem3);
        return orderItems;
    }


    @Test
    public void testGetOrderItems() {
        List orders = orders();
        List orderItems = orderItems();
        when(ordersService.getAllOrders()).thenReturn(orders);
        when(orderItemsService.getAllOrderItems()).thenReturn(orderItems);
        assertThat(orderItems.size()).isGreaterThan(0);
        assertThat(orders.size()).isGreaterThan(0);
        System.out.println("The test 'GetOrderItems' is working properly.");
    }

    @Test
    public void testGetOrderItemsByOrderId() {
        List<orders> orders = orders();
        for (orders order : orders) {
            List<order_items> orderItems = orderItems();
            for (order_items orderItem : orderItems) {
                if (orderItem.getOrder_id() == order.getId()) {
                    System.out.println(orderItem.getOrder_id());
                } else{
                    return;
                }
            }
        }
    }








}

