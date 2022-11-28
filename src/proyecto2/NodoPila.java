/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author moise
 */
public class NodoPila {
    
    // Variable en la cual se va a guardar el valor.
     Object valor;
    // Variable para enlazar los nodos.
    NodoPila siguiente;
    
    public void Nodo(){
        this.valor = 0;
        this.siguiente = null;
    }
    
    public NodoPila(Object d){
        this.valor = d;
        this.siguiente = null;
    }
    
    public NodoPila(){
        this.valor = "";
        this.siguiente = null;
    }
    
    
    // Métodos get y set para los atributos.
    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
}
