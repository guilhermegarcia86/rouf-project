package br.com.rouf.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rouf.project.model.Dog;
import br.com.rouf.project.repository.Dogs;
import br.com.rouf.project.repository.filter.DogFilter;

/**
 * Serviço contendo métodos para dog 
 * 
 * @author Guilherme
 *
 */
@Service
public class DogService {
	
	@Autowired
	private Dogs dogs;
	
	public void salvar(Dog dog){
		dogs.save(dog);
	}
	
	public List<Dog> listarTodos(){
		return dogs.findAll();
	}
	
	public void excluir(Integer id){
		dogs.delete(id);
	}
	
	public List<Dog> filtrarPorNome(DogFilter filtro) {
		String descricao = filtro.getNomeCachorro() == null ? "%" : filtro.getNomeCachorro();
		
		return dogs.findByNomeCachorroContaining(descricao);
	}

}
