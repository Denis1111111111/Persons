
import java.util.ArrayList;



public class PersonDaoMock implements PersonDao
{
	ArrayList<Person> pp = null;
	
	public PersonDaoMock()
	{
		pp = new ArrayList<Person>();
		
		pp.add(new Person( 1, "Катя",	"Плугова",		25));
		pp.add(new Person( 2, "Жан",	"Ганин",		15));
		pp.add(new Person( 3, "Маня", 	"Шмок",			20));
		pp.add(new Person( 4, "Гриша", 	"Кимб",			58));
		pp.add(new Person( 5, "Гоша", 	"Онт",          33));
		pp.add(new Person( 6, "Артем", 	"Лалала",		70));
		pp.add(new Person( 7, "Инна", 	"Тырса",		24));
		pp.add(new Person( 8, "Саша", 	"Крыса",		25));
		pp.add(new Person( 9, "Роман", 	"Жабкин",		18));
		pp.add(new Person(10, "Анна", 	"Курка",		47));
		pp.add(new Person(11, "Росан", 	"Гак",			39));
		pp.add(new Person(12, "Алекс", 	"Досм",		    62));
		pp.add(new Person(13, "Семен", 	"Сыроедов",		84));
		pp.add(new Person(14, "Рудольф", "Ром",	        50));
		pp.add(new Person(15, "Ролан", 	"Рифель",		75));
		pp.add(new Person(16, "Инна", 	"Лук",			16));
		pp.add(new Person(17, "Денис", 	"Земин",		16));
		pp.add(new Person(18, "Остап", 	"Орный",		37));
		pp.add(new Person(19, "Козел", 	"Горный",		64));
		pp.add(new Person(20, "Петр", 	"Фича",		    70));
		pp.add(new Person(21, "Руслан", 	"Кича",		44));
		pp.add(new Person(22, "Олег", 	"Блаблабла",	49));
		pp.add(new Person(23, "Даниил", 	"Пешев",	41));
		pp.add(new Person(24, "рома", 	"Лихорадов",	19));
		pp.add(new Person(25, "Антон", 	"Гадов",		56));
		pp.add(new Person(26, "Петр", 	"Иванов",		17));
		pp.add(new Person(27, "Иоахим", "Пайпер",	    54));
		pp.add(new Person(28, "Анон", 	"Поцко",		30));
		pp.add(new Person(29, "Гусь", 	"Антонов",		29));
		pp.add(new Person(30, "Жанна", 	"Крюк",		    21));
		pp.add(new Person(31, "Андрей",	"Лукьяненко",	24));
		pp.add(new Person(32, "Елена", 	"Петрова",		32));
		pp.add(new Person(33, "Антон", 	"Селюк",		78));
		pp.add(new Person(34, "Олег", 	"Городюк",		25));
		pp.add(new Person(35, "Стас", 	"Кудряс",		36));
		pp.add(new Person(36, "Адольф", 	"Хальт",	71));
		pp.add(new Person(37, "Никита", 	"Ряскин",	60));
		pp.add(new Person(38,  "Жора" ,   "Обжора",	 	48));
		pp.add(new Person(39, "Пират",	  "Капер",		27));
		pp.add(new Person(40, "Василий", "Тилер",		29));
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