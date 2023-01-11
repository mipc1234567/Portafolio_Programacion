package gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.TileObserver;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import persistence.Score;

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego Ahorcado
 */

public class FrameScore extends JFrame implements ActionListener {


	/**
	 * Atributo que permitira saber los puntajes obtenidos en el Juego
	 */

	private JLabel Values;
	private JLabel Titless;
	private JTextField textField;
	private JTextArea textArea;
	private String newline;

	/**
	 * Constructor de la clase
	 */
	public FrameScore(){	
		this.setSize(500, 300);
		Titless= new JLabel("Altos Puntajes:");
		Titless.setBounds(150, 0, this.getWidth(), 30);
		Titless.setFont(new Font("Arial",50,35));
		this.add(Titless);
		setResizable(false);
		this.setLocationRelativeTo(null);
		init();

	}
	/**
	 * Metodo que permite actulizar el contenido de un vector del puntaje
	 * @param Value
	 * @retutn void
	 * 
	 */
	public void Actualiza(String []Value){
		String parcial="";
		for (int i = 0; i < Value.length; i++){
			textArea.setText(Value[i].toString());
			this.repaint();
		}
	}

	/**
	 * Metodo que permite inicializar los componentes de la ventana puntaje
	 * @param Value
	 * @retutn void	
	 */
	public void init() {
		textField = new JTextField(20);
		textArea = new JTextArea(5, 20);
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		GridBagLayout gridBag = new GridBagLayout();
		getContentPane().setLayout(gridBag);
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.HORIZONTAL;
		gridBag.setConstraints(textField, c);
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		gridBag.setConstraints(scrollPane, c);
		getContentPane().add(scrollPane);
		newline = System.getProperty("line.separator");
	}
	/**
	 * Metodo que permite actulizar el contenido del jtextarea 
	 * para no modificar
	 * @param Value
	 * @retutn void
	 */
	public void actionPerformed(ActionEvent evt) {
		String text = textField.getText();
		textArea.append(text + newline);

	}


	/**
	 * los----------------- GET Y LOS SET--------------------------	    
	 * 
	 */
	public JLabel getValues() {
		return Values;
	}

	public void setValues(JLabel values) {
		Values = values;
	}

	public JLabel getTitless() {
		return Titless;
	}

	public void setTitless(JLabel titless) {
		Titless = titless;
	}


}

