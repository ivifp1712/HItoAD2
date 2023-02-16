package com.example.hitoprueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
	@Autowired
	private TareaRepository repo;
	
	public List<Tarea> listAll() {
		return repo.findAll();
	}
	
	public void save(Tarea product) {
		repo.save(product);
	}
	
	public Tarea get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
