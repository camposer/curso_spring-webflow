package service;

import java.util.List;

import model.Libro;

public interface ILibroService {
	public List<Libro> getLibrosByCategoria(Long categoriaId);
	public Libro getLibro(Long id);
}
