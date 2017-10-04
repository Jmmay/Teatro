/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.ObraTeatral;
import java.sql.*;

import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class DAOObra extends DAOGeneral<ObraTeatral> {
    public Connection con;

    public DAOObra() {
    }
    
    
    
     public int agregar(ObraTeatral obra) throws SQLException {
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "INSERT INTO \"obra\"(titulo,descripcion,personaje,director,telefono,email) VALUES ('"
                + obra.getTituloObra() 
                + "', '" + obra.getDescripcionObra()
                + "', '" + obra.getPersonajeprincipalObra()
                + "', '" + obra.getDirectorObra()
                + "', '" + obra.getDescripcionObra()
                + "', '" + obra.getEmailDirectorObra() + "')";

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion) throws SQLException {
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "DELETE FROM \"obra\" WHERE " + condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }
    
    public int modificar(ObraTeatral obraTeatro, String condicion) throws SQLException {
        int numFilas = 0;
        Connection conec = getConeccion();

        String orden = "UPDATE \"obra\" SET "
                + " descripcion='" + obraTeatro.getDescripcionObra()+ "',"
                + " director=" + obraTeatro.getDirectorObra()+ ", " + "personaje=" + obraTeatro.getPersonajeprincipalObra()+ ""
                + " WHERE " + condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }
    
    public ArrayList<ObraTeatral> consultar(String condicion) throws SQLException {
        ArrayList<ObraTeatral> lista = new ArrayList<ObraTeatral>();
        ObraTeatral obraTeatro;
        Connection conexion = getConeccion();
        String orden = "SELECT * FROM obra WHERE titulo='" + condicion + "'";
        Statement sentencia = conexion.createStatement();
        ResultSet resulta = sentencia.executeQuery(orden);

        while (resulta.next()) {
            obraTeatro = new ObraTeatral(resulta.getInt("id_obra"),resulta.getString("titulo"), resulta.getString("descripcion"), resulta.getString("personaje"), resulta.getString("director"),resulta.getString("telefono"),resulta.getString("email"));
            lista.add(obraTeatro);
            sentencia.close();
            cerrarConeccion(conexion);
            return lista;
        }
        return null;
      }

    public ArrayList<ObraTeatral> consultarTodos() throws SQLException {
        ArrayList<ObraTeatral> lista = new ArrayList<ObraTeatral>();
        ObraTeatral obraTeatro;
        Connection conexion = getConeccion();

        String orden = "SELECT * FROM obra ";
        Statement sentencia = conexion.createStatement();
        ResultSet resulta = sentencia.executeQuery(orden);

        while (resulta.next()) {
            obraTeatro = new ObraTeatral(resulta.getString("titulo"), resulta.getString("descripcion"), resulta.getString("personaje"), resulta.getString("director"),resulta.getString("telefono"),resulta.getString("email"));
            lista.add(obraTeatro);
            System.out.println(obraTeatro);
        }
        sentencia.close();
        cerrarConeccion(conexion);
        return lista;
    }
}
