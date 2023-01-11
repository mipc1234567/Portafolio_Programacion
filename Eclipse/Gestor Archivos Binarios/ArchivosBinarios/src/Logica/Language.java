package Logica;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.util.Properties;

import Persistencia.DocumentType;

public class Language {
	
	
public static String namefile="languageSP.properties";
public  static String namefile1="languageUS.properties";
public String name=namefile;
public DocumentType document;


public String leerDocument(DocumentType key) throws IOException{
String aux="";
String nombre = null;
File fil = new File(name);
FileInputStream stream = null;
Properties properties= new Properties();

try {
stream = new FileInputStream(fil);
properties.load(stream);

} catch (FileNotFoundException e) {
	System.out.println("no se puede leer el archivo");
	// TODO Auto-generated catch block
	e.printStackTrace();
}
aux= properties.getProperty(document.transformar(key));
return aux;
}


public String leer(String key) throws IOException{
String aux="";
String nombre = null;
File fil = new File(name);
FileInputStream stream = null;
Properties properties= new Properties();

try {
stream = new FileInputStream(fil);
properties.load(stream);

} catch (FileNotFoundException e) {
	System.out.println("no se puede leer el archivo");
	// TODO Auto-generated catch block
	e.printStackTrace();
}
aux= properties.getProperty(key);
return aux;

}




public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}