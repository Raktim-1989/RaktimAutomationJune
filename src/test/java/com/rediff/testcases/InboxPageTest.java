package com.rediff.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rediff.base.Base;
import com.rediff.pageobject.HomePage;
import com.rediff.pageobject.InboxPage;
import com.rediff.pageobject.SignInPage;

public class InboxPageTest extends Base {
	
	SignInPage signin;
	InboxPage inbox;
	HomePage homepage;
	
	InboxPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		log.debug("Initialization method is invoked for InboxPage test");
		homepage = new 	HomePage();
		homepage.onClickSignIn();
		log.info("SignIn link from homepage is clicked to initiate the login process");
		signin = new SignInPage();
		signin.onSuccessfulLogin();
		log.info("Successful login is performed to initiate the InboxPage test");
		inbox = new InboxPage();
	}
		
	@Test
	public void onClickItemTest()
	{
		inbox.onClickItem();
		log.debug("Item is clicked from mail inbox");
	}
	
	@Test
	public void profileVerificationTest()
	{
		String title = inbox.profileVerification();
		log.info("Prifle is verified successfully");
		Assert.assertEquals(title, "Go to Raktim Sarkar profile");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("InBoxPage test is completed");
	}
	

}
