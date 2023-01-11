package Interfaz;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

import Logica.Language;
import Logica.ManagerFiles;
import Persistencia.ControlFile;

/**
 * permite almacernar objetos de personas y de procesadores
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:21 p. m.
 */
public class Change implements ActionListener{

	public AdminProcesadores AdminProcesadores;
	public Interfaz.AdminPersonas AdminPersonas;
	public Personas personas;
	public Procesadores procesadores;
	public ParametrosGenerales parametrosgenerales;
	public MainWindow mainWindow;
	public Language language;
	public ManagerFiles File;
	public String persona;
	public String procesador;
	

public Change(String Persona, String Procesador,ManagerFiles fils) throws ClassNotFoundException, IOException{
		this.File=fils;
		AdminPersonas= new AdminPersonas();
		AdminProcesadores= new AdminProcesadores();
		//mainWindow=new MainWindow(persona,procesador,File );
		//personas= new Personas(Persona,Procesador);
		//procesadores=new Procesadores(Persona,Procesador);
		parametrosgenerales=new ParametrosGenerales();
		persona=Persona;
		procesador=Procesador;
		
		
		
/*		ChangeEspañol();
		
		ChangeEnglish();*/
		
	
	}

public void ChangeEspañol(){
	language= new Language();
	  	if(language.getName()==language.namefile){
//	  		language.setName(language.namefile);
	  		try {
	  			
	  			
	  			
	  			//----leyendas a configurar de adpersonas
	  			mainWindow=new MainWindow(persona,procesador,File);
	  			personas= new Personas(persona,procesador,File);
				procesadores=new Procesadores(persona,procesador,File);
//	  			AdminPersonas.getJlbldatos().setText(language.leer("3"));
	  			AdminPersonas.getBtnCancelar().setText(language.leer("25"));
	  			AdminPersonas.getBtnModificar().setText(language.leer("24"));
	  			AdminPersonas.getBtnNuevo().setText(language.leer("23"));
	  			AdminPersonas.setNombre(language.leer("17"));
	  			AdminPersonas.setApellido(language.leer("18"));
	  			AdminPersonas.setNumeroDoc(language.leer("19"));
	  			AdminPersonas.setGenero(language.leer("20"));
	  			AdminPersonas.setEmail(language.leer("21"));
	  			AdminPersonas.setFechaNacimiento(language.leer("22"));
	  			
//----leyendas a congigurar menu-------
	  			
	  			
	  			mainWindow.getMenuitem1().setText(language.leer("10"));
	  			mainWindow.getMenuitem2().setText(language.leer("11"));
	  			mainWindow.getMenuitem3().setText(language.leer("13"));
	  			mainWindow.getMenuitem5().setText(language.leer("14"));
	  			mainWindow.getMenuitem4().setText(language.leer("32"));
	  			mainWindow.getMenuObjetos().setText(language.leer("12"));
	  			mainWindow.getMenuAcerca().setText(language.leer("15"));
	  			mainWindow.getMenuArchivo().setText(language.leer("9"));
	  			
	  			
	  
	  			
	  		//pendiente	
	//AdminPersonas.getCombobox().getItemAt(1).(arg0);
//	  	AdminPersonas.getCombobox1().setText(language.leer("3"));;
	  		
	  			
	  			
	  			//------------leyendas a configurar de adprocesador
	  			
	  			//AdminProcesadores.getJlbldatos().setText(language.leer("3"));
	  			
	  			AdminProcesadores.getBtnCancelar().setText(language.leer("25"));
	  			AdminProcesadores.getBtnModificar().setText(language.leer("24"));
	  			AdminProcesadores.getBtnNuevo().setText(language.leer("23"));
	  			AdminProcesadores.setNumeroNuc(language.leer("28"));
	  			AdminProcesadores.setMarca(language.leer("27"));
	  			AdminProcesadores.setFrecuenciaReloj(language.leer("29"));
	  			AdminProcesadores.setCache(language.leer("30"));
	  			AdminProcesadores.setConjuntoInstrucciones(language.leer("31"));
	  			
	  			
	  	
	  			
	  			
	  			//------leyendas de personas
	  			
	  			personas.getJbtnCancelar().setText(language.leer("25"));
	  			personas.getJbtnNuevp().setText(language.leer("23"));
	  			personas.getJlbdatosapellido().setText(language.leer("18"));
	  		//	personas.getJlbdatosCC().setText(language.leer("33"));
	  			personas.getJlbdatosEmail().setText(language.leer("21"));
	  			personas.getJlbdatosfecha().setText(language.leer("22"));
	  			personas.getJlbdatosgenero().setText(language.leer("44"));
	  			personas.getJlbdatosnombre().setText(language.leer("33"));
	  			personas.getJlbdatostipod().setText(language.leer("34"));
	  			personas.getJlbnumerodocumento().setText(language.leer("36"));
	  	
	  			
	  			//--------------leyenda de procesadores
	  			
	  			
	  			procesadores.getJbtnCancelar().setText(language.leer("25"));
	  			procesadores.getJbtnGuardar().setText(language.leer("23"));
	  		//	procesadores.getJbtnModificar().setText(language.leer("24"));
	  			procesadores.getJLabelCache().setText(language.leer("41"));
	  			procesadores.getJlbConjuntodeInstrucciones().setText(language.leer("42"));
	  			procesadores.getJlbNumeroNucleos().setText(language.leer("40"));
	  			procesadores.getJlbMarca().setText(language.leer("39"));
	  	
	  			
	  			
	  			
	  			
	  			//---------leyenda de los parametros generales
	  			
	  			parametrosgenerales.getJButtonGuardar().setText(language.leer("7"));
	  			parametrosgenerales.getIdioma().setText(language.leer("2"));
	  			parametrosgenerales.getArchivoPersona().setText(language.leer("5"));
	  			parametrosgenerales.getArchivoProcesador().setText(language.leer("6"));
	  			parametrosgenerales.getCombobox().setName(language.leer("2"));
	  			
				
	  			
	  		
	  		} catch (IOException e2) {
	  			// TODO Auto-generated catch block
	  			e2.printStackTrace();
	 
	  	}
	  	}
}
	  		public void ChangeEnglish(){
	  			language= new Language();
	  			if(language.getName()==language.namefile){
	  		  		language.setName(language.namefile1);
	  	try {
	  		
	  		
	  	
	  	
  			
  			
  			
  			//----leyendas a configurar de adpersonas
	  		mainWindow=new MainWindow(persona,procesador,File );
	  		personas= new Personas(persona,procesador,File);
			procesadores=new Procesadores(persona,procesador,File);
//  			AdminPersonas.getJlbldatos().setText(language.leer("3"));
  			AdminPersonas.getBtnCancelar().setText(language.leer("0"));
  			AdminPersonas.getBtnModificar().setText(language.leer("24"));
  			AdminPersonas.getBtnNuevo().setText(language.leer("23"));
  			AdminPersonas.setNombre(language.leer("17"));
  			AdminPersonas.setApellido(language.leer("18"));
  			AdminPersonas.setNumeroDoc(language.leer("19"));
  			AdminPersonas.setGenero(language.leer("20"));
  			AdminPersonas.setEmail(language.leer("21"));
  			AdminPersonas.setFechaNacimiento(language.leer("22"));
  			
//----leyendas a congigurar menu-------
  			
  			
  			/*mainWindow.getButtonSalir().setText(language.leer("3"));
  			mainWindow.getButtonVolver().setText(language.leer("3"));*/
  			mainWindow.getMenuitem1().setText(language.leer("10"));
  			mainWindow.getMenuitem2().setText(language.leer("11"));
  			mainWindow.getMenuitem3().setText(language.leer("13"));
  			mainWindow.getMenuitem5().setText(language.leer("14"));
  			mainWindow.getMenuitem4().setText(language.leer("32"));
  			mainWindow.getMenuObjetos().setText(language.leer("12"));
  			mainWindow.getMenuAcerca().setText(language.leer("15"));
  			mainWindow.getMenuArchivo().setText(language.leer("9"));
  			mainWindow.getMenuitem6().setText(language.leer("13"));
  			mainWindow.getMenuitem7().setText(language.leer("14"));
  			mainWindow.getCrear().setText(language.leer("45"));
  
  			
  		//pendiente	
//AdminPersonas.getCombobox().getItemAt(1).(arg0);
//  	AdminPersonas.getCombobox1().setText(language.leer("3"));;
  		
  			
  			
  			//------------leyendas a configurar de adprocesador
  			
  			//AdminProcesadores.getJlbldatos().setText(language.leer("3"));
  			
  			AdminProcesadores.getBtnCancelar().setText(language.leer("25"));
  			AdminProcesadores.getBtnModificar().setText(language.leer("24"));
  			AdminProcesadores.getBtnNuevo().setText(language.leer("23"));
  			AdminProcesadores.setNumeroNuc(language.leer("28"));
  			AdminProcesadores.setMarca(language.leer("27"));
  			AdminProcesadores.setFrecuenciaReloj(language.leer("29"));
  			AdminProcesadores.setCache(language.leer("30"));
  			AdminProcesadores.setConjuntoInstrucciones(language.leer("31"));
  			
  			
  	
  			
  			
  			//------leyendas de personas
  			
  			personas.getJbtnCancelar().setText(language.leer("25"));
  		//	personas.getJbtnModificar().setText(language.leer("24"));
  			personas.getJbtnNuevp().setText(language.leer("23"));
  			personas.getJlbdatosapellido().setText(language.leer("18"));
//  		personas.getJlbdatosCC().setText(language.leer("33"));
  			personas.getJlbdatosEmail().setText(language.leer("21"));
  			personas.getJlbdatosfecha().setText(language.leer("22"));
  			personas.getJlbdatosgenero().setText(language.leer("44"));
  			personas.getJlbdatosnombre().setText(language.leer("33"));
  			personas.getJlbdatostipod().setText(language.leer("34"));
  			personas.getJlbnumerodocumento().setText(language.leer("36"));
  	
  			
  			//--------------leyenda de procesadores
  			
  			
  			procesadores.getJbtnCancelar().setText(language.leer("25"));
  			procesadores.getJbtnGuardar().setText(language.leer("23"));
  		//	procesadores.getJbtnModificar().setText(language.leer("24"));
  			procesadores.getJLabelCache().setText(language.leer("41"));
  			procesadores.getJlbConjuntodeInstrucciones().setText(language.leer("42"));
  			procesadores.getJlbNumeroNucleos().setText(language.leer("40"));
  			procesadores.getJlbMarca().setText(language.leer("39"));
  	
  			
  			
  			
  			
  			//---------leyenda de los parametros generales
  			
  			parametrosgenerales.getJButtonGuardar().setText(language.leer("7"));
  			parametrosgenerales.getIdioma().setText(language.leer("2"));
  			parametrosgenerales.getArchivoPersona().setText(language.leer("5"));
  			parametrosgenerales.getArchivoProcesador().setText(language.leer("6"));
  			parametrosgenerales.getCombobox().setName(language.leer("2"));
  			
				
				
				
				
				
				
				
				
	  	} catch (IOException e1) {
	  		// TODO Auto-generated catch block
	  		e1.printStackTrace();
	  	}
	  	System.out.println("funciona");
	    }
	  		}
	
	
	

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void AsignateManager(ManagerFiles files){
    this.File=files;
	}







	public AdminProcesadores getAdminProcesadores() {
		return AdminProcesadores;
	}







	public void setAdminProcesadores(AdminProcesadores adminProcesadores) {
		AdminProcesadores = adminProcesadores;
	}







	public Interfaz.AdminPersonas getAdminPersonas() {
		return AdminPersonas;
	}







	public void setAdminPersonas(Interfaz.AdminPersonas adminPersonas) {
		AdminPersonas = adminPersonas;
	}







	public Personas getPersonas() {
		return personas;
	}







	public void setPersonas(Personas personas) {
		this.personas = personas;
	}







	public Procesadores getProcesadores() {
		return procesadores;
	}







	public void setProcesadores(Procesadores procesadores) {
		this.procesadores = procesadores;
	}







	public ParametrosGenerales getParametrosgenerales() {
		return parametrosgenerales;
	}







	public void setParametrosgenerales(ParametrosGenerales parametrosgenerales) {
		this.parametrosgenerales = parametrosgenerales;
	}







	public MainWindow getMainWindow() {
		return mainWindow;
	}







	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}







	public Language getLanguage() {
		return language;
	}







	public void setLanguage(Language language) {
		this.language = language;
	}

	public ManagerFiles getFile() {
		return File;
	}

	public void setFile(ManagerFiles file) {
		File = file;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}; 
	
	
	
//los get y los set



}//end Objetos