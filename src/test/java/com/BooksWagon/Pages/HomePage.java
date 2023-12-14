package com.BooksWagon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	@FindBy(xpath="//div[@class='col-sm-5 d-flex align-items-center justify-content-end']/descendant::span[3]")
	WebElement MyAccount;
	
	@FindBy(xpath="//div[@class='userpopup']/descendant::a[1]")
	WebElement LoginBtn;
	
	@FindBy(xpath=("//input[@class='inputbar']"))
	static WebElement searchbox1;
	
	@FindBy(xpath=("//input[@name='btnTopSearch']"))
	static WebElement searchbutton;
	
	@FindBy(linkText = "Request a Book")
	WebElement requestButton;
	
	@FindBy(xpath="//li[@id='ctl00_liAW']/a")
	WebElement awardWinners;
	
	@FindBy(linkText="Best sellers")
	WebElement BestSellers;
	
	@FindBy(linkText="Fiction Books")
	WebElement FictionLink;
	
	@FindBy(linkText=("New Arrivals"))
	static WebElement NewArrivals;
	
	@FindBy(linkText="Box Sets")
	static WebElement BoxSets;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void	clickLogin(WebDriver driver) throws InterruptedException {
		
		Actions a = new Actions(driver);
		a.moveToElement(MyAccount).perform();
		Thread.sleep(1500);
		
		LoginBtn.click();
		
	}
	
	public void searchitem(String search) throws InterruptedException
	{
		searchbox1.sendKeys(search);
		Thread.sleep(1000);
		searchbutton.click();
	}
	 public void click_RequestBook() {		
	    	requestButton.click();
	        
	    }
	 
	 public void	clickaward() {
			awardWinners.click();
		}
	 
	 public void click_BestSellers() {
			BestSellers.click();
		}
	 
	 public void click_fiction() {
			FictionLink.click();
		}
	 
	 public void NewArrivals()
		{
			NewArrivals.click();
		}
	 
	 public void clickBoxSets()
		{
			BoxSets.click();
		}

}
