package com.sfdcTestcases;

import java.io.IOException;




import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.sfdcPageObjects.AccountsPage;
import com.sfdcPageObjects.ContactsPage;
import com.sfdcPageObjects.LeadsPage;
import com.sfdcPageObjects.LoginPage;
import com.sfdcPageObjects.OpertunitiesPage;
import com.sfdcPageObjects.UsermenuPage;
import com.sfdcUtilities.ReadTestDataFileUtils;
import com.sfdcUtilities.ReusableUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public  ReadTestDataFileUtils read = new ReadTestDataFileUtils();

	public static WebDriver driver = null;
	//public static ExtentReports extent = null;
//	public static ExtentHtmlReporter report = null;
	//public static ExtentTest test = null;
	public static LoginPage loginPage = null;
	public static UsermenuPage usermenuPage= null;
	public static AccountsPage accountsPage= null;
	public static OpertunitiesPage opertunitiesPage = null;
	public static LeadsPage leadsPage = null;
	public static ContactsPage contactsPage = null;
	public static ReusableUtils reUsable = null;
	public  Logger logger = Logger.getLogger(getClass().getSimpleName());
	 
	@Parameters("browser name")
	@BeforeTest
	public void setUp(String sBrowserName) {
		
		PropertyConfigurator.configure("log4j.properties"); 
		logger.info("Log file configured");
		driver = selectBrowser(sBrowserName);
		logger.info("selected the desired browser");
		//initializeReports();
		loginPage = new LoginPage(driver);
		logger.info("Login page object created");
		usermenuPage = new UsermenuPage(driver);
		accountsPage = new AccountsPage(driver);
		opertunitiesPage = new OpertunitiesPage(driver);
		leadsPage = new LeadsPage(driver);
		contactsPage = new ContactsPage(driver);
		reUsable = new ReusableUtils();
	}
	
	@AfterTest
	public void tearDown() {
		 
		driver.close();
		logger.info("driver closed after test");
		//extent.flush();
		
		
	}
	
	/**
	 * This function is used to configure the diver
	 * @param browserName eg:chrome or safari or firefox
	 * @return particular driver of the given browser
	 */
	public WebDriver selectBrowser(String browserName) {
		
		String browser = browserName.toLowerCase();
		switch(browser) {
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    logger.info("chrome driver intialized");
			break;
			
		case "edge":
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge driver intialized");
			break;
			
		case "ie":	
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			logger.info("Internet Explorer driver intialized");
			break;
			
		default:
			
			driver = null;
			
		}
		return driver;
	}
	
	/**
	 * This function is used to select the appropriate environment
	 * @param enviroment eg:environment= prod.url or qa.url or dev.url
	 * @return URL of type environment
	 * @throws IOException
	 */
	public String selectEnvironment(String enviroment) throws IOException {
		 
		  String appURL = null;
		  switch(enviroment) {
		  case "prod.url":
			  appURL = read.readAppEnvironmentsFile("prod.url");
			  logger.info("Production URL intialized");
			  break;
			  
		  case "qa.url":
			  appURL = read.readAppEnvironmentsFile("qa.url");
			  logger.info("QA URL intialized");
			  break;
			  
		  case "dev.url":
			  appURL = read.readAppEnvironmentsFile("dev.url");
			  logger.info("Developer URL intialized");
			  break;
			  
		  default:
			  appURL = null;
		  }
		  return appURL;
	}
	
	/**
	 * This function is used to generate reports
	 * @return 
	 * 
	 */
	/*public void initializeReports() {
		try {
			extent = new ExtentReports();
		String dateFormat = new SimpleDateFormat("yyyy:MM:dd:HH.mm.ss").format(new Date());
		String reportPath ="C:\\Pushpa\\Java Class\\SFDCAutomation\\"+dateFormat+"SFDCReports.html";
		System.out.println(reportPath);
		ExtentHtmlReporter report = new ExtentHtmlReporter(reportPath);
		 extent.attachReporter(report);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}*/

}
