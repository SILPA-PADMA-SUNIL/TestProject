package assignmentsSelenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TableAssignment {
	WebDriver driver;
	@Test(priority = 1)
	public void verifyTheNewProductAddedIsAvailableInTheTable() {
		WebElement userName=driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys("admin");

		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("password");

		WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		loginBtn.click();

		WebElement productTab=driver.findElement(By.xpath("(//*[text()='Product'])[1]"));
		productTab.click();

		WebElement addProductTab=driver.findElement(By.xpath("//button[@class='btn btn-add btn-lg']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", addProductTab);
		addProductTab.click();

		WebElement code=driver.findElement(By.xpath("//input[@id='ProductCode']"));
		code.sendKeys("0095");

		WebElement name=driver.findElement(By.xpath("//input[@id='ProductName']"));
		name.sendKeys("grapes");

		WebElement tax=driver.findElement(By.xpath("//input[@id='Tax']"));
		tax.sendKeys("20");

		WebElement price=driver.findElement(By.xpath("//input[@id='Price']"));
		price.sendKeys("100");

		WebElement submitBtn=driver.findElement(By.xpath("(//button[text()='Submit'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		submitBtn.click();

		WebElement submit=driver.findElement(By.xpath("(//button[text()='submit'])[2]"));

		submit.click();
		driver.navigate().refresh();

		WebElement searchBox=driver.findElement(By.xpath("//input[@type='search']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));

		searchBox.sendKeys("grapes");

		WebElement grapes=driver.findElement(By.xpath("//table[@id='Table']//tbody//tr[1]"));
		Boolean actual=grapes.isDisplayed();
		Assert.assertTrue(actual);


	}
	@Test(priority = 2)
	public void verifyTheEditFunctionalityOfAddedProduct()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@type='text']"));
		userName.sendKeys("admin");

		WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("password");

		WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		loginBtn.click();

		WebElement productTab=driver.findElement(By.xpath("(//*[text()='Product'])[1]"));
		productTab.click();

		WebElement searchBox=driver.findElement(By.xpath("//input[@type='search']"));
		searchBox.sendKeys("grapes");

		WebElement edit=driver.findElement(By.xpath("//a[@class='btn btn-default']/following-sibling::a[2]"));
		edit.click();

		WebElement tax=driver.findElement(By.xpath("//input[@id='Tax']"));
		tax.clear();
		tax.sendKeys("10");

		WebElement submitBtn=driver.findElement(By.xpath("//button[@type='submit']"));
		submitBtn.click();

		WebElement search=driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("grapes");

		WebElement grapes=driver.findElement(By.xpath("//table[@id='Table']//tbody//tr[1]"));
		grapes.getText();
		Boolean actual=grapes.isDisplayed();
		Assert.assertTrue(actual);

	}
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://qalegend.com/restaurant/login"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
