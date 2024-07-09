package columbiaviajes;

import MyUtils.Consola;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

public abstract class Usuario implements Serializable {

    //Atributos
    private String nombre;
    private String apellido;
    private String id;
    private String clave;
    private String rol;
    private String direccion;
    private String email;
    private String telefono;
    
    // Metodos
    // Constructor
    public Usuario( String nombre, String apellido, String id, String clave, String rol, String direccion,String email, String telefono) {
        this.nombre = nombre;       //Not Null
        this.apellido = apellido;   //Not Null
        this.id = id;               //Not Null + Incremental
        this.clave = clave;         //Not Null
        this.rol= rol;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }
    public Usuario() {
    }

    public abstract int opcionMenuPrincipal();
    public abstract void mostrarMenuPrincipal(Empresa Cv);

    // Getters y Setters
    public String getNombe() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getId() {
        return id;
    }
    public String getClave() {
        return clave;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getEmail() {
        return email;
    }
    public String getRol() {
        return rol;
    }
    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
   
    // Override
    @Override
    public String toString() {
        return ("\nINFORMACION PERSONAL" +
                "\n\t* Codigo: " + id +
                "\n\t* Nombre y Apellido: " + nombre + " " + apellido +
                "\n\t* Contrasenia: " + clave +
                "\n\t* Email: " + email + 
                "\n\t* Direccion: " + direccion +
                "\n\t* Telefono: " + telefono);
    }
    
    private int mostrarOpcionesEditar(){
        Consola.println("********** Editar Usuario **********");
        Consola.println("[1]            Nombre            [1]");
        Consola.println("[2]           Apellido           [2]");
        Consola.println("[3]              Id              [3]");
        Consola.println("[4]             Clave            [4]");
        Consola.println("[5]           Direccion          [5]");
        Consola.println("[6]             Email            [6]");
        Consola.println("[7]           Telefono           [7]");
        return Consola.leerEnteroEntre( 7, 1, "Ingrese que desea Editar: ");
    }
    public void editInfoPersonal(Empresa Cv) throws IOException {
        Consola.println( toString() );
        switch ( mostrarOpcionesEditar() ){
                    case 1 -> setNombre( Consola.leerString("Nombre: ") );
                    case 2 -> setApellido( Consola.leerString("Apellido: ") );
                    case 3 -> setId( Consola.leerString("Id: ") );
                    case 4 -> setClave( Consola.leerString("Clave: ") );
                    case 5 -> setDireccion( Consola.leerString("Direccion: ") );
                    case 6 -> setEmail( Consola.leerString("Email: "));
                    case 7 -> setTelefono( Consola.leerString("Telefono: ") );
        }
        Cv.serializar("BaseDeUsuarios.txt");
    }
    
    public void getInfoUsuario(Empresa Cv) {
        if (Cv.hayUsuario("CLIENTE")) {
            Cliente c = (Cliente) Cv.listarEncontrar("CLIENTE");
            if (c != null) {
                c.getInfoCliente();
            } else {
                Consola.println("ERROR: No se encontro al usuario.");
            }
        } else {
            Consola.println("ERROR: No hay clientes guardados.");
        }
    }
    public void getInfoUsuario(Empresa Cv, String rol) {
        if (Cv.hayUsuario(rol)) {
            Usuario u = Cv.listarEncontrar(rol);
            if (u != null) {
                Consola.println( u.toString() );
            } else {
                Consola.println("ERROR: No se encontro al usuario.");
            }
        } else {
            Consola.println("ERROR: No hay usuarios guardados.");
        }
    }
    
    private int mostrarOpcionesModificar(){
        Consola.println("********** Modificar Usuario **********");
        Consola.println("       [1]       Nombre      [1]");
        Consola.println("       [2]      Apellido     [2]");
        Consola.println("       [3]         Id        [3]");
        Consola.println("       [4]      Direccion    [4]");
        Consola.println("       [5]        Email      [5]");
        Consola.println("       [6]       Telefono    [6]");
        return Consola.leerEnteroEntre( 6, 1, "Ingrese que desea Modificar: ");
    }
    public void modificarUsuario(Empresa Cv, String rol) throws IOException {
        if (Cv.hayUsuario(rol)) {
            Usuario u = Cv.listarEncontrar(rol);
            if (u != null) {
                Consola.println( u.toString() );
                switch( mostrarOpcionesModificar() ){
                    case 1 -> u.setNombre( Consola.leerString("Nombre: ") );
                    case 2 -> u.setApellido( Consola.leerString("Apellido: ") );
                    case 3 -> u.setId( Consola.leerString("Id: ") );
                    case 4 -> u.setDireccion( Consola.leerString("Direccion: ") );
                    case 5 -> u.setEmail( Consola.leerString("Email: ") );
                    case 6 -> u.setTelefono( Consola.leerString("Telefono: ") );
                }
            } else {
                Consola.println("ERROR: Ese ID no coincide con ningun usuario.");
            }
        } else {
            Consola.println("ERROR: No hay "+ rol +"/ES cargados.");
        }
        Cv.serializar("BaseDeUsuarios.txt");
    }
        
    public void aniadirAdmin(Empresa Cv) throws IOException{
        Consola.println("Perfecto! ahora necesito que ingreses los datos del nuevo Usuario.\n");

        String nombre = Consola.leerString("Nombre: ");
        String apellido = Consola.leerString("Apellido: ");
        String direc = Consola.leerString("Direccion: ");
        String email = Consola.leerString("Email: ");
        String telefono = Consola.leerString("Telefono: ");
        Consola.println("Muy bien! los siguientes datos son MUY IMPORTANTES.");
        String id;
        do {
            id = Consola.leerString("Numero de Identificacion Unico: ");
        }while(Cv.validarId(id));
        String clave = Consola.leerString("Contrasenia: ");

        Cv.agregarUsuario(new Administrador(nombre, apellido, id, clave, direc, email, telefono));
        
        Cv.serializar("BaseDeUsuarios.txt");
    }
    public void aniadirVendedor(Empresa Cv) throws IOException{
        Consola.println("Perfecto! ahora necesito que ingreses los datos del nuevo Usuario.\n");

        String nombre = Consola.leerString("Nombre: ");
        String apellido = Consola.leerString("Apellido: ");
        String direc = Consola.leerString("Direccion: ");
        String email = Consola.leerString("Email: ");
        String telefono = Consola.leerString("Telefono: ");
        Consola.println("Muy bien! los siguientes datos son MUY IMPORTANTES.\n");
        String id;
        do {
            id = Consola.leerString("Numero de Identificacion Unico: ");
        }while(Cv.validarId(id));
        String clave = Consola.leerString("Contrasenia: ");

        Cv.agregarUsuario(new Vendedor(nombre, apellido, id, clave, direc, email, telefono));
        
        Cv.serializar("BaseDeUsuarios.txt");
    }

    /*public void aniadir(Empresa Cv, String usuarioID) throws IOException{
        Usuario usuario = null;

        try {
            // Construye dinámicamente el nombre de la clase y crea una instancia
            usuario = (Usuario) Class.forName( Usuario.class.getPackage().getName() + "." + usuarioID )
                                     .getDeclaredConstructor().newInstance();
            /**
             * u.getClass().getPackage().getName():
             *      Obtiene el nombre del paquete de la clase del objeto u.
             *      Por ejemplo, si u es una instancia de Usuario y la clase Usuario está en el paquete com.example,
             *      esto devolverá "com.example".
             * 
             * + "." + usuarioID:
             *      Concatena el nombre del paquete con un punto y el valor de usuarioID.
             *      Supongamos que usuarioID es "Vendedor", esto resultará en "com.example.Vendedor"
             * 
             * Class.forName(...):
             *      Carga la clase con el nombre completo especificado.
             *      En este caso, intentará cargar la clase com.example.Vendedor
             * 
             * .getDeclaredConstructor():
             *      Obtiene el constructor predeterminado (sin parámetros) de la clase especificada
             * 
             * .newInstance():
             *      Crea una nueva instancia de la clase utilizando el constructor obtenido
            */
    
        /*} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            Consola.println("Error al crear el usuario: " + e.getMessage());
            return;
        }

        Consola.println("Perfecto! ahora necesito que ingreses los datos del nuevo Usuario.\n");

        String n = Consola.leerString("Nombre: ");
        String a = Consola.leerString("Apellido: ");
        String d = Consola.leerString("Direccion: ");
        String e = Consola.leerString("Email: ");
        String t = Consola.leerString("Telefono: ");
        Consola.mostrarMensajeConColor("Muy bien! los siguientes datos son MUY IMPORTANTES.", 6);
        String i;
        do {
            i = Consola.leerString("Numero de Identificacion Unico: ");
        } while (Cv.validarId(i));
        String c = Consola.leerString("Contrasenia: ");

        usuario.setNombre(n);
        usuario.setApellido(a);
        usuario.setDireccion(d);
        usuario.setEmail(e);
        usuario.setTelefono(t);
        usuario.setId(i);
        usuario.setClave(c);

        Cv.agregarUsuario(usuario);

        Cv.serializar("BaseDeUsuarios.txt");
    }*/
}