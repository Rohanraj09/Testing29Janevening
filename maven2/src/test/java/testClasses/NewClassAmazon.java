package testClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import browsers.Base;
import pomclass.AmazonHomePage;
import utils.Utility;

public class NewClassAmazon{
	WebDriver driver;
	AmazonHomePage amazonHomePage;
	 @Parameters ("BrowserName")
	 
	 @BeforeTest
	 public void launchBrowser (String browser) {
		  
		  System.out.println(browser);
		  if(browser.equals("Chrome"))
		  {
			  driver=Base.OpenChromeBrowser();
		  }
		  if(browser.equals("Firefox"))
		  {
			  driver=Base.OpenFirfoxBrowser();
		  }
		
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	 
	 
	@BeforeClass
	public void CreatePomPage() {
		
		 amazonHomePage = new AmazonHomePage (driver);

		
	}
	@BeforeMethod
	  public void launchApplication() {
        driver.get("https://www.amazon.in/");

	}
	
	@Test 
	public void varifysellertab() {
		
		amazonHomePage.clickbestseller();
		String d=driver.getTitle();
		String t =driver.getCurrentUrl();
		 Assert.assertEquals("https://www.amazon.in/gp/bestsellers/?ref_=nav_cs_bestsellers", t);
		 Assert.assertEquals("Amazon.in Bestsellers: The most popular items on Amazon", d);
		
	}
		@Test
		public void varifymobile() {
			amazonHomePage.clickmobile();
			String url = driver.getCurrentUrl();
			String title = driver .getTitle();
			Assert.assertEquals("https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles", url);
			Assert.assertEquals("Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in",title);
			
			
		}
			@Test
			public void VarifyCustomerservicetab() {
				amazonHomePage.clickcustomerservice();
				
				String url = driver.getCurrentUrl();
				String title = driver .getTitle();
				Assert.assertEquals("https://www.amazon.in/gp/help/customer/display.html?nodeId=200507590&ref_=nav_cs_help", url);
				Assert.assertEquals("Help - Amazon Customer Service", title);
				
			}
	@Test  (enabled = false)
	public void mouseaction() {
		amazonHomePage.listshow(driver);
		
		
	}
	
	@Test  (enabled = false)
	public void clickall() {
		
		amazonHomePage.clickall();
		
		
	}
	@Test
	public void screenshot() throws IOException {
		
		amazonHomePage.screenshot(driver);
		
	}
	
	
				@Test
  public void varifytodaysdealtab() {
					amazonHomePage.clicktodaysdeal();
					
					String url = driver.getCurrentUrl();
					String title = driver .getTitle();
					
					Assert.assertEquals("https://www.amazon.in/deals?ref_=nav_cs_gb", url);
					Assert.assertEquals("Amazon.in - Today's Deals", title);
					
				}
			@Test
			public void varifyfashiontab() {
				amazonHomePage.clickfashion();
				
				String url = driver.getCurrentUrl();
				String title = driver .getTitle();
				Assert.assertEquals("https://www.amazon.in/gp/browse.html?node=6648217031&ref_=nav_cs_fashion", url);
				Assert.assertEquals("Amazon Fashion: Clothing, Footwear and Accessories online for Men, Women and Kids", title);
				
				
			}
     
			 @AfterMethod 
			 public void exit (ITestResult result) throws IOException {
				 if(ITestResult.FAILURE==result.getStatus()){
					Utility.capturescreenshot(driver, result.getName());
				 }
			 }
				    
			
		  @AfterTest 
		  public void logout () {
		 	 driver.close();
		 	 driver=null;
		 	   System.gc();
		  }	
			
		}
		
		
	
	
		
	
	

