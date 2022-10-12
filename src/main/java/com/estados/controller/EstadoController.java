package com.estados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estados.dto.EstadoDTO;
import com.estados.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public ResponseEntity<Page<EstadoDTO>> buscarTudo(@RequestParam(defaultValue = "0") int page){
		Page<EstadoDTO> estados = estadoService.buscarTudo(page);
		return ResponseEntity.ok().body(estados);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<EstadoDTO> buscarId(@PathVariable Long id){
		EstadoDTO estado = estadoService.buscarId(id);
		return ResponseEntity.ok().body(estado);
	}
	
	@GetMapping("/uf/{uf}")
	public ResponseEntity<EstadoDTO> buscarUF(@PathVariable String uf){
		EstadoDTO estado = estadoService.buscarUF(uf);
		return ResponseEntity.ok().body(estado);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<EstadoDTO>> buscarNome(@PathVariable String nome, 
			@RequestParam(defaultValue = "0") int page){
		Page<EstadoDTO> estados = estadoService.buscarNome(nome, page);
		return ResponseEntity.ok().body(estados);
	}
	
	@GetMapping("/capital/{capital}")
	public ResponseEntity<Page<EstadoDTO>> buscarCapital(@PathVariable String capital, 
			@RequestParam(defaultValue = "0") int page){
		Page<EstadoDTO> estados = estadoService.buscarCapital(capital, page);
		return ResponseEntity.ok().body(estados);
	}
	
	@GetMapping({"/pib", "/PIB"})
	public ResponseEntity<Page<EstadoDTO>> ordenarPib(@RequestParam(defaultValue = "maior") String order, 
			@RequestParam(defaultValue = "0") int page){
		Page<EstadoDTO> estados = estadoService.ordenarPib(order, page);
		return ResponseEntity.ok().body(estados);
	}
	
	@GetMapping("/populacao")
	public ResponseEntity<Page<EstadoDTO>> ordenarPopulacao(@RequestParam(defaultValue = "maior") String order, 
			@RequestParam(defaultValue = "0") int numPage){
		Page<EstadoDTO> estados = estadoService.ordenarPopulacao(order, numPage);
		return ResponseEntity.ok().body(estados);
	}
 }
