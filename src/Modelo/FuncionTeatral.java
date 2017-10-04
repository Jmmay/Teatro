/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Acer
 */
public class FuncionTeatral {
    private int id_obra;
    private String tituloFuncion;
    private String fechaFuncion;
    private String horaFuncion;
    private int precioDiamanteFuncion;
    private String estadoFuncion;

    public FuncionTeatral() {
    }

    public FuncionTeatral(String titulo, String Fecha, String hora, int PDiamante, String Estado) {
        this.tituloFuncion = titulo;
        this.fechaFuncion= Fecha;
        this.horaFuncion = hora;
        this.precioDiamanteFuncion= PDiamante;
        this.estadoFuncion= Estado;
    }
public FuncionTeatral(int id_obra,String titulo, String Fecha, String hora, int PDiamante, String Estado) {
        this.id_obra=id_obra;    
        this.tituloFuncion = titulo;
        this.fechaFuncion = Fecha;
        this.horaFuncion= hora;
        this.precioDiamanteFuncion= PDiamante;
        this.estadoFuncion= Estado;
    }
    public FuncionTeatral(String Fecha, String hora, int PDiamante, String Estado) {
        this.fechaFuncion = Fecha;
        this.horaFuncion= hora;
        this.precioDiamanteFuncion = PDiamante;
        this.estadoFuncion = Estado;
    }

    
    
    
    public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public String getTituloFuncion() {
        return tituloFuncion;
    }

    public void setTituloFuncion(String tituloFuncion) {
        this.tituloFuncion = tituloFuncion;
    }

    public String getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(String fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public String getHoraFuncion() {
        return horaFuncion;
    }

    public void setHoraFuncion(String horaFuncion) {
        this.horaFuncion = horaFuncion;
    }

    public int getPrecioDiamanteFuncion() {
        return precioDiamanteFuncion;
    }

    public void setPrecioDiamanteFuncion(int precioDiamanteFuncion) {
        this.precioDiamanteFuncion = precioDiamanteFuncion;
    }

    public String getEstadoFuncion() {
        return estadoFuncion;
    }

    public void setEstadoFuncion(String estadoFuncion) {
        this.estadoFuncion = estadoFuncion;
    }

    @Override
    public String toString() {
        return "FuncionTeatral{" + "id_obra=" + id_obra + ", tituloFuncion=" + tituloFuncion + ", fechaFuncion=" + fechaFuncion + ", horaFuncion=" + horaFuncion + ", precioDiamanteFuncion=" + precioDiamanteFuncion + ", estadoFuncion=" + estadoFuncion + '}';
    }

}
