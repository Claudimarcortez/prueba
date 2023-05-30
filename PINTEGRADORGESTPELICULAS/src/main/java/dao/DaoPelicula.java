package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.google.gson.Gson;

import modelo.Pelicula;
/**
 * 
 * @author Claudimar
 *
 */
public class DaoPelicula {
	
	private Connection con = null;
	private static DaoPelicula instance = null;
	
	public DaoPelicula() throws SQLException {
		
		con = DBconexion.getConnection();
				
	}

	
	//Este metodo es el que utilizo para aplicar el patron Singelton 
	
	public static DaoPelicula getInstance() throws SQLException {
		
		if(instance== null) {
			instance = new DaoPelicula();
			
		}
		return instance; 
		
	}
	
	
	
	public void insertar(Pelicula p) throws SQLException {
		
		
		// codigo (INSERT....) para poder insertar una pelicula 
		// Paso 1: Prepago la query /// jdbc
		// 
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO peliculas (titulo, genero, valoracion, foto) VALUES (?,?,?,?)");
		ps.setString(1, p.getTitulo());		
		ps.setString(2, p.getGenero());	
		ps.setInt(3, p.getValoracion());	
		ps.setString(4, p.getFoto());	
		
	
	
		
		int filas = ps.executeUpdate(); // cuando quiero enviar cosas (insertar, actualizar y para borrar)
		ps.close();
		
		
	}
	
	
	public void update(Pelicula a) {
		
		
	}
	
	//para recoger datos y devolver
	public ArrayList<Pelicula> listar () throws SQLException{
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM peliculas");
		
		ResultSet rs = ps.executeQuery(); //este metodo retorna una coleccion de tipo ResultSET de la SET. 
		
		ArrayList<Pelicula> result = null;
		
		while (rs.next()) {
			
			if (result == null) {
				result = new ArrayList<>();
				
			}
			result.add(new Pelicula (rs.getInt("id"), rs.getString("titulo"), rs.getString("genero"), rs.getString("foto"), rs.getInt("valoracion")));
			
			
		}
		return result;
			
		
	}
	//devolver datos al cliente
	public String dameJson() throws SQLException {
		String json = "";
		Gson gson = new Gson();
		
		json = gson.toJson(this.listar());
		return json; 
		
		
		
	}
	
	
	
	
}
