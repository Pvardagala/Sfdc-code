package com.sfdcTestcases;



import java.io.IOException;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.sfdcUtilities.SfdcReports;

//@Listeners(SfdcReports.class)
public class LoginTest extends BaseTest {
	
	@BeforeMethod
	public void launchApp() {
		try {
		driver.get(selectEnvironment("prod.url"));
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
		
	}
	@Test(priority = 2)
	public void loginErrorMessage_TC01(Method name) throws IOException {
		
		//System.out.println(extent);
		//test = extent.createTest(name.getName());
		
		//checking for login page title
		
		String expectedTitle = read.readPageValidationsFile("loginpage.title");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		logger.info("checkig for the login page title");
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
				
			if(reUsable.isElementDisplayed(driver,loginPage.username)) { 
			loginPage.username.sendKeys(read.readUserAccountsFile("username.prod"));
			logger.info("Username is entered");
			//test.info("username entered");
						
			loginPage.password.clear();
			logger.info("Clear the password field");
			//test.info("clear the password field");
			
			if(reUsable.waitForElementClickable(driver, loginPage.login)) {
				loginPage.clickLogin();
				logger.info("click on login button");
				//test.info("click on login button");
				
				Assert.assertTrue(loginPage.getLoginErrorMsg(),"Failed to verify error message");
				//test.pass(name.getName());
			}
			else {
				System.out.println("Login button is not clickable");
			}
	
			}
			else {
				System.out.println("username field is not find");
			}
	}
	
	@Test(priority = 4)
	public void loginToSalesforce_2(Method name) throws IOException {
		
		//test = extent.createTest(name.getName());
		if(reUsable.waitForElementClickable(driver, loginPage.username)) {	
		loginPage.username.sendKeys(read.readUserAccountsFile("username.prod"));
		//test.info("username entered");
				
		 
		loginPage.password.sendKeys(read.readUserAccountsFile("password.prod"));
		//test.info("password entered");
		//Thread.sleep(3000);
		if(reUsable.waitForElementClickable(driver, loginPage.login)) {
			loginPage.clickLogin();
			Assert.assertTrue(true);
			System.out.println("yes");
		}
		
		
		else {
			Assert.assertTrue(false);
			System.out.println("no");
		}
		
		}	
	}
	@Test(priority = 3)
	public void checkRememberMe_3(Method name) throws IOException, InterruptedException {
		
		//test = extent.createTest(name.getName());
		
		loginPage.username.sendKeys(read.readUserAccountsFile("username.prod")); 
		//test.info("username entered");
		
		
		loginPage.password.sendKeys(read.readUserAccountsFile("password.prod")); 
		//test.info("password entered");
		
		
		 loginPage.getRememberMe();
		//test.info("click on rememberMe checkbox");
	    
		if(reUsable.waitForElementClickable(driver, loginPage.login)) {
			loginPage.clickLogin();
			
			loginPage.getUserMenu(driver,loginPage.userMenu);
		    // test.info("click on UserMenu");
			
		     loginPage.logout.click();
		    // test.info("click on login");
		     
		     Thread.sleep(1000);
		     if(reUsable.isElementDisplayed(driver, loginPage.username)) {
		    	 
		    	 System.out.println("Username field is appeared with username");
		    	
		     }
		     
		     Assert.assertTrue(true);
			
				}
			
		else {
			Assert.assertTrue(false);     
		}  
		
	}
	@Test(priority = 1)
	public void forgotPassword_4B(Method name) throws IOException, InterruptedException {
		//test = extent.createTest(name.getName());
		if(reUsable.waitForElementClickable(driver, loginPage.username)) {
		loginPage.username.sendKeys(read.readUserAccountsFile("username.invalid"));
		loginPage.password.sendKeys(read.readUserAccountsFile("password.invalid"));
		
		if(reUsable.waitForElementClickable(driver, loginPage.login)) {
		loginPage.clickLogin();
		Thread.sleep(2000);
		
		String actualError = read.readPageValidationsFile("loginpage.errorMessage2");
		String expectedError = loginPage.loginErrorMessage.getText();
		System.out.println(actualError);
		System.out.println(expectedError);
		if(expectedError.equalsIgnoreCase(actualError)) {
			Assert.assertTrue(true);
		}
		
		}
	}
		else
		{
			System.out.println("Login button is not clickable");
		}
			
		
	}
	@Test(enabled = false)
	public void forgotPassword_4A() throws IOException {
		
		loginPage.forgotPassword.click();
		
		 
		loginPage.forgotPageUsername.sendKeys(read.readUserAccountsFile("username.prod"));
		
		loginPage.continueButton.click();
		
	}

}

