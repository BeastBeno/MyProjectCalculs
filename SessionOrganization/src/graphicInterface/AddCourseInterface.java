package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

/**
 * Graphic interface to add courses .
 * It a table where the users can feel his marks and change his evaluation name as need
 * 
 * @author  Dietz-Bénony AWOUSSI
 * @version 1.0
 * @since   2019-12-24
 */
public class AddCourseInterface extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main() {
		try {
			AddCourseInterface dialog = new AddCourseInterface();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCourseInterface() {
		setBounds(100, 100, 625, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		contentPanel.setLayout(null);
		
		// Creation the array of the table it been feel up with the number of evaluation
		Object[][] donnees = new Object[CourseName.numEvaluation][4] ;
		for(int i=0; i< CourseName.numEvaluation; i++)
		{
			donnees[i][0] = "Test"+(i+1);
			donnees[i][1] = 100;
			donnees[i][2] = 90;
			donnees[i][3] = (100 / CourseName.numEvaluation);
		}
		
		// This is the header of my table
		String[] entetes = {"Designation", "Wanted marks", "Marks obtained", "weighting(%)"};

		table = new JTable(donnees, entetes);
		table.setBounds(62, 267, 438, -193);
		//contentPanel.add(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						/**
						 * <p>
						 * By pressing OK the table is being exported to an excel sheet.
						 * And then I run the excel sheet to let the users save his data 
						 * he must change the expansion of the file and erase the .xls in the end of the name of the sheet
						 * <p>
						 * <b>Note:</b>THIS MUST BE CORRECT IN A FUTURE VERSION OF THE APPLICATION
						 */
						exporter(table,new File("res\\image\\"+CourseName.courseName+"_"+"data.xls"));
						String command = "cmd /c cd res\\image\\ & "+CourseName.courseName+"_"+"data.xls"
								+" & exit";
						MyUsersInterface.StartCommand(command);
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

			getContentPane().add(new JScrollPane(table));
		}
	}
	// 
	/**
	 * <p>
	 * Exporting the table to file .xls 
	 * Getting every line of my table and writing them in an excel file
	 * he must change the expansion of the file and erase the .xls in the end of the name of the sheet
	 * <p>
	 * <b>Note:</b>The sheet create by this method must be save as a .xlsx file in the excel sheet
	 * @param table the table that will be export to an excel file
	 * @param file the file where the project will be export to
	 * @return no return generate the excel sheet 
	 */
	public void exporter(JTable table, File file)
	{
		try
		{

			TableModel model = table.getModel();
			FileWriter out = new FileWriter(file);
			for(int i=0; i < model.getColumnCount(); i++) {
				out.write(model.getColumnName(i) + "\t");
			}
			out.write("\n");

			for(int i=0; i< model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) {
					out.write(model.getValueAt(i,j).toString()+"\t");
				}
				out.write("\n");
			}

			out.close();
		}	catch(Exception err)
		{
			err.printStackTrace();
		}
	}


}
