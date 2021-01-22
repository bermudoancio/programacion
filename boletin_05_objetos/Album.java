package boletin_05_objetos;

public class Album {
	private String nombre;
	private String estudio;
	private int anyo;
	private Grupo grupo;
	
	public Album(String nombre, String estudio, int anyo, Grupo grupo) {
		this.setNombre(nombre);
		this.setEstudio(estudio);
		this.setAnyo(anyo);
		this.setGrupo(grupo);
	}
	
	/**
	 * @return the name
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setNombre(String name) {
		this.nombre = name;
	}
	
	/**
	 * @return the estudio
	 */
	public String getEstudio() {
		return estudio;
	}
	
	/**
	 * @param estudio the estudio to set
	 */
	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	/**
	 * @return the anyo
	 */
	public int getAnyo() {
		return anyo;
	}
	
	/**
	 * @param anyo the anyo to set
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}
	
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
}
