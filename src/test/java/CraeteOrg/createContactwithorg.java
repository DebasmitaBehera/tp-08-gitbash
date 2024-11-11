package CraeteOrg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createContactwithorg {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		Sheet sh = w.getSheet("Sheet9");
		Row row = sh.getRow(7);
	      String orgname = row.getCell(2).toString()+ random ;
	      String lastname = row.getCell(3).toString();
	      w.close();
	      WebDriver driver = null;
			if(BROWSER.equals("chrome")) {
				driver= new ChromeDriver();
			}
			else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();}
			else {
				driver= new ChromeDriver();
			}
			
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			Thread.sleep(2000);
			driver.findElement(By.id("submitButton")).click();

			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			//verify the header msg expected result
			String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerInfo.contains(orgname)) {
				System.out.println(headerInfo+ "is created ==Pass");
			}
			else {
				System.out.println(headerInfo+ "is not created ==FAIL");
			}
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			Thread.sleep(2000);
			
				driver.findElement(By.name("lastname")).sendKeys(lastname);
				
				//click on + and add org
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				
				//Switch to child window
				Set<String> childwindow = driver.getWindowHandles();
				for(String window:childwindow) {
					driver.switchTo().window(window);
					if(driver.getCurrentUrl().contains("module=Accounts")) {
						break;
					}
				}
				/*Iterator<String> childcoll = childwindow.iterator();
				while(childcoll.hasNext()) {
					String windowID = childcoll.next();
					driver.switchTo().window(windowID);
					String actUrl = driver.getCurrentUrl();
					if(actUrl.contains("module=Accounts")) {
						break;
					}
				}*/
				
				//enter the orgname insearchfield and click on search
				driver.findElement(By.name("search_text")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				
				//Dynamic xpath
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
				
				//switch to parent
				Set<String> parentwindow = driver.getWindowHandles();
				for(String windowid:parentwindow) {
					driver.switchTo().window(windowid);
					if(driver.getCurrentUrl().contains("Contacts&action")) {
						break;
					}
				}
				//click on save button
				driver.findElement(By.name("button")).click();
			
				//verify the header msg expected result
				headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(headerInfo.contains(lastname)) {
					System.out.println(headerInfo+ "is created ==Pass");
				}
				else {
					System.out.println(headerInfo+ "is not created ==FAIL");
				}
				//verify the orgname
				String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText().trim();
				System.out.println(actOrgName);
				System.out.println(orgname);
				if(actOrgName.equals(orgname)) {
					System.out.println(actOrgName+ "is created ==Pass");
				}
				else {
					System.out.println(actOrgName+ "is not created ==FAIL");
				}


				 driver.quit();




	}

}
