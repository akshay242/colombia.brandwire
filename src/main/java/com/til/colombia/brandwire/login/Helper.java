package com.til.colombia.brandwire.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.glass.events.KeyEvent;
import com.til.brandwire.main.BaseClass;

public class Helper {
	// static String winHandle;
	static WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
	static String imagePath = System.getProperty("user.dir") + File.separator + "inputdata" + File.separator
			+ "alibaba.jpg";

	static void click(String locator) {
		BaseClass.driver.findElement(value(locator)).click();
	}

	static void waiting(String waitElement) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(value(waitElement)));
	}

	static void hidden(String waitElement) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(value(waitElement)));
	}

	static void elementClickable(String waitElement) {
		wait.until(ExpectedConditions.elementToBeClickable(value(waitElement)));

	}

	static void sendData(String sendDataElement, String sendDataElementValue) {
		BaseClass.driver.findElement(value(sendDataElement)).sendKeys(sendDataElementValue);
	}

	static void sendEnterKey(String sendDataElement, char enter) {
		BaseClass.driver.findElement(value(sendDataElement)).sendKeys(Keys.getKeyFromUnicode(enter));
	}

	static void commonTOIInfo() {
		// CreateStoryListicle.hidden(BaseClass.prop.getProperty("overlay"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CreateBrandStory.elementClickable(BaseClass.prop.getProperty("toiCheckBox"));
		CreateBrandStory.click(BaseClass.prop.getProperty("toiCheckBox"));
		CreateBrandStory.click(BaseClass.prop.getProperty("toiCategory"));
		CreateBrandStory.click(BaseClass.prop.getProperty("toiCategoryValue"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("toiCategoryValue"),
				BaseClass.prop.getProperty("categoryName"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("toiCategoryValue"), Keys.ENTER.charAt(0));
	}

	static void commonETInfo() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CreateBrandStory.elementClickable(BaseClass.prop.getProperty("etCheckBox"));
		CreateBrandStory.click(BaseClass.prop.getProperty("etCheckBox"));
		CreateBrandStory.click(BaseClass.prop.getProperty("etCategory"));
		CreateBrandStory.click(BaseClass.prop.getProperty("etCategoryValue"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("etCategoryValue"),
				BaseClass.prop.getProperty("categoryName"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("etCategoryValue"), Keys.ENTER.charAt(0));
	}

	static void commonBWInfo() {
		CreateBrandStory.click(BaseClass.prop.getProperty("bwCategory"));
		CreateBrandStory.click(BaseClass.prop.getProperty("bwCategoryValue"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("bwCategoryValue"),
				BaseClass.prop.getProperty("categoryName"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("bwCategoryValue"), Keys.ENTER.charAt(0));
	}

	static void commonNBTInfo() {
		CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
		CreateBrandStory.click(BaseClass.prop.getProperty("nbtCheckbox"));
		CreateBrandStory.click(BaseClass.prop.getProperty("nbtCategory"));
		CreateBrandStory.click(BaseClass.prop.getProperty("nbtCategoryValue"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("nbtCategoryValue"),
				BaseClass.prop.getProperty("hindiCategoryName"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("nbtCategoryValue"), Keys.ENTER.charAt(0));
	}

	static void selectNBT() {
		CreateBrandStory.click(BaseClass.prop.getProperty("languageHindi"));
		CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
	}
	
	static void createStory() {
		CreateBrandStory.click(BaseClass.prop.getProperty("createStoryNextButton"));
		CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
		CreateBrandStory.waiting(BaseClass.prop.getProperty("longHeadline"));
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CreateBrandStory.click(BaseClass.prop.getProperty("longHeadline"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("longHeadline"),
				BaseClass.prop.getProperty("longHeadlineText"));
		CreateBrandStory.click(BaseClass.prop.getProperty("shortHeadline"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("shortHeadline"),
				BaseClass.prop.getProperty("shortHeadlineText"));
		if (CreateBrandStory.languageValue.equalsIgnoreCase("Hindi")) {
			CreateBrandStory.click(BaseClass.prop.getProperty("pageTitle"));
			CreateBrandStory.sendData(BaseClass.prop.getProperty("pageTitle"),
					BaseClass.prop.getProperty("pageTitleText"));
		}
		CreateBrandStory.click(BaseClass.prop.getProperty("brandStoryContent"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("brandStoryContent"),
				BaseClass.prop.getProperty("storyContent"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("brandStoryContent"), Keys.ENTER.charAt(0));

	}
	public static boolean languageSelection() {
		//logger3.info("languageSelection method is called");
		if (CreateBrandStory.languageValue.equalsIgnoreCase("Hindi")) {
			CreateBrandStory.click(BaseClass.prop.getProperty("languageHindi"));
			CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
		}
		else if(CreateBrandStory.languageValue.equalsIgnoreCase("English")){
			
		}
		return true;

	}

	static void uploadListicleImage(int imageCount){
		int i = 0;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (i < imageCount) {

			CreateBrandStory.click(BaseClass.prop.getProperty("openFileButton"));
			try {
				CreateBrandStory.uploadViaRobot();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CreateBrandStory.waiting(BaseClass.prop.getProperty("saveButton"));
			CreateBrandStory.click(BaseClass.prop.getProperty("saveButton"));
			CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
			CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("brandStoryContent"), Keys.ENTER.charAt(0));
			i++;
		}
	}

	static void uploadNormalImage(int normalImageCount) {
		int j = 0;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (j < normalImageCount) {
			if(j == 0){
				CreateBrandStory.click(BaseClass.prop.getProperty("imageUpload"));
			}
			else{
				CreateBrandStory.waiting(BaseClass.prop.getProperty("addMoreImages"));
				try {
					Thread.sleep(900);
					CreateBrandStory.click(BaseClass.prop.getProperty("addMoreImages"));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				}
			try {
				CreateBrandStory.uploadViaRobot();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CreateBrandStory.waiting(BaseClass.prop.getProperty("saveButton"));
			CreateBrandStory.click(BaseClass.prop.getProperty("saveButton"));
			CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
			((JavascriptExecutor) BaseClass.driver).executeScript("window.scrollBy(0,200)");
			//CreateStoryListicle.sendEnterKey(BaseClass.prop.getProperty("brandStoryContent"), Keys.ENTER.charAt(0));
			j++;
		}
	}

	static void uploadViaRobot() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.setAutoDelay(900);
		StringSelection str = new StringSelection(CreateBrandStory.imagePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		robot.setAutoDelay(900);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.setAutoDelay(900);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(900);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}

	static void insertTwitterEmbed(String value) throws InterruptedException {
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("brandStoryContent"), Keys.ENTER.charAt(0));
		// CreateStoryListicle.hidden(BaseClass.prop.getProperty("overlay"));
		Thread.sleep(800);
		CreateBrandStory.waiting(BaseClass.prop.getProperty("socialEmbed"));
		CreateBrandStory.click(BaseClass.prop.getProperty("socialEmbed"));
		CreateBrandStory.waiting(BaseClass.prop.getProperty("socialEmbedCode"));
		CreateBrandStory.click(BaseClass.prop.getProperty("socialEmbedCode"));
		// CreateStoryListicle.sendData(BaseClass.prop.getProperty("socialEmbedCode"),
		// CreateStoryListicle.twitEmbedCode );
		BaseClass.driver.findElement(By.id("snoteEmbedText")).sendKeys(value);
		Thread.sleep(1000);
		CreateBrandStory.click(BaseClass.prop.getProperty("socialEmbedSubmit"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("brandStoryContent"), Keys.ENTER.charAt(0));
	}

	static void insertFacebookEmbed() {
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("brandStoryContent"), Keys.ENTER.charAt(0));
		CreateBrandStory.waiting(BaseClass.prop.getProperty("socialEmbed"));
		CreateBrandStory.click(BaseClass.prop.getProperty("socialEmbed"));
		CreateBrandStory.waiting(BaseClass.prop.getProperty("socialselectDropdown"));
		CreateBrandStory.click(BaseClass.prop.getProperty("socialselectDropdown"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("socialselectDropdown"),
				BaseClass.prop.getProperty("facebook"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("socialselectDropdown"), Keys.ENTER.charAt(0));
		CreateBrandStory.click(BaseClass.prop.getProperty("socialEmbedCode"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("socialEmbedCode"),
				BaseClass.prop.getProperty("facebookEmbed"));
		CreateBrandStory.click(BaseClass.prop.getProperty("socialEmbedSubmit"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("brandStoryContent"), Keys.ENTER.charAt(0));
	}

	static void insertYoutubeVideo() throws InterruptedException {
		CreateBrandStory.click(BaseClass.prop.getProperty("videoUpload"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("videoUpload"),
				BaseClass.prop.getProperty("youtubeVideo"));
		CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
		((JavascriptExecutor) BaseClass.driver).executeScript("window.scrollBy(0,800)");
		Thread.sleep(1000);
	}

	// Brand story Type
	static void selectBrandStoryType() {
		CreateBrandStory.click(BaseClass.prop.getProperty("brandStoryType"));
		CreateBrandStory.click(BaseClass.prop.getProperty("brandStoryTypeValue"));
		CreateBrandStory.sendData(BaseClass.prop.getProperty("brandStoryTypeValue"),
				BaseClass.prop.getProperty("storyType"));
		CreateBrandStory.sendEnterKey(BaseClass.prop.getProperty("brandStoryTypeValue"), Keys.ENTER.charAt(0));

	}

	static void checkMediaContact() throws InterruptedException, AWTException {
		WebElement brandLogo = BaseClass.driver.findElement(
				By.xpath("//*[@id='prInfo']/div[6]/div/div[4]/div[1]/div[4]/div/div[3]/div[1]/div[2]/div[1]/div"));
		((JavascriptExecutor) BaseClass.driver).executeScript("window.scrollBy(0,300)");
		((JavascriptExecutor) BaseClass.driver).executeScript("arguments[0].setAttribute('style','display:block;');",
				brandLogo);
		CreateBrandStory.click(BaseClass.prop.getProperty("brandLogo"));
		CreateBrandStory.uploadViaRobot();
		CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
	}

	static void uncheckMediaContact() {
		((JavascriptExecutor) BaseClass.driver).executeScript("window.scrollBy(0,300)");
		CreateBrandStory.click(BaseClass.prop.getProperty("mediaContactBox"));
	}

	static void finalPublish() {
		CreateBrandStory.click(BaseClass.prop.getProperty("publishButton"));
		CreateBrandStory.waiting(BaseClass.prop.getProperty("publishConfirmation"));
		CreateBrandStory.click(BaseClass.prop.getProperty("publishConfirmation"));
	}

	public static By value(String locator) {
		// TODO Auto-generated method stub
		String breakLocatorType = locator.substring(0, 3);
		String breakLocatorValue = locator.substring(3, locator.length());
		if (breakLocatorType.equals("xp_")) { // Locator type = xpath
			return By.xpath(breakLocatorValue);
		} else if (breakLocatorType.equals("id_")) { // Locator type = id
			return By.id(breakLocatorValue);
		} else if (breakLocatorType.equals("cl_")) { // Locator type = class
			return By.className(breakLocatorValue);
		}
		return null;
	}

}
