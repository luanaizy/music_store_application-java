package br.ufc.dc.luthier.gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;

public class HomeBotaoOrdensListener implements ActionListener {
	public void actionPerformed(ActionEvent evento){
		JanelaOrdensDeServico janela_ordens = new JanelaOrdensDeServico();
	}
}
