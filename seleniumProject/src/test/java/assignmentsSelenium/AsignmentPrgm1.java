package assignmentsSelenium;

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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AsignmentPrgm1 {
	WebDriver driver;
	
	@Test(priority = 1)
	public void verifyTheDetailsOfPerson() {
		WebElement table=driver.findElement(By.xpath("//a[contains(text(),'Table')]"));
		table.click();
		WebElement tigerNixon=driver.findElement(By.xpath("(//tr[@class='odd'])[1]"));
		System.out.println(tigerNixon.getText());
		Boolean actual=tigerNixon.isDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority = 2)
	public void verifyTheSearchFunctionality()
	{
		WebElement table=driver.findElement(By.xpath("//a[contains(text(),'Table')]"));
		table.click();
		WebElement tableSortAndSearch=driver.findElement(By.xpath("//a[contains(text(),'Table Sort ')]"));
		tableSortAndSearch.click();
		WebElement searchBox=driver.findElement(By.xpath("//input[@type='search']"));
		searchBox.sendKeys("Dai Rios");
		WebElement daiRios=driver.findElement(By.xpath("//td[@class='sorting_1 dtr-control']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='sorting_1 dtr-control']")));
		Boolean actual=daiRios.isDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority = 3)
	public void verifyHomeTabIsDisplayed() {
		WebElement homeTab=driver.findElement(By.xpath("//a[text()='Home']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Home']")));
		Boolean actual=homeTab.isDisplayed();
		Assert.assertTrue(actual);
	}
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
