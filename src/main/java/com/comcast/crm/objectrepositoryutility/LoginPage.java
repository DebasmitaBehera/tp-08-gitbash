package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {//rule1 create a seprate class foe every page
	//rule2 object creation
	
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
		userEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		LoginBtn.click();
	}
	
	
}
