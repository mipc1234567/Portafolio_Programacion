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
 * clase que ordena la lista de recetas
 */
public class OrderList extends ArrayList<Order> {

    public ArrayList<Order> getRecetas() {
        return this;
    }

    /**
     * constructor de la clase
     * @return el numero del orden de la recta
     */
    public String nuevoNumOrden() {
        int numOrden = (this.size() + 1);
        String orden = "No." + String.valueOf(numOrden);
        return orden;
    }

}
