package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Prgm4 {
	WebDriver driver;
  @Test
  public void verifyLogoSize() {
	  WebElement logo=driver.findElement(By.xpath("(//img[@alt='logo'])[1]"));
		System.out.println("logo size = " +logo.getSize());
  }
  @Test
  public void verifyTheHomeOption()
  {
	  WebElement home=driver.findElement(By.xpath("//a[text()='Home']"));
		System.out.println("tag name: " +home.getTagName());
		System.out.println("attribute value = " +home.getAttribute("class"));
		System.out.println("css value = " +home.getCssValue("font-size"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php"); 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
