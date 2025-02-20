import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.sql.*
;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class JavaCrud {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField txtedicao;
	private JTextField txtpreco;
	private JTable table;
	private JTextField txtlid;

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
		Connect();
		table_load();
									
	}
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	
	
	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/projetocrud", "root", "M@7h3u$");
		} catch(ClassNotFoundException ex) {
			
		}catch(SQLException ex) {
			
		}
		
	}
	
	
	public void table_load() {
		try {
			pst = con.prepareStatement("select * from livro");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(127, 255, 212));
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
		
		txtedicao = new JTextField();
		txtedicao.setBounds(115, 80, 175, 20);
		panel.add(txtedicao);
		txtedicao.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Preço");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(10, 123, 95, 17);
		panel.add(lblNewLabel_1_1_1);
		
		txtpreco = new JTextField();
		txtpreco.setBounds(115, 122, 175, 20);
		panel.add(txtpreco);
		txtpreco.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lnome, edicao, preco;
				
				
				lnome = txtbname.getText();
				edicao = txtedicao.getText();
				preco = txtpreco.getText();
				
				
				try {
					pst = con.prepareStatement("insert into livro(nome, edicao, preco) values(?,?,?)");
					pst.setString(1, lnome);
					pst.setString(2, edicao);
					pst.setString(3, preco);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Titulo adicionado!");
					table_load();
					txtbname.setText("");
					txtedicao.setText("");
					txtpreco.setText("");
					txtbname.requestFocus();
				}catch(SQLException el) {
					el.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(32, 274, 89, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
						
				
			}
		});
		btnSair.setBounds(136, 274, 89, 40);
		frame.getContentPane().add(btnSair);
		
		JButton btnNewButton_1_1 = new JButton("Limpar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				txtbname.setText("");
				txtedicao.setText("");
				txtpreco.setText("");
				txtbname.requestFocus();
				
				
			}
		});
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
		
		txtlid = new JTextField();
		txtlid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					String id = txtlid.getText();
					
					pst = con.prepareStatement("select nome, edicao, preco from livro where id=?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next() == true) {
						String nome = rs.getString(1);
						String edicao = rs.getString(2);
						String preco = rs.getString(3);
						
						txtbname.setText(nome);
						txtedicao.setText(edicao);
						txtpreco.setText(preco);
					}else {
						txtbname.setText("");
						txtedicao.setText("");
						txtpreco.setText("");
					}
				}catch(SQLException ex) {
					
				}
				
								
				
			}
		});
		txtlid.setColumns(10);
		txtlid.setBounds(74, 24, 175, 20);
		panel_1.add(txtlid);
		
		JButton btnNewButton_1_1_1 = new JButton("Atualizar");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lnome, edicao, preco, lid;
				
				
				lnome = txtbname.getText();
				edicao = txtedicao.getText();
				preco = txtpreco.getText();
				lid = txtlid.getText();
				
				try {
					pst = con.prepareStatement("update livro set nome = ?, edicao = ?,preco = ? where id = ?");
					pst.setString(1, lnome);
					pst.setString(2, edicao);
					pst.setString(3, preco);
					pst.setString(4, lid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Titulo atualizado!");
					table_load();
					txtbname.setText("");
					txtedicao.setText("");
					txtpreco.setText("");
					txtbname.requestFocus();
				}catch(SQLException el) {
					el.printStackTrace();
				}
				
				
				
				
				
				
			}
		});
		btnNewButton_1_1_1.setBounds(427, 326, 89, 40);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Deletar");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lid;
				
				
				
				lid = txtlid.getText();
				
				try {
					pst = con.prepareStatement("delete from livro where id = ?");					
					pst.setString(1, lid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Titulo deletado!");
					table_load();
					txtbname.setText("");
					txtedicao.setText("");
					txtpreco.setText("");
					txtbname.requestFocus();
				}catch(SQLException el) {
					el.printStackTrace();
				}
				
																			
				
				
			}
		});
		btnNewButton_1_1_1_1.setBounds(526, 326, 89, 40);
		frame.getContentPane().add(btnNewButton_1_1_1_1);
	}
}
