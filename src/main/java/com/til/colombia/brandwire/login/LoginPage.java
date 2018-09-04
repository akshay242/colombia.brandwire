package com.til.colombia.brandwire.login;

import org.apache.log4j.Logger;
import com.til.brandwire.main.BaseClass;

public class LoginPage extends Helper {
	public static final Logger logger1 = Logger.getLogger(LoginPage.class);

	public boolean verifyLogin() {
		// sign in + send keys + click all will happen here
		
		logger1.info("Inside verifyLogin method ");
		LoginPage.click(BaseClass.prop.getProperty("signInButton"));
		LoginPage.waiting(BaseClass.prop.getProperty("emailField"));
		LoginPage.sendData(BaseClass.prop.getProperty("emailField"), BaseClass.prop.getProperty("email"));
		LoginPage.waiting(BaseClass.prop.getProperty("logInButton"));
		LoginPage.click(BaseClass.prop.getProperty("logInButton"));
		logger1.info("Value of button is " + BaseClass.prop.getProperty("logInButton"));
		LoginPage.sendData(BaseClass.prop.getProperty("passwordField"), BaseClass.prop.getProperty("password"));
		LoginPage.click(BaseClass.prop.getProperty("logInButton"));
		return true;
	}
	public boolean accordionClick() {
		logger1.info("Inside the accordionClick method");
		LoginPage.waiting(BaseClass.prop.getProperty("contentAccordian"));
		LoginPage.click(BaseClass.prop.getProperty("contentAccordian"));
		LoginPage.click(BaseClass.prop.getProperty("createStory"));
		return true;

	}
	
	
	

}

