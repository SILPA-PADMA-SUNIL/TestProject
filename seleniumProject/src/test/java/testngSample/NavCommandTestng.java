package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class NavCommandTestng {
	WebDriver driver;
  @Test
  public void verifyNavigationToOtherUrl() {
	  driver.navigate().to("http://groceryapp.uniqassosiates.com/admin/login");
  }
  @Test
  public void verifyNavigationBack()
  {
	  driver.navigate().back();
  }
  @Test
  public void verifyNavigationForward()
  {
	  driver.navigate().forward();
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
