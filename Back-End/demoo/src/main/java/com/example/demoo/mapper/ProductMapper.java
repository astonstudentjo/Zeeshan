package com.example.demoo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demoo.model.Product;
//this is the mapper
@Mapper
public interface ProductMapper {

    @Select("select * from products")
    List<Product> findAll();

    @Insert("insert into users(id, name, description, img, price, stock, sales, category, artist) values(#{id}, #{name}, #{description}, #{img}, #{price}, #{stock}, #{sales}, #{category}, #{artist} )")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Users users);
}
