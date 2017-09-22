package modelo;

import java.util.LinkedList;
import java.util.Queue;

import util.Observavel;

public class BuscaLargura extends Busca {
	
	private Queue<Estado> queue;
	
	public BuscaLargura(Observavel observavel) {		
		super(observavel);
		queue = new LinkedList<>();
	}

	@Override
	protected void adicionaEstadoAVisitar(Estado estado) {
		if (estado != null) {
			queue.add(estado);
		}		
	}
	
	@Override
	protected Estado getProximoEstadoExplorar() {
		return queue.poll();
	}

	@Override
	protected Acao[] getSequenciaAcoes() {
		Acao[] acoes = {Acao.ESQUERDA,Acao.DIREITA,Acao.CIMA,Acao.BAIXO,Acao.ASPIRAR}; 
		return acoes;
	}


}
