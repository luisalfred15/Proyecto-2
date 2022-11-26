/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author moise
 */
public class Pila<T> {
    
    private NodoPila inicio;
    private int tamanio;

    public Pila() {
        this.inicio = null;
        this.tamanio = 0;
    }
    
    public boolean esVacia(){
        return getInicio() == null;
    }
    
    public int getTamanio(){
        return tamanio;
    } 
    
    public void apilar(Object valor){
        // Define un nuevo nodo.
        NodoPila nuevo = new NodoPila(valor);
        // Consulta si la pila esta vacia.
        if (esVacia()) {
            // Inicializa la pila con el nuevo valor.
            setInicio(nuevo);
        }
        // Caso contrario agrega el nuevo nodo al inicio de la pila.
        else{
            nuevo.setSiguiente(getInicio());
            setInicio(nuevo);
        }
        // Incrementa el contador del tamaño.
        setTamanio(getTamanio() + 1);
    } 
    
    public void quitar(){
        if (!esVacia()) {
            // Asigna como primer nodo al siguiente de la pila.
            setInicio(getInicio().getSiguiente());
            // Decrementa el contador del tamaño de la pila
            setTamanio(getTamanio() - 1);
        }
    }
    
    public Object cima(){
        if(!esVacia()){
            return getInicio().getValor();
        }else{
            return "La Pila esta vacia";
        }
    }
    
    public void destruir(){
        // Elimina el valor y la referencia a los demas nodos.
        setInicio(null);
        // Reinicia el contador a 0.
        setTamanio(0);
    }

    /**
     * @return the inicio
     */
    public NodoPila getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(NodoPila inicio) {
        this.inicio = inicio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    
}
