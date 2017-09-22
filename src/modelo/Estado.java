package modelo;

import java.util.Arrays;

public class Estado {
	
	private Estado estadoPai;
	
	//posicaoX em que o aspirador se encontra
	private Integer posicaoX;
	
	//posicaoY em que o aspirador se encontra
	private Integer posicaoY;
	
	//Acao a ser executada (aspirar, cima,baixo,esquerda,direita)
	private Acao acao;
	
	private StatusAmbiente[][] statusAmbiente;
	
	public Estado(Estado estadoPai,Integer posicaoX,Integer posicaoY,Acao acao,StatusAmbiente[][] statusAmbiente) {
		
		this.estadoPai = estadoPai;
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
		this.acao = acao;
		this.statusAmbiente = statusAmbiente;
	}
		
	public Estado(Integer posicaoX,Integer posicaoY,Acao acao) {
		this(null,posicaoX,posicaoY,acao,null);
	}
	
	public Estado(Estado estadoPai,Integer posicaoX,Integer posicaoY,Acao acao) {
		this(estadoPai,posicaoX,posicaoY,acao,null);
	}

	
	public Estado(Integer posicaoX,Integer posicaoY,StatusAmbiente[][] statusAmbiente) {
		this(null,posicaoX,posicaoY,null,statusAmbiente);
	}
	
	public boolean isEstadoObjetivo() {
		for (int i = 0; i < statusAmbiente.length;i++) {
			for (int j = 0; j < statusAmbiente[0].length;j++) {
				if (statusAmbiente[i][j] == StatusAmbiente.SUJO) {
					return false;
				}
			}
		}
		return true;
	}

	public StatusAmbiente getStatusAmbienteEstado() {
		return statusAmbiente[posicaoX][posicaoY];
	}
	
	public StatusAmbiente[][] getStatusAmbienteClone() {
		StatusAmbiente[][] s = new StatusAmbiente[Agente.posX][Agente.posY];
		for (int i = 0; i < Agente.posX;i++) {
			for (int j = 0; j < Agente.posY;j++) {
				s[i][j] = statusAmbiente[i][j];
			}		
		}
		return s;
	}


	public Integer getPosicaoX() {
		return posicaoX;
	}
	
	public void setPosicaoX(Integer posicaoX) {
		this.posicaoX = posicaoX;
	}

	public Integer getPosicaoY() {
		return posicaoY;
	}

	public void setPosicaoY(Integer posicaoY) {
		this.posicaoY = posicaoY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((posicaoX == null) ? 0 : posicaoX.hashCode());
		result = prime * result + ((posicaoY == null) ? 0 : posicaoY.hashCode());
		result = prime * result + Arrays.deepHashCode(statusAmbiente);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (posicaoX == null) {
			if (other.posicaoX != null)
				return false;
		} else if (!posicaoX.equals(other.posicaoX))
			return false;
		if (posicaoY == null) {
			if (other.posicaoY != null)
				return false;
		} else if (!posicaoY.equals(other.posicaoY))
			return false;
		if (!Arrays.deepEquals(statusAmbiente, other.statusAmbiente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado [posicaoX=" + posicaoX + ", posicaoY=" + posicaoY + ", acao=" + acao + ", statusAmbiente="
				+ Arrays.toString(statusAmbiente) + "]";
	}

	public Estado getEstadoPai() {
		return estadoPai;
	}

	public Acao getAcao() {
		return acao;
	}
	
	

}
