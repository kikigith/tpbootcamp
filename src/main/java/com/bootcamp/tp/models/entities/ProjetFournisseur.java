package com.bootcamp.tp.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

@Entity
@Table(name="tp_projet_fournisseur")
public class ProjetFournisseur  extends BaseEntite implements Serializable{
	
	@ManyToOne 
	@JoinColumn(name ="PROJET_ID", referencedColumnName="id")
	private Projet projet;
	@ManyToOne 
	@JoinColumn(name ="FOURNISSEUR_ID", referencedColumnName="id")
	private Fournisseur fournisseur;
	
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	

}
