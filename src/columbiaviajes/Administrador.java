package columbiaviajes;

import MyUtils.Consola;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administrador extends Usuario implements Serializable {
    // Metodos
    // Constructor
    public Administrador(String nombre, String apellido, String id, String clave,String direccion, String email, String telefono) {
        super(nombre, apellido, id, clave, "ADMINISTRADOR", direccion, email, telefono);
    }
    
    // Override
    @Override
    public int opcionMenuPrincipal(){
        Consola.println("********** MENU PRINCIPAL **********");
        Consola.println("[1]     Informacion PERSONAL     [1]");
        Consola.println("[2]         Editar Perfil        [2]");
        Consola.println("[3]    Informacion de VENDEDOR   [3]");
        Consola.println("[4]        Aniadir VENDEDOR      [4]");
        Consola.println("[5]        Editar VENDEDOR       [5]");
        Consola.println("[6]     Informacion de CLIENTE   [6]");
        Consola.println("[0]            Salir             [0]");
        return Consola.leerEnteroEntre( 6, 0, "Ingrese que desea Editar: ");
    }
    @Override
    public void mostrarMenuPrincipal(Empresa Cv) {
        try {
            Cv.deSerializar("BaseDeUsuarios.txt");
        } catch (IOException | ClassNotFoundException ex ) {
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
                getInfoUsuario(Cv, "VENDEDOR");
                mostrarMenuPrincipal(Cv);
                
            case 4:
                Consola.linea(80);
                try {
                    aniadirVendedor(Cv);
                    //aniadir(Cv, "Vendedor");
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);
                
            case 5:
                Consola.linea(80);
                try {
                    modificarUsuario(Cv, "VENDEDOR");
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);
                
            case 6:
                Consola.linea(80);
                getInfoUsuario(Cv, "CLIENTE");
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
