package javabackend.example.javabackend.repositories;

import javabackend.example.javabackend.models.orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface OrdersRepository extends CrudRepository<orders, Integer> {

    List<orders> findAll();
}
