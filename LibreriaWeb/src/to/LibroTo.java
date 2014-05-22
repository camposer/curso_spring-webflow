package to;

import java.io.Serializable;

public class LibroTo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombre;
	private Float precio;
	private Integer cantidad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Float getTotal() {
		return cantidad * precio;
	}
}
