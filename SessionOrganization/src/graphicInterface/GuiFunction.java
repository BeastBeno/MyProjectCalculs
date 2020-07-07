package graphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
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
		sessionName.repaint();  
		HomePageInterface.sessionList.add(sessionName);
	}

	public static void CreateNewLabel(JPanel contentPane) {
		JLabel newLabel = new JLabel("");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				newLabel.setForeground(Color.BLUE);
				newLabel.setIcon(new ImageIcon(GuiFunction.class.getResource("/image/icons8-graduation-cap-52.png")));
				Rectangle sessionPosition = HomePageInterface.sessionPosition.get(HomePageInterface.nbSession);
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
				Rectangle sessionNamePosition = HomePageInterface.sessionNamePosition.get(HomePageInterface.nbSession);
				lblSessionName.setBounds(sessionNamePosition);
				lblSessionName.setText(AddSessionInterface.sessionName);
				lblSessionName.setVisible(true);
				contentPane.add(lblSessionName);
				contentPane.validate();
				contentPane.repaint();
			}
		});

		HomePageInterface.sessionList.add(lblSessionName);
	}

}
