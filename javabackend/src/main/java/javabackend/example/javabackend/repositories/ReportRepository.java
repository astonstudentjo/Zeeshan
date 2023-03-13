package javabackend.example.javabackend.repositories;

import javabackend.example.javabackend.models.orders;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<orders, Integer> {
//    public void generateReport();
}
