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
 * Esta clase es la encargada de administrar una lista de recetas 
 */
public class AdminRecipe {

    private ArrayList<Recipe> listRecipes;

     /**
     * Constructor de la clase, en la que se instancia una lista 
     */
    public AdminRecipe() {
        listRecipes = new ArrayList<>();
    }

    /**
     * Metodo que permite agregar a la lista de recetas una receta 
     * @param recipeAdd entra por parametro una receta
     */
    public void addRecipe(Recipe recipeAdd) {
        this.listRecipes.add(recipeAdd);
    }

    /**
     * Metodo que permite borrar o eliminar a la lista de recetas una receta
     * @param recipeDelete  entra por parametro una receta
     */
    public void deleteRecipe(Recipe recipeDelete) {
        for (Recipe recipe : listRecipes) {
            if (recipe.getIdRecipe() == recipeDelete.getIdRecipe()) {
                listRecipes.remove(recipe);
            }
        }
    }

    /**
     * Metodo que permite editar una receta que ya esta se encuentra agregada
     * @param recipeEdit entra por parametros una receta
     * @param id un dato de tipo entero que se refiera al identificador de la receta
     */
    public void editRecipe(Recipe recipeEdit, int id) {
        for (Recipe recipe : listRecipes) {
            if (recipe.getIdRecipe() == id) {
                recipe = recipeEdit;
            }
        }
    }

    /**
     * Metodo que obtiene una lista de recetas
     * @return es la lista que contiene las recetas de la aplicacion
     */
    public ArrayList<Recipe> getListRecipes() {
        return listRecipes;
    }
    

}
