package proyecto.pkg2.diego;

public class NodoPila <T>{
    public T data;
    public NodoPila <T> pNext;

    public NodoPila(T data) {
        this.data = data;
        this.pNext = null;
    }
    
    
}
