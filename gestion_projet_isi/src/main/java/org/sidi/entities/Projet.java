package org.sidi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Projet implements Serializable{
   @Id
  private String intitulePro;
   @Temporal(TemporalType.DATE)
  private Date dateDebut;
   @Temporal(TemporalType.DATE)
  private Date dateFin; 
  private Integer VHT;
    @OneToMany(mappedBy="projet",fetch=FetchType.LAZY)
  private Set<Tache> taches;
  public String getIntitulePro() {
	return intitulePro;
}
public void setIntitulePro(String intitulePro) {
	this.intitulePro = intitulePro;
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
public Integer getVolumeHoraire() {
	return VHT;
}
public void setVolumeHoraire(Integer volumeHoraire) {
	this.VHT = volumeHoraire;
}
public Set<Tache> getTaches() {
	return taches;
}
public void setTaches(Set<Tache> taches) {
	this.taches = taches;
}
public Projet(String intitulePro,Integer volumeHoraire, Date dateDebut, Date dateFin) {
	super();
	this.intitulePro = intitulePro;
	this.VHT = volumeHoraire;
	this.dateDebut = dateDebut;
	this.dateFin = dateFin;
	 
}
public Projet() {
	super();
	// TODO Auto-generated constructor stub
}


  
}
