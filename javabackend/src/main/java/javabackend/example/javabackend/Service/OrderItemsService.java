package javabackend.example.javabackend.Service;

import javabackend.example.javabackend.models.*;

import java.util.List;

public interface OrderItemsService {
    List<order_items> getAllOrderItems();
    order_items updateStatus(order_items orderItems);
}
