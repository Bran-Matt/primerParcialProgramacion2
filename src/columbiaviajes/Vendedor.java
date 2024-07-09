package columbiaviajes;

import MyUtils.Consola;
import static columbiaviajes.EntradaSalida.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vendedor extends Usuario  implements Serializable {
   // Atributos
    private float facturacion = 0;
    
    // Metodos
    // Constructor
    public Vendedor(String nombre, String apellido, String id, String clave, String direccion, String email, String telefono) {
        super(nombre, apellido, id, clave, "VENDEDOR", direccion, email, telefono);
    }
    
    // Override
    @Override
    public int opcionMenuPrincipal(){
        Consola.println("********** MENU PRINVIPAL **********");
        Consola.println("[1]     Informacion Personal     [1]");
        Consola.println("[2]         Editar Perfil        [2]");
        Consola.println("[3]    Informacion de Cliente    [3]");
        Consola.println("[4]            Vender            [4]");
        Consola.println("[0]            Salir             [0]");
        return Consola.leerEnteroEntre( 4, 0,"Ingrese que desea Editar: ");
    }
    @Override
    public void mostrarMenuPrincipal(Empresa Cv) {
        try {
            Cv.deSerializar("BaseDeUsuarios.txt");
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
        }

        Consola.linea(80);
        Consola.println("\n");

        switch ( opcionMenuPrincipal() ) {
            case 1:
                Consola.linea(80);
                Consola.println(toString());
                // el try catch lo puso netbeans, nose por que jajajaj :,)
                try {
                    mostrarMenuLogin(Cv);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
                }

 
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
                getInfoCliente(Cv);
                mostrarMenuPrincipal(Cv);
                
            case 4:
                Consola.linea(80);
                if( Consola.leerBooleano("Desea ingresar un cliente existente?") ) {
                    try {
                        venderaCliente(Cv);
                    } catch (IOException ex) {
                        Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        aniadirCliente(Cv);
                    } catch (IOException ex) {
                        Logger.getLogger(Duenio.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    mostrarMenuLogin(Cv);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }          
          
        }
    }
    
    public void getInfoCliente(Empresa Cv) {
        if (Cv.hayUsuario("CLIENTE")) {
            Cliente c = (Cliente) Cv.listarEncontrar("CLIENTE");
            if (c != null) {
                c.getInfoCliente();
            } else {
                Consola.println("ERROR: No se encontro al Cliente.");
            }
        } else {
            Consola.println("ERROR: No hay Clientes guardados.");
        }
    }
    
    public void venderaCliente(Empresa Cv) throws IOException {
        Usuario u = null; 
        
        do {
            String code = Consola.leerString("Ingrese el ID del Cliente: ");
            u = Cv.buscarUsuario(code);
            if(u == null) {
                Consola.println("ERROR: No se encontro al Usuario.");
                mostrarMenuPrincipal(Cv);
            }
        } while(!(u instanceof Cliente));
        Cliente c = (Cliente) u;
         
        //Elije una Sucursal
        Sucursal suc = null;
        do {
            Consola.println("\n");
            Cv.listarSucursales();
            String numero = Consola.leerString("\nIngrese el codigo de sucursal que desea asignar: ");
            suc = Cv.buscarSucursal(numero);
        } while(suc == null);
        c.setSucursal(suc);
        
        //Elije un Hotel
        Hotel hotel = null;
        do {
            Consola.println("\n");
            Cv.listarHoteles();
            String nombr = Consola.leerString("\nIngrese el nombre del hotel que desea asignar: ");
            hotel = Cv.buscarHotel(nombr);
        } while(hotel == null);
        c.setHotel(hotel);
        
        //Elije un Vuelo
        Vuelo vuelo = null;
        do {
            Consola.println("\n");
            Cv.listarVuelos();
            int numero = Consola.leerEntero("\nIngrese el numero de vuelo que desea asignar: ");
            vuelo = Cv.buscarVuelo(numero);
        } while(vuelo == null);
        c.setVuelo(vuelo);
        
        facturacion += vuelo.getPrecio();
        facturacion += hotel.getPrecio()/3;
        
        Cv.serializar("BaseDeUsuarios.txt");
    }
    
    public void aniadirCliente(Empresa Cv) throws IOException{
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
        
        //Elije una Sucursal
        Sucursal suc = null;
        do {
            Consola.println("\n");
            Cv.listarSucursales();
            String numero = Consola.leerString("\nIngrese el codigo de sucursal que desea asignar: ");
            suc = Cv.buscarSucursal(numero);
        } while(suc == null);
        
        //Elije un Hotel
        Hotel hotel = null;
        do {
            Consola.println("\n\n");
            Cv.listarHoteles(); 
            String nombr = Consola.leerString("\nIngrese el nombre del hotel que desea asignar: ");
            hotel = Cv.buscarHotel(nombr);
        } while(hotel == null);
        
        //Elije un Vuelo
        Vuelo vuelo = null;
        do {
            Consola.println("\n");
            Cv.listarVuelos();
            int numero = Consola.leerEntero("\nIngrese el numero de vuelo que desea asignar: ");
            vuelo = Cv.buscarVuelo(numero);
        } while(vuelo == null);

        Cv.agregarUsuario(new Cliente(nombre, apellido, id, clave, direc, email, telefono, suc, hotel, vuelo));
        
        facturacion += vuelo.getPrecio();
        facturacion += hotel.getPrecio()/3;        
        
        Cv.serializar("BaseDeUsuarios.txt");
    }
    
    public float getFacturacion() {
        return facturacion;
    }
    public String getFacturacionReducida() {
        return getId() + ": " + getNombe()+ " $" + getFacturacion();
    }
}