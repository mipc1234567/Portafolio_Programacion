package internacionalizacion;

import gui.GameAhorcado;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego ahorcado
 */

public class ManagerLanguage{

	private GameAhorcado gameAhorcado;
	private Global global;
	private String image="/images/Alemania/Alemania.gif";
	private String image1="/images/España/Historia-de-la-bandera-de-España.png";
	private String image2="/images/Francia/Francia.gif";
	private String image3="/images/Portugal/bandera-de-portugal.png";
	private String image4="/images/Bandera-de-EU.png";

	/**
	 * Clase administradora de la clase manager
	 * @param frame
	 * @param global
	 */
	public ManagerLanguage(GameAhorcado frame ,Global global){
		this.gameAhorcado=frame;
		this.global=global;

	}

	/**
	 * Carga la aplicion por defecto
	 * @param global
	 */
	public ManagerLanguage(Global global) {
		// TODO Auto-generated constructor stub
		this.global=global;
	}

	/**
	 * Cambia el lenguaje segun la escogencia
	 * @param x
	 */
	public void changeLeng(int x){
		switch (x){
		case 0:
			this.global.language = ResourceBundle.getBundle("SP");
			try {
				Change();
				change_words();
				this.gameAhorcado.getPanel().getPersonalitation().setIcon(new ImageIcon(getClass().getResource(image1)));
				//	this.label.setIcon(new ImageIcon().getClass().getResource(image1));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;


		case 1:
			this.global.language = ResourceBundle.getBundle("EN");
			try {
				Change();
				change_words();
				this.gameAhorcado.getPanel().getPersonalitation().setIcon(new ImageIcon(getClass().getResource(image4)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;


		case 2:
			//this.global.SelectLanguage("fr");
			this.global.language = ResourceBundle.getBundle("PR");
			try {
				Change();
				change_words();
				this.gameAhorcado.getPanel().getPersonalitation().setIcon(new ImageIcon(getClass().getResource(image3)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case 3:
			this.global.language = ResourceBundle.getBundle("FR");
			try {
				Change();
				change_words();
				this.gameAhorcado.getPanel().getPersonalitation().setIcon(new ImageIcon(getClass().getResource(image2)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;


		case 4:
			this.global.language = ResourceBundle.getBundle("AL");
			try {
				Change();
				change_words();
				this.gameAhorcado.getPanel().getPersonalitation().setIcon(new ImageIcon(getClass().getResource(image)));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

	/**
	 * Realiza el cambio segun el idioma correspondiente
	 * @throws IOException
	 */
	public void Change() throws IOException{

		this.gameAhorcado.setTitle(Global.language.getString("1"));
		this.gameAhorcado.getButtonAceptar().setText(Global.language.getString("19"));
		this.gameAhorcado.getButtonCancelar().setText((Global.language.getString("20")));
		this.gameAhorcado.getMenuAcerca();

		this.gameAhorcado.getPanel().getJbtnSALIR().setText(Global.language.getString("1"));
		this.gameAhorcado.getPanel().getJbtnValidar().setText(Global.language.getString("11"));
		this.gameAhorcado.getPanel().getJlabelINTENTOS().setText((Global.language.getString("15")+" " +gameAhorcado.getIntetos()));

		this.gameAhorcado.getPanel().getJlblpalabra();

		this.gameAhorcado.getPanel().getJlblValidation().setText((Global.language.getString("121")));
		this.gameAhorcado.getPanel().getJtxtLETTER().setText((Global.language.getString("18")));
		this.gameAhorcado.getPanel().getJtxtWORD().setText(Global.language.getString("17"));

		this.gameAhorcado.getMenuArchivo().setText(Global.language.getString("2"));
		this.gameAhorcado.getMenuitem1().setText(Global.language.getString("3"));
		this.gameAhorcado.getMenuitem2().setText((Global.language.getString("13")));
		this.gameAhorcado.getMenuitem6().setText(Global.language.getString("1"));
		this.gameAhorcado.getMenuItem8().setText(Global.language.getString("122"));
		this.gameAhorcado.getMenuAcerca().setText(Global.language.getString("14"));
		this.gameAhorcado.getCrear().setText(Global.language.getString("2"));		
	}

	public String[] change_words(){
		String[] valores= new String[122];
		System.out.println("tamaño deñ vetrp");
		System.out.println(valores.length);
		for (int i = 21; i <=121; i++) {
			String parcial=i+"";
			valores[i]=Global.language.getString(parcial);
		}
		return valores;

	}



	
}
