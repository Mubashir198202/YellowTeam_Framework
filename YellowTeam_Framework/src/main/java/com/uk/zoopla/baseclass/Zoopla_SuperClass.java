package com.uk.zoopla.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Zoopla_SuperClass {
	public static WebDriver driver;
	public static Logger logger;
	public static Properties proper;

	public Zoopla_SuperClass() {

		logger = logger.getLogger("QA_Mubashir");
		PropertyConfigurator.configure("zooplalog4j.properties");
	}

	public static void initialization() throws Throwable {

		proper = new Properties();
		FileInputStream file = new FileInputStream("zooplaconfig.properties");

		proper.load(file);

		String br = proper.getProperty("browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", proper.getProperty("chromebrowser"));
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", proper.getProperty("firefoxbrowser"));
			driver = new FirefoxDriver();
		} else if (br.equals("medge")) {
			System.setProperty("webdriver.edge.driver", proper.getProperty("medgebrowser"));
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
