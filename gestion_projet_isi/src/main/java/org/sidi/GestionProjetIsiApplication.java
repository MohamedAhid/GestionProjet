package org.sidi;

import java.sql.Date;
import java.util.Arrays;

import org.sidi.dao.CollaborateurRepository;
import org.sidi.dao.CompetenceRepository;
import org.sidi.dao.ProjetRepository;
import org.sidi.dao.TacheRepository;
import org.sidi.entities.Collaborateur;
import org.sidi.entities.Competence;
import org.sidi.entities.Projet;
import org.sidi.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class GestionProjetIsiApplication implements CommandLineRunner  {
	
	  @Autowired private CollaborateurRepository collaborateurRepository;
	  
	  @Autowired private TacheRepository tacheRepository;
	  
	  @Autowired private ProjetRepository projetRepository;
	  
	  @Autowired private CompetenceRepository competenceRepository;
	 
	public static void main(String[] args) {
		SpringApplication.run(GestionProjetIsiApplication.class, args);
	}
	 /*@Bean
	    public CommandLineRunner mappingDemo(CollaborateurRepository collaborateurRepository,
					    		 TacheRepository tacheRepository, 
					    		 ProjetRepository projetRepository, 
					    		 CompetenceRepository competenceRepository ) {
	        return args -> {
*/
	
	  @Override public void run(String...arg0) throws Exception{ 
		  // create a Collaborateur
	  Collaborateur col1 = new Collaborateur("C01","Med", "Sidi");
	  Collaborateur col2 = new Collaborateur("C02","Issa", "Zekariya");
	  Collaborateur col3 = new Collaborateur("C03","Yousfi", "Merzough");
	  
	  // save the Collaborateur 
	  collaborateurRepository.saveAll(Arrays.asList(col1,
	  col2 , col3)); 
	  
	  
	  // create three Project
	  Projet pro1 = new Projet ("GestionBiblioth" , 120, new Date(12-02-2019), new Date(01-04-2019));
	  Projet pro2 = new Projet ("GestionCompte" , 12, new Date(03-01-2019), new Date(05-03-2019));
	  
	  // save Project 
	  projetRepository.saveAll(Arrays.asList(pro1, pro2));
	  
	  
	  // create Two Tache
	   Tache ta1 = new Tache("Gestion Utilisateur",new
	  Date(12-02-2019),new Date(12-02-2019), pro1); Tache ta2 = new
	  Tache("Gestion Secutité",new Date(12-02-2019),new Date(12-02-2019), pro1);
	  Tache ta3 = new Tache("Gestion Service",new Date(12-02-2019),new
	  Date(12-02-2019), pro1); Tache ta4 = new Tache("Gestion Utilisateur",new
	  Date(12-02-2019),new Date(12-02-2019), pro2); Tache ta5 = new
	  Tache("Gestion Secutité",new Date(12-02-2019),new Date(12-02-2019), pro2);
	  Tache ta6 = new Tache("Gestion Service",new Date(12-02-2019),new
	  Date(12-02-2019), pro2);
	  
	  // save tache 
	  tacheRepository.saveAll(Arrays.asList(ta1, ta2, ta3, ta4, ta5,
	  ta6));
	  
	  // create three Skills
	   Competence com1 = new Competence("Conception");
	  Competence com2 = new Competence("Web"); Competence com3 = new
	  Competence("Analyse");
	  
	  // save Skills
	   competenceRepository.saveAll(Arrays.asList(com1, com2, com3));
	  
	  
	  // add Tache to the collaborateur 
	  col1.getTaches().addAll(Arrays.asList(ta1,
	  ta2, ta3)); 
	  col2.getTaches().addAll(Arrays.asList(ta1, ta2, ta3));
	  col2.getTaches().addAll(Arrays.asList(ta1, ta2, ta3));
	  
	  // update the student 
	  collaborateurRepository.save(col1);
	  collaborateurRepository.save(col2);
	  collaborateurRepository.save(col3);
	  
	  // add Skills to the collaborateur
	  col1.getListeCompts().addAll(Arrays.asList(com1, com3));
	  col2.getListeCompts().addAll(Arrays.asList(com1, com2));
	  col2.getListeCompts().addAll(Arrays.asList(com2, com3));
	  
	  // update the Collaborateur 
	  collaborateurRepository.save(col1);
	  collaborateurRepository.save(col2);
	   collaborateurRepository.save(col3);
	  
	  // add Skills to the Taches
	  ta1.getCompetRequises().addAll(Arrays.asList(com1, com3));
	  ta2.getCompetRequises().addAll(Arrays.asList(com1, com2));
	  ta3.getCompetRequises().addAll(Arrays.asList(com2, com3));
	  ta4.getCompetRequises().addAll(Arrays.asList(com1, com3));
	  ta5.getCompetRequises().addAll(Arrays.asList(com1, com2));
	  ta6.getCompetRequises().addAll(Arrays.asList(com2, com3));
	  
	  // update the Taches 
	  tacheRepository.saveAll(Arrays.asList(ta1, ta2, ta3,ta4,
	  ta5, ta6));
	  
	  
	  
	  }
	 
}
