package javabackend.example.javabackend.Service;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javabackend.example.javabackend.models.order_items;
import javabackend.example.javabackend.repositories.ordersItemRepository;

@Service
public class OrderItemsServiceImplementation implements OrderItemsService {

    private ordersItemRepository ordersItemRepository;

    public OrderItemsServiceImplementation(ordersItemRepository ordersItemRepository) {
        super();
        this.ordersItemRepository = ordersItemRepository;
    }


    @Override
    public List<order_items> getAllOrderItems() {
        return ordersItemRepository.findAll();
    }

    @Override
    public order_items updateStatus(order_items orderItems) {
        return ordersItemRepository.save(orderItems);
    }
}
