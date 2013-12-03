package prova.provando;

public class Bala extends CosaMòbil {

    public Bala(double x, double y){
    	super("bala.gif");
    }

    public void moure(int x, int y){
    	
    	cosa.move(x, y);
    }

	@Override
	public void dispara(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
