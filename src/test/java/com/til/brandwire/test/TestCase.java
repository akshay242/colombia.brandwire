package com.til.brandwire.test;

import java.awt.AWTException;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.til.brandwire.main.BaseClass;
import com.til.colombia.brandwire.login.CreateBrandStory;
import com.til.colombia.brandwire.login.LoginPage;

import junit.framework.Assert;

public class TestCase extends BaseClass {
	private static LoginPage loginPage;
	public static String language;
	public static final Logger logger = Logger.getLogger(TestCase.class);
	CreateBrandStory createStoryListicleTOI;

	@BeforeClass()
	public void verifyLogin() {
		logger.info("verifyLogin method is called");
		loginPage = new LoginPage();
		Assert.assertEquals(loginPage.verifyLogin(),true);
		logger.info("verifyLogin method runs successfully");
	}

	@BeforeMethod()
	public void accordionClick() {
		// loginPage = new LoginPage();
		logger.info("accordionClick method is called");
		Assert.assertEquals(loginPage.accordionClick(), true);
		logger.info("accordionClick method successfully runs");
	}

	@Test(dataProvider = "setLoginData")
	public void enterStoryDetails(String templateType, String language, String publication, String image,
			String twitEmbed, String twitEmbedCode, String fbEmbed, String youTube, String mediaContact, String task)
			throws InterruptedException, AWTException {
		
		logger.info("enterStoryDetails method is called");
		Assert.assertEquals(CreateBrandStory.storyInitialize(templateType, language, publication, image, twitEmbed,
				twitEmbedCode, fbEmbed, youTube, mediaContact, task), true);
		logger.info("storyInitialize method successfully runs");
	}

	@DataProvider
	public Object[][] setLoginData() {
		int numberOfRows = BaseClass.sheet.getLastRowNum();
		int rowNum = 1;
		logger.info("Number of rows are " + numberOfRows);
		Row row = BaseClass.sheet.getRow(rowNum);
		int numberOfCellsPerRow = row.getLastCellNum();
		logger.info("numberOfCellsPerRow is " + numberOfCellsPerRow);
		Object[][] obj = new Object[numberOfRows][numberOfCellsPerRow];
		for (rowNum = 1; rowNum <= numberOfRows; rowNum++) {
			for (int cellNum = 0; cellNum < numberOfCellsPerRow; cellNum++) {
				obj[rowNum - 1][cellNum] = BaseClass.sheet.getRow(rowNum).getCell(cellNum).toString();
			}

		}
		return obj;

	}

}
