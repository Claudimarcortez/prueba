package modelo;

/**
 * <h2> Clase Administrador </h2>
 * <p> Se pueden crear administradores para gestionar las peliculas </p>
 * @author Claudimar Cortez
 * @version v1-2023
 * @since 04-2023
 * 
 * 
 */
	//clase Administrador
import java.util.Objects;

public class Administrador {
    private int id;
    private String nombre;
    private String correoElectronico;
    private String contrasena;

    public Administrador() {
    }

    public Administrador(int id, String nombre, String correoElectronico, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Administrador other = (Administrador) obj;
        return id == other.id &&
                Objects.equals(nombre, other.nombre) &&
                Objects.equals(correoElectronico, other.correoElectronico) &&
                Objects.equals(contrasena, other.contrasena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, correoElectronico, contrasena);
    }
}
