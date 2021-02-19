package boletin_08_herencia.estrellas;

public enum TipoEstrella {
	ENANA_BLANCA(1, 0.84f, 1.04f), 
	GIGANTE_ROJA(2, 0.89f, 1.20f), 
	PROTOESTRELLA(3, 0.93f, 1.29f), 
	ENANA_NEGRA(4, 0.99f, 1.5f), 
	ESTRELLA_DE_NEUTRONES(5, 1.28f, 167f);
	
	private int tipo;
	private float distanciaMinimaZonaHatibable;
	private float distanciaMaximaZonaHatibable;
	
	private TipoEstrella (int tipo, float distanciaMinZH, float distanciaMaxZH) {
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return this.tipo;
	}
	
	public float getDistanciaMinimaZonaHabitable() {
		return this.distanciaMinimaZonaHatibable;
	}
	
	public float getDistanciaMaximaZonaHabitable() {
		return this.distanciaMaximaZonaHatibable;
	}
}
