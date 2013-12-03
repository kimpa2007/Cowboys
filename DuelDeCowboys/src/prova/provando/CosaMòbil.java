package prova.provando;

public abstract class CosaMòbil extends Cosa {
	
	private static final long serialVersionUID = -4433197790871798837L;
	Pantalla p = Pantalla.getPantalla();

	public CosaMòbil(String imatge){
		super(imatge);
		cosa.setSize(55,80);
	}
	public abstract void moure(int x, int y);
}
