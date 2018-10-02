
import java.util.ArrayList;



public interface PersonDao
{
void create(Person p);
void update(Person p);
void delete(Person p);
ArrayList <Person> read();
}