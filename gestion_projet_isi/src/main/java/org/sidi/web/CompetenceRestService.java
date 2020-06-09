package org.sidi.web;
import java.util.List;

import org.sidi.dao.CompetenceRepository;
import org.sidi.entities.Competence;
import org.sidi.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/compets")
public class CompetenceRestService {
		  
	@Autowired
	private CompetenceRepository competencerepository;
	
	@RequestMapping(value="/compets", method=RequestMethod.GET) 
	public List<Competence> getCompetences(){ 
		   return competencerepository.findAll();
		   }
	  
	 @RequestMapping(value="/compets/{intituleCompt}", method=RequestMethod.GET)
	  public Competence getCompetences(@PathVariable String intituleCompt){ 
		      return competencerepository.findById(intituleCompt).orElse(null); 
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
			 * tacheRepository.chercher(mt, new PageRequest(page,size)); }
			 */
			 
	  @RequestMapping(value="/compets", method=RequestMethod.POST)
	  public Competence save(@RequestBody Competence C){ 
		  return competencerepository.save(C); 
		  }
	  
	  @RequestMapping(value="/taches/{intituleCompt}", method=RequestMethod.DELETE)
	  public boolean supprimer(@PathVariable String intituleCompt){ 
		  competencerepository.deleteById(intituleCompt);;
		  return true;
			   }
	  
	  @RequestMapping(value="/taches/{intituleCompt}", method=RequestMethod.PUT)
	  public Competence save(@PathVariable String intituleCompt, @RequestBody Competence C){ 
		  C.setIntituleCompt(intituleCompt);
		  return competencerepository.save(C); 
		  }
	
}
