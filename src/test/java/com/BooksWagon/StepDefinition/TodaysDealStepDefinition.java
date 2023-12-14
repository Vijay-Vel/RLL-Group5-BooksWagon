package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Pages.TodaysDealPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TodaysDealStepDefinition {
	
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	TodaysDealPage tp;
	
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;

	Logger logger = LogManager.getLogger(TodaysDealStepDefinition.class);
	public TodaysDealStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	@Given("user click on the todays deals")
	public void user_click_on_the_todays_deals() throws EncryptedDocumentException, IOException, InterruptedException {
		driver=s.getDriver();
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		hp.clickLogin(driver);
		inputData = ExcelUtility.getTestData("Sheet2");
		String EmailId = (String) inputData[currentRow][0];
		lp.enter_email(EmailId);
		
		inputData = ExcelUtility.getTestData("Sheet2");
		String password = (String) inputData[currentRow][1];
	    lp.enter_password(password);
	    
	    lp.click_loginbtn();
	    logger.info("Testing Todays Deal Functionality");
	    tp = new TodaysDealPage(driver);
	    tp.todaysdeallink();
	}

	@Given("user selected first item.")
	public void user_selected_first_item() {
	    tp.select_todaysDeal_book();
	  
	    
	}

	@When("user click on the buynow buttons")
	public void user_click_on_the_buynow_buttons() throws InterruptedException {
		  tp.buyNow();
		  lp.user_logout(driver);
	}
}
