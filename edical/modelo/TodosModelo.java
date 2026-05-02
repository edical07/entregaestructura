package com.example.edical.modelo;

/**
 * Modelo de datos que representa un producto o ítem general en la aplicación.
 * Utilizado para mapear los datos provenientes de Firebase Firestore o Realtime Database.
 */
public class TodosModelo {
    // Nombre del producto
    String nombre;
    // Descripción detallada del producto
    String descripcion;
    // Calificación o rating (ej. "4.5")
    String rating;
    // URL de la imagen almacenada en la nube
    String img_url;
    // Categoría o tipo de producto
    String tipo;
    // Precio unitario del producto
    int precio;

    /**
     * Constructor vacío requerido por Firebase para la deserialización de objetos.
     */
    public TodosModelo() {
    }

    /**
     * Constructor con parámetros para inicializar un objeto TodosModelo.
     */
    public TodosModelo(String nombre, String descripcion, String rating, String img_url, String tipo, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rating = rating;
        this.img_url = img_url;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Métodos Getter y Setter para acceder y modificar los atributos de la clase

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
