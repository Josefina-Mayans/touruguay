package com.dh.toururuguay.model;

public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String urlImagen;
public Producto(){

}

public Producto(String nombre, String descripcion, String urlImagen){
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.urlImagen = urlImagen;
}

//este lo uso para mostrar el producto completo en un listado
    public Producto(Integer id, String nombre, String descripcion, String urlImagen){
    this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

public Integer getId() {
    return id;
}
// EL ID ME LO DA LA BASE DE DATOS
    public void setId(Integer id) {
        this.id = id;
    }

public String getNombre() {return nombre;}
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion () {return descripcion;}
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen(){return urlImagen;}

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public java.lang.String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", urlImagen='" + urlImagen + '\'';
    }
}