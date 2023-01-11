/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import java.awt.Image;
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
 * Clase que crea una imagen 
 */
public class ImageDescription implements  Serializable{
    
    private String description;
    private Image image;

    /**
     * constructor de la clase, en la que le ingresan como paametros  una vcadena de 
     * caracteres que hacen referencia a la descripcion de la imagen y una imagen
     * @param description es el texto que describe la imagen 
     * @param image es la imagen que el usuario agregar a la receta
     */
    public ImageDescription(String description, Image image) {
        this.description = description;
        this.image = image;
    }

    /**
     * obtiene una descripcion de una imagen
     * @return es una linea de texto que representa la descripcion de la imagen
     */
    public String getDescription() {
        return description;
    }

    /**
     * asigna una descricion a de la imagen
     * @param description es la descripcion
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * metodo que obtienen una imagen de un recurso
     * @return retorna la imagen que el usuario asigno a la receta
     */
    public Image getImage() {
        return image;
    }

    /**
     * metodo que asigna una imagen de la receta
     * @param image es la imagen de la receta
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    
}
