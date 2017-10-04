/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.*;
import Vista.ViewButacas;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Acer
 */
public class ControlButacas implements ActionListener {
    private ViewButacas vistaButacas;
    
    public ControlButacas(ViewButacas vb) {
        this.vistaButacas = vb;
    }

    public void iniciar() {
        vistaButacas.setLocationRelativeTo(null);
        vistaButacas.setResizable(false);
        vistaButacas.setVisible(true);

        habilitarButacas();
    }

    public void actionPerformed(ActionEvent evento) {
        
    }
    
    public void habilitarButacas(){
        ButacaPlata[][] buttomsRightPlata = new ButacaPlata[2][6];
        ButacaPlata[][] buttomsLeftPlata = new ButacaPlata[2][6];
        
        ButacaPlata[][] buttomsRightPlata2 = new ButacaPlata[2][6];
        ButacaPlata[][] buttomsLeftPlata2 = new ButacaPlata[2][6];
        
        ButacaOro[][] buttomsRightOro = new ButacaOro[2][8];
        ButacaOro[][] buttomsLeftOro = new ButacaOro[2][8];
        
        ButacaDiamante[][] buttomsRightDiamante = new ButacaDiamante[3][8];
        ButacaDiamante[][] buttomsLeftDiamante = new ButacaDiamante[3][8];
        
        ButacaCobre[][] buttomsRightCobre = new ButacaCobre[3][8];
        ButacaCobre[][] buttomsLeftCobre = new ButacaCobre[3][8];
        
        ButacaLata[][] buttomsRightLata = new ButacaLata[6][6];
        ButacaLata[][] buttomsLeftLata = new ButacaLata[6][6];
        
        ButacaLata[][] buttomsRightLata2 = new ButacaLata[6][6];
        ButacaLata[][] buttomsLeftLata2 = new ButacaLata[6][6];
        
        for(int i=0;i<2;i++){
            for(int j=0;j<6;j++){
                buttomsRightPlata[i][j]=new ButacaPlata(50*j,40*i,30,30);
                buttomsRightPlata[i][j].setNameRight(j);
                vistaButacas.panelPlata.add(buttomsRightPlata[i][j]);
                buttomsLeftPlata[i][j]=new ButacaPlata(50*j,40*i,30,30);
                buttomsLeftPlata[i][j].setNameLeft(j);
                vistaButacas.panelPlata.add(buttomsLeftPlata[i][j]);
                
                buttomsRightPlata2[i][j]=new ButacaPlata(50*j,40*i,30,30);
                buttomsRightPlata2[i][j].setNameRight(j);
                vistaButacas.panelPlata2.add(buttomsRightPlata2[i][j]);
                buttomsLeftPlata2[i][j]=new ButacaPlata(50*j,40*i,30,30);
                buttomsLeftPlata2[i][j].setNameLeft(j);
                vistaButacas.panelPlata2.add(buttomsLeftPlata2[i][j]);
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<8;j++){                
                buttomsRightOro[i][j]=new ButacaOro(50*j,40*i,30,30);
                buttomsRightOro[i][j].setNameRight(j);
                vistaButacas.panelOro.add(buttomsRightOro[i][j]);
                buttomsLeftOro[i][j]=new ButacaOro(50*j,40*i,30,30);
                buttomsLeftOro[i][j].setNameLeft(j);
                vistaButacas.panelOro.add(buttomsLeftOro[i][j]);
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<8;j++){
                buttomsRightDiamante[i][j]=new ButacaDiamante(50*j,40*i,30,30);
                buttomsRightDiamante[i][j].setNameRight(j);
                vistaButacas.panelDiamante.add(buttomsRightDiamante[i][j]);
                buttomsLeftDiamante[i][j]=new ButacaDiamante(50*j,40*i,30,30);
                buttomsLeftDiamante[i][j].setNameLeft(j);
                vistaButacas.panelDiamante.add(buttomsLeftDiamante[i][j]);
                
                buttomsRightCobre[i][j]=new ButacaCobre(50*j,40*i,30,30);
                buttomsRightCobre[i][j].setNameRight(j);
                vistaButacas.panelCobre.add(buttomsRightCobre[i][j]);
                buttomsLeftCobre[i][j]=new ButacaCobre(50*j,40*i,30,30);
                buttomsLeftCobre[i][j].setNameLeft(j);
                vistaButacas.panelCobre.add(buttomsLeftCobre[i][j]);
               
            }
        }
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){                
                buttomsRightLata[i][j]=new ButacaLata(50*j,40*i,30,30);
                buttomsRightLata[i][j].setNameRight(j);
               vistaButacas.panelLata.add(buttomsRightLata[i][j]);
                buttomsLeftLata[i][j]=new ButacaLata(50*j,40*i,30,30);
                buttomsLeftLata[i][j].setNameLeft(j);
                vistaButacas.panelLata.add(buttomsLeftLata[i][j]);
                
                buttomsRightLata2[i][j]=new ButacaLata(50*j,40*i,30,30);
                buttomsRightLata2[i][j].setNameRight(j);
                 vistaButacas.panelLata2.add(buttomsRightLata2[i][j]);
                buttomsLeftLata2[i][j]=new ButacaLata(50*j,40*i,30,30);
                buttomsLeftLata2[i][j].setNameLeft(j);
                vistaButacas.panelLata2.add(buttomsLeftLata2[i][j]);
            }
        }
    }
}
