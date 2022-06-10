package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomclass.AmazonHomePage;

public class Verification {
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Chrome\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		
		AmazonHomePage amazonHomePage = new AmazonHomePage (driver);
		amazonHomePage.clickbestseller();
		String d=driver.getTitle();
		String t =driver.getCurrentUrl();
		
		if(t.equals("https://www.amazon.in/gp/bestsellers/?ref_=nav_cs_bestsellers")&& d.equals("Amazon.in Bestsellers: The most popular items on Amazon"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		amazonHomePage.clickmobile();
		String url = driver.getCurrentUrl();
		String title = driver .getTitle();
		
		if(url.equals("https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles")&& title.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.com"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		
		
		
		
		
	}
	
	
}
