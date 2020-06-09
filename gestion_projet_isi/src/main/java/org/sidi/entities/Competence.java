package org.sidi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity 
public class Competence implements Serializable {
  @Id
 private String intituleCompt;
  @ManyToMany(mappedBy = "competRequises", fetch = FetchType.LAZY)
 private Set<Tache> taches = new HashSet <> ()  ;
  @ManyToMany(mappedBy = "listeCompts", fetch = FetchType.LAZY)
 private Set<Collaborateur> collabos = new HashSet <> () ;
public String getIntituleCompt() {
	return intituleCompt;
}
public void setIntituleCompt(String intituleCompt) {
	this.intituleCompt = intituleCompt;
}
public Set<Tache> getTaches() {
	return taches;
}
public void setTaches(Set<Tache> taches) {
	this.taches = taches;
}
public Set<Collaborateur> getCollabos() {
	return collabos;
}
public void setCollabos(Set<Collaborateur> collabos) {
	this.collabos = collabos;
}
public Competence(String intituleCompt) {
	super();
	this.intituleCompt = intituleCompt;
}
public Competence() {
	super();
	// TODO Auto-generated constructor stub
}

}
