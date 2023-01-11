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
 * @author Diana Carolina Sanchez Bautista
 * 
 * clase que ordena las recetas de forma alfabetica
 */
public class Order {

    private String numberOrder = null;
    private String nameRecipe = null;

    /**
     * constructo de la clase en la que se le ingresa por parametros 
     * un cadena de caracteres que hacer referencia al número de orden y 
     * una cadena de caracteres que hace rerferencia al nombre de la receta.
     * @param numberOrder es el numero de orden
     * @param nameRecipe es el nombre de la receta
     */
    public Order(String numberOrder, String nameRecipe) {
        this.nameRecipe = nameRecipe;
        this.numberOrder = numberOrder;

    }

    /**
     * metodo que asigna el nombre de la receta
     * @param nameRecipe  es el nombre de la receta
     */
    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    /**
     * metodo que le asigna un numero de orden a la receta
     * @param numberOrder ess el numero de orden de la receta
     */
    public void setNumberOrder(String numberOrder) {
        this.numberOrder = numberOrder;
    }

    /**
     * metodo que obtiene el nombre de la receta
     * @return es una linea de texto que representa el nombre de la receta
     */
    public String getNameRecipe() {
        return nameRecipe;
    }

    /**
     * metodo que obtiene el número de orden de las recetas
     * @return es el numero de la receta
     */
    public String getNumberOrder() {
        return numberOrder;
    }

    /**
     * metodo que  concatena el numero de orden y el nombre de la receta describiendo la recceta
     * @return la linea de texto de descripcion
     */
    @Override
    public String toString() {
        return getNumberOrder() + " " + getNameRecipe();
    }
}
