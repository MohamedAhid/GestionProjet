package org.sidi.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.sidi.entities.Tache;

public interface TacheRepository 
extends JpaRepository<Tache, Long>{
	/*
	 * @Query("select c from Tache t where t.nom like :x") public Page<Tache>
	 * chercher(@Param("x") String mc,Pageable pageable);
	 */

}
