package Uniandes.cupi2.calabozo.interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

import javax.swing.*;

public class PanelImagen extends JPanel{

	private JLabel labImagen;
	
	public PanelImagen() {
		setLayout(new BorderLayout());
		labImagen = new JLabel();
		ImageIcon imagen = new ImageIcon("./data/imagenes/banner.png");
		labImagen.setIcon(imagen);
		setBackground(Color.BLACK);
		labImagen.setHorizontalAlignment(JLabel.CENTER);
		add(labImagen, BorderLayout.CENTER);
		
	}

}
