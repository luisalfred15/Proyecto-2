package proyecto.pkg2.diego;

public class Cola <T>{
    private NodoCola <T> pFirst;
    private NodoCola <T> pLast;
    private int size;

    public Cola() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    public boolean IsEmpty(){
        return size == 0;
    }
    
    public T leerCabeza(){
        return pFirst.data;
    }
    
    public void Encolar(T info){
        NodoCola <T> nuevo = new NodoCola(info);
        nuevo.data = info;
        nuevo.pNext = null;
        
        if (pFirst == null) {
            pFirst = nuevo;
        }else{
            pLast.pNext = nuevo;
        }
        
        pLast = nuevo;
        size += 1;
        
    }
    
    
//    public void Desencolar(){
//        NodoCola <T> aux = pFirst;
//        pFirst = pFirst.pNext;
//        size -= 1;
//        
//        if (pFirst == null) {
//            pLast = null;
//        }
//    }
    
    public void Desencolar(){
        T dato;
        NodoCola <T> aux = pFirst;
        pFirst = pFirst.pNext;
        dato = leerCabeza();
        size -= 1;
        
        if (pFirst == null) {
            pLast = null;
        }
    }
    
    
    public void Invertir(){
        T element;
        if (!IsEmpty()) {
            element = leerCabeza();
            Desencolar();
            Invertir();
            Encolar(element);
        }
    }
    
    public void InsertarPrincipio(T info){
        T element;
        Encolar(info);
        for (int i = 0; i < size; i++) {
            element = leerCabeza();
            Desencolar();
            Encolar(element);
        }
        
    }
    
    public void Print(){
        T element;
        if (!IsEmpty()) {
            element = leerCabeza();
            Desencolar();
            System.out.println(element);
            Print();
            Encolar(element);
        }
    }
    
}
