package proyecto.pkg2.diego;

public class NodoArbolBinario <T>{
    public T data;
    public NodoArbolBinario <T> HijoIzq;
    public NodoArbolBinario<T> HijoDer;
    

    public NodoArbolBinario (T data) {
        this.data = data;
        this.HijoIzq = null;
        this.HijoDer = null;
        
    }
    
    
}