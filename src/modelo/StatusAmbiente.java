package modelo;

public enum StatusAmbiente {
	LIMPO('L'),
	SUJO('S');
	
	private Character caractere;
	
	private StatusAmbiente(Character caractere) {
		this.caractere = caractere;
	}

	public Character getCaractere() {
		return caractere;
	}
	
	@Override
	public String toString() {
		return this.caractere+"";
	}

}
