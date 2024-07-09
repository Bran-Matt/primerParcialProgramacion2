package columbiaviajes;

import MyUtils.Consola;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Usuario  implements Serializable {
    // Atributos
    private Sucursal sucursalAsigned;
    private Vuelo vueloAsigned;
    private Hotel hotelAsigned;
    
    // Metodos
    // Constructor
    public Cliente(String nombre, String apellido, String id, String clave, String direccion, String email, String telefono, Sucursal sucursal, Hotel hotel, Vuelo vuelo) {
        super(nombre, apellido, id, clave, "CLIENTE", direccion, email, telefono);
        this.sucursalAsigned = sucursal;
        this.hotelAsigned = hotel;
        this.vueloAsigned = vuelo;
    }

    // Getters y Setters
    public void setVuelo(Vuelo vuelo) {
        this.vueloAsigned = vuelo;
    }
    public void setHotel(Hotel hotel) {
        this.hotelAsigned = hotel;
    }
    public void setSucursal(Sucursal sucursal) {
        this.sucursalAsigned = sucursal;
    }

    public void getInfoCliente() {
        Consola.println( toString() );
        Consola.println("Sucursal: " + sucursalAsigned.getCode() +
                        "\n\tHotel: " + hotelAsigned.getNombre() +
                        "\n\tVuelo: " + vueloAsigned.getNumeroVuelo());
    }
    
    // Override
    @Override
    public int opcionMenuPrincipal(){
        Consola.println("********** MENU PRINCIPAL **********");
        Consola.println("[1]     Informacion PERSONAL     [1]");
        Consola.println("[2]         Editar Perfil        [2]");
        Consola.println("[3]      Consultar SUCURSAL      [3]");
        Consola.println("[4]        Consultar HOTEL       [4]");
        Consola.println("[5]        Consultar VUELO       [5]");
        Consola.println("[0]            Salir             [0]");
        return Consola.leerEnteroEntre( 5, 0, "Ingrese que desea Editar: ");
    }
    @Override
    public void mostrarMenuPrincipal(Empresa Cv) {
        try {
            Cv.deSerializar("BaseDeUsuarios.txt");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
        }

        Consola.linea(80);
        Consola.println("");

        switch ( opcionMenuPrincipal() ) {
            case 1:
                Consola.linea(80);
                Consola.println( toString() );
                mostrarMenuPrincipal(Cv);
                
            case 2:
                Consola.linea(80);
                try {
                    editInfoPersonal(Cv);
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);
            
            case 3:
                Consola.linea(80);
                if(sucursalAsigned == null){
                    Consola.println("No tiene ninguna sucursal asignada.");
                } else {
                    Consola.println( sucursalAsigned.toString() );
                }
                mostrarMenuPrincipal(Cv);
                        
            case 4:
                Consola.linea(80);
                if(hotelAsigned == null){
                    Consola.println("No tiene ningun Hotel asignado.");
                } else {
                    Consola.println( hotelAsigned.toString() ); 
                }
                mostrarMenuPrincipal(Cv);
                
            case 5:
                Consola.linea(80);
                if(vueloAsigned == null){
                    Consola.println("No tiene ningun vuelo asignado.");
                } else {
                    Consola.println( vueloAsigned.toString() );
                }
                mostrarMenuPrincipal(Cv);
                
            case 0:
                Consola.linea(80);
                try {
                    Cv.serializar("BaseDeUsuarios.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    EntradaSalida.mostrarMenuLogin(Cv);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}