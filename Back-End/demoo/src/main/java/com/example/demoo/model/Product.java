package com.example.demoo.model;

public class Products {
    

    //fields
    private int id;
    private String name;
    private String description;
    private Image img; 
    private float price;
    private int stock;
    private int sales;
    private String category;
    private String artist;
//private blob img;  // we need to find out what type this is.
    //`id`,`name`,`description`,`img`,`price`,`stock`,`sales`,`category`,`artist`


public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}



public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}


public String getImgPath() {
    return img.getUrl();
}

public void setImg (String artist) {
    this.img = new Image(artist);
}

public float getPrice() {
    return price;
}

public void setPrice (float price) {
    this.price = price;
}



public int getStock() {
    return stock;
}

public void setStock (int stock) {
    this.stock = stock;
}

public int getsales() {
    return sales;   
} 
    
public void setsales(int sales) {
    this.sales = sales;
}                       
    
public String getcategory () {
    return category;
} 
    
public void setcategory(String category) {
    this.category= category;
} 
    
public String getartist () {
    return artist;
} 
public void setartist(String artist) {
    this.artist= artist;
} 
}
