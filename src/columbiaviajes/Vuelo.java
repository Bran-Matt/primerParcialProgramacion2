package columbiaviajes;

import java.io.Serializable;

public class Vuelo implements Serializable {
    // Atributos
    private int numeroVuelo;
    private String fecha;
    private String origen;
    private String destino;
    private int plazasTotales;
    private int plazasTurista;
    private float precio;
    
    // Metodos
    // Constructor
    public Vuelo(int numeroVuelo, String fecha, String origen, String destino, int plazasTotales, int plazasTurista, float precio) {
        this.numeroVuelo = numeroVuelo;
        this.fecha = fecha;
        this.origen = origen;
        this.destino = destino;
        this.plazasTotales = plazasTotales;
        this.plazasTurista = plazasTurista;
        this.precio = precio;
    }

    // Getters
    public int getNumeroVuelo() {
        return numeroVuelo;
    }
    public String getFecha() {
        return fecha;
    }
    public String getOrigen() {
        return origen;
    }
    public String getDestino() {
        return destino;
    }
    public int getPlazasTotales() {
        return plazasTotales;
    }
    public int getPlazasTurista() {
        return plazasTurista;
    }
    public float getPrecio() {
        return precio;
    }
    
    // Override
    @Override
    public String toString() {
        return ("Numero de Vuelo: " + getNumeroVuelo() +
                "\n\tDe: " + getOrigen() + ".   Hasta: " + getDestino() +
                "\n\tPlazas: " + getPlazasTotales() +
                "\n\tPrecio: $" + precio);
    }
}