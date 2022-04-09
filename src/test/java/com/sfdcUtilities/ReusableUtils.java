package com.sfdcUtilities;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.utils.FileUtil;
import com.sfdcTestcases.BaseTest;

public class ReusableUtils {
	
	/**
	 * This function is to  find element is displaying or not
	 * @param driver
	 * @param element
	 * @return {boolean}  elementFound
	 */
	public boolean isElementDisplayed(WebDriver driver,WebElement element) {
		
		boolean elementFounnd = false;
		
		if(element.isDisplayed()) {
			elementFounnd = true;
		}
		return elementFounnd;
		
	}
	
	/**
	 * This function is used to wait for clicking particular element
	 * @param driver
	 * @param element eg:login,edit or save
	 * @return {boolean} isElementClickable
	 */
	public boolean waitForElementClickable(WebDriver driver,WebElement element) {
		
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable = true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while waiting for the element"+e.getMessage());
		}
		
		return isElementClickable;
	}
/**
 * This method is used to wait for the visibilty of web element
 * @param driver
 * @param element
 * @return {boolean} if element is visible
 */
public boolean waitForVisibilityOfElement(WebDriver driver,WebElement element) {
		
		boolean isElementVisible = false;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOf(element));
		     isElementVisible = true;
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while waiting for the element"+e.getMessage());
		}
		
		return isElementVisible;
	}
	
	/**
	 * This function is used to take screen shot of the page when testcase is failed
	 * @return destination path of the file
	 * @throws IOException
	 */
	public String takeScreenshot() throws IOException {
		
		String dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot screenShot = (TakesScreenshot) BaseTest.driver;
		File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
		String dest_path=System.getProperty("user.dir")+"//Screenshots//"+dateFormat+".PNG";
		File destinationFile = new File(dest_path);
		FileUtils.copyFile(sourceFile, destinationFile);
		return dest_path;
		
	}
	

}
