package scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyDemo 
{
	@Test
    public void getData() throws FileNotFoundException, IOException
    {
		Properties p=new Properties();
		
		p.load(new FileInputStream("./p.properties"));
		
		String value = p.getProperty("country");
		System.out.println(value);
    }
	

}
