/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

import javax.swing.JOptionPane;

/**
 *
 * @author moise
 */
public class PROYECTO2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funciones func = new Funciones();
        ListaSimple expresion = func.Leer_txt();
        Conversion conver = new Conversion();
        String exp = conver.covertInfixToPostfix(expresion.Transformar());
        
        expresion.mostrar();
        
        JOptionPane.showMessageDialog(null, exp);
//          Interfaz ventana = new Interfaz();
//          ventana.setVisible(true);

        
    }
}
