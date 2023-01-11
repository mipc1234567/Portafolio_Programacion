/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import persistence.*;

/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 * 
 * es la clase que decide  de que forma se va a abrir el archivo
 */
public enum FormOpenObjectFile {
    // es una clase especial,
    
    WRITE("w"),READ("r"),UPDATE("rw");

    /**
     * Constructor de la clase
     * @param mode es una cadena de caracteres que hace referencia a la forma de abrir el archivo
     */
    private FormOpenObjectFile(String mode) {
        this.mode = mode;
    }
    
    private String mode;

    /**
     * metodo que obtiene el modelo o forma de abrir el archivo
     * @return  una cadena de caracteres que hace reerencia a la forma de abrir el archivo
     */
    public String getMode() {
        return mode;
    }
}
