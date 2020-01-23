package graphicInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Font;

/**
 * This is the principal interface of our users .
 * It make with :
 * 				 button to add courses
 * 				 A label to show the graphics
 * 				 A button to change marks
 * 				 A button to change the view of the graph(Switch between hours and marks)
 * 				 A label to show the rating of the courses
 * 
 * @author  Dietz-Bénony AWOUSSI
 * @version 1.0
 * @since   2019-12-24	 
 */
public class MyUsersInterface {

	private JFrame frmMyPlan;
	public static int nbCourse = 1;
	public static int course1 = 0;
	public static int course2 = 0;
	public static int course3 = 0;
	public static int course4 = 0;
	public static int course5 = 0;
	public static int course6 = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyUsersInterface window = new MyUsersInterface();
					window.frmMyPlan.setVisible(true);
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
		frmMyPlan = new JFrame();
		frmMyPlan.setTitle("My Plan");
		frmMyPlan.setBounds(100, 100, 1006, 601);
		frmMyPlan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyPlan.getContentPane().setLayout(null);
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(85, 384, 162, 11);
		frmMyPlan.getContentPane().add(progressBar);
		
		JButton btnLoadSession = new JButton("Load Session");
		btnLoadSession.setBackground(new Color(255, 0, 255));
		btnLoadSession.setBounds(820, 504, 132, 32);
		frmMyPlan.getContentPane().add(btnLoadSession);


		//this button will be use to add new courses to the student session
		JButton btnNewButton = new  JButton("Name of the course");
		btnNewButton.setEnabled(false);

		btnNewButton.setBounds(23, 24, 116, 32);
		frmMyPlan.getContentPane().add(btnNewButton);

		JButton btnCourse = new JButton("Course_2");
		btnCourse.setEnabled(false);
		btnCourse.setBounds(199, 21, 116, 35);
		frmMyPlan.getContentPane().add(btnCourse);

		JButton btnCourse_1 = new JButton("Course_3");
		btnCourse_1.setEnabled(false);
		btnCourse_1.setBounds(23, 100, 116, 35);
		frmMyPlan.getContentPane().add(btnCourse_1);

		JButton btnCourse_2 = new JButton("Course_4");
		btnCourse_2.setEnabled(false);
		btnCourse_2.setBounds(199, 100, 116, 35);
		frmMyPlan.getContentPane().add(btnCourse_2);

		JButton btnCourse_3 = new JButton("Course_5");
		btnCourse_3.setEnabled(false);
		btnCourse_3.setBounds(23, 191, 116, 35);
		frmMyPlan.getContentPane().add(btnCourse_3);

		JButton btnCourse_4 = new JButton("Course_6");
		btnCourse_4.setEnabled(false);
		btnCourse_4.setBounds(199, 191, 116, 35);
		frmMyPlan.getContentPane().add(btnCourse_4);
		//On ajoute un label pour pouvoir ajouter une image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/thermo2_MySession.png")));
		lblNewLabel.setBounds(341, 10, 641, 470);
		frmMyPlan.getContentPane().add(lblNewLabel);

		// this label is set for the rating of the courses. It will upgrade as soon as the student change his marks
		JLabel lblA = new JLabel("A+");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblA.setForeground(Color.GREEN);
		lblA.setBackground(Color.GREEN);

		//Button add courses to permit the student to add new courses to his session
		JButton btnAddACourse = new JButton("Add a course"); // toujours en derniere position Boutton pour ajouter un cour
		btnAddACourse.setBackground(new Color(51, 255, 51));
		btnAddACourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(nbCourse) {
				case 1:
				{
					CourseName.main();
					btnNewButton.setText(CourseName.courseName);
					btnNewButton.setEnabled(true);
					lblNewLabel.setEnabled(true);
					break;
				}
				case 2:
				{
					CourseName.main();
					btnCourse.setText(CourseName.courseName);
					btnCourse.setEnabled(true);
					lblNewLabel.setEnabled(true);
					break;
				}

				case 3:
				{
					CourseName.main();
					btnCourse_1.setText(CourseName.courseName);
					btnCourse_1.setEnabled(true);
					lblNewLabel.setEnabled(true);
					break;
				}

				case 4:
				{
					CourseName.main();
					btnCourse_2.setText(CourseName.courseName);
					btnCourse_2.setEnabled(true);
					lblNewLabel.setEnabled(true);
					break;
				}

				case 5:
				{
					CourseName.main();
					btnCourse_3.setText(CourseName.courseName);
					btnCourse_3.setEnabled(true);
					lblNewLabel.setEnabled(true);
					break;
				}

				case 6:
				{
					CourseName.main();
					btnCourse_4.setText(CourseName.courseName);
					btnCourse_4.setEnabled(true);
					lblNewLabel.setEnabled(true);
					progressBar.setForeground(Color.RED);
					break;
				}
				default:
					btnAddACourse.setBackground(Color.RED);
					progressBar.setForeground(Color.RED);
					System.out.println("You can only add six courses for the moment");// Will be replace with a label
				}
				
				nbCourse++;
				progressBar.setValue(nbCourse*10);
			}
		});
		btnAddACourse.setBounds(85, 337, 162, 46);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course1 == 0)
				{
					InnitButton(btnNewButton, lblNewLabel);
				}
				else
				{
					CourseName.courseName = btnNewButton.getText();
					InnitButton(btnNewButton, lblNewLabel);
				}
				course1++;
			}
		});
		frmMyPlan.getContentPane().add(btnAddACourse);

		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(course2 == 0)
				{
					InnitButton(btnCourse, lblNewLabel);
				}
				else
				{
					CourseName.courseName = btnCourse.getText();
					InnitButton(btnCourse, lblNewLabel);
				}
				course2++;
			}
		});

		btnCourse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course3 == 0)
				{
					InnitButton(btnCourse_1, lblNewLabel);
				}
				else
				{
					CourseName.courseName = btnCourse_1.getText();
					InnitButton(btnCourse_1, lblNewLabel);
				}
				course3++;			
			}
		});

		btnCourse_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course4 == 0)
				{
					InnitButton(btnCourse_2, lblNewLabel);
				}
				else
				{
					CourseName.courseName = btnCourse_2.getText();
					InnitButton(btnCourse_2, lblNewLabel);
				}
				course4++;			
			}
		});

		btnCourse_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course5 == 0)
				{
					InnitButton(btnCourse_3, lblNewLabel);
				}
				else
				{
					CourseName.courseName = btnCourse_3.getText();
					InnitButton(btnCourse_3, lblNewLabel);
				}
				course5++;	
			}
		});

		btnCourse_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course6 == 0)
				{
					InnitButton(btnCourse_4, lblNewLabel);
				}
				else
				{
					CourseName.courseName = btnCourse_4.getText();
					InnitButton(btnCourse_4, lblNewLabel);
				}
				course6++;
			}
		});
		// Label of the rating
		JLabel lblNewLabel_1 = new JLabel("Rating :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(328, 503, 63, 33);
		frmMyPlan.getContentPane().add(lblNewLabel_1);

		lblA.setBounds(390, 506, 40, 30);
		frmMyPlan.getContentPane().add(lblA);

		// This button will help the users to correct or change their marks in the excel file

		JButton btnChangeMyMarks = new JButton("Change my marks");
		btnChangeMyMarks.setBackground(new Color(222, 184, 135));
		btnChangeMyMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//We simply open the excel sheet
				String command = "cmd /c cd res\\image\\ & "+CourseName.courseName+"_"+"data.xlsx"
						+" & exit";
				StartCommand(command);
			}
		});
		btnChangeMyMarks.setBounds(463, 504, 162, 32);
		frmMyPlan.getContentPane().add(btnChangeMyMarks);

		JButton btnViewMyWeeks = new JButton("View my weeks' organization");
		btnViewMyWeeks.setBackground(Color.CYAN);
		btnViewMyWeeks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * <p>
				 * This button will help us to lunch the python program and show up the graph of the weeks orgarnisation of 
				 * the student session 
				 * And then we set the picture to show up the hours bar
				 * <p>
				 */
				String command = "cmd /c cd C:\\Users\\awous\\PycharmProjects\\ProjectCalculs\\MyProjectCalculs & "
						+ "Graph.py "+CourseName.courseName+
						" -t A+ & exit";

				final Thread t1 = new Thread(){
					@Override
					public void run(){
						/**
						 * This function lunch the command in the prompt command and show the timme per weeks
						 * @param command
						 * @return no return
						 */
						StartCommand(command);
					}
				};
				t1.start();
				try {
					t1.join();

				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				final Thread t2 = new Thread(){
					@Override
					public void run(){
						ImageIcon graphImage = new ImageIcon("res/image/"+CourseName.courseName+"_HoursBar.png");
						graphImage.getImage().flush();
						lblNewLabel.setIcon(graphImage);
						lblNewLabel.setEnabled(true);
					}
				};
				//System.out.println(t1.isAlive());//test to know if the thraed t1 is still alive
				t2.start();
			}
		});
		btnViewMyWeeks.setBounds(635, 504, 175, 32);
		frmMyPlan.getContentPane().add(btnViewMyWeeks);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/wallpaper.jpg")));
		label.setBounds(0, 0, 992, 564);
		frmMyPlan.getContentPane().add(label);
	
	}

	public static void InnitButton(JButton myButton, JLabel graphs) {

		/**
		 * <p>
		 * When the user click on the course button he is lunching the prompt command and will being connecting 
		 * to the Python program
		 * We are also making sure the python environment is correctly equipt, Cause we need to install some module
		 * to lunch the application 
		 * <p>
		 */
		//passage par argument de la commande à lancer
		String command = "cmd /c cd C:\\Users\\awous\\PycharmProjects\\ProjectCalculs\\MyProjectCalculs & pip install xlrd"
				+ "& python -m pip install numpy & python -m pip install matplotlib & Graph.py "+CourseName.courseName+
				" -m A+ & exit";
		//We are calling the start command to execute the command in the prompt
		//Use of thread will permit to to the application to update the image before setting the label
		final Thread t1 = new Thread(){
			@Override
			public void run(){
				//We are calling the start command to execute the command in the prompt
				StartCommand(command);
			}
		};
		t1.start();
		try {
			t1.join();

		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final Thread t2 = new Thread(){
			@Override
			public void run(){
				ImageIcon graphImage = new ImageIcon("res/image/"+CourseName.courseName+"_MySession.png");
				graphImage.getImage().flush();
				graphs.setIcon(graphImage);
				//lblNewLabel.updateUI();
				graphs.setEnabled(true);
				myButton.setText(CourseName.courseName);
				myButton.setEnabled(true);

			}
		};

		//System.out.println(t1.isAlive());//test to know if the thraed t1 is still alive
		t2.start();
	}

	/**
	 * This function lunch the command in the prompt command
	 * made static so it can be use by the other class
	 * @param command
	 * @return no return
	 */
	public static void StartCommand(String command) {
		try {
			/**
			 * Executing the command pass in the parameters
			 */
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


//Ecrire le choix de chaque utilisateur dans un fichier et apres faire une liste pour selectionner la sauvegarde