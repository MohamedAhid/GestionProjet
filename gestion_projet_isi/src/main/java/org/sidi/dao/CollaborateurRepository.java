package org.sidi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sidi.entities.Collaborateur;

public interface CollaborateurRepository 
extends JpaRepository<Collaborateur, String>  {
	
}
