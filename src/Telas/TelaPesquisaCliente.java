package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Dao.ClienteDAO;
import Jdbc.ClienteDAOJDBC;
import Model.Cliente;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaPesquisaCliente {

	private JFrame frame;
	private JRadioButton jrbPesquisaCpf;
	private JRadioButton jrbTodos;
	private JTextField jtfCpf;
	private JLabel jlbCpf;
	private Cliente cliente;
	
	private List<Cliente> listaClientes;

	private DefaultTableModel dtmLista;
	
	private JTable jtTabela;
	private JButton jbtPesquisar;
	private JButton btnNovaPesquisa;

	private ClienteDAO clienteDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisaCliente frame = new TelaPesquisaCliente();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void criarRadioButtons(){
		
		jrbPesquisaCpf = new JRadioButton("Pesquisar por Usuário");
		jrbPesquisaCpf.setBackground(Color.WHITE);
		jrbPesquisaCpf.setBounds(73, 166, 168, 25);
		frame.getContentPane().add(jrbPesquisaCpf);
		
		jrbTodos = new JRadioButton("Pesquisar TODOS");
		jrbTodos.setBackground(Color.WHITE);
		jrbTodos.setBounds(85, 134, 136, 25);
		frame.getContentPane().add(jrbTodos);
	
		ButtonGroup grupo = new ButtonGroup();  
		grupo.add(jrbPesquisaCpf);  
		grupo.add(jrbTodos);  

	}
	
	public void criarJLabels(){
		
		JLabel lblPesquisaDeCliente = new JLabel("Pesquisa de Cliente");
		lblPesquisaDeCliente.setBounds(178, 13, 432, 46);
		lblPesquisaDeCliente.setForeground(Color.ORANGE);
		lblPesquisaDeCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
		frame.getContentPane().add(lblPesquisaDeCliente);
		
		JLabel jlbTipoPesquisa = new JLabel("Escolha uma op\u00E7\u00E3o abaixo");
		jlbTipoPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbTipoPesquisa.setBounds(52, 83, 238, 21);
		frame.getContentPane().add(jlbTipoPesquisa);
		
		JLabel jlbLinha = new JLabel("______________________________________________________________________________________________");
		jlbLinha.setBounds(52, 260, 670, 16);
		frame.getContentPane().add(jlbLinha);
		
		jlbCpf = new JLabel("Digite o CPF do Cliente:");
		jlbCpf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbCpf.setVisible(false);
		jlbCpf.setBounds(368, 83, 177, 21);
		frame.getContentPane().add(jlbCpf);
	}
	
	public void criarJTfields(){
		jtfCpf = new JTextField();
		jtfCpf.setBounds(378, 135, 177, 22);
		jtfCpf.setVisible(false);
		frame.getContentPane().add(jtfCpf);
		jtfCpf.setColumns(10);


	}
	
	public void criarBotao(){
		JButton jbtEscolha = new JButton("Escolher");
		jbtEscolha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jrbPesquisaCpf.isSelected()){
					jlbCpf.setVisible(true);
					jtfCpf.setVisible(true);
					jbtPesquisar.setVisible(true);
				}else{
					preencherDadosTabelaSemFiltro();
				}
			}
		});
		jbtEscolha.setIcon(new ImageIcon("D:\\Faculdade\\Motions DVDs 1.0\\Motions DVDs 1.0\\Imagens\\icon-certo.gif"));
		jbtEscolha.setBounds(39, 220, 214, 38);
		frame.getContentPane().add(jbtEscolha);
		
		jbtPesquisar = new JButton("Pesquisar Cliente");
		jbtPesquisar.setIcon(new ImageIcon("D:\\Faculdade\\Motions DVDs 1.0\\Motions DVDs 1.0\\Imagens\\icone_lupa (1).png"));
		jbtPesquisar.setVisible(false);
		jbtPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherDadosTabelaCliente();
			}
		});
		jbtPesquisar.setBounds(393, 187, 162, 33);
		frame.getContentPane().add(jbtPesquisar);

		btnNovaPesquisa = new JButton("Nova Pesquisa");
		btnNovaPesquisa.setIcon(new ImageIcon("D:\\Faculdade\\Motions DVDs 1.0\\Motions DVDs 1.0\\Imagens\\arrow_right.png"));
		btnNovaPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtmLista.setNumRows(0);
			}
		});
		btnNovaPesquisa.setBounds(39, 289, 226, 38);
		frame.getContentPane().add(btnNovaPesquisa);
		
	}
	
	public void tabelaCliente() {
		dtmLista = new DefaultTableModel();
		dtmLista.addColumn("CPF");
		dtmLista.addColumn("Nome");
		dtmLista.addColumn("Telefone");
		
		// POPULANDO A TABELA

		jtTabela = new JTable(dtmLista);
		jtTabela.getColumnModel().getColumn(0).setMaxWidth(150);
		jtTabela.getColumnModel().getColumn(1).setMaxWidth(220);
		jtTabela.getColumnModel().getColumn(2).setMaxWidth(150);
	
		JScrollPane scpCliente_1 = new JScrollPane(jtTabela);
		scpCliente_1.setBounds(39, 335, 692, 186);
		frame.getContentPane().add(scpCliente_1);
	}
	
	public void preencherDadosTabelaCliente(){
		String cpf = jtfCpf.getText().toString();
		cliente = new Cliente();
		cliente = new ClienteDAOJDBC().buscar(cpf);
		listaClientes.add(cliente);
		for (Cliente todos : listaClientes) {
			dtmLista.addRow(
					new String[] { String.valueOf(todos.getCpfCliente()), todos.getNomeCliente(), todos.getTelefone()});
		}		
	}

	public void preencherDadosTabelaSemFiltro() {
		clienteDAO = new ClienteDAOJDBC();
		clienteDAO.todos().forEach(
				f -> dtmLista.addRow(new String[] { f.getCpfCliente().toString(), f.getNomeCliente().toString(), f.getTelefone().toString()  }));
	}
	
	/**
	 * Create the application.
	 */
	public TelaPesquisaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		listaClientes = new ArrayList<>();
		frame = new JFrame();
		
		criarBotao();
		criarJLabels();
		criarJTfields();
		criarRadioButtons();
		tabelaCliente();
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 807, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

	}
}
