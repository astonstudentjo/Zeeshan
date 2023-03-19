package javabackend.example.javabackend.repositories;

import javabackend.example.javabackend.models.order_items;
import javabackend.example.javabackend.models.orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ordersItemRepository extends JpaRepository<order_items, Integer> {
    List<order_items> findAll();

}
