package prova.provando;

public class Pantalla {
	private static Pantalla pantalla;
	int amplada;
	int llargada;
	
	public static Pantalla getPantalla(){
		if (pantalla == null) pantalla = new Pantalla();
		return pantalla;
	}
	
	public int getPantallaLlargada(){
		return llargada;
	}
	
	public int getPantallaAmplada(){
		return amplada;
	}
	
	public void setPantallaMida(int amplada, int llargada){
		this.amplada=amplada;
		this.llargada=llargada;
	}
}
