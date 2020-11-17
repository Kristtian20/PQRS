/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pqrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {
 
    private Connection conexion=null;
    private String servidor="";
    private String dataBase="";
    private String usuario="";
    private String password="";
    private String url="";

    public Connection Conectar (String servidor, String dataBase, String usuario, String password){
        try {
 
            this.servidor = servidor;
            this.dataBase = dataBase;
 
            Class.forName("com.mysql.jdbc.Driver");
           
 	    url="jdbc:mysql://"+servidor+"/"+dataBase;
            conexion =DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");
 
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return conexion;
    }
 
    public Connection getConexion(){
        return conexion;
    }
 
    public Connection cerrarConexion(){
        try {
            conexion.close();
             System.out.println("Cerrando conexion a "+url+" . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion=null;
        return conexion;
    }

    /*public Statement createStatement()throws SQLException{
        
        Statement s = conexion.createStatement();
        return s;
    }*/
    
}
