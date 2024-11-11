package webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriverutility {
	//maximize the window
	public void maximizethewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	//minimize the window
		public void minimizethewindow(WebDriver driver)
		{
			driver.manage().window().minimize();
		}
		
		
	//implicitly wait
	 public void waitforpagetoload(WebDriver driver) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
	 }
	 
	 //explicitly wait
 public void explicitlywaitbyelementToBeSelected(WebDriver driver,WebElement element) {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	 wait.until(ExpectedConditions.elementToBeSelected(element));

 }
 
 
 public void explicitlywaitbyvisiblityofelement(WebDriver driver,WebElement element) {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	 wait.until(ExpectedConditions.visibilityOf(element));

 }
 
 
 public void explicitlywaitbyvisiblityofwebelements(WebDriver driver,WebElement element) {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
 
 
 public void explicitlywaitbyvisiblityofwebelements(WebDriver driver,WebElement element,String attribute) {
	 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	 wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
	 }
 
 
 //switch to window using url
 public void switchtonewbrowsertab(WebDriver driver,String partialurl) {
	 Set<String> set = driver.getWindowHandles();
	 Iterator<String> it=set.iterator();
	 while(it.hasNext()) {
		 String windowid=it.next();
		 driver.switchTo().window(windowid);
		 String acturl=driver.getCurrentUrl();
		 if(acturl.contains(acturl)) {
			 break;
		 }
	 }
 }
 
 
 //switch to parent frame
 public void switchtoparentframe(WebDriver driver) {
	 driver.switchTo().parentFrame();
 }
 
 
 //switch to default content
 public void switchtodefaultcontent(WebDriver driver) {
	 driver.switchTo().defaultContent();
 }
 
 
 //switch to window using title
 public void switchtontitle(WebDriver driver,String partialtitle) {
	 Set<String> set = driver.getWindowHandles();
	 Iterator<String> it=set.iterator();
	 while(it.hasNext()) {
		 String windowid=it.next();
		 driver.switchTo().window(windowid);
		 String acturl =driver.getCurrentUrl();
		 if(acturl.contains(partialtitle)) {
			 break;
		 }}}
 
 //switch to frame
 public void switchtoframe(WebDriver driver,int index) {
	 driver.switchTo().frame(index);
 }
 
 
 public void switchtoframe1(WebDriver driver,String text) {
	 driver.switchTo().frame(text);
 }
 
 
 public void switchtoframe2(WebDriver driver,WebElement ele) {
	 driver.switchTo().frame(ele);
 }
 
 //switch to alert
 public void switchtoalert(WebDriver driver) {
	 driver.switchTo().alert().accept();
 }

public void switchtoalert2(WebDriver driver) {
	 driver.switchTo().alert().dismiss();
}

//select by  index
public void selectbyindex(WebElement ele, int index) {
	Select s=new Select(ele);
	s.selectByIndex(index);
}

//select by name
public void selectbyname(WebElement ele, String name) {
	Select s=new Select(ele);
	s.deselectByVisibleText(name);
}


//select by value
public void selectbyvalue(WebElement ele, String value) {
	Select s=new Select(ele);
	s.deselectByValue(value);
}

//action
public void performmouseaction(WebDriver driver,WebElement ele) {
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	
}
//right click on element
public void performmouseaction2(WebDriver driver,WebElement ele) {
	Actions act=new Actions(driver);
	act.contextClick(ele).perform();
	
}


//click on element
public void clickonelement(WebDriver driver,WebElement ele) {
	Actions act=new Actions(driver);
	act.click(ele);
}


public void performmouseaction(WebDriver driver,WebElement ele1,WebElement ele2) {
	Actions act=new Actions(driver);
	act.dragAndDrop(ele1, ele2);
}
	
public void performmouseaction(WebDriver driver,WebElement ele1,int x,int y) {
	Actions act=new Actions(driver);
	act.dragAndDropBy(ele1, x, y);
}
	
//double click on element
public void doubleclickonelement(WebDriver driver,WebElement ele) {
	Actions act=new Actions(driver);
	act.doubleClick(ele);}
//screenshot

public void takescreenshotOfWebpage(WebDriver driver,String homepage) throws IOException {
	TakesScreenshot  ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshot" +homepage+"/.png");
	FileHandler.copy(src, dest);
}

public void takescreenshotofelement(WebDriver driver,String srchbtn,WebElement ele) throws IOException {
	File src=ele.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshot" +srchbtn+"/.png");
	FileHandler.copy(src, dest);

}}
