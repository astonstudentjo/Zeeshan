package javabackend.example.javabackend.repositories;

import org.springframework.data.repository.CrudRepository;

import javabackend.example.javabackend.models.*;

public interface UsersRepository extends CrudRepository<users, Integer> {

}
