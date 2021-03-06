/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tp.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.bootcamp.tp.models.dependencies.BaseEntite;

/**
 *
 * @author kiki
 */
@Entity
@Table(name = "tp_projet")
public class Projet extends BaseEntite implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
    @Column(length = 45)
    private String nom;
    @Column(length = 45)
    private String objectif;
    
    @Temporal(TemporalType.DATE)
    private Date dateDeDebut;
    @Temporal(TemporalType.DATE)
    private Date dateDeFin;
    private Integer budgetPrevisionnel;
    private Integer budgetEffectif;
    
    @OneToOne
    private IndicateurPerformance indicateurPerformance;
    
    @ManyToOne
    @JoinColumn(name = "PROGRAMME_ID", referencedColumnName = "id")
    private Programme programme;
    
    @OneToMany(mappedBy = "projet",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Livrable> livrables=new ArrayList<Livrable>();
    
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "tp_projet_has_fournisseur", 
//            joinColumns = @JoinColumn(name = "projet_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "fournisseur_id", referencedColumnName = "id"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"projet_id","fournisseur_id"})
//    )
    @OneToMany(mappedBy = "projet",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ProjetFournisseur> fournisseursProjet=new ArrayList<ProjetFournisseur>();
    
    @OneToMany(mappedBy = "projetdubeneficiaire",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BeneficiaireProjet> beneficiairesProjet=new ArrayList<BeneficiaireProjet>();

    @OneToMany(mappedBy = "projet",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<BailleurProjet> bailleursProjet=new ArrayList<BailleurProjet>();
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

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public Date getDateDeDebut() {
        return dateDeDebut;
    }

    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDeDebut = dateDeDebut;
    }

    public Date getDateDeFin() {
        return dateDeFin;
    }

    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public Integer getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    public void setBudgetPrevisionnel(Integer budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    public Integer getBudgetEffectif() {
        return budgetEffectif;
    }

    public void setBudgetEffectif(Integer budgetEffectif) {
        this.budgetEffectif = budgetEffectif;
    }

    public IndicateurPerformance getIndicateurPerformance() {
        return indicateurPerformance;
    }

    public void setIndicateurPerformance(IndicateurPerformance indicateurPerformance) {
        this.indicateurPerformance = indicateurPerformance;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }

    public List<Livrable> getLivrables() {
        return livrables;
    }

    public void setLivrables(List<Livrable> livrables) {
        this.livrables = livrables;
    }

    public List<ProjetFournisseur> getFournisseursProjet() {
        return fournisseursProjet;
    }

    public void setFournisseursProjet(List<ProjetFournisseur> fournisseursProjet) {
        this.fournisseursProjet = fournisseursProjet;
    }
    @PrePersist
    @PreUpdate
    private  void validate(){
    	if((getNom().isEmpty()) || (getNom()==null))
    		throw new IllegalArgumentException("Le libelle est obligatoire");
    	if((getObjectif().isEmpty()) || (getObjectif()==null))
    		throw new IllegalArgumentException("L'objectif est obligatoire");
    	if((getDateDeDebut().equals(null)) || (getDateDeFin().equals(null)))
    		throw new IllegalArgumentException("Les dates de début et de fin sont obligatoires");
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
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.projet.entites.Projet[ id=" + getId() + " ]";
    }
    
}
