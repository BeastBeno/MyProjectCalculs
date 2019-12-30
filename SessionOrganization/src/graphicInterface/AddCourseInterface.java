package graphicInterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

public class AddCourseInterface extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

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
		
		Object[][] donnees = new Object[CourseName.numEvaluation][4] ;
        /*= {
                {"Test1", 100,90, 10},
                {"Test2", 90, 60, 40},
                {"Test3", 100, 80,15},
                {"Test4", 90, 75, 35},
                //{"Test1", "Schrödinger", Color.magenta, false, Sport.FOOTBALL},
                //{"Delphine", "Duke", Color.yellow, false, Sport.TENNIS},
                //{"Eric", "Trump", Color.pink, true, Sport.FOOTBALL},
        };
        */
        for(int i=0; i< CourseName.numEvaluation; i++)
        {
			donnees[i][0] = "Test1";
			donnees[i][1] = 100;
			donnees[i][2] = 90;
			donnees[i][3] = 10;
        }
 
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
					  // Créer un fichier excel dans le dossier local avec le contenu de la JTable 
		              exporter(table,new File(CourseName.courseName+"_"+"data.xlsx"));
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
