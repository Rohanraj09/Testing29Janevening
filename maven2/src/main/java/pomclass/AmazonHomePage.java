package pomclass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage {

	@FindBy (xpath="(//a[@class='nav-a  '])[1]")private WebElement bestseller;
	
	@FindBy (xpath="//a[text()='Mobiles']")private WebElement mobile;
	
	@FindBy (xpath="//a[text()='Customer Service']")private WebElement customerservice;
	
	@FindBy (xpath="//a[@href='/deals?ref_=nav_cs_gb']")private WebElement todaysdeal ;
	
	@FindBy (xpath="//a[@data-csa-c-slot-id='nav_cs_4']")private WebElement fashion  ;
	
@FindBy (xpath="(//span[@class='nav-icon nav-arrow'])[2]")private WebElement list  ;


@FindBy (xpath="//select[@name='url']")private WebElement all  ;

WebDriver driver;
WebDriverWait wait;
	public AmazonHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickbestseller() {
		bestseller.click();
	}
	public void clickmobile() {
		mobile.click();
	}
	public void clickcustomerservice() {
		customerservice.click();
	}
	public void clicktodaysdeal() {
		todaysdeal.click();
	}
	public void clickfashion () {
		fashion.click();
	}
	
	public void clickall() {
		all.click();
		Select s = new Select(all);
		s.selectByVisibleText("Books");
		
	}
	
	public void screenshot (WebDriver driver) throws IOException {
		
		TakesScreenshot s = ((TakesScreenshot)driver);
	File source=	s.getScreenshotAs(OutputType.FILE);
		File destiny = new File("D:\\Selenium ScreenShot\\New screenshot\\amazon2.jpeg");
		FileHandler.copy(source, destiny);
	}
	
	public void listshow(WebDriver driver) {
//		wait=new WebDriverWait(driver,20);
//  	  wait.until(ExpectedConditions.visibilityOf(list));
		Actions act = new Actions(driver);
		act.moveToElement(list).perform();
		
	}
	
	
}
