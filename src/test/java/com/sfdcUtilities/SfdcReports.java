package com.sfdcUtilities;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class SfdcReports implements ITestListener{
	
	public  ExtentReports extent;
	public  ExtentHtmlReporter report;
	public static ExtentTest test;
	
	ReusableUtils reUsable = new ReusableUtils();

	@Override
	public void onTestStart(ITestResult result) {
		String dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//String reoprtPath = System.getProperty("user.dir")+"//target//Reports//"+"_SFDCReports"+dateFormat+".html";
		
		report = new ExtentHtmlReporter("C:\\Pushpa\\Java Class\\SFDCAutomation\\target\\Reports\\"+dateFormat+"report.html");
		extent = new ExtentReports();
		extent.attachReporter(report);
		test = extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test script Passed ");
		//test = extent.createTest(result.getName());
		test.pass(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test script Failed ");
		//test = extent.createTest(result.getName());
		try {
			test.addScreenCaptureFromPath(reUsable.takeScreenshot());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.fail(result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	

}
