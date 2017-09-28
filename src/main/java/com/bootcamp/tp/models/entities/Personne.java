package com.bootcamp.tp.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="CATEGORIE_PERSONNE")
@DiscriminatorValue("PERSONNE")
@Table(name="tp_personne")
public class Personne extends BaseEntite implements Serializable{

	private static final long serialVersionUID = 1L;
   
    @Column(length = 45, nullable = false)
    private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}	
    
    
    
    
}
