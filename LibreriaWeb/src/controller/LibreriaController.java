package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Categoria;
import model.Libro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ICategoriaService;
import service.ILibroService;
import to.LibroTo;
import form.OrdenForm;

@Controller
public class LibreriaController {
	@Autowired
	private ICategoriaService categoriaService;
	@Autowired
	private ILibroService libroService;
	
	@ModelAttribute
	public OrdenForm ordenForm() {
		OrdenForm ordenForm = new OrdenForm();
		ordenForm.setCategoria(0L);
		ordenForm.setLibro(0L);
		ordenForm.setCantidad(0);
		return ordenForm;
	}
	
	@RequestMapping("/catalogo")
	public String catalogo(@ModelAttribute("ordenForm") OrdenForm ordenForm,
			Model model) {
		// Cargando categorías
		List<Categoria> categorias = categoriaService.getCategorias();
		model.addAttribute("categorias", categorias);

		// Cargando libros por categorías
		List<Libro> libros = libroService.getLibrosByCategoria(ordenForm.getCategoria());
		model.addAttribute("libros", libros);
		
		return "catalogo.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/agregar")
	public String agregar(@ModelAttribute("ordenForm") OrdenForm ordenForm,
			HttpSession sesion) {

		List<LibroTo> ordenLibros = (List<LibroTo>) sesion.getAttribute("ordenLibros");
		if (ordenLibros == null) {
			ordenLibros = new ArrayList<LibroTo>();
			sesion.setAttribute("ordenLibros", ordenLibros);
		}
		
		agregarOrdenLibro(ordenForm, ordenLibros);
		
		return "redirect:catalogo.lib";
	}
	
	@RequestMapping("/comprar")
	public String comprar(HttpSession sesion) {
		sesion.invalidate(); // Eliminando la sesión
		
		return "comprar.jsp";
	}
	
	public boolean agregarOrdenLibro(OrdenForm ordenForm, List<LibroTo> ordenLibros) {
		// TODO: Incluir validaciones!
		Libro libro = libroService.getLibro(ordenForm.getLibro());
		
		LibroTo libroTo = new LibroTo();
		libroTo.setNombre(libro.getNombre());
		libroTo.setPrecio(libro.getPrecio());
		libroTo.setCantidad(ordenForm.getCantidad()); // FIXME: Qué pasa cuando el libro ya había sido agregado?
		ordenLibros.add(libroTo);
		
		return true; // TODO: Agregar otros tipos de retorno si accede a datos
	}
}












