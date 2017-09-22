package modelo;

import java.util.LinkedHashSet;
import java.util.Set;

import util.Observavel;

public abstract class Busca {
	
	private Set<Estado> estadosVisitados;
	
	private Observavel observavel;
	
	protected abstract void adicionaEstadoAVisitar(Estado estado);
	
	protected abstract Estado getProximoEstadoExplorar();
	
	public Busca(Observavel observavel) {
		this.observavel = observavel;
		this.estadosVisitados = new LinkedHashSet<>();
	}
	
	public Estado executaBuscaCega(Estado estado) {
		observavel.notifica(estado.getStatusAmbienteEstado(),estado.getPosicaoX(),estado.getPosicaoY());		
		if (estado.isEstadoObjetivo()) {
			estadosVisitados.add(estado);
			return estado;
		}
		if (!estadosVisitados.contains(estado)) {
			for (Acao acao: Acao.values()) {
				adicionaEstadoAVisitar(getEstado(acao,estado));
			}
			estadosVisitados.add(estado);
		} 	
		return executaBuscaCega(getProximoEstadoExplorar());
	}

	private Estado getEstado(Acao acao,Estado estado) {
		Integer deslocamentoX = acao.getDeslocamentoX();
		Integer deslocamentoY = acao.getDeslocamentoY();
		if (estado.getPosicaoX()+deslocamentoX < 0 || 
			estado.getPosicaoX()+deslocamentoX > Agente.posX-1) {
			return null;
		}
		if (estado.getPosicaoY()+deslocamentoY < 0 || 
			estado.getPosicaoY()+deslocamentoY > Agente.posY-1) {
			return null;
		}
		StatusAmbiente[][] status = estado.getStatusAmbienteClone();
		if (acao == Acao.ASPIRAR) {			
			status[estado.getPosicaoX()+deslocamentoX][estado.getPosicaoY()+deslocamentoY] = 
					StatusAmbiente.LIMPO;
		}
		return new Estado(estado,
			         estado.getPosicaoX()+deslocamentoX, 
			          estado.getPosicaoY()+deslocamentoY,
			          acao, 
			          status);			
	}

}
