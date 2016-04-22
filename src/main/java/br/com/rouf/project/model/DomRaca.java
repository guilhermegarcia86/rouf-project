package br.com.rouf.project.model;

public enum DomRaca {
	
	PEDIGREE("Pedigree"),
	VIRALATA("Vira-Lata");
	
	private String raca;
	
	DomRaca(String raca){
		this.raca = raca;
	}

	public String getDescricao() {
		return raca;
	}
}
