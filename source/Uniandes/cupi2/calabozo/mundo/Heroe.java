package Uniandes.cupi2.calabozo.mundo;

public class Heroe 

{

	//-----------------
	// ATRIBUTOS
	//-----------------
	private int numVidas;
	private int numEspadas;
	private int numLlaves;
	
	private int posX;
	private int posY;
	private int numDemonios;
	
	private boolean espadaRoja;
	private boolean espadaAzul;
	private boolean espadaAmarrilla;
	
	private boolean llaveRoja;
	private boolean llaveAzul;
	private boolean llaveAmarrilla;
	
	
	
	//---------------------
	// CONSTRUCTORES
	//---------------------
	public Heroe(int nPosX,int nPosY, int nNumDemonios)
	{
		numVidas = 3;
		numEspadas= 0;
		numLlaves = 0;
		
		numDemonios =nNumDemonios;
		posX = nPosX;
		posY = nPosY;
		
		espadaAmarrilla=false;
		espadaAzul=false;
		espadaRoja =false;
		
		llaveAmarrilla=false;
		llaveAzul=false;
		llaveRoja=false;
			
		
	}
	//----------------------------------
	// METODOS QUE RETORNAN LOS ATRIBUTOS
	//----------------------------------
	public int darVidas()
	{
		return numVidas;
	}
	
	public int darNumerosEspadas()
	{
		
		return numEspadas;
	}
	
	public int darNumeroLlaves()
	{
		return numLlaves;
	}
	
	public int darPosX()
	{
		return posX;
	}
	
	public int darPosY()
	{
		return posY;
	}
	
	public int darNumeroDemonios()
	{
		return numDemonios;
	}
	public int darNumeroDemoniosDerrotados()
	{
		return numDemonios;
	}
	
	public void EliminarDeomonio()
	{
	numDemonios--;
	}
	
	public void obtenerEspadaRoja()
	{
	espadaRoja = true ;
	numEspadas++;
	}
	
	public void obtenerEspadaAzul()
	{
		espadaAzul = true;
		numEspadas++;
	}
	
	public void obtenerEspadaAmarilla()
	{
		espadaAmarrilla = true;
		numEspadas++;

	}
	
	public void obtenerLlaveRoja()
	{
		
		llaveRoja= true;
		numLlaves++;
		
	}
	
	public void obtenerLlaveAzul()
	{
		llaveAzul = true;
		numLlaves++;
	}
	
	public void obtenerLlaveAmarilla()
	{
		llaveAmarrilla = true;
		numLlaves++;
	}
	
//	public boolean puedeAbrirPuertaRoja()
//	{
//		boolean puedeAbrir = false;
//		
//		if(tieneLlaveRoja())
//			puedeAbrir= true;
//		
//		return puedeAbrir;
//	}
//	
//	public boolean puedeAbrirPuertaAzul()
//	{
//		boolean puedeAbrir = false;
//		
//		if(tieneLlaveAzul())
//			puedeAbrir= true;
//		
//		return puedeAbrir;
//		
//	}
//	
//	public boolean puedeAbrirPuertaAmarilla()
//	{
//		boolean puedeAbrir = false;
//		
//		if(tieneLlaveAmarilla())
//			puedeAbrir= true;
//		
//		return puedeAbrir;
//		
//	}
	
	public void cambiarPosicion(int nPosX, int nPosY)
	{
		posX = nPosX;
		posY = nPosY;	
	}
	
	//---------------------------
	// METODOS QUE MODIFICAN LOS ATRIBUTOS
	//---------------------------
	
	public void perderVida()
	{
		numVidas--;
	}
	
	public boolean tieneLlaveRoja()
	{
		return llaveRoja;
	}
	
	public boolean tieneLlaveAzul()
	{
		return llaveAzul;
	}
	
	public boolean tieneLlaveAmarilla()
	{
		return llaveAmarrilla;
	}
	
	public boolean tieneEspadaRoja()
	{
		return espadaRoja;
	}
	
	public boolean tieneEspadaAzul()
	{
		return espadaAzul;
	}
	
	public boolean tieneEspadaAmarilla()
	{
		return espadaAmarrilla;
	}
	
	
	
	
	
	
	
}
