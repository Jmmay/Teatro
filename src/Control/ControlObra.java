/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ObraTeatral;
import Persistencia.DAOObra;
import Vista.VistaObrasTeatrales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class ControlObra implements ActionListener {
    
    private VistaObrasTeatrales vobrasteatrales;
    private ObraTeatral obrateatral;
    
    public ControlObra(ObraTeatral obraTeatro, VistaObrasTeatrales vistaObra) {
        this.obrateatral = obraTeatro;
        this.vobrasteatrales = vistaObra;
        this.vobrasteatrales = new VistaObrasTeatrales();
        this.vobrasteatrales.JbBorrar.addActionListener(this);
         this.vobrasteatrales.jBAgregar.addActionListener(this);
        this.vobrasteatrales.jBBuscar.addActionListener(this);
        this.vobrasteatrales.jCObras.addActionListener(this);
        this.vobrasteatrales.jTDirector.addActionListener(this);
        this.vobrasteatrales.jTEmail.addActionListener(this);
        this.vobrasteatrales.jTTelefono.addActionListener(this);
        this.vobrasteatrales.jTdescripcion.addActionListener(this);
        this.vobrasteatrales.jTpersonajeprincipal.addActionListener(this);
        this.vobrasteatrales.jTTitulo.addActionListener(this);
        this.vobrasteatrales.setVisible(true);
    }
    public void iniciar() {
        vobrasteatrales.setVisible(true);
        vobrasteatrales.setLocationRelativeTo(null);
        vobrasteatrales.setResizable(false);
    }  
    public void actionPerformed(ActionEvent evento) {
        if (vobrasteatrales.jBAgregar == evento.getSource()) {
            agregarObra();
            limpiarVista();
            llenarObras();
        } else if (vobrasteatrales.JbBorrar == evento.getSource()) {
            eliminarObra();
            limpiarVista();
        } else if (vobrasteatrales.jBBuscar == evento.getSource()) {
            consultarObra();
        }
    }
    public void limpiarVista() {
        vobrasteatrales.jTTitulo.setText("");
        vobrasteatrales.jTEmail.setText("");
        vobrasteatrales.jTDirector.setText("");
        vobrasteatrales.jTTelefono.setText("");
        vobrasteatrales.jTdescripcion.setText("");
        vobrasteatrales.jTpersonajeprincipal.setText("");
    }  
    public void agregarObra() {
        ObraTeatral obraTeatro = new ObraTeatral(vobrasteatrales.jTTitulo.getText(),
                vobrasteatrales.jTdescripcion.getText(),
                vobrasteatrales.jTpersonajeprincipal.getText(),
                vobrasteatrales.jTDirector.getText(),
                vobrasteatrales.jTTelefono.getText(),
                vobrasteatrales.jTEmail.getText());

        //Agregando a la base de datos
        DAOObra daoobra = new DAOObra();
        try {
            daoobra.agregar(obraTeatro);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } 
    public void eliminarObra() {
        String cad = "titulo= " + vobrasteatrales.jTTitulo.getText();

        //Eliminando de la base de datos
        DAOObra daoFuncion = new DAOObra();
        try {
            daoFuncion.eliminar(cad);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }  
    public void consultarObra() {
        String condicion = "titulo= " + vobrasteatrales.jTTitulo.getText();

        DAOObra daoFuncion = new DAOObra();
        try {
            ArrayList<ObraTeatral> listafunciones = new ArrayList<ObraTeatral>();
            listafunciones = daoFuncion.consultar(condicion);
            vobrasteatrales.jTdescripcion.setText(listafunciones.get(0).getDescripcionObra());
            vobrasteatrales.jTpersonajeprincipal.setText(listafunciones.get(0).getPersonajeprincipalObra());
            vobrasteatrales.jTDirector.setText(listafunciones.get(0).getDirectorObra());
            vobrasteatrales.jTTelefono.setText(listafunciones.get(0).getTelDirectorObra());
            vobrasteatrales.jTEmail.setText(listafunciones.get(0).getEmailDirectorObra());

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
     public void modificarFuncion() {
        String condicion = "titulo= " + vobrasteatrales.jTTitulo.getText();
         ObraTeatral obraTeatro = new ObraTeatral(vobrasteatrales.jTdescripcion.getText(),
                vobrasteatrales.jTpersonajeprincipal.getText(),
                vobrasteatrales.jTDirector.getText(),
                vobrasteatrales.jTTelefono.getText(),
                vobrasteatrales.jTEmail.getText());
        //Moficanado a la base de datos
        DAOObra daoObra = new DAOObra();
        try {
            daoObra.modificar(obraTeatro, condicion);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   
      public void llenarObras() {
        int i;
        vobrasteatrales.jCObras.removeAllItems();
        DAOObra daoObra = new DAOObra();
        try {
            ArrayList<ObraTeatral> listafunciones = new ArrayList<ObraTeatral>();
            listafunciones = daoObra.consultarTodos();
            System.out.println(listafunciones.size());
            for (i = 0; i < listafunciones.size(); i++) {
                vobrasteatrales.jCObras.addItem(listafunciones.get(i).getTituloObra());
                System.out.println(listafunciones.get(i).getTituloObra());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }  
}
