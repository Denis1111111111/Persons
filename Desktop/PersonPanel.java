


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;




public class PersonPanel extends JPanel
{

	public static JTable tb;
	
	public PersonPanel()
	{
		setLayout(null);
		PersonDM dm = new PersonDM();
		dm.dm = dm;
		tb = new JTable(dm);
		JScrollPane sp = new JScrollPane(tb);
		dm.addTableModelListener(tb);
		sp.setBounds(0, 0, 400, 463);
		add(sp);


		//=========================
		//COMBOBOX
		//=========================
		String[] DB = { "MOCK", "SQL", "H2"};
		JComboBox comboBox = new JComboBox(DB);
		comboBox.setBounds(399, 0, 900, 21);
		Font font = new Font("Verdana", Font.PLAIN, 16);
		comboBox.setFont(font);
		add(comboBox);
		comboBox.addActionListener(dm.aCombo);


		//=====================
		// BUTTONS
		//=====================
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(480, 150, 125, 25);
		btnCreate.addActionListener(dm.aCreate);
		add(btnCreate);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(620, 150, 125, 25);
		btnUpdate.addActionListener(dm.aUpdate);
		add(btnUpdate);

		JButton btnRead = new JButton("Read");
		btnRead.setBounds(530, 50, 325, 25);
		btnRead.addActionListener(dm.aRead);
		add(btnRead);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(780, 150, 125, 25);
		btnDelete.addActionListener(dm.aDelete);
		add(btnDelete);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setBounds(480, 400, 125, 25);
		btnOpen.addActionListener(dm.aFopen);
		add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(780, 400, 125, 25);
		btnSave.addActionListener(dm.aSave);
		add(btnSave);
	}
}
