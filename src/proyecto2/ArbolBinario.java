/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author luisa
 */
public class ArbolBinario {
    
    private NodoArbol nodoRaiz;
    
    public ArbolBinario() {
        this.nodoRaiz = null;
    }
    
    public boolean esVacio() {
        return this.getNodoRaiz() == null;
    }
    
    public void vaciar() {
        this.setNodoRaiz(null);
    }
    
    public NodoArbol buscarPadre(NodoArbol nodoRaiz, Object datos) {
        NodoArbol nodoEncontrado = null;
        if (nodoRaiz.getDatos() == datos) {
            return nodoRaiz;
        }
        if (nodoRaiz.getNodoHijoIzq() != null && nodoEncontrado == null) {
            nodoEncontrado = buscarPadre(nodoRaiz.getNodoHijoIzq(), datos);
        }
        if (nodoRaiz.getNodoHijoDer() != null && nodoEncontrado == null) {
            nodoEncontrado = buscarPadre(nodoRaiz.getNodoHijoDer(), datos);
        }
        return nodoEncontrado;
    }
    
    public void agregarNodo(NodoArbol nodoNuevo, Object datosPadre, String lado) {
        if (this.esVacio()) {
            this.setNodoRaiz(nodoNuevo);
        } else {
            NodoArbol nodoPadre = buscarPadre(this.getNodoRaiz(), datosPadre);
            if (nodoPadre == null) {
                System.out.println("El nodo no existe");
            } else if (nodoPadre.getNodoHijoIzq() == null && lado == "izquierda") {
                nodoPadre.setNodoHijoIzq(nodoNuevo);
            } else if (nodoPadre.getNodoHijoDer() == null && lado == "derecha") {
                nodoPadre.setNodoHijoDer(nodoNuevo);
            } else {
                System.out.println("Espacios de hijos ocupados");
            }
        }
    }

    /**
     * @return the nodoRaiz
     */
    public NodoArbol getNodoRaiz() {
        return nodoRaiz;
    }

    /**
     * @param nodoRaiz the nodoRaiz to set
     */
    public void setNodoRaiz(NodoArbol nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }
    
    
}
