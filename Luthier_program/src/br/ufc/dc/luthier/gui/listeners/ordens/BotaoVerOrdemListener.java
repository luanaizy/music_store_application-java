package br.ufc.dc.luthier.gui.listeners.ordens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaVerOrdem;

public class BotaoVerOrdemListener implements ActionListener {
	private OrdemController ordem_controller;
	private int index;
	public BotaoVerOrdemListener(int index,OrdemController ordem_controller) {
		this.ordem_controller = ordem_controller;
		this.index = index;
	}
	public void actionPerformed(ActionEvent e) {
		JanelaVerOrdem janela_ver_ordem = new JanelaVerOrdem(index, ordem_controller);
	}
}
