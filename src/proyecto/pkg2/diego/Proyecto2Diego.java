/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg2.diego;

import javax.swing.JFrame;

public class Proyecto2Diego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        String expression = "(3*x^2+2*x*y^2+8*y^3)/(8*x^3+3*x^2*y^2)";
//        String expression2 = "/++*3^x2**2x^y2*8^y3+*8^x3**3^x2^y2";
//        Conversion c = new Conversion();
//        
//        System.out.println(c.convertPrefixToInfix(expression2));
//        System.out.println(c.covertInfixToPostfix(c.convertPrefixToInfix(expression2)));

        //PATRON MVC
        ArbolBinario tree = new ArbolBinario(new NodoArbolBinario(10)); //MODELO
        Lienzo objLienzo = new Lienzo(); //VISTA
        Controlador objControlador = new Controlador(objLienzo, tree); //CONTROLADOR
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //INSERTAR Y PINTAR ARBOL
        tree.insertarIzq(5, tree.Raiz());
        tree.insertarDer(8, tree.Raiz());
        tree.insertarIzq(7, tree.Buscar(tree.Raiz(),5));
        tree.insertarDer(3, tree.Buscar(tree.Raiz(),5));
        tree.insertarDer(2, tree.Buscar(tree.Raiz(),8));
        
        objControlador.iniciar();
        //= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
        //MOSTRAR LIENZO EN UNA VENTANA TODO
        JFrame ventana = new JFrame();
        ventana.getContentPane().add(objLienzo);
        ventana.setDefaultCloseOperation(3);
        ventana.setSize(600, 600);
        ventana.setVisible(true);
        //= = = = = = = = 
        
    
       
        
    
        
            
        
    }
    
}
