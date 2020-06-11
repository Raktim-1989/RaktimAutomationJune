package com.rediff.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rediff.base.Base;

public class InboxPage  extends Base{
	
	public InboxPage()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@title= 'Go to Raktim Sarkar profile']")
	WebElement profile;
	
	public void onClickItem()
	{
		List<WebElement> rowcount = driver.findElements(By.xpath("//*[@class= 'rd_main_page_cont']/div[2]//ul[@class = 'rd_ml']/li"));
		System.out.println("the rowcount " + rowcount.size());
		for (int i = 1; i < rowcount.size(); i++) {
	WebElement description = driver.findElement(By.xpath("//*[@class= 'rd_main_page_cont']/div[2]//ul[@class = 'rd_ml']/li["+i+"]/span[2]"));
	if (description.getText().contains("Welcome to Rediffmail")) {
		description.click();
		String header = driver.findElement(By.xpath("//*[@class= 'read_originalmail']//div/h2")).getText();
		System.out.println("The header name of the item is " + header);
		driver.findElement(By.xpath("//a[@class= 'ng_mid_backlink']")).click();
	}
				}
		
				
	}
	
 public String profileVerification()
	{
       return  profile.getAttribute("title");
       
	}
	
	
}
