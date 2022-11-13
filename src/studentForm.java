import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class studentForm extends JFrame {

	ArrayList<Student> studentList = new ArrayList<>();
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_surname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txt_file;
	JSlider slider = new JSlider();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentForm frame = new studentForm();
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
	public studentForm() {
		setTitle("Student Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(10, 26, 46, 14);
		contentPane.add(lblNewLabel);
		
		txt_name = new JTextField();
		txt_name.setBounds(66, 23, 86, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname :");
		lblNewLabel_1.setBounds(10, 71, 59, 14);
		contentPane.add(lblNewLabel_1);
		
		txt_surname = new JTextField();
		txt_surname.setBounds(68, 68, 86, 20);
		contentPane.add(txt_surname);
		txt_surname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Birth Year :");
		lblNewLabel_2.setBounds(10, 155, 59, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox birthYearBox = new JComboBox();
		birthYearBox.setBounds(68, 151, 59, 22);
		contentPane.add(birthYearBox);
		
		JLabel lblNewLabel_3 = new JLabel("City  :");
		lblNewLabel_3.setBounds(10, 221, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JComboBox cityBox = new JComboBox();
		cityBox.setModel(new DefaultComboBoxModel(new String[] {"Istanbul", "Ankara", "Izmir", "Antalya"}));
		cityBox.setBounds(67, 217, 87, 22);
		contentPane.add(cityBox);
		
		JLabel lblNewLabel_4 = new JLabel("Department :");
		lblNewLabel_4.setBounds(259, 26, 70, 14);
		contentPane.add(lblNewLabel_4);
		
		JComboBox courseBox = new JComboBox();
		courseBox.setBounds(335, 129, 89, 22);
		contentPane.add(courseBox);
		
		JRadioButton computing = new JRadioButton("Computing");
		computing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseBox.setModel(new DefaultComboBoxModel(new String[] {"Web Design","DataBase","Java"}));
			}
		});
		buttonGroup.add(computing);
		computing.setBounds(335, 22, 109, 23);
		contentPane.add(computing);
		
		JRadioButton literature = new JRadioButton("Literature");
		literature.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				courseBox.setModel(new DefaultComboBoxModel(new String[] {"Poetry","Drame","Novel"}));
			}
		});
		buttonGroup.add(literature);
		literature.setBounds(335, 67, 109, 23);
		contentPane.add(literature);
		
		JLabel lblNewLabel_5 = new JLabel("Course :");
		lblNewLabel_5.setBounds(259, 133, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login log = new Login();
				log.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(63, 381, 89, 23);
		contentPane.add(backButton);
		
		JButton listButton = new JButton("List Page");
		listButton.setBounds(191, 381, 89, 23);
		contentPane.add(listButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitButton.setBounds(335, 415, 109, 23);
		contentPane.add(exitButton);
		
		
		JButton saveButton = new JButton("Save to File");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileWriter saveFile = new FileWriter("C:\\Users\\ahmet\\Desktop\\"+txt_file.getText()+".txt");
					BufferedWriter bufferWriter = new BufferedWriter(saveFile);
					bufferWriter.write("Student Name : "+txt_name.getText());
					bufferWriter.newLine();
					bufferWriter.write("Student Surname : "+txt_surname.getText());
					bufferWriter.newLine();
					bufferWriter.write("Student Birth Year : "+String.valueOf(birthYearBox.getSelectedItem()));
					bufferWriter.newLine();
					bufferWriter.write("City : "+cityBox.getSelectedItem());
					bufferWriter.newLine();
					bufferWriter.write("Year of Study : "+String.valueOf(slider.getValue()));
					bufferWriter.newLine();
					bufferWriter.write("Department : "+String.valueOf(buttonGroup.getSelection()));
					bufferWriter.newLine();
					bufferWriter.write("Course : "+courseBox.getSelectedItem());
					bufferWriter.newLine();
					bufferWriter.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		saveButton.setBounds(335, 381, 109, 23);
		contentPane.add(saveButton);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("File Name");
		lblNewLabel_6.setBounds(488, 369, 86, 14);
		contentPane.add(lblNewLabel_6);
		
		txt_file = new JTextField();
		txt_file.setBounds(488, 394, 86, 20);
		contentPane.add(txt_file);
		txt_file.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Year of Study :");
		lblNewLabel_7.setBounds(10, 287, 86, 20);
		contentPane.add(lblNewLabel_7);
		
		JButton addButton = new JButton("Add to List");
		JList list = new JList();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = txt_name.getText();
				String surname = txt_surname.getText();
				String birthYear = String.valueOf(birthYearBox.getSelectedItem());
				String city = (String) cityBox.getSelectedItem();
				String yearStudy = String.valueOf(slider.getValue());
				String department = String.valueOf(buttonGroup.getSelection());
				String course = (String) courseBox.getSelectedItem();
				
				Student student = new Student(name, surname, birthYear, city, yearStudy, department, course);
				studentList.add(student);
				
				for(Student x: studentList) {
					String [] array = {(x.name+" "+x.surname)};
					list.setVisible(false);
					JList stuList = new JList(array);
					stuList.setBounds(488, 26, 183, 289);
					contentPane.add(stuList);
					
				}
				
			}
		});
		addButton.setBounds(335, 286, 89, 23);
		contentPane.add(addButton);
		
		
		list.setBounds(488, 25, 183, 289);
		contentPane.add(list);
		slider.setValue(0);
		slider.setMajorTickSpacing(3);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(4);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(91, 269, 200, 45);
		contentPane.add(slider);
	
		for(int i = 1960 ; i < 2001 ; i++) {
			
			birthYearBox.addItem(i);
		}
	}
}
