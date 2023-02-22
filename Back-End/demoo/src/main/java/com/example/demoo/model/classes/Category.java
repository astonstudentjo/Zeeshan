package main.java.com.example.demoo.model.classes;
public enum Category {
     pop, rap, rock, metal, country;
     @Override
     public String toString()
     {
          return this.getClass().toString();
     }
}
