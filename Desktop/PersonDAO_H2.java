

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class PersonDAO_H2 implements PersonDao
{

	ArrayList<Person> pp = new ArrayList<Person>();
	
	@Override
	public void create(Person p) 
	{
		String arg = "INSERT INTO person (id, Fname, Lname, age) \n" +
	               " VALUES ("+p.id+", '"+p.fname+"', '"+p.lname+"', "+p.age+");";

		try
		{
			Connection con = DriverManager.getConnection("jdbc:h2:~/edu", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(arg);
			stmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Person> read() 
	{
		pp = new ArrayList<Person>();
		
		try
		{
			Connection con = DriverManager.getConnection("jdbc:h2:~/edu", "root", "");
			Statement stmn = (Statement) con.createStatement();
			ResultSet rs = stmn.executeQuery("select * from person");

			while(rs.next())
			{
				pp.add(new Person(rs.getInt(1), rs.getString("Fname"), rs.getString("Lname"), rs.getInt(4)));
			}
			rs.close();
			stmn.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return pp;
	}

	@Override
	public void update(Person p) 
	{
		String arg = "UPDATE person SET Fname='"+p.fname+"', Lname='"+p.lname+"', age="+p.age+" WHERE person.id="+p.id+";";

		try
		{
			Connection con = DriverManager.getConnection("jdbc:h2:~/edu", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(arg);
			stmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Person p) 
	{
		String arg = "DELETE FROM person WHERE person.id="+p.id+";";

		try
		{
			Connection con = DriverManager.getConnection("jdbc:h2:~/edu", "root", "");
			Statement stmt = con.createStatement();
			stmt.executeUpdate(arg);
			stmt.close();
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
