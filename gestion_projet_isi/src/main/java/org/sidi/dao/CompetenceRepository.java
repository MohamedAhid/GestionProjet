package org.sidi.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.sidi.entities.Competence;

public interface CompetenceRepository 
extends JpaRepository<Competence, String> {


}
