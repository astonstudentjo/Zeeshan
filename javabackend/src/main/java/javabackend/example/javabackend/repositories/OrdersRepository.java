package javabackend.example.javabackend.repositories;

import org.springframework.data.repository.CrudRepository;
import javabackend.example.javabackend.models.*;

import java.util.List;
public interface OrdersRepository extends CrudRepository<orders, Integer> {

    List<orders> findAll();
}
