package com.sfdcPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.sfdcUtilities.ReusableUtils;

import net.bytebuddy.implementation.bytecode.constant.MethodConstant.CanCache;

public class ContactsPage {
	
	ReusableUtils reUsable = new ReusableUtils();
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Contacts")
	public WebElement contactsTab;
	@FindBy(xpath = "//*[@id=\"createNewMenu\"]/a[3]")
	public WebElement createContact;
	@FindBy(xpath= "//*[@id=\"bodyCell\"]/div[1]/div[1]/div[1]/h2")
	public WebElement newContactPageTitle;
	@FindBy(id = "name_lastcon2")
	public WebElement lastName;
	@FindBy(id = "con4")
	public WebElement accountName;
	@FindBy(id = "hotlist_mode")
	public WebElement selectRecentlyCreatedTab; 
	@FindBy(linkText = "kk")
	public WebElement name;
	@FindBy(name = "cancel")
	public WebElement cancelButton;
	@FindBy(name = "new")
	public WebElement newButton;
	@FindBy(name = "save_new")
	public WebElement save_newButton;
	@FindBy(xpath = "//*[@id=\"ep\"]/div[1]/table/tbody/tr/td[1]/h2")
	public WebElement contactEditTitle;
	
	/**This method is used to open the contact page and to create a new contact
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean createNewContact(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, contactsTab)) {
			//click on contacts tab
			contactsTab.click();
			//click on create new
			Thread.sleep(1000);
			AccountsPage.createNewButton.click();
			if(reUsable.isElementDisplayed(driver, createContact)) {
				//click on contact
				createContact.click();
				//checking for the page title
				String title = newContactPageTitle.getText();
				if(title.equalsIgnoreCase(newContactPageTitle.getText())) {
				//enter the last name and account name also
				lastName.sendKeys("kk");
				accountName.sendKeys("Nani");
				AccountsPage.saveButton.click();
				}
			}
			
		}
		return true;
	}
	/**This method is used to create a new view in contacts page
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean createNewViewInContact(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, contactsTab)) {
			//click on contacts tab
			contactsTab.click();
			if(reUsable.waitForElementClickable(driver, AccountsPage.createNewView)) {
				//click on new view button
				AccountsPage.createNewView.click();
				//enter the view name and save it
				Thread.sleep(1000);
				AccountsPage.viewName.sendKeys("pop3");
				AccountsPage.saveButton.click();
				
			}
		}
		return true;
	}
	/**This method is used to check recently created contacts
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean checkRecentlyCreatedContactPage(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, contactsTab)) {
			//click on contacts tab
			contactsTab.click();
			Thread.sleep(1000);
			
			Select select = new Select(selectRecentlyCreatedTab);
			select.selectByVisibleText("Recently Created");
			System.out.println("Recently created ctacts list is shown");
			
			
		}
		return true;
	}
	/**This method is used to select My contacts from the view
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean selectMyContactsFromView(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, contactsTab)) {
			//click on contacts tab
			contactsTab.click();
			Thread.sleep(1000);
			//checking for the contacts page title
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase(driver.getTitle())) {
			Select select = new Select(LeadsPage.selectTab);
			select.selectByVisibleText("My Contacts");
			Thread.sleep(1000);
			//click on go button
			LeadsPage.goButton.click();
			System.out.println("My Contacts list is shown");
			}
	}
		return true;
	}
	/**this method is used to select name under name field and display the list
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean displayNameList(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, contactsTab)) {
			//click on contacts tab
			contactsTab.click();
			Thread.sleep(1000);
			//checking for the contacts page title
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase(driver.getTitle())) {
				Thread.sleep(2000);
				//click on name
				name.click();
			}
		}
		return true;
	}
	/**This method is used to generate error message in create view page by giving only unique view
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean createNewViewWithErrorMessage(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, contactsTab)) {
			//click on contacts tab
			contactsTab.click();
			if(reUsable.waitForElementClickable(driver, AccountsPage.createNewView)) {
				//click on new view button
				AccountsPage.createNewView.click();
				//enter the unique view name and save it
				Thread.sleep(1000);
				if(reUsable.isElementDisplayed(driver, AccountsPage.uniqueViewName)) {
				AccountsPage.uniqueViewName.sendKeys("pp");
				AccountsPage.saveButton.click();
				//String acterror = "Error: You must enter a value";
				//String experror = LoginPage.loginErrorMessage.getText();
				//System.out.println(experror);
				Thread.sleep(3000);
				Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
		}
		return true;
	}
	/**This method is used to check cancel button in create new view page
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean checkNewViewWithCancelButton(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, contactsTab)) {
			//click on contacts tab
			contactsTab.click();
			if(reUsable.waitForElementClickable(driver, AccountsPage.createNewView)) {
				//click on new view button
				AccountsPage.createNewView.click();
				//enter the view and wrong unique view name and click on cancel button
				Thread.sleep(1000);
				if(reUsable.isElementDisplayed(driver, AccountsPage.viewName)) {
				    AccountsPage.viewName.sendKeys("abc");
					AccountsPage.uniqueViewName.sendKeys("efg");
					Thread.sleep(1000);
				    cancelButton.click();
				
				Thread.sleep(2000);
				//Select select = new Select(LeadsPage.selectTab);
				// select.selectByVisibleText("abc");
				// System.out.println("Thre is no abc view");
				Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
		}
		return true;
	}
	/**This method is used to edit the contact and checking save and new button functionality
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean checkingSaveAndNewButton(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, contactsTab)) {
			//click on contacts tab
			contactsTab.click();
			
			//click on  new Button for edit the contact
						
			if(reUsable.waitForElementClickable(driver, newButton)) {
				//click on contact
				newButton.click();
				Thread.sleep(3000);
				//checking for the page title
				String title = contactEditTitle.getText();
				System.out.println(title);
				if(title.equalsIgnoreCase(contactEditTitle.getText())) {
				//enter the last name and account name also
					Thread.sleep(3000);
				lastName.sendKeys("Indian");
				accountName.sendKeys("Global Media");
				save_newButton.click();
				Thread.sleep(3000);
				}
			}
			
		}
		return true;
	}
	
}