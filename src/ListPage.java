import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ListPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtList;
	private JTextField txt_read;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPage frame = new ListPage();
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
	public ListPage() {
		setTitle("List Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student List");
		lblNewLabel.setBounds(21, 51, 81, 14);
		contentPane.add(lblNewLabel);
		
		txtList = new JTextField();
		txtList.setBounds(10, 76, 170, 256);
		contentPane.add(txtList);
		txtList.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("File Name");
		lblNewLabel_1.setBounds(265, 51, 53, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_read = new JTextField();
		txt_read.setBounds(252, 76, 116, 30);
		contentPane.add(txt_read);
		txt_read.setColumns(10);
		
		JButton readBotton = new JButton("Read File");
		readBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileReader readFile = new FileReader("C:\\Users\\ahmet\\Desktop\\"+txt_read.getText()+".txt");
					txtList.read(readFile,"C:\\Users\\ahmet\\Desktop\\"+txt_read.getText()+".txt");
					readFile.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		
		readBotton.setBounds(249, 117, 119, 23);
		contentPane.add(readBotton);
		
		JButton backBotton = new JButton("Back");
		backBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
			}
		});
		backBotton.setBounds(265, 255, 89, 23);
		contentPane.add(backBotton);
		
		JButton exitBotton = new JButton("Exit");
		exitBotton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBotton.setBounds(265, 313, 89, 23);
		contentPane.add(exitBotton);
	}

}
