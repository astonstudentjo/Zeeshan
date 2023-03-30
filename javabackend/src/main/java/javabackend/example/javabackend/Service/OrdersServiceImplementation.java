package javabackend.example.javabackend.Service;

import javabackend.example.javabackend.models.orders;

import java.util.List;

import org.springframework.stereotype.Service;
import javabackend.example.javabackend.models.orders;
import javabackend.example.javabackend.repositories.ordersRepository;


@Service
public class OrdersServiceImplementation implements OrdersService{

    private ordersRepository OrdersRepository;

    public OrdersServiceImplementation(ordersRepository ordersRepository){
        super();
        this.OrdersRepository = ordersRepository;
    }


    @Override
    public List<orders> getAllOrders() {
        return OrdersRepository.findAll();
    }

    @Override
    public orders saveOrder(orders orders) {
        return OrdersRepository.save(orders);
    }

    @Override
    public void deleteOrdersById(Integer id) {
        OrdersRepository.deleteById(id);
    }

    @Override
    public orders getOrdersById(Integer id) {
        return OrdersRepository.findById(id).get();
    }

    @Override
    public orders updateOrders(orders orders) {
        return OrdersRepository.save(orders);
    }
}
