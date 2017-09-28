/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tp.models.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.bootcamp.tp.models.dependencies.BaseEntite;

/**
 *
 * @author kiki
 */
@Entity
@Table(name = "tp_indicateurperformance")
public class IndicateurPerformance extends BaseEntite implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
    @Column(length = 45)
    private String libelle;
    @Column(length = 45)
    private String nature;
    @Column(length = 45)
    private String valeur;
    
    @OneToMany(mappedBy = "indicateurPerformance",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<IndicateurQualitatif> indicateurQualitatifs;
    
    @OneToMany(mappedBy = "indicateurPerformance",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<IndicateurQuantitatif> indicateurQuantitatifs;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
    
    @PrePersist
    @PreUpdate
    private  void validate(){
    	if((getLibelle().isEmpty()) || (getLibelle()==null))
    		throw new IllegalArgumentException("Le libelle est obligatoire");
    	if((getNature().isEmpty()) || (getNature()==null))
    		throw new IllegalArgumentException("La nature est obligatoire");
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
        if (!(object instanceof IndicateurPerformance)) {
            return false;
        }
        IndicateurPerformance other = (IndicateurPerformance) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.projet.entites.IndicateurPerformance[ id=" + getId() + " ]";
    }
    
}
