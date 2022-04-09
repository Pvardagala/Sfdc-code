package com.sfdcPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sfdcUtilities.ReusableUtils;

public class LeadsPage {
	
	ReusableUtils reUsable = new ReusableUtils();
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Leads")
	public WebElement leadsTab;
	@FindBy(tagName = "select")
	public static WebElement selectTab;
	@FindBy(xpath = "//*[@id=\"fcf\"]/option")
	public List<WebElement> leadsViewList;
	@FindBy(xpath = "//input[@title='Go!']")
	public static WebElement goButton;
	@FindBy(xpath = "//*[@id=\"createNewMenu\"]/a[6]")
	public WebElement createLeads;
	@FindBy(id = "name_lastlea2")
	public WebElement lastName;
	@FindBy(id = "lea3")
	public WebElement companyName;
	

	public boolean verifyleadsPage(WebDriver driver,WebElement element) throws InterruptedException {
		Thread.sleep(3000);
		if(reUsable.waitForElementClickable(driver, leadsTab)) {
			leadsTab.click();
			String title = driver.getTitle();
			System.out.println(title);
			if(title.equalsIgnoreCase("Leads: Home ~ Salesforce - Developer Edition")){
				System.out.println("Navigating to Leads page");
			}
		}
		return true;
	}
	public boolean veriryLeadsView(WebDriver driver,WebElement element) throws InterruptedException {
		boolean isVerified = false;
		Thread.sleep(3000);
		Select select = new Select(selectTab);
		
		String[] options = {"All Open Leads","My Unread Leads","Recently Viewed Leads","Today's Leads","View - Custom 1","View - Custom 2"};
				
		System.out.println(options.length);
		for(int i=0; i < options.length; i++) {
			
			String name = leadsViewList.get(i).getText();
			System.out.println(name);
			
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
	public boolean todaysLeadsPage(WebDriver driver) {
		if(reUsable.waitForElementClickable(driver, selectTab)) {
			Select select = new Select(selectTab);
			select.selectByVisibleText("Today's Leads");
			if(reUsable.waitForElementClickable(driver, goButton)) {
				goButton.click();
				String title = driver.getTitle();
				System.out.println(title);
				if(title.equalsIgnoreCase("Leads ~ Salesforce - Developer Edition")) {
					System.out.println("In correct page only");
				}
			}
			
		}
		return true;
	}
		
		
		
		
	}
	

