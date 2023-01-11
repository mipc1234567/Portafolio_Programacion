package Logica;

import java.io.Serializable;

import javax.swing.JOptionPane;

import Interfaz.AdminProcesadores;
import Persistencia.Cache;
import Persistencia.Marca;


/**
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:25 p. m.
 */
public class Procesador implements Serializable {

	
	
	private Cache cachep;
	private Marca marcap;
	private ManagerFiles manager;
	private int cache;
	private int FrecuenciaReloj;
	private String Instrucciones;
	private String marca;
	private int NumeroNucleos;
	private AdminProcesadores adminProcesador;


	public Procesador(String marca, int cache, int frecuencia,int numeroNucleos,String conjuntoInstrucciones){

	setCache(cache);
	setMarca(marca);
	setFrecuenciaReloj(frecuencia);
	setNumeroNucleos(numeroNucleos);
	setInstrucciones(conjuntoInstrucciones);
		
	}
	
	public  Procesador(Procesador P){
		setCache(P.getCache());
		setMarca(P.getMarca());
		setFrecuenciaReloj(P.getFrecuenciaReloj());
		setNumeroNucleos(P.getNumeroNucleos());
		setInstrucciones(P.getInstrucciones());
	}
	
	public void validarProcesador(String marca, int cache, int frecuencia,int numeroNucleos,String conjuntoInstrucciones){
		String var="";
		setCache(cache);
		setMarca(marca);
		setFrecuenciaReloj(frecuencia);
		setNumeroNucleos(numeroNucleos);
		setInstrucciones(conjuntoInstrucciones);
		
		
		
		//validacion de frecuencia
		if(frecuencia!=0 || frecuencia<2041){
		var+="1";
		System.out.println("su"+" "+frecuencia+" "+"es correcto");
		}else{
			if(frecuencia>99999999 && frecuencia==0){
		var+="0";
		JOptionPane.showMessageDialog(null, "SU FRECUENCIA NO ES CORRECTO");
			}else{
			}
		}
		
		//validacion de memoria cache
		if(cache!=0 && cache<=256 && cache>=64){
			var+="1";
			System.out.println("su"+" "+cache+" "+"es correcto");
			}else{
				if(cache==0 || cache>256 || cache<64){
			var+="0";
			JOptionPane.showMessageDialog(null, "SU CACHE NO ES CORRECTO");
				}else{
				}
			}
		
		//validacion del Marca
		if(marca.equals(" ") || marca.endsWith(";")  || (marca.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<"))){
			var+="0";	
			JOptionPane.showMessageDialog(null, "SU Marca NO ES CORRECTO");
			
		}else{
			if(!marca.equals(" ") && !marca.endsWith(";")  && !(marca.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<"))){
			var+="1";
			System.out.println("su"+" "+marca+" es  correcto");	
			}
			
			
		}
		if(numeroNucleos!=0 && numeroNucleos<=0 && numeroNucleos>=4){
			var+="1";
			System.out.println("su"+" "+numeroNucleos+" "+"es correcto");
			}else{
				if(numeroNucleos==0 || numeroNucleos>4 || numeroNucleos<0){
			var+="0";
			JOptionPane.showMessageDialog(null, "SU numeroNucleos NO ES CORRECTO");
				}else{
				}
			}
		
		
		if(marca.equals(" ") || marca.endsWith(";")  || (marca.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<"))){
			var+="0";	
			JOptionPane.showMessageDialog(null, "SU Marca NO ES CORRECTO");
			
		}else{
			if(!marca.equals(" ") && !marca.endsWith(";")  && !(marca.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<"))){
			var+="1";
			System.out.println("su"+" "+marca+" es  correcto");	
			}
		

		}
		if(conjuntoInstrucciones.equals(" ") || conjuntoInstrucciones.endsWith(";")  || (conjuntoInstrucciones.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<"))){
			var+="0";	
			JOptionPane.showMessageDialog(null, "SU conjuntoInstrucciones NO ES CORRECTO");
			
		}else{
			if(!conjuntoInstrucciones.equals(" ") && !conjuntoInstrucciones.endsWith(";")  && !(conjuntoInstrucciones.contentEquals(";.!!#$%&/()=?¡*][:;-{}+´¿>12345567890<"))){
			var+="1";
			System.out.println("su"+" "+conjuntoInstrucciones+" es  correcto");	
			}
	}
	

	}
	
	
	
	
	public void asignarMarca(String tipo){

		int i=0;
		int n=Marca.values().length;
		for (int j=0; j<n; j++) {
		    System.out.println(i);
		//personas.getCombobox().getSelectedItem().equals(arg0)
			if (Marca.values()[j].equals(tipo)){
				System.out.println("es un procesador:"+tipo);
			
			}

			}
			}
	
	
	public void asignarCache(String tipo){

		int i=0;
		int n=Cache.values().length;
		for (int j=0; j<n; j++) {
		    System.out.println(i);
		//personas.getCombobox().getSelectedItem().equals(arg0)
			if (Cache.values()[j].equals(tipo)){
				System.out.println("es una cedula:");
	
			}
		}
		}


	public ManagerFiles getManager() {
		return manager;
	}


	public void setManager(ManagerFiles manager) {
		this.manager = manager;
	}




	

	public Cache getCachep() {
		return cachep;
	}

	public void setCachep(Cache cachep) {
		this.cachep = cachep;
	}

	public Marca getMarcap() {
		return marcap;
	}

	public void setMarcap(Marca marcap) {
		this.marcap = marcap;
	}

	public int getCache() {
		return cache;
	}

	public void setCache(int cache) {
		this.cache = cache;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getFrecuenciaReloj() {
		return FrecuenciaReloj;
	}


	public void setFrecuenciaReloj(int frecuenciaReloj) {
		FrecuenciaReloj = frecuenciaReloj;
	}


	public String getInstrucciones() {
		return Instrucciones;
	}


	public void setInstrucciones(String instrucciones) {
		Instrucciones = instrucciones;
	}





	public int getNumeroNucleos() {
		return NumeroNucleos;
	}


	public void setNumeroNucleos(int numeroNucleos) {
		NumeroNucleos = numeroNucleos;
	}



	
}//end Procesador