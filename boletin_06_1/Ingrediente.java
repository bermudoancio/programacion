package boletin_06_1;


public class Ingrediente {
	private String nombreIngrediente;
	private int cantidad;

	public Ingrediente(String ingrediente) {
		this.nombreIngrediente = nombreIngrediente.toUpperCase();
	}

	public Ingrediente(String nombreIngrediente, int cantidad) {
		super();
		this.nombreIngrediente = nombreIngrediente.toUpperCase();
		this.cantidad = cantidad;
	}

	public String getNombreIngrediente() {
		return nombreIngrediente;
	}

	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Ingrediente [nombreIngrediente=" + nombreIngrediente + ", cantidad=" + cantidad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreIngrediente == null) ? 0 : nombreIngrediente.hashCode());
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
		Ingrediente other = (Ingrediente) obj;
		if (nombreIngrediente == null) {
			if (other.nombreIngrediente != null)
				return false;
		} else if (!nombreIngrediente.equals(other.nombreIngrediente))
			return false;
		return true;
	}

}
