package practice_pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.LoginPageusingconstructor;

public class LoginUsingConstructor {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888");
		LoginPageusingconstructor lp=new LoginPageusingconstructor(driver);
		lp.LoginToApp("admin","password");
		
}
}