package com.learn.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.cursomc.domain.Cidade;
import com.learn.cursomc.domain.Cliente;
import com.learn.cursomc.domain.Endereco;
import com.learn.cursomc.domain.enums.TipoCliente;
import com.learn.cursomc.dto.ClienteDTO;
import com.learn.cursomc.dto.ClienteNewDTO;
import com.learn.cursomc.repositories.ClienteRepository;
import com.learn.cursomc.repositories.EnderecoRepository;
import com.learn.cursomc.services.exceptions.DataIntegrityException;
import com.learn.cursomc.services.exceptions.ObjectNotFoundException;
import com.learn.cursomc.utils.Util;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository cli;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Cliente find(Integer id_busca) throws ObjectNotFoundException {
		Optional<Cliente> cat = cli.findById(id_busca);
		// este sem tratamento -> return cat.orElse(null);
		// OR
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id_busca + ", Tipo: " + Cliente.class.getName()));
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = cli.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return cli.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		
		try {
			cli.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new DataIntegrityException("Não é possível excluir o cliente porque há pedidos relacionados.");
		}
	}
	
	public List<Cliente> findAll() {
		return cli.findAll();
	}
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cli.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail());
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (Util.isValidString(objDto.getTelefone2())) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (Util.isValidString(objDto.getTelefone3())) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}