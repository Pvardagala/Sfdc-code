package com.sfdcTestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfdcPageObjects.AccountsPage;
import com.sfdcPageObjects.OpertunitiesPage;

public class OpertunitiesTest extends BaseTest {

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
	 public void verifyOpertunitiesDropdown_TC15() throws InterruptedException {
		 
		 if(reUsable.waitForElementClickable(driver, opertunitiesPage.opertunity)) {
			 opertunitiesPage.opertunity.click();
			 Thread.sleep(2000);
			Assert.assertTrue(opertunitiesPage.veriryOpertunitiesMenu(driver,opertunitiesPage.selectOpertunitiesMenu), "Failed to verify Opertunities List");
			System.out.println("Verified");
		 }
		 else {
		 System.out.println("Not Verified");
		 }
	 }
	 @Test
	 public void createOppertunity_TC16() throws InterruptedException {
		 if(reUsable.waitForElementClickable(driver, opertunitiesPage.opertunity)) {
			 opertunitiesPage.opertunity.click();
			 Thread.sleep(2000);
			Assert.assertTrue(opertunitiesPage.createNewOppertunity(driver,AccountsPage.createNewButton), "Failed to create new Opertunities");
			System.out.println("created Oppertunity");
		 }
		 else {
		 System.out.println("Not created");
		 }
	 }
	 @Test
	 public void oppertunitiesPipeline_TC17() throws InterruptedException {
		 if(reUsable.waitForElementClickable(driver, opertunitiesPage.opertunity)) {
			 opertunitiesPage.opertunity.click();
			 Thread.sleep(2000);
			Assert.assertTrue(opertunitiesPage.oppertunitiesPipeLine(driver,opertunitiesPage.oppertunitiesPipeline), "Failed to display Opertunities");
			System.out.println(" Oppertunity pipeline page is displayed");
		 }
		 else {
		 System.out.println("Not displayed");
		 }
	 }
	 @Test
	 public void stuckOppertunity_TC18() throws InterruptedException {
		 if(reUsable.waitForElementClickable(driver, opertunitiesPage.opertunity)) {
			 opertunitiesPage.opertunity.click();
			 Thread.sleep(2000);
			Assert.assertTrue(opertunitiesPage.stuckOnOppertunities(driver,opertunitiesPage.stuckOnoppertunity), "Failed to display stuck on Opertunities");
			System.out.println("Stuck on Oppertunity page is displayed");
		 }
		 else {
		 System.out.println("Not displayed");
		 }
	 }
	 @Test
	 public void quarterlySummary_TC19() throws InterruptedException {
		 if(reUsable.waitForElementClickable(driver, opertunitiesPage.opertunity)) {
			 opertunitiesPage.opertunity.click();
			 Thread.sleep(2000);
			Assert.assertTrue(opertunitiesPage.quarterlySummary(driver,opertunitiesPage.selectInclude), "Failed to display Quarterly summary Opertunities");
			System.out.println("Quarterly Summary report is displayed");
		 }
		 else {
		 System.out.println("Not displayed");
		 }
	 }
}
