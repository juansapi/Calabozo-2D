package Uniandes.cupi2.calabozo.mundo;

public class Casilla 
{
	/**
	 * 
	 */
	public final static int HEROE = 0;
	
	public final static int MURO = 1;
	
	public final static int PISO = 2;
	
	public final static int LLAVE_ROJA = 3;

	public final static int LLAVE_AZUL = 4;
	
	public final static int LLAVE_AMARILLA = 5;
	
	public final static int PUERTA_ROJA = 6;
	
	public final static int PUERTA_AZUL = 7;
	
	public final static int PUERTA_AMARILLA= 8;
	
	public final static int PUERTA_SALIDA = 9;
	
	public final static int DEMONIO_ROJO = 10;
	
	public final static int DEMONIO_AZUL = 11;
	
	public final static int DEMONIO_AMARILLO = 12;
	
	public final static int ESPADA_ROJA = 13;
	
	public final static int ESPADA_AZUL = 14;
	
	public final static int ESPADA_AMARILLA= 15;
	
	
	private int estado;
	
	private int posx;
	
	private int posy;
	private String imagen;
	
	public Casilla(int nEstado, int nPosx , int nPosy , String nImagen)
	{
		estado = nEstado;
		posx = nPosx;
		posy = nPosy;
		imagen = nImagen;
		
	}
	
	// metodo que retorna los atributos
	
	public int darEstado(){
		return estado;
	}
	
	public int darPosicionX(){
		return posx;
	}
	
	public int darPosicionY(){
		return posy;
	}
	public String darImagen()
	{
		return imagen;
	}
	
	// --------------------
	
	public boolean compararCasilla(Casilla otra){
		
		int miEstado = darEstado();
		int otroEstado = otra.darEstado();
		boolean iguales = false;
		
		if(miEstado == otroEstado)
		{
			iguales = true;
		}
		return iguales;
	}
	
	// metodo que modifica el estado decada casilla
	
	public void cambiarEstado(int  nEstado)
	{
		estado = nEstado;
	}
	
	// cambiar imagen de la casilla
	
	public void cambiarImagen(String nImagen){
		
		imagen = nImagen;
		
	}

}
