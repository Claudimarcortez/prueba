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
public class Administrador {

	// entidades 
	/** 
	 * id del administrador
	 */
	private int id;
	/** nombre del administrador 
	 * 
	 */
	private String nombre;
	/** correo electronico del administrador 
	 * 
	 */
	private String correoElectronico;
	/** contrasena del administrado
	 * 
	 */
	private String contrasena;
	
	/** Constructor de la clase Administrador con 4 parametros 
	 * 
	 * @param id
	 * @param nombre
	 * @param correoElectronico
	 * @param contrasena
	 */
		public Administrador(int id, String nombre, String correoElectronico, String contrasena) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.correoElectronico = correoElectronico;
			this.contrasena = contrasena;
		}
		
	
	/**
	 * 
	 * @return
	 */
		
	public int getId() {
		return id;
	}
/**
 * 
 * @param id
 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @return
	 */

	public String getCorreoElectronico() {
		return correoElectronico;
	}
	
	/**
	 * 
	 * @param correoElectronico
	 */

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	/**
	 * 
	 * @return
	 */

	public String getContrasena() {
		return contrasena;
	}
	
	/**
	 * 
	 * @param contrasena
	 */

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	/**
	 * Constructor Administrador 
	 */
	public Administrador() {
		super();
	}

	

}
