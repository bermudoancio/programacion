package boletin_08_herencia.estrellas;

public class Estrella {
	public static final int NUMERO_PLANETAS_MAX = 7;
	
	private String nombre;
	private double diametro;
	private TipoEstrella tipo;
	private Planeta[] planetas;
	// Las distancias mínimas y máximas van asociadas al tipo de estrella
//	private final float distanciaMinimaZonaHabitable;
//	private final float distanciaMaximaZonaHabitable;
	
	public Estrella(String nombre, double diametro, TipoEstrella tipo,
			float distanciaMinimaZonaHabitable, float distanciaMaximaZonaHabitable) {
		super();
		this.nombre = nombre;
		this.diametro = diametro;
		this.tipo = tipo;
		this.planetas = new Planeta[Estrella.NUMERO_PLANETAS_MAX];
	}
	
	public static int getNumeroPlanetasMax() {
		return NUMERO_PLANETAS_MAX;
	}

	public String getNombre() {
		return nombre;
	}

	public double getDiametro() {
		return diametro;
	}

	public TipoEstrella getTipo() {
		return tipo;
	}

	public Planeta[] getPlanetas() {
		return planetas;
	}
	
	public Planetoide[] getPlanetasHabitables() {
		Planetoide[] planetoidesHabitables = new Planetoide[Estrella.NUMERO_PLANETAS_MAX * Planeta.MAX_LUNAS];
		
		for (Planeta p: planetas) {
			if (p != null) {
				if (this.esHabitable(p, p.getDistanciaMediaAlSol())) {
					Estrella.addPlanetoideAArray()
				}
			}
		}
		
		return planetoidesHabitables;
	}

	private boolean esHabitable(Planetoide p, double distanciaEstrella) {
		boolean esHabitable = false;
		if (p.getTipo().equals(TipoPlaneta.ROCOSO) 
				&& distanciaEstrella >= this.getTipo().getDistanciaMinimaZonaHabitable()
				&& distanciaEstrella <= this.getTipo().getDistanciaMaximaZonaHabitable()) {
			esHabitable = true;
		}
		
		return esHabitable;
	}
	
}
