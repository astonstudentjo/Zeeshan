package javabackend.example.javabackend.models;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column (name = "img")
    private String img;

    @Column(name = "price")
    private Float price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "artist")
    private String artist;

    @Column(name = "category")
    private String category;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setImg(String img){
        this.img = img;
    }

    public String getImg(){
        return img;
    }


    public void setPrice(Float price){
        this.price = price;
    }

    public Float getPrice(){
        return price;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getArtist(){
        return artist;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setStock(Integer stock){
        this.stock = stock;
    }

    public Integer getStock(){
        return stock;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }



    


    
}
