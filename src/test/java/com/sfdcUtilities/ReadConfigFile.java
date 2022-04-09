package com.sfdcUtilities;
//configuration folder and this read congig data is for my learning purpose

import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfigFile {

	Properties prop;
	FileInputStream fis;
	
	public ReadConfigFile() {
		
		try {
		    fis = new FileInputStream("./Configuratins//config.properties");
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is:"+e.getMessage());
		}
		
	}
	
	public String getUsername() {
		String username = prop.getProperty("username.valid");
		return username;
	}
	public String getPassword() {
		String password = prop.getProperty("password.valid");
		return password;
	}
	public String getInvalidUsername() {
		String invalidUname = prop.getProperty("username.invalid");
		return invalidUname;
	}
	public String getInvalidPassword() {
		String invalidpwd = prop.getProperty("password.invalid");
		return invalidpwd;
	}
	
}
