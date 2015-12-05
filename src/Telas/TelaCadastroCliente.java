
package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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

import Dao.ClienteDAO;
import Formatacao.Mascara;
import Jdbc.CidadeDAOJDBC;
import Jdbc.ClienteDAOJDBC;
import Model.Cidade;
import Model.Cliente;

public class TelaCadastroCliente extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFormattedTextField jtfCpf;
	private JTextField jtfNome;
	private JTextField jtfRg;
	private JLabel jlbNome;
	private JLabel lblRg;
	private JFormattedTextField jtfDataNascimento;
	private JLabel lblDataDeNascimento;
	private JTextField jtfRua_1;
	private JLabel lblRua;
	private JTextField jtfNumero;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JTextField jtfBairro;
	private JLabel lblCidade;
	private JLabel lblRendaMensal;
	private JLabel jlbEstado;
	private JLabel jlbCadastroCliente;
	private JLabel jlbLinha;
	private JLabel jlbCpf;
	private JTextField jtfRendaMensal;
	private JFormattedTextField jtfTelefone;
	private JFormattedTextField jtfTelefone2;
	private JComboBox<Cidade> jComboCidade;
	private DefaultComboBoxModel<Cidade> dcmCidade;
	private JComboBox<String> jComboSexo;
	private JLabel lblComplemento;
	private JTextField jtfComplemento;
	int valor;
	int selecionado;
	private JTextField jtfEmail;
	String nomeCliente;
	String cpfCliente;
	
	private ClienteDAO clienteDAO = new ClienteDAOJDBC();
	private Cliente cliente = new Cliente();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroCliente() {
		initialize();
	}


	public void criarJLabel() {

		jlbNome = new JLabel("Nome:");
		jlbNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbNome.setBounds(27, 147, 56, 16);
		getContentPane().add(jlbNome);

		lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRg.setBounds(27, 211, 56, 16);
		getContentPane().add(lblRg);

		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataDeNascimento.setBounds(172, 211, 164, 16);
		getContentPane().add(lblDataDeNascimento);

		lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRua.setBounds(27, 274, 56, 16);
		getContentPane().add(lblRua);

		lblNumero = new JLabel("Numero da Casa:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumero.setBounds(270, 274, 137, 16);
		getContentPane().add(lblNumero);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBairro.setBounds(27, 338, 56, 16);
		getContentPane().add(lblBairro);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCidade.setBounds(27, 395, 56, 16);
		getContentPane().add(lblCidade);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon("D:\\Faculdade\\Motions DVDs 1.0\\Motions DVDs 1.0\\Imagens\\download.jpg"));
		lblImagem.setBounds(433, 47, 225, 271);
		getContentPane().add(lblImagem);

		jlbEstado = new JLabel("Telefone(1):");
		jlbEstado.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbEstado.setBounds(27, 430, 94, 16);
		getContentPane().add(jlbEstado);

		lblRendaMensal = new JLabel("Renda Mensal:");
		lblRendaMensal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRendaMensal.setBounds(27, 520, 121, 16);
		getContentPane().add(lblRendaMensal);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblComplemento.setBounds(252, 338, 137, 16);
		getContentPane().add(lblComplemento);
				
		jlbCadastroCliente = new JLabel("Cadastro de Cliente");
		jlbCadastroCliente.setForeground(Color.ORANGE);
		jlbCadastroCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
		jlbCadastroCliente.setBounds(27, 0, 390, 63);
		getContentPane().add(jlbCadastroCliente);
		
		jlbCpf = new JLabel("CPF:");
		jlbCpf.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbCpf.setBounds(27, 89, 44, 16);
		getContentPane().add(jlbCpf);
		

		jlbLinha = new JLabel("___________________________________________________________");
		jlbLinha.setBounds(24, 118, 413, 16);
		getContentPane().add(jlbLinha);
		
		JLabel lblTelefone = new JLabel("Telefone(2):");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefone.setBounds(295, 432, 94, 16);
		getContentPane().add(lblTelefone);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSexo.setBounds(252, 149, 56, 16);
		getContentPane().add(lblSexo);
		

		JLabel jlbEmail = new JLabel("E-mail:");
		jlbEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		jlbEmail.setBounds(27, 459, 94, 16);
		getContentPane().add(jlbEmail);
	}

	public void criarJtextFields() {
		jtfCpf = new JFormattedTextField(Mascara.getCpfMask());
		jtfCpf.setBackground(SystemColor.menu);
		jtfCpf.setColumns(10);
		jtfCpf.setBounds(70, 88, 137, 22);
		getContentPane().add(jtfCpf);
		
		jtfTelefone = new JFormattedTextField(Mascara.getTelefoneMask());
		jtfTelefone.setColumns(10);
		jtfTelefone.setBounds(125, 429, 154, 22);
		getContentPane().add(jtfTelefone);

		jtfTelefone2 = new JFormattedTextField(Mascara.getTelefoneMask());
		jtfTelefone2.setColumns(10);
		jtfTelefone2.setBounds(391, 429, 154, 22);
		getContentPane().add(jtfTelefone2);
		
		jtfRendaMensal = new JTextField();
		jtfRendaMensal.setColumns(10);
		jtfRendaMensal.setBounds(27, 549, 126, 22);
		getContentPane().add(jtfRendaMensal);

		jtfNome = new JTextField();
		jtfNome.setBounds(27, 176, 219, 22);
		getContentPane().add(jtfNome);
		jtfNome.setColumns(10);

		jtfRg = new JTextField();
		jtfRg.setColumns(10);
		jtfRg.setBounds(27, 240, 126, 22);
		getContentPane().add(jtfRg);

		jtfDataNascimento = new JFormattedTextField(Mascara.getDatas());
		jtfDataNascimento.setColumns(10);
		jtfDataNascimento.setBounds(172, 240, 157, 22);
		getContentPane().add(jtfDataNascimento);

		jtfRua_1 = new JTextField();
		jtfRua_1.setColumns(10);
		jtfRua_1.setBounds(27, 303, 219, 22);
		getContentPane().add(jtfRua_1);

		jtfNumero = new JTextField();
		jtfNumero.setColumns(10);
		jtfNumero.setBounds(270, 303, 106, 22);
		getContentPane().add(jtfNumero);

		jtfBairro = new JTextField();
		jtfBairro.setColumns(10);
		jtfBairro.setBounds(27, 360, 219, 22);
		getContentPane().add(jtfBairro);

		jtfComplemento = new JTextField();
		jtfComplemento.setColumns(10);
		jtfComplemento.setBounds(252, 360, 175, 22);
		getContentPane().add(jtfComplemento);
		
		jtfEmail = new JTextField();
		jtfEmail.setColumns(10);
		jtfEmail.setBounds(27, 485, 219, 22);
		getContentPane().add(jtfEmail);
		
	}

	public void criarComboBox() {
		dcmCidade = new DefaultComboBoxModel<Cidade>();
		
		List<Cidade> cidades = new CidadeDAOJDBC().todos();
		for (Cidade cd : cidades) {
			dcmCidade.addElement(cd);
		}
		
		jComboCidade = new JComboBox<Cidade>(dcmCidade);
		jComboCidade.setBounds(88, 394, 177, 22);
		getContentPane().add(jComboCidade);
		
		jComboSexo = new JComboBox<>();
        jComboSexo.addItem("Masculino");  
        jComboSexo.addItem("Feminino");  
		jComboSexo.setBounds(252, 178, 137, 22);
		getContentPane().add(jComboSexo);

	}

	public void criarBotao() {

		JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CADASTRAR CLIENTE
				cliente.setNomeCliente(jtfNome.getText());
				cliente.setCpfCliente(jtfCpf.getText());
				cliente.setSexo(jComboSexo.getSelectedItem().toString());
				cliente.setRegistroGeral(jtfRg.getText());
				cliente.setDataNascimento(LocalDate.now());
				cliente.setRua(jtfRua_1.getText());
				cliente.setNumero(jtfNumero.getText());
				cliente.setBairro(jtfBairro.getText());
				cliente.setComplemento(jtfComplemento.getText());
				cliente.setCidade((Cidade) dcmCidade.getSelectedItem());
				cliente.setTelefone(jtfTelefone.getText());
				cliente.setTelefone2(jtfTelefone2.getText());
				cliente.setEmail(jtfEmail.getText());
				cliente.setRendaMensal(Double.valueOf(jtfRendaMensal.getText()));
				clienteDAO.inserir(cliente);
				JOptionPane.showMessageDialog(null, "ok");
			
			}
		});
		btnCadastrarCliente.setBounds(37, 588, 177, 25);
		getContentPane().add(btnCadastrarCliente);

		JButton btnCancelarcadastro = new JButton("CancelarCadastro");
		btnCancelarcadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				//dispose();
			}
		});
		btnCancelarcadastro.setBounds(243, 588, 164, 25);
		getContentPane().add(btnCancelarcadastro);

	}

//	public Cliente getCliente() {
//		Cliente cliente = new Cliente();
//		cliente.setNomeCliente(jtfNome.getText());
//		cliente.setCpfCliente(jtfCpf.getText());
//		String sexo = (String) jComboSexo.getSelectedItem();
//		cliente.setSexo(sexo);
//		cliente.setRegistroGeral(jtfRg.getText());
//		cliente.setDataNascimento(LocalDate.now());
//		cliente.setRua(jtfRua_1.getText());
//		cliente.setNumero(jtfNumero.getText());
//		cliente.setBairro(jtfBairro.getText());
//		cliente.setComplemento(jtfComplemento.getText());
//		int selecionado = jComboCidade.getSelectedIndex();
//		cliente.setCidade(selecionado);
//		cliente.setTelefone(jtfTelefone.getText());
//		cliente.setTelefone2(jtfTelefone2.getText());
//		cliente.setEmail(jtfEmail.getText());
//		cliente.setRendaMensal(Double.valueOf(jtfRendaMensal.getText()));
//		
//		return cliente;
//	}
//
//	/**
//	 * Initialize the contents of the 
//	 */
	private void initialize() {
		setTitle("Fox Locadora - Cadastro Cliente");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 688, 719);

		criarJLabel();
		criarJtextFields();
		criarComboBox();
		criarBotao();
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
	}

}
