package com.rediff.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.rediff.testutil.TestUtil;

public class Base {
	
	public static WebDriver driver;
	public static Properties property;
	public static Logger log;
	public Base()
	{
		try {
		log = LogManager.getLogger(Base.class.getName());
		File file = new File("./" + "Configuration/config.properties");
		FileInputStream fis = new FileInputStream(file);
		property = new Properties();
		property.load(fis);
		}
		
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
	}
	
	public static void initialization()
	{
		String browser = property.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./" + "Drivers/chromedriver.exe");
		     driver = new ChromeDriver();
		     log.info("ChromeDriver has been initialized");
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./" + "Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
			log.info("IEDriver has been initialized");
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./" + "Drivers/geckodriver.exe");
			driver = new FirefoxDriver();	
			log.info("FireFoxDriver has been initialized");
		}
		log.debug("RddifMail URL is set into the address bar");
		driver.get(property.getProperty("URL"));
		log.info("ReddifMail website is launced successfully");
		driver.manage().window().maximize();
		log.info("Browser window is maximized");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEWAIT, TimeUnit.SECONDS);
		log.info("Implict wait is set to 10 seconds globally");
		
	
	}
	
	
}
