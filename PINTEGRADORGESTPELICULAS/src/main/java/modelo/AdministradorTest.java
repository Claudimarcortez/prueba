package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdministradorTest {

    @Test
    void testConstructorAndGetters() {
        Administrador administrador = new Administrador(1, "Nombre", "correo@ejemplo.com", "contraseña");

        assertEquals(1, administrador.getId());
        assertEquals("Nombre", administrador.getNombre());
        assertEquals("correo@ejemplo.com", administrador.getCorreoElectronico());
        assertEquals("contraseña", administrador.getContrasena());
    }

    @Test
    void testSetters() {
        Administrador administrador = new Administrador();

        administrador.setId(1);
        administrador.setNombre("Nombre");
        administrador.setCorreoElectronico("correo@ejemplo.com");
        administrador.setContrasena("contraseña");

        assertEquals(1, administrador.getId());
        assertEquals("Nombre", administrador.getNombre());
        assertEquals("correo@ejemplo.com", administrador.getCorreoElectronico());
        assertEquals("contraseña", administrador.getContrasena());
    }

    @Test
    void testEquals() {
        Administrador administrador1 = new Administrador(1, "Nombre", "correo@ejemplo.com", "contraseña");
        Administrador administrador2 = new Administrador(1, "Nombre", "correo@ejemplo.com", "contraseña");
        Administrador administrador3 = new Administrador(2, "OtroNombre", "correo2@ejemplo.com", "otracontraseña");

        assertEquals(administrador1, administrador2); // Deben ser iguales
        assertNotEquals(administrador1, administrador3); // No deben ser iguales
    }

    // Agrega más pruebas según tus necesidades

}
