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
 * clase encargada de administrar los recursos , muesta la cantridad ques se necesita de este recurso
 */

public class ResourceQuantity implements Serializable{   
    
   public static final int SIZE_RESOURCE_QUANTITY=30;
   private int idResource;
   private double quantity;
   private GroupResource groupResource;
   
   /**
    * constructor de la clase
    * @param quantity es la cantidad que se requiere de este recurso
    * @param id es el identificador correspondiente al recurso
    */ 
   public ResourceQuantity(double quantity,int id) {
        this.groupResource = GroupResource.instanceOfGroup();
        this.quantity = quantity;
        if(groupResource.get(id)!= null) {
             this.idResource = id;
        }        
        id = -1;
    }

   /**
    * constructor de la clase
    */
   public ResourceQuantity() {
       this.groupResource = GroupResource.instanceOfGroup();
       this.quantity = 0;
       this.idResource =-1;
     }
      
   /**
    * metodo que le permite selecionr un recurso y
    * ver cuanta cantidad de este se necvesita a travez del un identidficador
    * @param quantity es la cantidad de recursos y es de tipo double
    * @param id es el identificador del recurso y es de tipo entero
    * @return  retorna un si es verdadero o falso 
    */ 
   public boolean setResourceQuantity(double quantity,int id) {
        this.quantity = quantity;
        if(groupResource.getResource(id)!= null) {
             this.idResource = id;
             return true;
        }        
        return false;
    }
   
}
