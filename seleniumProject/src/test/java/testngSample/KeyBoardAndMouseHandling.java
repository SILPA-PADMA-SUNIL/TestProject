package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class KeyBoardAndMouseHandling {
	WebDriver driver;
  @Test
  public void verifyTheYourMessagrTextIsDisplayedUsingKeyboardHandlings() {
	  WebElement enterMessage=driver.findElement(By.xpath("//input[@id='single-input-field']"));
	  Actions action=new Actions(driver);           //instantiate actions class
	  action.keyDown(Keys.SHIFT).build().perform();
	  enterMessage.sendKeys("hi");
	  action.keyUp(Keys.SHIFT).build().perform();
	  
	 // action.keyDown(Keys.TAB).build().perform();
	 // action.keyUp(Keys.TAB).build().perform();
	  //or
	  action.sendKeys(Keys.TAB).build().perform();    //keypress using sendkeys
	  
	 // action.sendKeys(Keys.ENTER).build().perform();  
	 //or 
	  WebElement showMshButton=driver.findElement(By.xpath("//button[@id='button-one']"));
	  action.sendKeys(showMshButton,Keys.ENTER).build().perform();           //click using sendkeys
	  
	  WebElement message=driver.findElement(By.xpath("//div[@id='message-one']"));
	  Boolean actual=message.isDisplayed();
	  Assert.assertTrue(actual);  
  }
  @Test
  public void mouseHandling()
  {
	 WebElement homeTab=driver.findElement(By.xpath("//a[text()='Home']")) ;
	 Actions action=new Actions(driver);
	 action.moveToElement(homeTab).build().perform();
	 //action.contextClick(homeTab).build().perform();
	 action.doubleClick(homeTab).build().perform();
	 
			 
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
