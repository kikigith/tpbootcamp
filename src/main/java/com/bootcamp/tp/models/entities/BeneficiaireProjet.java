package com.bootcamp.tp.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

@Entity
@Table(name = "tp_beneficiaire_projet")
public class BeneficiaireProjet extends BaseEntite implements Serializable{
	@ManyToOne
	@JoinColumn(name = "BENEFICIAIRE_ID", referencedColumnName = "id")
	private Beneficiaire beneficiaire;
	@ManyToOne
	@JoinColumn(name = "PROJET_ID", referencedColumnName = "id")
	private Projet projet;

	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

}
