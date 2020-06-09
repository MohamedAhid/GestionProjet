package org.sidi.entities;
import javax.persistence.JoinColumn;
import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Collaborateur implements Serializable{
	@Id
	 private String codeCallab;
	 private String nom;
	 private String prenom;
	    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	    @JoinTable(name = "Collabo_Tache",
        joinColumns = {
                @JoinColumn(name = "Collabo_id", referencedColumnName = "codeCallab",
                        nullable = false, updatable = false)},
        inverseJoinColumns = {
                @JoinColumn(name = "Tache_id", referencedColumnName = "id",
                        nullable = false, updatable = false)})
     	     
	private  Set<Tache> taches = new HashSet <> () ;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Collabo_Compt",
    joinColumns = {
            @JoinColumn(name = "Collabo_id", referencedColumnName = "codeCallab",
                    nullable = false, updatable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "Compt_id", referencedColumnName = "intituleCompt",
                    nullable = false, updatable = false)})	     
	 private Set<Competence> listeCompts = new HashSet <> () ;
	
	public Set<Tache> getTaches() {
		return taches;
	}
	
	 public Collaborateur(String codeCallab,String nom, String prenom) {
			super();
			this.codeCallab=codeCallab;
			this.nom = nom;
			this.prenom = prenom;
		}
	public void setTaches(Set<Tache> taches) {
		this.taches = taches;
	}

	/*
	 * public Collaborateur( String nom, String prenom, Set<Tache> taches,
	 * List<Competence> listeCompts) { super(); this.nom = nom; this.prenom =
	 * prenom; this.taches = taches; this.listeCompts = listeCompts; }
	 */
	public String getCodeCallab() {
		return codeCallab;
	}
	public void setCodeCallab(String codeCallab) {
		this.codeCallab = codeCallab;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Set<Competence> getListeCompts() {
		return listeCompts;
	}
	public void setListeCompts(Set<Competence> listeCompts) {
		this.listeCompts = listeCompts;
	}
	 
	public Collaborateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public Collaborateur(String nom, String prenom) { super(); this.nom = nom;
	 * this.prenom = prenom; }
	 */
} 
 