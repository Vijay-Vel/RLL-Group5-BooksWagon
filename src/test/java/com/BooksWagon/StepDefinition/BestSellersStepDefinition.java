package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.BooksWagon.Pages.BestSellersPage;
import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BestSellersStepDefinition {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	BestSellersPage bp;
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;
	Logger logger = LogManager.getLogger(BestSellersStepDefinition.class);
	public BestSellersStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	
	@Given("User is on the home Page")
	public void user_is_on_the_home_page() throws InterruptedException, EncryptedDocumentException, IOException {
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

	@When("User clicks on the Best Sellers section")
	public void user_clicks_on_the_best_sellers_section() {
		hp.click_BestSellers();
		logger.info("Testing Best Seller Functionality");
	}

	@When("User selects a book from the Best Sellers")
	public void user_selects_a_book_from_the_best_sellers() throws InterruptedException {
		bp =  new BestSellersPage(driver);
		bp.click_book();
		Thread.sleep(1000);
	    
	}

	@When("User adds the book to the cart")
	public void user_adds_the_book_to_the_cart() throws InterruptedException {
	    bp.click_buy();
	    Thread.sleep(1000);
	    }

}
