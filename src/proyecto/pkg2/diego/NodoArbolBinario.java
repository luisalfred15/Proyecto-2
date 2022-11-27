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
    
    
    public int nodosCompletos(NodoArbolBinario n) {
        if (n == null)
            return 0;
        else {
            if (n.HijoIzq != null && n.HijoDer != null)
                return nodosCompletos(n.HijoIzq) + nodosCompletos(n.HijoDer) + 1;
            return nodosCompletos(n.HijoIzq) + nodosCompletos(n.HijoDer);
        }
    }
    
    
}