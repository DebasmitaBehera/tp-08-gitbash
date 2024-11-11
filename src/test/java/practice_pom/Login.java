package practice_pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.objectrepositoryutility.LoginPage;

public class Login {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888");
		
		LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
		//
//lp.getLoginBtn().sendKeys("admin");
//lp.getPasswordEdt().sendKeys("password");
//lp.getLoginBtn().click();
		//
lp.LoginToApp("admin","password");
	}

}
