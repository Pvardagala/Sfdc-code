package com.sfdcPageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sfdcUtilities.ReusableUtils;

public class UsermenuPage {
	
	ReusableUtils reUsable = new ReusableUtils();
	public UsermenuPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(partialLinkText = "Pushpalatha")
	public WebElement usermenuName;
	
	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement myProfile;
	
	@FindBy(xpath = "//div[@id='userNav-menuItems']//a")
	public List<WebElement> listOfuserMenuOptions;
	
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
    public WebElement editPen;
	
	@FindBy(xpath = "//a[@role='tab']")
    public WebElement aboutTab;
	
	@FindBy(xpath = "//input[@value='Save All']")
	 public WebElement saveAllButton;
	@FindBy(id = "lastName")
	public WebElement lastname;
	@FindBy(id = "contactInfoContentId")
	public WebElement frame;
	@FindBy(xpath = "//a[@title='Post']")
	public WebElement postLink;
	@FindBy(xpath = "//iframe[@class = 'cke_wysiwyg_frame cke_reset']")
	public WebElement postframe;
	@FindBy(xpath = "//html/body")
	public WebElement postText;
	@FindBy(id = "publishersharebutton")
	public WebElement shareButton;
	@FindBy(id = "publisherAttachContentPost")
	public WebElement file;
	@FindBy(xpath = "//a[@title='Upload a file from your computer']")
	public WebElement uploadFile;
	@FindBy(id = "chatterFile")
	public WebElement chooseFile;
	@FindBy(linkText = "Add Photo")
	public WebElement addPhoto;
	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement selectPhoto;
	@FindBy(id = "j_id0:uploadFileForm:save")
	public WebElement saveButton;
	@FindBy(xpath = "//a[@title='My Settings']")
	public WebElement mySettings;
	@FindBy(id = "PersonalInfo_font")
	public WebElement personalInfo;
	@FindBy(id = "LoginHistory_font")
	public WebElement loginHistory;
	@FindBy(id = "DisplayAndLayout")
	public WebElement displayLayout;
	@FindBy(id = "CustomizeTabs_font")
	public WebElement customTab;
	@FindBy(id = "duel_select_0")
	public WebElement selectTabs;
	@FindBy(xpath = "//img[@title='Add']")
	public static WebElement addTab;
	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement saveCustomTabButton;
	@FindBy(id = "EmailSetup")
	public WebElement email;
	@FindBy(id = "EmailSettings_font")
	public WebElement emailSettings;
	@FindBy(id = "sender_name")
	public WebElement emailName;
	@FindBy(id = "sender_email")
	public WebElement emailAddress;
	@FindBy(id = "auto_bcc1")
	public WebElement radioButton;
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement calenderReminders;
	@FindBy(id = "Reminders_font")
	public WebElement activityReminders;
	@FindBy(xpath =  "//input[@value='Open a Test Reminder']")
	public WebElement openTestReminder;
	@FindBy(partialLinkText = "Developer Console")
	public WebElement developerConsole;
	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoIframe;
	@FindBy(id = "j_id0:j_id7:save")
	public WebElement savePhoto2;
	@FindBy(id = "j_id0:uploadFileForm:save")
	public WebElement savePhoto1;
	
/**
 * This method is used to verify user menu list 
 * @param driver
 * @return menu list
 */
public  boolean verifyUserMenuItems(WebDriver driver) {
	
	boolean isOptionVerified = true;
	String[] userMenuOptions = { "My Profile", "My Settings", "Developer Console", "Switch to Lightning Experience",
			"Logout" };
	
	for (int i = 0; i < userMenuOptions.length; i++) {
		String optionValue = listOfuserMenuOptions.get(i).getText();
		if (optionValue.equals(userMenuOptions[i])) {
			System.out.println("Option " + userMenuOptions[i] + " is verified");
		} else {
			System.out.println("Verification of " + userMenuOptions[i] + " failed");
			isOptionVerified = false;
		}
	}
	return isOptionVerified;
}
/**
 * This method is used to select the option from user menu
 * @param option
 * @return {boolean} isOptionSelected
 */
public void selectMyProflie() {
	myProfile.click();
}
/**This method is used to select edit pen and change lastname of about tab 
 * @param driver
 * @return 
 * @throws InterruptedException
 */
public boolean selectEditPen(WebDriver driver) throws InterruptedException {
	boolean iseditpen = false;
	  if(reUsable.waitForElementClickable(driver, editPen)) {
		//clicking on edit pen
		editPen.click();
		//Thread.sleep(2000);
		//switch to frame for about tab
		driver.switchTo().frame("contactInfoContentId");
		//click on about tab
		aboutTab.click();
		//clear the field name of last name and enter a new text
		lastname.clear();
		lastname.sendKeys("Kondari");
		//Thread.sleep(1000);
		//click on save all button
		saveAllButton.click();
		//switch to default window
		driver.switchTo().defaultContent();
		iseditpen = true;
	}
	return iseditpen;
}
/**This method is used to post the text
 * @param driver
 * @return
 * @throws InterruptedException 
 */
public boolean selectPostText(WebDriver driver) throws InterruptedException {
	boolean isPostlinkSuccess = false;
	if(reUsable.waitForElementClickable(driver, postLink)) {
		//click on post link
		postLink.click();
		//switch to frame0 to give post
		driver.switchTo().frame(0);
		postText = driver.switchTo().activeElement();
		Thread.sleep(2000);
		postText.sendKeys("Hello!");
		driver.switchTo().defaultContent();
		shareButton.click();
		
		isPostlinkSuccess = true;
	}
	return isPostlinkSuccess;
	
}
/**This method is used to upload a file
 * @param driver
 * @return
 * @throws InterruptedException
 */
public boolean selectFileUpload(WebDriver driver) throws InterruptedException {
	boolean isFileUploaded = false;
	if(reUsable.waitForElementClickable(driver, file)) {
		//click on file 
		file.click();
		//click on upload file
		uploadFile.click();
		//choose file from ur computer
		chooseFile.sendKeys("C:\\Pushpa\\hi.txt");
		Thread.sleep(2000);
		shareButton.click();
		Thread.sleep(5000);
		isFileUploaded = true;
	}
	return isFileUploaded;
}
/**This method is used to upload a photo to My Profile page
 * @param driver
 * @return
 * @throws InterruptedException
 */
public boolean selectPhoto(WebDriver driver) throws InterruptedException {
	boolean isPhotoselected =false;
	if(reUsable.waitForElementClickable(driver, addPhoto)) {
		Thread.sleep(5000);
		Actions actionOnPhoto = new Actions(driver);
		actionOnPhoto.moveToElement(addPhoto).click().perform();
		driver.switchTo().frame(photoIframe);
		Thread.sleep(5000);
		selectPhoto.sendKeys("C:\\Users\\garat\\Documents\\roses.jpg");
		Thread.sleep(9000);
		
		savePhoto1.click();
		
		Thread.sleep(7000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame(photoIframe);
		savePhoto2.click();
		Thread.sleep(9000);
		driver.switchTo().defaultContent();
		isPhotoselected = true;
	}
	return isPhotoselected;
}
/**
 * This method is used to select My Profile option
 */
public void selectMySettings() {
	mySettings.click();
}

/**
 * This method is used to select personal info on My Settings page
 */
public boolean selectPersonalInfo(WebDriver driver,WebElement element) {
	if(reUsable.waitForElementClickable(driver, personalInfo)) {
	personalInfo.click();
	}
	return true;
}
/**this method is used to display login history
 * @param driver
 * @param element
 * @return
 */
public boolean loginHistory(WebDriver driver,WebElement element) {
	boolean isLoginHistoryDisplayed = false;
	if(reUsable.waitForElementClickable(driver, loginHistory)) {
		loginHistory.click();
		isLoginHistoryDisplayed = true;
	}
	return isLoginHistoryDisplayed;
}
/**This method is used to customize the tab
 * @param driver
 * @param element
 * @return
 */
public boolean addCustomTab(WebDriver driver,WebElement element) {
	boolean isCustomtabAdded = false;
	if(reUsable.waitForElementClickable(driver, customTab)) {
		customTab.click();
		//select a tab like Reports
		Select tabs = new Select(selectTabs);
		tabs.selectByVisibleText("Reports");
		addTab.click();
		if(reUsable.waitForElementClickable(driver, saveCustomTabButton)) {
			saveCustomTabButton.click();
		}
		isCustomtabAdded = true;
	}
	return isCustomtabAdded;
}
/**This method is used to setting email name and address
 * @param driver
 * @param element
 * @return
 */
public boolean selectEmailsettings(WebDriver driver,WebElement element) {
	boolean isEmailUpdated = false;
	if(reUsable.waitForElementClickable(driver, emailSettings)) {
		emailSettings.click();
		if(reUsable.isElementDisplayed(driver, emailName)) {
			emailName.click();
			emailName.clear();
			emailName.sendKeys("Pushpalatha.V");
		}
		else {
			System.out.println("Email name is not displayed");
		}
		if(reUsable.isElementDisplayed(driver, emailAddress)) {
			emailAddress.click();
			emailName.clear();
			emailAddress.sendKeys("pushpalatha.V@gmail.com");
		}
		else {
			System.out.println("Email address is not displayed");
		}
		radioButton.click();
		if(reUsable.waitForElementClickable(driver, saveCustomTabButton)) {
			saveCustomTabButton.click();
		}
		isEmailUpdated = true;
	}
	return isEmailUpdated;
}
/**This method is used to see calenders and reminders
 * @param driver
 * @param element
 * @return
 * @throws InterruptedException 
 */
public boolean selectCalendersReminders(WebDriver driver,WebElement element) throws InterruptedException {
	boolean popup = false;
	if(reUsable.waitForElementClickable(driver, calenderReminders)) {
		calenderReminders.click();
		if(reUsable.waitForElementClickable(driver, activityReminders)) {
			activityReminders.click();
			if(reUsable.isElementDisplayed(driver, openTestReminder)) {
				openTestReminder.click();
				Thread.sleep(2000);
				
				//for window handling
				String parent=driver.getWindowHandle();
				System.out.println(parent);
				//getting all opened windows
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
			}
		}
		//driver.switchTo().defaultContent();
		popup = true;
	}
	return popup;
}
}
