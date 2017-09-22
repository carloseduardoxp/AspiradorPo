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
		System.out.println("**********Estados Visitados**********");
		int pos = 1;
		for (Estado estadoVisitado: busca.getEstadosVisitados()) {
			System.out.println(imprimeEstado(estadoVisitado, pos++));
		}
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
				"Posicao Agente: [" + estado.getPosicaoX() + ","+estado.getPosicaoY()+"]\n" +
				getMatriz(estado.getStatusAmbienteClone())+"\n\n";
	}


	private String getMatriz(StatusAmbiente[][] statusAmbiente) {
		StringBuilder saida = new StringBuilder("");
		for (int i = 0; i < Agente.posX;i++) {
			saida.append("(");
			for (int j = 0; j < Agente.posY;j++) {
				saida.append(statusAmbiente[i][j].name()+",");
			}
			saida.delete(saida.length()-1,saida.length());
			saida.append(")\n");
		}

		return saida.toString();
	}

	public Estado getEstadoObjetivo() {
		return estadoObjetivo;
	}

}
