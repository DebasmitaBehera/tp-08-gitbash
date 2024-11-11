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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrgWithIndname {

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
			Sheet sh = w.getSheet("Sheet3");
			Row row=sh.getRow(4);
		      String orgname = row.getCell(2).toString()+ random ;
		      String induestry = row.getCell(3).toString() ;
		      String type = row.getCell(4).toString();
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
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

				driver.findElement(By.name("accountname")).sendKeys(orgname);
				
				//industeries
				WebElement ind= driver.findElement(By.xpath("//select[@name='industry']"));
				Select sl=new Select(ind);
				//sl.selectByValue("Apparel");
				sl.selectByVisibleText(induestry);//excel sheet data
				
				//Type
				WebElement typefild = driver.findElement(By.name("accounttype"));
				Select select2=new Select(typefild);
				select2.selectByVisibleText(type);
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//verify the industeries and type
		String actinds = driver.findElement(By.id("mouseArea_Industry")).getText();
				//String text = actIndus.getText();
				//System.out.println(actIndus);
				if(actinds.contains(induestry)) {
					System.out.println(actinds + "is verified ==Pass");
				}
				else {
					System.out.println(actinds + "is not verified ==FAIL");
				}
				
				//Type
				String actType = driver.findElement(By.id("dtlview_Type")).getText();
				if(actType.equals(type)) {
					System.out.println(actType+ "is verified ==Pass");
				}
				else {
					System.out.println(actType+ "is not verified ==FAIL");
				}
				/*Actions action=new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		       driver.findElement(By.linkText("Sign Out")).click();*/
		       driver.quit();


			}
}


