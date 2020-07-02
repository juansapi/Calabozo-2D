package Uniandes.cupi2.calabozo.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Uniandes.cupi2.calabozo.mundo.*;
import sun.net.www.content.image.jpeg;

public class InterfazCalabozo extends JFrame{
	
	private PanelImagen panelImagen;
	
	private PanelEstado panelEstado;
	
	private PanelOpciones panelOpciones;
	
	private PanelMovimientos panelMovimientos;
	
	private PanelAcciones panelAcciones;
	
	private PanelCalabozo panelCalabozo;
	
	private PanelExtra panelExtra;
	
	private Calabozo calabozo;
	

	public InterfazCalabozo() 
	{
	
		setSize(765, 800);
		setTitle("Calabozo");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		calabozo = null;		
		
		panelImagen = new PanelImagen();
		
		panelEstado = new PanelEstado(this);
		
		panelOpciones = new PanelOpciones(this);
		
		panelMovimientos = new PanelMovimientos(this);
		
		panelAcciones = new PanelAcciones(this); 
		
    	panelCalabozo = new PanelCalabozo(this);
    	
    	panelExtra = new PanelExtra(this);
    	
		
		
		JPanel este = new JPanel();
		
		este.setLayout(new GridLayout(4,1,1,1));
		este.add(new JLabel());
		este.add(panelMovimientos);
		este.add(panelAcciones);
		este.add(panelExtra);
		
		JPanel sur = new JPanel();
		
		sur.setLayout(new BorderLayout());
		sur.add(panelEstado, BorderLayout.NORTH);
		sur.add(panelOpciones, BorderLayout.CENTER);
			
		add(panelImagen, BorderLayout.NORTH);
		add(panelCalabozo, BorderLayout.CENTER);
		add(este, BorderLayout.EAST);
		add(sur, BorderLayout.SOUTH);
		
		actualizar();
		
	}
	
	
    public void cargarCalabozo( ) throws Exception
    {
        JFileChooser fc = new JFileChooser( "./data" );
        fc.setDialogTitle( "Abrir archivo de calabozo" );
        int resultado = fc.showOpenDialog( this );
        if( resultado == JFileChooser.APPROVE_OPTION )
        {
            File archivoCampeonato = fc.getSelectedFile( );
            
            calabozo = new Calabozo(archivoCampeonato);
            
            actualizar();
          
            }
    }
    
    public void reiniciar(){
    	
    	try 
    	{
			calabozo.reiniciar();
			
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    }
    
    
    public void actualizar(){

    	panelOpciones.actualizarBotones(false);
    	
    	if(calabozo!=null)
    	{
    		
        panelEstado.actualizarDatosHeroe(calabozo.darHeroe());
        panelExtra.actualizarDatos(calabozo.darHeroe());
        panelMovimientos.actualizarBotonesMoviento(calabozo.estadoJuego());
        panelAcciones.actualizarBotonesAcciones(calabozo.estadoJuego());
    	panelCalabozo.actualizar(calabozo);
    	calabozo.perderVida();
    	panelEstado.actualizarDatosHeroe(calabozo.darHeroe());
    	panelOpciones.actualizarBotones(true);
    	
    	if(calabozo.darHeroe().darVidas() == 0)
    	{
        	calabozo.perderVida();	
            panelMovimientos.actualizarBotonesMoviento(calabozo.estadoJuego());
            panelAcciones.actualizarBotonesAcciones(calabozo.estadoJuego());
    	}
    
    	}
    	
    	
    	
    	repaint();
    	
    }
    
    public void moverIzquierdaArriba(){
    	
    	try 
    	{
			calabozo.moverIzquierdaArriba();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    }
    
    public void moverArriba(){
    	
    	try 
    	{
			calabozo.moverArriba();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    }
    
    public void moverDerechaArriba(){
    	
    	try 
    	{
			calabozo.moverDerechaArriba();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    }
    
    
    public void moverAlaIzquierda(){
    	
    	try 
    	{
			calabozo.moverAlaIzquierda();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    }
    
    
    public void moverAlaDerecha(){
    	
    	try 
    	{
			calabozo.moverAlaDerecha();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    	
    }
    
    public void moverIzquierdaAbajo(){
    	
    	try 
    	{
			calabozo.moverIzquierdaAbajo();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    }
    

    public void moverAbajo(){
    	
    	try 
    	{
			calabozo.moverAbajo();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    }
    
    public void moverDerechaAbajo(){
    	
    	try 
    	{
			calabozo.moverDerechaAbajo();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    }
    
    
    public void accionDerecha(){
    	
    	
    	try 
    	{
			calabozo.accionDerecha();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    	
    }
    
    public void accionIzquierda(){
    	
    	try 
    	{
			calabozo.accionIzquierda();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    	
    }
    
    public void accionArriba()
    {
    	try 
    	{
			calabozo.accionArriba();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    	
    	
    }
    
    
    public void accionAbajo()
    {
    	try 
    	{
			calabozo.accionAbajo();
			actualizar();
		} 
    	catch (Exception e) 
    	{
			JOptionPane.showMessageDialog(this, e.getMessage(),"Información",JOptionPane.INFORMATION_MESSAGE);
		}
    	
    	
    }
    
    
    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método 1 de extensión del ejemplo
     */
    public void reqFuncOpcion1( )
    {
    	if(calabozo!=null)
    	{
        String respuesta = calabozo.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    	}
    }

    /**
     * Método 2 de extensión del ejemplo
     */
    public void reqFuncOpcion2( )
    {
    	if(calabozo!=null)
    	{
        String respuesta = calabozo.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    	}
    }

    
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InterfazCalabozo frame = new InterfazCalabozo();
		frame.setVisible(true);
		
	}

}
