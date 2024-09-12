package br.ufc.dc.luthier.gui.janelas.clientes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JanelaClientes extends JFrame {
	public JanelaClientes() {
		setSize(800,700);
		setLocationRelativeTo(null);
		
		JPanel pane_lista = new JPanel();
		pane_lista.setLayout(new BoxLayout(pane_lista, BoxLayout.Y_AXIS));
		JPanel pane_botao = new JPanel();
		
        ArrayList<String[]> clientes = new ArrayList<>();
        clientes.add(new String[] {"João Silva", "123.456.789-00"});
        clientes.add(new String[] {"Maria Oliveira", "987.654.321-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        clientes.add(new String[] {"Carlos Souza", "456.789.123-00"});
        
        for (String[] cliente : clientes) {
            JPanel panel_item = new JPanel();
 
            JPanel panel_labels = new JPanel();
            panel_labels.setLayout(new BoxLayout(panel_labels, BoxLayout.Y_AXIS));
            JLabel label_nome = new JLabel("Nome: " + cliente[0]);
            JLabel label_cpf = new JLabel("CPF: " + cliente[1]);
            panel_labels.add(label_nome);
            panel_labels.add(label_cpf);
            
            JPanel panel_botoes = new JPanel();
            panel_botoes.setLayout(new BoxLayout(panel_botoes, BoxLayout.Y_AXIS));
            JButton botao_ver = new JButton("Ver");
            JButton botao_editar = new JButton("Editar");
            JButton botao_excluir = new JButton("Excluir");
            botao_ver.setAlignmentX(CENTER_ALIGNMENT);
            botao_editar.setAlignmentX(CENTER_ALIGNMENT);
            botao_excluir.setAlignmentX(CENTER_ALIGNMENT);
            panel_botoes.add(botao_ver);
            panel_botoes.add(botao_editar);
            panel_botoes.add(botao_excluir);

            panel_item.add(panel_labels, BorderLayout.WEST);
            panel_item.add(panel_botoes, BorderLayout.EAST);
            panel_item.setAlignmentX(CENTER_ALIGNMENT);

            pane_lista.add(panel_item);
        }

 
        JScrollPane scrollPane = new JScrollPane(pane_lista);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton cadastrar_botao = new JButton("Cadastrar Usuario");
		pane_botao.add(cadastrar_botao);
		
		JPanel pane_principal = new JPanel(new BorderLayout());	
		pane_principal.add(scrollPane, BorderLayout.CENTER);  // Adiciona o pane_lista no centro
        pane_principal.add(pane_botao, BorderLayout.SOUTH);
		setContentPane(pane_principal);
		setVisible(true);
	}
}
