package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.Service.OrdersService;
import javabackend.example.javabackend.models.orders;
import javabackend.example.javabackend.repositories.ordersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.aspectj.bridge.MessageUtil.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrdersService ordersService;
    @Mock
    private ordersRepository ordersRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public List setup() {
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



    @Test
    public void getOrders() {
        List orders = setup();
        if (orders.isEmpty()) {
            System.out.println("There are no orders");
        } else {
            System.out.println("There are orders");
        }
        System.out.println("The test 'GetOrders' is working properly.");

    }



    @Test
    void updateStatusWithValidOrderId() {
        List<orders> orders = setup();
        for (orders order : orders) {
            if (order.getId() == 1) {
                order.setStatus("shipped");
                break;
            }
        }
        orders updatedOrder = orders.get(0);
        assertEquals("shipped", updatedOrder.getStatus());
        System.out.println("The test 'updateStatusWithValidOrderId' is working properly.");
    }



    @Test
    void updateStatusWithInvalidOrderId() {
        List<orders> orders = setup();

        boolean orderFound = false;
        for (orders order : orders) {
            if (order.getId() == 4) {
                order.setStatus("shipped");
                orderFound = true;
                break;
            }
        }
        if (!orderFound) {
            fail("Could not find order with id 4");
        }
        orders updatedOrder = orders.get(0);
        assertEquals("pending", updatedOrder.getStatus());
        System.out.println("The test 'updateStatusWithInvalidOrderId' is working properly.");
    }

    @Test
    void filterOrdersAll() {
        List<orders> orders = setup();
        List<orders> filteredOrders = new ArrayList<>(); // Initialize filteredOrders with an empty ArrayList
        for (orders order : orders) {
            if (order.getStatus().equals("pending")) {
                filteredOrders.add(order);
            }
        }

        System.out.println(filteredOrders);
        assertEquals(2, filteredOrders.size());
        System.out.println("The test 'filterOrdersAll' is working properly.");
    }







}
