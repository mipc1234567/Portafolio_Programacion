/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.io.Serializable;
import java.util.ArrayList;
import logic.Util;

/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 * 
 * clase encargada de crear la receta 
 */
public class Recipe implements Serializable{
    private static int ID_ADD=0;
    private static final int SIZE_RECIPE=762;
    private static final int SIZE_NAME_RECIPE=18;
    private static final int SIZE_PREPARACION=720;
    private ArrayList<ResourceQuantity>  listIngredients;
    private String                 name;
    private String                 preparation;
    private ArrayList<ImageDescription> listImageDescription;
    private int                    idRecipe;
    

    /**
     * constructor de la clase, que recibe coo parametros 
     * una lista de ingredientes, cadena de caracteres que 
     * hace refererncia a le nombre de la receta, una cadena ce caracteres que hace
     * referencia a la preparacion de la receta y una lista de iagenes.
     * @param listIngredients es la lista de todos los recursos pertenecientes a la receta con su cantidad
     * @param name es el nombre de la receta
     * @param preparation es la descripcion de la´preparacion de la recta
     * @param listImageDescription es una lista que contiene las imagenes de la receta con si descripcion
     */
    public Recipe(ArrayList<ResourceQuantity> listIngredients, String name, String preparation, ArrayList<ImageDescription> listImageDescription ) {
        this.listIngredients = listIngredients;
        this.name = name;
        this.preparation = preparation;
        this.listImageDescription = listImageDescription;
        this.idRecipe = ID_ADD;
        ID_ADD++;
    }
   
   
    /**
     * metodo que obtiene una listas de recursos de la receta
     * @return  la lista de recursos
     */
    public ArrayList<ResourceQuantity> getListIngredients() {
        return listIngredients;
    }

    /**
     * metodo que asigna una lista de ingreientes 
     * @param listIngredients asigna la lista de recursos
     */
    public void setListIngredients(ArrayList<ResourceQuantity> listIngredients) {
        this.listIngredients = listIngredients;
    }

    /**
     * metodo que obtiene el nombre de una receta
     * @return es el nombre de la receta
     */
    public String getName() {
        return name;
    }

    /**
     * metodo que asigna un nombre a la receta
     * @param name es el nombre de la receta a asignar
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * metodo que obtiene la preparacion de la receta
     * @return es la descripcion de la preparacion de la receta
     */
    public String getPreparation() {
        return preparation;
    }

    /**
     * metodo que asigna una cadena e caracteres que hacen referencia a la preparacion de la receta
     * @param preparation es descripcion de la preparacionde la reeta
     */
    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    /**
     * metodo que obtiene una lista de imagenes
     * @return es la lista de las imagenes con su descripcion
     */
    public ArrayList<ImageDescription> getListImageDescription() {
        return listImageDescription;
    }

    /**
     * metodo que asigna una lista de imagenes a la receta
     * @param listImageDescription es una lista de imagenes descritas
     */
    public void setListImageDescription(ArrayList<ImageDescription> listImageDescription) {
        this.listImageDescription = listImageDescription;
    }

    /**
     * obtien un identificador de una receta
     * @return es el identificador de la receta
     */
    public int getIdRecipe() {
        return idRecipe;
    }

   /**
     * asigna un identificador a una receta
     * @param idRecipe es el identificador de la receta a asiganar
     */
    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }
}
