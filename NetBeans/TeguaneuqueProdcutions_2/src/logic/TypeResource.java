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
 * Esta clase enumerada que establece los tipos de recursos que se van a utilizar 
 */
public enum TypeResource implements Serializable{
    
    INGREDIENT("Ingrediente",0), TIME("Tiempo",1), ELEMENT("Elemento",2);
    
    private String name;
    private int index;

   /**
    * Constructor de la clase, en la cual le entra por parametro una cadena de caracteres
    * y un entero que identifica el tipo de recurso
    * @param name es el nombre que identifica al dato enumerado
    * @param index  es el número que identifica al dato enumerado
    */
    private TypeResource(String name, int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * metodo que obtiene el nombre de la lista del enumerado
     * @return  devuelve el nombre que se le asigno al dato enumerado
     */
    public String getName() {
        return name;
    }

    /**
     * metodo que asigna el nombre a un atributo de la clase
     * @param name cadena de caracteres que hace referencia a el nombre que identifica el al tipo enumerado
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * metodo que obtiene el numero de la lista del emumerado
     * @return devuelve el numero o identificador que se le asigno al dato enumerado
     */
    public int getIndex() {
        return index;
    }

    /**
     * metodo que asigna el número de un atributo en la listas 
     * @param index  entero que hace referencia a el nombre que identificara el dato enumerado
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
     

}    
