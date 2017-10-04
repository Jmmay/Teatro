/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author David C
 */
public abstract class Butaca extends JButton implements ActionListener{
    private int precio;
    private int fila;
    private int columna;
    private int estado;
    private int ubicacion;

    public Butaca(int row,int col,int large, int height) {
        fila=row;
        columna=col;
        setBounds(row,col,large,height);
        addActionListener(this);
    }
    public void setNameRight(int j){
        setText(""+(j+15));
    }
    public void setNameLeft(int j){
        setText(""+(j+1));
    }
    public void setNameCenter(int j){
        setText(""+(j+7));
    }
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(getBackground()==Color.BLACK){
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);}
        else{ 
        setBackground(Color.BLACK);
        setOpaque(true);
        }
    }
    
}
