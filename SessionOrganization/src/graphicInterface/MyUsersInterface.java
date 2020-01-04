package graphicInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MyUsersInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyUsersInterface window = new MyUsersInterface();
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
	public MyUsersInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1006, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JButton btnNewButton = new  JButton("Name of the course");
		btnNewButton.setEnabled(false);

		btnNewButton.setBounds(23, 24, 116, 28);
		frame.getContentPane().add(btnNewButton);
		//On ajoute un label pour pouvoir ajouter une image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(new ImageIcon("file\\Python_MySession.png"));
		lblNewLabel.setBounds(341, 10, 641, 470);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblA = new JLabel("A+");
		lblA.setBackground(Color.GREEN);

		JButton btnAddACourse = new JButton("Add a course"); // toujours en derniere position Boutton pour ajouter un cour
		btnAddACourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseName.main();
				btnNewButton.setText(CourseName.courseName);
				btnNewButton.setEnabled(true);
				//lblNewLabel.setIcon(new ImageIcon("C:\\Beno\\Java\\SessionOrganization\\file\\"+CourseName.courseName+"_MySession.png"));
				lblNewLabel.setEnabled(true);
			}
		});
		btnAddACourse.setBounds(10, 519, 116, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//passage par argument de la commande à lancer
				String command = "cmd /c cd C:\\Users\\awous\\PycharmProjects\\ProjectCalculs\\MyProjectCalculs & pip install xlrd"
						+ "& python -m pip install numpy & python -m pip install matplotlib & Graph.py "+CourseName.courseName+
						" -m A+ & exit";
				StartCommand(command);
				lblNewLabel.setIcon(new ImageIcon("file\\"+CourseName.courseName+"_MySession.png"));
				lblNewLabel.setEnabled(true);
				btnNewButton.setText(CourseName.courseName);
				btnNewButton.setEnabled(true);
				//lblA.setText();
			}
		});
		frame.getContentPane().add(btnAddACourse);
		
		JLabel lblNewLabel_1 = new JLabel("Rating :");
		lblNewLabel_1.setBounds(341, 503, 39, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblA.setBounds(390, 506, 24, 17);
		frame.getContentPane().add(lblA);
		
		JButton btnChangeMyMarks = new JButton("Change my marks");
		btnChangeMyMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String command = "cmd /c cd C:\\Users\\awous\\PycharmProjects\\ProjectCalculs\\MyProjectCalculs\\SessionOrganization\\file & "+CourseName.courseName+"_"+"data.xlsx"
						+" & exit";
				StartCommand(command);
			}
		});
		btnChangeMyMarks.setBounds(463, 504, 162, 21);
		frame.getContentPane().add(btnChangeMyMarks);
		
		JButton btnViewMyWeeks = new JButton("View my weeks' organization");
		btnViewMyWeeks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//passage par argument de la commande à lancer
				String command = "cmd /c cd C:\\Users\\awous\\PycharmProjects\\ProjectCalculs\\MyProjectCalculs & "
						+ "Graph.py "+CourseName.courseName+
						" -t A+ & exit";
				StartCommand(command);
				lblNewLabel.setIcon(new ImageIcon("file\\"+CourseName.courseName+"_HoursBar.png"));
				lblNewLabel.setEnabled(true);
			}
		});
		btnViewMyWeeks.setBounds(635, 504, 175, 21);
		frame.getContentPane().add(btnViewMyWeeks);
	}
	public static void StartCommand(String command) {
		try {
			//creation du processus
			Process p = Runtime.getRuntime().exec(command);
			p.waitFor();
			InputStream in = p.getInputStream();

			//on récupère le flux de sortie du programme

			StringBuilder build = new StringBuilder();
			char c = (char) in.read();

			while (c != (char) -1) {
				build.append(c);
				c = (char) in.read();
			}

			String response = build.toString();

			//on l'affiche
			System.out.println(response);
		}
		catch (Exception e) {
			System.out.println("\n" + command + ": commande inconnu ");
		}
	}
}
