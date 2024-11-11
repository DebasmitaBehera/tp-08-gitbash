package CraeteOrg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class TrbleTcktTitle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		Sheet sh = w.getSheet("Sheet5");
		Row row=sh.getRow(1);
		 String title = row.getCell(2).toString()+ random ;
		
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Trouble Tickets")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.name("ticket_title")).sendKeys(title);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			String text = driver.findElement(By.className("dvHeaderText")).getText();
			if(text.contains(title)) {
				System.out.println(text + "is verified ==Pass");
			}
			else {
				System.out.println(text + "is not verified ==FAIL");
				
			}
			
			
	}

}
