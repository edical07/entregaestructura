package com.example.edical.modelo;

/**
 * Modelo de datos que representa un producto popular en la aplicación.
 * Esta clase se utiliza para mapear la información de productos destacados o en tendencia.
 */
public class PopularModelo {
    // Nombre del producto popular
    String nombre;
    // Breve descripción de las características del producto
    String descripcion;
    // Calificación promedio otorgada por los usuarios
    String rating;
    // Información sobre promociones o descuentos aplicables
    String descuento;
    // Clasificación o categoría a la que pertenece el producto
    String tipo;
    // Enlace directo a la imagen del producto alojada en el servidor
    String img_url;

    /**
     * Constructor predeterminado sin argumentos.
     * Es indispensable para que Firebase pueda convertir los datos de la base de datos en este objeto.
     */
    public PopularModelo() {

    }

    /**
     * Constructor completo para inicializar todas las propiedades del producto popular.
     * 
     * @param nombre Nombre del producto.
     * @param descripcion Descripción del producto.
     * @param rating Calificación del producto.
     * @param descuento Descuento disponible.
     * @param tipo Categoría del producto.
     * @param img_url URL de la imagen.
     */
    public PopularModelo(String nombre, String descripcion, String rating, String descuento, String tipo, String img_url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rating = rating;
        this.descuento = descuento;
        this.tipo = tipo;
        this.img_url = img_url;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre almacenado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define o actualiza el nombre del producto.
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     * @return La descripción almacenada.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define o actualiza la descripción del producto.
     * @param descripcion La nueva descripción.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la calificación del producto.
     * @return El rating almacenado.
     */
    public String getRating() {
        return rating;
    }

    /**
     * Define o actualiza la calificación del producto.
     * @param rating El nuevo rating.
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * Obtiene la información del descuento.
     * @return El descuento almacenado.
     */
    public String getDescuento() {
        return descuento;
    }

    /**
     * Define o actualiza el descuento del producto.
     * @param descuento El nuevo descuento.
     */
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    /**
     * Obtiene el tipo o categoría del producto.
     * @return El tipo almacenado.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o actualiza la categoría del producto.
     * @param tipo El nuevo tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la URL de la imagen del producto.
     * @return La URL de la imagen.
     */
    public String getImg_url() {
        return img_url;
    }

    /**
     * Define o actualiza la URL de la imagen del producto.
     * @param img_url La nueva URL.
     */
    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
