
	package org.sidi.web;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RestController;

	import org.sidi.dao.CollaborateurRepository;
	import org.sidi.entities.Collaborateur;

	@RestController
	public class CollaborateurRestService {

	@Autowired
	private CollaborateurRepository controlleurRepository;

	CollaborateurRestService(CollaborateurRepository controlleurRepository) {
	  this.controlleurRepository = controlleurRepository;
	}

	// Aggregate root

	@GetMapping("/employees")
	List<Collaborateur> all() {
	  return controlleurRepository.findAll();
	}

	@PostMapping("/employees")
	Collaborateur newEmployee(@RequestBody Collaborateur newEmployee) {
	  return controlleurRepository.save(newEmployee);
	}

	// Single item
	/*
	 * @GetMapping("/employees/{id}") Collaborateur one(@PathVariable String
	 * codeCallab) {
	 * 
	 * return controlleurRepository.findById(codeCallab) .orElseThrow(() -> new
	 * CollaborateurNotFoundException(codeCallab)); }
	 * 
	 * @PutMapping("/employees/{codeCallab}") Collaborateur
	 * replaceEmployee(@RequestBody Collaborateur newEmployee, @PathVariable String
	 * codeCallab) {
	 * 
	 * return controlleurRepository.findById(codeCallab) .map(collabo -> {
	 * collabo.setName(new Collaborateur.getNom()); collabo.setRole(new
	 * Collaborateur.getRole()); return controlleurRepository.save(collabo); })
	 * .orElseGet(() -> { newEmployee.setId(codeCallab); return
	 * controlleurRepository.save(new Collaborateur); }); }
	 * 
	 * @DeleteMapping("/employees/{id}") void deleteCollaborateur(@PathVariable
	 * String collabo) { controlleurRepository.deleteById(collabo); }
	 */

	}



