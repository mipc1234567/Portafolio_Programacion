package Interfaz;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

/**
 * configura el acerca dede del programa
 * @author Mateo
 * @version 1.0
 * @created 20-mar.-2015 12:12:15 p. m.
 */
public class Acercade extends JFrame {
	/**
	 * Agregara la imagen al archivo
	 */
	private Image MarcaAgua;
	
	/**
	 * permite crear un mensaje
	 */
	
	private JLabel imagen;
	private JLabel autor;
	private JLabel Jlbfrase;
	
	public Acercade(){
		setSize(500,300);
		setTitle("Administador personas");
		setLayout(null);
		setResizable(false);
		this.setLocationRelativeTo(null);
//		 this.getContentPane().setBackground(Color.orange);
		   
		/*	Jlbldatos= new JLabel();
			Jlbldatos.setBounds(10,250, 200, 30);
			add(Jlbldatos);*/
	
       
Jlbfrase=new JLabel("DESARROLLADO POR:");
Jlbfrase.setBounds(30, 20, 150, 30);
add(Jlbfrase);	
		
autor=new JLabel("MATEO IVAN PEÑA CANCELADO:");
autor.setBounds(100, 60, 200, 30);
add(autor);

imagen= new JLabel();
imagen.setIcon(new ImageIcon(".//files//Imagen","jpg"));
add(imagen);

}
	
	

	public Image getMarcaAgua() {
		return MarcaAgua;
	}



	public void setMarcaAgua(Image marcaAgua) {
		MarcaAgua = marcaAgua;
	}



	public JLabel getImagen() {
		return imagen;
	}



	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}



	public JLabel getAutor() {
		return autor;
	}



	public void setAutor(JLabel autor) {
		this.autor = autor;
	}



	public JLabel getJlbfrase() {
		return Jlbfrase;
	}



	public void setJlbfrase(JLabel jlbfrase) {
		Jlbfrase = jlbfrase;
	}



	public void finalize() throws Throwable {

	}
}//end Acerca de