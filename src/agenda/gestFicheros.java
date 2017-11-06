/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase contiene los metodos que trabajan con los ficheros
 * 
 * @author death
 */
public class gestFicheros {
    
    /**
     * Metodo para escribir una nueva linea de texto en el fichero
     * @param frase corresponde al String que se irà a escribir en el fichero
     */
    
    public void escribir(String frase){
        BufferedWriter fichero2 = null;
        try {
            // TODO add your handling code here:
            fichero2 = new BufferedWriter(new FileWriter("logs.txt", true));
            fichero2.write(frase);
            fichero2.newLine();
            fichero2.close();
        } catch (IOException ex) {
            System.out.println("Error!!!!");
        } finally {
            try {
                fichero2.close();
            } catch (IOException ex) {
                System.out.println("Error!!!!");
            }
        }
    }
    
    /**
     * Metodo utilizado para leer del fichero
     * 
     * @return devuelve una String costruida por BufferedReader 
     */
    
    public String leer() {
        try {
            // TODO add your handling code here:
            BufferedReader fichero = null;
            StringBuilder texto = new StringBuilder();
            fichero = new BufferedReader(new FileReader("logs.txt"));
            String linea;
            try {
                while ((linea = fichero.readLine()) != null) {
                    texto.append(linea).append("\n");
                }
                return texto.toString();
            } catch (IOException ex) {
                System.out.println("Error!!!!");
            }
            fichero.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error!!!!");
        } catch (IOException ex) {
            System.out.println("Error!!!!");
        }
        return null;
    }
    
    /**
     * Metodo usado para detectar la fecha y hora y convertirlos en String
     * @return devuleve una String que contiene fecha y hora actual
     */
    
    public String logTime(){
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        String day="(Fecha y hora: ";
        String end=")";
        return day+timeStamp+end;
    }
}
