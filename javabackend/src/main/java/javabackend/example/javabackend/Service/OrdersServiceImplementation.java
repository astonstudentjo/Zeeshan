package javabackend.example.javabackend.Service;

import javabackend.example.javabackend.models.orders;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class OrdersServiceImplementation implements OrdersService{

    private javabackend.example.javabackend.repositories.OrdersRepository OrdersRepository;

    public OrdersServiceImplementation(javabackend.example.javabackend.repositories.OrdersRepository ordersRepository){
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
