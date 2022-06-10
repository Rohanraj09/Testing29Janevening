package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void capturescreenshot(WebDriver driver, String screenshotName ) throws IOException {
		
		         TakesScreenshot d = (TakesScreenshot) driver;
		         File source= d.getScreenshotAs(OutputType.FILE);
		         Calendar  cal=  Calendar.getInstance();
		         Date time = cal.getTime();
		          SimpleDateFormat fo = new  SimpleDateFormat("dd_MM_YYYY_hh_mm_ss");
		          
		         String z =   fo.format(cal.getTime());
		       
		         File destination = new File ("test-output\\Screenshot\\image"+"-" + screenshotName+"-"+z+".png");
	        
		         FileHandler.copy(source, destination);	
		         }

	
	
	
}
