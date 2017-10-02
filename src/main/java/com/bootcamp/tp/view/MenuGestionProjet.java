package com.bootcamp.tp.view;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class MenuGestionProjet extends JFrame {

	private JDesktopPane jMainPane;
	private JMenuBar mnuBar;
	private JMenu mnuReferentiel;
	private JMenuItem miBailleur, miBeneficiaire, miFournisseur;
	private JMenu mnuGestion;
	private JMenuItem miProjet, miProgramme, miIndicateur, miLivrable;
	private JMenu mnuParametres;
	private JMenuItem miParams;
	private JMenu mnuAide;
	private JMenuItem miAide;

	public MenuGestionProjet() throws HeadlessException {
		initComponents();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		
		jMainPane = new JDesktopPane();
		jMainPane.setBackground(java.awt.Color.gray);

		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		mnuBar = new JMenuBar();

		
		mnuReferentiel = new JMenu("Référentiels");
		miBailleur = new JMenuItem("Bailleur");
		miBailleur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuBailleurActionPerformed(evt);
			}
		}

		);
		miBeneficiaire = new JMenuItem("Bénéficiaire");
		miBeneficiaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuBeneficiaireActionPerformed(evt);
			}
		}

		);
		miFournisseur = new JMenuItem("Fournisseur");
		miFournisseur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuFournisseurActionPerformed(evt);
			}
		}

		);
		
		mnuReferentiel.add(miBailleur);
		mnuReferentiel.add(miBeneficiaire);
		mnuReferentiel.add(miFournisseur);
		
		mnuBar.add(mnuReferentiel);
		
		
		mnuGestion = new JMenu("Gestion");
		miProjet = new JMenuItem("Projet");
		miProjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuBailleurActionPerformed(evt);
			}
		});
		
		miProgramme = new JMenuItem("Programme");
		miProgramme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuBailleurActionPerformed(evt);
			}
		});
		
		miIndicateur = new JMenuItem("Indicateur");
		miIndicateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuBailleurActionPerformed(evt);
			}
		});
		
		miLivrable = new JMenuItem("Livrable");
		miLivrable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mnuBailleurActionPerformed(evt);
			}
		});
		
		mnuGestion.add(miProjet);
		mnuGestion.add(miProgramme);
		mnuGestion.add(miIndicateur);
		mnuGestion.add(miLivrable);
		
		mnuBar.add(mnuGestion);
		
		mnuParametres = new JMenu("Paramètres");
		mnuAide = new JMenu("Aide");
		
		mnuBar.add(mnuParametres);
		mnuBar.add(mnuAide);
		
		
		this.setJMenuBar(mnuBar);
		this.pack();

	}

	private void mnuBailleurActionPerformed(ActionEvent evt) {
		BailleurFrame bailleurFrm = new BailleurFrame();
		jMainPane.add(bailleurFrm);
		bailleurFrm.setVisible(true);

	}

	private void mnuBeneficiaireActionPerformed(ActionEvent evt) {
		BailleurFrame bailleurFrm = new BailleurFrame();
		jMainPane.add(bailleurFrm);
		bailleurFrm.setVisible(true);
	}

	private void mnuFournisseurActionPerformed(ActionEvent evt) {
		BailleurFrame bailleurFrm = new BailleurFrame();
		jMainPane.add(bailleurFrm);
		bailleurFrm.setVisible(true);
	}

	private void mnuProjetActionPerformed(ActionEvent evt) {
		BailleurFrame bailleurFrm = new BailleurFrame();
		jMainPane.add(bailleurFrm);
		bailleurFrm.setVisible(true);
	}
	
	private void mnuProgrammeActionPerformed(ActionEvent evt) {
		BailleurFrame bailleurFrm = new BailleurFrame();
		jMainPane.add(bailleurFrm);
		bailleurFrm.setVisible(true);
	}
	private void mnuIndicateurActionPerformed(ActionEvent evt) {
		BailleurFrame bailleurFrm = new BailleurFrame();
		jMainPane.add(bailleurFrm);
		bailleurFrm.setVisible(true);
	}
	private void mnuLivrableActionPerformed(ActionEvent evt) {
		BailleurFrame bailleurFrm = new BailleurFrame();
		jMainPane.add(bailleurFrm);
		bailleurFrm.setVisible(true);
	}
	
}
