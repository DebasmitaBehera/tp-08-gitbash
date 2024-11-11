package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageusingconstructor
{
	WebDriver driver;
	public LoginPageusingconstructor(WebDriver driver) 
	{
		this.driver=driver;
		 PageFactory.initElements(driver,this);
		 
		 
	}
	@FindBy(name="user_name")
	 private WebElement userEdt;
	
	@FindBy(name="user_password")
	 private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	 private WebElement LoginBtn;
	
	//rule 3-object initialization
	//rule 4-object encapsulation

	public WebElement getUserEdt() {
		return userEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
//rule 5-we can provide action
	public void LoginToApp(String username,String password)
	{
		driver.manage().window().maximize();
		userEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		LoginBtn.click();
	}
	
	
}

