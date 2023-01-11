package enu;
/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego Ahorcado
 */

public enum FormSaveFile {

	SECUENCIAL("V"), DIRECTO("E");

	private FormSaveFile(String mode){
		this.manera=mode;
	}
	private String manera;

	public String getManera() {
		return manera;
	}


	
}


