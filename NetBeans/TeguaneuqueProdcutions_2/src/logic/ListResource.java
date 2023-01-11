/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;

/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 * 
 * Este metodo es el encargado de generar una lista de recursos 
 */
public class ListResource {
    
   private  ArrayList<Resource> resources=null;

   /**
    * Constructor de la clase 
    */ 
   public ListResource() {
        this.resources=new ArrayList<>();
    }
   /**
    * metodo que obtiene una  lista de recursos 
    * @return es la lista de los recursos 
    */
    public ArrayList<Resource> getResources() {
        return resources;
    }

    /**
     * metodo que asigna a la clase una lista de recursos a la  perteniente de la clase
     * @param resources recibe una lista de recursos 
     */
    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }
}
