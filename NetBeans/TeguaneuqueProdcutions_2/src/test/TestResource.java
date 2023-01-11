/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.ArrayList;
import logic.Resource;
import logic.TypeResource;
import logic.UnitOfMeasure;

/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 * 
 * es la clase prueva el agregar nuevos recursos 
 */
public class TestResource {

    /**
     * metodo encargado de ejecutar la clase recursos
     * @param args vectod de cadena de caracter que esta definido por defecto 
     */
    public static void main(String[] args) {
        ArrayList<Resource> listResources = new ArrayList<>();
        
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        listResources.add(new Resource("Tiempo horneo", UnitOfMeasure.MINUTES, TypeResource.TIME));
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        listResources.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
        
    }
}
