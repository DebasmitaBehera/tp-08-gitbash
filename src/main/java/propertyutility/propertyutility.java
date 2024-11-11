package propertyutility;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propertyutility {
	
	public String getDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream("(\"C:\\\\Users\\\\admin\\\\OneDrive\\\\Desktop/commondata.properties\")");
		Properties prop= new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;
		
	}

}


