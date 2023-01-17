package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TableXpath {
	WebDriver driver;
  @Test(priority = 1)
  public void verifySearchFunctionalityByUsingClientName() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  login.click();
	 WebElement clients=driver.findElement(By.xpath("//a[text()='Clients']"));
	  clients.click();
	  WebElement clientNameSearchBox=driver.findElement(By.cssSelector("input#clientsearch-client_name"));
	  clientNameSearchBox.sendKeys("Sam");
	  WebElement searchButton=driver.findElement(By.xpath("//button[text()='Search']"));
	  searchButton.click();
	 WebElement sam=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]"));
	  //System.out.println(sam.getText());
	  String expectedText="Sam";
	  String actualText=sam.getText();
	  Assert.assertEquals(actualText, expectedText);
	  
  }
  @Test(priority = 3)
  public void displayClientDetailsOfTom()
  {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  login.click();
	 WebElement clients=driver.findElement(By.xpath("//a[text()='Clients']"));
	 // clients.click();
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].click();", clients);
	  WebElement tom=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[12]"));
	 // JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("arguments[0].scrollIntoView();", tom);
	  Boolean actual=tom.isDisplayed();
	  Assert.assertTrue(actual);
  }
  
  
  
  @Test(priority = 2,enabled = false)
  public void verifySearchFunctionality() {
	  WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
	  userName.sendKeys("carol");
	  WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
	  password.sendKeys("1q2w3e4r");
	  WebElement login=driver.findElement(By.xpath("//button[text()='Login']"));
	  login.click();
	 WebElement clients=driver.findElement(By.xpath("//a[text()='Clients']"));
	  clients.click();
	  WebElement clientNameSearchBox=driver.findElement(By.cssSelector("input#clientsearch-client_name"));
	  clientNameSearchBox.sendKeys("Selenium");
	  WebElement searchButton=driver.findElement(By.xpath("//button[text()='Search']"));
	  searchButton.click();
	 // WebElement selenium=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[5]//td[2]"));
	 // System.out.println(selenium.getText());
	 // WebElement dennis=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[6]//td[2]"));
	 // System.out.println(dennis.getText());
	  WebElement jerry=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[13]"));
	  System.out.println(jerry.isDisplayed());
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
