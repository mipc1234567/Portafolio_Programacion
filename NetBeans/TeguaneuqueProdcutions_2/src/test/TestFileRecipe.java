/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.ArrayList;
import logic.GroupResource;
import logic.Resource;
import logic.ResourceQuantity;
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
 * es la clase en la que se prueva el archivo de recetas
 */
public class TestFileRecipe {

    /**
     * metodo encargado de ejecutar (main)
     * @param args es un vector de cadenas de carateres  que se asigna por defecto
     */
    public static void main(String[] args) {
      
        GroupResource groupResource = GroupResource.instanceOfGroup();
        
         groupResource.add(new Resource("Harina", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
         groupResource.add(new Resource("Tiempo horneo", UnitOfMeasure.MINUTES, TypeResource.TIME));
         groupResource.add(new Resource("aZUCAR", UnitOfMeasure.GRAM, TypeResource.INGREDIENT));
         groupResource.add(new Resource("Molde", UnitOfMeasure.UNIT, TypeResource.ELEMENT));
         
         ResourceQuantity resourceQuantity = new ResourceQuantity();
         if (resourceQuantity.setResourceQuantity(1.5, 2)) {
             System.out.println("Agragado");
         }
         else{
             System.out.println("No existe");
         };

        ResourceQuantity resourceQuantity1 = new ResourceQuantity(1.5, 2);
                
    }
}
