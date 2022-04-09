package com.sfdcTestcases;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest {
	
	 @BeforeMethod	
	  public void launchApp() {
			
			try {
				driver.get(selectEnvironment("prod.url"));
				loginPage.loginToApp(driver);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
				
		}
	 @Test(groups = "contacts")
	 public void createNewContact_TC25() throws InterruptedException {
		 
		 Assert.assertTrue(contactsPage.createNewContact(driver, contactsPage.contactsTab), "Failed to create a new contact");
		 System.out.println("Created a new contact successfully");
	 }
	 
	 @Test(groups = "contacts")
	 
	 public void createNewViewInContactPage_TC26() throws InterruptedException {
		 
		 Assert.assertTrue(contactsPage.createNewViewInContact(driver, contactsPage.contactsTab), "Failed to create a new view in contact page");
		 System.out.println("Created a new view in contact page  successfully");
		 //checking for the entered view name in the list
		 if(reUsable.waitForElementClickable(driver, leadsPage.selectTab)) {
		 Select select =  new Select(leadsPage.selectTab);
		 select.selectByVisibleText("pop3");
		 System.out.println("View is correct");
		 Assert.assertTrue(true);
	 }
		 else
		 {
			 Assert.assertTrue(false);
			 System.out.println("view name not entered");
		 }
	 
	 }
	 @Test( groups = "contacts")
	 public void checkRecentlyCreatedContacts_TC27() throws InterruptedException {
		 
		 Assert.assertTrue(contactsPage.checkRecentlyCreatedContactPage(driver, contactsPage.contactsTab), "Failed to show contact");
		 System.out.println("showing contact successfully");
	 }
	 @Test(groups = "contacts")
     public void selectMyContactsView_TC28() throws InterruptedException {
		 
		 logger.info("seleclted my contacts from view ");
		 Assert.assertTrue(contactsPage.selectMyContactsFromView(driver, contactsPage.contactsTab), "Failed to show My Contacts view");
		 System.out.println("showing My Contacts view successfully");
	 }
	 @Test(groups = "contacts")
    public void displayNameContacts_TC29() throws InterruptedException {
		 
		 logger.info("Display selected name contacts ");
		 Assert.assertTrue(contactsPage.displayNameList(driver, contactsPage.contactsTab), "Failed to show Name Contacts list");
		 System.out.println("showing selected name Contacts successfully");
	 }
	 @Test(groups = "contacts")
    public void createNewViewWithErrorMessage_TC30() throws InterruptedException {
		 
		 logger.info("Display Error message for View page ");
		 Assert.assertTrue(contactsPage.createNewViewWithErrorMessage(driver, contactsPage.contactsTab), "Failed to give Error message");
		 System.out.println("showing Error Message to create a new view successfully");
	 }
	 @Test(groups = "contacts")
    public void ckeckingNewViewWithcancelButton_TC31() throws InterruptedException {
		 
		 logger.info("Checking for functionalit of cancel button in create new View page ");
		 Assert.assertTrue(contactsPage.checkNewViewWithCancelButton(driver, contactsPage.contactsTab), "Failed to click on cancil button");
		 System.out.println("Cancel button is working successfully");
	 }
	 @Test(groups = "contacts")
   public void checkingContactEditWithSave_NewButton_TC32() throws InterruptedException {
		 
		 logger.info("Checking for functionalit of save-new button in contact edit page ");
		 Assert.assertTrue(contactsPage.checkingSaveAndNewButton(driver, contactsPage.contactsTab), "Failed to click on save and new button");
		 System.out.println("save-new button is working successfully");
	 }
	 
}
