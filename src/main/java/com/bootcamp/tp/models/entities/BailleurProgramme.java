package com.bootcamp.tp.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

@Entity
@Table(name="tp_bailleur_programme")
public class BailleurProgramme extends BaseEntite implements Serializable	 {

	@ManyToOne
	@JoinColumn(name="BAILLEUR_ID", referencedColumnName="id")
	private Bailleur bailleur;
	
	@ManyToOne
	@JoinColumn(name="PROGRAMME_ID", referencedColumnName="id")
	private Programme programme;
}
