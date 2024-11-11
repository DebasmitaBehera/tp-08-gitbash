package practice_pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AutoHealing {

	// TODO Auto-generated method stub
	@FindBy(name="user_name")
	WebElement ele1;
	
	@FindBy(name="user_password")
	WebElement ele2;
	
	@FindAll({@FindBy(id = "sub"),@FindBy(xpath = "//input[@type='submit']")})
	WebElement ele3;
	


@Test
public void sampleTest()
{
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/");
SampleTestWitPOM s=PageFactory.initElements(driver, SampleTestWitPOM.class);
s.ele1.sendKeys("admin");
s.ele2.sendKeys("password");
driver.navigate().refresh();
s.ele1.sendKeys("admin");
	
	s.ele2.sendKeys("password");
	s.ele3.click();
	}
}

