package model;

public class Articulo {
    public int codigo;
    public String descripcion;
    public double precio_Venta;
    public int stock;

    public Articulo() {
    }

    public Articulo(int codigo, String descripcion, double precio_Venta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio_Venta = precio_Venta;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio_Venta() {
        return precio_Venta;
    }

    public void setPrecio_Venta(double precio_Venta) {
        this.precio_Venta = precio_Venta;
    }

    @Override
    public String toString() {
        return "\nDatos del Articulo" +
                "\ncodigo = " + codigo +
                "\ndescripcion = " + descripcion +
                "\nprecio de Venta = " + precio_Venta +
                "\nstock = " + stock +
                "\n-------------------------------------";
    }
}
