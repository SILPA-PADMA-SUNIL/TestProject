package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TestClassForLogin {
	WebDriver driver;
  @Test(dataProvider="successfulLogin",dataProviderClass=DataProviderForLogin.class)
  public void verifySuccessfulLogin(String uname,String password) {
	  WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
	  userName.sendKeys(uname);
	  WebElement pass =driver.findElement(By.xpath("//input[@name='password']"));
	  pass.sendKeys(password);
	  WebElement signInBtn=driver.findElement(By.xpath("//button[text()='Sign In']"));
	  signInBtn.click();
	  
	  WebElement adminName=driver.findElement(By.xpath("//a[@data-toggle='dropdown']"));
	  Boolean actual=adminName.isDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  
  @Test(dataProvider="unSuccessfulLogin",dataProviderClass=DataProviderForLogin.class)
  public void verifyUnSuccessfulLogin(String uname,String password) {
	  WebElement userName=driver.findElement(By.xpath("//input[@name='username']"));
	  userName.sendKeys(uname);
	  WebElement pass =driver.findElement(By.xpath("//input[@name='password']"));
	  pass.sendKeys(password);
	  WebElement signInBtn=driver.findElement(By.xpath("//button[text()='Sign In']"));
	  signInBtn.click();
	 
	  WebElement alertMsg=driver.findElement(By.xpath("//h5[contains(text(),' Alert!')]"));
	  Boolean actual=alertMsg.isDisplayed();
	  Assert.assertTrue(actual);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://groceryapp.uniqassosiates.com/admin/login"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
