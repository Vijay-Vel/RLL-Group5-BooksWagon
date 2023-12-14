package com.BooksWagon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	@FindBy(xpath="//input[@value='Add to Wishlist']")      
	static WebElement wishlist1;
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
		
	}
	public void wishlistsearch()
	{
		wishlist1.click();
		//assertTrue(true);
	}
}
