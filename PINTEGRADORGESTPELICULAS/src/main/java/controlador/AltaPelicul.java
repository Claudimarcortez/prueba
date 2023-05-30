package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Pelicula;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

/**
 * <h2> Servlet implementation class AltaPelicul</h2>
 * @author Claudimar Cortez
 * @version v1-2023
 * @since 04-2023
 */

@MultipartConfig
public class AltaPelicul extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String pathFiles = "C:\\Users\\Claudimar\\Desktop\\FP DAW\\Programacion\\PINTEGRADORGESTPELICULAS\\src\\main\\webapp\\fotos";  
    private File uploads = new File(pathFiles); 
    
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaPelicul() {
    	super ();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	

	String titulo = request.getParameter("titulo");
	String genero = request.getParameter("genero");
	int valoracion = Integer.parseInt(request.getParameter("valoracion"));
	
	//lectura de datos desde el cliente origen
	
	/**
	 * lectura de datos desde el cliente origen
	 */
	Part part = request.getPart("foto");  // datos binarios de la foto
	Path path = Paths.get(part.getSubmittedFileName()); // esto da el nombre de archivo original
	String fileName = path.getFileName().toString()	;  //esto se almacena en la base de datos
	
	//camino - el buufer
	
	InputStream input = part.getInputStream();
	
	// copiar la foto
	File file = new File(uploads,fileName);
	
	try {
	Files.copy(input, file.toPath());
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println ("error en la copia del archivo");
		PrintWriter error = response.getWriter();
		error.print("<h4> Se ha producido un error, contacte con el administrador</h4>");
	}
	
	
	Pelicula p = new Pelicula(titulo, genero, fileName, valoracion );
	
			
	try {
		p.insertar();
		// Redirigir al usuario a la página de inicio de sesión exitosa
					response.sendRedirect("index1.html");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	//esto parece que no va 
	System.out.println(p.toString());
	//respuesta web 
	PrintWriter out = response.getWriter();
	
	System.out.print("<p>La pelicula " +p.getTitulo() + " llego al <strong> servlet </strong> sin problemas</p>");
	
	
	// insertar base de datos 
	}
}
