/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package internacionalizacion;

import gui.GameAhorcado;
import gui.PanelGame;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;


/* ColorChooserDemo.java requires no other files. */

/**
 * @author Mateo Ivan Peña C
 * @version 1.0
 * @Place Universidad Pedagogica y Tecnologica de Colombia
 * juego ahorcado
 */
public class ColorChooserDemo extends JFrame implements ChangeListener,ActionListener{

private static final long serialVersionUID = 1L;
protected JColorChooser tcc;
protected JLabel banner;
private JPanel panelventana;
private JButton bottonaplicar;
private JButton bottoncancelar;
private JButton bottonaceptar;
private JPanel panel;
private final static String CALCULATE="Calculate";
protected Color color;   
private GameAhorcado panelInterfaz;
private JLabel label;	
private ColorChooserDemo JcolorChoser;
private Fonts principal;


public ColorChooserDemo(GameAhorcado jframeMajorNumber) {
this.panelInterfaz=jframeMajorNumber;
this.color= Color.blue;
bottonaceptar= new JButton("Aceptar");
bottonaceptar.setActionCommand(CALCULATE);
bottonaceptar.addActionListener(actionsButtons2);
bottoncancelar= new JButton("Cancelar");
bottoncancelar.setActionCommand(CALCULATE);
bottoncancelar.addActionListener(actionsButtons3);
setSize(400, 500);
//Set up the banner at the top of the window
	banner = new JLabel("Se vera asi  en la ventana",JLabel.CENTER);
		banner.setForeground(Color.yellow);
		banner.setBackground(Color.blue);
		banner.setOpaque(true);
		banner.setFont(new Font("SansSerif", Font.BOLD, 24));
		banner.setPreferredSize(new Dimension(100, 65));
		
		
		JPanel bannerPanel = new JPanel(new BorderLayout());
		bannerPanel.add(banner, BorderLayout.CENTER);
		bannerPanel.setBorder(BorderFactory.createTitledBorder("Banner"));

		//Set up color chooser for setting text color
		tcc = new JColorChooser(banner.getForeground());
		tcc.getSelectionModel().addChangeListener(this);
		tcc.setBorder(BorderFactory.createTitledBorder(
				"Choose Text Color"));

		JPanel panelBotones= new JPanel(new FlowLayout());
		//panelBotones.add(bottonaplicar);
		panelBotones.add(bottoncancelar);
		panelBotones.add(bottonaceptar);

		add(bannerPanel, BorderLayout.NORTH);
		add(tcc, BorderLayout.CENTER);
		this.add(panelBotones,BorderLayout.SOUTH);
	}
 @Override
	public void stateChanged(ChangeEvent e) {
	 Color newColor = tcc.getColor();
	 banner.setForeground(newColor);
	 setColor(tcc.getColor());
	 System.out.println(getColor().toString());
		System.out.println("Entróo");
	
		try {
			ChangeColor();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelInterfaz.repaint();
		//panelInterfaz.setContentPane(banner);
		//panelInterfaz.getContentPane().setBackground(color);
		//panelInterfaz.getContentPane().setForeground(color);
		//framemajor.setForeground(newColor);
		//framemajor.setBackground(newColor);
		//panelInterfaz.repaint();	
 }
 
 
 public void ChangeColor() throws IOException{
		
		this.panelInterfaz.setTitle(Global.language.getString("1"));
		this.panelInterfaz.getButtonAceptar().setBackground(color);
		this.panelInterfaz.getButtonCancelar().setBackground(color);
		this.panelInterfaz.getMenuAcerca().setBackground(color);
		//los del panel game
		this.panelInterfaz.getPanel().getJbtnSALIR().setBackground(color);
		this.panelInterfaz.getPanel().getJbtnValidar().setBackground(color);
		this.panelInterfaz.getPanel().getJlabelINTENTOS().setBackground(color);
//pendiente por modificar
		this.panelInterfaz.getPanel().getJlblpalabra().setBackground(color);
		
		this.panelInterfaz.getPanel().getJlblValidation().setBackground(color);
		this.panelInterfaz.getPanel().getJtxtLETTER().setBackground(color);
		this.panelInterfaz.getPanel().getJtxtWORD().setBackground(color);
		
		this.panelInterfaz.getMenuArchivo().setBackground(color);;
		this.panelInterfaz.getMenuitem1().setBackground(color);
		this.panelInterfaz.getMenuitem2().setBackground(color);
		this.panelInterfaz.getMenuitem6().setBackground(color);
		this.panelInterfaz.getMenuItem8().setBackground(color);
		this.panelInterfaz.getMenuAcerca().setBackground(color);
		this.panelInterfaz.getCrear().setBackground(color);
	}
	//---------------------METODOS--------------------------------------
	/**
	 * 
	 * 1º
	 */

/*	ActionListener actionsButtons1 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
				System.out.println("boton de aplicar");
				framemajor.cambiarColor(color);
				
			}
		}
	};
*/

	/**
	 * 2º 
	 */
	ActionListener actionsButtons2 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {
			if(a.getActionCommand().equals(CALCULATE)){
				System.out.println("boton de aceptar");
				System.out.println(color.toString());
				//panelInterfaz.cambiarFondo(color);
				//panelInterfaz.CambiarFrente(color);
				setVisible(false);
			}
		}
	};

	/**
	 * 2º 
	 */
	ActionListener actionsButtons3 = new ActionListener() {		
		public void actionPerformed(ActionEvent a) {

			if(a.getActionCommand().equals(CALCULATE)){
				System.out.println("boton de cancelar");
				setVisible(false);
			}
		}
	};

	//------------------los get y los set---------------------	

	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JColorChooser getTcc() {
		return tcc;
	}

	public void setTcc(JColorChooser tcc) {
		this.tcc = tcc;
	}

	public JLabel getBanner() {
		return banner;
	}

	public void setBanner(JLabel banner) {
		this.banner = banner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}



}

