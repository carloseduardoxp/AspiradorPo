package modelo;

import java.util.Stack;

import util.Observavel;

public class BuscaProfundidade extends Busca {
	
	private Stack<Estado> estados;
	
	public BuscaProfundidade(Observavel observavel) {
		super(observavel);
		estados = new Stack<>();
	}
	
	@Override
	protected void adicionaEstadoAVisitar(Estado estado) {
		if (estado != null) {
			estados.push(estado);
		}		
	}

	@Override
	protected Estado getProximoEstadoExplorar() {
		return estados.pop();
	}

}
