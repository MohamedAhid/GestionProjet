package org.sidi.entities;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
@Embeddable
public class Tache implements Serializable{
	
	 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private Long id;
   private String intitule;
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Projet_ID")
	
   private Projet projet;
	 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	    @JoinTable(name = "Tache_Compt",
     joinColumns = {
             @JoinColumn(name = "Tache_id", referencedColumnName = "id",
                     nullable = false, updatable = false)},
     inverseJoinColumns = {
             @JoinColumn(name = "Compt_id", referencedColumnName = "intituleCompt",
                     nullable = false, updatable = false)})
  private Set<Competence> competRequises = new HashSet <> ();
  
	
	  @Override public boolean equals(Object o) { if (this == o) return true; if
	  (!(o instanceof Tache)) return false; Tache that = (Tache) o; return
	  Objects.equals(getIntitule(), that.getIntitule()) &&
	  Objects.equals(getProjet(), that.getProjet()); }

   @Override
   public int hashCode() {
       return Objects.hash(getIntitule(),getProjet());
   }
    
	  @Temporal(TemporalType.DATE)
  private Date dateDebut;
	  @Temporal(TemporalType.DATE)
  private Date dateFin;
@ManyToMany(mappedBy = "taches", fetch = FetchType.LAZY)
  private Set<Collaborateur> collabos = new HashSet <  > () ;
public Tache() {
	super();
	// TODO Auto-generated constructor stub
}
public Set<Collaborateur> getCollabos() {
	return collabos;
}
public void setCollabos(Set<Collaborateur> collabos) {
	this.collabos = collabos;
}
public Tache(String intitule, Date dateDebut, Date dateFin, Projet projet) {
	super();
	this.intitule = intitule;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	this.projet = projet;
}
public Projet getProjet() {
	return projet;
}
public void setProjet(Projet projet) {
	this.projet = projet;
}
public String getIntitule() {
	return intitule;
}
public void setIntitule(String intitule) {
	this.intitule = intitule;
}
public Set<Competence> getCompetRequises() {
	return competRequises;
}
public void setCompetRequises(Set<Competence> competRequises) {
	this.competRequises = competRequises;
}
public Date getDateDebut() {
	return dateDebut;
}
public void setDateDebut(Date dateDebut) {
	this.dateDebut = dateDebut;
}
public Date getDateFin() {
	return dateFin;
}
public void setDateFin(Date dateFin) {
	this.dateFin = dateFin;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

}
