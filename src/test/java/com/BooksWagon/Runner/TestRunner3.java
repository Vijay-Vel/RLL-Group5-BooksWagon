package com.BooksWagon.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\LoginFeatureBooksWagon.feature",
						//"C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\SearchAndTodaysDealFeature.feature",
						//"C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\RequestABook.feature",
						//"C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\TodaysDeal.feature",
						//"C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\AwardWinner.feature",
						//"C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\BestSellers.feature",
						//"C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\Fiction.feature",
						//"C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\NewArrivals.feature",
						//"C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\src\\test\\resources\\BoxSets.feature",
				glue= {"com.BooksWagon.StepDefinition"},
				dryRun=false,
						plugin={"pretty",
								"html:target/myreport2.html",
								  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
								  "timeline:test-output-thread/"}
)
public class TestRunner3 extends AbstractTestNGCucumberTests {

}
