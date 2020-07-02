package Uniandes.cupi2.calabozo.interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.sun.xml.internal.ws.api.config.management.policy.ManagementAssertion.Setting;

public class PanelMovimientos extends JPanel implements ActionListener {

	private final static String IZQUIERDA_ARRIBA ="Izquierda_Arriba";
	
	private final static String ARRIBA = "Arriba";
	
	private final static String DERECHA_ARRIBA ="Derecha_Arriba";
		
	private final static String IZQUIERDA = "Izquierda";
	
	private final static String DERECHA = "Derecha";
	
	private final static String IZQUIERDA_ABAJO = "Izquierda_Abajo";
	
	private final static String ABAJO = "Abajo";
	
	private final static String DERECHA_ABAJO = "Derecha_Abajo";
	
	
	
	private JButton butIzquierda_Arriba;
	
	private JButton butArriba;
	
	private JButton butDerecha_Arriba;
	
	private JButton butIzquierda;
	
	private JButton butDerecha;
	
	private JButton butIzquierda_Abajo;
	
	private JButton butAbajo;
	
	private JButton butDerecha_Abajo;
	
	
	private InterfazCalabozo ventana;
	
	
	public PanelMovimientos(InterfazCalabozo principal)
	{
		ventana = principal;
		
		setBorder(new TitledBorder("Movimientos"));
		setPreferredSize(new Dimension(170,10));
		
		butIzquierda_Arriba = new JButton();
		butIzquierda_Arriba.setIcon(new ImageIcon("./data/imagenes/flechaArribaIzquierdaAcc.png"));
		butIzquierda_Arriba.setBackground(Color.WHITE);
		butIzquierda_Arriba.setActionCommand(IZQUIERDA_ARRIBA);
		butIzquierda_Arriba.addActionListener(this);
		
		butArriba = new JButton();
		butArriba.setIcon(new ImageIcon("./data/imagenes/flechaArribaAcc.png"));
		butArriba.setBackground(Color.WHITE);
		butArriba.setActionCommand(ARRIBA);
		butArriba.addActionListener(this);
		
		butDerecha_Arriba = new JButton();
		butDerecha_Arriba.setIcon(new ImageIcon("./data/imagenes/flechaArribaDerechaAcc.png"));
		butDerecha_Arriba.setBackground(Color.WHITE);
		butDerecha_Arriba.setActionCommand(DERECHA_ARRIBA);
		butDerecha_Arriba.addActionListener(this);
		
		butIzquierda = new JButton();
		butIzquierda.setIcon(new ImageIcon("./data/imagenes/flechaIzquierdaAcc.png"));
		butIzquierda.setBackground(Color.WHITE);
		butIzquierda.setActionCommand(IZQUIERDA);
		butIzquierda.addActionListener(this);
		
		butDerecha = new JButton();
		butDerecha.setIcon(new ImageIcon("./data/imagenes/flechaDerechaAcc.png"));
		butDerecha.setBackground(Color.WHITE);
		butDerecha.setActionCommand(DERECHA);
		butDerecha.addActionListener(this);
		
		butIzquierda_Abajo = new JButton();
		butIzquierda_Abajo.setIcon(new ImageIcon("./data/imagenes/flechaAbajoIzquierdaAcc.png"));
		butIzquierda_Abajo.setBackground(Color.WHITE);
		butIzquierda_Abajo.setActionCommand(IZQUIERDA_ABAJO);
		butIzquierda_Abajo.addActionListener(this);
		
		butAbajo = new JButton();
		butAbajo.setIcon(new ImageIcon("./data/imagenes/flechaAbajoAcc.png"));
		butAbajo.setBackground(Color.WHITE);
		butAbajo.setActionCommand(ABAJO);
		butAbajo.addActionListener(this);
		
		butDerecha_Abajo = new JButton();
		butDerecha_Abajo.setIcon(new ImageIcon("./data/imagenes/flechaAbajoDerechaAcc.png"));
		butDerecha_Abajo.setBackground(Color.WHITE);
		butDerecha_Abajo.setActionCommand(DERECHA_ABAJO);
		butDerecha_Abajo.addActionListener(this);
		
		
		setLayout(new GridLayout(3,3,3,3));
		
		add(butIzquierda_Arriba);
		add(butArriba);
		add(butDerecha_Arriba);
		add(butIzquierda);
		add(new JLabel());
		add(butDerecha);
		add(butIzquierda_Abajo);
		add(butAbajo);
		add(butDerecha_Abajo);
	}
	
	public void actualizarBotonesMoviento(boolean nEstado){
		
		butIzquierda_Arriba.setEnabled(nEstado);
		butArriba.setEnabled(nEstado);
		butDerecha_Arriba.setEnabled(nEstado);
		butIzquierda.setEnabled(nEstado);
		butDerecha.setEnabled(nEstado);
		butIzquierda_Abajo.setEnabled(nEstado);
		butAbajo.setEnabled(nEstado);
		butDerecha_Abajo.setEnabled(nEstado);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if (comando.equals(IZQUIERDA_ARRIBA)) 
		{
			ventana.moverIzquierdaArriba();
		}
		else if (comando.equals(ARRIBA)) 
		{
			ventana.moverArriba();
		} 
		else if (comando.equals(DERECHA_ARRIBA)) 
		{
			ventana.moverDerechaArriba();
		} 
		else if (comando.equals(IZQUIERDA)) 
		{
			ventana.moverAlaIzquierda();
		}
		else if (comando.equals(DERECHA)) 
		{
			ventana.moverAlaDerecha();
		} 
		else if (comando.equals(IZQUIERDA_ABAJO)) 
		{
			ventana.moverIzquierdaAbajo();
		}
		else if (comando.equals(ABAJO)) 
		{
			ventana.moverAbajo();
		} 
		else if (comando.equals(DERECHA_ABAJO)) 
		{
			ventana.moverDerechaAbajo();
		}

		
		
		
		
	}

}
