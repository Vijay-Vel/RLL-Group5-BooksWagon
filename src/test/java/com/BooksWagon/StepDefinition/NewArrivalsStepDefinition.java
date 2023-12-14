package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Pages.NewArrivalsPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewArrivalsStepDefinition {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	NewArrivalsPage np;
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;
	Logger logger = LogManager.getLogger(NewArrivalsStepDefinition.class);
	public NewArrivalsStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	@When("I am open the bookswagon Home Page")
	public void i_am_open_the_bookswagon_home_page() throws InterruptedException, EncryptedDocumentException, IOException {
	    
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

	@When("I click on New Arrival button")
	public void i_click_on_new_arrival_button() {
		hp.NewArrivals();
		logger.info("Testing New Arrivals Functionality");
		 String ExpectedTitle = "New Arrivals";
		 String ActualTitle = driver.getTitle();
		 Assert.assertEquals(ExpectedTitle, ActualTitle, "Title is Same");
	}

	@Then("I Select the Paper")
	public void i_select_the_paper() throws InterruptedException {
		np = new NewArrivalsPage(driver);
		np.paper();
		String ExpectedTitle = "Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ExpectedTitle, ActualTitle, "Title is Same");
	    
	}

	@Then("I type Select the Language")
	public void i_type_select_the_language() throws InterruptedException {
		np.Select_lang();
	
	}

	@Then("I select one Book")
	public void i_select_one_book() {
	    np.Select_Book();
	}

	@Then("I finally buy a Books")
	public void i_finally_buy_a_books() throws InterruptedException {
		np.Buy();
		Thread.sleep(1000);
	    
	}


}
