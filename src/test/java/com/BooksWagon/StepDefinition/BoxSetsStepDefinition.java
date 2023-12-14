package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.BooksWagon.Pages.BoxSetsPage;
import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BoxSetsStepDefinition {
	
	Logger logger = LogManager.getLogger(BoxSetsStepDefinition.class);
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	BoxSetsPage bp;
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;
	
	public BoxSetsStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	@Given("I am on the HomePage")
	public void i_am_on_the_home_page() throws InterruptedException, EncryptedDocumentException, IOException {
	    
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

	@Given("I click on Boxsets")
	public void i_click_on_boxsets() {
		hp.clickBoxSets();
		logger.info("Testing Box Sets Functionality");
	   
	}

	@When("I click on one book")
	public void i_click_on_one_book() throws InterruptedException {
		bp = new BoxSetsPage(driver);
	    bp.books();
	    Assert.assertTrue(true);
	}

	@When("I click on buynow")
	public void i_click_on_buynow() throws InterruptedException {
		bp.buynow();
		Assert.assertTrue(true);
		lp.user_logout(driver);
	}


}
