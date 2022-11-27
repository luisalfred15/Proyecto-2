/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg2.diego;

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
        pintar(g, getWidth() / 2, 20, objArbol.proot);
    }
    
    private void pintar(Graphics g, int x, int y, NodoArbolBinario n) {
        if (n == null)
        {}
        else {
            int EXTRA = n.nodosCompletos(n) * (ANCHO / 2);
            g.drawOval(x, y, DIAMETRO, DIAMETRO);
            g.drawString(n.data.toString(), x + 12, y + 18);
            if (n.HijoIzq != null)
                g.drawLine(x + RADIO, y + RADIO, x - ANCHO - EXTRA + RADIO, y + ANCHO + RADIO);
            if (n.HijoDer != null)
                g.drawLine(x + RADIO, y + RADIO, x + ANCHO + EXTRA + RADIO, y + ANCHO + RADIO);
            pintar(g, x - ANCHO - EXTRA, y + ANCHO, n.HijoIzq);
            pintar(g, x + ANCHO + EXTRA, y + ANCHO, n.HijoDer);
        }
    }
}
