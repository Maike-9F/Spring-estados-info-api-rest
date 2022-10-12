package com.estados.dto;

import java.io.Serializable;

import com.estados.entities.Estado;

public class EstadoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String capital;
	private String uf;
	private String governador;
	private Long pib;
	private Long populacao;
	
	public EstadoDTO() {
	}

	public EstadoDTO(Long id, String nome, String capital, String uf, String governador, Long pib, Long populacao) {
		this.id = id;
		this.nome = nome;
		this.capital = capital;
		this.uf = uf;
		this.governador = governador;
		this.pib = pib;
		this.populacao = populacao;
	}
	
	public EstadoDTO(Estado estado) {
		this(estado.getId(), estado.getNome(), estado.getCapital(), estado.getUf(), estado.getGovernador(), 
				estado.getPib(), estado.getPopulacao());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getGovernador() {
		return governador;
	}

	public void setGovernador(String governador) {
		this.governador = governador;
	}

	public Long getPib() {
		return pib;
	}

	public void setPib(Long pib) {
		this.pib = pib;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}
	
	
}
