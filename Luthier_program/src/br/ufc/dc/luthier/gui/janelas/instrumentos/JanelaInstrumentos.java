package br.ufc.dc.luthier.gui.janelas.instrumentos;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import br.ufc.dc.luthier.gui.listeners.instrumentos.BotaoCadastrarInstrumentoListener;
import br.ufc.dc.luthier.gui.listeners.instrumentos.BotaoEditarInstrumentoListener;
import br.ufc.dc.luthier.gui.listeners.instrumentos.BotaoExcluirInstrumentoListener;

public class JanelaInstrumentos extends JFrame {
	public JanelaInstrumentos() {
		setSize(800,700);
		setLocationRelativeTo(null);
		
		JPanel pane_lista = new JPanel();
		pane_lista.setLayout(new BoxLayout(pane_lista, BoxLayout.Y_AXIS));
		JPanel pane_botao = new JPanel();
		
        ArrayList<String[]> instrumentos = new ArrayList<>();
        instrumentos.add(new String[] {"Baixo", "123541241231"});
        instrumentos.add(new String[] {"Baixo", "234514613241"});
        instrumentos.add(new String[] {"Baixo", "123541241231"});
        instrumentos.add(new String[] {"Baixo", "234514613241"});
        instrumentos.add(new String[] {"Baixo", "123541241231"});
        instrumentos.add(new String[] {"Baixo", "234514613241"});
        instrumentos.add(new String[] {"Baixo", "123541241231"});
        instrumentos.add(new String[] {"Baixo", "234514613241"});
        instrumentos.add(new String[] {"Baixo", "123541241231"});
        instrumentos.add(new String[] {"Baixo", "234514613241"});
        instrumentos.add(new String[] {"Baixo", "123541241231"});
        instrumentos.add(new String[] {"Baixo", "234514613241"});

        
        for (String[] instrumento : instrumentos) {
            
            JLabel label_tipo = new JLabel("Tipo: " + instrumento[0]);
            JLabel label_codigo = new JLabel("Código: " + instrumento[1]);
            JLabel label_marca = new JLabel("Marca: " + instrumento[1]);
            JLabel label_proprietario = new JLabel("Proprietario: " + instrumento[1]);
            JLabel label_estado = new JLabel("Estado: " + instrumento[1]);
            JPanel panel_labels = new JPanel();
            panel_labels.setLayout(new BoxLayout(panel_labels, BoxLayout.Y_AXIS));
            panel_labels.add(label_tipo);
            panel_labels.add(label_codigo);
            panel_labels.add(label_marca);
            panel_labels.add(label_proprietario);
            panel_labels.add(label_estado);
            
            JButton botao_editar = new JButton("Editar");
            botao_editar.addActionListener(new BotaoEditarInstrumentoListener());
            JButton botao_excluir = new JButton("Excluir");
            botao_excluir.addActionListener(new BotaoExcluirInstrumentoListener());

            botao_editar.setAlignmentX(CENTER_ALIGNMENT);
            botao_excluir.setAlignmentX(CENTER_ALIGNMENT);
            JPanel panel_botoes = new JPanel();
            panel_botoes.setLayout(new BoxLayout(panel_botoes, BoxLayout.Y_AXIS));
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
        
		JButton cadastrar_botao = new JButton("Cadastrar Instrumento");
		cadastrar_botao.addActionListener(new BotaoCadastrarInstrumentoListener());

		pane_botao.add(cadastrar_botao);
		
		JPanel pane_titulo = new JPanel();
		JLabel titulo = new JLabel("Instrumentos");
		pane_titulo.add(titulo);
		
		JPanel pane_principal = new JPanel(new BorderLayout());	
		pane_principal.add(pane_titulo, BorderLayout.NORTH);
		pane_principal.add(scroll_pane, BorderLayout.CENTER);
        pane_principal.add(pane_botao, BorderLayout.SOUTH);
		setContentPane(pane_principal);
		
		setVisible(true);
	}
}
