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
    private long price;


    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
