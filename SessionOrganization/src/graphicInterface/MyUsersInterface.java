package graphicInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import com.sun.net.httpserver.Authenticator.Success;


/**
 * This is the principal interface of our users .
 * It make with :
 * 				 button to add courses
 * 				 A label to show the graphics
 * 				 A button to change marks
 * 				 A button to change the view of the graph(Switch between hours and marks)
 * 				 A label to show the rating of the courses
 * 
 * @author  Dietz-B�nony AWOUSSI
 * @version 1.0
 * @since   2019-12-24	 
 */
public class MyUsersInterface {

	private JFrame frmMyPlan;
	ArrayList<JButton> coursesList = new ArrayList<JButton>();
	public static ArrayList<Rectangle> arrowsUpPosition = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> arrowsDownPosition = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> evaluationPosition = new ArrayList<Rectangle>();
	public static int nbCourse = 1;
	public static int course1 = 0;
	public static int course2 = 0;
	public static int course3 = 0;
	public static int course4 = 0;
	public static int course5 = 0;
	public static int course6 = 0;
	static int compteurRefresh = 1;
	private static Point point = new Point();

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					Success s=new Success(null);
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
		frmMyPlan.setUndecorated(true);
		frmMyPlan.getContentPane().setBackground(Color.DARK_GRAY);
		frmMyPlan.setTitle("My Plan");
		frmMyPlan.setBounds(100, 100, 1342, 782);
		frmMyPlan.getContentPane().setLayout(null);
		GuiFunction.InitializeArrowsUpPositionList();
		GuiFunction.InitializeArrowsDownPositionList();
		GuiFunction.InitializeEvaluationPositionList();
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(36, 690, 162, 11);
		frmMyPlan.getContentPane().add(progressBar);
		
		frmMyPlan.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	          point.x = e.getX();
	          point.y = e.getY();
	        }
	      });
		frmMyPlan.addMouseMotionListener(new MouseMotionAdapter() {
	        public void mouseDragged(MouseEvent e) {
	          Point p = frmMyPlan.getLocation();
	          frmMyPlan.setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
	        }
	      });
		
		JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/next_MyPerformance.png")));
		label.setBounds(246, 88, 982, 269);
		frmMyPlan.getContentPane().add(label);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/next_MyAptitude.png")));
		label_3.setEnabled(false);
		label_3.setBounds(965, 375, 353, 341);
		frmMyPlan.getContentPane().add(label_3);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-multiplier-26.png")));
		label_7.setBounds(10, 10, 36, 27);
		label_7.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        	 System.exit(0);
	        }
	      });
		frmMyPlan.getContentPane().add(label_7);


		//this button will be use to add new courses to the student session
		JButton btnNewButton = new  JButton("Name of the course");
		btnNewButton.setBackground(new Color(51, 51, 51));
		btnNewButton.setEnabled(false);

		btnNewButton.setBounds(540, 56, 116, 22);
		frmMyPlan.getContentPane().add(btnNewButton);

		JButton btnCourse = new JButton("Course_2");
		btnCourse.setEnabled(false);
		btnCourse.setBackground(new Color(51, 51, 51));
		btnCourse.setBounds(656, 56, 116, 22);
		frmMyPlan.getContentPane().add(btnCourse);

		JButton btnCourse_1 = new JButton("Course_3");
		btnCourse_1.setEnabled(false);
		btnCourse_1.setBounds(770, 56, 116, 22);
		btnCourse_1.setBackground(new Color(51, 51, 51));
		frmMyPlan.getContentPane().add(btnCourse_1);

		JButton btnCourse_2 = new JButton("Course_4");
		btnCourse_2.setEnabled(false);
		btnCourse_2.setBounds(880, 56, 116, 22);
		btnCourse_2.setBackground(new Color(51, 51, 51));
		frmMyPlan.getContentPane().add(btnCourse_2);

		JButton btnCourse_3 = new JButton("Course_5");
		btnCourse_3.setEnabled(false);
		btnCourse_3.setBounds(996, 56, 116, 22);
		btnCourse_3.setBackground(new Color(51, 51, 51));
		frmMyPlan.getContentPane().add(btnCourse_3);

		JButton btnCourse_4 = new JButton("Course_6");
		btnCourse_4.setEnabled(false);
		btnCourse_4.setBounds(1112, 56, 116, 22);
		btnCourse_4.setBackground(new Color(51, 51, 51));
		frmMyPlan.getContentPane().add(btnCourse_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/next_HoursBar.png")));
		label_2.setEnabled(false);
		label_2.setBounds(602, 375, 353, 341);
		frmMyPlan.getContentPane().add(label_2);
		//On ajoute un label pour pouvoir ajouter une image
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/next_MySession.png")));
		lblNewLabel.setBounds(224, 375, 368, 341);
		frmMyPlan.getContentPane().add(lblNewLabel);

		// this label is set for the rating of the courses. It will upgrade as soon as the student change his marks
		JLabel lblA = new JLabel("A+");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblA.setForeground(Color.GREEN);
		lblA.setBackground(Color.GREEN);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/i3cons8-nom-48.png")));
		lblImg.setBounds(36, 68, 48, 55);
		frmMyPlan.getContentPane().add(lblImg);
		
		JLabel lblLogIn = new JLabel("IDUL");
		lblLogIn.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		lblLogIn.setBounds(89, 79, 124, 37);
		frmMyPlan.getContentPane().add(lblLogIn);
		
		JRadioButton rdbtnChange = new JRadioButton("Add courses");
		rdbtnChange.setForeground(Color.WHITE);
		rdbtnChange.setFont(new Font("Tw Cen MT", Font.ITALIC, 22));
		rdbtnChange.setBackground(new Color(51, 102, 255));
		rdbtnChange.setBounds(41, 218, 132, 21);
		rdbtnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(nbCourse) {
				case 1:
				{
					CourseName.main();
					btnNewButton.setText(CourseName.courseName);
					btnNewButton.setEnabled(true);
					lblNewLabel.setEnabled(true);
					GuiFunction.CreateNewArrows(frmMyPlan);
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
					rdbtnChange.setBackground(Color.RED);
					progressBar.setForeground(Color.RED);
					System.out.println("You can only add six courses for the moment");// Will be replace with a label
				}
				
				nbCourse++;
				progressBar.setValue(nbCourse*10);
			}
		});
		frmMyPlan.getContentPane().add(rdbtnChange);
		
		JRadioButton rdbtnAddACourses = new JRadioButton("Edit courses");
		rdbtnAddACourses.setForeground(Color.WHITE);
		rdbtnAddACourses.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		rdbtnAddACourses.setBackground(new Color(51, 102, 255));
		rdbtnAddACourses.setBounds(41, 280, 132, 21);
		rdbtnAddACourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//We simply open the excel sheet
				String command = "cmd /c cd res\\image\\ & "+CourseName.courseName+"_"+"data.xlsx"
						+" & exit";
				StartCommand(command);
			}
		});
		frmMyPlan.getContentPane().add(rdbtnAddACourses);
		
		JRadioButton rdbtnUserProfile = new JRadioButton("User profile");
		rdbtnUserProfile.setForeground(Color.WHITE);
		rdbtnUserProfile.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		rdbtnUserProfile.setBackground(new Color(51, 102, 255));
		rdbtnUserProfile.setBounds(41, 342, 132, 21);
		frmMyPlan.getContentPane().add(rdbtnUserProfile);
		
		JRadioButton rdbtnConnection = new JRadioButton("Connection");
		rdbtnConnection.setForeground(Color.WHITE);
		rdbtnConnection.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		rdbtnConnection.setBackground(new Color(51, 102, 255));
		rdbtnConnection.setBounds(41, 404, 132, 21);
		rdbtnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final Thread t1 = new Thread(){
					@Override
					public void run(){
						ConnectionInterface.main();
					}
				};
				t1.start();
				try {
					t1.join();

				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				final Thread t2 = new Thread(){
					@Override
					public void run(){
						GuiFunction.WaitForConnection();
						GuiFunction.UpdateUserName(lblLogIn);
					}
				};
				t2.start();
			}
		});
		frmMyPlan.getContentPane().add(rdbtnConnection);
		
		JRadioButton rdbtnWeeksSchedule = new JRadioButton("Schedule");
		rdbtnWeeksSchedule.setForeground(Color.WHITE);
		rdbtnWeeksSchedule.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		rdbtnWeeksSchedule.setBackground(new Color(51, 102, 255));
		rdbtnWeeksSchedule.setBounds(41, 466, 132, 21);
		frmMyPlan.getContentPane().add(rdbtnWeeksSchedule);
		
		JRadioButton rdbtnSaveSession = new JRadioButton("Save session");
		rdbtnSaveSession.setForeground(Color.WHITE);
		rdbtnSaveSession.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		rdbtnSaveSession.setBackground(new Color(51, 102, 255));
		rdbtnSaveSession.setBounds(41, 528, 132, 21);
		frmMyPlan.getContentPane().add(rdbtnSaveSession);
		
		JRadioButton rdbtnLoadSession = new JRadioButton("Load Session");
		rdbtnLoadSession.setForeground(Color.WHITE);
		rdbtnLoadSession.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		rdbtnLoadSession.setBackground(new Color(51, 102, 255));
		rdbtnLoadSession.setBounds(41, 590, 132, 21);
		frmMyPlan.getContentPane().add(rdbtnLoadSession);
		
		JRadioButton rdbtnDashboard = new JRadioButton("DASHBOARD");
		rdbtnDashboard.setForeground(Color.WHITE);
		rdbtnDashboard.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		rdbtnDashboard.setBackground(new Color(51, 102, 255));
		rdbtnDashboard.setBounds(41, 156, 132, 21);
		frmMyPlan.getContentPane().add(rdbtnDashboard);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course1 == 0)
				{
					InnitButton(btnNewButton, lblNewLabel, label_2, label, label_3);
					btnNewButton.setBackground(new Color(51, 102, 255));
				}
				else
				{
					CourseName.courseName = btnNewButton.getText();
					InnitButton(btnNewButton, lblNewLabel, label_2, label, label_3);
				}
				course1++;
			}
		});

		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				if(course2 == 0)
				{
					InnitButton(btnCourse, lblNewLabel, label_2, label, label_3);
					btnCourse.setBackground(new Color(51, 102, 255));
				}
				else
				{
					CourseName.courseName = btnCourse.getText();
					InnitButton(btnCourse, lblNewLabel, label_2, label, label_3);
					btnCourse.setBackground(new Color(51, 102, 255));
				}
				course2++;
			}
		});

		btnCourse_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course3 == 0)
				{
					InnitButton(btnCourse_1, lblNewLabel, label_2, label, label_3);
					btnCourse_1.setBackground(new Color(51, 102, 255));
				}
				else
				{
					CourseName.courseName = btnCourse_1.getText();
					InnitButton(btnCourse_1, lblNewLabel, label_2, label, label_3);
					btnCourse_1.setBackground(new Color(51, 102, 255));
				}
				course3++;			
			}
		});

		btnCourse_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course4 == 0)
				{
					InnitButton(btnCourse_2, lblNewLabel, label_2, label, label_3);
					btnCourse_2.setBackground(new Color(51, 102, 255));
				}
				else
				{
					CourseName.courseName = btnCourse_2.getText();
					InnitButton(btnCourse_2, lblNewLabel, label_2, label, label_3);
					btnCourse_2.setBackground(new Color(51, 102, 255));
				}
				course4++;			
			}
		});

		btnCourse_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course5 == 0)
				{
					InnitButton(btnCourse_3, lblNewLabel, label_2, label, label_3);
					btnCourse_3.setBackground(new Color(51, 102, 255));
				}
				else
				{
					CourseName.courseName = btnCourse_3.getText();
					InnitButton(btnCourse_3, lblNewLabel, label_2, label, label_3);
					btnCourse_3.setBackground(new Color(51, 102, 255));
				}
				course5++;	
			}
		});

		btnCourse_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(course6 == 0)
				{
					InnitButton(btnCourse_4, lblNewLabel, label_2, label, label_3);
					btnCourse_4.setBackground(new Color(51, 102, 255));
				}
				else
				{
					CourseName.courseName = btnCourse_4.getText();
					InnitButton(btnCourse_4, lblNewLabel, label_2, label, label_3);
					btnCourse_4.setBackground(new Color(51, 102, 255));
				}
				course6++;
			}
		});

		lblA.setBounds(173, 82, 40, 30);
		frmMyPlan.getContentPane().add(lblA);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/myBlue1.jpg")));
		label_1.setForeground(Color.BLACK);
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(20, 65, 194, 634);
	    LineBorder line = new LineBorder(new Color(51, 102, 255),21, true);

	    label_1.setBorder(line);
		frmMyPlan.getContentPane().add(label_1);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(compteurRefresh % 2 == 0)
					label_4.setBounds(1142, 10, 33, 36);
				else
					label_4.setBounds(1142, 20, 33, 36);
				compteurRefresh++;
				
			}
		});
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SwingUtilities.updateComponentTreeUI(frmMyPlan);
				System.out.println("benoooooo");
			}
		});
		label_4.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/refresh (3).png")));
		label_4.setBounds(1142, 10, 33, 36);
		label_4.revalidate();
		frmMyPlan.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/notification.png")));
		label_5.setBounds(1183, 10, 45, 36);
		frmMyPlan.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/comment.png")));
		label_6.setBounds(1096, 10, 33, 36);
		frmMyPlan.getContentPane().add(label_6);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-home-24.png")));
		label_8.setBounds(1048, 10, 36, 36);
		label_8.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        	HomePageInterface.main(null);
	        }
	      });
		frmMyPlan.getContentPane().add(label_8);
		
		JLabel lblSessionNme = new JLabel("Session Name");
		lblSessionNme.setForeground(Color.CYAN);
		lblSessionNme.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		lblSessionNme.setBounds(56, 10, 124, 27);
		lblSessionNme.setText(AddSessionInterface.sessionName);
		frmMyPlan.getContentPane().add(lblSessionNme);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-collapse-arrow-26.png")));
		lblNewLabel_1.setBounds(1238, 107, 26, 27);
		frmMyPlan.getContentPane().add(lblNewLabel_1);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-expand-arrow-26.png")));
		label_9.setBounds(1278, 107, 26, 27);
		frmMyPlan.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("1");
		label_10.setBackground(Color.GREEN);
		label_10.setFont(new Font("Georgia", Font.PLAIN, 20));
		label_10.setForeground(Color.RED);
		label_10.setBounds(1317, 107, 25, 27);
		frmMyPlan.getContentPane().add(label_10);
		
		
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-reply-arrow-26.png")));
		label_11.setBounds(250, 65, 33, 13);
		label_11.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        	System.out.println("Cancel the current action");
	        }
			@Override
			public void mouseExited(MouseEvent e) {
				label_11.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-reply-arrow-261.png")));
			}
	      });
		frmMyPlan.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-collapse-arrow-26.png")));
		label_12.setBounds(1238, 170, 26, 27);
		frmMyPlan.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setEnabled(false);
		label_13.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-expand-arrow-26.png")));
		label_13.setBounds(1278, 170, 26, 27);
		frmMyPlan.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("2");
		label_14.setForeground(Color.RED);
		label_14.setFont(new Font("Georgia", Font.PLAIN, 20));
		label_14.setBackground(Color.GREEN);
		label_14.setBounds(1317, 170, 25, 27);
		frmMyPlan.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-chevron-24.png")));
		label_15.setBounds(1238, 229, 26, 27);
		frmMyPlan.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("");
		label_16.setEnabled(false);
		label_16.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-chevron-24 (1).png")));
		label_16.setBounds(1278, 229, 26, 27);
		frmMyPlan.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("3");
		label_17.setForeground(Color.RED);
		label_17.setFont(new Font("Georgia", Font.PLAIN, 20));
		label_17.setBackground(Color.GREEN);
		label_17.setBounds(1317, 229, 25, 27);
		frmMyPlan.getContentPane().add(label_17);
		SetUp();
		
			
	}
	
	public static void SetUp() {
		
		String command = "cmd /c cd src\\graphicInterface\\ & pip install xlrd"
				+ "& python -m pip install numpy & python -m pip install matplotlib & python -m pip install pandas & exit";
		try {
			StartCommand(command);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public static void InnitButton(JButton myButton, JLabel graphs, JLabel weekGraph,JLabel performanceGraph, JLabel aptitudeGraph) {

		/**
		 * <p>
		 * When the user click on the course button he is lunching the prompt command and will being connecting 
		 * to the Python program
		 * We are also making sure the python environment is correctly equipt, Cause we need to install some module
		 * to lunch the application 
		 * <p>
		 */
		//passage par argument de la commande � lancer : Tracer les deux courbes
		//System.out.println(System.getProperty("user.dir"));
		String command = "cmd /c cd src\\graphicInterface\\ & Graph.py "+CourseName.courseName+" -m A+ & Graph.py "+CourseName.courseName+" -t A+ & exit";
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
				graphs.setEnabled(true);
				
				ImageIcon weekImage = new ImageIcon("res/image/"+CourseName.courseName+"_HoursBar.png");
				weekImage.getImage().flush();
				weekGraph.setIcon(weekImage);
				weekGraph.setEnabled(true);
				
				ImageIcon performanceImage = new ImageIcon("res/image/"+CourseName.courseName+"_MyPerformance.png");
				performanceImage.getImage().flush();
				performanceGraph.setIcon(performanceImage);
				performanceGraph.setEnabled(true);
				
				ImageIcon aptitudeImage = new ImageIcon("res/image/"+CourseName.courseName+"_MyAptitude.png");
				aptitudeImage.getImage().flush();
				aptitudeGraph.setIcon(aptitudeImage);
				aptitudeGraph.setEnabled(true);
				//lblNewLabel.updateUI();
				
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

			//on r�cup�re le flux de sortie du programme

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