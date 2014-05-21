package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import model.Categoria;

@Service
public class CategoriaService implements ICategoriaService {
	private List<Categoria> categorias;

	@PostConstruct
	public void init() {
		categorias = new ArrayList<Categoria>();
		categorias.add(new Categoria(0L, "Seleccione una categoría"));		
		categorias.add(new Categoria(1L, "Accion"));
		categorias.add(new Categoria(2L, "Drama"));
		categorias.add(new Categoria(3L, "Comics"));
	}
	
	@Override
	public List<Categoria> getCategorias() {
		return categorias;
	}

	@Override
	public Categoria getCategoria(Long id) {
		for (Categoria c : categorias) {
			if (c.getId().equals(id))
				return c;
		}
		return null;
	}

}
