package javabackend.example.javabackend.Service;

import java.util.List;

import javabackend.example.javabackend.models.orders;

public interface OrdersService {
    List<orders> getAllOrders();

    orders saveOrder(orders orders);

    void deleteOrdersById(Integer id);

    orders getOrdersById(Integer id);

    orders updateOrders(orders orders);

}
