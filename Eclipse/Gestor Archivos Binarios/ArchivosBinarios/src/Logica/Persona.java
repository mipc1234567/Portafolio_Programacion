package Logica;

import java.io.IOError;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import Interfaz.AdminPersonas;
import Interfaz.Personas;
import Persistencia.DocumentType;
import Persistencia.Genero;


/**
 * @author Mateo
 * @version 1.0
 * @param <Docmentype>
 * @created 20-mar.-2015 12:12:23 p. m.
 */
public class Persona implements Serializable{

	private ManagerFiles managerpersona;
	private Personas personas;
	private Date birthday;
	private int documentNumber;
	private DocumentType documentType;
	private Genero genero;
	private String lastName;
	private String name;
	private String genre;
	private String Email;
//	private Genero genero;
	public AdminPersonas Persona;
	public String controls;
	
	/**
	 * Inicializa los atributos pertinentes de la clase
	 */
public  Persona(int numeroDocumento,String genero, String nombre,Date fecha,String email){
String auxiliar="no esta parametrizado";
//	personas[cont]=name;	
//	 auxiliar= JOptionPane.showInputDialog("____Fecha___\n1.ingreser su fecha completa de nacimiento \n2.Dia/Mes/Año\n3.dd/dd/aa/\n4.Ingrese los numeros separado por ");		
	//System.out.println("la fecha no fue ingresada correctamente");
setEmail(email);
setGenre(genero);
setDocumentNumber(numeroDocumento);
setName(nombre);
//PENDIENTE POR CONFIGURAR
setDocumentType(documentType);
setBirthday(birthday);
setLastName(auxiliar);
	
	}


public  Persona(Persona P){
	//String auxiliar="mateo falta";
//	personas[cont]=name;	
//	 auxiliar= JOptionPane.showInputDialog("____Fecha___\n1.ingreser su fecha completa de nacimiento \n2.Dia/Mes/Año\n3.dd/dd/aa/\n4.Ingrese los numeros separado por ");		
	//System.out.println("la fecha no fue ingresada correctamente");
setEmail(P.getEmail());
setGenre(P.getGenre());
setDocumentNumber(P.getDocumentNumber());
setName(P.getName());
//PENDIENTE POR CONFIGURAR
setDocumentType(P.getDocumentType());
setBirthday(P.getBirthday());
setLastName(P.getLastName());	
}


//-----------------------LOS METODOS-------------------------


public void validarPersona(int numeroDocumento,String genero, String nombre,String apellido,Date fecha,String email){

setEmail(email);
setGenre(genero);
setDocumentNumber(numeroDocumento);
setName(nombre);
setLastName(apellido);
//PENDIENTE POR CONFIGURAR
setDocumentType(documentType);
setBirthday(birthday);
String var="";

//validacion del numero de documento
if(numeroDocumento!=0){
var="1";
System.out.println("su"+" "+numeroDocumento+" "+"es correcto");
}else{
	if(numeroDocumento>99999999 || numeroDocumento==0){
var="0";
JOptionPane.showMessageDialog(null, "SU NUMERO De documento no es correcto NO ES CORRECTO");
	}else{
	}
}
//validacion del email	
if(email.equals(" ") || email.endsWith(";")  || (email.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<"))){
	var="0";	
	JOptionPane.showMessageDialog(null, "SU EMAIL NO ES CORRECTO");
	
}else{
	if(!email.equals(" ") && !email.endsWith(";")  && !(email.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<"))){
	var="1";
	System.out.println("su"+" "+email+" es  correcto");	
	}
	
	
}
//validacion como string 
if(genero.equalsIgnoreCase("Femenino")==true || genero.equalsIgnoreCase("Masculino")==true){
var="1";
System.out.println("su"+" "+genero+" es  correcto");
}else{
//validacion del genero
	System.out.println("el valor del genreo es"+ " "+genero);
if(genero!="Femenino"|| genero!=("Masculino")){
var="0";
JOptionPane.showMessageDialog(null, "SU GENERO NO ES CORRECTO");
}
//validacion del nombre

}if(!nombre.equals(" ") && (!nombre.contentEquals(";.#$%&/()=?¡*][:;-{}+´¿>12345567890<")) && nombre.toUpperCase().charAt(0)==(nombre.charAt(0))){	
var="1";
System.out.println("su"+" "+nombre+" es  correcto");
}else{
if(nombre.equals("  ") || (nombre.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<")) ||nombre.toUpperCase().charAt(0)!=(nombre.charAt(0))){	
	var="0";	
	JOptionPane.showMessageDialog(null, "SU NOMBRE NO ES CORRECTO");
	
	
// Validacion del apellido

}
}


if(!apellido.equals("  ") && (apellido.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<")) && apellido.toUpperCase().charAt(0)==(apellido.charAt(0))){	
var="1";
System.out.println("su"+" "+apellido+" es  correcto");
}else{
if(nombre.equals("  ") || (!apellido.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<")) ||!(apellido.toUpperCase().charAt(0)!=(apellido.charAt(0)))){	
	var="0";	
	JOptionPane.showMessageDialog(null, "SU APELLIDO NO ES CORRECTO");

	}

}
//PEDIENTE
//validacion de la fecha
if(fecha.equals("!##$%&/()=??¡*][_:]")){
var+="0";
JOptionPane.showMessageDialog(null, "SU FECHA NO ES CORRECTO");
}else{
	var+="1";
	System.out.println("su"+" "+fecha+" "+ " no es correcto");
}
System.out.println( var);
controls=var;
}

	


/*}catch(IOError e){
	e.printStackTrace();
	System.out.println("los datos no fueron ingresados correctamente");
}
}*/


//validacion como enumerado



public void asignarTipoDocumento(){
//personas= new Personas();
int i=0;
int n=DocumentType.values().length;
for (int j=0; j<n; j++) {
    System.out.println(i);
//personas.getCombobox().getSelectedItem().equals(arg0)
	if (DocumentType.values()[j].equals(DocumentType.CC)){
		System.out.println("es una cedula:");
	}else{
	if (DocumentType.values()[j].equals(DocumentType.CE ))
		System.out.println("es una cedula de extrangeria");
	
	}
	if(DocumentType.values()[j].equals(DocumentType.TI)){
		System.out.println("es una Tarjeta de identidad");
	}
	}
	}




public void asignarGenero(){

int i=0;
int n=Genero.values().length;
for (int j=0; j<n; j++) {
    System.out.println(i);
//personas.getCombobox().getSelectedItem().equals(arg0)
	if (Genero.values()[j].equals(Genero.F)){
		System.out.println("es una cedula:");
	}else{
	if (Genero.values()[j].equals(Genero.M ))
		System.out.println("es una cedula de extrangeria");
	
	}

	}
	}




//----------------------LOS GET Y LOS SET-----------------------------

	public ManagerFiles getManagerpersona() {
		return managerpersona;
	}

	public void setManagerpersona(ManagerFiles managerpersona) {
		this.managerpersona = managerpersona;
	}




	public Personas getPersonas() {
		return personas;
	}





	public void setPersonas(Personas personas) {
		this.personas = personas;
	}





	public Date getBirthday() {
		return birthday;
	}





	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}





	public int getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(int documentNumber) {
		this.documentNumber = documentNumber;
	}



	public DocumentType getDocumentType() {
		return documentType;
	}





	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}





	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdminPersonas getPersona() {
		return Persona;
	}

	public void setPersona(AdminPersonas persona) {
		Persona = persona;
	}



	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}





	public Genero getGenero() {
		return genero;
	}





	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public String getControls() {
		return controls;
	}


	public void setControls(String controls) {
		this.controls = controls;
	}



	

	//---------------LOS GET Y LOS SET-----------------------------------
	
	
	
	
	
}//end Persona
