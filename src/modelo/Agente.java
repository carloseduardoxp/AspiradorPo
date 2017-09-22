package modelo;

import util.Observavel;

public class Agente implements Runnable {
	
	private Observavel observavel;
	
	//private Ambiente ambiente;
	
	private Busca busca;
	
	public static Integer posX;
	
	public static Integer posY;
	
	private Estado estadoInicial;
	
	private Estado estadoObjetivo;
	
	public Agente(Integer x,Integer y,Busca busca,StatusAmbiente[][] status,
			Observavel observavel,Integer posX,Integer posY) {
		//this.ambiente = new Ambiente(status);
		this.busca = busca;
		this.estadoInicial = new Estado(x, y, status);
		this.observavel = observavel;
		Agente.posX = posX;
		Agente.posY = posY;
	}
	
	public void run() {
		observavel.notifica("Iniciando a busca cega");		
		this.estadoObjetivo = busca.executaBuscaCega(estadoInicial);	
		System.out.println("**********Caminho Ate Objetivo**********");
		imprimeCaminhoAteObjetivo(estadoObjetivo);
		System.out.println("*************************************\n\n");

	}
	
	private void imprimeCaminhoAteObjetivo(Estado estado) {
		int pos = 1;
		String resultado = "";
		resultado += imprimeEstado(estado, pos);
		Estado e = estado;

		while (e.getEstadoPai() != null) {
			pos++;
			e = e.getEstadoPai();
			resultado = imprimeEstado(e, pos) + resultado;
		}

		System.out.println(resultado);

	}
	
	private String imprimeEstado(Estado estado, int pos) {
		return  "" + pos + "\n" +
				"Posicao: [" + estado.getPosicaoX() + ","+estado.getPosicaoY()+"]\n" +
				"Acao: " + estado.getAcao()+ "\n\n";
	}


	public Estado getEstadoObjetivo() {
		return estadoObjetivo;
	}

}
