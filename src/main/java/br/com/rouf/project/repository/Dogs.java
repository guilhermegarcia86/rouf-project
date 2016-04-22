package br.com.rouf.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rouf.project.model.Dog;

public interface Dogs extends JpaRepository<Dog, Integer> {
	
	public List<Dog> findByNomeCachorroContaining(String descricao);

}
