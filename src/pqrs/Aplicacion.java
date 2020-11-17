/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pqrs;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kristtian
 */
public class Aplicacion {
    
    // declarar e inicializar variables para la cadena de conexión        
// declarar e inicializar variables para la cadena de conexión        
String servidor = "localhost";
String dataBase = "pqrs_Program";
String username = "root";
String password = "";

//instanciar objeto de la clase  
public static void pruebaConexion() {
try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("Error, no se ha podido cargar MySQL JDBC Driver");
        }

        try {
// declarar e inicializar variables para la cadena de conexión        
            String url = "jdbc:mysql://localhost/Universidad";
            String username = "root";
            String password = "";
// crear la cadena de conexión        
            Connection connection = DriverManager.getConnection(url, username, password);
// declara objeto statement para almacenar la consulta        
            Statement statement = connection.createStatement();
// se ejecuta  la consulta por medio del statement y se almacena el resultado en un resultset (conjunto de resultados)        
            ResultSet rs = statement.executeQuery("SELECT * FROM Estudiante");
// para recorrer el resultset usualmente se utiliza un ciclo while        
            while (rs.next()) {
                int codigo = rs.getInt("Codigo");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                Date fecha = rs.getDate("Fecha_Ingreso");
                System.out.println(String.format("%d, %s %s, %s", codigo, nombre, apellido, fecha));
            } 
// para finalizar cerrar los objetos creados        
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            System.out.println(ex);
                 }
       

}
    /*public void conexion3() throws SQLException{     
        
        Conexion con = new Conexion(servidor, dataBase, username, password);
// declara objeto statement para almacenar la consulta
            Statement statement = null;
// se ejecuta  la consulta por medio del statement y se almacena el resultado en un resultset (conjunto de resultados)        
            ResultSet rs = statement.executeQuery("SELECT * FROM Persona");
// para recorrer el resultset usualmente se utiliza un ciclo while   
        
        while(rs.next()) {
            int codigo = rs.getInt("idPersona");
            String nombre = rs.getString("Nombre");
            String apellido = rs.getString("Apellido");
            String fecha = rs.getString("Telefono");
            System.out.println(String.format("%s, %s %s, %s", codigo, nombre, apellido, fecha));
            } 
    }*/
}
