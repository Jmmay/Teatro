/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Acer
 */
public class ObraTeatral {
    private int id_obra;
    private String tituloObra;
    private String descripcionObra;
    private String personajeprincipalObra;
    private String directorObra;
    private String telDirectorObra;
    private String emailDirectorObra;

    public ObraTeatral() {
    }


    public ObraTeatral(String titulo, String descripcion, String personajePrincipal, String director, String telDirector, String emailDirector) {
        this.tituloObra = titulo;
        this.descripcionObra= descripcion;
        this.personajeprincipalObra= personajePrincipal;
        this.directorObra = director;
        this.telDirectorObra= telDirector;
        this.emailDirectorObra= emailDirector;
    }
    public ObraTeatral(int id,String titulo, String descripcion, String personajePrincipal, String director, String telDirector, String emailDirector) {
        this.id_obra=id;
        this.tituloObra= titulo;
        this.descripcionObra = descripcion;
        this.personajeprincipalObra= personajePrincipal;
        this.directorObra= director;
        this.telDirectorObra= telDirector;
        this.emailDirectorObra= emailDirector;
    }

    public ObraTeatral(String Descripcion, String Pprincipal, String Director, String Teldirector, String Emaildirector) {
        this.descripcionObra= Descripcion;
        this.personajeprincipalObra= Pprincipal;
        this.directorObra= Director;
        this.telDirectorObra= Teldirector;
        this.emailDirectorObra= Emaildirector;
    }

      public int getId_obra() {
        return id_obra;
    }

    public void setId_obra(int id_obra) {
        this.id_obra = id_obra;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public String getDescripcionObra() {
        return descripcionObra;
    }

    public void setDescripcionObra(String descripcionObra) {
        this.descripcionObra = descripcionObra;
    }

    public String getPersonajeprincipalObra() {
        return personajeprincipalObra;
    }

    public void setPersonajeprincipalObra(String personajeprincipalObra) {
        this.personajeprincipalObra = personajeprincipalObra;
    }

    public String getDirectorObra() {
        return directorObra;
    }

    public void setDirectorObra(String directorObra) {
        this.directorObra = directorObra;
    }

    public String getTelDirectorObra() {
        return telDirectorObra;
    }

    public void setTelDirectorObra(String telDirectorObra) {
        this.telDirectorObra = telDirectorObra;
    }

    public String getEmailDirectorObra() {
        return emailDirectorObra;
    }

    public void setEmailDirectorObra(String emailDirectorObra) {
        this.emailDirectorObra = emailDirectorObra;
    }
    
    
 
}
