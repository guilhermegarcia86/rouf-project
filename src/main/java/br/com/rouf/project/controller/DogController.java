package br.com.rouf.project.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.rouf.project.model.Dog;
import br.com.rouf.project.model.DomRaca;
import br.com.rouf.project.repository.filter.DogFilter;
import br.com.rouf.project.service.DogService;

//Controller da página cadastroDeDog.html
@Controller
@RequestMapping("/dogs")
public class DogController {
	
	private static final String CADASTRO_VIEW = "cadastroDeDog";

	/* Injeção de dependência */
	@Autowired
	private DogService dogService;

	@RequestMapping("/novo")
	public ModelAndView novoTitulo() {
		return new ModelAndView(CADASTRO_VIEW).addObject(new Dog());
	}

	/**
	 * Método para salvar na entidade Dog
	 * 
	 * @param dog
	 * 		objeto que será persistido
	 * @return
	 * 		retorna um {@link ModelAndView modelandView}
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Dog dog, Errors erros, RedirectAttributes attributes) {		
		if(erros.hasErrors()){
			return CADASTRO_VIEW;
		}		
		
		dogService.salvar(dog);
		attributes.addFlashAttribute("mensagem", "Dog salvo com sucesso!");

		return "redirect:/dogs/novo";
	}
	
	/**
	 * Lista todos os {@link Dog dogs}
	 * 
	 * @return
	 * 	retorna um {@link ModelAndView modelandView} contendo a lista de {@link Dog dogs}
	 */
	@RequestMapping
	public ModelAndView listarTodos(@ModelAttribute("filtro") DogFilter filtro){
		List<Dog> listaDeDogs = dogService.filtrarPorNome(filtro);
		
		return new ModelAndView("pesquisaDog").addObject("dogs", listaDeDogs);
	}
	
	@RequestMapping("{idCachorro}")
	public ModelAndView atualizar(@PathVariable("idCachorro") Dog dog){
		ModelAndView modelAndView = new ModelAndView(CADASTRO_VIEW);
		modelAndView.addObject(dog);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "{idCachorro}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Integer idCachorro, RedirectAttributes attributes){
		dogService.excluir(idCachorro);
		attributes.addFlashAttribute("mensagem", "Dog excluído com sucesso!");
		
		return "redirect:/dogs";
	}
	
	@ModelAttribute("listaEnumDog")
	public List<DomRaca> listaDeRacas(){
		return Arrays.asList(DomRaca.values());
	}

}