package com.sfdcPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sfdcUtilities.ReusableUtils;

public class OpertunitiesPage {
	
	ReusableUtils reUsable = new ReusableUtils();
	
	public OpertunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Opportunities")
	public WebElement opertunity;
	@FindBy(tagName = "select")
	public WebElement selectOpertunitiesMenu;
	@FindBy(xpath = "//*[@id='fcf']/option")
	public List<WebElement> opertunitiesList;
	@FindBy(xpath = "//*[@id=\"createNewMenu\"]/a[5]")
	public WebElement createOppertunity;
	@FindBy(id = "opp3")
	public WebElement oppertunityName;
	@FindBy(id = "opp4")
	public WebElement accountName;
	@FindBy(id = "opp9")
	public WebElement closeDate;
	@FindBy(className = "calToday")
	public WebElement todayDate;
	@FindBy(id = "opp11")
	public WebElement selectStage;
	@FindBy(linkText = "Opportunity Pipeline")
	public WebElement oppertunitiesPipeline;
	@FindBy(xpath = "//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")
	public WebElement oppertunitiesPipelineTitle;
	@FindBy(linkText = "Stuck Opportunities")
	public WebElement stuckOnoppertunity;
	@FindBy(xpath = "//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")
	public WebElement stuckOnoppertunityTitle;
	@FindBy(id ="quarter_q")
	public WebElement selectInterval;
	@FindBy(id ="open")
	public WebElement selectInclude;
	@FindBy(xpath = "//input[@title='Run Report']")
	public WebElement runReport;
	@FindBy(xpath = "//*[@id=\"noTableContainer\"]/div/div[1]/div[1]/div[1]/h1")
	public WebElement runReportTiltle;
	
	
	/**This method is used to verify opertunities drop down with all list
	 * @param driver
	 * @param element
	 * @return
	 * @throws InterruptedException
	 */
	public boolean veriryOpertunitiesMenu(WebDriver driver,WebElement element) throws InterruptedException {
		boolean isVerified = false;
		Thread.sleep(3000);
		Select select = new Select(selectOpertunitiesMenu);
		
		String[] options = {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week","New Last Week",
				"Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
		System.out.println(options.length);
		for(int i=0; i < options.length; i++) {
			//opertunitiesList = select.getFirstSelectedOption().getText();
			String name = opertunitiesList.get(i).getText();
			System.out.println(name);
			//select.selectByValue(option.getAttribute("value"));
			if(name.equals(options[i])) {
				System.out.println("selected option from the List is:"+options[i]+ "  is verified");
				isVerified = true;
			}
			else {
			System.out.println("selected option from the List is:"+options[i]+ "  is not verified");
			    
			}
		}
		
		return isVerified;
		
	}
	public boolean createNewOppertunity(WebDriver driver,WebElement element) throws InterruptedException {
		if(reUsable.waitForElementClickable(driver, AccountsPage.createNewButton)){
			
			AccountsPage.createNewButton.click();
			Thread.sleep(1000);
			if(reUsable.waitForVisibilityOfElement(driver, createOppertunity)) {
				createOppertunity.click();
				oppertunityName.sendKeys("Oppertunity1");
				//give account name
				accountName.sendKeys("Latha");
				closeDate.click();
				todayDate.click();
				//select stage using select tab
				Select select = new Select(selectStage);
				select.selectByVisibleText("Needs Analysis");
				AccountsPage.saveButton.click();
				Thread.sleep(2000);
				}
			
		}
		return true;
	}
	public boolean oppertunitiesPipeLine(WebDriver driver,WebElement element) throws InterruptedException {
		
		if(reUsable.waitForElementClickable(driver, oppertunitiesPipeline)) {
			oppertunitiesPipeline.click();
			String title = oppertunitiesPipelineTitle.getText();
			System.out.println(title);
			if(title.equalsIgnoreCase("Opportunity Pipeline")) {
				System.out.println("page displayed correctly");
				
			}
			Thread.sleep(1000);
		}
		return true;
	}
public boolean stuckOnOppertunities(WebDriver driver,WebElement element) throws InterruptedException {
		
		if(reUsable.waitForElementClickable(driver, stuckOnoppertunity)) {
			stuckOnoppertunity.click();
			String title = stuckOnoppertunityTitle.getText();
			System.out.println(title);
			if(title.equalsIgnoreCase("Stuck Opportunities")) {
				System.out.println("page displayed correctly");
				
			}
			Thread.sleep(1000);
		}
		return true;
	}
public boolean quarterlySummary(WebDriver driver,WebElement element) throws InterruptedException {
	
	if(reUsable.waitForElementClickable(driver, selectInterval)) {
		Select interval = new Select(selectInterval);
		interval.selectByVisibleText("Current FQ");
		Select include = new Select(selectInclude);
		include.selectByVisibleText("Open Opportunities");
		runReport.click();
		String title = runReportTiltle.getText();
		System.out.println(title);
		if(title.equalsIgnoreCase("Opportunity Report")) {
			System.out.println("page displayed correctly");
			
		}
		Thread.sleep(1000);
	}
	return true;
}
}
