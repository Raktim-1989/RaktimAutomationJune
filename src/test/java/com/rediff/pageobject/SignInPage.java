package com.rediff.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rediff.base.Base;

public class SignInPage extends Base {
	
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//input[@name =  'login']")
	WebElement username;
	@FindBy(xpath= "//input[@name =  'passwd']")
	WebElement password;
	@FindBy(xpath= "//input[@value =  'Sign in']")
	WebElement login;
	public String getTitleSignin()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'login']")));
		return driver.getTitle();
	}
	
	public InboxPage onSuccessfulLogin()
	{
		username.sendKeys(property.getProperty("Username"));
		log.debug("User enetred a valid username ");
		password.sendKeys(property.getProperty("Password"));
		log.debug("User entered a valid password");
		login.click();
		log.debug("Login Button is clicked");
		return new InboxPage();
	}
	
	
	
	
	
	

}
