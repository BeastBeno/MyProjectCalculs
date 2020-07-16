package graphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class GuiFunction {

	public static void InitializeSessionPositionList() {
		HomePageInterface.sessionPosition.add(new Rectangle(20,89, 145, 87));
		HomePageInterface.sessionPosition.add(new Rectangle(204,89, 145, 87));
		HomePageInterface.sessionPosition.add(new Rectangle(395,89, 145, 87));
		HomePageInterface.sessionPosition.add(new Rectangle(584,89, 145, 87));
		HomePageInterface.sessionPosition.add(new Rectangle(20,259, 145, 87));
		HomePageInterface.sessionPosition.add(new Rectangle(204,259, 145, 87));
		HomePageInterface.sessionPosition.add(new Rectangle(395,259, 145, 87));
		HomePageInterface.sessionPosition.add(new Rectangle(584,259, 145, 87));
	}
	
	public static void InitializeSessionNamePositionList() {
		HomePageInterface.sessionNamePosition.add(new Rectangle(43,186, 112, 13));
		HomePageInterface.sessionNamePosition.add(new Rectangle(224,186, 112, 13));
		HomePageInterface.sessionNamePosition.add(new Rectangle(415,186, 112, 13));
		HomePageInterface.sessionNamePosition.add(new Rectangle(604,186, 112, 13));
		HomePageInterface.sessionNamePosition.add(new Rectangle(43,356, 112, 13));
		HomePageInterface.sessionNamePosition.add(new Rectangle(224,356, 112, 13));
		HomePageInterface.sessionNamePosition.add(new Rectangle(415,356, 112, 13));
		HomePageInterface.sessionNamePosition.add(new Rectangle(604,356, 112, 13));
	}
	
	public static void InitializeArrowsUpPositionList() {
		MyUsersInterface.arrowsUpPosition.add(new Rectangle(1238, 107, 26, 27));
		MyUsersInterface.arrowsUpPosition.add(new Rectangle(1238, 163, 26, 27));
		MyUsersInterface.arrowsUpPosition.add(new Rectangle(1238, 219, 26, 27));
		MyUsersInterface.arrowsUpPosition.add(new Rectangle(1238, 275, 26, 27));
		MyUsersInterface.arrowsUpPosition.add(new Rectangle(1238, 331, 26, 27));
	}
	
	public static void InitializeArrowsDownPositionList() {
		MyUsersInterface.arrowsDownPosition.add(new Rectangle(1278, 107, 26, 27));
		MyUsersInterface.arrowsDownPosition.add(new Rectangle(1278, 163, 26, 27));
		MyUsersInterface.arrowsDownPosition.add(new Rectangle(1278, 219, 26, 27));
		MyUsersInterface.arrowsDownPosition.add(new Rectangle(1278, 275, 26, 27));
		MyUsersInterface.arrowsDownPosition.add(new Rectangle(1278, 331, 26, 27));
	}
	
	public static void InitializeEvaluationPositionList() {
		MyUsersInterface.evaluationPosition.add(new Rectangle(1317, 107, 26, 27));
		MyUsersInterface.evaluationPosition.add(new Rectangle(1317, 163, 26, 27));
		MyUsersInterface.evaluationPosition.add(new Rectangle(1317, 219, 26, 27));
		MyUsersInterface.evaluationPosition.add(new Rectangle(1317, 275, 26, 27));
		MyUsersInterface.evaluationPosition.add(new Rectangle(1317, 331, 26, 27));
	}
	
	public static void InitializeCoursePositionList() {
		MyUsersInterface.coursePosition.add(new Rectangle(1112, 56, 116, 22));
		MyUsersInterface.coursePosition.add(new Rectangle(996, 56, 116, 22));
		MyUsersInterface.coursePosition.add(new Rectangle(880, 56, 116, 22));
		MyUsersInterface.coursePosition.add(new Rectangle(770, 56, 116, 22));
		MyUsersInterface.coursePosition.add(new Rectangle(656, 56, 116, 22));
		MyUsersInterface.coursePosition.add(new Rectangle(540, 56, 116, 22));
		MyUsersInterface.coursePosition.add(new Rectangle(424, 56, 116, 22));
		MyUsersInterface.coursePosition.add(new Rectangle(308, 56, 116, 22));
	}
	
	public static void InitializeCoursesList() {
		for(int i = 0; i < AddSessionInterface.numCourses; i++) {
			String courseName = "Course "+(i+1);
			MyUsersInterface.coursesList.add(new JButton(courseName));
		}
	}
	public static void setCoursesProperty() {
		for(int i = 0; i < AddSessionInterface.numCourses; i++) {
			Rectangle coursePosition = MyUsersInterface.coursePosition.get(i);
			JButton course = MyUsersInterface.coursesList.get(i);
			course.setBounds(coursePosition);
			course.setBackground(new Color(51, 51, 51));
			course.setEnabled(false);
		}
	}
	
	public static void setCoursesAction(JLabel graphs, JLabel weekGraph,JLabel performanceGraph, JLabel aptitudeGraph) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < AddSessionInterface.numCourses; i++) {
					JButton course = MyUsersInterface.coursesList.get(i);
					course.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							CourseName.courseName = course.getText();
							MyUsersInterface.InnitButton(course, graphs, weekGraph, performanceGraph, aptitudeGraph);
							course.setBackground(new Color(51, 102, 255));
					}
				});
				
			}
			}
		});
	}

	public static void UpdateUserName(JLabel userName) {
		userName.setText(ConnectionInterface.userName);
		userName.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		userName.setBounds(89, 79, 124, 37);
		userName.setEnabled(true);
		userName.repaint();  
	}

	public static void WaitForJDialog() {
		while(!CheckIfAddSessoinDone())
			System.out.println(AddSessionInterface.sessionName);    
	}

	public static boolean CheckIfAddSessoinDone() {
		while(!AddSessionInterface.informationCorrect)
			return false;
		return true;     
	}


	public static void WaitForConnection() {
		while(!CheckIfConnectionDone())
			System.out.println(ConnectionInterface.userName);    
	}

	public static boolean CheckIfConnectionDone() {
		while(!ConnectionInterface.informationCorrect)
			return false;
		return true;     
	}
	
	public static void WaitForCourseName() {
		while(!CheckIfCourseNameDone())
			System.out.println(CourseName.courseName);    
	}

	public static boolean CheckIfCourseNameDone() {
		while(!CourseName.informationCorrect)
			return false;
		return true;     
	}


	public static void AddSession(JLabel newSession, JPanel contentPane) {

		if(HomePageInterface.nbSession == 0)
			UpdateSessionName(newSession);
		else {
			CreateNewLabel(contentPane);
			CreateNewLabelName(contentPane);
		}
	}

	public static void UpdateSessionName(JLabel sessionName) {
		sessionName.setText(AddSessionInterface.sessionName);
		sessionName.setEnabled(true);
		//sessionName.repaint();  
		HomePageInterface.sessionList.add(sessionName);
	}

	public static void CreateNewLabel(JPanel contentPane) {
		JLabel newLabel = new JLabel("");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				newLabel.setForeground(Color.BLUE);
				newLabel.setIcon(new ImageIcon(GuiFunction.class.getResource("/image/icons8-graduation-cap-52.png")));
				Rectangle sessionPosition = HomePageInterface.sessionPosition.get(HomePageInterface.nbSession-1);
				newLabel.setBounds(sessionPosition);
				LineBorder line = new LineBorder(new Color(51, 102, 255),1, true);
				newLabel.setBackground(Color.BLUE);
				newLabel.setBorder(line);
				newLabel.setVisible(true);
				newLabel.addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						final Thread lunchMyUsersInterface = new Thread(){

							public void run(){
								LineBorder line = new LineBorder(new Color(51, 102, 255),2, true);
								newLabel.setBorder(line);
								//lblSessionName.setForeground(Color.white);
								MyUsersInterface.main();
							}
						};
						lunchMyUsersInterface.start();
						try {
							lunchMyUsersInterface.join();

						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						final Thread closeGui = new Thread(){

							public void run(){
								//dispose();
								System.out.println("delete this");
							}
						};
						closeGui.start();
					}
				});
				contentPane.add(newLabel);
				contentPane.validate();
				contentPane.repaint();
			}
		});

		HomePageInterface.sessionList.add(newLabel);

	}

	public static void CreateNewLabelName(JPanel contentPane) {
		JLabel lblSessionName = new JLabel("Session name");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				lblSessionName.setForeground(Color.LIGHT_GRAY);
				lblSessionName.setFont(new Font("Georgia", Font.PLAIN, 16));
				lblSessionName.setText(AddSessionInterface.sessionName);
				Rectangle sessionNamePosition = HomePageInterface.sessionNamePosition.get(HomePageInterface.nbSessionName-1);
				lblSessionName.setBounds(sessionNamePosition);
				lblSessionName.setVisible(true);
				contentPane.add(lblSessionName);
				contentPane.validate();
				contentPane.repaint();
			}
		});

		HomePageInterface.sessionList.add(lblSessionName);
	}
	
	public static void CreateNewArrows(JFrame frmMyPlan) {
		
			
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < CourseName.numEvaluation; i++) {
					
				if (i > 4) {
					break;
				}
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setEnabled(false);
				lblNewLabel_1.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-collapse-arrow-26.png")));
				Rectangle arrowsUpPosition = MyUsersInterface.arrowsUpPosition.get(i);
				lblNewLabel_1.setBounds(arrowsUpPosition);
				frmMyPlan.getContentPane().add(lblNewLabel_1);
				
				JLabel label_9 = new JLabel("");
				label_9.setIcon(new ImageIcon(MyUsersInterface.class.getResource("/image/icons8-expand-arrow-26.png")));
				Rectangle arrowsDownPosition = MyUsersInterface.arrowsDownPosition.get(i);
				label_9.setBounds(arrowsDownPosition);
				frmMyPlan.getContentPane().add(label_9);
				
				JLabel label_10 = new JLabel(Integer.toString(i));
				label_10.setBackground(Color.GREEN);
				label_10.setFont(new Font("Georgia", Font.PLAIN, 20));
				label_10.setForeground(Color.RED);
				Rectangle evaluationPosition = MyUsersInterface.evaluationPosition.get(i);
				label_10.setBounds(evaluationPosition);
				frmMyPlan.getContentPane().add(label_10);
				}
			}
		});

	}
	
	public static void setCourse(JButton btnNewButton) {

		btnNewButton.setText(CourseName.courseName);
		btnNewButton.setEnabled(true);
	}
	
	

}
