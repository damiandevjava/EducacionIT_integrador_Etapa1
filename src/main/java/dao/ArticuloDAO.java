package dao;

import controller.Conexion;
import model.Articulo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticuloDAO implements IArticuloDAO {

    @Override
    public void crearArticulo(Articulo articulo) {
        Connection con = null;
        try{
            con = Conexion.conectar();
            con.setAutoCommit(false);
            String query = "INSERT INTO ARTICULO(codArticulo, descripcion, precioVenta, stock) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,articulo.getCodigo());
            ps.setString(2, articulo.getDescripcion());
            ps.setDouble(3, articulo.getPrecio_Venta());
            ps.setInt(4,articulo.getStock());

            ps.execute();
            System.out.println("Datos preparados para insertar");
            con.commit();
            System.out.println("Articulo insertado");
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            try{
                con.rollback();
                System.out.println("Se realiza rollback");
            }catch (SQLException e2){
                e2.getMessage();
                System.out.println("No se pudo realizar el rollback");
            }
        }
    }

    @Override
    public void eliminarArticulo(int codArticulo) {
        Connection con = null;
        try{
            con = Conexion.conectar();
            con.setAutoCommit(false);
            String query = "DELETE FROM articulo WHERE codArticulo = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codArticulo);
            int rowsAffected = ps.executeUpdate();
            con.commit();
            if (rowsAffected > 0)
                System.out.println("Articulo Eliminado");
            else
                System.out.println("No existe tal articulo");
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error, no pudo eliminarse");
            try{
                con.rollback();
                System.out.println("Se realiza rollback");
                con.close();
            }catch (SQLException e2){
                e2.getMessage();
                System.out.println("No se pudo realizar el rollback");
            }
        }
    }

    @Override
    public void agregarStock(int codArticulo,int suma) {
        Connection con = null;
        try{
            con = Conexion.conectar();
            con.setAutoCommit(false);

            String query = "UPDATE articulo SET stock = stock + ? WHERE codArticulo = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, suma);
            ps.setInt(2, codArticulo);
            int rowsAffected = ps.executeUpdate();
            con.commit();
            if(rowsAffected > 0)
                System.out.println("Stock del articulo modificado");
            else
                System.out.println("El articulo no existe");
        }catch(Exception e){
            System.out.println("No pudo modificarse el stock");
            System.out.println(e.getMessage());
            try{
                System.out.println("Se realizará rollback");
                con.rollback();
            }catch(SQLException e2){
                System.out.println("No se pudo realizar rollback");
                System.out.println(e2.getMessage());
            }
        }
    }

    @Override
    public void actualizarPrecio(int codArticulo,double precioNuevo) {
        Connection con = null;
        try{
            con = Conexion.conectar();
            con.setAutoCommit(false);

            String query = "UPDATE articulo SET precioVenta = ? WHERE codArticulo = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDouble(1, precioNuevo);
            ps.setInt(2, codArticulo);
            int rowsAffected = ps.executeUpdate();
            con.commit();
            if(rowsAffected > 0)
                System.out.println("Precio del articulo modificado");
            else
                System.out.println("El articulo no existe");
        }catch(Exception e){
            System.out.println("No pudo modificarse el precio del articulo");
            System.out.println(e.getMessage());
            try{
                System.out.println("Se realizará rollback");
                con.rollback();
            }catch(SQLException e2){
                System.out.println("No se pudo realizar rollback");
                System.out.println(e2.getMessage());
            }
        }
    }

    @Override
    public void listarArticulos() {
        Connection con = null;
        ArrayList<Articulo> listadoArticulos = new ArrayList<>();

        try{
            con = Conexion.conectar();
            con.setAutoCommit(false);

            String query = "SELECT * FROM ARTICULO";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet resultado = ps.executeQuery();

            while(resultado.next()){
                int codArticulo = resultado.getInt("codArticulo");
                String descripcion = resultado.getString("descripcion");
                double precioVenta = resultado.getDouble("precioVenta");
                int stock = resultado.getInt("stock");
                Articulo articulo = new Articulo(codArticulo, descripcion, precioVenta,stock);
                listadoArticulos.add(articulo);
            }

            for(Articulo art: listadoArticulos){
                System.out.println(art);
            }

            con.commit();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Error al listar, se realizará rollback");
            try{
                con.rollback();
            }catch (SQLException e2){
                System.out.println(e2.getMessage());
                System.out.println("Error en el rollback");
            }
        }
    }
}
