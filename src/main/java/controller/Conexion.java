package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static Connection con = null;
    static String url = "jdbc:mysql://localhost:3306/tienda_informatica";
    static String user = "root";
    static String password = "root";
    public static Connection conectar(){
        try{
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Exitosa");
        }catch(Exception e){
            System.out.println("Conexión Fallida");
            System.out.println(e.getMessage());
        }
        return con;
    }
}
