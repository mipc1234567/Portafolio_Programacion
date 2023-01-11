package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import logic.Recipe;

/**
 * Proyeto Teguaneque Productions Universidad Padaggogíca y Tecnologíca de
 * Colombia grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 * 
 * Este metodo es el encargado de generar un archivo 
 */

public class RecipeFileObject {

    private File                file;
    private FormOpenObjectFile  formOpenObjectFile;
    private FileInputStream     fileInputStream;
    private FileOutputStream    fileOutputStream;
    private ObjectInputStream   objectInputStream;
    private ObjectOutputStream  objectOutputStream;

    /**
     * Constructor de la clase, en el cual instancio todos los atributos
     * @param fileName cadena de caracteres que hace referencia al nombre del archivo
     * @param formOpenObjectFile es la forma de abrir el archivo y es de tipo formOpenFile
     */
    public RecipeFileObject(String fileName, FormOpenObjectFile formOpenObjectFile) {
        this.file                   = new File(fileName);
        this.formOpenObjectFile     = formOpenObjectFile;
    }
    
    /**
     * metodo que permite abrir el archivo 
     * @return una afirmacion si es posible o no abrir el archivo 
     */
    public boolean open() {
        try {
            if(formOpenObjectFile == FormOpenObjectFile.WRITE) {
                fileOutputStream   =  new FileOutputStream(file);
                objectOutputStream =  new  ObjectOutputStream(fileOutputStream);
            }else{
                  fileInputStream    =  new FileInputStream(file);                  
                  objectInputStream  =  new ObjectInputStream(fileInputStream);    
            }
            return true;
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
           return false;
        } catch (IOException ex) {
            return false;
        } 
    }
    
    /**
     * metodo que cierra el archivo
     * @return devuelve una afirmacion si fue posible abrir el archivo o no 
     */
    public boolean close(){
        try {
           if(formOpenObjectFile == FormOpenObjectFile.WRITE) {
                fileOutputStream.close();
                objectOutputStream.close();
            }else{
                fileInputStream.close();                  
                objectInputStream.close();                  
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    /**
     * metodo que recibe una receta la cual se va a agregar al archivo
     * @param recipe es una receta que se trae de la logica
     * @return devuelve una afirmacion si fue posible o noo leer una receta
     */
    public boolean put(Recipe recipe){
        try {
            objectOutputStream.writeObject(recipe);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    /**
     * metodo que obtiene una receta 
     * @return devuelve una reeta 
     */
    public Recipe get() {
        try {
            return (Recipe) objectInputStream.readObject();
        } catch (IOException ex) {           
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException ex) {            
            ex.printStackTrace();
            return null;
        }
    }   
    
}
