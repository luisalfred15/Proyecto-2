/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;


/**
 *
 * @author digio
 */
public class Lienzo extends JPanel {
    private ArbolBinario objArbol;
    public static final int DIAMETRO = 30;
    public static final int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public void setObjArbol(ArbolBinario objArbol) {
        this.objArbol = objArbol;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        pintar(g, getWidth() / 2, 20, objArbol.nodoRaiz);
    }
    
    private void pintar(Graphics g, int x, int y, NodoArbol n) {
        Font fuente=new Font("Arial", Font.BOLD, 20);
        if (n == null)
        {}
        else {
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.setColor(Color.WHITE);
            g.fillOval(x, y, DIAMETRO, DIAMETRO);
            g.setColor(Color.RED);
            g.setFont(fuente);
            g.drawString(n.getDatos().toString(), x + 12, y + 18);
            g.setColor(Color.BLACK);
            
            if (n.getNodoHijoIzq() != null)
                g.setColor(Color.BLACK);
                g.drawLine(x + RADIO, y + RADIO , x - ANCHO - EXTRA + RADIO , y + ANCHO + RADIO);
            if (n.getNodoHijoDer() != null)
                g.setColor(Color.BLACK);
                g.drawLine(x + RADIO , y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, n.getNodoHijoIzq());
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, n.getNodoHijoDer());
        }
    }
}
