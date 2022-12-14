/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 * Clase para los nodos de la lista simple
 *
 * @author moise
 */
public class Nodo {

    private Object dato; //Variable donde se guardarĂ¡ el valor
    private Nodo pnext; //Variable para enlazar los nodos

    //Constructor vacio
    public Nodo() {
        this.dato = "";
        this.pnext = null;
    }

    //Constructor de la clase nodo si le paso solo la info
    public Nodo(Object dato) {
        this.dato = dato;
        this.pnext = null;
    }

    //Constructor de la clase nodo
    public Nodo(Object dato, Nodo nodito) {
        this.dato = dato;
        this.pnext = nodito;
    }

    //Metodos get y set para los atrubutos
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getPnext() {
        return pnext;
    }

    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }

    @Override
    public String toString() {
        return "Nodo{" + "dato=" + dato + ", pnext=" + pnext + '}';
    }

}
