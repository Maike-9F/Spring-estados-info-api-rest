package com.estados.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.estados.dto.EstadoDTO;
import com.estados.entities.Estado;
import com.estados.repository.EstadoRepository;
import com.estados.service.exceptions.NotFoundException;
import com.estados.service.exceptions.ParamInvalidException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Page<EstadoDTO> buscarTudo(int numPage){
		PageRequest page = PageRequest.of(numPage, 7);
		Page<Estado> estados = estadoRepository.findAll(page);
		Page<EstadoDTO> estadosDTO = estados.map((x) -> new EstadoDTO(x));
		return estadosDTO;
	}
	
	public EstadoDTO buscarId(Long id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		return new EstadoDTO(estado.orElseThrow(() -> new NotFoundException("Não foi encontrado Estado com o ID "+id)));
	}
	
	public EstadoDTO buscarUF(String uf) {
		Optional<Estado> estado = estadoRepository.findByUfIgnoringCase(uf);
		return new EstadoDTO(estado.orElseThrow(() -> new NotFoundException("Não foi encontrado Estado com o UF "+uf)));	
	}
	
	public Page<EstadoDTO> buscarNome(String texto, int numPage){
		Pageable page = PageRequest.of(numPage, 7);
		Page<Estado> estados = estadoRepository.findByNomeIgnoringCaseLike("%"+texto+"%", page);
		
		if(estados.isEmpty()) {
			throw new NotFoundException("Não foram encontrados Estados com o nome "+texto);
		}
		
		Page<EstadoDTO> estadosDTO = estados.map((x) -> new EstadoDTO(x));
		return estadosDTO;
	}
	
	public Page<EstadoDTO> buscarCapital(String texto, int numPage) {
		Pageable page = PageRequest.of(numPage, 7);
		Page<Estado> estados = estadoRepository.findByCapitalIgnoringCaseLike("%"+texto+"%", page);
		
		if(estados.isEmpty()) {
			throw new NotFoundException("Não foram encontrados Estados com a Capital "+texto);
		}
		
		Page<EstadoDTO> estadosDTO = estados.map((x) -> new EstadoDTO(x));
		return estadosDTO;
	}
	
	public Page<EstadoDTO> ordenarPib(String order, int numPage){
		Sort sort;
		
		if(order.equals("maior")) {
			sort = Sort.by(Sort.Direction.DESC, "pib");
			
		} else if(order.equals("menor")) {
			sort = Sort.by(Sort.Direction.ASC, "pib");
			
		} else {
			throw new ParamInvalidException("Parametro invalido");
		}
		
		Pageable page = PageRequest.of(numPage, 7, sort);
		Page<Estado> estados = estadoRepository.findAll(page);
		
		Page<EstadoDTO> estadosDTO = estados.map((x) -> new EstadoDTO(x));
		return estadosDTO;
	}
	
	public Page<EstadoDTO> ordenarPopulacao(String order, int numPage){
		Sort sort;
		
		if(order.equals("maior")) {
			sort = Sort.by(Sort.Direction.DESC, "populacao");
		} else if(order.equals("menor")) {
			sort = Sort.by(Sort.Direction.ASC, "populacao");
		} else {
			throw new ParamInvalidException("Parametro invalido");
		}
		
		Pageable page = PageRequest.of(numPage, 7, sort);
		Page<Estado> estados = estadoRepository.findAll(page);
		
		Page<EstadoDTO> estadosDTO = estados.map((x) -> new EstadoDTO(x));
		return estadosDTO;
	}
	
}