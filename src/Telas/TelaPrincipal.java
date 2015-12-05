package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TelaPrincipal extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
    private JMenu jmRealizarLocacao;
    private JMenu jmPesquisa;
    private JMenu jmRelatrio;
    private JMenu jmCadastros;
    private JMenuItem jmiLocar;
    private JMenuItem jmiCadastrarCliente;
    private JMenuItem jmiCadastrarFita;
    private JMenuItem jmiConsultarCadastro;
    private JMenuItem jmiSituacaoCliente;
    private JMenuItem jmiPesquisaFilme;
    private JMenuItem jmiClientesPorCidade;
    private JMenuItem jmiCliente;
    private JMenuItem jmiVenda;
    
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TelaPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public void criarJMenu(){

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		jmRealizarLocacao = new JMenu("Locar Filme");
		menuBar.add(jmRealizarLocacao);
		
		jmiLocar = new JMenuItem("Locar");
		jmiLocar.addActionListener(this);
		jmRealizarLocacao.add(jmiLocar);
		jmiLocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLocacao tela = new TelaLocacao();
				tela.setVisible(true);
				//dispose();
			}
		});
		
		
		jmCadastros = new JMenu("Cadastros");
		menuBar.add(jmCadastros);
		
		jmiCadastrarCliente = new JMenuItem("Cadastrar Cliente");
		jmiCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCliente();
				//dispose();
			}
		});
		jmCadastros.add(jmiCadastrarCliente);
		
		jmiCadastrarFita = new JMenuItem("Cadastrar Filme");
		jmiCadastrarFita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrodeFita tela = new TelaCadastrodeFita();
				tela.setVisible(true);
				//dispose();
			}
		});
		jmCadastros.add(jmiCadastrarFita);
		
		jmiConsultarCadastro = new JMenuItem("Consultar Cadastro");
		jmiConsultarCadastro.addActionListener(this);
		jmCadastros.add(jmiConsultarCadastro);
		
		jmPesquisa = new JMenu("Pesquisar");
		menuBar.add(jmPesquisa);
		
		jmiSituacaoCliente = new JMenuItem("Situa\u00E7\u00E3o Cliente");
		jmiSituacaoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				//dispose();
			}
		});
		jmPesquisa.add(jmiSituacaoCliente);
		
		jmiPesquisaFilme = new JMenuItem("Pesquisar Filmes");
		jmiPesquisaFilme.addActionListener(this);
		jmPesquisa.add(jmiPesquisaFilme);
		
		jmRelatrio = new JMenu("Relat\u00F3rio");
		menuBar.add(jmRelatrio);
		
		jmiClientesPorCidade = new JMenuItem("Relatorio de Clientes");
		jmiClientesPorCidade.addActionListener(this);
		jmRelatrio.add(jmiClientesPorCidade);
		
		jmiCliente = new JMenuItem("Cliente");
		jmiCliente.addActionListener(this);
		jmRelatrio.add(jmiCliente);
		
		jmiVenda = new JMenuItem("Venda na Data");
		jmiVenda.addActionListener(this);
		jmRelatrio.add(jmiVenda);
		getContentPane().setLayout(null);
	}
	
	public void criarJLabel(){
		JLabel jlbLogo = new JLabel("New label");
		jlbLogo.setIcon(new ImageIcon("D:\\Faculdade\\Motions DVDs 1.0\\Imagens\\logo_fox.png"));
		jlbLogo.setBounds(476, 67, 359, 391);
		getContentPane().add(jlbLogo);
		
		JLabel jlbNome = new JLabel("Fox");
		jlbNome.setForeground(Color.RED);
		jlbNome.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 96));
		jlbNome.setBounds(105, 139, 215, 116);
		getContentPane().add(jlbNome);
		
		JLabel jlbLocadora = new JLabel("Locadora");
		jlbLocadora.setForeground(Color.BLACK);
		jlbLocadora.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 76));
		jlbLocadora.setBounds(39, 250, 343, 125);
		getContentPane().add(jlbLocadora);
	}
	
	public TelaPrincipal() {
		iniciarTelaPrincipal();
	}

	/**
	 * Initialize the contents of the 
	 */
	public void iniciarTelaPrincipal() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Fox Locadora");
		setBounds(100, 100, 877, 544);
		
		criarJMenu();
		criarJLabel();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
