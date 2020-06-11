package com.rediff.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest {
	
	public static WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "./" + "Drivers/chromedriver.exe");
	     driver = new ChromeDriver();	
	     driver.get("https://www.rediff.com/");
	}
	
	@Test
	public void main()
	{
		driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();
		driver.findElement(By.xpath("//input[@name =  'login']")).sendKeys("wrishi_1989");
		driver.findElement(By.xpath("//input[@name =  'passwd']")).sendKeys("Naj#2025");
		driver.findElement(By.xpath("//input[@value =  'Sign in']")).click();
		}

}
