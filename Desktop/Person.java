
public class Person implements Comparable<Person>
{
	public int id;
	public String fname;
	public String lname;
	public int age;

	public Person(int id, String fname, String lname, int age)
	{
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	} 

	public int getid()
	{
		return id;
	}

	public String getfname()
	{
		return fname;
	}

	public int getage()
	{
		return age;
	}

	public String getlname()
	{
		return lname;
	}

	@Override
	public String toString()
	{
		return "id=" + id + "fname="  + fname + " lname=" + lname+" age=" + age;  
	}

	@Override
	public int compareTo(Person arg0)
	{
		return 0;
	} 
}

