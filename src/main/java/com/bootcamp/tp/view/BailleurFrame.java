package com.bootcamp.tp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

public class BailleurFrame extends JInternalFrame {
	
	private JLabel lblNom;
	private JTable tbBailleurs;
	private JButton btnSave, btnModify,btnDelete,btnSearch;
	private JPanel panel;
	
	public BailleurFrame(){
		initComponents();
	}
	
	private void initComponents(){
		panel = new JPanel();
		lblNom=new JLabel("Nom:");
		btnSave=new JButton("Sauvegarder");
		btnModify=new JButton("Modifier");
		btnDelete=new JButton("Supprimer");
		btnSearch=new JButton("Rechercher");
		tbBailleurs=new JTable();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.white);
		panel.setBorder(BorderFactory.createTitledBorder(null, "Gestion des Commandes", 
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
				new Font("arial", 0, 14),new Color(200,108,108)));
		
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				saveActionPerformed(evt);
			}
		});
		
	}
	
	private void saveActionPerformed(ActionEvent evt){
		
		
	}

}
