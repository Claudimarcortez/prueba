package controlador;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * 
 * @author Claudimar
 * version v1. 
 * subimos proyecto a repositorio. 
 * 
 */

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private List<String> protectedRoutes;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicializamos la lista de rutas protegidas
        protectedRoutes = Arrays.asList("/altaPelicula.html", "/galeria.html", "/index1.html");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        String requestURI = httpRequest.getRequestURI();

        // Verificamos si la ruta solicitada está protegida
        boolean isProtectedRoute = protectedRoutes.stream().anyMatch(route -> requestURI.endsWith(route));

        // Si la ruta está protegida y el usuario no está autenticado, redireccionamos a la página de inicio de sesión
        if (isProtectedRoute && (session == null || session.getAttribute("username") == null)) {
            httpResponse.sendRedirect("Login.html");
        } else if (!isProtectedRoute && session != null && session.getAttribute("username") != null) {
            // Si la ruta no está protegida y el usuario está autenticado, redireccionamos a la página de inicio
            httpResponse.sendRedirect("Login.html");
        } else {
            // Permitimos el acceso a la ruta solicitada
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Limpieza de recursos
    }
}

