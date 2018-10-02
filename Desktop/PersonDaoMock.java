
import java.util.ArrayList;



public class PersonDaoMock implements PersonDao
{
	ArrayList<Person> pp = null;
	
	public PersonDaoMock()
	{
		pp = new ArrayList<Person>();
		
		pp.add(new Person( 1, "����",	"�������",		25));
		pp.add(new Person( 2, "���",	"�����",		15));
		pp.add(new Person( 3, "����", 	"����",			20));
		pp.add(new Person( 4, "�����", 	"����",			58));
		pp.add(new Person( 5, "����", 	"���",          33));
		pp.add(new Person( 6, "�����", 	"������",		70));
		pp.add(new Person( 7, "����", 	"�����",		24));
		pp.add(new Person( 8, "����", 	"�����",		25));
		pp.add(new Person( 9, "�����", 	"������",		18));
		pp.add(new Person(10, "����", 	"�����",		47));
		pp.add(new Person(11, "�����", 	"���",			39));
		pp.add(new Person(12, "�����", 	"����",		    62));
		pp.add(new Person(13, "�����", 	"��������",		84));
		pp.add(new Person(14, "�������", "���",	        50));
		pp.add(new Person(15, "�����", 	"������",		75));
		pp.add(new Person(16, "����", 	"���",			16));
		pp.add(new Person(17, "�����", 	"�����",		16));
		pp.add(new Person(18, "�����", 	"�����",		37));
		pp.add(new Person(19, "�����", 	"������",		64));
		pp.add(new Person(20, "����", 	"����",		    70));
		pp.add(new Person(21, "������", 	"����",		44));
		pp.add(new Person(22, "����", 	"���������",	49));
		pp.add(new Person(23, "������", 	"�����",	41));
		pp.add(new Person(24, "����", 	"���������",	19));
		pp.add(new Person(25, "�����", 	"�����",		56));
		pp.add(new Person(26, "����", 	"������",		17));
		pp.add(new Person(27, "������", "������",	    54));
		pp.add(new Person(28, "����", 	"�����",		30));
		pp.add(new Person(29, "����", 	"�������",		29));
		pp.add(new Person(30, "�����", 	"����",		    21));
		pp.add(new Person(31, "������",	"����������",	24));
		pp.add(new Person(32, "�����", 	"�������",		32));
		pp.add(new Person(33, "�����", 	"�����",		78));
		pp.add(new Person(34, "����", 	"�������",		25));
		pp.add(new Person(35, "����", 	"������",		36));
		pp.add(new Person(36, "������", 	"�����",	71));
		pp.add(new Person(37, "������", 	"������",	60));
		pp.add(new Person(38,  "����" ,   "������",	 	48));
		pp.add(new Person(39, "�����",	  "�����",		27));
		pp.add(new Person(40, "�������", "�����",		29));
	}
	
	@Override
	public void create(Person p) 
	{
		pp.add(p);
	}
	
	@Override
	public void update(Person p) 
	 {
	  for(Person i : pp)
	  {
	   if(p.id == i.id)
	   {
	    i.fname = p.fname;
	    i.lname = p.lname;
	    i.age   = p.age;
	   }
	  }
	 }

	@Override
	public  void delete(Person p) 
	{
		Person del = null;
		for(Person i : pp)
			if(p.id == i.id)
				del = i;
		pp.remove(del);
	}
	
	@Override
	public ArrayList<Person> read() 
	{
		return pp;
	}
}