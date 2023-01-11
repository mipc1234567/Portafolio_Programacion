package Logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import Interfaz.ParametrosGenerales;
import Persistencia.ControFileAuxiliar;
import Persistencia.ControlFile;

/**
 * Permite administrar la creacion de los archivos en este caso archivos binarios
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:20 p. m.
 */
public class ManagerFiles {

//	
	
	/**
	 * permite controlar la creacion de los archivos
	 */
	
	private ControFileAuxiliar auxiliarcontrol;
	//private ControlFile controlfile;
	
	/**
	 * permite controlar la creacion de los archivos
	 */
	
	

	private String parametro;
	

	//Numero de la posicion del objeto	
	private int cont;

	

	private ArrayList<Persona> arrayListPerson;
	
	

	private ArrayList<Procesador> arrayListProcesa;
	
	private Persona persona;
	private Procesador procesador;
	private ManagerFiles Manger;
	public String ParaPer;
	public String paraPro;
	
	
	public ManagerFiles(String param) {
		this.parametro=param;
		setParametro(param);
		 arrayListPerson = new ArrayList<Persona>();
		 arrayListProcesa = new ArrayList<Procesador>();
	
	}
		
	
	public ManagerFiles() {
		arrayListPerson = new ArrayList<Persona>();
		 arrayListProcesa = new ArrayList<Procesador>();
	
	
	}
		// TODO Auto-generated constructor stub
	

	public void finalize() throws Throwable {

	}
	
	
	
 public void initializacePersona(){
	 //persona= new Persona(1052338678,"F","mateo","Pena",new Date(19, 9, 2014),"maiu234@gmail.com");
//	 persona=  new Persona(persona.getDocumentNumber(),persona.getName(),persona.getLastName(),persona.getGenre(),persona.getBirthday(),persona.getEmail());
	 arrayListPerson = new ArrayList<Persona>();
	System.out.println("wel nombre del parametro es "+ parametro);
	// controlfile= new ControlFile(parametro);
	 //controlfile.initializacePer();
	 
	 try {
		auxiliarcontrol= new ControFileAuxiliar();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     auxiliarcontrol.InitialiceControFileAuxiliar(parametro);
	 auxiliarcontrol.initializacePer();
	 
 }
 
 public void initializaceProcesador(){
	 //persona= new Persona(1052338678,"F","mateo","Pena",new Date(19, 9, 2014),"maiu234@gmail.com");
//	 persona=  new Persona(persona.getDocumentNumber(),persona.getName(),persona.getLastName(),persona.getGenre(),persona.getBirthday(),persona.getEmail());
	 arrayListProcesa = new ArrayList<Procesador>();
	 System.out.println("wel nombre del parametro es "+ parametro);
	 //controlfile= new ControlFile(parametro);
	 //controlfile.initializacePro();
	 try {
			auxiliarcontrol= new ControFileAuxiliar();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 auxiliarcontrol.InitialiceControFileAuxiliar(parametro);
	 auxiliarcontrol.initializacePro();
	 
 }
 


 
 public void SavePersona(Persona p,int parame) throws Exception{
	cont=parame;
	 //persona = new Persona(p.getDocumentNumber(), p.getGenre(), p.getName(), p.getBirthday(), p.getEmail());
	 //arrayListPerson = new ArrayList<Persona>();
	//System.out.println("el tamaño del array es" +arrayListPerson.size());
	 //controlfile= new ControlFile(parametro);
	 auxiliarcontrol= new ControFileAuxiliar();
	 auxiliarcontrol.InitialiceControFileAuxiliar(parametro);
	 setParaPer(parametro);
	 
	 persona=p;
	 System.out.println("Numero de documento"+p.getDocumentNumber());
	 System.out.println("Genero"+p.getGenre());
	 System.out.println("Nombre de la persona"+p.getName());
	 //System.out.println("el tamaño del array list persona es"+arrayListPerson.size());
	 arrayListPerson.add(persona);
	 System.out.println(arrayListPerson.isEmpty());
	 System.out.println("el tamaño del array list persona ahora es"+arrayListPerson.size());
	 
	 
	
	  try {
		//controlfile.createFilePerson(parametro);
	//	controlfile.SaveFilePerson(arrayListPerson,cont);
        auxiliarcontrol.SaveFilePerson(arrayListPerson, cont);
		cont++;
		
	} catch (IOException e) {
		e.printStackTrace();
		// TODO Auto-generated catch block
		
	}
	 
 }
 public void SaveProcesador(Procesador p,int parame) throws Exception{
	 cont=parame;
	// arrayListProcesa = new ArrayList<Procesador>();
	//controlfile= new ControlFile(parametro);
	auxiliarcontrol= new ControFileAuxiliar();
	 auxiliarcontrol.InitialiceControFileAuxiliar(parametro);
	 procesador=p;
	 setParaPro(parametro);
	 System.out.println("el valor del parametro procesador es"+paraPro);
	 System.out.println("Numero de documento"+p.getCache());
	 System.out.println("Numero de documento"+p.getMarca());
	 System.out.println("el tamaño del array list procesador  es"+arrayListProcesa.size());
	 arrayListProcesa.add(procesador);
	 System.out.println("el tamaño del array list procesador ahora es es"+arrayListProcesa.size());
	
	  try {
		//controlfile.createFilePerson(parametro);
		//controlfile.SaveFileProcesador(arrayListProcesa,cont);
		auxiliarcontrol.SaveFileProcesador(arrayListProcesa, cont);
		
		//System.out.println("el tamaño del array lis  procesador ahora  es"+arrayListPerson.size());
		
	} catch (IOException e) {
		e.printStackTrace();
		// TODO Auto-generated catch block
		
	}
	 
 }
 
 
 public void ReadProcesador() throws Exception{
	 try {
	
		 System.out.println("EL VALOR DEL PARAMETRO DEL ARCHVIO ES"+getParaPro());
		 //	 controlfile.ReadFileProcesador(arrayListProcesa.size()-1);
auxiliarcontrol.ReadFileProcesador(arrayListProcesa.size(),getParaPro());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		 }
 }
 public void ReadPersona() throws Exception{
	 try {
		 System.out.println("el valor de la persona en Manager es: "+getParaPer());
	//	 controlfile.ReadFilePerson(arrayListPerson.size(),getParaPer());
		 auxiliarcontrol.ReadFilePerson(arrayListPerson.size(),getParaPer());
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		 }
 }
 
 
 public void EditPersona(Persona p,int parame) throws Exception{
		cont=parame;
		 //persona = new Persona(p.getDocumentNumber(), p.getGenre(), p.getName(), p.getBirthday(), p.getEmail());
		 //arrayListPerson = new ArrayList<Persona>();
		//System.out.println("el tamaño del array es" +arrayListPerson.size());
		 //controlfile= new ControlFile(parametro);
		 auxiliarcontrol= new ControFileAuxiliar();
		 auxiliarcontrol.InitialiceControFileAuxiliar(parametro);
		 setParaPer(parametro);
		 
		 persona=p;
		 System.out.println("Numero de documento"+p.getDocumentNumber());
		 System.out.println("Genero"+p.getGenre());
		 System.out.println("Nombre de la persona"+p.getName());
		 //System.out.println("el tamaño del array list persona es"+arrayListPerson.size());
		 arrayListPerson.set(cont, persona);
		 System.out.println(arrayListPerson.isEmpty());
		 System.out.println("el tamaño del array list persona ahora es"+arrayListPerson.size());
		 
		 
		
		  try {
			//controlfile.createFilePerson(parametro);
		//	controlfile.SaveFilePerson(arrayListPerson,cont);
	        auxiliarcontrol.ActualizaFilePerson(cont,persona);
			cont++;
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			
		}
		 
	 }
 
 

	/**
	 * 
	 * @param o0
	 * @param o1
	 */
	private void ManagerFiles(Persona o0){

	}

	/**
	 * 
	 * @param o0
	 * @param o1
	 */
	public void ManagerFiles(Procesador o0){

	}

	/**
	 * 
	 * @param o0
	 */
	private Persona Borrar(Persona o0){
		return null;
	}

	/**
	 * 
	 * @param o0
	 */
	private Procesador Borrar(Procesador o0){
		return null;
	}

	/**
	 * permite buscar una persona con todos sus datos
	 * 
	 * @param o0
	 */
	private Persona Buscar(Persona o0){
		return null;
	}

	/**
	 * 
	 * @param o0
	 */
	private void Buscar(Procesador o0){

	}
	/**
	public ControlFile getControlfile() {
		return controlfile;
	}

	public void setControlfile(ControlFile controlfile) {
		this.controlfile = controlfile;
	}
*/
	public ArrayList<Persona> getArrayListPerson() {
		return arrayListPerson;
	}

	public void setArrayListPerson(ArrayList<Persona> arrayListPerson) {
		this.arrayListPerson = arrayListPerson;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * 
	 * @param o0
	 * @param o1
	 * @param o2
	 *//*
	private Persona Cambiar(Persona o0, Nombre o1, Apellido o2){
		return null;
	}

	*//**
	 * 
	 * @param o0
	 * @param o1
	 * @param o2
	 *//*
	public void Cambiar(Procesador o0, Nombre o1, Apellido o2){

	}*/

	public Language ChangeLanguage(){
		return null;
	}
	

	
	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public ArrayList<Procesador> getArrayListProcesa() {
		return arrayListProcesa;
	}

	public void setArrayListProcesa(ArrayList<Procesador> arrayListProcesa) {
		this.arrayListProcesa = arrayListProcesa;
	}


	public String getParaPer() {
		return ParaPer;
	}


	public void setParaPer(String paraPer) {
		ParaPer = paraPer;
	}


	public String getParaPro() {
		return paraPro;
	}


	public void setParaPro(String paraPro) {
		this.paraPro = paraPro;
	}
}//end ManagerFiles