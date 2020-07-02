package Uniandes.cupi2.calabozo.interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Uniandes.cupi2.calabozo.mundo.Heroe;

public class PanelEstado extends JPanel{

	private InterfazCalabozo ventana;
	
	private JLabel labVidas;
	
	private JTextField txtVidas;
	
	private JLabel labLlaves;
	
	private JTextField txtLlaves;
	
	private JLabel labEspadas;
	
	private JTextField txtEspadas;
	
	
	public PanelEstado(InterfazCalabozo principal) 
	{
	ventana = principal;
	
	setBorder(new TitledBorder("Estado"));
	
	labVidas = new JLabel("Vidas");
	labVidas.setHorizontalAlignment(JLabel.CENTER);
	labVidas.setVerticalAlignment(JLabel.NORTH);
	
	txtVidas = new JTextField();
	txtVidas.setEditable(false);
	txtVidas.setHorizontalAlignment(JTextField.CENTER);
	
	labLlaves = new JLabel("Llaves");
	labLlaves.setHorizontalAlignment(JLabel.CENTER);
	labLlaves.setVerticalAlignment(JLabel.NORTH);
	
	
	txtLlaves = new JTextField();
	txtLlaves.setEditable(false);
	txtLlaves.setHorizontalAlignment(JTextField.CENTER);
	
	labEspadas = new JLabel("Espadas");
	labEspadas.setHorizontalAlignment(JLabel.CENTER);
	labEspadas.setVerticalAlignment(JLabel.NORTH);
	
	txtEspadas = new JTextField();
	txtEspadas.setEditable(false);
	txtEspadas.setHorizontalAlignment(JTextField.CENTER);
	
	
	setLayout(new GridLayout(1,6,2,2));
	
	add(labVidas);
	add(txtVidas);
	add(labLlaves);
	add(txtLlaves);
	add(labEspadas);
	add(txtEspadas);
	
	
	}
	
	public void actualizarDatosHeroe(Heroe heroe){
		
		txtVidas.setText(heroe.darVidas()+"");
		txtEspadas.setText(heroe.darNumerosEspadas()+"");
		txtLlaves.setText(heroe.darNumeroLlaves()+"");
		
	}
	

}
