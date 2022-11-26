package proyecto.pkg2.diego;

public class ArbolBinario <T>{
    public NodoArbolBinario<T> proot;

    public ArbolBinario() {
        this.proot = null;
    }
    
    public ArbolBinario(NodoArbolBinario <T> proot){
        this.proot = proot;
    }
    
    public NodoArbolBinario <T> Raiz(){
        return proot;
    }
    
    public int size(NodoArbolBinario <T> root){
        int count = 0;
        if (root != null) {
            count++;
            count += size(root.HijoIzq);
            count += size(root.HijoDer);
        }
        return count;
    }
    
    public int altura(NodoArbolBinario <T> root){
        if (root == null) {
            return 0;
        }else{
            return Math.max(altura(root.HijoIzq), altura(root.HijoDer) + 1);
        }
    }
    
     public boolean IsEmpty(){
        return proot == null;
    }
    
    public NodoArbolBinario <T> izquierdo(NodoArbolBinario <T> temp) {
        return temp.HijoIzq;
    }
    
    public NodoArbolBinario <T> derecho(NodoArbolBinario <T> temp) {
        return temp.HijoDer;
    }
    
    public boolean existeIzq(NodoArbolBinario <T> temp) {
        return (temp.HijoIzq != null);
    }
    
    public boolean existeDer(NodoArbolBinario <T> temp) {
        return (temp.HijoDer != null);
    }
    
    public T leer(NodoArbolBinario <T> temp) {
        return temp.data;
    }
    
     public boolean IsLeaf(NodoArbolBinario <T> temp){
        return (temp.HijoIzq == null && temp.HijoDer == null);
    }
     
    public String preorden(NodoArbolBinario <T> root) {
        String recorrido = "";
        if (root != null) {
            recorrido += "(" + root.data + ") ";
            recorrido += preorden(root.HijoIzq);
            recorrido += preorden(root.HijoDer);
        }
        return recorrido;
    }
    
    public String inorden(NodoArbolBinario <T> root) {
        String recorrido = "";
        if (root != null) {
            recorrido += inorden(root.HijoIzq);
            recorrido += "(" + root.data + ") ";
            recorrido += inorden(root.HijoDer);
        }
        return recorrido;
    }
    
    public String postorden(NodoArbolBinario <T> root) {
        String recorrido = "";
        if (root != null) {
            recorrido += postorden(root.HijoIzq);
            recorrido += postorden(root.HijoDer);
            recorrido += "(" + root.data + ") ";
        }
        return recorrido;
    }
    
    public void insertarIzq(T info, NodoArbolBinario <T> root) {

        if (proot != null) {
            NodoArbolBinario <T> temp = Buscar(proot, root.data);
            NodoArbolBinario <T> izq = new NodoArbolBinario(info);
            if (temp.HijoIzq == null) {
                temp.HijoIzq = izq;
            }else{
                System.out.println("Ya existe un hijo izquierdo");
            }
        }else{
            System.out.println("El arbol esta vacio");
        }
        
        
    }
    
     public void insertarDer(T info, NodoArbolBinario<T> root) {

        if (proot != null) {
            NodoArbolBinario <T> temp = Buscar(proot, root.data);
            NodoArbolBinario <T> der = new NodoArbolBinario(info);
            if (temp.HijoDer == null) {
                temp.HijoDer = der;
            }else{
                System.out.println("Ya existe un hijo izquierdo");
            }
        }else{
            System.out.println("El arbol esta vacio");
        }
        
        
    }
    
    
    public NodoArbolBinario <T> Buscar(NodoArbolBinario <T> root, T info){
        NodoArbolBinario <T> target = null;
        if (root != null && !IsEmpty()) {
            if ((int) root.data == (int) info) {
                return root;
            }
            if (root.HijoIzq != null) {
                target = Buscar(root.HijoIzq, info);
            }
            if (target == null) {
                target = Buscar(root.HijoDer, info);
            }
            return target;
        }else{
            return null;
        }
        
    }
    
    
    public NodoArbolBinario <T> Padre(NodoArbolBinario <T> temp, NodoArbolBinario <T> root){
        NodoArbolBinario <T> padre;
        if (root == null || temp == null) {
            return null;
        }else if((root.HijoDer != null && root.HijoDer == temp) || (root.HijoIzq != null && root.HijoIzq == temp)){
            return root;
        }else{ 
            padre = Padre(temp, root.HijoIzq);
            if (padre == null) {
                padre = Padre(temp, root.HijoDer);
            }
            return padre;
        }
        
        
    }
    
    
    
}
