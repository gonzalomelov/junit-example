/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tvs_testingunitario;

import java.util.LinkedList;

/**
 *
 * @author gonza
 */
public class Utils {
    public static void printLibroList(LinkedList<Libro> list){
        for(Libro l: list){
            System.out.println(l.toString());
        }
    }
    
    public static void printSocioList(LinkedList<Socio> list){
        for(Socio s: list){
            System.out.println(s.toString());
        }
    }
    
    public static void printReservaList(LinkedList<Reserva> list){
        for(Reserva r: list){
            System.out.println(r.toString());
        }
    }
    
    public static void printPrestamoList(LinkedList<Prestamo> list){
        for(Prestamo p: list){
            System.out.println(p.toString());
        }
    }
    
    public static void printLibroDataTypeList(LinkedList<LibroDataType> list){
        for(LibroDataType ldt: list){
            System.out.println(ldt.toString());
        }
    }
}
