package br.ufc.dc.luthier.gui.janelas.ordens;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufc.dc.luthier.gui.listeners.clientes.BotaoCadastrarClienteListener;
import br.ufc.dc.luthier.gui.listeners.clientes.BotaoEditarClienteListener;
import br.ufc.dc.luthier.gui.listeners.clientes.BotaoExcluirClienteListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoCadastrarOrdemListener;
import br.ufc.dc.luthier.gui.listeners.ordens.BotaoEditarOrdemListener;

public class JanelaOrdensDeServico extends JFrame {
	public JanelaOrdensDeServico() {
		setSize(800,700);
		setLocationRelativeTo(null);
		
		JPanel pane_lista = new JPanel();
		pane_lista.setLayout(new BoxLayout(pane_lista, BoxLayout.Y_AXIS));
		JPanel pane_botao = new JPanel();
		
        ArrayList<String[]> ordens = new ArrayList<>();
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        ordens.add(new String[] {"123123", "material", "cliente","Baixotal","lalala", "123.456.789-00"});
        
        for (String[] ordem : ordens) {
            
            JLabel label_numero = new JLabel("Número: " + ordem[0]);
            JLabel label_nome_do_cliente = new JLabel("Cliente: " + ordem[3]);
            JLabel label_tipo_do_instrumento = new JLabel("Tipo de Instrumento: " + ordem[4]);
            JPanel panel_labels = new JPanel();
            panel_labels.setLayout(new BoxLayout(panel_labels, BoxLayout.Y_AXIS));
            panel_labels.add(label_numero);
            panel_labels.add(label_nome_do_cliente);
            panel_labels.add(label_tipo_do_instrumento);
            
            JButton botao_ver = new JButton("Ver");
            //botao_ver.addActionListener(new BotaoExcluirOrdemListener());
            JButton botao_editar = new JButton("Editar");
            botao_editar.addActionListener(new BotaoEditarOrdemListener());
            JButton botao_excluir = new JButton("Excluir");
            //botao_excluir.addActionListener(new BotaoExcluirOrdemListener());
            
            botao_ver.setAlignmentX(CENTER_ALIGNMENT);
            botao_editar.setAlignmentX(CENTER_ALIGNMENT);
            botao_excluir.setAlignmentX(CENTER_ALIGNMENT);
            JPanel panel_botoes = new JPanel();
            panel_botoes.setLayout(new BoxLayout(panel_botoes, BoxLayout.Y_AXIS));
            panel_botoes.add(botao_ver);
            panel_botoes.add(botao_editar);
            panel_botoes.add(botao_excluir);
            
            JPanel panel_item = new JPanel();
            panel_item.add(panel_labels, BorderLayout.WEST);
            panel_item.add(panel_botoes, BorderLayout.EAST);
            panel_item.setAlignmentX(CENTER_ALIGNMENT);

            pane_lista.add(panel_item);
        }

 
        JScrollPane scroll_pane = new JScrollPane(pane_lista);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
		JButton cadastrar_botao = new JButton("Cadastrar Ordem");
		cadastrar_botao.addActionListener(new BotaoCadastrarOrdemListener());

		pane_botao.add(cadastrar_botao);
		
		JPanel pane_titulo = new JPanel();
		JLabel titulo = new JLabel("Ordens de Servico");
		pane_titulo.add(titulo);
		
		JPanel pane_principal = new JPanel(new BorderLayout());	
		pane_principal.add(pane_titulo, BorderLayout.NORTH);
		pane_principal.add(scroll_pane, BorderLayout.CENTER);
        pane_principal.add(pane_botao, BorderLayout.SOUTH);
		setContentPane(pane_principal);
		
		setVisible(true);
	}
}
