package MyUtils;

import javax.swing.JOptionPane;

public class Gui {

    /**
     * @param texto Se espera que le llegue un String por parametros.
     * 
     * <p>Este metodo lee un <b>char</b> que le ingrese el usuario, usando <b>GUI</b></p> 
     * 
     * @return Se devuelve un char que ingresa el usuario.
     */
    public static char leerChar(String texto) {
        String st = JOptionPane.showInputDialog(texto);
        return (st == null || st.length() == 0 ? '0' : st.charAt(0));
    }

    /**
     * @param texto Se espera que le llegue un String por parametros.
     * 
     * <p>Este metodo lee un <b>String</b> que le ingrese el usuario, usando <b>GUI</b></p> 
     * 
     * @return Se devuelve un String que ingresa el usuario.
     */
    public static String leerString(String texto) {
        String st = JOptionPane.showInputDialog(texto);
        return (st == null ? "" : st);
    }

    /**
     * @param texto Se espera que le llegue un String por parametros.
     * 
     * <p>Este metodo lee un <b>boolean</b> que le ingrese el usuario, usando <b>GUI</b></p> 
     * 
     * @return Se devuelve un boolean que ingresa el usuario.
     */
    public static boolean leerBoolean(String texto) {
        int i = JOptionPane.showConfirmDialog(null, texto, "Consulta", JOptionPane.YES_NO_OPTION);
        return i == JOptionPane.YES_OPTION;
    }

    /**
     * @param s Se espera que le llegue un String por parametros,
     * 
     * <p>Este metodo muestra un <b>String</b>, usando <b>GUI</b></p> 
     * 
     */
    public static void mostrarString(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

}
