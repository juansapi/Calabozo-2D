package Uniandes.cupi2.calabozo.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Uniandes.cupi2.calabozo.mundo.Heroe;

public class PanelExtra extends JPanel 
{

	private JLabel labNumDemonios;
	
	private JTextField txtNumDemonios;
	
	private JLabel labPosHeroeX;
	
	private JTextField txtPosHeroeX;
	
	private JLabel labPosHeroeY;
	
	private JTextField txtPosHeroeY;
	
	private InterfazCalabozo ventana;
	
	public PanelExtra(InterfazCalabozo principal){
		
		ventana = principal;
		
		setBorder(new TitledBorder("Panel Extra"));
		setLayout(new GridLayout(3,2,5,5));
		
		labNumDemonios = new JLabel("Demonios");
		labNumDemonios.setHorizontalAlignment(JLabel.CENTER);
		
		txtNumDemonios = new JTextField();
		txtNumDemonios.setEditable(false);
		txtNumDemonios.setHorizontalAlignment(JTextField.CENTER);
		
		labPosHeroeX = new JLabel(" X ");
		labPosHeroeX.setHorizontalAlignment(JLabel.CENTER);
		
		txtPosHeroeX = new JTextField();
		txtPosHeroeX.setEditable(false);
		txtPosHeroeX.setHorizontalAlignment(JTextField.CENTER);
		
		labPosHeroeY = new JLabel(" Y ");
		labPosHeroeY.setHorizontalAlignment(JLabel.CENTER);
		
		txtPosHeroeY = new JTextField();
		txtPosHeroeY.setEditable(false);
		txtPosHeroeY.setHorizontalAlignment(JTextField.CENTER);
		

		add(labPosHeroeX);
		add(txtPosHeroeX);
		add(labPosHeroeY);
		add(txtPosHeroeY);
		add(labNumDemonios);
		add(txtNumDemonios);

	}
	
	public void actualizarDatos(Heroe heroe){
		
		txtNumDemonios.setText(heroe.darNumeroDemonios()+"");
		txtPosHeroeX.setText(heroe.darPosX()+"");
		txtPosHeroeY.setText(heroe.darPosY()+"");
		
	}
	
	
	
	
}
