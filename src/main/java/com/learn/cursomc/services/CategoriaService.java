package com.learn.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.learn.cursomc.domain.Categoria;
import com.learn.cursomc.repositories.CategoriaRepository;
import com.learn.cursomc.services.exceptions.DataIntegrityException;
import com.learn.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository cr;
	
	public Categoria find(Integer id_busca) throws ObjectNotFoundException {
		Optional<Categoria> cat = cr.findById(id_busca);
//		este sem tratamento -> return cat.orElse(null);
		// OR 
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id_busca + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return cr.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return cr.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
			cr.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new DataIntegrityException("Não é posível excluir uma categoria que possui produtos.");
		}
	}
	
	public List<Categoria> findAll() {
		return cr.findAll();
	}
}