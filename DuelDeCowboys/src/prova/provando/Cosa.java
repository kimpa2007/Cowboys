package prova.provando;


import acm.graphics.GImage;

public abstract class Cosa {
	
	private static final long serialVersionUID = -9026631590887421067L;
	GImage cosa;
	
	public Cosa (String imatge){
		cosa = new GImage(imatge);
		cosa.setSize(35,70);
	}
	
	
	public GImage getImatge(){
		return cosa;
	}
	
	public int getLlargada(){
		return (int)(cosa.getY() + cosa.getHeight());
	}
	
	public int getAmplada(){
		return (int)(cosa.getX() + cosa.getWidth());
	}
	
	public void setPosicio(int x, int y){
		cosa.setLocation(x,y);
	}
	
	public void setPosicioAleatoria(int w, int h){
		int widthImatge = (int) cosa.getWidth();
		int heightImatge = (int) cosa.getHeight();
		
		int x = generaPosicio(h - heightImatge);
		int y = generaPosicio(w - widthImatge);
		cosa.setLocation(x,y);
	}
	
	public void enviaDavant(){
		cosa.sendToFront();
	}
	
	public void enviaDarrera(){
		cosa.sendBackward();
	}
	
	public abstract void moure(int x, int y);
	public abstract void dispara(int x, int y);

	public int generaPosicio(int maxim){
		return (int)(Math.random() * maxim);
	}
}
