package com.example.demoo.resource;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demoo.model.Product;

@MappedTypes(Product.class)
@MapperScan("com.example.demoo.DemooApplication")
@SpringBootApplication
public class DemooApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemooApplication.class, args);
	}

}

