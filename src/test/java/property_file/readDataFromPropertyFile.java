package property_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		System.out.println(p.getProperty("Browser"));
		System.out.println(p.getProperty("Url"));
		System.out.println(p.getProperty("UserName"));
		System.out.println(p.getProperty("Password"));

	}

}
