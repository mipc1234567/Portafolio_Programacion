package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import Interfaz.Personas;
import Logica.Persona;
import Logica.Procesador;

public class ControFileAuxiliar extends ObjectOutputStream {

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
private int ControlReadPerson;
private int CotntrolReadProce;



public ControFileAuxiliar(OutputStream out) throws IOException {	
super(out);

}
public ControFileAuxiliar() throws IOException, SecurityException {	
super();

}

protected void writeStreamHeader() throws IOException
{
}

//se debe empezar a instanciar la persona
public void InitialiceControFileAuxiliar(String param) {	
this.namePersona=param;
this.nameProcesador=param;


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
//objectOutputStream.close();
}

public void SaveFilePerson(ArrayList<Persona> Arrayperson,int position) throws Exception{
System.out.println("esta agregadno una persona nueva en la posicion"+position);
fileOutputStream = new FileOutputStream("./src/"+getNamePersona()+".per");
objectOutputStream = new ObjectOutputStream(fileOutputStream);
ControFileAuxiliar Oss = new ControFileAuxiliar(fileOutputStream);
if(position==0){
	Persona p= new Persona(Arrayperson.get(0));
	objectOutputStream.writeObject(p);
	this.ControlReadPerson=0;
	System.out.println("SI PASO POR ACA"+ "valor del  control"+ControlReadPerson);
	objectOutputStream.close();
}else
	if(position>=1){
	System.out.println("SI PASO POR ACA TAMNINEN HAY EEROR"+ControlReadPerson);
ControlReadPerson=1;
for(int i =0;i<=position;i++){
	Oss.writeUnshared((Persona)Arrayperson.get(i));
	System.out.println("este es el valor de contador"+i);
	System.out.println("el valor del nombre de la persona  es"+ Arrayperson.get(i).getDocumentNumber());
}}

Oss.close();
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
System.out.println("esta agregadno un procesador nuevo en la posicion"+position);
fileOutputStream = new FileOutputStream("./src/"+getNameProcesador()+".pro");
objectOutputStream = new ObjectOutputStream(fileOutputStream);
ControFileAuxiliar Osc = new ControFileAuxiliar(fileOutputStream);
if(position==0){
	Procesador p= new Procesador(Arrayprocesa.get(0));
	objectOutputStream.writeObject(p);
	this.CotntrolReadProce=0;
	System.out.println("SI PASO POR ACA"+ "valor del  control"+CotntrolReadProce);
	objectOutputStream.close();
}else
	if(position>=1){
	this.CotntrolReadProce=1;
	System.out.println("SI PASO POR ACA TAMNINEN HAY EEROR");
	for(int i =0;i<=position;i++){
		System.out.println("este es el valor de contador"+i);
Osc.writeUnshared(Arrayprocesa.get(i));
System.out.println("el valor del nombre del procesador es:"+ Arrayprocesa.get(i).getMarca());

}}
		Osc.close();
}

public ArrayList<Procesador> ReadFileProcesador(int cont,String Parametro) throws Exception{
//
	try{
		String valor=Parametro;
	
		arrayListProcessor= new ArrayList<Procesador>();
		
	//fileOutputStream = new FileOutputStream("./src/"+getNameProcesador()+".pro");
	//arrayListProcessor= new ArrayList<Procesador>();
	if (CotntrolReadProce==0){
	System.out.println("ENTRO EN EL PRIMERO");
fileInputStream= new FileInputStream("./src/"+getNameProcesador()+".pro");
objectInputStream= new ObjectInputStream(fileInputStream);
//objectOutputStream = new ObjectOutputStream(fileOutputStream);
Procesador procesador= (Procesador) objectInputStream.readObject();
	}else{
		if (ControlReadPerson>=1){
		System.out.println("ENTRO EN EL SEGUNDO");
		fileInputStream= new FileInputStream("./src/"+getNameProcesador()+".pro");
	objectInputStream= new ObjectInputStream(fileInputStream);
	//objectOutputStream = new ObjectOutputStream(fileOutputStream);
	Procesador procesador= (Procesador) objectInputStream.readObject();
arrayListProcessor.add(procesador);
while (procesador!=null){
    if (procesador instanceof Procesador)
        System.out.println(procesador);  // Se escribe en pantalla el objeto
    procesador = (Procesador) objectInputStream.readObject();
    arrayListProcessor.add(procesador);
    System.out.println("22 la mcarca del procesador leido es:"+" "+procesador.getMarca());
	System.out.println("222 el nombre de las instruccioneses:"+" "+procesador.getInstrucciones());
}
objectInputStream.close();
		}
	}
	}catch (Exception e) {
	System.out.println("fin del archivo");
	// TODO: handle exception
	}
	return arrayListProcessor;
}

public ArrayList<Persona> ReadFilePerson(int cont,String Parametro) throws Exception{
	
	try{
		String valor=Parametro;
	
		arrayListPerson= new ArrayList<Persona>();
	 //arrayListPersonArchive= new ArrayList<Persona>();

		//System.out.println("EL VALOR DEL PARAMETRO ES;"+Parametro);
		//System.out.println("EL VALOR DEL PARAMETRO ES;"+valor);
	System.out.println("el valor del contros es O Y AQUI TAMBIEN ES"+ControlReadPerson);
	if (ControlReadPerson==0){
		System.out.println("entro aa la primera forma");
	fileInputStream= new FileInputStream("./src/"+Parametro+".per");
	objectInputStream= new ObjectInputStream(fileInputStream);
	//objectOutputStream = new ObjectOutputStream(fileOutputStream);
	Persona person= (Persona) objectInputStream.readObject();
	arrayListPerson.add(person);
	}else{
		if (ControlReadPerson>=1){
		System.out.println("entro aa la segunad foram");
		fileInputStream= new FileInputStream("./src/"+Parametro+".per");
	     objectInputStream= new ObjectInputStream(fileInputStream);
		Persona person= (Persona) objectInputStream.readObject();
		System.out.println("111 el nombre de la persona leudo es:"+" "+person.getName());
		System.out.println("111 el nombre numero de la persona es:"+" "+person.getDocumentNumber());
	// Mientras haya objetos http://www.chuidiang.org/java/ficheros/ObjetosFichero.php
	while (person!=null)
	{
	    if (person instanceof Persona)
	       System.out.println("sI ENTRO AL WULE");
	    	System.out.println(person);  // Se escribe en pantalla el objeto
	    person = (Persona) objectInputStream.readObject();
	    arrayListPerson.add(person);
	    System.out.println("22 el nombre de la persona leudo es:"+" "+person.getName());
		System.out.println("222 el nombre numero de la persona es:"+" "+person.getDocumentNumber());
	}
	
	objectInputStream.close();
		
		}
	}
	}catch (Exception e) {
		System.out.println("fin del archivo");
		// TODO: handle exception
	}return arrayListPerson;
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
	
	@SuppressWarnings("unchecked")
	public ArrayList<Procesador> readListProce() throws IOException, ClassNotFoundException {
		//System.out.println(file.mkdir());
		System.out.println(file.exists());
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());
		
		fileInputStream = new FileInputStream(this.file);
		objectInputStream = new ObjectInputStream(fileInputStream);
		arrayListProcessor = (ArrayList<Procesador>)objectInputStream.readObject();
		objectInputStream.close();
		
		return arrayListProcessor;
		
	}
	
	
	
	/*
	 * Metodo para actualizar los datos de cualquier persona dentro del archivo
	 * 
	 */
	public void ActualizaFilePerson(int position,Persona p) throws Exception{
		fileOutputStream = new FileOutputStream("./src/"+getNamePersona()+".per");
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		ControFileAuxiliar Oss = new ControFileAuxiliar(fileOutputStream);
		if(position==0){
			objectOutputStream.writeObject(p);
			this.ControlReadPerson=0;
			System.out.println("SI PASO POR ACA"+ "valor del  control"+ControlReadPerson);
			objectOutputStream.close();
		}else
			if(position>=1){
			System.out.println("SI PASO POR ACA TAMNINEN HAY EEROR"+ControlReadPerson);
		ControlReadPerson=1;
		for(int i =0;i<=position;i++){
			Oss.writeUnshared(p);
			System.out.println("este es el valor de contador"+i);
			System.out.println("el valor del nombre de la persona  es"+ p.getDocumentNumber());
		}}

		Oss.close();
		}
	
	

	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}


	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}


	public FileOutputStream getFileOutputStream() {
		return fileOutputStream;
	}


	public void setFileOutputStream(FileOutputStream fileOutputStream) {
		this.fileOutputStream = fileOutputStream;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Personas getPersonas() {
		return personas;
	}


	public void setPersonas(Personas personas) {
		this.personas = personas;
	}


	public ObjectInputStream getObjectInputStream() {
		return objectInputStream;
	}


	public void setObjectInputStream(ObjectInputStream objectInputStream) {
		this.objectInputStream = objectInputStream;
	}


	public ObjectOutputStream getObjectOutputStream() {
		return objectOutputStream;
	}


	public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
		this.objectOutputStream = objectOutputStream;
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


	public ArrayList<Persona> getArrayListPerson() {
		return arrayListPerson;
	}


	public void setArrayListPerson(ArrayList<Persona> arrayListPerson) {
		this.arrayListPerson = arrayListPerson;
	}


	public ArrayList<Procesador> getArrayListProcessor() {
		return arrayListProcessor;
	}


	public void setArrayListProcessor(ArrayList<Procesador> arrayListProcessor) {
		this.arrayListProcessor = arrayListProcessor;
	}


	public ArrayList<Procesador> getArrayListProcessorArchive() {
		return arrayListProcessorArchive;
	}


	public void setArrayListProcessorArchive(ArrayList<Procesador> arrayListProcessorArchive) {
		this.arrayListProcessorArchive = arrayListProcessorArchive;
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
