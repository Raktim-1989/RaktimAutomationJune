

package com.rediff.pageobject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.base.Base;

public class HomePage extends Base{
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[contains(text(), 'Sign in')]")
	public WebElement SignIn;
	@FindBy(xpath = "//*[contains(text(), 'Create Account')]")
	WebElement SignUp;

public String getTitleHome()
{
		return driver.getTitle();
	
}

public SignInPage onClickSignIn()
{
	SignIn.click();
	return new SignInPage();
}

public SignUpPage onClickSignup()
{
	SignUp.click();
	return new SignUpPage();
}
	
	

}
