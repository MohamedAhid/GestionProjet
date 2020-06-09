package org.sidi.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sidi.entities.Projet;

public interface ProjetRepository 
extends JpaRepository<Projet, String>{

	
	
	  @Query("select p from Projet p where p.intitulePro like :x") public
	  Page<Projet> chercher(@Param("x") String mc,Pageable pageable);
	 
}
