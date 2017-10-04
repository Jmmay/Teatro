
package Modelo;

/**
 * Clase usuario
 * @author User
 */
public class Usuario {
    private String nombre;
    private int clave;
    private String password;

 
/**
 * Constructor de usuario sin parametros.
 */
    public Usuario() {
        this.nombre = nombre;
        this.clave = clave;
    }
/**
 * Constructor que recibe los parametros usuario y password.
 * @param usu
 * @param password 
 */
    public Usuario(String usuario, String password) {
        this.nombre = usuario;
        this.password = password;
    }
    /**
     * los siguentes son metodos get y set.
     * @return 
     */
   public String getPasword() {
        return password;
    }

    public void setPasword(String pasword) {
        this.password = pasword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
}
