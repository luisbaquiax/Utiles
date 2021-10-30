/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.archivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.*;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Luis
 */
public class ManejoArchivo {

    private JFileChooser choser;
    public static final String FILTRO = ".txt";

    public String pathChoserSave() {

        choser = new JFileChooser();
        choser.addChoosableFileFilter(new FileNameExtensionFilter("Persona", "txt"));
        choser.setAcceptAllFileFilterUsed(false);
        int seleccionado = choser.showSaveDialog(null);
        if (seleccionado == APPROVE_OPTION) {
            return (choser.getSelectedFile().getAbsolutePath());
        }
        return "";
    }

    public String pathChoserOpen() {
        choser = new JFileChooser();
        choser.addChoosableFileFilter(new FileNameExtensionFilter("Persona", "txt"));
        choser.setAcceptAllFileFilterUsed(false);
        int seleccionado = choser.showOpenDialog(null);
        if (seleccionado == APPROVE_OPTION) {
            return (choser.getSelectedFile().getAbsolutePath());
        }
        return "";
    }

    public void escribirObjeto(String filepath, Object persona) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(persona);
            objectOut.close();
            System.out.println("Se ha escrito el objeto");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Object leerObejtodelAarchivo(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();
            System.out.println("Se ha leido el objeto");
            objectIn.close();
            return obj;

        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public ArrayList<Persona> personas(String path) {
        try {
            ObjectInputStream flujoSalida = new ObjectInputStream(new FileInputStream(path));
            Object salida = flujoSalida.readObject();
            flujoSalida.close();
            return (ArrayList<Persona>) salida;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void escribirArchivodeTexto(String ruta, String contenido) {
        try {
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter escribeArchivo = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(escribeArchivo);
            bw.write(contenido);
            bw.close();
        } catch (IOException e) {
        }
    }

    public void leerArchivo() throws FileNotFoundException, IOException {
//        JFileChooser choser = new JFileChooser();
//        choser.addChoosableFileFilter(new  FileNameExtensionFilter("documento Luis", "txt"));
//        choser.setAcceptAllFileFilterUsed(false);
//        int selecionado = choser.showOpenDialog(null);
//        File archivo = choser.getSelectedFile();
//        FileReader leerArchivo = new FileReader(archivo.getAbsoluteFile());
//        BufferedReader leyendo = new BufferedReader(leerArchivo);//para leer linea por linea
//        String linea = "";
//        while (leyendo.ready()) {
//            linea = leyendo.readLine();
//            System.out.println("Cada linea");
//            System.out.println(linea);
//            
//        }

        /**
         * CREAR CARPETA PRUEBA
         */
        JFileChooser choser = new JFileChooser();
        String nameCarpeta = JOptionPane.showInputDialog(null, "Ingrese el nombre de la carptea", "CARPETA", JOptionPane.INFORMATION_MESSAGE);

        File carpeta = new File("C:\\Users\\Usuario\\OneDrive\\Documentos\\" + nameCarpeta);
        if (carpeta.mkdir()) {
            System.out.println("creado");
            System.out.println(carpeta.getAbsolutePath());
        } else {
            System.out.println("no creado");
            System.out.println(carpeta.getAbsolutePath());
        }
    }
}
