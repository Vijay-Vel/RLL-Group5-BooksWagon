package com.BooksWagon.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.BooksWagon.StepDefinition.SharedSteps;

public class ScreenshotUtility {

	public static  String takeScreenshot() throws IOException {
				
		TakesScreenshot ts = (TakesScreenshot)SharedSteps.driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\USER\\eclipse-workspace\\BooksWagon-Project\\target\\myScreenshot_"+System.currentTimeMillis()+".png";
		File target = new File(path);
		FileUtils.copyFile(source, target);
		
		String targetpath = target.getAbsolutePath();
		return targetpath;
}
}
