package proyecto.pkg2.diego;

public class Pila <T>{
    private NodoPila <T> pCima;
    private int size;

    public Pila() {
        this.pCima = null;
        this.size = 0;
    }
    
    public boolean IsEmpty(){
        return size == 0;
    }
    
    
    public void Apilar(T info){
        NodoPila <T> nuevo = new NodoPila(info);
        nuevo.data = info;
        nuevo.pNext = pCima;
        pCima = nuevo;
        size += 1;
        
    }
    
//    public void Desapilar(){
//        NodoPila <T> aux = pCima;
//        pCima = pCima.pNext;
//        size -= 1;
//    }
//    
    public T Desapilar(){
        
        T dato = null;
        NodoPila <T> aux = pCima;
        pCima = pCima.pNext;
        dato = peek();
        size -= 1;
        return dato;
    }
    
    public T peek(){
        return pCima.data;
    }
    
    public int size(){
        return size;
    }
    
    public void Print(){
        T element;
        if (!IsEmpty()) {
            element = peek();
            Desapilar();
            System.out.println(element);
            Print();
            Apilar(element);
        }
    }
    
    public void Sumergir(T info){
        T element;
        if (!IsEmpty()) {
            element = peek();
            Desapilar();
            Sumergir(info);
            Apilar(element);
        }else{
            Apilar(info);
        }
    }
    
    public void imprimir() {
        NodoPila temp = pCima;
        while (temp != null) {
            System.out.println(temp.data );
            temp = temp.pNext;
        }
    }
    
    public void push(T d) {
        NodoPila nuevo = new NodoPila(d);
        if (pCima == null) {
            pCima = nuevo;
            size++;
        } else {
            if (d != null) {
                nuevo.pNext = pCima;
                pCima = nuevo;
                size++;
            }
        }
    }

    public Object pop() {
        NodoPila temp = pCima;
        pCima = pCima.pNext;
        size--;
        return temp.data;
    }
    
    
}
