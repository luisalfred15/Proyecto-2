/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author moise
 */
public class Interfaz extends javax.swing.JFrame {

    ListaSimple expresion = new ListaSimple();
    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Cargartxt = new javax.swing.JButton();
        CargarArchivo_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Expresion = new javax.swing.JTextArea();
        TITULO_CargarNotacion = new javax.swing.JLabel();
        MostrarNotacion = new javax.swing.JButton();
        TITULO_MostrarABB = new javax.swing.JLabel();
        MostrarABB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cargartxt.setText("...");
        Cargartxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargartxtActionPerformed(evt);
            }
        });
        jPanel1.add(Cargartxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 90, 50));

        CargarArchivo_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarArchivo_txtActionPerformed(evt);
            }
        });
        jPanel1.add(CargarArchivo_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, 20));

        Expresion.setColumns(20);
        Expresion.setRows(5);
        jScrollPane1.setViewportView(Expresion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, 60));

        TITULO_CargarNotacion.setText("Mostrar Tipo de Notación");
        jPanel1.add(TITULO_CargarNotacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        MostrarNotacion.setText("Cargar");
        MostrarNotacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarNotacionActionPerformed(evt);
            }
        });
        jPanel1.add(MostrarNotacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, 20));

        TITULO_MostrarABB.setText("Mostrar Arbol");
        jPanel1.add(TITULO_MostrarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 80, 20));

        MostrarABB.setText("Mostrar");
        MostrarABB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarABBActionPerformed(evt);
            }
        });
        jPanel1.add(MostrarABB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 80, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarArchivo_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarArchivo_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarArchivo_txtActionPerformed

    private void CargartxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargartxtActionPerformed
        JFileChooser fc = new JFileChooser();
        
        int op = fc.showOpenDialog(this);
        
        if (op == JFileChooser.APPROVE_OPTION){
            File fichero = fc.getSelectedFile();
            
            this.CargarArchivo_txt.setText(fichero.getAbsolutePath());
            
            try(FileReader fr = new FileReader(fichero)){
                String cadena = "";
                int valor = fr.read();
                while (valor != -1){
                    cadena = cadena + (char) valor;
                    valor = fr.read();
                }
                if (!"".equals(cadena)){
                    String[] expresion_split = cadena.split("");
                    for (String expresion_split1 : expresion_split) {
                        expresion.InsertarFinal(expresion_split1);
                    }
                }
                this.Expresion.setText(cadena);
            }catch (IOException el){
                el.printStackTrace();
            }
        }
    }//GEN-LAST:event_CargartxtActionPerformed

    private void MostrarNotacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarNotacionActionPerformed
        if(!expresion.EsVacio()){
            JOptionPane.showMessageDialog(null, expresion.Notacion());
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }//GEN-LAST:event_MostrarNotacionActionPerformed

    private void MostrarABBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarABBActionPerformed
        if(!expresion.EsVacio()){
            if("Infija".equals(expresion.Notacion())){
                Conversion conver = new Conversion();
                String exp = conver.covertInfixToPostfix(expresion.Transformar());
                
            }else if("Polaca Inversa".equals(expresion.Transformar())){
                Conversion conver2 = new Conversion();
                String exp2 = conver2.convertPrefixToInfix(expresion.Transformar());
                String exp3 = conver2.covertInfixToPostfix(exp2);
                
            }else if("Polaca".equals(expresion.Transformar())){
                
            }else{
                JOptionPane.showMessageDialog(null, "La lista esta vacia");
            }
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }//GEN-LAST:event_MostrarABBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CargarArchivo_txt;
    private javax.swing.JButton Cargartxt;
    private javax.swing.JTextArea Expresion;
    private javax.swing.JButton MostrarABB;
    private javax.swing.JButton MostrarNotacion;
    private javax.swing.JLabel TITULO_CargarNotacion;
    private javax.swing.JLabel TITULO_MostrarABB;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
