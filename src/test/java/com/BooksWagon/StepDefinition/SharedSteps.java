package com.BooksWagon.StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SharedSteps {
	
	public static WebDriver driver;
	@Before
	public void setup() 
	{	
		driver = new ChromeDriver();
		driver.get("https://www.bookswagon.com/");
		driver.manage().window().maximize();
	}
	
	public WebDriver getDriver() 
	{
		return driver;
	}
	//@After
	public void tearDown() {
		driver.close();
	}

}
