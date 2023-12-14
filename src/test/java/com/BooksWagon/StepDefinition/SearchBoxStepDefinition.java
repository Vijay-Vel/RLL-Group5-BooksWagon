package com.BooksWagon.StepDefinition;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.BooksWagon.Pages.HomePage;
import com.BooksWagon.Pages.LoginPage;
import com.BooksWagon.Pages.SearchPage;
import com.BooksWagon.Utilities.ExcelUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SearchBoxStepDefinition {
	
	WebDriver driver;
	HomePage hp;
	SearchPage sp;
	LoginPage lp;
	SharedSteps s;
	Object[][] inputData;
	static int currentRow = 0;
	String search;
	Logger logger = LogManager.getLogger(SearchBoxStepDefinition.class);
	
	public SearchBoxStepDefinition(SharedSteps s)
	{
		this.s=s;
	}
	
	@Given("user entering the {string} item in the search box")
	public void user_entering_the_item_in_the_search_box(String string) throws EncryptedDocumentException, IOException {
		driver=s.getDriver();
		inputData = ExcelUtility.getTestData("Sheet3");
		search = (String) inputData[currentRow][0];
		currentRow=currentRow+1;
		
	}

	@Given("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		hp = new HomePage(driver);
		logger.info("Testing Search Box Functionality");
		hp.searchitem(search);
		String actualsearch=search;
		String Expectedsearch="Beyond The Story: 10-Year Record of BTS";
		Assert.assertEquals(actualsearch, Expectedsearch, "Assert not same search item");
	}

	@When("User click on wishList")
	public void user_click_on_wish_list() throws EncryptedDocumentException, IOException {
		sp = new SearchPage(driver);
		sp.wishlistsearch();
		inputData = ExcelUtility.getTestData("Sheet2");
		String email = (String) inputData[currentRow-1][0];
	
		lp = new LoginPage(driver);
		lp.enter_email(email);
		inputData = ExcelUtility.getTestData("Sheet2");
		String password = (String) inputData[currentRow-1][1];
		lp.enter_password(password);
		lp.click_loginbtn();
		
	}

}
