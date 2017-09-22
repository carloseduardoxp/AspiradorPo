package util;

import modelo.StatusAmbiente;

public interface Observavel {
	
	public void notifica(String texto);
	
	public void notifica(StatusAmbiente s,Integer x,Integer y);

}
