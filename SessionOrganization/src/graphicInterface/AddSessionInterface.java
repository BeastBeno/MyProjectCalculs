package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddSessionInterface extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField textField;
	private JTextField textField_1;
	public static String sessionName = "";
	public static int numCourses = 1;
	public static boolean informationCorrect = false;
	private JTextField txtA;
	private static Point point = new Point();

	/**
	 * Launch the application.
	 */
	public static void main() {
		try {
			informationCorrect = false;
			AddSessionInterface dialog = new AddSessionInterface();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddSessionInterface() {
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new LineBorder(new Color(0, 128, 0), 2, true));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Name of the session");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setForeground(new Color(30, 144, 255));
			lblNewLabel.setBounds(10, 88, 158, 42);
			contentPanel.add(lblNewLabel);
		}

		textField = new JTextField();
		textField.setBounds(178, 95, 224, 30);
		contentPanel.add(textField);
		textField.setColumns(10);

		JLabel lblNumberOfEvaluation = new JLabel("Number of evaluation");
		lblNumberOfEvaluation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberOfEvaluation.setForeground(new Color(30, 144, 255));
		lblNumberOfEvaluation.setBounds(10, 169, 158, 30);
		contentPanel.add(lblNumberOfEvaluation);

		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setBounds(178, 169, 25, 30);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setForeground(new Color(30, 144, 255));
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRating.setBounds(10, 229, 158, 30);
		contentPanel.add(lblRating);
		
		txtA = new JTextField();
		txtA.setForeground(Color.GREEN);
		txtA.setText("A+");
		txtA.setColumns(10);
		txtA.setBounds(178, 229, 25, 30);
		contentPanel.add(txtA);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
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

						sessionName = textField.getText();
						numCourses = Integer.parseInt(textField_1.getText());
						informationCorrect = true;
						dispose();

						//HomePageInterface.main();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener(){
					/**
					 * We simply taking the name of the course and the number of evaluation
					 */
					public void actionPerformed(ActionEvent evt)
					{
						informationCorrect = true;
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		
		// Move the interface
		this.addMouseListener(new MouseAdapter() {
	        public void mousePressed(MouseEvent e) {
	          point.x = e.getX();
	          point.y = e.getY();
	        }
	      });
		this.addMouseMotionListener(new MouseMotionAdapter() {
	        public void mouseDragged(MouseEvent e) {
	          Point p = getLocation();
	          setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
	        }
	      });
	}
	
	
}
