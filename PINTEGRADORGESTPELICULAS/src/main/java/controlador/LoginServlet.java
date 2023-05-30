package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;

import dao.DBconexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Obtiene una conexión a la base de datos
            conn = DBconexion.getConnection();
            
            // Prepara la consulta SQL para buscar un usuario por nombre de usuario
            String sql = "SELECT * FROM users WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            
            // Ejecuta la consulta SQL
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                // Si se encuentra el usuario, obtiene el hash almacenado en la base de datos
                String hashedPasswordFromDB = rs.getString("password");
                
                // Genera el hash de la contraseña ingresada por el usuario
                String hashedPassword = getMD5(password);
                
                // Compara los hashes
                if (hashedPasswordFromDB.equals(hashedPassword)) {
                    // Si los hashes coinciden, el usuario es válido
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    response.sendRedirect("index1.html");
                } else {
                    // Si los hashes no coinciden, muestra un mensaje de error
                    request.setAttribute("error", "Nombre de usuario o contraseña incorrectos");
                    request.getRequestDispatcher("Login2.html").forward(request, response);
                }
            } else {
                // Si no se encuentra el usuario, muestra un mensaje de error
                request.setAttribute("error", "Nombre de usuario o contraseña incorrectos");
                request.getRequestDispatcher("Login2.html").forward(request, response);
            }
            
        } catch (SQLException e) {
            // Si hay un error en la base de datos, muestra un mensaje de error
            request.setAttribute("error", "Error en la base de datos: " + e.getMessage());
            request.getRequestDispatcher("login.html").forward(request, response);
        } finally {
            // Cierra los recursos de base de datos
            try { rs.close(); } catch (Exception e) {}
            try { pstmt.close(); } catch (Exception e) {}
            try { conn.close(); } catch (Exception e) {}

       }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtiene la sesión actual
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("username") != null) {
            // Si hay una sesión y el nombre de usuario está definido, lo muestra en la página de inicio
            String username = (String) session.getAttribute("username");
            request.setAttribute("username", username);
            request.getRequestDispatcher("index1.html").forward(request, response);
        } else {
            // Si no hay sesión o el nombre de usuario no está definido, redirige al usuario a la página de inicio de sesión
            response.sendRedirect("login2.html");
        }
    }
    
    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
