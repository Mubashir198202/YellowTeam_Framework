package com.uk.zoopla.listeners;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Zoopla_Listeners implements ITestListener{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onTestStart(ITestResult result) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "report-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/" + repName);
																									
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extend-zoopla.xml");
	
		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Mubashir");

		htmlReporter.config().setDocumentTitle("Automation Test Project"); 
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); 
		htmlReporter.config().setTheme(Theme.DARK);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName()); // create new entry in th report
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger = extent.createTest(result.getName()); // create new entry in th report
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));	
		
		String screenshotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + result.getName() + ".png";
		File f = new File(screenshotPath);
		if (f.exists()) {
			try {
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger = extent.createTest(result.getName()); // create new entry in th report
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));	
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
	
}
