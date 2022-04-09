package com.sfdcUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadTestDataFileUtils {
	
 	
	/**
	 * @param keyName as username or password
	 * @return value of the username or password
	 * @throws IOException
	 */
	public String readUserAccountsFile(String keyName) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(TestdataFilepathConstants.USERACCOUNTS_FILEPATH);
		prop.load(fis);
		fis.close();
		return prop.getProperty(keyName);
		
	}	
	
	
/**
 * @param keyName as prod.url or qa.url or dev.url
 * @return url of type production or qa or developer
 * @throws IOException
 */
   public String readAppEnvironmentsFile(String keyName) throws IOException {
		
	    Properties prop = new Properties();
	    FileInputStream fis = null;
	 	try {
	    fis = new FileInputStream(TestdataFilepathConstants.APP_ENVIRONMENTS_FILEPATH);
		prop.load(fis);
	    }catch(Exception e) {
	    	System.out.println("Exception is:"+e.getMessage());
	    }
	    finally {
		fis.close();
	    }
		return prop.getProperty(keyName);
		
	}

   /**
 * @param keyName as error  or title 
 * @return string type of error
 * @throws IOException
 */
public String readPageValidationsFile(String keyName) throws IOException {
		
	    Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(TestdataFilepathConstants.PAGE_VALIDATIONS_FILEPATH);
		prop.load(fis);
		fis.close();
		return prop.getProperty(keyName);
		
	}


}
