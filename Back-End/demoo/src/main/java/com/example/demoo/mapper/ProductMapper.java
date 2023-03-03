package com.example.demoo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demoo.model.Product;
//this is the mapper
@Mapper
public interface ProductMapper {

    @Select("select * from products")
    List<Product> findAll();
}
