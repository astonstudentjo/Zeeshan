package javabackend.example.javabackend.Service;

import javabackend.example.javabackend.models.orders;
import javabackend.example.javabackend.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrdersServiceImplementation implements OrdersService{

    private OrdersRepository ordersRepository;

    public OrdersServiceImplementation(OrdersRepository ordersRepository){
        super();
        this.ordersRepository = ordersRepository;
    }


    @Override
    public List<orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @Override
    public orders saveOrder(orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void deleteOrdersById(Integer id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public orders getOrdersById(Integer id) {
        return ordersRepository.findById(id).get();
    }

    @Override
    public orders updateOrders(orders orders) {
        return ordersRepository.save(orders);
    }
}
