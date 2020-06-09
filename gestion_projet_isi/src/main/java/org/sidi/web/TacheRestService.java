package org.sidi.web;

import java.util.List;
import java.util.Optional;

import org.sidi.dao.TacheRepository;
import org.sidi.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class TacheRestService {
	@Autowired 
	private TacheRepository tacheRepository;
	  
	
		@RequestMapping(value="/taches", method=RequestMethod.GET) 
		public List<Tache> getTaches(){ 
			   return tacheRepository.findAll();
			   }
		  
	  @RequestMapping(value="/taches/{id}", method=RequestMethod.GET)
	  public Tache getTache(@PathVariable Long id){ 
		  return tacheRepository.findById(id).orElse(null); 
		  }
	 
			/*
			 * @RequestMapping(value="/cherchertaches", method=RequestMethod.GET) public
			 * Page<Tache> chercher(
			 * 
			 * @RequestParam(name="mt", defaultValue="") String mt,
			 * 
			 * @RequestParam(name="page", defaultValue="0") int page,
			 * 
			 * @RequestParam(name="size", defaultValue="5") int size){ return
			 * tacheRepository.chercher(mc, pageable) }
			 */
	  @RequestMapping(value="/taches", method=RequestMethod.POST)
	  public Tache save(@RequestBody Tache t){ 
		  return tacheRepository.save(t); 
		  }
	  
	  @RequestMapping(value="/taches/{id}", method=RequestMethod.DELETE)
	  public boolean supprimer(@PathVariable Long id){ 
		  tacheRepository.deleteById(id);;
		  return true;
			   }
	  
	  @RequestMapping(value="/taches/{id}", method=RequestMethod.PUT)
	  public Tache save(@PathVariable Long id, @RequestBody Tache t){ 
		  t.setId(id);
		  return tacheRepository.save(t); 
		  }
	  
	  
}
