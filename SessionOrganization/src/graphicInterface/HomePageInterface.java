package graphicInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.sun.net.httpserver.Authenticator.Success;


public class HomePageInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Point point = new Point();
	public static int nbSession = 0;
	public static int nbSessionName = 0;
	public static ArrayList<JLabel> sessionList = new ArrayList<JLabel>();
	public static ArrayList<JLabel> sessionNameList = new ArrayList<JLabel>();
    public static ArrayList<Rectangle> sessionPosition = new ArrayList<Rectangle>();
    public static ArrayList<Rectangle> sessionNamePosition = new ArrayList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				@SuppressWarnings("unused")
				Success s=new Success(null);
					final HomePageInterface frame = new HomePageInterface();
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
	
	public HomePageInterface() {
		GuiFunction.InitializeSessionPositionList();
		GuiFunction.InitializeSessionNamePositionList();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 637);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JLabel lblSessionName = new JLabel("Session name");
		lblSessionName.setForeground(Color.LIGHT_GRAY);
		lblSessionName.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblSessionName.setBounds(43, 186, 112, 13);
		contentPane.add(lblSessionName);
		
		JLabel lblDie = new JLabel("Dietz Predict 2.0");
		lblDie.setForeground(Color.WHITE);
		lblDie.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblDie.setBounds(351, 0, 134, 24);
		contentPane.add(lblDie);
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(Color.BLUE);
		label_5.setBackground(Color.BLUE);
		label_5.setIcon(new ImageIcon(HomePageInterface.class.getResource("/image/icons8-graduation-cap-52.png")));
		Rectangle sessionPosition = HomePageInterface.sessionPosition.get(0);
		label_5.setBounds(sessionPosition);
		LineBorder line = new LineBorder(new Color(51, 102, 255),1, true);
		label_5.setBorder(line);
		label_5.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	    		final Thread lunchMyUsersInterface = new Thread(){

	    			public void run(){
	    				LineBorder line = new LineBorder(new Color(51, 102, 255),2, true);
	    				label_5.setBorder(line);
	    				lblSessionName.setForeground(Color.white);
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
	    				dispose();
	    			}
	    		};
	    		closeGui.start();
	        }
	      });
		contentPane.add(label_5);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(HomePageInterface.class.getResource("/image/icons8-info-24.png")));
		label_3.setBounds(802, 32, 24, 24);
		contentPane.add(label_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(HomePageInterface.class.getResource("/image/icons8-chercher-24.png")));
		label_2.setBounds(836, 32, 24, 24);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HomePageInterface.class.getResource("/image/icons8-multiplier-26.png")));
		label_1.setBounds(0, 0, 36, 27);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HomePageInterface.class.getResource("/image/Classic_RoyalBlue_Shimmer_main.jpg")));
		label.setBounds(0, 0, 881, 27);
		contentPane.add(label);
		
		JButton btnNewSession = new JButton("New Session");
		btnNewSession.setForeground(Color.WHITE);
		btnNewSession.setBackground(Color.DARK_GRAY);
		btnNewSession.setBounds(629, 605, 116, 22);
		btnNewSession.setBorder(new RoundedBorder(20));
		btnNewSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
		final Thread lunchAddSession = new Thread(){

			public void run(){
				AddSessionInterface.main();
			}
		};
		lunchAddSession.start();
		try {
			lunchAddSession.join();

		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		final Thread updateGUI = new Thread(){

			public void run(){
				GuiFunction.WaitForJDialog();
				GuiFunction.AddSession(lblSessionName, contentPane);
				nbSession++;
				nbSessionName++;
				System.out.print(nbSession);
			}
		};
		updateGUI.start();
	}
		});
		contentPane.add(btnNewSession);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setForeground(Color.WHITE);
		btnOpen.setBackground(Color.DARK_GRAY);
		btnOpen.setBounds(755, 605, 116, 22);
		btnOpen.setBorder(new RoundedBorder(20));
		contentPane.add(btnOpen);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(HomePageInterface.class.getResource("/image/icons8-utilisateur-masculin-24.png")));
		label_4.setBounds(768, 32, 24, 24);
		label_4.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        	ConnectionInterface.main();
	        }
	      });
		contentPane.add(label_4);
		
		
		//for (Iterator<JLabel> i = sessionList.iterator(); i.hasNext();) {
		    //String item = i.next();
		    //System.out.println(item);
		//} 
		
		// Move the interface
		label.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	          point.x = e.getX();
	          point.y = e.getY();
	        }
	      });
		label.addMouseMotionListener(new MouseMotionAdapter() {
	        public void mouseDragged(MouseEvent e) {
	          Point p = getLocation();
	          setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
	        }
	      });
		
		label_1.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	        	System.exit(0);
	        }
	      });
		
	}
	
    public void paint(Graphics g) {
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin = new Line2D.Float(0, 55, 1000, 55);
        g2.setColor(Color.GRAY);
        g2.draw(lin);
    }
	
	private static class RoundedBorder implements Border {

	    private int radius;


	    RoundedBorder(int radius) {
	        this.radius = radius;
	    }


	    public Insets getBorderInsets(Component c) {
	        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
	    }


	    public boolean isBorderOpaque() {
	        return true;
	    }


	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
	        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
	    }
	}
}

