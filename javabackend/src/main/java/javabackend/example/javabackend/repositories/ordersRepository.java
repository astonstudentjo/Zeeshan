package javabackend.example.javabackend.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javabackend.example.javabackend.models.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public interface ordersRepository extends CrudRepository<orders, Integer> {

    List<orders> findAll();
}
