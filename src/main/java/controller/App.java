package controller;

import dao.ArticuloDAO;
import model.Articulo;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        Articulo art = new Articulo(2, "Producto de prueba 3", 1500, 35);
        ArticuloDAO dao = new ArticuloDAO();

        dao.crearArticulo(art);
        dao.listarArticulos();
        */
        Scanner sc = new Scanner(System.in);
        String menu = """
                Bienvenido al sistema de alta, baja y modificación de articulos informáticos
                
                Seleccione a continuación la opción de la operación que desea realizar:
                
                * Agregar un articulo: 1
                * Listar los articulos existentes: 2
                * Eliminar un articulo: 3
                * Agregar stock a un articulo existente: 4
                * Actualizar precio de un articulo existente: 5
                * Salir: 0
                
                Opcion: 
                """;
        int opc;
        do{
            System.out.println(menu);
            opc = sc.nextInt();
            switch(opc){
                case 0:
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    System.out.println("""
                            A continuación ingrese los datos del articulo que desea ingresar
                            """);
                    System.out.println("Codigo de Articulo: ");
                    int codigoArticulo = sc.nextInt();
                    System.out.println("Descripción: ");
                    String descripcion = sc.next();
                    System.out.println("Precio de Venta: ");
                    double precioVenta = sc.nextDouble();
                    System.out.println("Stock");
                    int stock = sc.nextInt();
                    Articulo articulo = new Articulo(codigoArticulo, descripcion, precioVenta, stock);
                    ArticuloDAO artDAO = new ArticuloDAO();
                    artDAO.crearArticulo(articulo);
                    System.out.println(menu);
                    opc = sc.nextInt();
                    break;
                case 2:
                    ArticuloDAO artDAO2 = new ArticuloDAO();
                    artDAO2.listarArticulos();
                    break;
                case 3:
                    ArticuloDAO artDAO3 = new ArticuloDAO();
                    System.out.println("Ingrese el codigo de articulo que desea eliminar");
                    int codArticulo_eliminar = sc.nextInt();
                    artDAO3.eliminarArticulo(codArticulo_eliminar);
                    break;
                case 4:
                    ArticuloDAO artDAO4 = new ArticuloDAO();
                    System.out.println("Ingrese el codigo de articulo que desea modificar su stock: ");
                    int codArticulo_stock = sc.nextInt();
                    System.out.println("Ingrese el nuevo stock del articulo: ");
                    int nuevoStock = sc.nextInt();
                    artDAO4.agregarStock(codArticulo_stock,nuevoStock);
                    break;
                case 5:
                    ArticuloDAO artDAO5 = new ArticuloDAO();
                    System.out.println("Ingrese el código de articulo que desea modificar su precio: ");
                    int codArticulo_precio = sc.nextInt();
                    System.out.println("Ingrese el nuevo precio del articulo: ");
                    double precioNuevo = sc.nextDouble();
                    artDAO5.actualizarPrecio(codArticulo_precio, precioNuevo);
                    break;
                default:
                    System.out.println("Opción incorrecta, ingrese una opción válida");
                    break;
            }
        }while(opc != 0);



    }
}
