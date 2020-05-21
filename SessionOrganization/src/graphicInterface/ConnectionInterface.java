package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class ConnectionInterface extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtEnter;
	private JPasswordField passwordField;
	public static String userName = "";
	public static String password ;

	/**
	 * Launch the application.
	 */
	public static void main() {
		try {
			ConnectionInterface dialog = new ConnectionInterface();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConnectionInterface() {
		setTitle("Connection");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserName.setBounds(42, 76, 91, 49);
		contentPanel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(42, 165, 77, 25);
		contentPanel.add(lblPassword);
		
		txtEnter = new JTextField();
		txtEnter.setForeground(Color.BLACK);
		txtEnter.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtEnter.setBounds(142, 86, 250, 34);
		contentPanel.add(txtEnter);
		txtEnter.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 163, 250, 34);
		contentPanel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("My Plan - Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(42, 24, 200, 42);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener()
				{
					/**
					 * We simply taking the name of the course and the number of evaluation
					 */
					public void actionPerformed(ActionEvent evt)
					{
						userName = txtEnter.getText();
						password = new String(passwordField.getPassword());
				        if (login(userName, password) == 1){
				        	lblUserName.setForeground(Color.GREEN);
				        	lblPassword.setForeground(Color.GREEN);
				            JOptionPane.showMessageDialog(null,"User, Found Access Granted!");
				            dispose();
				        }
				        else if (login(userName, password) >1){
				        	lblUserName.setForeground(Color.RED);
				        	lblPassword.setForeground(Color.RED);
				            JOptionPane.showMessageDialog(null,"Duplicate User, Access Denied!");
				        } 
				            else {
				            	lblPassword.setForeground(Color.RED);
				            	lblUserName.setForeground(Color.RED);
				            JOptionPane.showMessageDialog(null, "user doesn't exsist. ");
				             }
						//getContentPane().setVisible(false);
					}
				});
				//okButton.setActionCommand("OK");
				buttonPane.add(okButton);

				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	

	  public static int login(String userName, String password) {

	    try {
	      // Chargement du driver
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Driver O.K.");
	      
	      String url = "jdbc:mysql://localhost/myPlan?characterEncoding=latin1";
	      String user = "root";
	      String passwd = "pr@j?vision100%@$!";
	      java.sql.Connection conn = DriverManager.getConnection(url, user, passwd);
	      System.out.println("Connexion effective !");
	      java.sql.Statement st = conn.createStatement();
	      
	        String sql = "select idul,motDePasse from Etudiant where idul='"+userName+"'and motDePasse='"+password+"'";
	        java.sql.ResultSet rs=st.executeQuery(sql);
	        int count = 0;
	        while(rs.next()){
	            count = count+1;
	        }
	        return count;
	      //Statement state = conn.createStatement();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
	    return 0;
	  }
	
}

