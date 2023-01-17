package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserCommandTestng {
	WebDriver driver;
  @Test
  public void verifyTheTitleOfPage() {
	  System.out.println(driver.getTitle());
  }
  @Test
  public void verifyTheUrl()
  {
	  System.out.println(driver.getCurrentUrl());
  }
 @Test
  public void getUrlByClickingInputForm ()
  {
	  WebElement inputForm=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
		inputForm.click();
		System.out.println(driver.getCurrentUrl());
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php"); 
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
