/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author moise
 */
public class NodoPila<T> {
    
    // Variable en la cual se va a guardar el valor.
    private Object valor;
    // Variable para enlazar los nodos.
    private NodoPila siguiente;
    
    public NodoPila(Object valor){
        this.valor = valor;
        this.siguiente = null;
    }
    
    
    // Métodos get y set para los atributos.
    public T getValor() {
        return (T) valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
}
