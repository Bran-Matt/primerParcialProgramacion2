package MyUtils;

import java.util.Scanner;
/**
 * import org.fusesource.jansi.Ansi;
 * import org.fusesource.jansi.AnsiConsole;
 *      AnsiConsole.systemInstall();
 *      System.out.println(Ansi.ansi().fgRed().a("Texto en rojo").reset());
 *      System.out.println(Ansi.ansi().fgYellow().bgBlue().a("Texto amarillo con fondo azul").reset());
 *      AnsiConsole.systemUninstall();
*/
public class Consola {
    
    /** --------------------[ COLORES ]-------------------- **/
    
    // Fondo de colores
    public static final String BLACK_BACKGROUND = "\u001B[40m";    //Código para activar fondo negro
    public static final String RED_BACKGROUND = "\u001B[41m";      //Código para activar fondo rojo
    public static final String GREEN_BACKGROUND = "\u001B[42m";    //Código para activar fondo verde
    public static final String YELLOW_BACKGROUND = "\u001B[43m";   //Código para activar fondo amarillo
    public static final String BLUE_BACKGROUND = "\u001B[44m";     //Código para activar fondo azul
    public static final String PURPLE_BACKGROUND = "\u001B[45m";   //Código para activar fondo purpura
    public static final String CYAN_BACKGROUND = "\u001B[46m";     //Código para activar fondo cyan
    public static final String WHITE_BACKGROUND = "\u001B[47m";    //Código para activar fondo blanco
    
    // Texto de colores 
    public static final String BLACK_TEXT = "\u001B[30m";  //Código para activar texto negro
    public static final String RED_TEXT = "\u001B[31m";    //Código para activar texto rojo
    public static final String GREEN_TEXT = "\u001B[32m";  //Código para activar texto verde
    public static final String YELLOW_TEXT = "\u001B[33m"; //Código para activar texto amarillo
    public static final String BLUE_TEXT = "\u001B[34m";   //Código para activar texto azul
    public static final String PURPLE_TEXT = "\u001B[35m"; //Código para activar texto purpura
    public static final String CYAN_TEXT = "\u001B[36m";   //Código para activar texto cyan
    public static final String WHITE_TEXT = "\u001B[37m";  //Código para activar texto blanco
    
    // Resetea los colores
    public static final String RESET_COLOR = "\u001B[0m";   //Codigo para desactivar el color
    
    /** --------------------[ CONSOLA ]-------------------- **/
 
    /**
     * @param mensaje Se espera que le llegue un String por parametros.
     * 
     * <p>Este metodo muestra un <b>String</b>, tener encuenta que <i><b>NO</b></i> hace un salto de linea.</p>
     */
    public static void print(String mensaje){
        System.out.print(mensaje);
    }
    /**
     * @param mensaje Se espera que le llegue un String por parametros.
     * 
     * <p>Este metodo muestra un <b>String</b>, tener en cuenta que hace un salto de linea.</p>
     */
    public static void println(String mensaje){
        System.out.println(mensaje);
    }
    /**
     * @param mensaje Se espera que le llegue un String por parametros.
     * 
     * <p>Este metodo muestra un <b>String</b>, tener en cuenta que solo hace una tabulacion.</p>
     */
    public static void printlt(String mensaje){
        System.out.print("\t" + mensaje);
    }
    /**
     * @param mensaje Se espera que le llegue un String por parametros.
     * 
     * <p>Este metodo muestra un <b>String</b>, tener en cuenta que tabula y salkta de linea.</p>
     */
    public static void printltn(String mensaje){
        System.out.println("\t" + mensaje);
    }
    
    /**
     * @param mensaje Se espera que le llegue un <b>String</b> por parametros.
     * 
     * <p>Este metodo lee un <b>String</b> que le ingrese el usuario.</p> 
     * 
     * @return Se devuelve el  String que ingresa el usuario.
     */
    public static String leerString(String mensaje){
        Consola.println(mensaje);
        return Consola.leerString();
    }
    /**
     * @return Se devuelve el String que ingresa el usuario.
     */
    private static String leerString(){
        Scanner sc = new Scanner(System.in);
        String scString = sc.nextLine();
        return scString;
    }

    /**
     * @param numMax Se pone el numero maximo que acepta
     * @param numMin Se pone el numero minimo que acepta
     * @param mensaje Se espera que le llegue un <b>String</b> por parametros.
     * 
     * <p>Este metodo lee un <b>Integer</b> que le ingrese el usuario.</p> 
     * 
     * @return Se devuelve el Integer que ingresa el usuario.
     */
    public static Integer leerEnteroEntre(int numMax, int numMin, String mensaje){
        int rango = leerEntero( mensaje );
        while( rango < numMin || rango > numMax ){
            rango = leerEntero( "[Error]. " + mensaje );
        }
        return rango;
    }
            
    /**
     * @param mensaje Se espera que le llegue un <b>String</b> por parametros.
     * 
     * <p>Este metodo lee un <b>Integer</b> que le ingrese el usuario.</p> 
     * 
     * @return Se devuelve el Integer que ingresa el usuario.
     */
    public static Integer leerEntero(String mensaje){
        Consola.println(mensaje);
        return Consola.leerEntero();
    }
    /**
     * @return Se devuelve el Integer que ingresa el usuario.
     */
    private static Integer leerEntero(){
        Scanner sc = new Scanner(System.in);
        int scInt = sc.nextInt();
        return scInt;
    }

    /**
     * @param mensaje Se espera que le llegue un <b>String</b> por parametros.
     * 
     * <p>Este metodo lee un <b>boolean</b> que le ingrese el usuario.</p> 
     * 
     * @return Se devuelve un boolean que ingresa el usuario.
     */
    public static boolean leerBooleano(String mensaje){
        Consola.println(mensaje);
        return Consola.leerBooleano();
    }
    /**
     * @return Se devuelve un boolean que ingresa el usuario.
     */
    private static boolean leerBooleano(){
        Scanner sc = new Scanner(System.in);
        return sc.nextBoolean();
    }

    /**
     * @param mensaje Se espera que le llegue un <b>String</b> por parametros
     * 
     * <p>Este metodo lee un <b>char</b> que le ingrese el usuario.</p> 
     * 
     * @return Se devuelve el char que ingresa el usuario.
     */
    public static char leerCaracter(String mensaje){
        Consola.println(mensaje);
        return Consola.leerCaracter();
    }
    /**
     * @return Se devuelve el char que ingresa el usuario.
     */
    private static char leerCaracter(){
        Scanner sc = new Scanner(System.in);
        char scChar = sc.next().charAt(0);
        return scChar;
    }
    
    /**
     * @param mensaje Se espera que le llegue un <b>String</b> por parametros
     * 
     * <p>Este metodo lee un <b>float</b> que le ingrese el usuario.</p> 
     * 
     * @return Se devuelve el float que ingresa el usuario.
     */
    public static float leerFlotante(String mensaje) {
        Consola.println(mensaje);
        return leerFlotante();
    }
    /**
     * @return Se devuelve el float que ingresa el usuario.
     */
    private static float leerFlotante(){
        Scanner s = new Scanner(System.in);
        return Float.parseFloat(s.nextLine());
    }

    /**
     * @param mensaje Se espera que le llegue un <b>String</b> por parametros
     * @param colorTexto Se espera que ingrese un <b>int</b> que representa el color.
     * 
     * <p>mostrar el <b>String</b>, con un color de texto o de background, cada color significa algo:</p>
     * <ul>
     *      <ol>1 - <b>negro</b>     ->  <i>Secreto.</i></ol>
     *      <ol>2 - <b>rojo</b>      ->  <i>Error.</i></ol>
     *      <ol>3 - <b>verde</b>     ->  <i>Correcto.</i></ol>
     *      <ol>4 - <b>amarillo</b>  ->  <i>Alerta.</i></ol>
     *      <ol>5 - <b>azul</b>      ->  <i>Advertencia.</i></ol>
     *      <ol>6 - <b>purpura</b>   ->  <i>Misterio.</i></ol>
     *      <ol>7 - <b>cyan</b>      ->  <i>Informaivo.</i></ol>
     *      <ol>8 - <b>blanco</b>    ->  <i>Neutral.</i></ol>
     * </ul>
     */
    public static void mostrarMensajeConColor(String mensaje, int colorTexto){
        switch(colorTexto){
            case 1 -> System.out.print( BLACK_TEXT );
            case 2 -> System.out.print( RED_TEXT );
            case 3 -> System.out.print( GREEN_TEXT );
            case 4 -> System.out.print( YELLOW_TEXT );
            case 5 -> System.out.print( BLUE_TEXT );
            case 6 -> System.out.print( PURPLE_TEXT );
            case 7 -> System.out.print( CYAN_TEXT );
            case 8 -> System.out.print( WHITE_TEXT );
            default -> System.out.print("");
        }
        Consola.println(mensaje + RESET_COLOR);
    }
    /**
     * @param mensaje Se espera que le llegue un <b>String</b> por parametros
     * @param colorFondo Se espera que ingrese un <b>int</b> que representa el color.
     * 
     * <p>mostrar el <b>String</b>, con un color de texto o de background, cada color significa algo:</p>
     * <ul>
     *      <ol>1 - <b>negro</b>     ->  <i>...</i></ol>
     *      <ol>2 - <b>rojo</b>      ->  <i>...</i></ol>
     *      <ol>3 - <b>verde</b>     ->  <i>...</i></ol>
     *      <ol>4 - <b>amarillo</b>  ->  <i>...</i></ol>
     *      <ol>5 - <b>azul</b>      ->  <i>...</i></ol>
     *      <ol>6 - <b>purpura</b>   ->  <i>...</i></ol>
     *      <ol>7 - <b>cyan</b>      ->  <i>...</i></ol>
     *      <ol>8 - <b>blanco</b>    ->  <i>...</i></ol>
     * </ul>
     */
    public static void mostrarMensajeConFondo(String mensaje, int colorFondo){
        switch(colorFondo){
            case 1 -> System.out.print( BLACK_BACKGROUND );
            case 2 -> System.out.print( RED_BACKGROUND );
            case 3 -> System.out.print( GREEN_BACKGROUND );
            case 4 -> System.out.print( YELLOW_BACKGROUND );
            case 5 -> System.out.print( BLUE_BACKGROUND );
            case 6 -> System.out.print( PURPLE_BACKGROUND );
            case 7 -> System.out.print( CYAN_BACKGROUND );
            case 8 -> System.out.print( WHITE_BACKGROUND );
            default -> System.out.print("");
        }
        Consola.println(mensaje + RESET_COLOR);
    }
    
    /**
     * esta funcion hace una linea recta
     * 
     * @param n es el largo de la linea
     */
    public static void linea(int n) {
        Consola.println("");
        for (int i = 0; i < n; i++) {
            Consola.print("-");
        }
        Consola.println("");
    }
    
}
