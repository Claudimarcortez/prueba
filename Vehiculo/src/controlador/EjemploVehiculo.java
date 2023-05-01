package controlador;

import modelo.Vehiculo;

/**
 * Esta clase representa un ejemplo de uso de la clase Vehiculo.
 */
public class EjemploVehiculo {
  
  /**
   * <h1> Método main que crea varios vehículos y utiliza los métodos de la clase Vehiculo.</h2>
   * @author Claudimar Cortez
   * @version 1
   * @since 04-2023
   */
	
  public static void main(String[] args) {
    // Crear varios vehículos utilizando los constructores de la clase Vehiculo
    Vehiculo vehiculo1 = new Vehiculo("Toyota", "Corolla", 2020);
    Vehiculo vehiculo2 = new Vehiculo("Honda", "Civic", 2018);
    Vehiculo vehiculo3 = new Vehiculo("Ford", "Mustang", 2015);
    
    // Imprimir los detalles de cada vehículo utilizando el método toString()
    System.out.println("Detalles del vehículo 1.1: " + vehiculo1.toString());
    System.out.println("Detalles del vehículo 2: " + vehiculo2.toString());
    System.out.println("Detalles del vehículo 3: " + vehiculo3.toString());
    
    // Cambiar el modelo del vehículo 1 utilizando el método setModelo()
    vehiculo1.setModelo("Camry");
    
    // Imprimir los detalles actualizados del vehículo 1
    System.out.println("Detalles del vehículo 1 actualizados: " + vehiculo1.toString());
    
    // Obtener el valor de la variable estática 'cantidadVehiculos'
    int cantidadVehiculos = Vehiculo.getCantidadVehiculos();
    System.out.println("Cantidad de vehículos creados: " + cantidadVehiculos);
    
  }
}

