package com.examenTendencias.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenTendencias.entity.Empleado;
import com.examenTendencias.service.EmpleadoService;


@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	
	
	@Autowired
	private EmpleadoService empleadoService;
	
	//Crear POST
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody Empleado empleado){
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado));
	}
	

	//Editar PUT
	@PutMapping("/editar/{id_empleado}")
	public ResponseEntity<?> update(@RequestBody Empleado empleadoDetails, @PathVariable Long id_empleado){
		Optional<Empleado> empleado = empleadoService.findById(id_empleado);
		
		if(!empleado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		empleado.get().setNombre(empleadoDetails.getNombre());
		empleado.get().setApellido(empleadoDetails.getApellido());
		empleado.get().setTelefono(empleadoDetails.getTelefono());
		empleado.get().setDireccion(empleadoDetails.getDireccion());
		empleado.get().setObservacion(empleadoDetails.getObservacion());
		empleado.get().setDias_trabajo(empleadoDetails.getDias_trabajo());
		empleado.get().setSueldo(empleadoDetails.getSueldo());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleado.get()));
	}
	
	
	//Eliminar DELETE
	@DeleteMapping("/eliminar/{id_empleado}")
	public ResponseEntity<?> delete(@PathVariable Long id_empleado){
		
		if(!empleadoService.findById(id_empleado).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		empleadoService.deleteById(id_empleado);
		return ResponseEntity.ok().build();
	}
	
	//Leer  GET
	@GetMapping("/list")
	public List<Empleado> readAll(){
		
		List<Empleado> users = StreamSupport
				.stream(empleadoService.findAll().spliterator(), false).collect(Collectors.toList());
		
		return users;
	}
}
