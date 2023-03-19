package javabackend.example.javabackend.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javabackend.example.javabackend.models.orders;
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

//    @Override
//    public List<order_items> getOrderItems(Long orderId) {
//        Optional<order_items> orderOptional = orderRepository.findById(orderId);
//        if (orderOptional.isPresent()) {
//            orders order = orderOptional.get();
//            return order.getOrderItems();
//        }
//        return Collections.emptyList();
//    }

}
