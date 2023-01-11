package internacionalizacion;

import java.awt.Frame;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego ahorcado
 */

public class Global {
	/**
	 * Permite acceder al uso de diferentes idiomas para utilizar en la aplicacion
	 */
	public static ResourceBundle language;
	public Global(){
		
	}
	
	public void SelectLanguage(String language){
		switch (language="sp") {
		case "sp":
			Global.language = ResourceBundle.getBundle(language);
			System.out.println("si");
			break;
		case "en":
			Global.language = ResourceBundle.getBundle(language);
			System.out.println("si");
			break;
		case "pr":
			Global.language = ResourceBundle.getBundle(language);
			System.out.println("si");
			break;
			
		case "fr":
			Global.language = ResourceBundle.getBundle(language);
			System.out.println("si");
			break;
			
			
			
		case "al":
			Global.language = ResourceBundle.getBundle(language);
			System.out.println("si");
			break;
		default:
			break;
		}
		
		
	
	}
	
	public   void displayMessage(Locale currentLocale) {
	System.out.println("currentLocale = " + currentLocale.toString());
	System.out.println();
    ResourceBundle messages =ResourceBundle.getBundle("MessageBundle",currentLocale);
	 Object[] messageArguments = {
	        messages.getString("Planet"),
	         new Integer(7),
	         new Date()
	      };
	  MessageFormat formatter = new MessageFormat("");
      formatter.setLocale(currentLocale);
 
      formatter.applyPattern(messages.getString("template"));
      String output = formatter.format(messageArguments);
      JOptionPane.showMessageDialog(null, output);
      System.out.println(output);
}
	public String leer(String key,Locale currentLocale) throws IOException{
		String aux="";
		String nombre = null;
		ResourceBundle messages =ResourceBundle.getBundle("MessageBundle",currentLocale);
	    MessageFormat formatter = new MessageFormat("");
	    formatter.setLocale(currentLocale);
	    formatter.applyPattern(messages.getString(key));
	    //String output = formatter.format(aux);
		aux=messages.getString(key);
		
		return aux;
		}
	
	
	
	
	
	
}



