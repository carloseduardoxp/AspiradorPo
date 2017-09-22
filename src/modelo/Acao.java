package modelo;

public enum Acao {
	ESQUERDA(0,-1),
	DIREITA(0,1),
	CIMA(-1,0),
	BAIXO(1,0),	
	ASPIRAR(0,0);
	
	private Integer deslocamentoX;
	
	private Integer deslocamentoY;
	
	private Acao(Integer deslocamentoX,Integer deslocamentoY) {
		this.deslocamentoX = deslocamentoX;
		this.deslocamentoY = deslocamentoY;
	}

	public Integer getDeslocamentoX() {
		return deslocamentoX;
	}

	public Integer getDeslocamentoY() {
		return deslocamentoY;
	}

}
