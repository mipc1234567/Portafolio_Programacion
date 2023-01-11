package Persistencia;

import java.io.File;

import Interfaz.Personas;
import Logica.Persona;
import Logica.Procesador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import sun.util.calendar.BaseCalendar.Date;


public class ControlFile implements Serializable {

private FileInputStream fileInputStream;
private FileOutputStream fileOutputStream;
private Persona persona;
private Personas personas;
private ObjectInputStream objectInputStream;
private ObjectOutputStream objectOutputStream;
private File file;
private File fileProcesador;
private ArrayList<Persona> arrayListPerson;
private ArrayList<Procesador> arrayListProcessor;
private ArrayList<Persona> arrayListPersonArchive;
private ArrayList<Procesador> arrayListProcessorArchive;
private String namePersona;

private String nameProcesador;


public ControlFile(String parametro) {	
this.namePersona=parametro;
this.nameProcesador=parametro;


}


public void initializacePer(){
	try {
		createFilePerson(namePersona);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void initializacePro(){
	try {
		createFileProcesador(nameProcesador);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



	
public void createFilePerson(String name) throws IOException{
	this.namePersona=name;	
	arrayListPerson = new ArrayList<Persona>();
	file = new File("./src/"+namePersona+".per");
	setFile(file);
fileOutputStream = new FileOutputStream("./src/"+getNamePersona()+".per");
objectOutputStream = new ObjectOutputStream(fileOutputStream);
objectOutputStream.close();
}

public void SaveFilePerson(ArrayList<Persona> Arrayperson,int position) throws Exception{
System.out.println("esta agregadno una persona nueva en la posicion"+position);
fileOutputStream = new FileOutputStream("./src/"+getNamePersona()+".per");
objectOutputStream = new ObjectOutputStream(fileOutputStream);
for(int i =0;i<=position;i++){
objectOutputStream.writeObject((Persona)Arrayperson.get(i));
	System.out.println("el valor del nombre de la persona  es"+ Arrayperson.get(i).getDocumentNumber());
}
objectOutputStream.close();
}


public void createFileProcesador(String name) throws IOException{
	this.nameProcesador=name;
	arrayListProcessor = new ArrayList<Procesador>();
	fileProcesador= new File("./src/"+nameProcesador+".pro");
	setFileProcesador(fileProcesador);
fileOutputStream = new FileOutputStream("./src/"+getNameProcesador()+".pro");
objectOutputStream = new ObjectOutputStream(fileOutputStream);
objectOutputStream.close();
}

public void SaveFileProcesador(ArrayList<Procesador> Arrayprocesa,int position) throws Exception{
fileOutputStream = new FileOutputStream("./src/"+getNameProcesador()+".pro");
objectOutputStream = new ObjectOutputStream(fileOutputStream);
objectOutputStream.writeObject((Procesador)Arrayprocesa.get(position));
objectOutputStream.close();
}

public ArrayList<Procesador> ReadFileProcesador(int cont) throws Exception{
//fileOutputStream = new FileOutputStream("./src/"+getNameProcesador()+".pro");
	//arrayListProcessor= new ArrayList<Procesador>();
fileInputStream= new FileInputStream("./src/"+getNameProcesador()+".pro");
objectInputStream= new ObjectInputStream(fileInputStream);
//objectOutputStream = new ObjectOutputStream(fileOutputStream);
arrayListProcessor.add((Procesador) (objectInputStream.readObject()));	
for(int i=0;i<cont;i++){
	System.out.println("el valor del cache  es:"+ arrayListProcessor.get(i).getCache());
	System.out.println("el valor del Frecuencia de Relog es:"+ arrayListProcessor.get(i).getFrecuenciaReloj());
	System.out.println("el valor de la marca es"+ arrayListProcessor.get(i).getMarca());
	System.out.println("el valor de las instrucciones es:"+ arrayListProcessor.get(i).getInstrucciones());
	System.out.println("el valor del numero de nucleos es:"+ arrayListProcessor.get(i).getNumeroNucleos());

}
objectInputStream.close();
return arrayListProcessor;
}

public ArrayList<Persona> ReadFilePerson(int cont,String Parametro) throws Exception{
	String valor=Parametro;
	fileInputStream= new FileInputStream("./src/"+Parametro+".per");
	objectInputStream= new ObjectInputStream(fileInputStream);
	//objectOutputStream = new ObjectOutputStream(fileOutputStream);
	Persona person= (Persona) objectInputStream.readObject();
	arrayListPerson.add(person);
   
	// Mientras haya objetos http://www.chuidiang.org/java/ficheros/ObjetosFichero.php
	while (person!=null)
	{
	    if (person instanceof Persona)
	        System.out.println(person);  // Se escribe en pantalla el objeto
	    person = (Persona) objectInputStream.readObject();
	    arrayListPerson.add(person);
	}
	objectInputStream.close();
	return arrayListPerson;
	}
/*
 Es un metodo especial para leer una archivo binario sin tener cabecera como se esta guardado
 anteriormente
 */
public void ReadFilePersona(int position) throws Exception{
	fileInputStream= new FileInputStream("./src/"+getNameProcesador()+".pro");
	objectInputStream= new ObjectInputStream(fileInputStream);
	//objectOutputStream = new ObjectOutputStream(fileOutputStream);
	Procesador p=(Procesador)objectInputStream.readObject();
	System.out.println("el valor del objeto es"+ p.getFrecuenciaReloj());
	objectInputStream.close();
	}
/*
Es un metodo especial para leer una archivo binario sin tener cabecera como se esta guardado
anteriormente
*/
public void ReadFileProcesa(int position) throws Exception{
	//fileOutputStream = new FileOutputStream("./src/"+getNameProcesador()+".pro");
	fileInputStream= new FileInputStream("./src/"+getNameProcesador()+".pro");
	objectInputStream= new ObjectInputStream(fileInputStream);
	//objectOutputStream = new ObjectOutputStream(fileOutputStream);
	Procesador p=(Procesador)objectInputStream.readObject();
	System.out.println("el valor del objeto es"+ p.getFrecuenciaReloj());
	objectInputStream.close();
	}


public void deleteRegister(Persona p){
int i = 0;
int es = 0;
try {
	for (Persona person : readListPerson()) {
			if(personas.getJlbnumerodocumento().equals(p.getDocumentNumber())){
				es = i;
			}
			i++;
			}
			arrayListPerson.remove(es);
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("1");
			createFilePerson(arrayListPerson.get(es).toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Persona> readListPerson() throws IOException, ClassNotFoundException {
		//System.out.println(file.mkdir());
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		
		fileInputStream = new FileInputStream(this.file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		arrayListPerson = (ArrayList<Persona>)objectInputStream.readObject();
		objectInputStream.close();
		
		return arrayListPerson;
		
	}

	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}
	public File getFileProcesador() {
		return fileProcesador;
	}


	public void setFileProcesador(File fileProcesador) {
		this.fileProcesador = fileProcesador;
	}


	public ArrayList<Procesador> getArrayListProcessor() {
		return arrayListProcessor;
	}


	public void setArrayListProcessor(ArrayList<Procesador> arrayListProcessor) {
		this.arrayListProcessor = arrayListProcessor;
	}
	public String getNamePersona() {
		return namePersona;
	}


	public void setNamePersona(String namePersona) {
		this.namePersona = namePersona;
	}


	public String getNameProcesador() {
		return nameProcesador;
	}


	public void setNameProcesador(String nameProcesador) {
		this.nameProcesador = nameProcesador;
	}
	
	
}
