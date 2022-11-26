/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2.diego;

/**
 *
 * @author digio
 */
public class Funciones {
    
    public String expresion;
    Pila E = new Pila();
    Pila P = new Pila();
    Pila S = new Pila();

    public Funciones (String x){
        this.expresion = x;
    }
    
    public void EsInfijo(){
        
    }
    
    public void EsPreFijo(){
    
    }
    
    public void EsPostFijo(){
    
    }
    
    
    
    
    
    
//    public String infijoToPrefijo(){
//        String salida = "";
//        String aux = "";
//        String temp = "";
//        
//        for (int i = expresion.length() - 1; i >= 0; i++) {
//            aux += expresion.charAt(i);
//        }
//        
//        for (int i = 0; i < aux.length(); i++) {
//            if (aux.charAt(i) >= '0' & aux.charAt(i) <= '9') {
//                temp += aux.charAt(i);
//            }
//            if (aux.charAt(i) >= '*' & aux.charAt(i) <= '/') {
//                pila.Apilar(aux.charAt(i));
//            }
//            if (aux.charAt(i) == ')') {
//                temp += pila.Desapilar();
//            }
//        }
//        
//        while(!pila.IsEmpty()){
//            salida += pila.Desapilar();
//        }
//        
//        for (int i = temp.length() - 1; i >= 0; i++) {
//            salida += temp.charAt(i);
//        }
//        
//        return salida;
//  
//    }
    
//    public Pila infijoToPostfijo(){
//        
//        
//
//        for (int i = 0; i < expresion.length(); i++) {
//            char c = expresion.charAt(i);
//            E.push(c);
//        }
//        
//        
//        while(!E.IsEmpty()){
//            if (!isOperator((String)E.Cima())) {
//                S.push(E.Desapilar());
//            }else{
//                if (E.Desapilar() == "(") {
//                    P.push(E.Desapilar());
//                }else if(E.Desapilar() == ")"){
//                    while(E.Desapilar() != "("){
//                        S.push(E.Desapilar());
//                    }
//                    E.Desapilar();
//                }else if(isOperator((String)E.Cima())){
//                    while((char)P.Cima() >= prioridad((char)E.Cima())){
//                        S.push(P.Desapilar());
//                    }
//                    P.Apilar(E.Desapilar());
//                }else{
//                    S.push(E.Desapilar());
//                }
//            }
//        }
//        return S;
//        
//    }
    
    
//    public String infijaToPostfija(){
//        String salida = "";
//        Pila stack = new Pila();
//        
//        for (int i = 0; i < expresion.length(); i++) {
//            char c = expresion.charAt(i);
//
//            if (prioridad(c) > 0) {
//                while(!stack.IsEmpty() && prioridad((char)stack.Cima()) >= prioridad(c)){
//                    if (stack.Desapilar() != "(") {
//                        salida += stack.Desapilar();
//                    }
//                    
//                }
//                stack.Apilar(c);
//            }else if(c == ')'){
//                char x = (char)stack.Desapilar();
//                while(x != '('){
//                    salida += x;
//                    x = (char)stack.Desapilar();
//                }
//            }else if(c == '('){      
//                stack.Apilar(c);
//            }else{
//                if (c != '(') {
//                
//                    salida += c;
//                }
//                
//            }
//        }
//        
//        for (int i = 0; i <= stack.size(); i++) {
//            salida += stack.Desapilar();
//        }
//        return salida;
//
//    }
    
    
    
//    private String depurar(String s){
//        s = s.replaceAll("\\s+", "");
//        s = "(" + s + ")";
//        String simbols = "+-*/()";
//        String str = "";
//        
//        for (int i = 0; i < s.length(); i++) {
//            if (simbols.contains("" + s.charAt(i))) {
//                str += " " + s.charAt(i);
//            }else{
//                s += s.charAt(i);
//            }
//        }
//        return str.replaceAll("\\s+", " ");
//    }
    
//    public boolean isOperator(String c){
//        if (c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-") || c.equals("^") || c.equals("(") || c.equals(")")) {
//            return true;
//        }else{
//            return false;
//        }
//    }       
    
//    public int prioridad(char x){
//        switch (x){
//            case '+':
//            case '-':
//                return 3;
//            case '*':
//            case '/':
//                return 4;
//            case '^':
//                return 5;
//            case ')':
//                return 2;
//            case '(':
//                return 6;
//          
//        }
//        return 0;
//         
//    }
//    
//public static int prioridadExp(char x) { //se le aasigna la prioridad a cada operador de la expresion
//        if (x == '^') {
//            return 4;
//        }
//        if (x == '*' || x == '/') {
//            return 2;
//        }
//        if (x == '+' || x == '-') {
//            return 1;
//        }
//        if (x == '(') {
//            return 5;
//        }
//        if (x == ')') {
//            return 5;
//        }
//        return 0;
//    }

//    public static int prioridadPila(char x) { //se le asigna prioridad a cada operador de la pila 
//        if (x == '^') {
//            return 3;
//        }
//        if (x == '*' || x == '/') {
//            return 2;
//        }
//        if (x == '+' || x == '-') {
//            return 1;
//        }
//        if (x == '(') {
//            return 0;
//        }
//        if (x == ')') {
//            return 0;
//        }
//        return 0;
//    }

//    public static boolean esOperador(char letra) {
//        if (letra == '*' || letra == '/' || letra == '+' || letra == '-' || letra == '^' || letra == '(' || letra == ')') {
//            return true;         //se compara letra con cada uno de los operadores 
//        } else {
//            return false;
//        }
//    }
    

   
    
    
}
