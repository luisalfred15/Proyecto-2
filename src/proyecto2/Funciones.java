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
                    String[] expresion_split = expresion_txt.split("");
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
     
     public static String evaluarElemento(Object elemento) {
        if (elemento instanceof ArbolBinario) {
            return "arbol";
        } else if (Character.isLetter(String.valueOf(elemento).charAt(0))) {
            return "variable";
        } else if (Character.isDigit(String.valueOf(elemento).charAt(0))) {
            return "numero";
        } else {
            return "operador";
        }
    }
}
