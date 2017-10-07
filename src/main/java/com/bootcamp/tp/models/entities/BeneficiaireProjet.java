package com.bootcamp.tp.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

@Entity
@Table(name="tp_beneficiaire_projet")
public class BeneficiaireProjet extends BaseEntite implements Serializable{
	@ManyToOne
	@JoinColumn(name = "BENEFICIAIRE_ID", referencedColumnName = "id")
	private Beneficiaire beneficiaireprojet;
	
	@ManyToOne
	@JoinColumn(name = "PROJET_ID", referencedColumnName = "id")
	private Projet projetdubeneficiaire;

	public Beneficiaire getBeneficiaireprojet() {
		return beneficiaireprojet;
	}

	public void setBeneficiaireprojet(Beneficiaire beneficiaire) {
		this.beneficiaireprojet = beneficiaire;
	}

	public Projet getProjetdubeneficiaire() {
		return projetdubeneficiaire;
	}

	public void setProjetdubeneficiaire(Projet projet) {
		this.projetdubeneficiaire = projet;
	}

}
