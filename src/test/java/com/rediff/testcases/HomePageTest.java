package com.rediff.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rediff.base.Base;
import com.rediff.pageobject.HomePage;
import com.rediff.pageobject.SignInPage;
import com.rediff.pageobject.SignUpPage;

public class HomePageTest extends Base {
	public HomePage homepage;
	public SignInPage signin;
	public SignUpPage signup;
	
	//In TestNG framework even if we don't have @Test but we have @Beforemethod the  
	//constructor will be always called. Here since it have the parent constructor super()
	//when we will triger this case it will come to the child constructor which willl invoke super()
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		log.debug("Initialization method is invoked for homepage test");
	      homepage = new HomePage();
	 
	     	}
	
	@Test(priority=2)
	public void getTitleHomeTest()
	{
		String title = homepage.getTitleHome();
		log.info("HomePage title is fetched");
		Assert.assertEquals(title, "Rediff.com: News | Rediffmail1 | Stock Quotes | Shopping");
		
	}
	
	@Test(priority=1)
	public void onClickSignInTest()
	{	
		
		signin = homepage.onClickSignIn();
		log.info("SignIn link is clicked from reddif home page screen");
		
	}
	
	@Test(priority=3)
	public void onClickSignupTest()
	{
		signup = homepage.onClickSignup();
		log.info("SignUp link is clicked from home page screen");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("HomePageTest is completed");
	}
	
}
