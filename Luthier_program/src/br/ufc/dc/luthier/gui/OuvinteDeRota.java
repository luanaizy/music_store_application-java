package br.ufc.dc.luthier.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OuvinteDeRota implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		Object fonte = e.getSource();
		if(fonte instanceof JButton) {
			if(((JButton)fonte).getText() == "Clientes") {
				System.out.println("aa");
			}
			if(((JButton)fonte).getText() == "Instrumentos") {
				System.out.println("aa");
			}
			if(((JButton)fonte).getText() == "Ordens de Servico") {
				System.out.println("aa");
			}
		}
		}
		
	}