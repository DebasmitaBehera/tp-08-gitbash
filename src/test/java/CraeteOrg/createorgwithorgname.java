package CraeteOrg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createorgwithorgname {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop/commondata.properties");
		Properties p=new Properties();
		p.load(fis);

		String BROWSER = p.getProperty("Browser");
		String URL=p.getProperty("Url");
		String USERNAME=p.getProperty("UserName");
		String PASSWORD=p.getProperty("Password");
		Random ran=new Random();
		int random=ran.nextInt(1000);
		FileInputStream fiss=new FileInputStream("./testdata/Orgnztn.xlsx");
		Workbook w=WorkbookFactory.create(fiss);
		Sheet sh = w.getSheet("org");
		Row row=sh.getRow(1);
		 String orgname = row.getCell(2).toString()+ random ;
		 w.close();
	      WebDriver driver=null;
	      if(BROWSER.equals("edge"))
			{
				driver = new EdgeDriver();
				
			}
			else if (BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			}
			else if (BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
		}
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			String text = driver.findElement(By.className("dvHeaderText")).getText();
			System.out.println(text);
			if(text.contains(orgname)) {
				System.out.println(text + "is verified ==Pass");
			}
			else {
				System.out.println(text + "is not verified ==FAIL");
			}
			 driver.quit();
	}

}
