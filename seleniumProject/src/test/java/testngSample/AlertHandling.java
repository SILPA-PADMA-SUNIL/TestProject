package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class AlertHandling {
	WebDriver driver;
  @Test
  public void alertHandling() throws InterruptedException {
	  WebElement customerId=driver.findElement(By.name("cusid"));
	  customerId.sendKeys("123");
	  WebElement submitButton=driver.findElement(By.xpath("//input[@name='submit']"));
	  submitButton.submit();
	  Thread.sleep(1000);
	 driver.switchTo().alert().accept();
	  //Thread.sleep(1000);
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.alertIsPresent());
	 System.out.println(driver.switchTo().alert().getText());
	  driver.switchTo().alert().accept();
  }
  @Test
  public void alertDismissing()
  {
	  WebElement customerId=driver.findElement(By.name("cusid"));
	  customerId.sendKeys("123");
	  WebElement submitBtn=driver.findElement(By.xpath("//input[@name='submit']"));
	  submitBtn.submit();
	  driver.switchTo().alert().dismiss();
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
