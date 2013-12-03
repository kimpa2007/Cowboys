package prova.provando;

import java.util.ArrayList;

public class Cowboy extends CosaMòbil {
	ArrayList<Bala> cargador = new ArrayList<Bala>();
    private static final int TOTALBALES= 6;

	public Cowboy(String imatge) {
		super(imatge);
	}

	public void moure(int x, int y){
		if (x + (cosa.getX() + cosa.getWidth()) < p.amplada && x + cosa.getX() > 0)	cosa.move(x, 0);
		if (y + (cosa.getY() + cosa.getHeight()) < p.llargada && y + cosa.getY() > 0) 	cosa.move(0, y);
	}
	
	public void dispara(int x, int y){
		if(cargador.size()<TOTALBALES){
			cargador.add(new Bala(x,y));
		}
		
	}
	/*
	public void carregaInicial(int x, int y){
		if (cargador.size() == 0) carregaCargador(x,y);
	}
	
	public void carregaCargador(int x, int y){
			while(cargador.size() < TOTALBALES){
				cargador.add(new Bala(x,y));
			}
	}
	
	public ArrayList<Bala> cargador(){
		return cargador;
	}
	*/
}
