/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author moise
 */
public class Pila {
    
    private NodoPila inicio;
    private int tamanio;

    public Pila() {
        this.inicio = null;
        this.tamanio = 0;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public int getTamanio(){
        return tamanio;
    } 
    
    public void apilar(Object valor){
        // Define un nuevo nodo.
        NodoPila nuevo = new NodoPila();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la pila esta vacia.
        if (esVacia()) {
            // Inicializa la pila con el nuevo valor.
            inicio = nuevo;
        }
        // Caso contrario agrega el nuevo nodo al inicio de la pila.
        else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        // Incrementa el contador del tamaño.
        tamanio++;
    } 
    
    public void quitar(){
        if (!esVacia()) {
            // Asigna como primer nodo al siguiente de la pila.
            inicio = inicio.getSiguiente();
            // Decrementa el contador del tamaño de la pila
            tamanio--;
        }
    }
    
    public Object cima(){
        if(!esVacia()){
            return inicio.getValor();
        }else{
            return "La Pila esta vacia";
        }
    }
    
    public void destruir(){
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Reinicia el contador a 0.
        tamanio = 0;
    } 
}
