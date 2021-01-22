package boletin_05_objetos;

public class Grupo {
	
	private static final int MAX_COMPONENTES = 10;
	private String nombre;
	private final int anyoFundacion;
	private Componente[] componentes;
	
	public Grupo(String nombre, int anyoFundacion) {
		this.nombre = nombre;
		this.anyoFundacion = anyoFundacion;
		componentes = new Componente[MAX_COMPONENTES];
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the componentes
	 */
	public Componente[] getComponentes() {
		return componentes;
	}
	
	/**
	 * @param componentes the componentes to set
	 */
	public void addComponente(Componente componente) {
		int nComponentes = getNumeroComponentes();
		if (nComponentes <= MAX_COMPONENTES) {
			this.componentes[nComponentes] = componente;
		}
	}
	
	/**
	 * @return the anyoFundacion
	 */
	public int getAnyoFundacion() {
		return anyoFundacion;
	}
	
	public int getNumeroComponentes() {
		int i = 0;
		while (i < this.componentes.length && this.componentes[i] != null) {
			i++;
		}
		return i;
	}
}
