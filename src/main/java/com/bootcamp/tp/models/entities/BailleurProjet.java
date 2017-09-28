package com.bootcamp.tp.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

@Entity
@Table(name = "tp_bailleur_projet")
public class BailleurProjet extends BaseEntite implements Serializable {

	@ManyToOne
	@JoinColumn(name="BAILLEUR_ID", referencedColumnName="id")
	private Bailleur bailleur;
	@ManyToOne
	@JoinColumn(name="PROJET_ID", referencedColumnName="id")
	private Projet projet;
	public Bailleur getBailleur() {
		return bailleur;
	}
	public void setBailleur(Bailleur bailleur) {
		this.bailleur = bailleur;
	}
	public Projet getProjet() {
		return projet;
	}
	public void setProjet(Projet projet) {
		this.projet = projet;
	}
	
	
}
