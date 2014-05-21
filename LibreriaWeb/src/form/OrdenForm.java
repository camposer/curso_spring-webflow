package form;

public class OrdenForm {
	private Long categoria;
	private Long libro;
	private Integer cantidad;

	public Long getCategoria() {
		return categoria;
	}
	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}
	public Long getLibro() {
		return libro;
	}
	public void setLibro(Long libro) {
		this.libro = libro;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "OrdenForm [categoria=" + categoria + ", libro=" + libro
				+ ", cantidad=" + cantidad + "]";
	}
	
	
}
