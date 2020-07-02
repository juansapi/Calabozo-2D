package Uniandes.cupi2.calabozo.mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Calabozo 

{
	private Heroe heroe;	
	private Casilla[][] mapa;
	private int numFilas;
	private int numColumnas;
	private String[] tipos;
	
	private File file;

	private boolean estadoJuego;
	
	private int numDemonios;
	
	
	// metodo constructor
	
	public Calabozo( File archivo ) throws Exception
	{
		file = archivo;
		cargarInfoCalabozo(archivo);
     
	}
	
	public void cargarInfoCalabozo(File archivo) throws Exception
	{
		// Carga la información
		estadoJuego = true;
		
		Properties persistencia = new Properties( );
		FileInputStream fis = new FileInputStream( archivo );
		persistencia.load( fis );
		fis.close( );
		
		// Lee la información
		numFilas = Integer.parseInt(persistencia.getProperty("calabozo.filas"));
		numColumnas = Integer.parseInt(persistencia.getProperty("calabozo.columnas"));
		
		mapa = new Casilla[numFilas][numColumnas];
		
		int posx = Integer.parseInt(persistencia.getProperty("calabozo.heroe.posX"));
		int posy = Integer.parseInt(persistencia.getProperty("calabozo.heroe.posY"));
		numDemonios = Integer.parseInt(persistencia.getProperty("calabozo.numDemonios"));
		
		heroe = new Heroe(posx, posy,numDemonios);
		
		tipos = new String[16];
		tipos[0] = "./data/imagenes/heroe.png";
		for(int tipo = 1; tipo <= 15; tipo++) 
		{
			tipos[tipo] ="./data/imagenes/"+persistencia.getProperty("calabozo.rutaImagenTipo"+(tipo)); 
		}
		
		
		for (int x = 0; x < numFilas; x++) {

			String linea = persistencia.getProperty("calabozo.fila" + x);

			String[] estado = linea.split("-");

			for (int y = 0; y < estado.length; y++) {

				int nEstado = Integer.parseInt(estado[y]);
			
				String rutaImage = tipos[(nEstado)];

				mapa[y][x] = new Casilla(nEstado, x, y, rutaImage);

			}
			
		}	
		
		mapa[posy][posx] = new Casilla(Casilla.HEROE, posx,posy , tipos[Casilla.HEROE]);
		
	}
	
	public void reiniciar() throws Exception
	{
		cargarInfoCalabozo(file);	
	}
	
	public Casilla[][] darCasillas(){
		
		return mapa;
	}
	// ----------- metodo que retorna las filas del mapa
	
	public int darFilas() {

		return numFilas;

	}
	
	public int darColumnas(){
		
		return numColumnas;
	}
	
	public Heroe darHeroe(){
		
		return heroe;
	}
	
	public int darNumeroDemonios(){
		
		return numDemonios;
	}
	
	public void perderVida(){
		
		
		int heroeX = heroe.darPosX();
		int heroeY = heroe.darPosY();
		
		if( ((heroeX-1) >= 0 &&( heroeX+1 ) < (numColumnas) && (heroeY-1) >= 0 &&( heroeY+1) < (numFilas) ))
				{
			
			
			if(heroe.darVidas() == 0)
			{
				cambiarEstadoJuego(false);
				JOptionPane.showMessageDialog(null, "Has perdido","Información",JOptionPane.INFORMATION_MESSAGE);
			}
			
			for (int i = -1; i <= 1; i++) 	
				for (int j = -1; j <= 1; j++) 
				{
					
					if(mapa[i+heroeX][j+heroeY].darEstado() == Casilla.DEMONIO_ROJO && !heroe.tieneEspadaRoja())
					{
						heroe.perderVida();
					}
					if(mapa[i+heroeX][j+heroeY].darEstado() == Casilla.DEMONIO_AZUL && !heroe.tieneEspadaAzul())
					{
						heroe.perderVida();
					}
					if(mapa[i+heroeX][j+heroeY].darEstado() == Casilla.DEMONIO_AMARILLO && !heroe.tieneEspadaAmarilla())
					{
						heroe.perderVida();
					}
					
				
			}
			
				}
	}
	
	private void cambiarEstadoJuego(boolean nEstado){

		estadoJuego = nEstado;

	}
	
	public boolean estadoJuego(){
		
		return estadoJuego;
	}
	
	
	public void moverIzquierdaArriba() throws Exception
	{ 
		if( (heroe.darPosX() == 0 ||  heroe.darPosY()== (0) ) )		
		{
			throw new Exception("Movimiento fuera de rango");
		} 

		if(heroe.darPosY() >= 0 && heroe.darPosY() <= numColumnas && (mapa[heroe.darPosX()-1][heroe.darPosY()-1].darEstado()) == Casilla.PISO )
		{
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarEstado(Casilla.PISO);
			heroe.cambiarPosicion(heroe.darPosX()-1, heroe.darPosY()-1 );
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.HEROE]);
						
		}
		
		else
		{
			throw new Exception("Movimiento inválido");
		}
	}
	
	
	public void moverArriba() throws Exception
	{ 	
		
		if(heroe.darPosY()==0)
		{
			throw new Exception("Movimiento fuera de rango");
		} 
		
		if(heroe.darPosY() >= 0 && heroe.darPosY() <= (numFilas-1) && (mapa[heroe.darPosX()][heroe.darPosY()-1].darEstado()) == Casilla.PISO )
		{
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarEstado(Casilla.PISO);
			heroe.cambiarPosicion(heroe.darPosX(), heroe.darPosY()-1 );
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.HEROE]);
						
		}
		else
		{
			throw new Exception("Movimiento inválido");
		}
	}
	

	public void moverDerechaArriba() throws Exception
	{ 
			
		if( (heroe.darPosY() == 0 ||  heroe.darPosX()== (numColumnas-1) ) || (heroe.darPosY() == (numFilas-1) &&  heroe.darPosX()== (numColumnas-1)))
		{
			throw new Exception("Movimiento fuera de rango");
		} 
		
		if(heroe.darPosY() >= 0 && heroe.darPosY() <= (numFilas-1) && (mapa[heroe.darPosX()+1][heroe.darPosY()-1].darEstado()) == Casilla.PISO )
		{
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarEstado(Casilla.PISO);
			heroe.cambiarPosicion(heroe.darPosX() + 1, heroe.darPosY() - 1);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.HEROE]);
						
		}
		
		else
		{
			throw new Exception("Movimiento inválido");
		}
	    
		
	}
	
	
	public void moverAlaIzquierda() throws Exception
	{ 
		
		if(heroe.darPosX()==0)
		{
			throw new Exception("Movimiento fuera de rango");
		} 
		
		if(heroe.darPosX() >= 0 && heroe.darPosX() <= numColumnas && (mapa[heroe.darPosX()-1][heroe.darPosY()].darEstado()) == Casilla.PISO )
		{
				mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
				mapa[heroe.darPosX()][heroe.darPosY()].cambiarEstado(Casilla.PISO);
				heroe.cambiarPosicion(heroe.darPosX()-1, heroe.darPosY());
				mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.HEROE]);
					
		}
		else
		{
			throw new Exception("Movimiento inválido");
		}
	    
	}
	
 
	public void moverAlaDerecha() throws Exception
	{ 
	
		if(heroe.darPosX()==(numColumnas-1))
		{
			throw new Exception("Movimiento fuera de rango");
		} 
		
		if(heroe.darPosY() >= 0 && heroe.darPosY() <= (numColumnas) && (mapa[heroe.darPosX()+1][heroe.darPosY()].darEstado()) == Casilla.PISO )
		{
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarEstado(Casilla.PISO);
			heroe.cambiarPosicion(heroe.darPosX()+1, heroe.darPosY());
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.HEROE]);
			
		}
		else
		{
			throw new Exception("Movimiento inválido");
		}
		
	    
	}
	
	public void moverIzquierdaAbajo() throws Exception
	{ 
		
		if(heroe.darPosY() == (numFilas-1)|| heroe.darPosX()== 0 )
		{
			throw new Exception("Movimiento fuera de rango");
		} 
		
		if(heroe.darPosY() >= 0 && heroe.darPosY() < numFilas && (mapa[heroe.darPosX()-1][heroe.darPosY()+1].darEstado()) == Casilla.PISO )
		{
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarEstado(Casilla.PISO);
			heroe.cambiarPosicion(heroe.darPosX() - 1, heroe.darPosY() + 1);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.HEROE]);
			
		}
		
		else
		{
			throw new Exception("Movimiento inválido");
		}
	}
	

	


	public void moverAbajo()  throws Exception
	{
		
		if(heroe.darPosY()==(numFilas-1))
		{
			throw new Exception("Movimiento fuera de rango");
		} 
		
		if (heroe.darPosY() >= 0 && heroe.darPosY() < (numFilas) && (mapa[heroe.darPosX()][heroe.darPosY()+1].darEstado()) == Casilla.PISO) 
		{
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarEstado(Casilla.PISO);
			heroe.cambiarPosicion(heroe.darPosX(), heroe.darPosY()+1 );
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.HEROE]);
			
		}
		
		else
		{
			throw new Exception("Movimiento inválido");
		}
	}
	
	public void moverDerechaAbajo() throws Exception
	{ 

		
		if(heroe.darPosY() ==(numColumnas-1) || heroe.darPosX()== (numFilas-1) )
		{
			throw new Exception("Movimiento fuera de rango");
		} 
		
		if(heroe.darPosX() >= 0 && heroe.darPosX() < (numFilas) && (mapa[heroe.darPosX()+1][heroe.darPosY()+1].darEstado()) == Casilla.PISO )
		{
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarEstado(Casilla.PISO);
			heroe.cambiarPosicion(heroe.darPosX() + 1, heroe.darPosY() + 1);
			mapa[heroe.darPosX()][heroe.darPosY()].cambiarImagen(tipos[Casilla.HEROE]);
			
		}
		
		else
		{
			throw new Exception("Movimiento inválido");
		}
	}
	
	


	
	// metodo que recoge llaves en direccion a la derecha
	
     public void accionDerecha() throws Exception   
     {
    	 if(heroe.darPosX()+1 < numColumnas)
		 { 
    	 
    	 switch (mapa[heroe.darPosX()+1][heroe.darPosY()].darEstado()) 
    	 {
    	 
		case Casilla.LLAVE_ROJA:
			
			heroe.obtenerLlaveRoja();
			
			break;
    	 
		case Casilla.LLAVE_AZUL:
			
			heroe.obtenerLlaveAzul();
			break;
			
		case Casilla.LLAVE_AMARILLA:
			
			heroe.obtenerLlaveAmarilla();
			break;
			
		case Casilla.DEMONIO_ROJO:
			
			if(heroe.tieneEspadaRoja())
			{
			heroe.EliminarDeomonio();
			}
			else 
			{
			throw new Exception("No puedes derrotar al demonio. Necesitas la espada roja");
			}
			break;
			
		case Casilla.DEMONIO_AZUL:

			if(heroe.tieneEspadaAzul())
			{
			heroe.EliminarDeomonio();
			}
			else 
			{
			throw new Exception("No puedes derrotar al demonio. Necesitas la espada azul");
			}
			break;
			
		case Casilla.DEMONIO_AMARILLO:
			
			if(heroe.tieneEspadaAmarilla())
			{
			heroe.EliminarDeomonio();
			}
			else 
			{
			throw new Exception("No puedes derrotar al demonio. Necesitas la espada amarilla");
			}
			break;

		case Casilla.ESPADA_ROJA:
			
			heroe.obtenerEspadaRoja();
			break;
			
		case Casilla.ESPADA_AZUL:
			
			heroe.obtenerEspadaAzul();
			break;
			
		case Casilla.ESPADA_AMARILLA:
			
			heroe.obtenerEspadaAmarilla();
			break;
			
		case Casilla.PUERTA_ROJA:
			
			if(!heroe.tieneLlaveRoja())
			{
			throw new Exception("No puedes abrir la puerta. Necesitas la llave roja");
			}
			break;
			
		case Casilla.PUERTA_AZUL:
			
			if(!heroe.tieneLlaveAzul())
			{
			throw new Exception("No puedes abrir la puerta. Necesitas la llave azul");
			}
			break;
			
		case Casilla.PUERTA_AMARILLA:
			
			if(!heroe.tieneLlaveAmarilla())
			{
			throw new Exception("No puedes abrir la puerta. Necesitas la llave amarilla");
			}
			break;
			
		case Casilla.PUERTA_SALIDA:
			if(!heroe.tieneLlaveRoja() || !heroe.tieneLlaveAzul()  || !heroe.tieneLlaveAmarilla())
			{
			throw new Exception("No puedes abrir la puerta. Necesitas las 3 llaves");
			}
			
			JOptionPane.showMessageDialog(null, "!Felicidades has ganado!\n Mataste "+((darNumeroDemonios()-heroe.darNumeroDemonios())+"/"+darNumeroDemonios())+" demonios","Información",JOptionPane.INFORMATION_MESSAGE);
			cambiarEstadoJuego(false);
			
			break;
			
			default:
				throw new Exception("Casilla vacía");
				
		}
			mapa[heroe.darPosX()+1][heroe.darPosY()].cambiarEstado(Casilla.PISO);
			mapa[heroe.darPosX()+1][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);

	}
}
    	 
    	 // metodo de accion del heroé. recoge llaves en la direccion izquierda
    	 
    	 public void accionIzquierda() throws Exception   
         {
    		 
    		 if(heroe.darPosX()-1 > 0 )
    		 {
    		 
    		 switch (mapa[heroe.darPosX()-1][heroe.darPosY()].darEstado()) 
        	 {
        	 
    		case Casilla.LLAVE_ROJA:
    			
    			heroe.obtenerLlaveRoja();
    			
    			break;
        	 
    		case Casilla.LLAVE_AZUL:
    			heroe.obtenerLlaveAzul();
    			break;
    			
    		case Casilla.LLAVE_AMARILLA:
    			heroe.obtenerLlaveAmarilla();
    			break;
    			
    		case Casilla.DEMONIO_ROJO:
    			if(heroe.tieneEspadaRoja())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada roja");
    			}
    			break;
    			
    		case Casilla.DEMONIO_AZUL:

    			if(heroe.tieneEspadaAzul())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada azul");
    			}
    			break;
    			
    		case Casilla.DEMONIO_AMARILLO:
    			if(heroe.tieneEspadaAmarilla())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada amarilla");
    			}
    			break;
    			
    		case Casilla.ESPADA_ROJA:
    			heroe.obtenerEspadaRoja();
    			break;
    			
    		case Casilla.ESPADA_AZUL:
    			heroe.obtenerEspadaAzul();
    			break;
    			
    		case Casilla.ESPADA_AMARILLA:
    			heroe.obtenerEspadaAmarilla();
    			break;
    			
    		case Casilla.PUERTA_ROJA:
    			if(!heroe.tieneLlaveRoja())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas la llave roja");
    			}
    			break;
    			
    		case Casilla.PUERTA_AZUL:
    			if(!heroe.tieneLlaveAzul())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas la llave azul");
    			}
    			break;
    			
    		case Casilla.PUERTA_AMARILLA:
    			if(!heroe.tieneLlaveAmarilla())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas la llave amarilla");
    			}
    			break;
    			
    		case Casilla.PUERTA_SALIDA:
    			if(!heroe.tieneLlaveRoja() || !heroe.tieneLlaveAzul()  || !heroe.tieneLlaveAmarilla())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas las 3 llaves");
    			}
    			
    			JOptionPane.showMessageDialog(null, "!Felicidades has ganado!\n Mataste "+((darNumeroDemonios()-heroe.darNumeroDemonios())+"/"+darNumeroDemonios())+" demonios","Información",JOptionPane.INFORMATION_MESSAGE);
    			cambiarEstadoJuego(false);
    			
    			break;
    			
    			default:
    				throw new Exception("Casilla vacía");
    				
    		}
    		 mapa[heroe.darPosX()-1][heroe.darPosY()].cambiarEstado(Casilla.PISO);
    		 mapa[heroe.darPosX()-1][heroe.darPosY()].cambiarImagen(tipos[Casilla.PISO]);
        	 
     		}
		}
    	 
    	 // metodo para recoger llaves en direccion norte
    	 
    	 public void accionArriba() throws Exception   
         {
    		 if(heroe.darPosY()-1 > 0)
    		 {
    		 
    		 switch (mapa[heroe.darPosX()][heroe.darPosY()-1].darEstado()) 
        	 {
        	 
    		case Casilla.LLAVE_ROJA:
    			
    			heroe.obtenerLlaveRoja();
    			
    			break;
        	 
    		case Casilla.LLAVE_AZUL:
    			heroe.obtenerLlaveAzul();
    			break;
    			
    		case Casilla.LLAVE_AMARILLA:
    			heroe.obtenerLlaveAmarilla();
    			break;
    			
    		case Casilla.DEMONIO_ROJO:
    			if(heroe.tieneEspadaRoja())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada roja");
    			}
    			break;
    			
    		case Casilla.DEMONIO_AZUL:

    			if(heroe.tieneEspadaAzul())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada azul");
    			}
    			break;
    			
    		case Casilla.DEMONIO_AMARILLO:
    			if(heroe.tieneEspadaAmarilla())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada amarilla");
    			}
    			break;
    			
    		case Casilla.ESPADA_ROJA:
    			heroe.obtenerEspadaRoja();
    			break;
    			
    		case Casilla.ESPADA_AZUL:
    			heroe.obtenerEspadaAzul();
    			break;
    			
    		case Casilla.ESPADA_AMARILLA:
    			heroe.obtenerEspadaAmarilla();
    			break;
    			
    		case Casilla.PUERTA_ROJA:
    			if(!heroe.tieneLlaveRoja())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas la llave roja");
    			}
    			break;
    			
    		case Casilla.PUERTA_AZUL:
    			if(!heroe.tieneLlaveAzul())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas la llave azul");
    			}
    			break;
    			
    		case Casilla.PUERTA_AMARILLA:
    			if(!heroe.tieneLlaveAmarilla())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas la llave amarilla");
    			}
    			break;
    			
    		case Casilla.PUERTA_SALIDA:
    			if(!heroe.tieneLlaveRoja() || !heroe.tieneLlaveAzul()  || !heroe.tieneLlaveAmarilla())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas las 3 llaves");
    			}
    			
    			JOptionPane.showMessageDialog(null, "!Felicidades has ganado!\n Mataste "+((darNumeroDemonios()-heroe.darNumeroDemonios())+"/"+darNumeroDemonios())+" demonios","Información",JOptionPane.INFORMATION_MESSAGE);
    			cambiarEstadoJuego(false);
    			
    			break;
    			
    			default:
    				throw new Exception("Casilla vacía");
    				
    		}
    		 mapa[heroe.darPosX()][heroe.darPosY()-1].cambiarEstado(Casilla.PISO);
    		 mapa[heroe.darPosX()][heroe.darPosY()-1].cambiarImagen(tipos[Casilla.PISO]);
        	 
     		} 
		}	
    	 
    	 // metodo que recoge llaves en direccion sur
    	 
    	 
    	 public void accionAbajo() throws Exception   
         {
    
    		 if(heroe.darPosY()+1 < numFilas)
    		 {
    		 switch (mapa[heroe.darPosX()][heroe.darPosY()+1].darEstado()) 
        	 {
        	 
    		case Casilla.LLAVE_ROJA:
    			
    			heroe.obtenerLlaveRoja();
    			
    			break;
        	 
    		case Casilla.LLAVE_AZUL:
    			heroe.obtenerLlaveAzul();
    			break;
    			
    		case Casilla.LLAVE_AMARILLA:
    			heroe.obtenerLlaveAmarilla();
    			break;
    			
    		case Casilla.DEMONIO_ROJO:
    			if(heroe.tieneEspadaRoja())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada roja");
    			}
    			break;
    			
    		case Casilla.DEMONIO_AZUL:

    			if(heroe.tieneEspadaAzul())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada azul");
    			}
    			break;
    			
    		case Casilla.DEMONIO_AMARILLO:
    			
    			if(heroe.tieneEspadaAmarilla())
    			{
    			heroe.EliminarDeomonio();
    			}
    			else 
    			{
    			throw new Exception("No puedes derrotar al demonio. Necesitas la espada amarilla");
    			}
    			break;
    			
    		case Casilla.ESPADA_ROJA:
    			heroe.obtenerEspadaRoja();
    			break;
    			
    		case Casilla.ESPADA_AZUL:
    			heroe.obtenerEspadaAzul();
    			break;
    			
    		case Casilla.ESPADA_AMARILLA:
    			heroe.obtenerEspadaAmarilla();
    			break;
    			
    		case Casilla.PUERTA_ROJA:
    			if(heroe.tieneLlaveRoja())
    			{		
    				throw new Exception("No puedes abrir la puerta. Necesitas la llave roja");
    			}
    			break;
    			
    		case Casilla.PUERTA_AZUL:
    			if(heroe.tieneLlaveAzul())
    			{
    				throw new Exception("No puedes abrir la puerta. Necesitas la llave azul");
    			}
    			break;
    			
    		case Casilla.PUERTA_AMARILLA:
    			if(!heroe.tieneLlaveAmarilla())
    			{
    				throw new Exception("No puedes abrir la puerta. Necesitas la llave amarilla");
    			}
    			break;
    			
    		case Casilla.PUERTA_SALIDA:
    			if(!heroe.tieneLlaveRoja() || !heroe.tieneLlaveAzul()  || !heroe.tieneLlaveAmarilla())
    			{
    			throw new Exception("No puedes abrir la puerta. Necesitas las 3 llaves");
    			}
    			
    			JOptionPane.showMessageDialog(null, "!Felicidades has ganado!\n Mataste "+((darNumeroDemonios()-heroe.darNumeroDemonios())+"/"+darNumeroDemonios())+" demonios"+" demonios");
    			cambiarEstadoJuego(false);
    			
    			break;
    			
    			default:
    				throw new Exception("Casilla vacía");
    				
    		}
    		 mapa[heroe.darPosX()][heroe.darPosY()+1].cambiarEstado(Casilla.PISO);
    		 mapa[heroe.darPosX()][heroe.darPosY()+1].cambiarImagen(tipos[Casilla.PISO]);
        	 
     		}

         }
    	 
    	    // -------------------------------------------------------------
    	    // Métodos de extensión
    	    // -------------------------------------------------------------

    	    /**
    	     * Método para la extensión 1
    	     * @return respuesta1
    	     */
    	    public String metodo1( )
    	    {
    	        return "Respuesta 1";
    	    }

    	    /**
    	     * Método para la extensión 2
    	     * @return respuesta2
    	     */
    	    public String metodo2( )
    	    {
    	        return "Respuesta 2";
    	    }
	
	
	
}