package org.sidi.web;


import java.util.List;

import javax.validation.Valid;

import org.sidi.dao.ProjetRepository;
import org.sidi.entities.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@Transactional 
@CrossOrigin(value="*")
@RestController
@RequestMapping("/")
public class ProjetRestService {
	
   
 
	@Autowired
	private ProjetRepository projetRepository;
	
	@GetMapping(value="/projets", produces ="application/json")
	   public List<Projet> getProjets(){ 
		 return  projetRepository.findAll(); }
	@GetMapping(value="/projets/{intitulePro}", produces ="application/json")
	   public Projet getProjet(@PathVariable String  intitulePro){
		  return projetRepository.findById(intitulePro).orElse(null); }
	  
		
		
		  @PostMapping(value="/projets/adduser")
		  public String addUProjet(@Valid Projet projet,BindingResult result, Model model) {
		  if (result.hasErrors()) { return "add-project"; }
		  projetRepository.save(projet); model.addAttribute("projets",
		  projetRepository.findAll()); return "index"; }
		  
		  @PutMapping(value="/projets/update/{intitulePro}")
		  public String updateProjet(@PathVariable("intitulePro")
		  String intitulePro, @Valid Projet projet, BindingResult result, Model model) {
			  if (result.hasErrors()) { projet.setIntitulePro(intitulePro); return
				  "update-projet"; } projetRepository.save(projet);
				  model.addAttribute("projets", projetRepository.findAll()); return "index"; }
				  
		  @DeleteMapping(value="/projets/delete/{intitulePro}") 
		  public String deleteProjet(@PathVariable("intitulePro") String
		  intitulePro, Model model) { Projet projet =
		  projetRepository.findById(intitulePro).orElseThrow(()-> new
		  IllegalArgumentException("Invalid projet Id:" + intitulePro));
		  projetRepository.delete(projet);
		  model.addAttribute("projets",projetRepository.findAll()); return "index"; }
		  
		 
	/*
	 * @GetMapping(value="/",produces ="application/json") public List<Projet>
	 * getProjets(){ return projetRepository.findAll(); }
	 * 
	 * @GetMapping(value="/{intitulePro}",produces ="application/json") public
	 * Projet getProjet(@PathVariable String intitulePro){ return
	 * projetRepository.findById(intitulePro).orElse(null); }
	 */
		
		  @GetMapping(value="/projets/chercherprojets")
		  public Page<Projet> chercher(
		  
		  @RequestParam(name="mc", defaultValue="") String mc,
		  
		  @RequestParam(name="page", defaultValue="0") int page,
		  
		  @RequestParam(name="size", defaultValue="5") int size){ return
		  projetRepository.chercher("%"+mc+"%", PageRequest.of(0, 5, Sort.by(
		  Order.desc("intitulePro")))); }
		 
		
		 
	  


	  
	    
}
