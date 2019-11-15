package com.learn.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.cursomc.domain.Pedido;
import com.learn.cursomc.repositories.PedidoRepository;
import com.learn.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository cr;
	
	public Pedido find(Integer id_busca) throws ObjectNotFoundException {
		Optional<Pedido> cat = cr.findById(id_busca);
//		este sem tratamento -> return cat.orElse(null);
		// OR 
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id_busca + ", Tipo: " + Pedido.class.getName()));
	}
}