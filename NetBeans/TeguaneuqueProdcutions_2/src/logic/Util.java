/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.Serializable;


/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 * 
 * Esta clase es la encargada comvertir las cadenas de caracteres a bytes 
 */
public class Util implements Serializable{
    
    /**
     * metodo convierte una cadena de caracteres en un vector de bytes
     * @param line cadena de caracteres que se va a pasar a un vector de bytes
     * @param size tamaño del vector del bytes
     * @return es el array de bytes que corresponde a la linea de caracteres
     */
    public static byte[] getStringByteArray(String line, int size) {
	        byte[] aux =  new byte[size];
	        for (int i = 0; i < line.length() && i <size; i++) {
	            aux[i] = (byte)line.charAt(i);
	        }
	        for (int i = line.length(); i < size; i++) {
	            aux[i] =(byte) ' ';
	        }
	        return aux;
    }

    /**
     * metodo encargado de convertir un vector de bytes ha cadena de caracteres
     * @param line vector de bytes que se va a pasar a una cadena de string
     * @param size es el tamaño de la cadena de caracteres
     * @return la linea de texto que corresponde al array de bytes
     */
    public String readByteToString(byte[] line, int size) {		 
        String result ="";      
        for (int i = 0; i < line.length && i < size; i++) {
            result += (char)line[i];
        }
        for (int i = result.length(); i < size; i++) {
            result+=" ";
        }
        return result;
    }
    
    
}
