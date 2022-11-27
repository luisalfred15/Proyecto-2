/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2.diego;

/**
 *
 * @author digio
 */
public class Controlador {
    private Lienzo objLienzo; //VISTA
    private ArbolBinario objArbol; //MODELO

    public Controlador(Lienzo objLienzo, ArbolBinario objArbol) {
        this.objLienzo = objLienzo;
        this.objArbol = objArbol;
    }
    
    public void iniciar() {
        objLienzo.setObjArbol(objArbol);
    }
    
}
