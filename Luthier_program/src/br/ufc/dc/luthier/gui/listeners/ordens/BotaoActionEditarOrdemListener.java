package br.ufc.dc.luthier.gui.listeners.ordens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.ufc.dc.luthier.controllers.ClienteController;
import br.ufc.dc.luthier.controllers.FuncionarioController;
import br.ufc.dc.luthier.controllers.InstrumentoController;
import br.ufc.dc.luthier.controllers.MaterialController;
import br.ufc.dc.luthier.controllers.OrdemController;
import br.ufc.dc.luthier.exceptions.ExisteOrdemAbertaPInstrException;
import br.ufc.dc.luthier.gui.janelas.ordens.JanelaOrdensDeServico;
import br.ufc.dc.luthier.instrumentos.Instrumento;
import br.ufc.dc.luthier.instrumentos.estados.EstadoInstrumento;
import br.ufc.dc.luthier.materiais.Material;
import br.ufc.dc.luthier.ordens.OrdemDeServico;
import br.ufc.dc.luthier.ordens.notificacoes.Notificacao;
import br.ufc.dc.luthier.ordens.situacao.SituacaoOrdem;
import br.ufc.dc.luthier.pessoas.Cliente;
import br.ufc.dc.luthier.pessoas.Funcionario;
import br.ufc.dc.luthier.servicos.ServicoAbstract;

public class BotaoActionEditarOrdemListener implements ActionListener {
	private JanelaOrdensDeServico owner;
	private int index;
	private JComboBox<String> atendente_input;
	private JComboBox<String> instrumento_input;
	private JComboBox<String> instrumento_estado_input;
	private JTextArea data_prevista_label;
	private JComboBox<String> situacao_input;
	private Vector<ServicoAbstract> servicos;
	private Vector<Material> materiais;
	private Vector<Notificacao> notificacoes;
	private ClienteController cliente_controller;
	private FuncionarioController funcionario_controller; 
	private InstrumentoController instrumento_controller;
	private  MaterialController material_controller;
	private OrdemController  ordem_controller;
	
	public BotaoActionEditarOrdemListener(JanelaOrdensDeServico owner, int index,JComboBox<String> atendente_input,
			JComboBox<String> instrumento_input, JComboBox<String> instrumento_estado_input, JTextArea data_prevista_label, JComboBox<String> situacao_input,
			 Vector<ServicoAbstract> servicos,Vector<Material> materiais,Vector<Notificacao> notificacoes, ClienteController cliente_controller, 
			 FuncionarioController funcionario_controller, InstrumentoController instrumento_controller, MaterialController material_controller, OrdemController  ordem_controller) {
		this.owner = owner;
		this.index = index;
		this.atendente_input = atendente_input;
		this.instrumento_input = instrumento_input;
		this.instrumento_estado_input = instrumento_estado_input;
		this.data_prevista_label = data_prevista_label;
		this.situacao_input = situacao_input;
		this.servicos = servicos;
		this.materiais = materiais;
		this.notificacoes = notificacoes;
		this.cliente_controller = cliente_controller;
		this.funcionario_controller = funcionario_controller;
		this.instrumento_controller = instrumento_controller;
		this.material_controller = material_controller;
		this.ordem_controller = ordem_controller;
	}
	
	public void actionPerformed(ActionEvent e){
		try {

			String atendente_selecionado = (String) atendente_input.getSelectedItem();
			String codigo_atendente = atendente_selecionado.split(" - ")[0]; 
			
			String instrumento_selecionado = (String) instrumento_input.getSelectedItem();
			String num_de_serie = instrumento_selecionado.split(" - ")[0];
			
			String estado_inst_string = (String) instrumento_estado_input.getSelectedItem();

			instrumento_controller.procurar(num_de_serie).setEstado(ordem_controller.getEstadoInstrumentoEquivalente(estado_inst_string));
			
			String situacao_input_string = (String) situacao_input.getSelectedItem();
			SituacaoOrdem situacao;
			if(situacao_input_string.equals("ABERTA")) {
				situacao = SituacaoOrdem.ABERTA;
			}else {
				situacao = SituacaoOrdem.CONCLUÍDA;
			}
			
			ordem_controller.modificar(index,servicos, instrumento_controller.procurar(num_de_serie), ordem_controller.getEstadoInstrumentoEquivalente(estado_inst_string), 
					data_prevista_label.getText(),  funcionario_controller.procurar(codigo_atendente), situacao, materiais);
			JOptionPane.showMessageDialog(null,  "Ordem editada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			JFrame janela_cadastro = (JFrame) ((JButton)e.getSource()).getTopLevelAncestor();
			janela_cadastro.dispose();
			owner.dispose();
			new JanelaOrdensDeServico( cliente_controller,  funcionario_controller, 
					 instrumento_controller,  material_controller,   ordem_controller);
			
		} catch( ExisteOrdemAbertaPInstrException exc) {
			JOptionPane.showMessageDialog(null,  exc.getMessage() + "Número: " + exc.getNumOrdemAberta(), "Falha", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}