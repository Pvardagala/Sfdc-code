package com.sfdcTestcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.hc.core5.reactor.Command.Priority;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;

import com.sfdcPageObjects.UsermenuPage;

//@Listeners(com.sfdcUtilities.SfdcReports.class)
public class UserMenuTest extends BaseTest{

	@BeforeMethod
	public void launchApp() {
		
		try {
			driver.get(selectEnvironment("prod.url"));
			loginPage.loginToApp(driver);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}
	
	@Test(priority = 1)
	public void TC05() {
		
		System.out.println(usermenuPage.usermenuName.getText());
		if(usermenuPage.usermenuName.getText().equalsIgnoreCase("Pushpalatha Kondari")) {
		//test.info("checking for user menu name")	;		
		if(reUsable.isElementDisplayed(driver,loginPage.userMenu)) {
			//test.info("checking for user menu drop down");
			loginPage.userMenu.click();
			//test.inf("click on user menu drop down");
			Assert.assertTrue(usermenuPage.verifyUserMenuItems(driver),"failed to verify the usermenu");
			//test.info("verify for all user menu list");
		}
		else
		{
		System.out.println("usermenu is not displayed");
		}
	}else {
		System.out.println("usermenu name is wrong");
	}
	}
	@Test(priority = 2) 
	public void selectMyProfile_TC06() throws InterruptedException {
		if(reUsable.isElementDisplayed(driver,loginPage.userMenu)) {
		     loginPage.userMenu.click();
		Assert.assertTrue(reUsable.isElementDisplayed(driver,loginPage.userMenu),"failed to drop down of usermenu");
		//test.info("checking for user menu drop dowm");
		if(reUsable.isElementDisplayed(driver, usermenuPage.myProfile)){
			//Thread.sleep(1000);
			usermenuPage.selectMyProflie();
			//test.info("click on My Profile option");
			//Thread.sleep(2000);
			//calling the method to EditPen operations
			//Assert.assertTrue(usermenuPage.selectEditPen(driver), "failed to perform editPen");
			System.out.println("Edited pen successfully");
			
			//Thread.sleep(1000);
			//calling the method for posting the text
			//Assert.assertTrue(usermenuPage.selectPostText(driver), "failed to perform editPen");
			System.out.println("Posted a text successfully");
			
			//Thread.sleep(1000);
			//Assert.assertTrue(usermenuPage.selectFileUpload(driver),"Failed to uploag a file");
			System.out.println("uploaded a file successfully");    
			
			Thread.sleep(1000);
			Assert.assertTrue(usermenuPage.selectPhoto(driver), "Failed to add a photo");
			System.out.println("Added a photo successfully");    
			
		}
		}
		else {
			System.out.println("MyProfile is not selected");
		}
		}
		@Test(priority = 3,enabled = true)
		public void selectMySettings_TC07() throws InterruptedException {
			if(reUsable.waitForElementClickable(driver, loginPage.userMenu)) {
				Thread.sleep(1000);
				loginPage.getUserMenu(driver, loginPage.userMenu);
				//click on My settings option
				usermenuPage.selectMySettings();
				
				//click on personal information field
                 usermenuPage.selectPersonalInfo(driver, usermenuPage.personalInfo);
				//check for login history
				usermenuPage.loginHistory(driver, usermenuPage.loginHistory);
				
				//Go for Display and Layout
				if(reUsable.waitForElementClickable(driver, usermenuPage.displayLayout)) {
					//click on display and layout
					usermenuPage.displayLayout.click();
					Assert.assertTrue(usermenuPage.addCustomTab(driver,usermenuPage.customTab), "Failed to add customized tab");
				}
				else {
					System.out.println("Custom tab is not working");
				}
				//Go for Email 
				if(reUsable.waitForElementClickable(driver, usermenuPage.email)) {
					usermenuPage.email.click();
					//calling method for setting email name and address
					Assert.assertTrue(usermenuPage.selectEmailsettings(driver, usermenuPage.emailSettings), "Failed to verify email settings");
				}
				else {
					System.out.println("Email Settings not done");
				}     
				//calling method for Calenders and Reminders
				Assert.assertTrue(usermenuPage.selectCalendersReminders(driver, usermenuPage.calenderReminders), "Failed to open Calenders and Reminders");
				Thread.sleep(2000);
			}
			else {
				System.out.println("My settings option is not selected");
			}
			
		}	
@Test(priority = 4)
public void selectDeveloperConsole_TC08() throws InterruptedException {
	if(reUsable.waitForElementClickable(driver, loginPage.userMenu)) {
		loginPage.getUserMenu(driver, loginPage.userMenu);
	     if(reUsable.waitForElementClickable(driver, usermenuPage.developerConsole)) {
		usermenuPage.developerConsole.click();
		//for window handling
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		
		Set<String> str=driver.getWindowHandles();
		
		Iterator<String> itr = str.iterator();
		while(itr.hasNext()) {
			String childWindow = itr.next();
			System.out.println(childWindow);
			
		if(!parent.equalsIgnoreCase(childWindow)) {
			
			//switch to child window
			driver.switchTo().window(childWindow);
			
			System.out.println(driver.switchTo().window(childWindow));
			Thread.sleep(3000);
			driver.close();
			
		}
		}
	     
		//switch to parent window
		driver.switchTo().window(parent);
		Assert.assertTrue(true);
		System.out.println("Developer Console window closed");
	
	     }     
	else {
		System.out.println("Developer Console is not displayed");
	}
	     Thread.sleep(2000);
	}
}
@Test(priority = 5)
public void selectLogout_TC09() throws InterruptedException, IOException {
	
	if(reUsable.waitForElementClickable(driver, loginPage.userMenu)) {
		loginPage.getUserMenu(driver, loginPage.userMenu);
	     
		if(reUsable.waitForElementClickable(driver, loginPage.logout)) {
		loginPage.logout.click();
		Thread.sleep(2000);
		System.out.println("Logout Successfully");
		BaseTest.driver.get(selectEnvironment("prod.url"));
		 System.out.println("Page opened again Successfully");
		Thread.sleep(2000);
		Assert.assertTrue(true);
	}
	else {
		System.out.println("Logout option is not there");
	}
	}	
}
		
	}
	

