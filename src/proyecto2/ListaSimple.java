/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import javax.swing.JOptionPane;

/**
 * Clase de la lista simple
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
    public boolean EsVacio() {
        return this.pFirst == null;
    }

    //Metodo que vacia la lista
    public void vaciar() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    //Metodo para retornar la posicion de un nodo
    public int getIndex(Nodo nodito) {
        if (!EsVacio()) {
            Nodo aux = pFirst;
            int count = 0;
            while (aux != null) {

                if (nodito == aux) {
                    return count;     //posicion en memoria del nodo
                }
                count++;
                aux = aux.getPnext();
            }
            return -1;
        }
        return -1;
    }

    // Funcion para buscar un elemento en la lista
    public boolean buscar(Object referencia) {
        Nodo aux = pFirst;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (referencia == aux.getDato()) {
                encontrado = true;
            } else {
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }

    //Metodo para Insertar por referencia
    public void insertarPorReferencia(Object ref, Object valor) {

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
    public void insrtarPorPosicion(int posicion, Object valor) {
        if (posicion >= 0 && posicion <= size) {
            Nodo nuevo = new Nodo();
            nuevo.setDato(valor);
            // Consulta si el nuevo nodo a ingresar va al inicio de la lista.
            if (posicion == 0) {
                nuevo.setPnext(pFirst);
                pFirst = nuevo;
            } else {
                // Si el nodo a inserta va al final de la lista.
                if (posicion == size) {
                    Nodo aux = pFirst;

                    // Recorre la lista hasta llegar al ultimo nodo.
                    while (aux.getPnext() != null) {
                        aux = aux.getPnext();
                    }

                    // Inserta el nuevo nodo despues de del ultimo.
                    aux.setPnext(nuevo);
                } else {
                    // Si el nodo a insertar va en el medio de la lista.
                    Nodo aux = pFirst;
                    // Recorre la lista hasta llegar al nodo anterior
                    // a la posicion en la cual se insertara el nuevo nodo.
                    for (int i = 0; i < (posicion - 1); i++) {
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
    public void InsertarFinal(Object dato) {

        Nodo pNew = new Nodo(dato);

        if (EsVacio()) {
            pFirst = pNew;
            pLast = pNew;

        } else {
            Nodo aux = pLast;
            aux.setPnext(pNew);
            pLast = pNew;
        }
        size++;
    }

    //Metodo para insertar al inicio
    public void InsertarInicio(Object dato) {

        Nodo pNew = new Nodo();
        pNew.setPnext(pNew);

        if (EsVacio()) {

            pFirst = pNew;

        } else {
            pNew.setPnext(pFirst);
            pFirst = pNew;
        }
        size++;
    }

    public String ImprimirPorFrame() {
        String ElementosDeLaLista = "nada";
        if (EsVacio()) {
            JOptionPane.showMessageDialog(null, "No hay elementos para mostrar");
        } else {
            String dato1 = pFirst.getDato().toString();
            ElementosDeLaLista = dato1;
            Nodo aux = pFirst.getPnext();
            for (int i = 0; i < size; i++) {
                String dato2 = aux.getDato().toString();   //convertimos lo que almacena el nodo a String para poder guardarlo en una cadena de caracteres y asi mostrarlo
                ElementosDeLaLista += "," + dato2;
                aux = aux.getPnext();
            }
        }
        return ElementosDeLaLista;
    }

    public void mostrar() {
        if (!EsVacio()) {
            Nodo aux = pFirst;
            String expresion = "";
            for (int i = 0; i < size; i++) {
                expresion += aux.getDato().toString();
                aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null, expresion);

        } else {
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }

    //Funcion para eliminar al inicio
    public boolean Eliminar_Inicio() {
        if (!EsVacio()) {
            pFirst = pFirst.getPnext();
            size--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para transformar una lista en cadena de caracteres
     *
     * @author: moise
     * @return: expresión en forma de String
     */
    public String Transformar() {
        if (!EsVacio()) {

            Nodo aux = pFirst;
            String expresion = "";

            for (int i = 0; i < size; i++) {
                expresion += aux.getDato().toString();
                aux = aux.getPnext();
            }
            return expresion;
        }
        return "Lista vacia";
    }

    /**
     * Metodolo para que los caracteres que contega la expresion son validos
     *
     * @author: moise
     * @return: opciones de acuerdo al símbolo
     */
    private int Simbolo_Correcto() {
        if (!EsVacio()) {
            String lista = this.Transformar();
            Pila PilaInc = new Pila();
            for (int i = 0; i < lista.length(); i++) {
                switch (lista.charAt(i)) {
                    case '^':
                    case '/':
                    case '*':
                    case '+':
                    case '-':
                    case '(':
                    case ')':
                        break;
                    default:
                        if (Character.isDigit(lista.charAt(i)) || Character.isLetter(lista.charAt(i))) {
                            break;
                        } else {
                            PilaInc.apilar(lista.charAt(i));
                        }
                }
            }
            if (PilaInc.esVacia()) {   //Los caracteres son validos
                return 1;
            } else {                   //Existe al menos un caracer invalido
                return 0;
            }
        } else {
            return 2;                //La lista es vacia
        }
    }

    /**
     * Evaluar sin contiene o no parentesis
     *
     * @author: moise
     * @return: opciones de acuerdo a los paréntesis
     */
    private int Parentesis() {
        if (!EsVacio() && Simbolo_Correcto() == 1) {
            String lista = this.Transformar();

            //Verificar si la expresion tiene paréntesis
            int count = 0;     //Contador de parentesis izquierdo
            int count2 = 0;    //Contador de parentesis derecho

            //Recorro la expresion para contar los parentesis
            char caracter_evaluar;
            for (int i = 0; i < lista.length(); i++) {
                caracter_evaluar = lista.charAt(i);
                switch (caracter_evaluar) {
                    case '(':
                        count++;
                        break;
                    case ')':
                        count2++;
                        break;
                }
            }
            if (count == 0 && count == count2) {    //No contiene parentesis
                return 0;
            } else if (count == count2) {             //Contiene parentesis
                return 1;
            } else {
                return 2;             //Falta algún parentesis en la expresion
            }
        } else {
            return 3;                //La lista es vacia o existe un caracter invalido                     
        }
    }

    /**
     * Metodo para evaluar la distribucion de los caracteres que contiene la
     * expresion
     *
     * @author: moise
     * @return: opciones de acuerdo a la forma del símbolo
     */
    private String Form_Simbolo() {
        if (!EsVacio() && Simbolo_Correcto() == 1) {
            String expresion = this.Transformar();
            Pila PilaVerif = new Pila();
            switch (this.Parentesis()) {
                case 0:
                case 1:
                    for (int i = 0; i < expresion.length(); i++) {
                        char caract_evaluar = expresion.charAt(i);
                        if (Character.isDigit(caract_evaluar) || Character.isLetter(caract_evaluar)) {
                            PilaVerif.apilar(caract_evaluar);
                        } else if (caract_evaluar == '(') {
                            if (expresion.charAt(i + 1) == '-' || Character.isDigit(expresion.charAt(i + 1)) || Character.isLetter(expresion.charAt(i + 1))) {
                                PilaVerif.apilar(caract_evaluar);
                            } else {
                                PilaVerif.apilar(caract_evaluar);
                                PilaVerif.apilar('S');
                            }
                        } else if (caract_evaluar == ')') {
                            if (Character.isDigit(expresion.charAt(i - 1)) || Character.isLetter(expresion.charAt(i - 1))) {
                                PilaVerif.apilar(caract_evaluar);
                            } else {
                                PilaVerif.apilar(caract_evaluar);
                                PilaVerif.apilar('S');
                            }
                        } else {
                            if (PilaVerif.esVacia()) {
                                PilaVerif.apilar(caract_evaluar);
                            } else {
                                if (Character.isDigit((char) PilaVerif.cima())) {
                                    PilaVerif.apilar(caract_evaluar);
                                } else if (Character.isLetter((char) PilaVerif.cima())) {
                                    PilaVerif.apilar(caract_evaluar);
                                } else if ((char) PilaVerif.cima() == '(' || (char) PilaVerif.cima() == ')') {
                                    PilaVerif.apilar(caract_evaluar);
                                } else {
                                    PilaVerif.quitar();
                                }
                            }
                        }
                    }
                    if (PilaVerif.getTamanio() == expresion.length()) {   //Notacion Infija
                        PilaVerif.destruir();
                        return "1";
                    } else if (PilaVerif.getTamanio() > expresion.length()) {  //Error de Notacion
                        PilaVerif.destruir();
                        return "-1";
                    } else if (PilaVerif.getTamanio() < expresion.length()) {    //Simbolos juntos
                        PilaVerif.destruir();
                        return "0";
                    }
            }
        }
        return null;
    }

    /**
     * Metodo que retorna el tipo de notacion
     *
     * @author: moise
     * @return: tipo de notación de acuerdo a la expresión
     */
    public String Notacion() {
        if (!EsVacio() && Simbolo_Correcto() == 1) {
            String expresion = this.Transformar();
            char inicio = expresion.charAt(0);
            char ultimo = expresion.charAt(expresion.length() - 1);
            if (3 == this.Parentesis()) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia.");
            } else {
                switch (this.Parentesis()) {
                    case 1:
                        switch (Form_Simbolo()) {
                            case "1":
                                if (Character.isDigit(inicio) || Character.isLetter(inicio) || inicio == '-' || inicio == '(') {
                                    if (Character.isDigit(ultimo) || Character.isLetter(ultimo) || ultimo == ')') {
                                        return "Infija";
                                    } else {
                                        return "Notacion incorrecta";
                                    }
                                }
                            default:
                                return "Notacion incorrecta";
                        }

                    case 0:
                        switch (Form_Simbolo()) {
                            case "1":
                            case "0":
                                switch (expresion.charAt(0)) {
                                    case '^':
                                    case '/':
                                    case '*':
                                    case '+':
                                    case '-':
                                        if (Character.isDigit(expresion.charAt(expresion.length() - 1)) || Character.isLetter(expresion.charAt(expresion.length() - 1))) {
                                            return "Polaca";
                                        } else {
                                            return "Error de notación";
                                        }

                                    default:
                                        if (Character.isDigit(expresion.charAt(0)) || Character.isLetter(expresion.charAt(0))) {
                                            switch (expresion.charAt(expresion.length() - 1)) {
                                                case '^':
                                                case '/':
                                                case '*':
                                                case '+':
                                                case '-':
                                                    return "Polaca Inversa";
                                                default:
                                                    return "Error de notacion";
                                            }
                                        } else if ((Character.isDigit(inicio) || Character.isLetter(inicio) || inicio == '-') && (Character.isDigit(ultimo) || Character.isLetter(ultimo))) {
                                            return "Infija";
                                        } else {
                                            return "Error de notación";
                                        }
                                }
                        }
                    default:
                        JOptionPane.showMessageDialog(null, "Faltan algún parentesis en la expresion");
                }
            }
        } else {
            return "Hay un caracter invalido o la Lista se encuentra vacía";
        }
        return null;
    }

    /**
     * Metodo que da valor a los operadores dentro de una expresion
     *
     * @author: moise
     * @param c: operador a evaluar
     * @return: prioridad
     */
    private int prioridad(char c) {
        int p = 100;
        switch (c) {
            case '^':    // La potencia es lo que más tiene prioridad
                p = 30;    // Se le asigna un valor 
                break;
            /*
                La multiplicación y la divisón tienen el mismo orden de prioridad
                entonces en ambos casos le asigno el mismo valor de prioridad,
                como debe ser menor al valor de prioridad de la potencia,
                le asigno 20
             */
            case '*':
            case '/':
                p = 20;
                break;

            /*
                La suma y la resta tienen el mismo orden de prioridad
                entonces en ambos casos le asigno el mismo valor de prioridad,
                como debe ser menor al valor de prioridad de la multiplicación y
                de la división, le asigno 10
             */
            case '+':
            case '-':
                p = 10;
                break;

            default:
                p = 0; // asumimos que lo que tenemos dentro de la pila tendrá un valor de 0

        }

        return p;
    }

    /**
     * Metodo para Traducir de Infijo a Posfijo
     *
     * @author: moise
     * @return: expresión posfija
     */
    public String TraducInf() {
        if ("Infija".equals(this.Notacion())) {
            Pila PilaTraduc = new Pila();
            ListaSimple ListaSalida = new ListaSimple();
            while (!EsVacio()) {
                Object element = pFirst.getDato();
                String s = (String) element;
                this.Eliminar_Inicio();
                if (Character.isDigit(s.charAt(0)) || Character.isLetter(s.charAt(0))) {
                    ListaSalida.InsertarFinal(element);
                } else {
                    switch (s.charAt(0)) {
                        case '(':
                            PilaTraduc.apilar(element);
                        case ')':
                            Object e = PilaTraduc.cima();
                            String cima = (String) e;
                            while (!PilaTraduc.esVacia() && cima.charAt(0) != '(') {
                                PilaTraduc.quitar();
                                ListaSalida.InsertarFinal(e);
                            }
                            if (!PilaTraduc.esVacia() && cima.charAt(0) == '(') {
                                PilaTraduc.quitar();
                            }
                        case '^':
                        case '/':
                        case '*':
                        case '+':
                        case '-':
                            Object e2 = PilaTraduc.cima();
                            String cima2 = (String) e2;
                            while (!PilaTraduc.esVacia() && prioridad(cima2.charAt(0)) >= prioridad(s.charAt(0))) {
                                PilaTraduc.quitar();
                                ListaSalida.InsertarFinal(element);
                            }
                            PilaTraduc.apilar(element);
                    }
                }
            }
            while (!PilaTraduc.esVacia()) {
                Object element2 = PilaTraduc.cima();
                PilaTraduc.quitar();
                ListaSalida.InsertarFinal(element2);
            }
            PilaTraduc.destruir();
            String expresion = ListaSalida.Transformar();
            return expresion;
        } else {
            return "La notación no es correcta";
        }
    }

    /**
     * Conversión de notación posfija en árbol
     *
     * @author: luisa
     * @return: árbol de expresión
     */
    public ArbolBinario conversionPosfijaEnArbol() {
        Pila pilaExpresion = new Pila();
        ArbolBinario arbolExpresion;

        while (!this.EsVacio()) {
            NodoArbol termino = new NodoArbol(this.getpFirst().getDato());
            ArbolBinario arbolTermino = new ArbolBinario();
            arbolTermino.agregarNodo(termino, null, "");
            this.Eliminar_Inicio();
            switch (Funciones.evaluarElemento(termino.getDatos())) {
                case "numero":
                    pilaExpresion.apilar(arbolTermino);
                    break;
                case "variable":
                    pilaExpresion.apilar(arbolTermino);
                    break;
                case "arbol":
                    pilaExpresion.apilar(arbolTermino);
                    break;
                case "operador":
                    ArbolBinario arbolElemento1 = (ArbolBinario) pilaExpresion.cima();
                    pilaExpresion.quitar();

                    ArbolBinario arbolElemento2 = (ArbolBinario) pilaExpresion.cima();
                    pilaExpresion.quitar();

                    ArbolBinario arbolAux = new ArbolBinario();
                    NodoArbol nodoRaiz = termino;
                    arbolAux.agregarNodo(nodoRaiz, null, "");
                    NodoArbol nodoDer = arbolElemento1.getNodoRaiz();
                    arbolAux.agregarNodo(nodoDer, nodoRaiz.getDatos(), "derecha");
                    NodoArbol nodoIzq = arbolElemento2.getNodoRaiz();
                    arbolAux.agregarNodo(nodoIzq, nodoRaiz.getDatos(), "izquierda");
                    pilaExpresion.apilar(arbolAux);
                    break;
            }
        }
        arbolExpresion = (ArbolBinario) pilaExpresion.cima();
        return arbolExpresion;
    }
}
