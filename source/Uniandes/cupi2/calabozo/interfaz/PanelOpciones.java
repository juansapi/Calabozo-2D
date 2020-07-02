package Uniandes.cupi2.calabozo.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOpciones extends JPanel implements ActionListener {

	private final static String CARGAR = "Cargar";
	
	private final static String REINICIAR = "Reiniciar";
	
	private final static String OPCION_1 = "Opción 1";
	
	private final static String OPCION_2 = "Opción 2";
	
	
	private JButton butCargar;
	
	private JButton butReiniciar;
	
	private JButton butOpcion_1;
	
	private JButton butOpcion_2;
	
	private InterfazCalabozo ventana;
	
	
	
	public PanelOpciones(InterfazCalabozo principal)
	{
		ventana = principal;
		
		setBorder(new TitledBorder("Opciones"));
		
		butCargar =  new JButton(CARGAR);
		butCargar.setActionCommand(CARGAR);
		butCargar.addActionListener(this);
		
		butReiniciar = new JButton(REINICIAR);
		butReiniciar.setActionCommand(REINICIAR);
		butReiniciar.addActionListener(this);
		
		butOpcion_1 = new JButton(OPCION_1);
		butOpcion_1.setActionCommand(OPCION_1);
		butOpcion_1.addActionListener(this);
		
		butOpcion_2 = new JButton(OPCION_2);
		butOpcion_2.setActionCommand(OPCION_2);
		butOpcion_2.addActionListener(this);
		
		setLayout(new GridLayout(2,2));
		
		add(butCargar);
		add(butReiniciar);
		add(butOpcion_1);
		add(butOpcion_2);
		
		
		
		
	}
	
	public void actualizarBotones(boolean estado){
		
		butReiniciar.setEnabled(estado);
		butOpcion_1.setEnabled(estado);
		butOpcion_2.setEnabled(estado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if (comando.equals(CARGAR)) 
		{
			try {
				ventana.cargarCalabozo();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if (comando.equals(REINICIAR)) 
		{
			ventana.reiniciar();	

		} 
		else if (comando.equals(OPCION_1)) 
		{
			ventana.reqFuncOpcion1( );
		} 
		else if (comando.equals(OPCION_2)) 
		{
			 ventana.reqFuncOpcion2( );
		}
		
   
	}

}
