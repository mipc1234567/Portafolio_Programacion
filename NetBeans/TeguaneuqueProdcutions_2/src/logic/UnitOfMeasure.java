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
 * Esta clase enumerada que establece las unidades de medidad de recursos que se van a utilizar 
 */
public enum UnitOfMeasure implements Serializable{
    
   GRAM("Gramo"), UNIT("Unidades"), CUBIC_CENTIMETERS("Centrimetros cubicos"),MINUTES("Minutos"),CENTIMETERS("Centrimetros");
    
   private String name;

   /**
    * constructor de la clase, en la que le entra por parametro una cadena de caractes
    * que hace referencia al nombre del enumerado 
    * @param name es el nombre que identifica al dato enumerado
    */
   private UnitOfMeasure(String name) {
        this.name = name;
    }

   /**
    * metodo que obtiene el nombre de el atributo de la lsita del enumerado
    * @return devuelve el nombre que se le asigno al dato enumerado
    */ 
   public String getName() {
        return name;
    }
   
   
}
