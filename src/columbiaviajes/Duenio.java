package columbiaviajes;

import MyUtils.Consola;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


public class Duenio extends Usuario implements Serializable {
    //METODOS
    // Constructor
    public Duenio(String nombre, String apellido, String id, String clave, String direccion, String email, String telefono) {
        super(nombre, apellido, id, clave, "DUENIO", direccion, email, telefono);
    }

    // Override
    @Override
    public int opcionMenuPrincipal(){
        Consola.println("*********** MENU PRINCIPAL ***********");
        Consola.println("[01]     Informacion PERSONAL     [01]");
        Consola.println("[02]        Aniadir DUENIO        [02]");
        Consola.println("[03]     Informacion CODUENIO     [03]");
        Consola.println("[04]        Editar Perfil         [04]");
        Consola.println("[05] Informacion de ADMINISTRADOR [05]");
        Consola.println("[06]     Aniadir ADMINISTRADOR    [06]");
        Consola.println("[07]      Editar ADMINISTRADOR    [07]");
        Consola.println("[08]        Agregar SUCURSAL      [08]");
        Consola.println("[09]       Listar SUCURSALES      [09]");
        Consola.println("[10]         Agregar VUELO        [10]");
        Consola.println("[11]         Listar VUELOS        [11]");
        Consola.println("[12]         Agregar HOTEL        [12]");
        Consola.println("[13]         Listar HOTELES       [13]");
        Consola.println("[14]     Listado de VENDEDORES    [14]");
        Consola.println("[00]             Salir            [00]");
        return Consola.leerEnteroEntre( 14, 0, "Ingrese que desea Editar: ");
    }
    @Override
    public void mostrarMenuPrincipal(Empresa Cv) {
        try {
            Cv.deSerializar("BaseDeUsuarios.txt"); //Obtiene informacion del archivo BBDD.
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
        }

        Consola.linea(80);
        Consola.println("");

        switch ( opcionMenuPrincipal() ) {

            case 1:
                Consola.linea(80);
                Consola.println(toString() );
                mostrarMenuPrincipal(Cv);
            
            case 2:
                Consola.linea(80);
                try {
                    aniadirDuenio(Cv);      
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);
                
            case 3:
                Consola.linea(80);
                getInfoUsuario(Cv, "DUENIO");    //Te muestra los administradores
                mostrarMenuPrincipal(Cv);
            
            case 4:
                Consola.linea(80);
                try {
                    editInfoPersonal(Cv);        //Puede editar su Informacion
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);
                
            case 5:
                Consola.linea(80);
                getInfoUsuario(Cv, "ADMINISTRADOR");    //Te muestra los administradores
                mostrarMenuPrincipal(Cv);

            case 6:
                Consola.linea(80);
                try {
                    aniadirAdmin(Cv);           //Agrega nuevos Administadores
                    //aniadir(Cv, "Administrador");
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);

            case 7:
                Consola.linea(80);
                try {
                    modificarUsuario(Cv, "ADMINISTRADOR");      //Edita un administrador
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);
                
            case 8:
                Consola.linea(80);
                Cv.listarSucursales();
                try {
                    agregarSucursal(Cv);
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);
                
            case 9:
                Consola.linea(80);
                Cv.listarSucursales();
                mostrarMenuPrincipal(Cv);
                
            case 10:
                Consola.linea(80);
                Cv.listarVuelos();
                try {
                    agregarVuelo(Cv);       //Crea un Vuelo 
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);

            case 11:
                Consola.linea(80);
                Cv.listarVuelos();
                mostrarMenuPrincipal(Cv);
                
            case 12:
                Consola.linea(80);
                Cv.listarHoteles();
                try {
                    agregarHotel(Cv);
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);
                
            case 13:
                Consola.linea(80);
                Cv.listarHoteles();
                mostrarMenuPrincipal(Cv);
                
            case 14:
                Consola.linea(80);
                try {
                    Cv.OrdenarVendedores();
                } catch (IOException ex) {
                    Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                mostrarMenuPrincipal(Cv);

            case 0:
                try {
                Cv.serializar("BaseDeUsuarios.txt");
            } catch (IOException ex) {
                Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.exit(0);
        }
    }

    // Agregar Usuarios
    public void aniadirDuenio(Empresa Cv) throws IOException{
        Consola.println("Perfecto! ahora necesito que ingreses los datos del nuevo Usuario.");

        String nombre = Consola.leerString("Nombre: ");
        String apellido = Consola.leerString("Apellido: ");
        String direc = Consola.leerString("Direccion: ");
        String email = Consola.leerString("Email: ");
        String telefono = Consola.leerString("Telefono: ");
        Consola.printltn("Muy bien! los siguientes datos son MUY IMPORTANTES.");
        String id;
        do {
            id = Consola.leerString("Numero de Identificacion Unico: ");
        }while(Cv.validarId(id));
        
        String clave = Consola.leerString("Contrasenia: ");

        Cv.agregarUsuario(new Duenio(nombre, apellido, id, clave, direc, email, telefono));
        
        Cv.serializar("BaseDeUsuarios.txt");
    }   
    public void agregarVuelo(Empresa Cv) throws IOException {
        Consola.println("\nAgrege a la lista otro vuelo.");
        int numeroVuelo;
        do{
                numeroVuelo = Consola.leerEntero("Ingrese el numero de vuelo: ");
        } while(Cv.validarNumeroVuelos(numeroVuelo));
        
        String fecha = Consola.leerString("Fecha: ");
        String origen = Consola.leerString("Origen: "); 
        String destino = Consola.leerString("Destino: "); 
        int plazasTotales = Consola.leerEntero("Plazas Totales: ");
        int plazasTurista = Consola.leerEntero("Plazaas en Turista: ");
        float precio = Consola.leerFlotante("Precio: ");
        
        Cv.agregarVuelo(new Vuelo(numeroVuelo, fecha, origen, destino, plazasTotales, plazasTurista, precio));
        Cv.serializar("BaseDeUsuarios.txt");
    } 
    public void agregarHotel(Empresa Cv) throws IOException {
        Consola.println("Agregue a la lista otro hotel.");
        String nombre;
        do {
            nombre = Consola.leerString("Ingrese el nombre del Hotel: ");
        } while(Cv.validarHotel(nombre));
        
        
        String direccion = Consola.leerString("Direccion: ");
        String ciudad = Consola.leerString("Ciudad: ");
        String telefono = Consola.leerString("Telefono: ");
        int plazas = Consola.leerEntero("Plazas Disponibles: ");
        float precio = Consola.leerFlotante("Precio: ");
        
        Cv.agregarHotel(new Hotel(nombre, direccion, ciudad, telefono, plazas, precio));
        Cv.serializar("BaseDeUsuarios.txt");
    }
    public void agregarSucursal(Empresa Cv) throws IOException {
        Consola.println("Agregue a la lista otro Sucursales.");
        String nombre;
        do {
            nombre = Consola.leerString("Ingrese el codigo de sucursal: ");
        } while(Cv.validarSucursal(nombre));
        
        String direccion = Consola.leerString("Direccion: ");
        String telefono = Consola.leerString("Telefono: ");
        String email = Consola.leerString("Email: ");
        
        
        Cv.agregarSucursal(new Sucursal(nombre, direccion, email, telefono));
        Cv.serializar("BaseDeUsuarios.txt");
    }
    
    // Mostrar
    private void mostraLrista(ArrayList<Vendedor> vendedores) {
        for (Vendedor v : vendedores) {
            v.getFacturacionReducida();
        }
    }
}