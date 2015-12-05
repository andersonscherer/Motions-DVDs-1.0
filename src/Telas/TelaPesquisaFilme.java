package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TelaPesquisaFilme {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisaFilme window = new TelaPesquisaFilme();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPesquisaFilme() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPesquisaDeFilmes = new JLabel("Pesquisa de Filmes");
		lblPesquisaDeFilmes.setBounds(124, 29, 367, 46);
		lblPesquisaDeFilmes.setForeground(Color.ORANGE);
		lblPesquisaDeFilmes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 38));
		frame.getContentPane().add(lblPesquisaDeFilmes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 127, 589, 224);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"T\u00EDtulo do Filme", "Valor (R$)"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(283);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		scrollPane.setViewportView(table);
		
		JButton jbtGerarListaFilmes = new JButton("Gerar Lista de Filmes");
		jbtGerarListaFilmes.setBounds(42, 89, 160, 25);
		frame.getContentPane().add(jbtGerarListaFilmes);
		frame.setBounds(100, 100, 700, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
