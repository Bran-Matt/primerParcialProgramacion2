package columbiaviajes;

import MyUtils.Consola;
import java.io.IOException;
import java.io.Serializable;

public class EntradaSalida implements Serializable {
    
    /*public static String fBaseDeUsuarios = "BaseDeUsuarios.txt";
    public String sVendeor = "VENDEDOR";
    public String sDuenio = "DUENIO";
    public String sCliente = "CLIENTE";
    public String sAdministracion = "ADMINISTRADOR";
    public String sUsuario = "USUARIO";*/
    
    public static void mostrarMenuLogin(Empresa Cv) throws IOException, ClassNotFoundException {
        Consola.println("Bienvenido al sistema de COLUMBIA VIAJES");
        String id = Consola.leerString("\nIngrese su ID: ");
        String clave = Consola.leerString("Ingrese Su Clave: ");
        Consola.linea(80);
        
        try {
            Cv = Cv.deSerializar("BaseDeUsuarios.txt");
        } catch(IOException | ClassNotFoundException e) {
            Consola.mostrarMensajeConColor("ERROR: No se pudo obtener la informacion guardada\n", 2);
        }
        Usuario u = Cv.validarUsuario(id + ":" + clave);
        /*Usuario u = Cv.validarUsuario(Consola.leerString( "\nIngrese su ID: ")
                                      + ":" +
                                      Consola.leerString("Ingrese Su Clave: ") );*/

        if (u == null) {
            Consola.mostrarMensajeConColor("ERROR: La combinacion ID/Clave ingresada no es correcta.", 2);
            mostrarMenuLogin(Cv);
        } else {
            Consola.println("La validacion se realizo correctamente...");
            Consola.print("Bienvenido " + u.getNombe() + ", como puedo serte util?");
            u.mostrarMenuPrincipal(Cv);
        }
    }
    
    public static void mostrarMenuLogin() throws IOException, ClassNotFoundException {
        Consola.printltn("Bienvenido al sistema de COLUMBIA VIAJES");
        String id = Consola.leerString("\nIngrese su ID: ");
        String clave = Consola.leerString("Ingrese Su Clave: ");
        Consola.linea(80);

        Empresa Cv = new Empresa();
        /** En el try-catch vemos si existe el txt, si existe recolecta la info,
         *  si no existe agrego al duenio serializo y muestro el mensaje de ERROR */
        try {
            Cv = Cv.deSerializar("BaseDeUsuarios.txt");
        } catch(IOException | ClassNotFoundException e) {
            Cv.agregarDuenio(new Duenio("Mateo Stefano", "Branciforte", "1234", "MATT", "Avalos 958", "mateo.branciforte@alu.inspt.utn.edu.ar", "63730305"));
            //Cv.agregarDuenio( primerDuenio() );
            Cv.serializar("BaseDeUsuarios.txt");
            Consola.mostrarMensajeConColor("[ERROR] No se pudo obtener la informacion guardada\n", 2);
        }
        
        // si no existe el usuario devuelve un null
        Usuario u = Cv.validarUsuario(id + ":" + clave);
        /*Usuario u = Cv.validarUsuario(Consola.leerString( "\nIngrese su ID: ")
                                      + ":" +
                                      Consola.leerString("Ingrese Su Clave: ") );*/

        if (u == null) {
            Consola.mostrarMensajeConColor("[ERROR] La combinacion ID/Clave ingresada no es correcta.", 2);
        } else {
            Consola.println("La validacion se realizo correctamente...");
            Consola.print("Bienvenido " + u.getNombe() + ", como puedo serte util?");
            u.mostrarMenuPrincipal(Cv);
        }
    }
    
    /*private static Duenio primerDuenio(){
        Consola.println("Esta es la primera vez que usan este programa no?, no hay problema creemos el primer duenio.");

        String nombre = Consola.leerString("\nIngrese el Nombre: ");
        String apellido = Consola.leerString("Ingrese el Apellido: ");
        String direc = Consola.leerString("Ingrese el Direccion: ");
        String email = Consola.leerString("Ingrese el Email: ");
        String telefono = Consola.leerString("Ingrese el Telefono: ");
        Consola.mostrarMensajeConColor("Muy bien! los siguientes datos son MUY IMPORTANTES.", 6);
        String id = Consola.leerString("Numero de Identificacion Unico: ");       
        String clave = Consola.leerString("Contrasenia: ");

        return new Duenio(nombre, apellido, id, clave, direc, email, telefono);
    }*/
}
