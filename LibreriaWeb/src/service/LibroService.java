package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Libro;

@Service
public class LibroService implements ILibroService {
	@Autowired
	private ICategoriaService categoriaService;
	public List<Libro> libros;

	@PostConstruct
	public void init() {
		libros = new ArrayList<Libro>();
		libros.add(new Libro(1L, "Libro #1", 200f, categoriaService.getCategoria(1L)));
		libros.add(new Libro(2L, "Libro #2", 300f, categoriaService.getCategoria(1L)));
		libros.add(new Libro(3L, "Libro #3", 150f, categoriaService.getCategoria(2L)));
		libros.add(new Libro(4L, "Libro #4", 400f, categoriaService.getCategoria(3L)));
	}
	
	@Override
	public List<Libro> getLibrosByCategoria(Long categoriaId) {
		List<Libro> librosByCategoria = null;
		
		for (Libro l : libros) {
			if (l.getCategoria().getId().equals(categoriaId)) {
				if (librosByCategoria == null)
					librosByCategoria = new ArrayList<Libro>();
				
				librosByCategoria.add(l);
			}
		}
		
		return librosByCategoria;
	}

	@Override
	public Libro getLibro(Long id) {
		for (Libro l : libros) {
			if (l.getId().equals(id)) {
				return l;
			}
		}
		return null;
	}
	
}


