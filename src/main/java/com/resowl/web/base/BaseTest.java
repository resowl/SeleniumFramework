package com.resowl.web.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.resowl.web.utils.PathUtils;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	//Base Test Logic Goes Here
	
	public static String projectDir;
	public static String configDir;
	public static Properties prop;
	public static WebDriver driver;
	public static long implicitWaitTime;
	public static ExtentTest test;
	public static ExtentReports report;
	
	public BaseTest(){
		projectDir = PathUtils.getCwd();
		configDir = PathUtils.getConfigDir(projectDir);
		System.out.println(configDir);
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(PathUtils.getFilePath(configDir, "config.properties"));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File config.properties Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Something went wrong processing the file");
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 
	 * @return Get url value specified in the properties file
	 */
	public static String getUrl() {
		return prop.getProperty("url");
	}
	
	/**
	 * Initialize Web Browser
	 * @param browser
	 */
	public static void initialization(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			implicitWaitTime = Long.parseLong(prop.getProperty("implicitwaitSec"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWaitTime));
		}
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}
	
	/**
	 * Hard wait
	 * @param ms
	 */
	public static void hardWait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Close driver
	 */
	public static void closeDriver() {
		driver.quit();
	}
	
	
}
