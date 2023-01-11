package Logica;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class SearchPerson {
	private ArrayList<String> arrayList;

	private Persona person;
	private int delete = 0;
	
	public SearchPerson() {
		person = null;
	}
	
	public ArrayList<String> searchPersonTipeDoc(ArrayList<Persona> personArr, String tipe){
		this.person=null;
		arrayList=new ArrayList<String>();
		for (Persona person : personArr) {
			if(person.getDocumentType().equals(tipe)){
				this.person = person;
				arrayList.add(person.getDocumentType()+" No:"+person.getDocumentNumber()+" Nombres:"+person.getName()
						+" Apellidos:"+person.getLastName()+" Género:"+person.getGenre()+" Fecha:"+person.getBirthday().getDay()+"/"+person.getBirthday().getMonth()+"/"+person.getBirthday().getYear()+" \n");
			}
		}
		if(arrayList.size()==0){
			JOptionPane.showMessageDialog(null, "No hay ninguno");
		}
		return arrayList;
	}
	
	public ArrayList<String> showPersonTipeDoc(ArrayList<Persona> person){
		arrayList=new ArrayList<String>();
		for (Persona dato : person) {
				arrayList.add("Tipo de Documento: ------------------>  "+dato.getDocumentType()+"\n");
		}
		return arrayList;
	}
	public ArrayList<String> searchPersonNumberDoc(ArrayList<Persona> personArr, int numeroDoc){
		this.person=null;
		arrayList=new ArrayList<String>();
		for (Persona person : personArr) {
		
			if(person.getDocumentNumber()==(numeroDoc)){
				this.person = person;
				arrayList.add(person.getDocumentType()+" No:"+person.getDocumentNumber()+" Nombres:"+person.getName()
						+" Apellidos:"+person.getLastName()+" Género:"+person.getGenre()+" Fecha:"+person.getBirthday().getDay()+"/"+person.getBirthday().getMonth()+"/"+person.getBirthday().getYear()+" \n");
			}
		}
		if(arrayList.size()==0){
			JOptionPane.showMessageDialog(null, "No hay ninguno");
		}
		return arrayList;
	}
	public ArrayList<String> showPersonNumberDoc(ArrayList<Persona> person){
		arrayList=new ArrayList<String>();
		for (Persona dato : person) {
				arrayList.add("Número de documento: ----->  "+dato.getDocumentNumber()+"\n");
		}
		return arrayList;
	}
	public ArrayList<String> searchPersonNames(ArrayList<Persona> personArr, String names){
		this.person=null;
		arrayList=new ArrayList<String>();
		for (Persona person : personArr) {
			if(person.getName().equals(names)){
				this.person = person;
				arrayList.add(person.getDocumentType()+" No:"+person.getDocumentNumber()+" Nombres:"+person.getName()
						+" Apellidos:"+person.getLastName()+" Género:"+person.getGenre()+" Fecha:"+person.getBirthday().getDay()+"/"+person.getBirthday().getMonth()+"/"+person.getBirthday().getYear()+" \n");
			}
		}
		if(arrayList.size()==0){
			JOptionPane.showMessageDialog(null, "No hay ninguno");
		}
		return arrayList;
	}
	public ArrayList<String> showPersonNames(ArrayList<Persona> person){
		arrayList=new ArrayList<String>();
		for (Persona dato : person) {
				arrayList.add("Nombre:------>   "+dato.getName()+"\n");
			}
		return arrayList;
	}
	public ArrayList<String> searchPersonLastName(ArrayList<Persona> personArr, String lastNames){
		this.person=null;
		arrayList=new ArrayList<String>();
		for (Persona person : personArr) {
			if(person.getLastName().equals(lastNames)){
				this.person = person;
				arrayList.add(person.getDocumentType()+" No:"+person.getDocumentNumber()+" Nombres:"+person.getName()
						+" Apellidos:"+person.getLastName()+" Género:"+person.getGenre()+" Fecha:"+person.getBirthday().getDay()+"/"+person.getBirthday().getMonth()+"/"+person.getBirthday().getYear()+" \n");
			}
		}
		if(arrayList.size()==0){
			JOptionPane.showMessageDialog(null, "No hay ninguno");
		}
		return arrayList;
	}
	public ArrayList<String> showPersonLastName(ArrayList<Persona> person){
		arrayList=new ArrayList<String>();
		for (Persona dato : person) {
				arrayList.add("Apellidos: ----->   "+dato.getLastName()+"\n");
			}
		return arrayList;
	}
	public ArrayList<String> searchPersonGender(ArrayList<Persona> personArr, char gender){
		this.person=null;
		arrayList=new ArrayList<String>();
		for (Persona person : personArr) {
			if(person.getGenre().charAt(0)==(gender)){
				this.person = person;
				arrayList.add(person.getDocumentType()+" No:"+person.getDocumentNumber()+" Nombres:"+person.getName()
						+" Apellidos:"+person.getLastName()+" Género:"+person.getGenre()+" Fecha:"+person.getBirthday().getDay()+"/"+person.getBirthday().getMonth()+"/"+person.getBirthday().getYear()+" \n");
			}
		}
		if(arrayList.size()==0){
			JOptionPane.showMessageDialog(null, "No hay ninguno");
		}
		return arrayList;
	}
	public ArrayList<String> showPersonGender(ArrayList<Persona> person){
		arrayList=new ArrayList<String>();
		for (Persona dato : person) {
				arrayList.add("Género: --->  "+dato.getGenre()+"\n");
		}
		return arrayList;
	}
	public ArrayList<String> searchPersonDate(ArrayList<Persona> personArr, String date){
		this.person=null;
		arrayList=new ArrayList<String>();
		for (Persona person : personArr) {
			if(person.getBirthday().toString().equals(date)){
				this.person=person;
				arrayList.add(person.getDocumentType()+" No:"+person.getDocumentNumber()+" Nombres:"+person.getName()
						+" Apellidos:"+person.getLastName()+" Género:"+person.getGenre()+" Fecha:"+person.getBirthday().getDay()+"/"+person.getBirthday().getMonth()+"/"+person.getBirthday().getYear()+" \n");
				
			}
		}
		if(arrayList.size()==0){
			JOptionPane.showMessageDialog(null, "No hay ninguno");
		}
		return arrayList;
	}
	public ArrayList<String> showPersonDate(ArrayList<Persona> person){
		arrayList=new ArrayList<String>();
		for (Persona dato : person) {
				arrayList.add("Fecha de nacimiento: ------>  "+dato.getBirthday()+"\n");
		}
		return arrayList;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public Persona getPerson() {
		return person;
	}

	public void setPerson(Persona person) {
		this.person = person;
	}
	
}
