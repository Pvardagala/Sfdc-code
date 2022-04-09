package com.sfdcPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sfdcUtilities.ReusableUtils;

public class AccountsPage {
	
	ReusableUtils reUsable = new ReusableUtils();
	
	public AccountsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//*[@id=\"Account_Tab\"]/a")
	public WebElement accounts;
	
	@FindBy(id = "createNewButton")
	public static  WebElement createNewButton;
	@FindBy(xpath = "//*[@id=\"createNewMenu\"]/a[4]")
	public WebElement newAccounts;
	@FindBy(id = "acc2")
	public WebElement accountName;
	@FindBy(xpath = "(//*[@title='Save'])[1]")
	public static WebElement saveButton;
	@FindBy(linkText = "Create New View")
	public static WebElement createNewView;
	@FindBy(id = "fname")
	public static WebElement viewName;
	@FindBy(id = "devname")
	public static WebElement uniqueViewName;
	@FindBy(id = "fcf")
	public WebElement selectViewName;
	@FindBy(id = "fcol1")
	public WebElement selectField;
	@FindBy(className = "operator")
	public WebElement selectOperator;
	@FindBy(id = "fval1")
	public WebElement value;
	@FindBy(id ="colselector_select_0")
	public WebElement availableFields;
	@FindBy(linkText = "Edit")
	public WebElement edit;
	@FindBy(partialLinkText = "Accounts with last activity > 30 days")
	public WebElement lastActivity;
	@FindBy(id = "ext-gen152")
	public WebElement date1;
	@FindBy(id = "ext-gen276")
	public WebElement fromDate;
	@FindBy(id = "ext-gen154")
	public WebElement date2;
	@FindBy(id = "ext-gen295")
	public WebElement toDate;
	@FindBy(id = "ext-gen63")
	public WebElement runReport;
	@FindBy(id = "ext-gen49")
	public WebElement saveReport;
	@FindBy(name = "reportName")
	public WebElement reportName;
	@FindBy(name = "reportDevName")
	public WebElement reportUniqueName;
	@FindBy(id = "ext-gen318")
	public WebElement saveAndRun;
	 
	
	
	/**This method is used to select Accounts tab on home page
	 * @param driver
	 */
	public void selectAccounts(WebDriver driver) {
		if(reUsable.waitForElementClickable(driver, accounts)) {
			accounts.click();
		}
	}
	
	/**This method is used to create a new account
	 * @param driver
	 * @param element
	 * @return
	 */
	public boolean createAccount(WebDriver driver,WebElement element) {
		boolean isAccountCreated = false;
		if(reUsable.waitForElementClickable(driver, accounts)) {
			accounts.click();
			if(reUsable.waitForElementClickable(driver, createNewButton)) {
				createNewButton.click();
				if(reUsable.waitForElementClickable(driver, newAccounts)) {
					newAccounts.click();
				    //accountName.click();
					accountName.sendKeys("Ajay");
					saveButton.click();
				
				}
				
				isAccountCreated = true;
			}
		}
		else
		{
			System.out.println("Threre is no Accounts tab");
		}
		return isAccountCreated;
	}
	/**This method is used to create a new view
	 * @param driver
	 * @param element
	 * @return
	 */
	public boolean createNewView(WebDriver driver,WebElement element) {
		boolean isNewViewCreated = false;
		selectAccounts(driver);
		if(reUsable.waitForElementClickable(driver, createNewView)) {
			createNewView.click();
			if(reUsable.isElementDisplayed(driver, viewName)) {
			viewName.sendKeys("Gk");
			uniqueViewName.sendKeys("Gk");
			saveButton.click();
			}
				
			isNewViewCreated = true;
		}
		return isNewViewCreated;
	}
	/**This method is used to edit the view name
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean editView(WebDriver driver,WebElement element) throws InterruptedException {
		boolean isviewedited = false;
		if(reUsable.waitForElementClickable(driver, accounts)) {
		selectAccounts(driver);
		}
		Thread.sleep(1000);
		Select viewTab = new Select(selectViewName);
		 viewTab.selectByVisibleText("Gk");
		 edit.click();
		 if(reUsable.waitForVisibilityOfElement(driver, viewName)) {
			 viewName.clear();
			 viewName.sendKeys("Gt");
			 Select field = new Select(selectField);
			 field.selectByVisibleText("Account Name");
			 Select operator = new Select(selectOperator);
			 operator.selectByVisibleText("contains");
			 value.sendKeys("a");
			 Select available = new Select(availableFields);
			 available.selectByVisibleText("Last Activity");
			 if(reUsable.waitForElementClickable(driver, UsermenuPage.addTab)) {
				 UsermenuPage.addTab.click();
				 saveButton.click();
			 }
			 isviewedited = true;
		 }
		 return isviewedited;
	}
	public boolean createReports(WebDriver driver,WebElement element) throws InterruptedException {
		boolean isReportCreated = false;
		if(reUsable.waitForElementClickable(driver, accounts)) {
		selectAccounts(driver);
		   if(reUsable.waitForVisibilityOfElement(driver, lastActivity)) {
			   lastActivity.click();
			   Thread.sleep(3000);
			   date1.click();
			   Thread.sleep(2000);
			   fromDate.click();
			   Thread.sleep(3000);
			  // date2.clear();
			  // date2.click();
			  // Thread.sleep(5000);
			   
			  // toDate.click();
			   Thread.sleep(4000);
			   saveReport.click();
			   reportName.sendKeys("Second");
			  // reportUniqueName.sendKeys("Second");
			   Thread.sleep(4000);
			   saveAndRun.click();
			   Thread.sleep(6000);
			  // runReport.click();
			   isReportCreated = true;
		   }
		   
		}
		return isReportCreated;
		
	}
    
}



