package dao;

import model.Articulo;

public interface IArticuloDAO {

    void crearArticulo(Articulo articulo);
    void eliminarArticulo(int codArticulo);
    void agregarStock(int codArticulo ,int stock);
    void actualizarPrecio(int codArticulo,double precioNuevo);
    void listarArticulos();
}
