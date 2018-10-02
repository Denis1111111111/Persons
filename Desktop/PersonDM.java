
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;

public class PersonDM extends AbstractTableModel
{
	ImplExp ie = null;
	ArrayList<Person>  pp = new ArrayList<Person>();
	public static PersonDao pd = new PersonDaoMock();

	PersonDialogWindow dialogwindow;
	String choice;
	PersonDM dm = null;

	//==============
	//ComboBox
	//==============
	Combobox aCombo = new Combobox();
	class Combobox implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JComboBox cb = (JComboBox)e.getSource();
			String petName = (String)cb.getSelectedItem();
			switch(petName)
			{
			case "SQL":  pd = new PersonDAO_SQL();
			case "MOCK": pd = new PersonDaoMock();
			case "H2": pd = new PersonDAO_H2(); 
			}
		}
	}

	ActionCreate aCreate = new ActionCreate();
	class ActionCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			dialogwindow = new PersonDialogWindow(dm);
			choice = "create";
		}	  
	}

	ActionUpdate aUpdate = new ActionUpdate();
	class ActionUpdate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			dialogwindow = new PersonDialogWindow(dm);
			choice = "update";
		}
	}



	ActionRead aRead = new ActionRead();
	class ActionRead implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			pp = pd.read();
			fireTableDataChanged();
		}
	}



	ActionDelete aDelete = new ActionDelete();
	class ActionDelete implements ActionListener
	{
		@Override
		public  void actionPerformed(ActionEvent arg0) 
		{
			dialogwindow = new PersonDialogWindow(dm);
			choice = "delete";
		}
	}

	ActionCancel aCancel = new ActionCancel();
	class ActionCancel implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			dialogwindow.dispose();
		}
	}

	ActionOK aOK = new ActionOK();
	class ActionOK implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			switch (choice)
			{

			case "create": 
			{
				Person p = new Person(Integer.parseInt(dialogwindow.Id.getText()), dialogwindow.Fname.getText(), dialogwindow.Lname.getText(), Integer.parseInt(dialogwindow.Age.getText()));
				pd.create(p);
				dialogwindow.dispose();
			};
			break;

			case "update":
			{
				Person p = new Person(Integer.parseInt(dialogwindow.Id.getText()), dialogwindow.Fname.getText(), dialogwindow.Lname.getText(), Integer.parseInt(dialogwindow.Age.getText()));
				pd.update(p);
				dialogwindow.dispose();
			};
			break;

			case "delete":
			{
				Person p = new Person(Integer.parseInt(dialogwindow.Id.getText()),"hssh","fgh",5);
				pd.delete(p);
				dialogwindow.dispose();
			};
			break;
			}
			reload();
		}
	}

	Save aSave = new Save();
	class Save implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser fc = new JFileChooser();  
			fc.setCurrentDirectory(new File("C:\\Users\\Denis\\Pictures\\"));
			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
			{  
				//	System.out.println(fc.getSelectedFile()); 
				try {  

					ie = IESelected.getImplExp(fc.getSelectedFile(),pp);
					ie.save();
				} 
				catch (Exception a) 
				{
					System.out.println("Что-то пошло не так...");
				}  
			} 
		}	
	}


	Open aFopen = new Open();
	class Open extends JFrame implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JFileChooser fc = new JFileChooser();
			//	FileNameExtensionFilter filter = new FileNameExtensionFilter("json");
			//	fc.setFileFilter(filter);
			fc.setCurrentDirectory(new File("C:\\Users\\Denis\\Pictures\\"));
			int returnVal = fc.showOpenDialog(getParent());
			if(returnVal == JFileChooser.APPROVE_OPTION) 
			{
				try 
				{

					ie =	IESelected.getImplExp(fc.getSelectedFile(),pp);
					pp = ie.load();
					fireTableDataChanged();
				} 
				catch (Exception a ) 
				{
					System.out.println("Что-то пошло не так...");
				}
			}	
		}
	}



	public void reload()
	{
		pp = pd.read();
		fireTableDataChanged();
	}


	@Override
	public int getColumnCount() 
	{
		return 4;
	}


	@Override
	public int getRowCount() 
	{
		return pp.size();
	}

	@Override
	public Object getValueAt(int row, int col)
	{
		Object ret = null;
		Person p = pp.get(row);

		switch(col)
		{
		case 0: ret = p.getid();    break;
		case 1: ret = p.getfname(); break;
		case 2: ret = p.getlname(); break;
		case 3: ret = p.getage() ;   break;  
		}
		return ret;
	}

	@Override
	public String getColumnName(int col)
	{
		String[] colName = {"Id", "First name", "Last name", "Age"};
		return colName[col];
	}

	@Override
	public void addTableModelListener(TableModelListener e)
	{
		super.addTableModelListener(e);
	}
}