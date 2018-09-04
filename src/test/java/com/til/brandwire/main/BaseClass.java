package com.til.brandwire.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public static WebDriver driver;
	public static String folderPath = System.getProperty("user.dir");
	public static Properties prop = new Properties();
	static FileInputStream fis;
	static FileInputStream fisExcel;
	XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static final Logger logger4 = Logger.getLogger(BaseClass.class);
	
	
	@BeforeTest
	public void driverInitialize() throws IOException {
		try {
			logger4.info("driverInitialize method is called");
			fis = new FileInputStream(folderPath + File.separator + "inputdata" + File.separator + "data.properties");
			prop.load(fis);
			fisExcel = new FileInputStream(
					folderPath + File.separator + "inputdata" + File.separator + "Framework.xlsx");
			wb = new XSSFWorkbook(fisExcel);
			sheet = wb.getSheet(wb.getSheetName(0));
			PropertyConfigurator.configure(BaseClass.folderPath + File.separator + "log4j.properties");
			//System.setProperty("webdriver.gecko.driver",folderPath +File.separator + "libs" + File.separator + "geckodriver.exe");
			//driver = new FirefoxDriver();
			System.setProperty("webdriver.chrome.driver",	folderPath + File.separator + "libs" + File.separator + "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			logger4.info("driverInitialize method successfully runs");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger4.info("Something went wrong ", e);
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			logger4.info("Something went wrong ", e1);
		}


	}

}
