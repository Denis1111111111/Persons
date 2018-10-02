


import javax.swing.*;

public class PersonFrame extends JFrame
{
	 public PersonFrame()
	 {
	  setTitle("Person");
	  setBounds(150, 15, 1000, 500);
	  PersonPanel pan = new PersonPanel();
	  add(pan);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);
	  setVisible(true);
	 }
}