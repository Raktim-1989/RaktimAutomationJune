package com.rediff.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rediff.base.Base;
import com.rediff.pageobject.HomePage;
import com.rediff.pageobject.InboxPage;
import com.rediff.pageobject.SignInPage;

public class SignInTest extends Base {
	
	SignInPage signin;
	InboxPage inbox;
	HomePage homepage;
	SignInTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		log.debug("initialization method is invoked for SignIn page test");
		homepage = new HomePage();
		homepage.onClickSignIn();
		log.info("SignIn link from homepage is clicked to initiate the login process");
		signin = new SignInPage();
						
	}
		
	@Test(priority=2)
	public void getTitleSigninTest()
	{
		String title = signin.getTitleSignin();
		log.info("SignIn page title is fetched from SignIn page");
		Assert.assertEquals(title, "Rediffmail");
	}
	
	@Test(priority=1)
	public void onSuccessfulLoginTest()
	{
		inbox = signin.onSuccessfulLogin();
		log.info("Login successful");
System.out.println("test git");   
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("SignInTest is completed");
	}

}
