/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Luis
 */
public class Utiles {

    /**
     * Pone una imagen/icono a un JLabel
     *
     * @param label
     * @param ruta
     */
    public void ponerIconoLabel(JLabel label, String ruta) {
        ImageIcon icono1 = new ImageIcon(ruta);
        label.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(label.getSize().width,
                label.getSize().height, Image.SCALE_SMOOTH)));
    }

    /**
     * Ponde una imagen/icono a un JButoon
     *
     * @param button
     * @param ruta
     */
    public void ponerIconoButton(JButton button, String ruta) {
        ImageIcon icono1 = new ImageIcon(ruta);
        button.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(button.getSize().width,
                button.getSize().height, Image.SCALE_SMOOTH)));
    }

    /**
     * SE DEBE TENER UNA CARPETA LLAMADA << RESOURCER >> AL MISMO NIVEL QUE LA
     * CARPETA << JAVA >>
     *
     * @param label
     * @param ruta
     */
    public void ponerIconoLabel1(JLabel label, String ruta) {
        ImageIcon icono1 = new ImageIcon(getClass().getResource(ruta));
        label.setIcon(new ImageIcon(icono1.getImage().getScaledInstance(
                label.getSize().width, label.getSize().height, Image.SCALE_SMOOTH)));
    }
}
