package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Pages.RequestABookPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestaBookStepDefinition {
	Logger logger = LogManager.getLogger(RequestaBookStepDefinition.class);
	WebDriver driver;
	HomePage hp;
	RequestABookPage rp;
	LoginPage lp;
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;
	static int currentRow1 = 0;
	
	public RequestaBookStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	
	@Given("The user clicks on Request a book Page")
	public void the_user_clicks_on_request_a_book_page() throws EncryptedDocumentException, IOException, InterruptedException {
		driver=s.getDriver();
		hp = new HomePage(driver);
		hp.clickLogin(driver);
		lp = new LoginPage(driver);
		inputData = ExcelUtility.getTestData("Sheet2");
		String EmailId = (String) inputData[currentRow1][0];
		lp.enter_email(EmailId);
		
		inputData = ExcelUtility.getTestData("Sheet2");
		String password = (String) inputData[currentRow1][1];
	    lp.enter_password(password);
	    
	    lp.click_loginbtn();
	    
		hp = new HomePage(driver);
		hp.click_RequestBook();
	   logger.info("Testing Request a Book Functionality");
	}

	@When("enter the required data iSBN as {string} Title as {string} Author as {string}  Phone as {string}")
	public void enter_the_required_data_i_sbn_as_title_as_author_as_phone_as(String string, String string2, String string3, String string4) throws InterruptedException, EncryptedDocumentException, IOException {
	    rp = new RequestABookPage(driver);
	    inputData = ExcelUtility.getTestData("Sheet5");
		String isbn = (String) inputData[currentRow][0];
		String BookTitle = (String) inputData[currentRow][1];
		String Author = (String) inputData[currentRow][2];
		String phone = (String) inputData[currentRow][3];
	    rp.enter_details(isbn, BookTitle, Author, phone);
	    Thread.sleep(1000);
	    currentRow=currentRow+1;
	}

	@When("Click the submit button")
	public void click_the_submit_button() {
		rp.click_submit();
		
	}

	@Then("request should be notify to them")
	public void request_should_be_notify_to_them() {
		
		String actual = "This book is already present";
		String expected = rp.get_message();
		Assert.assertNotEquals(actual,expected,"Book Already Present");
		
		String actual1 = "You have requested for this book before.";
		String expected1 = rp.get_message();
		Assert.assertNotEquals(actual1,expected1,"Book Already Requested");
	    
	}

}
