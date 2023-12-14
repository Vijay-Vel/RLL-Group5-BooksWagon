package com.BooksWagon.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestABookPage {
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtISBN']")
	WebElement ISBN;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtTitle']")
	WebElement Title;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtAuthor']")
	WebElement author;
	
	@FindBy(xpath="//*[@id='ctl00_phBody_RequestBook_txtPhone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_txtQty']")
	WebElement quantity;

	@FindBy(xpath="//input[@id='ctl00_phBody_RequestBook_imgbtnSave']")
	WebElement Submitbtn;
	
	@FindBy(xpath="(//div[@class='form-row'][4])/descendant::label")
	WebElement message;
	
	public RequestABookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void enter_details(String isbn, String bookTitle, String Author, String Phone) throws InterruptedException {
		ISBN.sendKeys(isbn);
		Thread.sleep(1000);
		
		Title.sendKeys(bookTitle);
		Thread.sleep(1000);
	
		author.sendKeys(Author);
		Thread.sleep(1000);
		
		phone.sendKeys(Phone);
		Thread.sleep(1000);
	}
	
	public void click_submit() {
		Submitbtn.click();
	}
	
	public String get_message() {
		return message.getText();
	}

}
