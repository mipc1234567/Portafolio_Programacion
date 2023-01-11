/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez 
 * 
 * Clase que controla el administrador de  recetas  
 */
public class Controller {
    
    private AdminRecipe adminRecipe=null;
    private ListResource listResource=null;

    /**
     * constructor de la clase
     */
    public Controller() {
        this.adminRecipe=new AdminRecipe();
        this.listResource=new ListResource();
    }

    /**
     * metodo que obtienen una lista de recetas
     * @return el administrador  de rectas
     */
    public AdminRecipe getListRecipe() {
        return adminRecipe;
    }

    /**
     * Metodo que asigna una lista de recetas
     * @param listRecipe  de tipo adminRecipe
     */
    public void setListRecipe(AdminRecipe listRecipe) {
        this.adminRecipe = listRecipe;
    }

    /**
     * metodo que obtiene una listas de recursos
     * @return retorna una lista de recursos
     */
    public ListResource getListResource() {
        return listResource;
    }

    /**
     * Metodo que asigna un alista de recursos
     * @param listResource de tipo listResource
     */
    public void setListResource(ListResource listResource) {
        this.listResource = listResource;
    }
    
    
}
    

    
    
    

