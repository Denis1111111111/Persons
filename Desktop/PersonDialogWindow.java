
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class PersonDialogWindow extends JDialog
{
	PersonDM dm = null;
	public JTextField Id;
	public JTextField Fname;
	public JTextField Lname;
	public  JTextField Age;


	//===================
	// VALUES FROM JTABLE
	//===================
	public String strId;
	public String strFname;
	public String strLname;
	public String strAge;


	public PersonDialogWindow(PersonDM dm)
	{
		this.dm = dm;
		setBounds(450, 100, 700, 350);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(null);
		
		if(PersonPanel.tb.getSelectedRow () == -1)
		{
			strId = "";
			strFname = "";
			strLname = "";
			strAge = "";
		}
		else 
		{
			strId = PersonPanel.tb.getModel().getValueAt(PersonPanel.tb.getSelectedRow(), 0).toString();
			strFname = (String) PersonPanel.tb.getModel().getValueAt(PersonPanel.tb.getSelectedRow(), 1);
			strLname = (String) PersonPanel.tb.getModel().getValueAt(PersonPanel.tb.getSelectedRow(), 2);
			strAge = PersonPanel.tb.getModel().getValueAt(PersonPanel.tb.getSelectedRow(), 3).toString();
		}


		//=====================
		// BUTTONS
		//=====================
		JButton cancel = new JButton("CANCEL");
		cancel.setBounds(520, 250, 125, 25);
		cancel.addActionListener(dm.aCancel);
		add(cancel);

		JButton ok = new JButton("OK");
		ok.setBounds(60, 250, 125, 25);
		ok.addActionListener(dm.aOK);
		add(ok);


		//=====================
		// FIELDS
		//=====================
		Id = new JTextField(strId);
		Id.setBounds(120, 50, 100, 25);
		add(Id);

		Fname = new JTextField(strFname);
		Fname.setBounds(400, 50, 200, 25);
		add(Fname);

		Age = new JTextField(strAge);
		Age.setBounds(120, 100, 100, 25);
		add(Age);

		Lname = new JTextField(strLname);
		Lname.setBounds(400, 100, 200, 25);
		add(Lname);


		//=====================
		// LABELS
		//=====================
		JLabel JID = new JLabel("ID");
		JID.setBounds(60, 50, 200, 25);
		add(JID);

		JLabel JAge = new JLabel("Age");
		JAge.setBounds(60, 100, 200, 25);
		add(JAge);

		JLabel JFName = new JLabel("Fname");
		JFName.setBounds(350, 50, 200, 25);
		add(JFName);

		JLabel JLName = new JLabel("Lname");
		JLName.setBounds(350, 100, 200, 25);
		add(JLName);
		setVisible(true);
	}
}
