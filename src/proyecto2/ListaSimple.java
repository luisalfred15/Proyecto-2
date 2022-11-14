/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author moise
 */
public class ListaSimple {
    private Nodo pFirst; //nodo apuntador al primero
    private Nodo pLast; //nodo apuntador al ultimo
    private int size; //tamaño de la lista
    
    //Constructor de la clase Lista
    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0; 
    }
    
    //Metodos get y set para los atrubutos

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    //Primitivas
    
    //Funcion para verificar si la lista es vacia
    public boolean EsVacio(){
        return this.pFirst == null;
    }
    
    //Metodo que vacia la lista
    public void vaciar(){
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;   
    }
    
    //Metodo para retornar la posicion de un nodo
    public int getIndex (Nodo nodito){
        if (!EsVacio()){
            Nodo aux = pFirst;
            int count = 0;
            while(aux != null){
                
                if (nodito == aux){
                    return count;     //posicion en memoria del nodo
                }
                count ++;
                aux = aux.getPnext();
            }
            return -1;
        }
    return -1;
    }
    
    // Funcion para buscar un elemento en la lista
    public boolean buscar(Object referencia){
        Nodo aux = pFirst;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getDato()){ 
                encontrado = true;
            }
            else{
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }
    
    //Metodo para Insertar por referencia
    public void insertarPorReferencia(Object ref,Object valor){
        
        Nodo nuevo = new Nodo();
        nuevo.setDato(valor);
        
        if (!EsVacio()) {
            if (buscar(ref)) {
                Nodo aux = pFirst;
                // Recorre la lista hasta llegar al nodo de referencia.
                while (aux.getDato() != ref) {
                    aux = aux.getPnext();
                }
                // Crea un respaldo de la continuación de la lista.
                Nodo siguiente = aux.getPnext();
                // Enlaza el nuevo nodo despues del nodo de referencia.
                aux.setPnext(nuevo);
                // Une la continuacion de la lista al nuevo nodo.
                nuevo.setPnext(siguiente);
            
                size++;
            }
        }
    }
    
    //Metodo para insertar un nodo despues de una pos. det.
    public void insrtarPorPosicion(int posicion, Object valor){
        if(posicion>=0 && posicion<=size){
            Nodo nuevo = new Nodo();
            nuevo.setDato(valor);
            // Consulta si el nuevo nodo a ingresar va al inicio de la lista.
            if(posicion == 0){
                nuevo.setPnext(pFirst);
                pFirst = nuevo;
            }
            else{
                // Si el nodo a inserta va al final de la lista.
                if(posicion == size){
                    Nodo aux = pFirst;
                    
                    // Recorre la lista hasta llegar al ultimo nodo.
                    while(aux.getPnext() != null){
                        aux = aux.getPnext();
                    }
                    
                    // Inserta el nuevo nodo despues de del ultimo.
                    aux.setPnext(nuevo);              
                }
                else{
                    // Si el nodo a insertar va en el medio de la lista.
                    Nodo aux = pFirst;
                    // Recorre la lista hasta llegar al nodo anterior
                    // a la posicion en la cual se insertara el nuevo nodo.
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getPnext();
                    }
                    // Guarda el nodo siguiente al nodo en la posición
                    // en la cual va a insertar el nevo nodo.
                    Nodo siguiente = aux.getPnext();
                    // Inserta el nuevo nodo en la posición indicada.
                    aux.setPnext(nuevo);
                    // Une el nuevo nodo con el resto de la lista.
                    nuevo.setPnext(siguiente);
                }
            }
            size++;
        }
    }

    //Metodo para insertar al final
    public void InsertarFinal(Object dato){
        
        Nodo pNew = new Nodo(dato);
        
        if(EsVacio()){
            pFirst = pNew;
            pLast = pNew;
            
        } else {
            Nodo aux = pLast;
            aux.setPnext(pNew);
            pLast = pNew;
        }
        size ++;
    }
    
    //Metodo para insertar al inicio
    public void InsertarInicio(Object dato){
        
        Nodo pNew = new Nodo();
        pNew.setPnext(pNew);
       
        if (EsVacio()) {
             
            pFirst= pNew;
        
        } else{
            pNew.setPnext(pFirst);
            pFirst = pNew;
        }
        size++;
    }
    
    public void mostrar(){
        if (!EsVacio()){
            Nodo aux = pFirst;
            String expresion = "";
            for(int i = 0; i <size;i++){
               expresion += aux.getDato().toString();
                aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null,expresion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
    
    //Metodo para eliminar del incio
    public void EliminarIncio(){
        if (EsVacio()){
            Nodo aux = pFirst;
            for(int i = 0; i < size; i++){
                System.out.println(aux.getDato());
                aux.getPnext();
            }
        }else{
            System.out.println("La lista esta vacia");
        }
    }

    
    public String TipoNotacion(){
        //Verificar que la lista no esté vacia
        if (!EsVacio()){
            
            //Convertir la lista en un String
            Nodo aux = pFirst;
            String expresion = "";
            for(int i = 0; i <size;i++){
               expresion += aux.getDato().toString();
                aux = aux.getPnext();
            }
            int count = 0;
            int count2 = 0;
            char caracter_evaluar;
            for(int i = 0; i < expresion.length(); i++){
                caracter_evaluar = expresion.charAt(i);
                switch(caracter_evaluar){
                    case '(':
                        count ++;
                        break;
                    case ')':
                        count2 ++;
                        break;
                }
            }
            if(count == 0 && count == count2){
                char ultimo = expresion.charAt(expresion.length()-1);
                if (Character.isDigit(expresion.charAt(0))){  //Verifico si el primer valor es un digito 
                    if(Character.isDigit(ultimo)){            //Verifico si el ultimo valor es un digito
                        return "Infija";
                    }else if(Character.isLetter(ultimo)){     //Verifico si el ultimo es una letra
                        return "Infija";
                    }else{
                        switch(ultimo){
                            case '^':
                            case '/':
                            case '*':
                            case '+':
                            case '-':
                                return "Polaca inversa";
                            default:
                                return "La notacion es incorrecta";
                        }
                    }
                }else if(Character.isLetter(expresion.charAt(0))){
                    if(Character.isDigit(ultimo)){
                        return "Infija";
                    }else if(Character.isLetter(ultimo)){
                        return "Infija";
                    }else{
                        switch(ultimo){
                            case '^':
                            case '/':
                            case '*':
                            case '+':
                            case '-':
                                return "Polaca inversa";
                            default:
                                return "La notacion es incorrecta";
                        }
                    }    
                }else{
                    switch(expresion.charAt(0)){
                    case '^':
                    case '/':
                    case '*':
                    case '+':
                    case '-':
                        return "Polaca";
                    default:
                        return "notacion incorrecta";
                    } 
            
                }
        }else if(count != 0 && count==count2){
             
//            if(Character.isDigit(expresion.charAt(0))){
//                char ultimo = expresion.charAt(expresion.length()-1);
//                char penultimo = expresion.charAt(expresion.length()-2);
//                if(Character.isDigit(ultimo)){
//                    return"Infija";
//                }else if(Character.isLetter(ultimo)){
//                    return "Infija";
//                }else if(ultimo == ')'){
//                    if(Character.isDigit(penultimo)){
//                        return "Infija";
//                    }else if(Character.isLetter(penultimo)){
//                        return "Infija";
//                    }else{
//                        return "Notacion equivocada";
//                    }
//                }
//            }else if (Character.isLetter(expresion.charAt(0))){
//               char ultimo = expresion.charAt(expresion.length()-1);
//                char penultimo = expresion.charAt(expresion.length()-2);
//                if(Character.isDigit(ultimo)){
//                    return"Infija";
//                }else if(Character.isLetter(ultimo)){
//                    return "Infija";
//                }else if(ultimo == ')'){
//                    if(Character.isDigit(penultimo)){
//                        return "Infija";
//                    }else if(Character.isLetter(penultimo)){
//                        return "Infija";
//                    }else{
//                        return "Notacion equivocada";
//                    }
//                }
//            }else if(expresion.charAt(0)=='('){
//                char segundo = expresion.charAt(1);
//                if(Character.isDigit(segundo)){
//                    return "Infijo";
//                }else if (Character.isLetter(segundo)){
//                    return"Infijo";
//                }else{
//                    return "Notacion invalida";
//                }
//                
//            }
//            
        }
        return null; 
    }
        return null;
    }   
    
}


    
    

