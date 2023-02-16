package assignmentsSelenium;

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

public class TestClassAssignment {
	WebDriver driver;
  @Test(dataProvider="successfulLogin",dataProviderClass=DataProviderAssgnment.class)
  public void verifySuccessfulLogin(String uname, String pwd) {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys(uname);
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys(pwd);
		WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
		login.click();
		
		WebElement carolThomas=driver.findElement(By.xpath("//a[text()='Carol Thomas']"));
		Boolean actual=carolThomas.isDisplayed();
		Assert.assertTrue(actual);
  }
  
  @Test(dataProvider="unSuccessfulLogin",dataProviderClass=DataProviderAssgnment.class)
  public void verifyUnsuccessfulLogin(String uname, String pwd) {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys(uname);
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys(pwd);
		WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
		login.click();
		
		WebElement errorMsg=driver.findElement(By.xpath("//p[text()='Incorrect username or password.']"));
		Boolean actual=errorMsg.isDisplayed();
		Assert.assertTrue(actual);
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
