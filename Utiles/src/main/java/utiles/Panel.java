/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Luis
 */
public class Panel extends JPanel {

    private Image imagen;
    private String ruta;

    public Panel(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(ruta).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

}
