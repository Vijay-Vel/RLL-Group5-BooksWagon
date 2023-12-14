package com.BooksWagon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BoxSetsPage {
	
	@FindBy(xpath="//div[@class='row bestsellerbox']/descendant::a[1]")
	WebElement book1;
	@FindBy(xpath="//div[@id='ctl00_phBody_ProductDetail_divaction']/descendant::input[1]")
	WebElement buynow;
	
	public BoxSetsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		
	}
	
	public void books() throws InterruptedException {
		book1.click();
		Thread.sleep(1000);
		
	}
	public void buynow()
	{
		buynow.click();
	}


}
