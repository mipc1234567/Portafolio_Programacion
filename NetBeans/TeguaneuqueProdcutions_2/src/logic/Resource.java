/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.io.Serializable;
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
 *Clase que crea un recurso para una receta
 */
public class Resource implements Serializable{
    public static final int SIZE_RESOURCE=34;
    private static int ID_ADD = 0;
    private static int SIZE_NAME=18;
    private String  name;
    private int     id;
    private UnitOfMeasure unitOfMeasure;
    private TypeResource typeIngredient;
 
    /**
     * Constructor de la clase que recibe como parametros un nombre de recurso, una unidad 
     * de medida, y u tipo de recurso
     * @param name es el nombre del recurso
     * @param unitOfMeasure es la unidad de medida del recurso
     * @param typeIngredient es el tipo de recurso
     */
    public Resource(String name, UnitOfMeasure unitOfMeasure, TypeResource typeIngredient) {
        this.name = name;
        this.id =  ID_ADD ;
         ID_ADD ++;
        this.unitOfMeasure = unitOfMeasure;
        this.typeIngredient = typeIngredient;
    
    }

    /**
     * metodo que obtiene el nombre de la recurso
     * @return es el nombre del reurso
     */
    public String getName() {
        return name;
    }

    /**
     * metodo que le asigna un  nombre a un recurso
     * @param name cadena de caracteres que hace referencia al nombre del recurso
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * metodo que obtiene el identificador del recurso
     * @return devuelve un entero que se refiere al numero de identificacion del producto
     */
    public int getId() {
        return id;
    }

    /**
     * metodo que le asigna un identificador a un recurso
     * @param id es un entero que hace referencia al identificador del recurso
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * metodo que obtiene la unidad de medida de el recurso
     * @return devuelve la unidad de medida del recurso
     */
    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /**
     *metodo que le asigna una unidad de meidida a un recurso 
     * @param unitOfMeasure es la unidad de medidad de el recurso
     */
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    /**
     * metodo que obtiene el tipo de recurso 
     * @return que tipo de recurso es
     */
    public TypeResource getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * metodo que le asigna un tipo a el recurso 
     * @param typeIngredient es el tipo de rrecurso 
     */
    public void setTypeIngredient(TypeResource typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
   
    
    
   
}


