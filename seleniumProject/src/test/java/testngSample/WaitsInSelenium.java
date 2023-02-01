package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WaitsInSelenium {
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
		//explicit wait
		//clients=new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Clients']")));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clients));
		
		clients.click();
		WebElement clientNameSearchBox=driver.findElement(By.cssSelector("input#clientsearch-client_name"));
		clientNameSearchBox.sendKeys("Sam");
		WebElement searchButton=driver.findElement(By.xpath("//button[text()='Search']"));
		searchButton.click();
		WebElement sam=driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]"));
		//explicit wait
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]")));
		//wait.until(ExpectedConditions.visibilityOf(sam));
		
		
		//fluent waits
		Wait<WebDriver> fWait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		fWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='table table-striped table-bordered']//tr[3]//td[2]")));                                   
				
		
		String expectedText="Sam";
		String actualText=sam.getText();
		Assert.assertEquals(actualText, expectedText);

	}
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/"); 
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
