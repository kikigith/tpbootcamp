package com.bootcamp.tp.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

@Entity
@Table(name="tp_programme_fournisseur")
public class ProgrammeFournisseur extends BaseEntite implements Serializable{
	@ManyToOne
	@JoinColumn(name="PROGRAMME_ID", referencedColumnName="id")
	private Programme programme;
	@ManyToOne
	@JoinColumn(name="FOURNISSEUR_ID", referencedColumnName="id")
	private Fournisseur fournisseur;
	
	public Programme getProgramme() {
		return programme;
	}
	public void setProgramme(Programme programme) {
		this.programme = programme;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	

}
