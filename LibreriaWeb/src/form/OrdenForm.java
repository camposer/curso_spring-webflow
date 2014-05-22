package form;

import java.io.Serializable;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;

public class OrdenForm implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public void validateSeleccionarLibro(ValidationContext context) {
		MessageContext messages = context.getMessageContext();
		if (cantidad <= 0) {
			messages.addMessage(new MessageBuilder().error()
					.source("cantidad")
					.defaultText("La cantidad debe ser mayor que 0").build());
		}
	}

}
