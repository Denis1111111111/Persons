

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class ImplExp_JSON implements ImplExp
{
	File file = null;
	ArrayList<Person> pp = null;
	
	public ImplExp_JSON(File file, ArrayList<Person> pp)
	{
		this.file = file;
		this.pp = pp;
	}

	@Override
	public void save() 
	{
		 try(BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
	        {
			 String rs = "{\"Persons\":";
				for(Person p:pp)
				{
					rs += "{\"id\":"+p.id+",\"fname\":"+p.fname+",\"lname\":"+p.lname+",\"age\":"+p.age+"}";
				}
				rs += "}";
	          bw.write(rs);
	        }
	        catch(IOException ex)
		 {
	             
	            System.out.println(ex.getMessage());
	        } 
	}

	
	@Override
	public ArrayList<Person> load() 
	{
		pp = new ArrayList<Person>();
		try {
			 BufferedReader bufR = new BufferedReader(new FileReader(file.getPath()));
	         String res = "";
	         String temp = "";
	         if((res += bufR.readLine()) != null)
		         while((temp = bufR.readLine()) != null)
		         {
		        	 res += "\n" + temp;
		         }
	         	res = res.substring(11, res.length());
	         	res = res.replaceAll("[}\"]", "");
			    String[] persons = res.split("\\{");
			    for(int i = 1; i < persons.length; i++)
			    {
			    	String[] actualPerson = persons[i].split(",");
			    	int id = Integer.parseInt(actualPerson[0].substring(3,actualPerson[0].length()));
		    		String fname = actualPerson[1].substring(6,actualPerson[1].length());
		    		String lname = actualPerson[2].substring(6,actualPerson[2].length());
		    		int age = Integer.parseInt(actualPerson[3].substring(4,actualPerson[3].length()));
		    		Person p = new Person(id, fname, lname, age);
		    		pp.add(p);
			    }
       } catch (IOException ex) 
       {
           ex.printStackTrace(System.out);
       }
		return pp;
	}

}
