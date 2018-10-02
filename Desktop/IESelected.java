import java.io.File;
import java.util.ArrayList;

public class IESelected 
{
	static ImplExp getImplExp(File file,ArrayList<Person>pp)
	{
		ImplExp ie = null;
		String name = file.getName();
		name = name.toLowerCase();

		if(name.endsWith(".json"));
		{
			ie = new ImplExp_JSON(file,pp);
		}
//				if(name.endsWith("xml"));
//				{
//					ie = new ImplExp_XML(file,pp);
//				}
//				if(name.endsWith("csv"));
//				{
//					ie = new ImplExp_CSV(file,pp);
//				}
//				if(name.endsWith("yaml"));
//				{
//					ie = new ImplExp_YAML(file,pp);
//				}



		return ie;
	}
}
