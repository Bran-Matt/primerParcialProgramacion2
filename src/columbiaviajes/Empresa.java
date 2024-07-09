package columbiaviajes;

import MyUtils.Consola;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Empresa implements Serializable {

    //LISTAS DE DATOS
    private ArrayList<Usuario> usuarios;
    private ArrayList<Sucursal> sucursales;
    private ArrayList<Vuelo> vuelos;
    private ArrayList<Hotel> hoteles;

    // Metodos
    // Constructor
    public Empresa() throws IOException {
        this.usuarios = new ArrayList<>();
        this.sucursales = new ArrayList<>();
        this.vuelos = new ArrayList<>();
        this.hoteles = new ArrayList<>();
    }

    // Guardar y Recuperar del Archivo
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        try (ObjectOutputStream o = new ObjectOutputStream(f)) {
            o.writeObject(this);
        }
    }
    public Empresa deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        Empresa s;
        try (ObjectInputStream o = new ObjectInputStream(f)) {
            s = (Empresa) o.readObject();
        }
        return s;
    }

    // Agregar a la Base de Datos
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public void agregarDuenio(Duenio duenio) {
        usuarios.add(duenio);
    }
    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }
    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }
    public void agregarHotel(Hotel hotel) {
        hoteles.add(hotel);
    }
    
    // Listas
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }
    public ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }
    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }
    
    public void OrdenarVendedores() throws IOException {
        float max = -1;        
        int cont = (int) usuarios.stream()
                                 .filter( u -> u.getRol().equals("VENDEDOR") )
                                 .count();
        /** traduccion:
         * .stream():
         *      Convierte la coleccion en un flujo de elementos
         * .filter(u -> u.getRol().equals("VENDEDOR")):
         *      Filtra los usuarios por el rol que es "VENDEDOR"
         * .count():
         *      Devuelve el numero de elementos en este flujo.
        */
        
        for (int i = 0; i < cont; i++) {
            for (Usuario u : usuarios) {
                if (u.getRol().equals("VENDEDOR")) { //FILTRO PARA SOLO LOS VENDEDORES
                    Vendedor v = (Vendedor) u;
                    if(v.getFacturacion() > max) {
                        max = v.getFacturacion();
                    } 
                }
            }
        }
        
        /**
         * List<Vendedor> vendedoresOrdenados = usuarios.stream()
         *                                              .filter(u -> u.getRol().equals("VENDEDOR"))
         *                                              .map(u -> (Vendedor) u)
         *                                              .sorted(Comparator.comparing(Vendedor::getFacturacion).reversed())
         *                                              .collect(Collectors.toCollection(ArrayList::new));
         ** traduccion:
         * .stream():
         *      Convierte la lista usuarios en un flujo (Stream) de elementos
         * .filter(u -> u.getRol().equals("VENDEDOR")):
         *      Filtra el flujo para incluir solo aquellos usuarios cuyo rol es "VENDEDOR"
         * .map(u -> (Vendedor) u):
         *      Convierte cada objeto Usuario del flujo en un objeto Vendedor
         * .sorted(Comparator.comparing(Vendedor::getFacturacion).reversed()):
         *      Ordena los vendedores según su facturación en orden descendente
         *          Comparator.comparing(Vendedor::getFacturacion):
         *              Crea un comparador basado en el método getFacturacion de la clase Vendedor
         *          .reversed():
         *              Indica que se desea ordenar en orden descendente (mayor a menor)
         * .collect(Collectors.toCollection(ArrayList::new)):
         *      Recolecta los vendedores ordenados en un nuevo ArrayList
         *          ArrayList::new:
         *              Se está indicando que queremos crear un nuevo ArrayList
         * ---------------------------------------------------------------------------------------------------------------
         * vendedoresOrdenados.forEach(v -> System.out.println(v.getFacturacionReducida()));
         ** traduccion:
         * .forEach(...):
         *      Itera sobre cada vendedor en la lista vendedoresOrdenados
         *      Para cada vendedor, usa el metodo getFacturacionReducida()
         * 
         */
    }

    public ArrayList<Usuario> getUsuarios(String rol) {
        /**antes:
         * ArrayList<Usuario> especificos = new ArrayList<>();
         * for (Usuario u : usuarios) {
         *     if (u.getRol().equals(rol)) {
         *         especificos.add(u);
         *     }
         * }
         * return especificos;*
         */
        
        return usuarios.stream()
                       .filter(u -> u.getRol().equals(rol))
                       .collect(Collectors.toCollection( ArrayList::new ));
        /** traduccion:
         * .stream():
         *      Convierte la lista usuarios en un flujo (Stream)
         * .filter(u -> u.getRol().equals(rol)):
         *      Filtra el flujo para incluir solo los usuarios cuyo rol coincide con el parámetro rol
         * .collect(Collectors.toCollection( ArrayList::new )):
         *      Colecciona los elementos filtrados en una nueva instancia de ArrayList
         */
    }

    // Mostrar Listar
    public void listarUsuarios() {
        Consola.printltn("Listado de Usuarios:");
        for (Usuario u : usuarios) {
            Consola.printltn( u.toString() );
        }
        //usuarios.stream().forEach(u -> Consola.println(u.toString()));
        Consola.println("\n");
    }
    public void listarSucursales() {
        Consola.printltn("Listado de Sucursales:");
        for (Sucursal s : sucursales) {
            Consola.printltn( s.toString() );
        }
        Consola.println("\n");
    }
    public void listarVuelos() {
        Consola.printltn("Listado de Vuelos:");
        for (Vuelo v : vuelos) {
            Consola.printltn( v.toString() );
        }
        Consola.println("\n");
    }
    public void listarHoteles() {
        Consola.printltn("Listado de Hoteles: \n");
        for (Hotel h : hoteles) {
            Consola.printltn( h.toString() );
        }
        Consola.println("\n");
    }
    public void listarUsuarios(String rol) {
        Consola.printltn("Listado de Usuarios (" + rol + "):");
        for (Usuario u : usuarios) {
            if (u.getRol().equals(rol)) {
                Consola.printltn( u.getId() + ": " + u.getNombe() + " " + u.getApellido());
            }
        }
        Consola.println("\n");
    }

    // Busqueda  
    public Usuario buscarUsuario(String ID) {
        int i = 0;
        //Usuario u;
        while (i < usuarios.size() && !ID.equals(usuarios.get(i).getId())) {
            i++;
        }
        //u = ( i < usuarios.size() )? usuarios.get(i) : null;
        return ( i < usuarios.size() )? usuarios.get(i) : null; // u;
    }
    public Sucursal buscarSucursal(String code) {
        int i = 0;
        //Sucursal s;
        while (i < sucursales.size() && !code.equals(sucursales.get(i).getCode())) {
            i++;
        }
        //s = ( i < sucursales.size() )? sucursales.get(i) : null;
        return ( i < sucursales.size() )? sucursales.get(i) : null; // s;
    }
    public Vuelo buscarVuelo(int numero) {
        int i = 0;
        //Vuelo v;
        while (i < vuelos.size() && numero != vuelos.get(i).getNumeroVuelo() ) {
            i++;
        }
        //v = ( i < vuelos.size() )? vuelos.get(i) : null;
        return ( i < vuelos.size() )? vuelos.get(i) : null; // v;
    }
    public Hotel buscarHotel(String nombre) {
        int i = 0;
        //Hotel h;
        while (i < hoteles.size() && !nombre.equals(hoteles.get(i).getNombre())) {
            i++;
        }
        //h = ( i < hoteles.size() )? hoteles.get(i) : null;
        return ( i < hoteles.size() )? hoteles.get(i) : null; //h;
    }
    public Usuario listarEncontrar(String rol) {
        listarUsuarios(rol);
        /**
         * antes:
         *      String code =Consola.leerString("Ingrese ID del usuario que desea revisar: ");
         *      Usuario u = buscarUsuario( code );
         * 
         * despues:
         *      Usuario u = buscarUsuario( Consola.leerString("Ingrese ID del usuario que desea revisar: ") );
         */
        return buscarUsuario( Consola.leerString("Ingrese ID del usuario que desea revisar: ") ); //u;
    }

    // Validar Atributos
    public Usuario validarUsuario(String IdClave) {
        int i = 0;
        while (i < usuarios.size() && !IdClave.equals(usuarios.get(i).getId() + ":" + usuarios.get(i).getClave())) {
            i++;
        }
        return ( i < usuarios.size() )? usuarios.get(i) : null;
    }
    public boolean validarId(String id) {
        return buscarUsuario(id) != null;
    }
    public boolean validarNumeroVuelos(int numVuelos) {       
        return buscarVuelo(numVuelos) != null;
    }
    public boolean validarHotel(String nombre) {
        return buscarHotel( nombre ) != null;
    }
    public boolean validarSucursal(String code) {
        return buscarSucursal(code) != null;
    }
    public boolean hayUsuario(String rol) {
        int i = 0;
        while (i < usuarios.size() && !rol.equals(usuarios.get(i).getRol())) {
            i++;
        }
        return  i < usuarios.size() ;
    }
    
}