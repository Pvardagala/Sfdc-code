package com.sfdcTestcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfdcPageObjects.LoginPage;

public class LeadsTest extends BaseTest {

	 @BeforeMethod	
	  public void launchApp() {
			
			try {
				driver.get(selectEnvironment("prod.url"));
				loginPage.loginToApp(driver);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				
		} 
	@Test
	 public void leadsTab_TC20() throws InterruptedException {
		 Thread.sleep(2000);
		 Assert.assertTrue(leadsPage.verifyleadsPage(driver, leadsPage.leadsTab), "failed to navigate to Leads page");
		 System.out.println("leads page opened successfully");
	 }
	@Test
	public void slectLeadsView_TC21() throws InterruptedException {
		 Assert.assertTrue(leadsPage.verifyleadsPage(driver, leadsPage.leadsTab), "failed to navigate to Leads page");
		 System.out.println("leads page opened successfully");
		 Assert.assertTrue(leadsPage.veriryLeadsView(driver, leadsPage.selectTab), "failed to view Leads list");
		 System.out.println("leads view verified");
	 }
	@Test
	public void defaultView_TC22() throws IOException, InterruptedException {
		Assert.assertTrue(leadsPage.verifyleadsPage(driver, leadsPage.leadsTab), "failed to navigate to Leads page");
		 System.out.println("leads page opened successfully");
		 Thread.sleep(2000);
		 Select select = new Select(leadsPage.selectTab);
		 select.selectByVisibleText("Today's Leads");
		 Thread.sleep(1000);
		 if(reUsable.waitForElementClickable(driver, loginPage.userMenu)) {
				loginPage.getUserMenu(driver, loginPage.userMenu);
			     
				if(reUsable.waitForElementClickable(driver, loginPage.logout)) {
				loginPage.logout.click();
				Thread.sleep(2000);
				System.out.println("Logout Successfully");
				driver.get(selectEnvironment("prod.url"));
				loginPage.loginToApp(driver);
				 System.out.println("Page opened again Successfully");
				Thread.sleep(2000);
				Assert.assertTrue(leadsPage.verifyleadsPage(driver, leadsPage.leadsTab), "failed to navigate to Leads page");
				if(reUsable.waitForElementClickable(driver, leadsPage.goButton)) {
					leadsPage.goButton.click();
				}
				System.out.println("Leads page is opened with default view");
				Assert.assertTrue(true);
				}
		 }
		 
		 
	}
	@Test
	public void todaysLeads_TC23() throws InterruptedException {
		Assert.assertTrue(leadsPage.verifyleadsPage(driver, leadsPage.leadsTab), "failed to navigate to Leads page");
		 System.out.println("leads page opened successfully");
		 Thread.sleep(2000);
		 Assert.assertTrue(leadsPage.todaysLeadsPage(driver), "failed to navigate to Today'sLeads page");
		 System.out.println("Todays leads page opened successfully");
	}
	@Test
	 public void createNewLeads_TC24() throws InterruptedException {
		 Assert.assertTrue(leadsPage.verifyleadsPage(driver, leadsPage.leadsTab), "failed to navigate to Leads page");
		 System.out.println("leads page opened successfully");
		 if(reUsable.waitForElementClickable(driver, accountsPage.createNewButton)) {
			 accountsPage.createNewButton.click();
			 if(reUsable.waitForElementClickable(driver, leadsPage.createLeads)) {
			 leadsPage.createLeads.click();
			 Thread.sleep(2000);
			 leadsPage.lastName.sendKeys("ABCD");
			 Thread.sleep(2000);
			 leadsPage.companyName.sendKeys("ABCD");
			 Thread.sleep(2000);
			 accountsPage.saveButton.click();
			 
			 Assert.assertTrue(true);
			 }
		 }
	 }
	
}
