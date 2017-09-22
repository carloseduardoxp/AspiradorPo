package modelo;

public class Ambiente {
		
	private StatusAmbiente[][] posicoes;
	
	public Ambiente(StatusAmbiente[][] statusAmbiente) {
		this.posicoes = statusAmbiente;
	}
	
	public StatusAmbiente sensorLeAmbiente(Integer x,Integer y) {
		return posicoes[x][y];
	}
	
	public void atuadorAmbiente(Integer x,Integer y,StatusAmbiente statusAmbiente) {
		posicoes[x][y] = statusAmbiente;
	}
	
	public Integer getTamanhoX() {
		return posicoes.length;
	}

	public Integer getTamanhoY() {
		return posicoes[0].length;
	}

}
