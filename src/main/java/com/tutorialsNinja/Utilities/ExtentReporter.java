package com.tutorialsNinja.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() throws Exception {
	//Step1: Add the extentreports dependency in pom.xml file
	
	//Step2: Create the Object of ExtentReports Class
	ExtentReports extentReport = new ExtentReports();
	
	//Step3: Create the Object of File class and pass the path of .html file in the constructor
	File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreport.html");
	
	//Step4: Create the Object of ExtentSparkReporter Class and pass the path of the file in it's constructor
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	
	//Step5: using sparkReporter we can configure a lot of things in our ExtentReport file
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("Tutorialsninja Automation Results");
	sparkReporter.config().setDocumentTitle("TNReportTitle|CanadaBatch");
	sparkReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss");
	
	//Step6: We need to attach the ExtentReport with the SparkReporter
	extentReport.attachReporter(sparkReporter);
	
	//Step7: Additional Information - System information and pass it on to the Extent Reports
	//    7.1: Create a Properties file and add necessary details of the application
	
	Properties prop = new Properties();
	FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + 
			"\\src\\main\\java\\com\\tutorialsNinja\\Config\\Config.properties");
	prop.load(ip);
	
	extentReport.setSystemInfo("application url", prop.getProperty("url"));
	extentReport.setSystemInfo("browswer name", prop.getProperty("browser"));
	extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
	extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
	extentReport.setSystemInfo("operating system", System.getProperty("os.name"));
	extentReport.setSystemInfo("ops version detail", System.getProperty("os.version"));
	extentReport.setSystemInfo("SDET Name", System.getProperty("user.name"));
	extentReport.setSystemInfo("java version", System.getProperty("java.version"));
	extentReport.setSystemInfo("java vendor", System.getProperty("java.vendor"));
	
	//Step8: Return the extentReport
	return extentReport;
	}

}
