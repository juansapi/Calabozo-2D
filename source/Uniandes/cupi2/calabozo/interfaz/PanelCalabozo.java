package Uniandes.cupi2.calabozo.interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Uniandes.cupi2.calabozo.mundo.Calabozo;
import Uniandes.cupi2.calabozo.mundo.Casilla;

public class PanelCalabozo extends JPanel{
	
	private JLabel[][] matriz;
	
	private int alto;
	
	private int ancho;
	
	private InterfazCalabozo ventana;
	
	public PanelCalabozo(InterfazCalabozo principal) {
		
		ventana = principal;
		
		setBorder(new TitledBorder("Escenario"));	

	}
	

	public void actualizar (Calabozo calabozo){
		
		removeAll();
		
		Casilla[][] casillas = calabozo.darCasillas();
		
		alto = calabozo.darFilas();
		ancho = calabozo.darColumnas();
		
		setLayout(new GridLayout(alto,ancho));
		
		matriz = new JLabel[alto][ancho];
		
		for (int i = 0; i < alto; i++)
			for (int j = 0; j < ancho; j++) {
				
				matriz[i][j] = new JLabel();
				
				JLabel etiqueta = matriz[i][j];

				add(etiqueta);
				etiqueta.setHorizontalAlignment(JLabel.CENTER);
				etiqueta.setIcon(new ImageIcon(casillas[j][i].darImagen()));
			}
		
		
	}
	
	
	
	
}
