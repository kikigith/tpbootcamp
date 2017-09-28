/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.bootcamp.tp.controleurs.BailleurController;
import com.bootcamp.tp.controleurs.BeneficiaireController;
import com.bootcamp.tp.controleurs.FournisseurController;
import com.bootcamp.tp.controleurs.IndicateurPerformanceController;
import com.bootcamp.tp.controleurs.LivrableController;
import com.bootcamp.tp.controleurs.ProgrammeController;
import com.bootcamp.tp.controleurs.ProjetController;
import com.bootcamp.tp.controleurs.exceptions.NonexistentEntityException;
import com.bootcamp.tp.models.entities.Bailleur;
import com.bootcamp.tp.models.entities.Beneficiaire;
import com.bootcamp.tp.models.entities.Fournisseur;
import com.bootcamp.tp.models.entities.IndicateurPerformance;
import com.bootcamp.tp.models.entities.Livrable;
import com.bootcamp.tp.models.entities.Programme;
import com.bootcamp.tp.models.entities.Projet;

/**
 *
 * @author kiki
 */
public class App {

    public static void main(String argv[]) {

//        EntityManager em = emf.createEntityManager();
//        Programme prg=new Programme();
//        em.getTransaction().begin();
//        prg.setNom("Programme 1");
//        
//        em.persist(prg);
//        
//        em.getTransaction().commit();
        App m = new App();
        m.displayMenu();
    }

    public int displayMenu() {
        int choix = 0;
        do {

            System.out.println("1- Gérer les bailleurs");
            System.out.println("2- Gérer les beneficiaires");
            System.out.println("3- Gérer les fournisseurs");
            System.out.println("4- Gérer les programmes");
            System.out.println("5- Gérer les projets");
            System.out.println("6- Gérer les indicateurs");
            System.out.println("7- Gérer les livrables");
            System.out.println("8- Quitter");
            System.out.print("Votre choix:");
            Scanner in = new Scanner(System.in);
            choix = in.nextInt();

            switch (choix) {
                case 1:
                    gestionBailleur();
                    break;
                case 2:
                    gestionBeneficiaire();
                    break;
                case 3:
                    gestionFournisseur();
                    break;
                case 4:
                    gestionProgramme();
                    break;
                case 5:
                    gestionProjet();
                    break;
                case 6:
                    gestionIndicateurPerformance();
                    break;
                case 7:
                    gestionLivrable();
                    break;
                default:
                    break;
            }
        } while (choix != 8);
        return choix;
    }

    public int displaySousMenu() {
        int choix = 0;
        do {
            System.out.println("1- Créer");
            System.out.println("2- Rechercher");
            System.out.println("3- Modifier");
            System.out.println("4- Supprimer");
            System.out.println("5- Menu principal");
            System.out.print("Votre choix:");
            Scanner in = new Scanner(System.in);
            choix = in.nextInt();
        } while (choix != 5);
        return choix;
    }

    public void gestionBailleur() {
        System.out.println("###########Gestion des bailleurs ################");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpmsqlPU");
        BailleurController bc = new BailleurController(emf);
        int choix = 0;
//        do {
        System.out.println("1- Créer");
        System.out.println("2- Rechercher");
        System.out.println("3- Modifier");
        System.out.println("4- Supprimer");
        System.out.println("5- Menu principal");
        System.out.print("Votre choix:");
        Scanner in = new Scanner(System.in);
        choix = in.nextInt();
//        } while (choix != 5);
        switch (choix) {
            case 1:
                Scanner in1 = new Scanner(System.in);
                System.out.println("Nom du bailleur:");
                String nom = in1.next();
                Bailleur b = new Bailleur();
                b.setNom(nom);
                bc.create(b);
                break;
            case 2:
                Scanner in2 = new Scanner(System.in);
                System.out.println("Nom du bailleur:");
                String nomr = in2.next();
                List<Bailleur> res = bc.findBailleurByName(nomr);
                if (res.size() > 0) {
                    for (Bailleur re : res) {
                        System.out.println(re.getId() + " " + re.getNom());
                    }
                }
                break;
            case 3:
                Scanner in3 = new Scanner(System.in);
                System.out.println("ID bailleur à modifier:");
                int i = in3.nextInt();
                Bailleur bm = bc.findBailleur(i);
                System.out.println("Nom bailleur:");
                String s = in3.next();
                bm.setNom(s);
                 {
                    try {
                        bc.edit(bm);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                Scanner in4 = new Scanner(System.in);

                System.out.println("ID bailleur à supprimer:");
                int id = in4.nextInt();
                 {
                    try {
                        bc.destroy(id);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 5:
                displayMenu();
                break;
            default:
                break;
        }
    }

    public void gestionBeneficiaire() {
        System.out.println("###########Gestion des Beneficiaires ################");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpmsqlPU");
        BeneficiaireController be = new BeneficiaireController(emf);
        int choix = 0;
//        do {
        System.out.println("1- Créer");
        System.out.println("2- Rechercher");
        System.out.println("3- Modifier");
        System.out.println("4- Supprimer");
        System.out.println("5- Menu principal");
        System.out.print("Votre choix:");
        Scanner in = new Scanner(System.in);
        choix = in.nextInt();
//        } while (choix != 5);
        switch (choix) {
            case 1:
                Scanner in0 = new Scanner(System.in);
                System.out.println("Nom du beneficiaire:");
                String nom = in0.next();
                Beneficiaire b = new Beneficiaire();
                b.setNom(nom);
                be.create(b);
                break;
            case 2:
                Scanner inm = new Scanner(System.in);
                System.out.println("Nom du beneficiaire:");
                String nomr = inm.next();
                List<Beneficiaire> res = be.findBeneficiaireByName(nomr);
                if (res.size() > 0) {
                    for (Beneficiaire re : res) {
                        System.out.println(re.getId() + " " + re.getNom());
                    }
                }
                break;
            case 3:
                Scanner inm1 = new Scanner(System.in);
                System.out.println("ID beneficiaire à modifier:");
                int i = inm1.nextInt();
                Beneficiaire bm = be.findBeneficiaire(i);
                System.out.println("Nom beneficiaire:");
                String s = inm1.next();
                bm.setNom(s);
                 {
                    try {
                        be.edit(bm);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                Scanner inm2 = new Scanner(System.in);
                System.out.println("ID beneficiaire à supprimer:");
                int id = inm2.nextInt();

                    try {
                        be.destroy(id);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }

                break;
            default:
                break;
        }
    }

    public void gestionFournisseur()   {
        System.out.println("###########Gestion des Fournisseurs ################");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpmsqlPU");
        FournisseurController fc = new FournisseurController(emf);
        int choix = 0;
//        do {
        System.out.println("1- Créer");
        System.out.println("2- Rechercher");
        System.out.println("3- Modifier");
        System.out.println("4- Supprimer");
        System.out.println("5- Menu principal");
        System.out.print("Votre choix:");
        Scanner in = new Scanner(System.in);
        choix = in.nextInt();
//        } while (choix != 5);
        switch (choix) {
            case 1:
                Scanner in0 = new Scanner(System.in);
                System.out.println("Nom du beneficiaire:");
                String nom = in0.next();
                Fournisseur f = new Fournisseur();
                f.setNom(nom);
                fc.create(f);
                break;
            case 2:
                Scanner inm = new Scanner(System.in);
                System.out.println("Nom du beneficiaire:");
                String nomr = inm.next();
                List<Fournisseur> res = fc.findFournisseurByName(nomr);
                if (res.size() > 0) {
                    for (Fournisseur re : res) {
                        System.out.println(re.getId() + " " + re.getNom());
                    }
                }
                break;
            case 3:
                Scanner inm1 = new Scanner(System.in);
                System.out.println("ID fournisseur à modifier:");
                int i = inm1.nextInt();
                Fournisseur fo = fc.findFournisseur(i);
                System.out.println("Nom fournisseur:");
                String s = inm1.next();
                fo.setNom(s);
                 {
                    try {
                        fc.edit(fo);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                Scanner inm2 = new Scanner(System.in);
                System.out.println("ID beneficiaire à supprimer:");
                int id = inm2.nextInt();
                 {
                    try {
                        fc.destroy(id);
//                    } catch (NonexistentEntityException ex) {
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void gestionProgramme() {
        System.out.println("###########Gestion des Programmes ################");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpmsqlPU");
        ProgrammeController pc = new ProgrammeController(emf);
        int choix = 0;
//        do {
        System.out.println("1- Créer");
        System.out.println("2- Rechercher");
        System.out.println("3- Modifier");
        System.out.println("4- Supprimer");
        System.out.println("5- Menu principal");
        System.out.print("Votre choix:");
        Scanner in = new Scanner(System.in);
        choix = in.nextInt();
//        } while (choix != 5);
        switch (choix) {
            case 1:
                Scanner in0 = new Scanner(System.in);
                Programme p = new Programme();
                System.out.println("Nom du programme:");
                String nom = in0.next();
                p.setNom(nom);
                System.out.println("objectif du programme:");
                String obj = in0.next();
                p.setObjectif(obj);
                System.out.println("date de debut du programme:");
                String sDebut = in0.next();
                System.out.println("date de fin du programme:");
                String sFin = in0.next();
                DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
                Date debut;
                Date fin;
                try {
                    debut = df.parse(sDebut);
                    fin = df.parse(sFin);
                    p.setDateDeDebut(debut);
                    p.setDateDeFin(fin);
                } catch (ParseException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("indicateur performance du programme:");
                String ipp = in0.next();
                p.setIndicateurPerformance(pc.findIndicateur(Integer.parseInt(ipp)));
                pc.create(p);
                break;
            case 2:
                Scanner inm = new Scanner(System.in);
                System.out.println("Nom du programme:");
                String nomr = inm.next();
                List<Programme> res = pc.findProgrammeByName(nomr);
                if (res.size() > 0) {
                    for (Programme re : res) {
                        System.out.println(re.getId() + " " + re.getNom());
                    }
                }
                break;
            case 3:
                Scanner inm1 = new Scanner(System.in);
                System.out.println("ID programme à modifier:");
                int i = inm1.nextInt();
                Programme pr = pc.findProgramme(i);
                System.out.println("Nom programme:");
                String s = inm1.next();
                pr.setNom(s);
                System.out.println("indicateur performance du programme:");
                int ipf = inm1.nextInt();
                pr.setIndicateurPerformance(pc.findIndicateur(ipf));
                System.out.println("objectif du programme:");
                String obj1 = inm1.next();
                pr.setObjectif(obj1);
                System.out.println("date de debut du programme:");
                String sDebut1 = inm1.next();
                System.out.println("date de fin du programme:");
                String sFin1 = inm1.next();
                DateFormat df1 = new SimpleDateFormat("dd/mm/yyyy");
                Date debut1;
                Date fin1;
                 {
                    try {
                        debut1 = df1.parse(sDebut1);
                        fin1 = df1.parse(sFin1);
                        pr.setDateDeDebut(debut1);
                        pr.setDateDeFin(fin1);
                        pc.edit(pr);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                Scanner inm2 = new Scanner(System.in);
                System.out.println("ID programme à supprimer:");
                int id = inm2.nextInt();
                 {
                    try {
                        pc.destroy(id);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void gestionProjet() {
        System.out.println("###########Gestion des Projet ################");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpmsqlPU");
        ProjetController pc = new ProjetController(emf);
        int choix = 0;
//        do {
        System.out.println("1- Créer");
        System.out.println("2- Rechercher");
        System.out.println("3- Modifier");
        System.out.println("4- Supprimer");
        System.out.println("5- Menu principal");
        System.out.print("Votre choix:");
        Scanner in = new Scanner(System.in);
        choix = in.nextInt();
//        } while (choix != 5);
        switch (choix) {
            case 1:
                Scanner in0 = new Scanner(System.in);
                Projet p = new Projet();
                System.out.println("Nom du projet:");
                String nom = in0.next();
                p.setNom(nom);
                System.out.println("objectif du projet:");
                String obj = in0.next();
                p.setObjectif(obj);
                System.out.println("date de debut du projet:");
                String sDebut = in0.next();
                System.out.println("date de fin du projet:");
                String sFin = in0.next();
                DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
                Date debut;
                Date fin;
                try {
                    debut = df.parse(sDebut);
                    fin = df.parse(sFin);
                    p.setDateDeDebut(debut);
                    p.setDateDeFin(fin);
                } catch (ParseException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("indicateur performance du projet:");
                int ipp = in0.nextInt();
                p.setIndicateurPerformance(pc.findIndicateur(ipp));
                List<Fournisseur> lstFournisseur = new ArrayList<Fournisseur>();
                String rep = "oui";
                do {
                    System.out.println("Voulez-vous ajouter un fournisseur au projet ? ");
                    Scanner sc = new Scanner(System.in);
                    rep = sc.next();
                    if (rep.equalsIgnoreCase("oui")) {
                        System.out.println("Numero du fournisseur :");
                        Scanner scf = new Scanner(System.in);
                        Fournisseur f = pc.findFournisseur(scf.nextInt());
                        lstFournisseur.add(f);
                    }
                } while (rep.equalsIgnoreCase("oui"));
                if (lstFournisseur.size() != 0) {
                    pc.addFournisseurs(lstFournisseur, Integer.parseInt(p.getId()));
                }
                pc.create(p);
                break;
            case 2:
                Scanner inm = new Scanner(System.in);
                System.out.println("Nom du projet:");
                String nomr = inm.next();
                List<Projet> res = pc.findProjetByName(nomr);
                if (res.size() > 0) {
                    for (Projet re : res) {
                        System.out.println(re.getId() + " " + re.getNom());
                    }
                }
                break;
            case 3:
                Scanner inm1 = new Scanner(System.in);
                System.out.println("ID projet à modifier:");
                int i = inm1.nextInt();
                Projet pr = pc.findProjet(i);
                System.out.println("Nom projet:");
                String s = inm1.next();
                pr.setNom(s);
                System.out.println("objectif du projet:");
                String obj1 = inm1.next();
                pr.setObjectif(obj1);
                System.out.println("indicateur performance du projet:");
                int ip1 = inm1.nextInt();
                pr.setIndicateurPerformance(pc.findIndicateur(ip1));
                System.out.println("date de debut du projet:");
                String sDebut1 = inm1.next();
                System.out.println("date de fin du projet:");
                String sFin1 = inm1.next();
                DateFormat df1 = new SimpleDateFormat("dd/mm/yyyy");
                Date debut1;
                Date fin1;
                 {
                    try {
                        debut1 = df1.parse(sDebut1);
                        fin1 = df1.parse(sFin1);
                        pr.setDateDeDebut(debut1);
                        pr.setDateDeFin(fin1);
                        pc.edit(pr);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                Scanner inm2 = new Scanner(System.in);
                System.out.println("ID projet à supprimer:");
                int id = inm2.nextInt();
                 {
                    try {
                        pc.destroy(id);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void gestionIndicateurPerformance() {
        System.out.println("###########Gestion des Indicateurs de performance ################");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpmsqlPU");
        IndicateurPerformanceController ipc = new IndicateurPerformanceController(emf);
        int choix = 0;
//        do {
        System.out.println("1- Créer");
        System.out.println("2- Rechercher");
        System.out.println("3- Modifier");
        System.out.println("4- Supprimer");
        System.out.println("5- Menu principal");
        System.out.print("Votre choix:");
        Scanner in = new Scanner(System.in);
        choix = in.nextInt();
//        } while (choix != 5);
        switch (choix) {
            case 1:
                Scanner in0 = new Scanner(System.in);
                IndicateurPerformance ip = new IndicateurPerformance();
                System.out.println("libelle indicateur:");
                String libelle = in0.next();
                ip.setLibelle(libelle);
                System.out.println("nature indicateur:");
                String nature = in0.next();
                ip.setNature(nature);
                System.out.println("valeur indicateur:");
                String valeur = in0.next();
                ip.setValeur(valeur);

                ipc.create(ip);
                break;
            case 2:
                Scanner inm = new Scanner(System.in);
                System.out.println("libelle indicateur:");
                String lib = inm.next();
                List<IndicateurPerformance> res = ipc.findIndicateurPerformanceByLibelle(lib);
                if (res.size() > 0) {
                    for (IndicateurPerformance re : res) {
                        System.out.println(re.getId() + " " + re.getLibelle() + " " + re.getNature() + " " + re.getValeur());
                    }
                }
                break;
            case 3:
                Scanner inm1 = new Scanner(System.in);
                System.out.println("ID Indicateur à modifier:");
                int i = inm1.nextInt();
                IndicateurPerformance ipf = ipc.findIndicateurPerformance(i);
                System.out.println("Libelle indicateur:");
                String s = inm1.next();
                ipf.setLibelle(s);
                System.out.println("Nature indicateur:");
                String obj1 = inm1.next();
                ipf.setNature(obj1);
                System.out.println("Valeur indicateur:");
                String vl = inm1.next();
                ipf.setValeur(vl);
                 {
                    try {
                        ipc.edit(ipf);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                Scanner inm2 = new Scanner(System.in);
                System.out.println("ID indicateur à supprimer:");
                int id = inm2.nextInt();
                 {
                    try {
                        ipc.destroy(id);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void gestionLivrable() {
        System.out.println("###########Gestion des Livrables ################");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpmsqlPU");
        LivrableController lc = new LivrableController(emf);
        int choix = 0;
//        do {
        System.out.println("1- Créer");
        System.out.println("2- Rechercher");
        System.out.println("3- Modifier");
        System.out.println("4- Supprimer");
        System.out.println("5- Menu principal");
        System.out.print("Votre choix:");
        Scanner in = new Scanner(System.in);
        choix = in.nextInt();
//        } while (choix != 5);
        switch (choix) {
            case 1:
                Scanner in0 = new Scanner(System.in);
                Livrable l = new Livrable();
                System.out.println("nom livrable:");
                String nom = in0.next();
                l.setNom(nom);
                System.out.println("date de debut du livrable:");
                String sDebut1 = in0.next();
                System.out.println("date de fin du livrable:");
                String sFin1 = in0.next();
                DateFormat df1 = new SimpleDateFormat("dd/mm/yyyy");
                Date debut1;
                Date fin1;
                 {
                    try {
                        debut1 = df1.parse(sDebut1);
                        fin1 = df1.parse(sFin1);
                        l.setDateDeDebut(debut1);
                        l.setDateDeFin(fin1);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                lc.create(l);
                break;
            case 2:
                Scanner inm = new Scanner(System.in);
                System.out.println("nom livrable:");
                String nl = inm.next();
                List<Livrable> res = lc.findLivrableByName(nl);
                if (res.size() > 0) {
                    for (Livrable re : res) {
                        System.out.println(re.getId() + " " + re.getNom() + " " + re.getDateDeDebut() + " " + re.getDateDeFin());
                    }
                }
                break;
            case 3:
                Scanner inm1 = new Scanner(System.in);
                System.out.println("ID Livrable à modifier:");
                int i = inm1.nextInt();
                Livrable lm = lc.findLivrable(i);
                System.out.println("nom livrable:");
                String s = inm1.next();
                lm.setNom(s);
                System.out.println("date de debut du livrable:");
                String sD1 = inm1.next();
                System.out.println("date de fin du livrable:");
                String sF1 = inm1.next();
                DateFormat f1 = new SimpleDateFormat("dd/mm/yyyy");
                Date de1;
                Date fi1;
                 {
                    try {
                        debut1 = f1.parse(sD1);
                        fin1 = f1.parse(sF1);
                        lm.setDateDeDebut(debut1);
                        lm.setDateDeFin(fin1);
                        lc.edit(lm);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                Scanner inm2 = new Scanner(System.in);
                System.out.println("ID livrable à supprimer:");
                int id = inm2.nextInt();
                 {
                    try {
                        lc.destroy(id);
                    } catch (Exception ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            default:
                break;
        }
    }
}