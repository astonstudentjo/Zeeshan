package javabackend.example.javabackend.models;
import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
public class ordersItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Long price;

//    getters

    public Long getId() {
        return id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Long getPrice() {
        return price;
    }

//    setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
