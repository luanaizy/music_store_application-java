package br.ufc.dc.luthier.gui.listeners.ordens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.exceptions.OrdemInexistenteException;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;


public class BotaoExcluirOrdemListener implements ActionListener {
	private String numero;
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller;
	private	InstrumentoController instrumento_controller;
	private MaterialController material_controller;
	private OrdemController  ordem_controller;
	
	public BotaoExcluirOrdemListener(String numero, ClienteController cliente_controller, FuncionarioController funcionario_controller, 
			InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.numero = numero;
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;
	}
	public void actionPerformed(ActionEvent e) {
		try {
			ordem_controller.remover(numero);
			JOptionPane.showMessageDialog(null,  "Ordem removida com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			JFrame janela_ordens = (JFrame)((JButton)e.getSource()).getTopLevelAncestor();
			janela_ordens.dispose();
			new JanelaOrdensDeServico( cliente_controller, funcionario_controller, instrumento_controller, material_controller, ordem_controller);
		} catch (OrdemInexistenteException oie) {
			JOptionPane.showMessageDialog(null,  "Tentativa de remover ordem inexistente!", "Falha", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
}
