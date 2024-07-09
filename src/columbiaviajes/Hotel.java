package columbiaviajes;

import java.io.Serializable;

public class Hotel implements Serializable{
    // Atributos
    private String nombre;
    private String dirección;
    private String ciudad;
    private String teléfono; 
    private int plazasDisponibles;
    private float precio;
    
    // Metodos
    // Constructor
    public Hotel(String nombre, String dirección, String ciudad, String teléfono, int plazasDisponibles, float precio) {
        this.nombre = nombre;
        this.dirección = dirección;
        this.ciudad = ciudad;
        this.teléfono = teléfono;
        this.plazasDisponibles = plazasDisponibles;
        this.precio = precio;
    }
    
    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return dirección;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getTeléfono() {
        return teléfono;
    }
    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }
    public float getPrecio() {
        return precio;
    }
    
    // Override
    @Override
    public String toString() {
        return ("Nombre: " + getNombre() +
                "\n\tCiudad: " + getCiudad() + ".  Direccion: " + getDireccion() +
                "\n\tTelefono: " + getTeléfono() +
                "\n\tPlazasDisponibles: " + getPlazasDisponibles() +
                "\n\tPrecio: $" + precio); 
    }    
}