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
 * Clase singleton que guarda una lista de recursos
 */
public class GroupResource extends ArrayList<Resource>{
    private static GroupResource groupResource = null; 
    
    /**
     * Constructor de la clase
     */
    private GroupResource() {
        super();
    }
    
    /**
     * Metodo que instancia el groupResource, evaluando
     * si este ya existe,garantizando que el grupo sea el mismo para toda la aplicacion
     * @return retorna el grupo de recursos
     */
    public static GroupResource instanceOfGroup() {
        if(groupResource == null) {
            groupResource = new GroupResource();
        }
        return groupResource;
        
    }

    /**
     * Metodo que asigna un identificador a el recurso
     * @param id es el numero identificador del recurso
     * @return el recurso que se identifica co el numero 
     */
    public Resource getResource(int id) {
        for (Resource resource : this) {
            if(resource.getId() == id){
                return this.get(id);
            }
        }
        return null;
    }
}
