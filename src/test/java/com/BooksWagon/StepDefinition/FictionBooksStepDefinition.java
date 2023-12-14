package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.BooksWagon.Pages.FictionBooksPage;
import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FictionBooksStepDefinition {

	Logger logger = LogManager.getLogger(FictionBooksStepDefinition.class);
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	FictionBooksPage fp;
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;
	
	public FictionBooksStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	@Given("User is on the Bookswagon website HomePage")
	public void user_is_on_the_bookswagon_website_home_page() throws InterruptedException, EncryptedDocumentException, IOException {
		driver=s.getDriver();
		hp = new HomePage(driver);
		hp.clickLogin(driver);
		lp = new LoginPage(driver);
		inputData = ExcelUtility.getTestData("Sheet2");
		String EmailId = (String) inputData[currentRow][0];
		lp.enter_email(EmailId);
		
		inputData = ExcelUtility.getTestData("Sheet2");
		String password = (String) inputData[currentRow][1];
	    lp.enter_password(password);
	    
	    lp.click_loginbtn();
	}

	@When("User navigates to the Fiction books section")
	public void user_navigates_to_the_fiction_books_section() {
	    hp.click_fiction();
	    logger.info("Testing Fiction Books Functionality");
	    String ExpectedTitle = "Fiction Books";
		String ActualTitle = driver.getTitle();
		Assert.assertNotEquals(ExpectedTitle, ActualTitle, "Title is Same");
	}

	@When("User selects a book")
	public void user_selects_a_book() throws InterruptedException {
		fp =  new FictionBooksPage(driver);
	    fp.click_book();
	}

	@Given("User adds the book to the cart in fiction")
	public void user_adds_the_book_to_the_cart_in_fiction() throws InterruptedException {
	    fp.buy_now();
	}

	@When("User verifies the book is in the cart")
	public void user_verifies_the_book_is_in_the_cart() throws InterruptedException {
	    fp.Cart();
	}

}
