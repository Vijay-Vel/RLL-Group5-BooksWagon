package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.BooksWagon.Pages.AwardWinnersPage;
import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AwardWinnersStepDefinition {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	AwardWinnersPage ap;
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;
	
	Logger logger = LogManager.getLogger(AwardWinnersStepDefinition.class);
	public AwardWinnersStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	@Given("I am on the home page")
	public void i_am_on_the_home_page() throws InterruptedException, EncryptedDocumentException, IOException {
		
		driver=s.getDriver();
		hp = new HomePage(driver);
		hp.clickLogin(driver);
		lp = new LoginPage(driver);
		
		inputData = ExcelUtility.getTestData("Sheet2");
		String EmailId = (String) inputData[currentRow][0];
		lp.enter_email(EmailId);
		
		logger.info("Testing Award Winners Functionality");
		inputData = ExcelUtility.getTestData("Sheet2");
		String password = (String) inputData[currentRow][1];
	    lp.enter_password(password);
	    
	    lp.click_loginbtn();
	    
	}

	@When("I click on the award link")
	public void i_click_on_the_award_link() {
		
		
		hp.clickaward();
		 String expectedTitle = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
		  String actualTitle = driver.getTitle();
		  Assert.assertEquals(expectedTitle, actualTitle);
		  logger.error("Error occured");
	}

	@When("I sort books by discount")
	public void i_sort_books_by_discount() {
	    ap = new AwardWinnersPage(driver);
	    ap.sortaward();
	}

	@When("I click on first book to buy")
	public void i_click_on_first_book_to_buy() throws InterruptedException {
	    ap.buybook();
	    Assert.assertTrue(ap.logo());
	}

	@Then("I click on cart to see details")
	public void i_click_on_cart_to_see_details() throws InterruptedException {
	    ap.cart();
	}

	@Then("I click on buy")
	public void i_click_on_buy() throws InterruptedException {
	    ap.buy();
	}

	@Then("I click on address save and continue")
	public void i_click_on_address_save_and_continue() throws InterruptedException {
	    ap.save();
	    Assert.assertTrue(ap.logoutvisible());
		  ap.click_logo();
		  lp.user_logout(driver);

	}

}
