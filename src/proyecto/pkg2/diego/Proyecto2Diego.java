/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg2.diego;



public class Proyecto2Diego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String expression = "(3*x^2+2*x*y^2+8*y^3)/(8*x^3+3*x^2*y^2)";
        String expression2 = "/++*3^x2**2x^y2*8^y3+*8^x3**3^x2^y2";
        Conversion c = new Conversion();
        
        System.out.println("Infija: " + expression);
        System.out.println("Polaca Inversa: " + c.covertInfixToPostfix(expression));
        System.out.println("Polaca: " + c.infixToPrefix(expression));
        
    
       
        
    
        
            
        
    }
    
}
