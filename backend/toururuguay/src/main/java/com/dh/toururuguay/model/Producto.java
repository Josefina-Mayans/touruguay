package com.dh.toururuguay.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    private String product_name;
    private String description;

    private String address;
    private Integer score;
    private Integer category_id;
    private Integer city_id;

public Producto(){

}

    public Producto(Integer product_id, String product_name, String description, String address, Integer score, Integer category_id, Integer city_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.address = address;
        this.score = score;
        this.category_id = category_id;
        this.city_id = city_id;
    }


//este lo uso para mostrar el producto completo en un listado


public Integer getId() {
    return product_id;
}
// EL ID ME LO DA LA BASE DE DATOS
    public void setId(Integer product_id) {
        this.product_id = product_id;
    }

public String getProduct_name() {return product_name;}
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription () {return description;}
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", category_id=" + category_id +
                ", city_id=" + city_id +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(product_id, producto.getId()) &&
                Objects.equals(product_name, producto.getProduct_name()) &&
                Objects.equals(description, producto.getDescription());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.product_id, this.product_name, this.description);
    }

}