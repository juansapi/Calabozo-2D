package Uniandes.cupi2.calabozo.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelAcciones extends JPanel implements ActionListener {
	
	private final static String ARRIBA = "Arriba";
	
	private final static String IZQUIERDA = "Izquierda";
	
	private final static String DERECHA = "Derecha";
	
	private final static String ABAJO = "Abajo";
	
	
	private JButton butArriba;
	
	private JButton butIzquierda;
	
	private JButton butDerecha;
	
	private JButton butAbajo;
	
	
	private InterfazCalabozo ventana;
	

	public PanelAcciones(InterfazCalabozo principal) {
		
		ventana = principal;
		setBorder(new TitledBorder("Acciones"));
		setPreferredSize(new Dimension(170,10));
		
		butArriba = new JButton();
		butArriba.setIcon(new ImageIcon("./data/imagenes/flechaArriba.png"));
		butArriba.setBackground(Color.WHITE);
		butArriba.setActionCommand(ARRIBA);
		butArriba.addActionListener(this);
		
		butIzquierda = new JButton();
		butIzquierda.setIcon(new ImageIcon("./data/imagenes/flechaIzquierda.png"));
		butIzquierda.setBackground(Color.WHITE);
		butIzquierda.setActionCommand(IZQUIERDA);
		butIzquierda.addActionListener(this);
		
		butDerecha = new JButton();
		butDerecha.setIcon(new ImageIcon("./data/imagenes/flechaDerecha.png"));
		butDerecha.setBackground(Color.WHITE);
		butDerecha.setActionCommand(DERECHA);
		butDerecha.addActionListener(this);
		
		butAbajo = new JButton();
		butAbajo.setIcon(new ImageIcon("./data/imagenes/flechaAbajo.png"));
		butAbajo.setBackground(Color.WHITE);
		butAbajo.setActionCommand(ABAJO);
		butAbajo.addActionListener(this);
		
		setLayout(new GridLayout(3,3,3,3));
		
		add(new JLabel());
		add(butArriba);
		add(new JLabel());
		add(butIzquierda);
		add(new JLabel());
		add(butDerecha);
		add(new JLabel());
		add(butAbajo);
		add(new JLabel());
	
	}
	
	public void actualizarBotonesAcciones(boolean nEstado){
		
	
		butArriba.setEnabled(nEstado);
		butIzquierda.setEnabled(nEstado);
		butDerecha.setEnabled(nEstado);
		butAbajo.setEnabled(nEstado);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String comando = e.getActionCommand();
		
		if(comando.equals(DERECHA))
		{
			ventana.accionDerecha();
		}
		else if(comando.equals(IZQUIERDA))
		{
			ventana.accionIzquierda();
		}
		
		else if(comando.equals(ARRIBA))
		{
			ventana.accionArriba();
		}
		
		else if(comando.equals(ABAJO))
		{
			ventana.accionAbajo();
		}
		
	}

}
