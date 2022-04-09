package com.sfdcPageObjects;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.sfdcUtilities.ReadTestDataFileUtils;
import com.sfdcUtilities.ReusableUtils;

public class LoginPage {
	
	public ReadTestDataFileUtils read = new ReadTestDataFileUtils();
	ReusableUtils reUsable = new ReusableUtils();
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "logo")
	public WebElement logo;
	@FindBy(name = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement login;
	
	@FindBy(id = "rememberUn")
	public WebElement rememberMe;
	
	@FindBy(id = "error")
	public static WebElement loginErrorMessage;
	
	@FindBy(id  = "userNav-arrow")
	public WebElement userMenu;
	
	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logout;
	
	@FindBy(partialLinkText = "Forgot")
	public WebElement forgotPassword;
	
	@FindBy(id = "continue")
	public WebElement continueButton;
	
	@FindBy(id = "un")
	public WebElement forgotPageUsername;
	
	

	
  
   public void clickLogin() {
		
		login.click();
	}
   public void getRememberMe() {
	   
	   rememberMe.click();
   }
   public boolean getUserMenu(WebDriver driver,WebElement element) {
	   boolean isUsermenuDisplayed = false;
	   if(reUsable.isElementDisplayed(driver,userMenu)) {
		userMenu.click();
		isUsermenuDisplayed = true;
	   }
	   return isUsermenuDisplayed;
	}
   public boolean getLoginErrorMsg() throws IOException {
	   
	    loginErrorMessage.sendKeys(read.readPageValidationsFile("loginpage.errorMessage"));
	    return true;
   }
  
   public  void loginToApp(WebDriver driver) throws IOException, InterruptedException {
		if(reUsable.waitForElementClickable(driver,username)) {
	    username.sendKeys(read.readUserAccountsFile("username.prod"));
		password.sendKeys(read.readUserAccountsFile("password.prod"));
		login.click();
	}
   }

}
