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
@Table(name = "tp_programme")
public class Programme extends BaseEntite implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
    @Column(length = 45)
    private String nom;
    @Column(length = 45, nullable = false)
    private String objectif;
    
    @Temporal(TemporalType.DATE)
    private Date dateDeDebut;
    
    @Temporal(TemporalType.DATE)
    private Date dateDeFin;
    
    private Integer budgetPrevisionnel;
    private Integer budgetEffectif;
    
    @OneToOne
    private IndicateurPerformance indicateurPerformance;
    
//    @ManyToMany
//    @JoinTable(name = "tp_programme_has_beneficiaire", 
//            joinColumns = @JoinColumn(name = "programme_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "beneficiaire_id", referencedColumnName = "id"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"beneficiaire_id","programme_id"})
//    )
//    private List<Beneficiaire> beneficiaires;
    @OneToMany(mappedBy = "programme",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
      private List<BailleurProgramme> bailleursProgramme=new ArrayList<BailleurProgramme>();
    
    @OneToMany(mappedBy = "programme",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
      private List<ProgrammeBeneficiaire> beneficiairesProgramme=new ArrayList<ProgrammeBeneficiaire>();
    
//    @ManyToMany
//    @JoinTable(name = "tp_programme_has_fournisseur", 
//            joinColumns = @JoinColumn(name = "programme_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "fournisseur_id", referencedColumnName = "id"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"programme_id","fournisseur_id"})
//    )
//    private List<Fournisseur> fournisseurs;
    @OneToMany(mappedBy = "programme",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<ProgrammeFournisseur> fournisseursProgramme=new ArrayList<ProgrammeFournisseur>();
    
    @OneToMany(mappedBy = "programme",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Projet> projets=new ArrayList<Projet>();
    

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

    
    public List<BailleurProgramme> getBailleursProgramme() {
		return bailleursProgramme;
	}

	public void setBailleursProgramme(List<BailleurProgramme> bailleursProgramme) {
		this.bailleursProgramme = bailleursProgramme;
	}

	public List<ProgrammeBeneficiaire> getBeneficiairesProgramme() {
        return beneficiairesProgramme;
    }

    public void setBeneficiairesProgramme(List<ProgrammeBeneficiaire> beneficiairesProgramme) {
        this.beneficiairesProgramme = beneficiairesProgramme;
    }

    public List<ProgrammeFournisseur> getFournisseursProgramme() {
        return fournisseursProgramme;
    }

    public void setFournisseursProgramme(List<ProgrammeFournisseur> fournisseursProgramme) {
        this.fournisseursProgramme = fournisseursProgramme;
    }

    public List<Projet> getProjets() {
        return projets;
    }

    public void setProjets(List<Projet> projets) {
        this.projets = projets;
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
        if (!(object instanceof Programme)) {
            return false;
        }
        Programme other = (Programme) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.projet.entites.Programme[ id=" + getId() + " ]";
    }
    
}
