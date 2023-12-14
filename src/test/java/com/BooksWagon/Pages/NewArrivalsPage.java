package com.BooksWagon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArrivalsPage {
	
	@FindBy(xpath=("(//div[@class='d-block position-relative fitertype mt-4'][1])/descendant::a[1]"))
	static WebElement Paper;
	
	@FindBy(xpath="(//div[@class='d-block position-relative fitertype mt-4'][2])/descendant::a[1]")
	static WebElement English;

	@FindBy(xpath="(//div[@class='d-block position-relative fitertype mt-4'][2])/descendant::a[4]")
	static WebElement Spanish;

	@FindBy(xpath="(//div[@class='d-block position-relative fitertype mt-4'][2])/descendant::a[6]")
	static WebElement Italian;
		
	@FindBy(xpath="//div[@class='row bestsellerbox']/descendant::a[1]")
	static WebElement Select_Book;
	
	@FindBy(xpath="//div[@id='ctl00_phBody_ProductDetail_divaction']/descendant::input[1]")
	 static WebElement Buy;
	
	public NewArrivalsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void paper() throws InterruptedException
	{
		Paper.click();
		Thread.sleep(1000);
	}
	
	public void Select_lang() throws InterruptedException
	{
		English.click();
		Thread.sleep(500);
		Spanish.click();
		Thread.sleep(500);
		Italian.click();
		Thread.sleep(500);
	}
	
	public void Select_Book()
	{
		Select_Book.click();
	}
	
	public void Buy()
	{
		Buy.click();
	}

}
