/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tp.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

/**
 *
 * @author kiki
 */
@Entity
@Table(name = "tp_indicateurqualitatif")
public class IndicateurQualitatif extends BaseEntite implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
    @Column(length = 45)
    private String nom;
    @Column(length = 45)
    private String propriete;
    @Column(length = 45)
    private String valeur;
    
    @ManyToOne
    @JoinColumn(name = "INDICATEURPERFORMANCE_ID", referencedColumnName = "id")
    private IndicateurPerformance indicateurPerformance;
//    

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPropriete() {
        return propriete;
    }

    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }
    
    
    @PrePersist
    @PreUpdate
    private  void validate(){
    	if((getNom().isEmpty()) || (getNom()==null))
    		throw new IllegalArgumentException("Le nom est obligatoire");
    	if((getPropriete().isEmpty()) || (getPropriete()==null))
    		throw new IllegalArgumentException("La propriete est obligatoire");
    	if((getValeur().isEmpty()) || (getValeur()==null))
    		throw new IllegalArgumentException("La valeur est obligatoire");
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
        if (!(object instanceof IndicateurQualitatif)) {
            return false;
        }
        IndicateurQualitatif other = (IndicateurQualitatif) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.projet.entites.IndicateurQualitatif[ id=" + getId() + " ]";
    }
    
}
