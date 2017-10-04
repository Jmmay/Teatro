/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Boleto;
import Vista.VistaVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Acer
 */
public class ControlVenta implements ActionListener {

    private VistaVenta Vventa;
    private Boleto boleto;
    
    public ControlVenta(Boleto B, VistaVenta vv) {
        this.boleto = B;
        this.Vventa = vv;
        this.Vventa = new VistaVenta();
        this.Vventa.id.addActionListener(this);
        this.Vventa.jBAsiento.addActionListener(this);
        this.Vventa.jBCalcular.addActionListener(this);
        this.Vventa.jBimprimir.addActionListener(this);
        this.Vventa.jCCategoria.addActionListener(this);
        this.Vventa.jCFunciones.addActionListener(this);
        this.Vventa.jTFolio.addActionListener(this);
        this.Vventa.jTHora.addActionListener(this);
        this.Vventa.jTPrecio.addActionListener(this);
        this.Vventa.jTasiento.addActionListener(this);
        this.Vventa.jTtotal.addActionListener(this);
    }
    
    
    
    
    public void actionPerformed(ActionEvent evento){
        
    }
    
}
