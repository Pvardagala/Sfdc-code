package com.sfdcTestcases;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountsTest extends BaseTest {
  
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
	public void createAccount_TC10() {
		
		Assert.assertTrue(accountsPage.createAccount(driver, accountsPage.accounts), "Failed to create a new account");
		System.out.println("created a new account");
	}
	@Test
	public void createNewView_TC11() {
		
		Assert.assertTrue(accountsPage.createNewView(driver, accountsPage.createNewView), "Failed to create a new view");
		System.out.println("created a new view and unique view");
	}
	@Test
	public void editView_TC12() throws InterruptedException {
		
		Assert.assertTrue(accountsPage.editView(driver, accountsPage.viewName), "Failed to edit the view");
		System.out.println("edited to a new view ");
	}
	@Test
	public void createAccountsReport_TC14() throws InterruptedException {
		
		Assert.assertTrue(accountsPage.createReports(driver, accountsPage.lastActivity), "Failed to create a report");
		System.out.println("created a new report ");
	}

}
