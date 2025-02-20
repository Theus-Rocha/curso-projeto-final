import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JavaCrud {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
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
	public JavaCrud() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Desk");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(260, 11, 207, 63);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 85, 340, 178);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Livro");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 32, 95, 17);
		panel.add(lblNewLabel_1);
		
		txtbname = new JTextField();
		txtbname.setBounds(115, 31, 175, 20);
		panel.add(txtbname);
		txtbname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edição");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(10, 81, 95, 17);
		panel.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 80, 175, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Preço");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 123, 95, 17);
		panel.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(115, 122, 175, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(32, 274, 89, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setBounds(136, 274, 89, 40);
		frame.getContentPane().add(btnSair);
		
		JButton btnNewButton_1_1 = new JButton("Limpar");
		btnNewButton_1_1.setBounds(235, 274, 89, 40);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(377, 85, 297, 230);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pesquisa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 0)));
		panel_1.setBounds(22, 325, 340, 55);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("ID_Livro");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_2.setBounds(10, 25, 95, 17);
		panel_1.add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(74, 24, 175, 20);
		panel_1.add(textField);
		
		JButton btnNewButton_1_1_1 = new JButton("Atualizar");
		btnNewButton_1_1_1.setBounds(427, 326, 89, 40);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Deletar");
		btnNewButton_1_1_1_1.setBounds(526, 326, 89, 40);
		frame.getContentPane().add(btnNewButton_1_1_1_1);
	}
}
