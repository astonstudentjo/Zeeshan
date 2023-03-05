package javabackend.example.javabackend.repositories;

import org.springframework.data.repository.CrudRepository;
import javabackend.example.javabackend.models.*;
import java.util.List;
public interface ordersRepository extends CrudRepository<orders, Long> {
    List<orders> findAll();

}
