/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.FuncionTeatral;
import Modelo.ObraTeatral;
import Vista.ViewButacas;
import Vista.VistaFunciones;
import Vista.VistaMenu;
import Vista.VistaObrasTeatrales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Acer
 */
public class ControlMenu implements ActionListener {

    private VistaMenu vistamenu;
    
    
    public ControlMenu(VistaMenu vistaMenu) {
        this.vistamenu = vistaMenu;
        this.vistamenu.jBFunciones.addActionListener(this);
        this.vistamenu.jBButacas.addActionListener(this);
        this.vistamenu.jBReporte.addActionListener(this);
        this.vistamenu.jBVenta.addActionListener(this);
        this.vistamenu.jBCancelar.addActionListener(this);
        this.vistamenu.jBOBRAS.addActionListener(this);

    }

    public void iniciar() {
        vistamenu.setLocationRelativeTo(null);
        vistamenu.setResizable(false);
        vistamenu.setVisible(true);
    }

    public void actionPerformed(ActionEvent evento) {
        if (vistamenu.jBFunciones == evento.getSource()) {
            FuncionTeatral funcionTeatral = new FuncionTeatral();
            VistaFunciones vistaFuncion = new VistaFunciones();
            ControlFuncion controlFuncion = new ControlFuncion(funcionTeatral, vistaFuncion);
            controlFuncion.iniciar();
            controlFuncion.llenarObras();
            vistamenu.setVisible(false);

//        } else if (vistamenu.jBVenta == evento.getSource()) {
            
        } else if (vistamenu.jBOBRAS == evento.getSource()) {
         JFrame frame=new JFrame("Alert");
             JOptionPane.showMessageDialog(frame, "HEY");
         
            ObraTeatral obra = new ObraTeatral();
            VistaObrasTeatrales vistaObras = new VistaObrasTeatrales();
            ControlObra controlObra = new ControlObra(obra, vistaObras);
            controlObra.iniciar();
            controlObra.llenarObras();
            vistamenu.setVisible(false);   

        }else if (vistamenu.jBButacas== evento.getSource()) {
            ViewButacas vistaButacas= new ViewButacas();
            ControlButacas controlButacas = new ControlButacas(vistaButacas);
            controlButacas.iniciar();
        }
    }
}
