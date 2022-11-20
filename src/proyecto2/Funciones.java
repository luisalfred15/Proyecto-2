/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author moise
 */
public class Funciones {
    
    public void Escribir_txt(ListaSimple expresion){
        String expresion_actual = "";
        if(!expresion.EsVacio()){
            Nodo aux = expresion.getpFirst();
            for(int i = 0; i < expresion.getSize(); i++){
                expresion_actual += aux.getDato().toString();
                aux = aux.getPnext();
            }
        }
        try{
            PrintWriter pw = new PrintWriter("test\\expresion.txt");
            pw.print(expresion_actual);
            pw.close();
            JOptionPane.showMessageDialog(null, "Guardado exitoso");
        } catch (Exception err){
            JOptionPane.showMessageDialog(null, err);
        }       
    }
     public ListaSimple Leer_txt(){
        ListaSimple expresion = new ListaSimple();
        String line;
        String expresion_txt = "";
        String path = "test\\expresion.txt";
        File file = new File(path);
        try{
            if(!file.exists()){
               file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine())!= null){
                    if(!line.isEmpty()){
                        expresion_txt += line;
                    }
                }
                if (!"".equals(expresion_txt)){
                    String[] expresion_split = expresion_txt.split("\n");
                    for(int i =0;i < expresion_split.length;i++){
                        expresion.InsertarFinal(expresion_split[i]);
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null, "Lectura exitosa");
            }  
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al leer la expresion");
        }
        return expresion;
    }
    
    public void convertir_Inf_Pos(ListaSimple ListaEntrada){
        //Crear pila y la lista de salida, inicialmente vacias
        Pila PilaTraduc = new Pila();
        ListaSimple ListaSalida = new ListaSimple();
        
        
    }
     
//    public void convertir_inf_pos(ListaSimple ListaEntrada){
//        
//        //Crear pila y la lista de salida, inicialmente vacias
//        Pila PilaTraduc = new Pila();
//        ListaSimple ListaSalida = new ListaSimple();
//       
//        while(!ListaEntrada.EsVacio()){
//            Nodo aux = ListaEntrada.getpFirst();
//            Object primer_element = aux.getDato();
//            String str = new String((String) primer_element);
//            if(Character.isDigit(str.charAt(0))){
//                ListaSalida.InsertarFinal(primer_element);
//            }else if(Character.isLetter(str.charAt(0))){
//                ListaSalida.InsertarFinal(primer_element);
//            }else if(str.charAt(0) == '('){
//                PilaTraduc.apilar(primer_element);
//            }else if(str.charAt(0) == ')'){
//                char s = '(';
//                Object s1 = s;
//                while(!PilaTraduc.esVacia() && PilaTraduc.cima() != s1){
//                    PilaTraduc.quitar();
//                    ListaSalida.InsertarFinal(PilaTraduc.cima());
//                }
//                if(PilaTraduc.cima() == s1){
//                    PilaTraduc.quitar();
//                }else{
//                    JOptionPane.showMessageDialog(null, "Se ha detcetado un error.");
//                }   
//            }else{
//                int p;
//                switch(str.charAt(0)){
//                    case '^':
//                        p=50;
//                        break;
//                    case '/':
//                    case '*':
//                        p=30;
//                        break;
//                    case '+':
//                    case '-':
//                        p=20;
//                        break;
//                    default:
//                        p=0;
//                        break;
//                }
//                int q=0;
//                String str2 = new String((String)PilaTraduc.cima());
//                switch(str2.charAt(0)){
//                   case '^':
//                        q=50;
//                        break;
//                    case '/':
//                    case '*':
//                        q=30;
//                        break;
//                    case '+':
//                    case '-':
//                        q=20;
//                        break;
//                    default:
//                        q=0;
//                        break;
//                }
//                while(!PilaTraduc.esVacia() && q>=p){
//                    PilaTraduc.quitar();
//                    ListaSalida.InsertarFinal(primer_element);
//                }
//                PilaTraduc.apilar(primer_element);
//            }    
//        }
//        while(!PilaTraduc.esVacia()){
//            PilaTraduc.quitar();
//            ListaSalida.InsertarFinal(this);
//        }
//        PilaTraduc.destruir();
//        ListaSalida.mostrar();
//    }
}
