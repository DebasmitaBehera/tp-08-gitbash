package Pac1;

import org.testng.annotations.Test;

public class CreateContactTest {
	@Test
	public void createcontact() {
		String URL=System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println("CreateContact");
		System.out.println("CreateContact1");
		
	}
	@Test
	
	public void createcontactwithphno() {
		System.out.println("CreateContactwithphno");
		System.out.println("CreateContact1");
		System.out.println("hiiiiiiiiiiiiii");
	}

}
