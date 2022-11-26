
package proyecto.pkg2.diego;

public class NodoCola <T>{
    public T data;
    public NodoCola <T> pNext;

    public NodoCola(T data) {
        this.data = data;
        this.pNext = null;
    }
    
    
}
