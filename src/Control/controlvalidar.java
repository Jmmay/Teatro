/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;


import Modelo.Usuario;
import Persistencia.DAOAgregarUsuario;
import Vista.VistaLogin;
import Vista.VistaMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *Valida al usuario junto con su password
 * @author User
 */
public class controlvalidar implements ActionListener {
    public Usuario Usuario;
    public VistaLogin val;
    
/**
 * Constructor del control validar 
 * @param v
 * @param a 
 */    
    public controlvalidar(VistaLogin v,Usuario a){
    this.Usuario = a;
    this.val = v;
    //this.val.getEntrar().addActionListener(new ValListener());
    this.val.aceptar.addActionListener( this);
    this.val.saliir.addActionListener( this);
    
    }
 /**
  * Inicia la vista validar
  */   
    public void iniciarVista(){
        val.setLocationRelativeTo(val);
        val.setTitle("Ingreso de Usuario");
        val.setLocationRelativeTo(null);
        val.setResizable(false);
        val.setVisible(true);
}
    
    /**
     * Boton salir.
     * @param e 
     */
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == val.saliir)
        {
            val.dispose();
        }

            
        }

        
    }
   
    


    
    

