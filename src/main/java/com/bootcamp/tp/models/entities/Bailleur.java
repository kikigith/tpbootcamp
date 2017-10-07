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
@DiscriminatorValue("BAILLEUR")
@Table(name = "tp_bailleur")
public class Bailleur extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//    @Column(length = 45, nullable = false)
//    private String nom;
    
    private TypeDeBailleur typeDeBailleur;
    
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "tp_bailleur_has_programme", 
//            joinColumns = @JoinColumn(name = "bailleur_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "programme_id", referencedColumnName = "id"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"bailleur_id","programme_id"})
//    )
//    private List<Programme> programmes=new ArrayList<Programme>();
    @OneToMany(mappedBy="bailleurduprogramme",
    		fetch=FetchType.LAZY,
    		cascade=CascadeType.ALL
    		)
    private List<BailleurProgramme> programmesBailleur=new ArrayList<BailleurProgramme>();
    
//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "tp_bailleur_has_projet", 
//            joinColumns = @JoinColumn(name = "bailleur_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "projet_id", referencedColumnName = "id"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"bailleur_id","projet_id"})
//    )
//    private List<Projet> projets=new ArrayList<Projet>();
    
    @OneToMany(mappedBy="bailleurduprojet",
    		fetch=FetchType.LAZY,
    		cascade=CascadeType.ALL
    		)
    private List<BailleurProjet> projetsBailleur=new ArrayList<BailleurProjet>();

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

    public TypeDeBailleur getTypeDeBailleur() {
        return typeDeBailleur;
    }

    public void setTypeDeBailleur(TypeDeBailleur typeDeBailleur) {
        this.typeDeBailleur = typeDeBailleur;
    }

    public List<BailleurProgramme> getProgrammesBailleur() {
        return programmesBailleur;
    }

    public void setProgrammesBailleur(List<BailleurProgramme> programmesBailleur) {
        this.programmesBailleur = programmesBailleur;
    }

    public List<BailleurProjet> getProjetsBailleur() {
        return projetsBailleur;
    }

    public void setProjetsBailleur(List<BailleurProjet> projetsBailleur) {
        this.projetsBailleur = projetsBailleur;
    }
    

    @PrePersist
    @PreUpdate
    private  void validate(){
    	if((getNom().isEmpty()) || (getNom()==null))
    		throw new IllegalArgumentException("Le nom est obligatoire");
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
        if (!(object instanceof Bailleur)) {
            return false;
        }
        Bailleur other = (Bailleur) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.tp.models.entities.Bailleur[ id=" + getId() + " ]";
    }
    
}
