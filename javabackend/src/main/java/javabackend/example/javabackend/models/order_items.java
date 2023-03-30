package javabackend.example.javabackend.models;

import jakarta.persistence.*;


@Entity
@Table(name = "order_items")
public class order_items {
    private final String name;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private float price;

    public order_items(int i, int i1, String s, int i2, float v) {
        this.id = i;
        this.product_id =i1;
        this.name = s;
        this.price = i2;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}


