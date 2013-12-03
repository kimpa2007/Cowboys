package prova.provando;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class Principal extends GraphicsProgram {
	private static final long serialVersionUID = 1L;

	ArrayList<Cosa> coses = new ArrayList<Cosa>();
	
	public void init() {
		GImage fons = new GImage("dune.jpg", 0, 0);
		setSize((int) fons.getWidth(), (int) fons.getHeight());
		add(fons);
		fons.sendBackward();
		
		Pantalla p = Pantalla.getPantalla();
		p.setPantallaMida((int)fons.getWidth(),(int)fons.getHeight());
	}

	public void run() {

		// Afegeixo els 2 cowboys
		coses.add(new Cowboy("lucky.gif"));
		coses.add(new Cowboy("cowboy2.gif"));
		
		//Crido la funció que carrega els cargadors inicials.
	//	carregaInicial();

		Cosa lucky = coses.get(0);
		Cosa cowboy = coses.get(1);

		// Posiciono els cowboys
		lucky.setPosicio(0, getHeight()/2);
		cowboy.setPosicio(getWidth()-cowboy.getAmplada(),getHeight()/2);
		
		// Genero cactus.
		for (int i = 2; i < 20; i++) {
			coses.add(new CosaEstàtica("cactus.gif"));
			// S'hauria de mirar que no es generin on es troben els cowboys....
			coses.get(i).setPosicioAleatoria(
					getHeight() - coses.get(i).getLlargada(),
					getWidth() - coses.get(i).getAmplada());
		}
		
		//Afegeixo els elements per pantalla
		for (int i = 0; i < coses.size(); i++) {
			add(coses.get(i).getImatge());
		}
		// Escolta entrades del teclat
		addKeyListeners();
	}

	// Segons la tecla premada, es fa una cosa o una altre
	// --- Si toca amb un cactus, mort el cowboy!!
	public void keyPressed(KeyEvent e) {
		Cosa lucky = coses.get(0);
		Cosa cowboy = coses.get(1);
		
		switch (e.getKeyCode()) {
		//Desplaçar Lucky Luke
		case KeyEvent.VK_W:  	lucky.moure(0, -10); 	break;
		case KeyEvent.VK_Z:  	lucky.moure(0, 10);   	break;
		case KeyEvent.VK_A:  	lucky.moure(-10, 0); 	break;
		case KeyEvent.VK_S:  	lucky.moure(10, 0); 	break;
		case KeyEvent.VK_D:	    lucky.dispara(lucky.getAmplada(), lucky.getLlargada());
							int ultimaPosicio= (coses.size()-1);
							add(coses.get(ultimaPosicio).getImatge());
								
			/*
			if(cargadorLucky.size()<5){
				//busco la ultima posicio, per saber a quin lloc ha d'anar la bala en la pantalla.
				cargadorLucky.add(new Bala(coses.get(0).getAmplada(), coses.get(0).getLlargada()));
				cargadorLucky.get(posicio).setPosicio(100+40*posicio,0);
				add(cargadorLucky.get(posicio).getImatge());
			}*/
		break;
					
			
		//Desplaçar l'altre Cowboy
		case KeyEvent.VK_UP:   	cowboy.moure(0, -10); 	break;
		case KeyEvent.VK_DOWN: 	cowboy.moure(0, 10);	break;
		case KeyEvent.VK_LEFT: 	cowboy.moure(-10, 0);	break;
		case KeyEvent.VK_RIGHT:	cowboy.moure(10, 0); 	break;
		case KeyEvent.VK_SPACE:
			Bala balaCowboy = new Bala(cowboy.getAmplada(), cowboy.getLlargada());
			balaCowboy.getImatge().setSize(60, 30);
			add(balaCowboy.getImatge());
			//cargadorCowboy.add(balaCowboy);
			break;
		}
	}
	/*
	public void carregaInicial(){
		for(int i=0; i<TOTALBALES; i++){
		cargadorLucky.add(new Bala(coses.get(0).getAmplada(), coses.get(0).getLlargada()));
	}
	
	for(int i=0; i<cargadorLucky.size(); i++){
		cargadorLucky.get(i).getImatge().setSize(60,30);
		cargadorLucky.get(i).setPosicio(100+40*i,0);;
		add(cargadorLucky.get(i).getImatge());
	}

	}
	*/
}
