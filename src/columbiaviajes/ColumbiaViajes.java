package columbiaviajes;

import MyUtils.Consola;
import java.io.IOException;

/** PRIMER PARCIAL (Límite para la entrega: 3/7/2024 – 8:00)
 * Desarrolle un sistema para gestionar la información de una cadena de agencias de viajes, relativa al 
 * hospedaje y vuelos de los turistas que la contratan, teniendo en cuenta que:
 * 
 * - La cadena de agencias está compuesta por un conjunto de sucursales. Cada sucursal viene definida
 *      por el código de sucursal, dirección, e-mail y teléfono.
 * - La cadena tiene contratados una serie de hoteles de forma exclusiva. Cada hotel estará definido por
 *      el código de hotel, nombre, dirección, ciudad, teléfono y número de plazas disponibles.
 * - De igual forma, la cadena tiene contratados una serie de vuelos regulares de forma exclusiva. Cada
 *      vuelo viene definido por el número de vuelo, fecha y hora, origen y destino, plazas totales y plazas
 *      de clase turista de las que dispone.
 * - La información que se desea almacenar por cada turista es el código de turista, nombre y apellidos,
 *      dirección, e-mail y teléfono.
 * 
 * Por otra parte, hay que tener en cuenta la siguiente información:
 * - A la cadena de agencias le interesa conocer qué sucursal ha contratado el turista.
 * - A la hora de viajar el turista puede elegir cualquiera de los vuelos que ofrece la cadena, y en que
 *      clase (turista o primera) desea viajar.
 * - De igual manera, el turista se puede hospedar en cualquiera de los hoteles que ofrece la cadena, y
 *      elegir el régimen de hospedaje (media pensión o pensión completa). Siendo significativa la fecha de
 *      llegada y de partida.
 * - Al sistema podrán acceder cuatro tipos de usuarios: clientes (que sólo lo podrán consultar),
 *      vendedores (que administrarán las reservas y a los clientes), administradores (que administrarán
 *      todo) y dueño (que podrá consultar un listado de los vendedores, ordenado según cuánto facturaron).
 * 
 * Para ello:
 * - Analice los requerimientos anteriores
 * - Determine los objetos requeridos para implementar ese sistema
 * - Establezca los atributos que deben tener estos objetos
 * - Fije los comportamientos que exhibirán estos objetos
 * - Especifique la forma en que los objetos deben interactuar entre sí para cumplir con los requerimientos del sistema
 * 
 * El sistema deberá utilizar serializable, abstracción, encapsulamiento, herencia, polimorfismo y persistencia (no BD).
 * La E/S del sistema será exclusivamente por consola (no GUI).
 * Se deberán subir a GitLab o GitHub el ejecutable (en formato jar), el código fuente, la documentación 
 *   (generada con javadoc) y los diagramas UML de caso-uso, de clases y uno de secuencia (generados con 
 *   http://plantuml.com/es y grabados en formato png)
 **/

public class ColumbiaViajes {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        EntradaSalida.mostrarMenuLogin();
        Consola.printltn("Gracias por usar el programa de Columbia Viajes, los esperamos devuelta");
    } 
}
