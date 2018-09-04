package com.til.colombia.brandwire.login;

import java.awt.AWTException;
import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.til.brandwire.main.BaseClass;
import junit.framework.Assert;

public class CreateBrandStory extends Helper {
	
	static String imagePath = System.getProperty("user.dir") + File.separator + "inputdata" + File.separator
			+ "alibaba.jpg";
	 static String twitEmbedCode, languageValue, templateValue, selectPublication;
	public static final Logger logger3 = Logger.getLogger(CreateBrandStory.class);

	public static boolean storyInitialize(String templateType, String language, String publication, String image,
			String twitEmbed, String twitEmbedCode, String fbEmbed, String youTube, String mediaContact, String task){
		logger3.info("storyInitialize method is called");
		Integer imageCount = 0;
		CreateBrandStory.languageValue = language;
		CreateBrandStory.templateValue = templateType;
		CreateBrandStory.selectPublication = publication;
		
		Assert.assertEquals(CreateBrandStory.languageSelection(), true);
		logger3.info("languageSelection successfully runs");
		
		Assert.assertEquals(CreateBrandStory.createBrandStory(), true);
		logger3.info("createBrandStory successfully runs");
		
		// Checking the article layout
		logger3.info("Checking the template type");
		logger3.info("Value of template entered is " + templateValue );
		Assert.assertEquals(CreateBrandStory.checkTemplateType(), true);
		logger3.info("The checkTemplateType method successfully runs");
		
		
		if (CreateBrandStory.languageValue.equalsIgnoreCase("English")) {
			if (selectPublication.equalsIgnoreCase("TOI")) {
				CreateBrandStory.commonTOIInfo();
				CreateBrandStory.commonBWInfo();
				CreateBrandStory.createStory();

			} else if (selectPublication.equalsIgnoreCase("ET")) {
				CreateBrandStory.commonETInfo();
				CreateBrandStory.commonBWInfo();
				CreateBrandStory.createStory();

			} else if (selectPublication.equalsIgnoreCase("TOI&ET")) {
				CreateBrandStory.commonTOIInfo();
				CreateBrandStory.commonETInfo();
				CreateBrandStory.commonBWInfo();
				CreateBrandStory.createStory();
			}
		} else if (CreateBrandStory.languageValue.equalsIgnoreCase("Hindi")) {
			if (selectPublication.equalsIgnoreCase("NBT")) {
				// CreateStoryListicle.selectNBT();
				CreateBrandStory.commonNBTInfo();
				CreateBrandStory.commonBWInfo();
				CreateBrandStory.createStory();
			}
		}
		try {
			imageCount = Integer.parseInt(image);
		} catch (NumberFormatException e) {
			double d = Double.parseDouble(image);
			imageCount = (int) d;
		}
		if(CreateBrandStory.templateValue.equalsIgnoreCase("Listicle")){
			CreateBrandStory.uploadListicleImage(imageCount);
		}
		else{
			((JavascriptExecutor) BaseClass.driver).executeScript("window.scrollBy(0,500)");
			CreateBrandStory.uploadNormalImage(imageCount);
		}
		CreateBrandStory.hidden(BaseClass.prop.getProperty("overlay"));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (twitEmbed.equalsIgnoreCase("Yes")) {
			try {
				CreateBrandStory.insertTwitterEmbed(twitEmbedCode);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (fbEmbed.equalsIgnoreCase("Yes")) {
			CreateBrandStory.insertFacebookEmbed();
		}
		if (youTube.equalsIgnoreCase("Yes")) {
			try {
				CreateBrandStory.insertYoutubeVideo();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CreateBrandStory.selectBrandStoryType();
		} else {
			CreateBrandStory.selectBrandStoryType();
		}
		if (mediaContact.equalsIgnoreCase("Yes")) {
			try {
				CreateBrandStory.checkMediaContact();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			CreateBrandStory.uncheckMediaContact();
		}
		if (task.equalsIgnoreCase("Publish")) {
			CreateBrandStory.finalPublish();
		}

		return true;
	}

	public static boolean checkTemplateType() {
		logger3.info("checkTemplateType method called");
		if (templateValue.equalsIgnoreCase("Self Serve")) {
			logger3.info("If block has been called");
			//CreateStoryListicle.elementClickable(BaseClass.prop.getProperty("selfServeTemplate"));
			CreateBrandStory.click(BaseClass.prop.getProperty("selfServeTemplate"));
		}
		else if(CreateBrandStory.templateValue.equalsIgnoreCase("Listicle")){
			logger3.info("Template type is listicle");
			logger3.info("else block has been called");
		}
		return true;
	}
	
	public static boolean createBrandStory() {
		logger3.info("createBrandStory method is called");
		LoginPage.click(BaseClass.prop.getProperty("clientDropdown"));
		LoginPage.click(BaseClass.prop.getProperty("clientEnterText"));
		LoginPage.sendData(BaseClass.prop.getProperty("clientEnterText"), BaseClass.prop.getProperty("client"));
		LoginPage.sendEnterKey(BaseClass.prop.getProperty("clientEnterText"), Keys.ENTER.charAt(0));
		LoginPage.hidden(BaseClass.prop.getProperty("overlay"));
		LoginPage.elementClickable(BaseClass.prop.getProperty("brandDropdown"));
		LoginPage.click(BaseClass.prop.getProperty("brandDropdown"));
		LoginPage.click(BaseClass.prop.getProperty("brandEnterText"));
		LoginPage.sendData(BaseClass.prop.getProperty("brandEnterText"), BaseClass.prop.getProperty("brandName"));
		LoginPage.sendEnterKey(BaseClass.prop.getProperty("brandEnterText"), Keys.ENTER.charAt(0));
		LoginPage.hidden(BaseClass.prop.getProperty("overlay"));
		return true;

	}
	

}
