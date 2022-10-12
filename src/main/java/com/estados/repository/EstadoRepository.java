package com.estados.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.estados.entities.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	public Optional<Estado> findByUfIgnoringCase(String uf);
	
	public Page<Estado> findByNomeIgnoringCaseLike(String nome, Pageable page);
	
	public Page<Estado> findByCapitalIgnoringCaseLike(String texto, Pageable page);
	
}
