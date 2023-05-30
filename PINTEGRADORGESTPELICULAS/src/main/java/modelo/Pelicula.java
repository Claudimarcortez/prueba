package modelo;

import java.sql.SQLException;

import dao.DaoPelicula;
/**
 * <h2> Clase Pelicula </h2>
 * <p>La clase Pelicula permite crear objetos que representan una pelicula, <br>
los cuales pueden ser almacenados en una base de datos y actualizados. </p>
 * @author Claudimar Cortez
 * @version v1-2023
 * @since 04-2023
 */


public class Pelicula {
	// atributos de la clase 
	/**
	 * id de la Pelicula
	 */
	private int id;
	/**
	 * Titulo de la pelicula
	 */
	private String titulo;
	/** 
	 * genero de la pelicula
	 */
	private String genero;
	/** foto de la pelicula
	 * 
	 */
	private String foto;
	/**
	 * valoracion de la pelicula
	 */
	private int valoracion;
	//si agrego una mas debo agregar el contructor y get and setters y toString 
	
	/** Constructores
	 * 
	 */
	public Pelicula() {
		
		
	}
	/**
	 * Constructor para crear un objeto pelicula con id para la base de datos y con foto
	 * @param id
	 * @param titulo
	 * @param genero
	 * @param foto
	 * @param valoracion
	 */
	
	//constructor con id para bbdd  //si agrego mas variables debo modificar el constructor 
	public Pelicula(int id, String titulo, String genero, String foto, int valoracion) {
		
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.foto = foto;
		this.valoracion = valoracion;
	}
	
	
	/**constructor de la clase Pelicula con 4 parametros 
	 * 
	 * @param titulo
	 * @param genero
	 * @param foto
	 * @param valoracion
	 */
	
	// constructor sin id 
	public Pelicula(String titulo, String genero, String foto, int valoracion) {
		
		this.titulo = titulo;
		this.genero = genero;
		this.foto = foto;
		this.valoracion = valoracion;
	}
	
	/** constructor con 3 parametros 
	 * 
	 * @param titulo
	 * @param genero
	 * @param valoracion
	 */
	// constructor sin id sin foto (prueba)
		public Pelicula(String titulo, String genero, int valoracion) {
			
			this.titulo = titulo;
			this.genero = genero;
			this.valoracion = valoracion;
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
		public String getTitulo() {
			return titulo;
		}
		
		/**
		 * 
		 * @param titulo
		 */
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		/**
		 * 
		 * @return
		 */
		public String getGenero() {
			return genero;
		}
		
		/**
		 * 
		 * @param genero
		 */

		public void setGenero(String genero) {
			this.genero = genero;
		}
		
		/**
		 * 
		 * @return
		 */

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}
		/**
		 * 
		 * @return
		 */
		public int getValoracion() {
			return valoracion;
		}
		
		/**
		 * 
		 * @param valoracion
		 */

		public void setValoracion(int valoracion) {
			this.valoracion = valoracion;
		}

		/**
		 * Isetar datos
		 * @throws SQLException
		 */
		
		//para insertar en base de datos
		public void insertar() throws SQLException {
			//se cambiara 
			/*
			DaoPelicula p = new DaoPelicula();
			p.insertar(this); 
			*/
			DaoPelicula.getInstance().insertar(this);
			
		}
				
		
		/**
		 * 
		 * @throws SQLException
		 */
		public void update() throws SQLException {
			
			DaoPelicula.getInstance().update(this);
			
		}
		
	
		
		@Override
	
		public String toString() {
			return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", foto=" + foto
					+ ", valoracion=" + valoracion + "]";
		}
		
	
	
}
