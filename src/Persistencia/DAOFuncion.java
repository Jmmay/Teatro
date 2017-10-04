/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.FuncionTeatral;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class DAOFuncion extends DAOGeneral<FuncionTeatral> {

    public Connection conexion;

    public DAOFuncion() {
    }
      
    public int agregar(FuncionTeatral funcion) throws SQLException {
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "INSERT INTO \"funciont\"(titulo,estado,hora,pdimante,id_obra) VALUES ('"
                + funcion.getTituloFuncion()+ "','" 
                + funcion.getEstadoFuncion()+ "','" 
                + funcion.getHoraFuncion()+ "'," 
                + funcion.getPrecioDiamanteFuncion()+"," 
                + funcion.getId_obra()+")";

        Statement sentencia = conexion.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(conexion);
        return numFilas;
    }

    public int eliminar(String condicion) throws SQLException {
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "DELETE FROM \"funciones\" WHERE " + condicion;

        Statement sentencia = conec.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(conec);
        return numFilas;
    }
    
    public int modificar(FuncionTeatral funcionTeatro, String condicion) throws SQLException {
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "UPDATE \"funciones\" SET "
                + " estado='" + funcionTeatro.getEstadoFuncion()+ "',"
                + " hora='" + funcionTeatro.getHoraFuncion()+ "', " + "pdiamante=" + funcionTeatro.getPrecioDiamanteFuncion()+ "," + "id_obra=" + funcionTeatro.getId_obra()+","+"fecha='"+funcionTeatro.getFechaFuncion()+"'"
                + " WHERE " + condicion;

        Statement sentencia = conec.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(conec);
        return numFilas;
    }
    
    public ArrayList<FuncionTeatral> consultar(String condicion) throws SQLException {
        ArrayList<FuncionTeatral> lista = new ArrayList<FuncionTeatral>();
        FuncionTeatral funcionTeatro;
        Connection conexion = getConeccion();
        String orden = "SELECT * FROM funciones WHERE titulo=" + condicion + "";
        Statement sentencia = conexion.createStatement();
        ResultSet resulta = sentencia.executeQuery(orden);
        while (resulta.next()) {
            funcionTeatro = new FuncionTeatral(resulta.getString("titulo"),resulta.getString("fecha"),resulta.getString("hora"), resulta.getInt("pdiamante"), resulta.getString("estado"));
            lista.add(funcionTeatro);
            sentencia.close();
            cerrarConeccion(conexion);
            return lista;
        }
        return null;
          
      }

    public ArrayList<FuncionTeatral> consultarTodos() throws SQLException {
        ArrayList<FuncionTeatral> lista = new ArrayList<FuncionTeatral>();
        FuncionTeatral funcionTeatro;
        Connection conexion = getConeccion();

        String orden = "SELECT * FROM funciones ";
        Statement sentencia = conexion.createStatement();
        ResultSet resulta = sentencia.executeQuery(orden);

        while (resulta.next()) {
            funcionTeatro = new FuncionTeatral(resulta.getString("titulo"),resulta.getString("fecha"),resulta.getString("hora"), resulta.getInt("pdiamante"), resulta.getString("estado"));
            lista.add(funcionTeatro);
            System.out.println(funcionTeatro);
        }
        sentencia.close();
        cerrarConeccion(conexion);

        return lista;

    }
        
}
