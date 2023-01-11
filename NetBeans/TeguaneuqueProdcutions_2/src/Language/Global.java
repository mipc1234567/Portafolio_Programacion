package Language;

import java.awt.Frame;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

/**
 * Clase que permite manejar ingredientes y los recursos de la misma Proyeto
 * Teguaneque Productions Universidad Padaggogíca y Tecnologíca de Colombia
 * grupo 5 :
 *
 * @author Caludia Jisell Alba Muñoz
 * @author Sindy Katherine Barón Peña
 * @author Mateo Ivan Peña Cancelado
 * @author Diana Carolina Sanchez Bautista
 *
 * Permite acceder al uso de diferentes idiomas para utilizar en la aplicación
 */
public class Global {

    /**
     * Permite acceder al uso de diferentes idiomas para utilizar en la
     * aplicacion
     */
    public static ResourceBundle language;

    public Global() {

    }

    /**
     * Este metodo permite cambiar el idioma recibiendo por parametro un cadena
     * de caracteres qu representa el idioma
     *
     * @param language cadena de caracteres que se refiere al idioma a cambiar
     */
    public void SelectLanguage(String language) {
        switch (language = "sp") {
            case "sp":
                Global.language = ResourceBundle.getBundle(language);
                break;
            case "en":
                Global.language = ResourceBundle.getBundle(language);
                break;
            case "pr":
                Global.language = ResourceBundle.getBundle(language);
                break;

            case "ar":
                Global.language = ResourceBundle.getBundle(language);
                break;
            default:
                break;
        }

    }

    /**
     * Este metodo busca en el archivo properti la palabra y la asigna a ingles
     * español
     *
     * @param key cadenana de caracteres que identifica la llave de la palabra a
     * cambiar
     * @param currentLocale id de la plabla
     * @return un acadena de caracteres que es la llave de que identifica un
     * palabra
     */

    public String leer(String key, Locale currentLocale) {
        String aux = "";
        String nombre = null;
        ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", currentLocale);
        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(currentLocale);
        formatter.applyPattern(messages.getString(key));
        aux = messages.getString(key);
        return aux;
    }

}
