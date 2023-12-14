package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginFeatureStepDefinition {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;
	Logger logger = LogManager.getLogger(LoginFeatureStepDefinition.class);
	public LoginFeatureStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	@Given("the User is on the BooksWagon home page")
	public void the_user_is_on_the_books_wagon_home_page() throws InterruptedException {
		driver=s.getDriver();
		
	}

	@Then("the User hover My Accounts and clicks on the login button")
	public void the_user_hover_my_accounts_and_clicks_on_the_login_button() throws InterruptedException {
		logger.info("Testing Login Page Functionality");
		hp = new HomePage(driver);
		hp.clickLogin(driver);
	}

	@When("the User enter email as {string} on the login page")
	public void the_user_enter_email_as_on_the_login_page(String string) throws InterruptedException, EncryptedDocumentException, IOException {
		lp = new LoginPage(driver);
		Thread.sleep(500);
		inputData = ExcelUtility.getTestData("Sheet1");
		String EmailId = (String) inputData[currentRow][0];
		lp.enter_email(EmailId);
	}

	@When("the User enter password as {string} on the login page")
	public void the_user_enter_password_as_on_the_login_page(String string) throws InterruptedException, EncryptedDocumentException, IOException {
		Thread.sleep(500);
		inputData = ExcelUtility.getTestData("Sheet1");
		String password = (String) inputData[currentRow][1];
	    lp.enter_password(password);
	    currentRow = currentRow+1;
	}

	@When("the User clicks on the login button on the page")
	public void the_user_clicks_on_the_login_button_on_the_page() throws InterruptedException {
		Thread.sleep(1000);
	    lp.click_loginbtn();
	}

	@When("the User hover My Account and clicks on logout button")
	public void the_user_hover_my_account_and_clicks_on_logout_button() throws InterruptedException {
		String uname=lp.get_uname();
		Assert.assertNotEquals(uname,"My Account");
	    lp.user_logout(driver);
	}

}
