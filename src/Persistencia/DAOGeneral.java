/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *Conexion entre postgresql y Netbeans
 * @author User
 */

    
    public abstract class DAOGeneral<T> {

    private String host="localhost";
    private String bd="Teatro";
    private String login="postgres";
    private String password="may1234";
    private boolean cargadoDriver;
/**
 *constructor del DAO
 */
    public DAOGeneral() {
        cargarDriver();
   }
/**
 * Carga el driver
 */
    public void cargarDriver(){
        try {
            if ( !cargadoDriver ) {
                Class.forName("org.postgresql.Driver");
                cargadoDriver = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/**
 * Establece la conexion
 * @param host
 * @param bd
 * @param login
 * @param password
 * @return 
 */
     public Connection getConeccion(String host, String bd, String login, String password){
        Connection conexion=null;
        String urlConexion = "jdbc:postgresql://"+ host +"/" + bd;
        try {
            conexion=DriverManager.getConnection(urlConexion, login, password);
        }catch (SQLException e) { e.printStackTrace(); }
        return conexion;
    }

     public Connection getConeccion(){
        return getConeccion(host, bd, login, password );
    }
/**
 * Cierra la conexion
 * @param con 
 */
    public void cerrarConeccion(Connection con){
        try {
            if ( con != null )
                if ( !con.isClosed() )    // Si no esta cerrada, se cierra
                    con.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }


    public abstract int agregar(T entidad)throws SQLException;

    public abstract int eliminar(String condicion)throws SQLException;

    public abstract int modificar(T entidad, String condicion)throws SQLException;

    public abstract ArrayList<T> consultar(String condicion)throws SQLException;

      public String getHost() {
        return host;
    }

    public String getBd() {
        return bd;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isCargadoDriver() {
        return cargadoDriver;
    }
    
}
