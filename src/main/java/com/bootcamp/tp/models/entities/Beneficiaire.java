/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tp.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author kiki
 */
@Entity
@DiscriminatorValue("BENEFICIAIRE")
@Table(name="tp_beneficiaire")
public class Beneficiaire extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//    
//    @Column(length = 45)
//    private String nom;
    
//    @ManyToMany
//    @JoinTable(name = "tp_beneficiaire_has_projet", 
//            joinColumns = @JoinColumn(name = "beneficiaire_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "projet_id", referencedColumnName = "id"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"beneficiaire_id","projet_id"})
//    )
    @OneToMany(mappedBy="beneficiaireprojet",
    		fetch=FetchType.LAZY,
			cascade = CascadeType.ALL
    		)
    private List<BeneficiaireProjet> projetsBeneficiaire=new ArrayList<BeneficiaireProjet>();

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
    
    
    
    @PrePersist
    @PreUpdate
    private  void validate(){
    	if((getNom().isEmpty()) || (getNom()==null))
    		throw new IllegalArgumentException("Le nom est obligatoire");
    }

    public List<BeneficiaireProjet> getProjetsBeneficiaire() {
		return projetsBeneficiaire;
	}

	public void setProjetsBeneficiaire(List<BeneficiaireProjet> projetsBeneficiaire) {
		this.projetsBeneficiaire = projetsBeneficiaire;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiaire)) {
            return false;
        }
        Beneficiaire other = (Beneficiaire) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.tp.models.entities.Beneficiaire[ id=" + getId() + " ]";
    }
    
}
