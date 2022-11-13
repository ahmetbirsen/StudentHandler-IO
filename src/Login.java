import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JTextField password;
	JPanel secondPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(32, 51, 71, 14);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(100, 48, 86, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setBounds(33, 91, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			String messageTrue = "Login Succesfully";
			String messageFalse = "Wrong user or password .";
			public void actionPerformed(ActionEvent arg0) {
				
				if(user.getText().equals("admin")&& password.getText().equals("12345")) {
					JOptionPane.showMessageDialog(null,"You Login Successfull","Login",JOptionPane.PLAIN_MESSAGE);
					secondPanel.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Wrong user or password","Login",JOptionPane.PLAIN_MESSAGE);
				}
					
			}
		});
		
		Login.setBounds(80, 174, 89, 23);
		contentPane.add(Login);
		
		JButton Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		Exit.setBounds(80, 273, 89, 23);
		contentPane.add(Exit);
		
		password = new JTextField();
		password.setBounds(100, 88, 86, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		secondPanel = new JPanel();
		secondPanel.setBounds(240, 64, 169, 230);
		contentPane.add(secondPanel);
		secondPanel.setLayout(null);
		secondPanel.setVisible(false);
		
		JButton register = new JButton("Student Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				studentForm stf = new studentForm();
				stf.setVisible(true);
				dispose();
				
			}
		});
		register.setBounds(10, 43, 149, 48);
		secondPanel.add(register);
		
		JButton stuList = new JButton("Student List");
		stuList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListPage lsg = new ListPage();
				lsg.setVisible(true);
				dispose();
			}
		});
		stuList.setBounds(10, 149, 149, 48);
		secondPanel.add(stuList);
	}
}
