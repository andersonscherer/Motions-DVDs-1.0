package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Dao.LocacaoDAO;
import Formatacao.Mascara;
import Jdbc.ClienteDAOJDBC;
import Jdbc.FitaDAOJDBC;
import Jdbc.LocacaoJDBC;
import Model.Cliente;
import Model.Fita;
import Model.Locacao;

public class TelaLocacao extends JFrame {

	private static final long serialVersionUID = 1L;

	private LocacaoDAO locacaoDAO;

	private JFormattedTextField jtfCpfCliente;
	private JTextField jtfCodigoFilme;
	private JLabel jlbCpfCliente;
	private JLabel jlbLinha;
	private JLabel jlbCodigoFile;
	private JLabel jlbLinha2;
	private JLabel jlbDadosdaLocacao;
	private JLabel jlbCliente;

	private JScrollPane scpCliente;
	private JScrollPane scpFita;

	private Cliente cliente;

	private List<Cliente> listaClientes;
	private List<Fita> listaFilmes;

	private DefaultTableModel dtmListaFilmes;
	private DefaultTableModel dtmLista;

	private JTable jtTabelaFita;
	private JTable jtTabela;

	private JLabel jlbTitulo;
	private JButton btnConsultarFilme;
	private JButton jbtConsultarCliente;
	private JTextField jtfValorTotal;
	private JLabel lblPreoDaLocao;
	private JButton jbtLocar;
	private JButton jbtImprimirRelatorio;
	private JButton jbtCancelar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TelaLocacao();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void preencherDadosTabelaFita() {
		Integer codigoFita = (Integer.valueOf(jtfCodigoFilme.getText()));
		Fita fita = new FitaDAOJDBC().buscar(codigoFita);
		listaFilmes.add(fita);
		dtmListaFilmes.addRow(new String[] { String.valueOf(fita.getCodigo()),
				fita.getTitulo(), fita.getDiretor(), fita.getDuracao(),
				fita.getOrigem(), fita.getPrecoAluguel().toString(),
				fita.getStatus() });

	}

	public void preencherDadosTabelaCliente() {

		String cpf = jtfCpfCliente.getText().toString();
		cliente = new ClienteDAOJDBC().buscar(cpf);
		listaClientes.add(cliente);

		for (Cliente todos : listaClientes) {
			dtmLista.addRow(new String[] {
					String.valueOf(todos.getCpfCliente()),
					todos.getNomeCliente(), todos.getRegistroGeral(),
					todos.getDataNascimento().toString(),
					todos.getSexo().toString(), todos.getTelefone() });
		}
	}

	public void tabelaCliente() {
		dtmLista = new DefaultTableModel();
		dtmLista.addColumn("CPF");
		dtmLista.addColumn("Nome");
		dtmLista.addColumn("RG");
		dtmLista.addColumn("Data Nascimento");
		dtmLista.addColumn("Sexo");
		dtmLista.addColumn("Telefone");

		// POPULANDO A TABELA

		jtTabela = new JTable(dtmLista);
		jtTabela.getColumnModel().getColumn(0).setMaxWidth(110);
		jtTabela.getColumnModel().getColumn(1).setMaxWidth(140);
		jtTabela.getColumnModel().getColumn(2).setMaxWidth(90);
		jtTabela.getColumnModel().getColumn(3).setMaxWidth(90);
		jtTabela.getColumnModel().getColumn(4).setMaxWidth(90);
		jtTabela.getColumnModel().getColumn(5).setMaxWidth(100);
		scpCliente = new JScrollPane(jtTabela);
		scpCliente.setBounds(12, 210, 617, 39);
		getContentPane().add(scpCliente);

	}

	public void TabelaFita() {

		dtmListaFilmes = new DefaultTableModel();
		dtmListaFilmes.addColumn("Cód");
		dtmListaFilmes.addColumn("Titulo");
		dtmListaFilmes.addColumn("Diretor");
		dtmListaFilmes.addColumn("Duraç.");
		dtmListaFilmes.addColumn("Orig.");
		dtmListaFilmes.addColumn("Val.(R$)");
		dtmListaFilmes.addColumn("Status");

		jtTabelaFita = new JTable(dtmListaFilmes);
		jtTabelaFita.getColumnModel().getColumn(0).setMaxWidth(40);
		jtTabelaFita.getColumnModel().getColumn(1).setMaxWidth(150);
		jtTabelaFita.getColumnModel().getColumn(2).setMaxWidth(130);
		jtTabelaFita.getColumnModel().getColumn(3).setMaxWidth(70);
		jtTabelaFita.getColumnModel().getColumn(4).setMaxWidth(120);
		jtTabelaFita.getColumnModel().getColumn(5).setMaxWidth(50);
		jtTabelaFita.getColumnModel().getColumn(6).setMaxWidth(70);
		scpFita = new JScrollPane(jtTabelaFita);
		scpFita.setBounds(12, 385, 617, 138);
		getContentPane().add(scpFita);

	}

	public void criarJLabels() {
		jlbTitulo = new JLabel("Realizar Locação");
		jlbTitulo.setBounds(12, 13, 390, 55);
		jlbTitulo.setForeground(Color.ORANGE);
		jlbTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));

		jlbCpfCliente = new JLabel("Digite o CPF do cliente:");
		jlbCpfCliente.setBounds(12, 115, 174, 21);
		jlbCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jlbLinha = new JLabel(
				"_________________________________________________");
		jlbLinha.setBounds(106, 81, 449, 21);
		jlbLinha.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jlbCodigoFile = new JLabel("Digite o c\u00F3digo do Filme");
		jlbCodigoFile.setBounds(12, 274, 195, 21);
		jlbCodigoFile.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jlbLinha2 = new JLabel(
				"_________________________________________________");
		jlbLinha2.setBounds(106, 242, 449, 21);
		jlbLinha2.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jlbDadosdaLocacao = new JLabel("Dados do Cliente:");
		jlbDadosdaLocacao.setBounds(12, 184, 151, 21);
		jlbDadosdaLocacao.setFont(new Font("Tahoma", Font.PLAIN, 17));

		jlbCliente = new JLabel("Lista de Filmes:");
		jlbCliente.setBounds(12, 352, 133, 21);
		jlbCliente.setFont(new Font("Tahoma", Font.PLAIN, 17));

		lblPreoDaLocao = new JLabel("Pre\u00E7o da Loca\u00E7\u00E3o (R$)");
		lblPreoDaLocao.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPreoDaLocao.setBounds(12, 586, 270, 46);
		getContentPane().add(lblPreoDaLocao);

	}

	public void criarJTextFields() {

		jtfCpfCliente = new JFormattedTextField(Mascara.getCpfMask());
		jtfCpfCliente.setBounds(12, 149, 116, 22);
		jtfCpfCliente.setColumns(10);

		jtfCodigoFilme = new JTextField();
		jtfCodigoFilme.setBounds(12, 317, 116, 22);
		jtfCodigoFilme.setColumns(10);

		getContentPane().setLayout(null);
		getContentPane().add(jlbTitulo);
		getContentPane().add(jlbLinha);
		getContentPane().add(jlbCpfCliente);
		getContentPane().add(jtfCpfCliente);
		getContentPane().add(jbtConsultarCliente);
		getContentPane().add(jlbCodigoFile);
		getContentPane().add(jtfCodigoFilme);
		getContentPane().add(jlbCliente);
		getContentPane().add(jlbDadosdaLocacao);
		getContentPane().add(jlbLinha2);

	}

	public void criarBotao() {

		jbtConsultarCliente = new JButton("Consultar Cliente");
		jbtConsultarCliente.setBounds(160, 148, 162, 25);
		jbtConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherDadosTabelaCliente();
			}

		});

		btnConsultarFilme = new JButton("Adicionar Filme");
		btnConsultarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherDadosTabelaFita();

				jtfValorTotal = new JTextField();
				jtfValorTotal.setText(getTotalPedido(listaFilmes).toString());
				jtfValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 27));
				jtfValorTotal.setBounds(286, 584, 143, 49);
				getContentPane().add(jtfValorTotal);
				jtfValorTotal.setColumns(10);

			}
		});
		btnConsultarFilme.setBounds(140, 316, 162, 25);
		getContentPane().add(btnConsultarFilme);

		jbtLocar = new JButton("Gerar Loca\u00E7\u00E3o");
		jbtLocar.addActionListener(new ActionListener() {
			//SALVAR UMA LOCAÇÃO
			public void actionPerformed(ActionEvent e) {
				for (Fita fita : listaFilmes) {
					Locacao locacao = new Locacao();
					locacao.setCliente(cliente);
					locacao.setvalorTotal(getTotalPedido(listaFilmes));
					locacao.setDataLocacao(LocalDate.now());
					locacao.setFita(fita);
					locacaoDAO.inserir(locacao);
					JOptionPane.showMessageDialog(null, "OK");
				}
			}
		});
		jbtLocar.setBounds(84, 681, 151, 25);
		getContentPane().add(jbtLocar);

		jbtImprimirRelatorio = new JButton("Imprimir Relat\u00F3rio");
		jbtImprimirRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtImprimirRelatorio.setBounds(282, 681, 145, 25);
		getContentPane().add(jbtImprimirRelatorio);

		jbtCancelar = new JButton("Cancelar");
		jbtCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jbtCancelar.setBounds(485, 742, 97, 25);
		getContentPane().add(jbtCancelar);
	}

	public Double getTotalPedido(List<Fita> fitas) {
		Double total = 0.0;
		if (!fitas.isEmpty()) {
			for (Fita p : fitas) {
				total += p.getPrecoAluguel();
			}
			return total;
		}
		return total;
	}

	public TelaLocacao() {
		locacaoDAO = new LocacaoJDBC();
		initialize();
	}

	private void initialize() {
		listaClientes = new ArrayList<>();
		listaFilmes = new ArrayList<>();

		getContentPane().setBackground(Color.WHITE);
		setTitle("Fox Locadora - Realizar Locação");
		setBounds(100, 100, 677, 839);

		TabelaFita();
		tabelaCliente();
		criarJLabels();
		criarBotao();
		criarJTextFields();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
