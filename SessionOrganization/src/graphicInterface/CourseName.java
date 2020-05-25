/**
 * this GUI will help the users to enter the name of the course we want to add as well as the number
 * of evaluation
 * 
 * @author  Dietz-B�nony AWOUSSI
 * @version 1.0
 * @since   2019-12-24
 */
package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class CourseName extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	public static String courseName = "";
	public static int numEvaluation = 1;

	/**
	 * Launch the application.
	 */
	public static void main() {
		try {
			CourseName dialog = new CourseName();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CourseName() {
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Name of the course");
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
						courseName = textField.getText();
						numEvaluation = Integer.parseInt(textField_1.getText());
						AddCourseInterface.main();
						//getContentPane().setVisible(false);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
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
}
