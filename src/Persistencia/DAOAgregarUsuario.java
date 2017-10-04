/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *Conexion entre la base de datos y el usuario
 * @author User
 */


    
    public class DAOAgregarUsuario extends DAOGeneral<Usuario>{
    /** Creates a new instance of DAOProblema */
    /**
     * Genera el Dao
     */
    public DAOAgregarUsuario() {
        
    }
/**
 * Agrega un usuario a la Base de Datos  recibido en parametro 
 * @param e
 * @return
 * @throws SQLException 
 */
    public int agregar(Usuario usuario) throws SQLException {
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "INSERT INTO \"usuarios\"(nombre,pasword) VALUES ('" +
            usuario.getNombre() + "', '" + usuario.getPasword()+"')" ;

        Statement sentencia = conec.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(conec);
        return numFilas;
    }
/**
 * Elimina un usuario en la base de datos
 * @param condicion
 * @return
 * @throws SQLException 
 */
    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "DELETE FROM \"usuarios\" WHERE "+condicion;

        Statement sentencia = conec.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(conec);
        return numFilas;
    }
/**
 * Modifica un usuario en la base de datos
 * @param e
 * @param condicion
 * @return
 * @throws SQLException 
 */
    public int modificar(Usuario usuario, String condicion)throws SQLException {
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "UPDATE \"usuarios\" SET " +
                " nombre='"+usuario.getNombre()+"',"+
                " pasword="+usuario.getPasword()+", "+
                " WHERE "+condicion;

        Statement sentencia = conec.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(conec);
        return numFilas;
    }
/**
 * Consulta un usuario apartir de una condicion 
 * @param condicion
 * @return
 * @throws SQLException 
 */
    public ArrayList<Usuario> consultar(String condicion) throws SQLException{
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        Usuario usuario;
        Connection conec = getConeccion();
        String orden = "SELECT * FROM \"usuarios\" " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = conec.createStatement();
        ResultSet resulta = sentencia.executeQuery( orden );

        while (resulta.next()) {
            usuario = new Usuario(resulta.getString("nombre"),resulta.getString("pasword"));
            lista.add( usuario );
        }
        sentencia.close();
        cerrarConeccion(conec);
        return lista;
    }
}