/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.FuncionTeatral;
import Modelo.ObraTeatral;
import Persistencia.DAOFuncion;
import Persistencia.DAOObra;
import Vista.VistaFunciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class ControlFuncion implements ActionListener {

    private VistaFunciones vistaFuncion;//vista
    private FuncionTeatral funcionTeatro;//f
    
    
    public ControlFuncion(FuncionTeatral funcionTeatral, VistaFunciones vistaFunciones) {
        this.funcionTeatro= funcionTeatral;
        this.vistaFuncion = vistaFunciones;
        this.vistaFuncion = new VistaFunciones();
        this.vistaFuncion.jBAgregar.addActionListener(this);
        this.vistaFuncion.jBBuscar.addActionListener(this);
        this.vistaFuncion.jBEliminar.addActionListener(this);
        this.vistaFuncion.jButton1.addActionListener(this);
        this.vistaFuncion.jCFunciones.addActionListener(this);
        this.vistaFuncion.jTPDiamante.addActionListener(this);
        this.vistaFuncion.jTHorario.addActionListener(this);
        this.vistaFuncion.jTTitulo.addActionListener(this);
        this.vistaFuncion.jCEstado.addActionListener(this);
        this.vistaFuncion.setVisible(true);
    }

    public void iniciar() {
        vistaFuncion.setVisible(true);
        vistaFuncion.setLocationRelativeTo(null);
        vistaFuncion.setResizable(false);
    }
  
    public void actionPerformed(ActionEvent evento) {
        if (vistaFuncion.jBAgregar == evento.getSource()) {
            agregarFuncion();
            limpiarVista();
            llenarObras();
        } else if (vistaFuncion.jBEliminar == evento.getSource()) {
            eliminarFuncion();
            limpiarVista();
        } else if (vistaFuncion.jBBuscar == evento.getSource()) {
            consultarFuncion();

        }else if(vistaFuncion.jButton1== evento.getSource()){
         String condicion = String.valueOf(vistaFuncion.jCFunciones.getSelectedItem());   
            System.out.println(condicion);
            llenarSeleccion(condicion);
        }
    }
    public void limpiarVista() {
        vistaFuncion.jTTitulo.setText("");
        vistaFuncion.jTHorario.setText("");
        vistaFuncion.jTPDiamante.setText("");      
    }
    public void agregarFuncion() {
        FuncionTeatral funcionTeatral = new FuncionTeatral(Integer.parseInt(vistaFuncion.jTId_Obra.getText()),
                vistaFuncion.jTTitulo.getText(),
                String.valueOf(vistaFuncion.jDate.getDate()),
                vistaFuncion.jTHorario.getText(),
                Integer.parseInt(vistaFuncion.jTPDiamante.getText()),
               String.valueOf( vistaFuncion.jCEstado.getSelectedItem())
        );
        //Agregando a la base de datos
        DAOFuncion daoFuncion = new DAOFuncion();
        try {
            System.out.println(funcionTeatral.toString());
            daoFuncion.agregar(funcionTeatral);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void eliminarFuncion() {
        String cad = "titulo= " + vistaFuncion.jTTitulo.getText();

        //Eliminando de la base de datos
        DAOFuncion daoFuncion = new DAOFuncion();
        try {
            daoFuncion.eliminar(cad);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }  
    public void consultarFuncion() {
        String condicion = vistaFuncion.jTTitulo.getText();
        DAOFuncion daoFuncion = new DAOFuncion();
        try {
            ArrayList<FuncionTeatral> listaFunciones = new ArrayList<FuncionTeatral>();
            listaFunciones = daoFuncion.consultar(condicion);
            vistaFuncion.jTHorario.setText(listaFunciones.get(0).getHoraFuncion());
            vistaFuncion.jTPDiamante.setText(String.valueOf(listaFunciones.get(0).getPrecioDiamanteFuncion()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } 
    public void llenarObras() {
        int i;
        vistaFuncion.jCFunciones.removeAllItems();
        DAOObra dao_Obra = new DAOObra();
        try {
            ArrayList<ObraTeatral> listaObras = new ArrayList<ObraTeatral>();
            listaObras = dao_Obra.consultarTodos();
            System.out.println(listaObras.size());
            for (i = 0; i < listaObras.size(); i++) {
                vistaFuncion.jCFunciones.addItem(listaObras.get(i).getTituloObra());
                System.out.println(listaObras.get(i).getTituloObra());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    } 
    public void modificarFuncion() {
        String condicion = "titulo= " + vistaFuncion.jTTitulo.getText();

        FuncionTeatral funcion = new FuncionTeatral(
                vistaFuncion.jDate.getDateFormatString(),
                vistaFuncion.jTHorario.getText(),
                Integer.parseInt(vistaFuncion.jTPDiamante.getText()),
               String.valueOf( vistaFuncion.jCEstado.getSelectedItem()));

        //Moficanado a la base de datos
        DAOFuncion daofuncion = new DAOFuncion();
        try {
            daofuncion.modificar(funcion, condicion);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
   public void llenarSeleccion(String condicion){
            DAOObra daoObra = new DAOObra();
            
            try {
                ArrayList<ObraTeatral> listaobra = new ArrayList<ObraTeatral>();
                listaobra = daoObra.consultar(condicion);
                vistaFuncion.jTTitulo.setText(listaobra.get(0).getTituloObra());
                vistaFuncion.jTId_Obra.setText(String.valueOf(listaobra.get(0).getId_obra()));
            } catch (SQLException ex) {
                Logger.getLogger(ControlFuncion.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
   
}
