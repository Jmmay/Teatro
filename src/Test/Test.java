/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Control.controlvalidar;
import Modelo.Usuario;
import Vista.VistaLogin;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Acer
 */
public class Test {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    Usuario usuario = new Usuario();
        VistaLogin validar = new VistaLogin();
        controlvalidar controlval= new controlvalidar(validar,usuario);
        validar.setVisible(true);
}
}
