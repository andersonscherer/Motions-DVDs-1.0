package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ComboBox.ComboBoxNomeRenderer;
import Jdbc.CidadeDAOJDBC;
import Jdbc.ClienteDAOJDBC;
import Model.Cidade;
import Model.Cliente;
import Model.Fita;

public class TelaPesquisaPorCidade {


	private JFrame frame;
	private JComboBox jComboCidade;
	private JButton btnPesquisar;

	private JScrollPane scpCliente;
	private JScrollPane scpFita;

	private Fita fita;
	private Cliente cliente;

	private List<Cliente> listaClientes;
	private List<Fita> listaFilmes;

	private DefaultTableModel dtmListaFilmes;
	private DefaultTableModel dtmLista;

	private JTable jtTabelaFita;
	private JTable jtTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisaPorCidade window = new TelaPesquisaPorCidade();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void criarComboBox() {
		jComboCidade = new JComboBox<Cidade>();
		List<Cidade> cidades = new CidadeDAOJDBC().todos();
		for (Cidade cd : cidades) {
			jComboCidade.addItem(cd);
		}
		jComboCidade.setRenderer(new ComboBoxNomeRenderer());
		jComboCidade.setBounds(100, 110, 177, 22);
		frame.getContentPane().add(jComboCidade);

	}

	public void criarJLabels(){
		JLabel lblEscolhaACidade = new JLabel("Escolha a cidade");
		lblEscolhaACidade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEscolhaACidade.setBounds(129, 76, 160, 16);
		frame.getContentPane().add(lblEscolhaACidade);
		
		JLabel jlbPesquisaCidade = new JLabel("Pesquisa por Cidade");
		jlbPesquisaCidade.setForeground(Color.ORANGE);
		jlbPesquisaCidade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
		jlbPesquisaCidade.setBounds(12, 0, 390, 63);
		frame.getContentPane().add(jlbPesquisaCidade);
				
	}

	public void preencherDadosTabelaFita() {
		Integer cidadeBusca = jComboCidade.getSelectedIndex();
		cliente = new Cliente();
		cliente = new ClienteDAOJDBC().buscarCidade(cidadeBusca);
		listaClientes.add(cliente);
		for (Cliente todos : listaClientes) {
			dtmLista.addRow(new String[] { String.valueOf(todos.getCpfCliente()), todos.getNomeCliente(),
					todos.getTelefone() });
		}

	}
	
	public void tabelaCliente() {
		
		dtmLista = new DefaultTableModel();
		dtmLista.addColumn("CPF");
		dtmLista.addColumn("Nome");
		dtmLista.addColumn("Telefone");

		// POPULANDO A TABELA

		jtTabela = new JTable(dtmLista);
		jtTabela.setBorder(new LineBorder(new Color(0, 0, 0)));
		jtTabela.getColumnModel().getColumn(0).setMaxWidth(150);
		jtTabela.getColumnModel().getColumn(1).setMaxWidth(220);
		jtTabela.getColumnModel().getColumn(2).setMaxWidth(150);

		scpCliente = new JScrollPane(jtTabela);
		scpCliente.setBounds(12, 215, 487, 39);
		frame.getContentPane().add(scpCliente);

	}

	
	public void criarBotoes(){
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherDadosTabelaFita();
			}
		});
		btnPesquisar.setBounds(145, 145, 97, 25);
		frame.getContentPane().add(btnPesquisar);

	}
	/**
	 * Create the application.
	 */
	public TelaPesquisaPorCidade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listaFilmes = new ArrayList<>();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		
		criarComboBox();
		criarJLabels();
		criarBotoes();
		tabelaCliente();
		
		frame.setBounds(100, 100, 541, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	}
}
