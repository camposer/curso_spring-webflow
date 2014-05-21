package controller;

import java.util.List;

import model.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.ICategoriaService;
import form.OrdenForm;

@Controller
public class LibreriaController {
	@Autowired
	private ICategoriaService categoriaService;
	
	@ModelAttribute
	public OrdenForm ordenForm() {
		OrdenForm ordenForm = new OrdenForm();
		ordenForm.setCategoria(0L);
		ordenForm.setLibro(0L);
		ordenForm.setCantidad(0);
		return ordenForm;
	}
	
	@RequestMapping("/catalogo")
	public String catalogo(Model model) {
		List<Categoria> categorias = categoriaService.getCategorias();
		categorias.add(0, new Categoria(0L, "Seleccione una categoría"));
		model.addAttribute("categorias", categorias);
		
		return "catalogo.jsp";
	}
	
	@RequestMapping("/agregar")
	public String agregar(@ModelAttribute("ordenForm") OrdenForm ordenForm) {
		System.out.println(ordenForm);
		
		return "catalogo.lib";
	}
	
}





