package br.com.rouf.project.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Dog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCachorro;
	
	@Column(nullable = false)
	@NotEmpty(message = "Nome é obrigatório.")
	private String nomeCachorro;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	@NotNull(message = "Data de adoção é obrigatória.")
	private Date dataAdocao;
	
	//@NumberFormat(pattern = "#,##0.00")
	//private BigDecimal valor;
	
	@Column
	private Integer idadeDog;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@NotNull(message = "Raça é obrigatória.")
	private DomRaca raca;
	
	@Override
	public String toString() {
		return "[Nome cachorro::" + nomeCachorro + "::data de adoção::" + dataAdocao;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(idCachorro);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Dog) {
			Dog outroDog = (Dog) obj;
	
			return Objects.equals(idCachorro, outroDog.idCachorro);
		} else {
			return false;
		}
	}

	/* Getters & Setters */
	public Integer getIdCachorro() {
		return idCachorro;
	}

	public void setIdCachorro(Integer idCachorro) {
		this.idCachorro = idCachorro;
	}

	public String getNomeCachorro() {
		return nomeCachorro;
	}

	public void setNomeCachorro(String nomeCachorro) {
		this.nomeCachorro = nomeCachorro;
	}

	public Date getDataAdocao() {
		return dataAdocao;
	}

	public void setDataAdocao(Date dataAdocao) {
		this.dataAdocao = dataAdocao;
	}

	public Integer getIdadeDog() {
		return idadeDog;
	}

	public void setIdadeDog(Integer idadeDog) {
		this.idadeDog = idadeDog;
	}

	public DomRaca getRaca() {
		return raca;
	}

	public void setRaca(DomRaca raca) {
		this.raca = raca;
	}

}
