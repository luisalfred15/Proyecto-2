/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author luisa
 */
public class NodoArbol {
    
    private Object datos;
    private NodoArbol nodoHijoIzq;
    private NodoArbol nodoHijoDer;
    
    public NodoArbol(Object datos) {
        this.datos = datos;
        this.nodoHijoDer = null;
        this.nodoHijoIzq = null;
    }

    /**
     * @return the datos
     */
    public Object getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(Object datos) {
        this.datos = datos;
    }

    /**
     * @return the nodoHijoIzq
     */
    public NodoArbol getNodoHijoIzq() {
        return nodoHijoIzq;
    }

    /**
     * @param nodoHijoIzq the nodoHijoIzq to set
     */
    public void setNodoHijoIzq(NodoArbol nodoHijoIzq) {
        this.nodoHijoIzq = nodoHijoIzq;
    }

    /**
     * @return the nodoHijoDer
     */
    public NodoArbol getNodoHijoDer() {
        return nodoHijoDer;
    }

    /**
     * @param nodoHijoDer the nodoHijoDer to set
     */
    public void setNodoHijoDer(NodoArbol nodoHijoDer) {
        this.nodoHijoDer = nodoHijoDer;
    }
    
    
}
