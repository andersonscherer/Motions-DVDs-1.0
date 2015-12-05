package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;

import Dao.FitaDAO;
import Formatacao.Mascara;
import Jdbc.FitaDAOJDBC;
import Jdbc.GenerosFilmeDAOJDBC;
import Model.Fita;
import Model.GenerosFilme;

public class TelaCadastrodeFita extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTextField jtfTitulo;
	private JTextField jtfDiretor;
	private JTextField jtfDuracao;
	private JTextField jtfOrigem;
	private JTextField jtfValor;
	private JLabel lblGnero;
	private JComboBox<GenerosFilme> jcbGenero;
	private DefaultComboBoxModel<GenerosFilme> dcmGenero;
	private JTextField jtfCodigodaFita;
	private JFormattedTextField jtfDataLancamento;
	private JLabel jlbCodigodaFita;
	private JLabel jlbLinha;
	private JLabel jlbDinheiro;
	private JLabel jlbMin;
	private JLabel jlbImagem;
	private JLabel jlbCadastroFilmes;
	private JLabel jlbTitulo;
	private JTextPane txpSinopse;

	private FitaDAO fitaDAO= new FitaDAOJDBC();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastrodeFita window = new TelaCadastrodeFita();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastrodeFita() {
		initialize();
	}

	public void criarJlabels() {

		JLabel lblSinopse = new JLabel("Sinopse:");
		lblSinopse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSinopse.setBounds(12, 284, 133, 21);
		getContentPane().add(lblSinopse);

		JLabel lblDiretor = new JLabel("Diretor:");
		lblDiretor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDiretor.setBounds(12, 486, 120, 21);
		getContentPane().add(lblDiretor);

		JLabel lblDurao = new JLabel("Dura\u00E7\u00E3o:");
		lblDurao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDurao.setBounds(12, 540, 68, 21);
		getContentPane().add(lblDurao);

		JLabel lblOrigem = new JLabel("Origem:");
		lblOrigem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblOrigem.setBounds(200, 540, 133, 21);
		getContentPane().add(lblOrigem);

		JLabel lblValor = new JLabel("Valor do Aluguel:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblValor.setBounds(12, 591, 150, 21);
		getContentPane().add(lblValor);

		JLabel lblAno = new JLabel("Data de Lan\u00E7amento:");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAno.setBounds(12, 224, 160, 21);
		getContentPane().add(lblAno);

		lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGnero.setBounds(254, 190, 59, 21);
		getContentPane().add(lblGnero);

		jlbMin = new JLabel("Min.");
		jlbMin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbMin.setBounds(78, 562, 54, 21);
		getContentPane().add(jlbMin);

		jlbImagem = new JLabel("New label");
		jlbImagem
				.setIcon(new ImageIcon(
						"D:\\Faculdade\\Motions DVDs 1.0\\Motions DVDs 1.0\\Imagens\\filme(1).jpg"));
		jlbImagem.setBounds(522, 473, 286, 261);
		getContentPane().add(jlbImagem);

		jlbTitulo = new JLabel("T\u00EDtulo do Filme:");
		jlbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbTitulo.setBounds(12, 169, 142, 21);
		getContentPane().add(jlbTitulo);

		jlbCadastroFilmes = new JLabel("Cadastro de Filmes");
		jlbCadastroFilmes.setForeground(Color.ORANGE);
		jlbCadastroFilmes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				38));
		jlbCadastroFilmes.setBounds(54, 13, 390, 71);
		getContentPane().add(jlbCadastroFilmes);

		jlbLinha = new JLabel("______________________________________________");
		jlbLinha.setBounds(26, 140, 335, 16);
		getContentPane().add(jlbLinha);

		jlbCodigodaFita = new JLabel("C\u00F3digo da Fita:");
		jlbCodigodaFita.setFont(new Font("Tahoma", Font.BOLD, 17));
		jlbCodigodaFita.setBounds(12, 97, 133, 21);
		getContentPane().add(jlbCodigodaFita);

		jlbDinheiro = new JLabel("R$:");
		jlbDinheiro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbDinheiro.setBounds(12, 621, 28, 21);
		getContentPane().add(jlbDinheiro);

	}

	public void criarJTextFields() {
		jtfTitulo = new JTextField();
		jtfTitulo.setBounds(12, 193, 230, 22);
		getContentPane().add(jtfTitulo);
		jtfTitulo.setColumns(10);

		jtfDiretor = new JTextField();
		jtfDiretor.setColumns(10);
		jtfDiretor.setBounds(12, 507, 217, 22);
		getContentPane().add(jtfDiretor);

		jtfDuracao = new JTextField();
		jtfDuracao.setColumns(10);
		jtfDuracao.setBounds(12, 562, 54, 22);
		getContentPane().add(jtfDuracao);

		jtfOrigem = new JTextField();
		jtfOrigem.setColumns(10);
		jtfOrigem.setBounds(199, 563, 217, 22);
		getContentPane().add(jtfOrigem);

		jtfValor = new JTextField();
		jtfValor.setColumns(10);
		jtfValor.setBounds(39, 622, 133, 22);
		getContentPane().add(jtfValor);

		txpSinopse = new JTextPane();
		txpSinopse.setBackground(UIManager.getColor("Button.background"));
		txpSinopse.setForeground(Color.BLACK);
		txpSinopse.setBounds(33, 318, 763, 155);
		getContentPane().add(txpSinopse);

		jtfCodigodaFita = new JTextField();
		jtfCodigodaFita.setBounds(12, 119, 116, 22);
		getContentPane().add(jtfCodigodaFita);
		jtfCodigodaFita.setColumns(10);

		jtfDataLancamento = new JFormattedTextField(Mascara.getDatas());
		jtfDataLancamento.setColumns(10);
		jtfDataLancamento.setBounds(12, 249, 160, 22);
		getContentPane().add(jtfDataLancamento);

	}

	public void criarJComboBox() {
		dcmGenero = new DefaultComboBoxModel<GenerosFilme>();
		
		List<GenerosFilme> generos = new GenerosFilmeDAOJDBC().todos();
		for (GenerosFilme gf : generos) {
			dcmGenero.addElement(gf);
		}
		
		jcbGenero = new JComboBox<GenerosFilme>(dcmGenero);
		jcbGenero.setBounds(314, 191, 160, 22);
		getContentPane().add(jcbGenero);
	}

	public void criarBotoes() {

		JButton jbtCadastrarFilme = new JButton("Cadastrar Filme");
		jbtCadastrarFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CADASTRA FITA
				Fita fita = new Fita();
				fita.setTitulo(jtfTitulo.getText());
				fita.setGenero((GenerosFilme)dcmGenero.getSelectedItem());
				fita.setDataLancamento(LocalDate.parse(jtfDataLancamento.getText(), Mascara.formatadorDatas()));
				fita.setSinopse(txpSinopse.getText());
				fita.setDiretor(jtfDiretor.getText());
				fita.setDuracao(jtfDuracao.getText());
				fita.setOrigem(jtfOrigem.getText());
				fita.setAno("1996");
				fita.setPrecoAluguel(Double.valueOf(jtfValor.getText()));
				fita.setStatus("ATIVO");
				fitaDAO.inserir(fita);
				JOptionPane.showMessageDialog(null, "OK");
			}
		});
		jbtCadastrarFilme
				.setIcon(new ImageIcon(
						"D:\\Faculdade\\Motions DVDs 1.0\\Motions DVDs 1.0\\Imagens\\icon-certo.gif"));
		jbtCadastrarFilme.setBounds(12, 677, 230, 44);
		getContentPane().add(jbtCadastrarFilme);

		JButton btnCancelarcadastro = new JButton("CancelarCadastro");
		btnCancelarcadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		btnCancelarcadastro
				.setIcon(new ImageIcon(
						"D:\\Faculdade\\Motions DVDs 1.0\\Motions DVDs 1.0\\Imagens\\Cancelar.jpg"));
		btnCancelarcadastro.setBounds(268, 677, 230, 44);
		getContentPane().add(btnCancelarcadastro);

	}

	private void initialize() {
		setTitle("Fox Locadora - Cadastro de Filme");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 826, 781);

		criarBotoes();
		criarJComboBox();
		criarJlabels();
		criarJTextFields();

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

	}
}
