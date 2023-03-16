package javabackend.example.javabackend.models;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class orders {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

//    Variables from Orders Table
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "total_price")
    private float total_price;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;


    @Column(name = "status")
    private String status;

//    Getters

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public float getTotal_price(){
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

    public void setTotal_price(float total_price){
        this.total_price = total_price;
    }

    public void setCreated_at(Timestamp created_at){
        this.created_at = created_at;
    }

    public void setUpdated_at(Timestamp updated_at){
        this.updated_at = updated_at;
    }

    public void setStatus(String status){ this.status = status; }

}

