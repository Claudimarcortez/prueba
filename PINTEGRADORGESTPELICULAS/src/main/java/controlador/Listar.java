package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Pelicula;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DaoPelicula;

/**
 * 
 * Servlet implementation class Listar
 * @author Claudimar Cortez
 * @version v1-2023
 * @since 04-2023
 */
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Listar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String respuestaJSON;
	try {
		respuestaJSON = DaoPelicula.getInstance().dameJson();
		
		System.out.println(respuestaJSON);
		
		PrintWriter respuesta = response.getWriter();
		
		respuesta.print(respuestaJSON);
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
			
		
		/*
		try {
			ArrayList<Pelicula> lista = DaoPelicula.getInstance().listar();
			
			for(Pelicula cir : lista) {
				
				System.out.println(cir.toString());
				
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
