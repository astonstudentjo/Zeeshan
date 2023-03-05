package javabackend.example.javabackend;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class ordersModel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

//    Variables from Orders Table
    private Integer id;

    private Integer user_id;

    private double total_price;

    private Timestamp created_at;

    private Timestamp updated_at;

    private String status;

//    Getters

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public double getTotal_price(){
        return total_price;
    }

    public Timestamp getCreated_at(){
        return  created_at;
    }

    public Timestamp getUpdated_at(){
        return  updated_at;
    }

    public String getStatus(){
        return status;
    }

//    Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setTotal_price(double total_price){
        this.total_price = total_price;
    }

    public void setCreated_at(Timestamp created_at){
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at){
        this.updated_at = updated_at;
    }





}

