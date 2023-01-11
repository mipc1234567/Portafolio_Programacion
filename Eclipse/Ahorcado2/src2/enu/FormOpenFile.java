package enu;
/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego Ahorcado
 */

public enum FormOpenFile {
	WRITE("w"),READ("r"),UPDATE("rw");
	private FormOpenFile(String  mode){
		this.mode=mode;
	}


	private String mode;
	public String getMode() {
		return mode;
	}


    
    
}
