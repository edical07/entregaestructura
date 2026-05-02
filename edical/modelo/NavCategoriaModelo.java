package com.example.edical.modelo;

public class NavCategoriaModelo {
    String nombre;
    String descripcion;
    String img_url;
    String descuento;

    public NavCategoriaModelo() {
    }

    public NavCategoriaModelo(String nombre, String descripcion, String img_url, String descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img_url = img_url;
        this.descuento = descuento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
}
