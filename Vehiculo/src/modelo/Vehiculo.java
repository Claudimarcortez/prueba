package modelo;
/**
 * <h2> Esta clase representa un vehículo con una marca, modelo y año de fabricación.</h2>
 * @author Claudimar Cortez
 * @version 1
 * @since 04-2023
 * 
 * 
 */
public class Vehiculo {
  
  /** La marca del vehículo */
  private String marca;
  
  /** El modelo del vehículo */
  private String modelo;
  
  /** El año de fabricación del vehículo */
  private int anioFabricacion;
  
  /** La cantidad de vehículos creados */
  private static int cantidadVehiculos;
  
  /**
   * Constructor de la clase Vehiculo.
   * 
   * @param marca La marca del vehículo.
   * @param modelo El modelo del vehículo.
   * @param anioFabricacion El año de fabricación del vehículo.
   */
  public Vehiculo(String marca, String modelo, int anioFabricacion) {
    this.marca = marca;
    this.modelo = modelo;
    this.anioFabricacion = anioFabricacion;
    cantidadVehiculos++;
  }
  
  /**
   * Devuelve la marca del vehículo.
   * 
   * @return La marca del vehículo.
   */
  public String getMarca() {
    return marca;
  }
  
  /**
   * Devuelve el modelo del vehículo.
   * 
   * @return El modelo del vehículo.
   */
  public String getModelo() {
    return modelo;
  }
  
  /**
   * Cambia el modelo del vehículo.
   * 
   * @param modelo El nuevo modelo del vehículo.
   */
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }
  
  /**
   * Devuelve el año de fabricación del vehículo.
   * 
   * @return El año de fabricación del vehículo.
   */
  public int getAnioFabricacion() {
    return anioFabricacion;
  }
  
  /**
   * Devuelve una cadena que representa los detalles del vehículo.
   * 
   * @return Una cadena que representa los detalles del vehículo.
   */
  public String toString() {
    return "Marca: " + marca + ", Modelo: " + modelo + ", Año de fabricación: " + anioFabricacion;
  }
  
  /**
   * Devuelve la cantidad de vehículos creados.
   * 
   * @return La cantidad de vehículos creados.
   */
  
  
 
  public static int getCantidadVehiculos() {
    return cantidadVehiculos;
  }
  
}

