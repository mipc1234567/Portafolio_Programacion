package Persistencia;

public enum DocumentType {
	/**
	 * <b>cedula de ciudadania </b>
	 */
	CC(1,"CEDULA DE CIUDADANIA"), 
	TI(2,"TARJETA DE IDENTIDAD"),
	CE(3,"CEDULA DE EXTRANJERIA");
	
	private int numero;
	private String tipo;
	
	private DocumentType(int numero, String tipo) {
	  this.tipo = tipo;
	  this.numero = numero;
	}
	
	public String getTipo(){
		tipo = tipo;
		return tipo; 
	}
	
	public int getnumero(){
		numero=numero;
		return numero;
	}
	
	public String transformar(DocumentType tipo){
	String result="";
	result=tipo.toString();
	return result;
	}
}
