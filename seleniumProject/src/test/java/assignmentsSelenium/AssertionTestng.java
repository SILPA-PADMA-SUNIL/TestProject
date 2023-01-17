package assignmentsSelenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssertionTestng {
	WebDriver driver;
	@Test
	public void verifyTheApplicationCorrectlyOpensByHittingUrl() {
		String expectedUrl="https://demo.guru99.com/test/newtours/index.php";
		String actualUrl=driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	@Test
	public void verifyTheLogoMercuryToursIsDisplayed()
	{
		WebElement logo=driver.findElement(By.xpath("//img[@alt='Mercury Tours']"));
		Boolean actual=logo.isDisplayed();
		Assert.assertTrue(actual);
	}
	@Test
	public void verifySuccessfulSignOn()
	{
		WebElement signOn=driver.findElement(By.xpath("//a[text()='SIGN-ON']")) ;
		signOn.click();
		WebElement userName=driver.findElement(By.xpath("//input[@name='userName']"));
		userName.sendKeys("anna");
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("1234");
		WebElement submitButton=driver.findElement(By.xpath("//input[@name='submit']"));
		submitButton.submit();
		WebElement msgAfterSubmit=driver.findElement(By.xpath("//table[@border='0' and @width='492']//tr[1]//td[1]"));

		Boolean actualText= msgAfterSubmit.isDisplayed();
		Assert.assertTrue(actualText);
	}

	@Test
	public void verifySignInUsingInvalidUsernameAndPassword()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@name='userName']"));
		userName.sendKeys("chinnu");
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("1234");
		WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
		submit.submit();
		WebElement msgAfterSubmit=driver.findElement(By.xpath("(//table[@width='100%'])[2]//tr[3]//td[2]//span"));
		String actualText="Enter your userName and password correct";
		String expectedText="Enter your userName and password correct";
		Assert.assertEquals(actualText, expectedText);

	}


	
	@Test
	public void verifyRegisterLinkIsClickable ()
	{
		WebElement register=driver.findElement(By.xpath("//a[text()='REGISTER']"));
		register.click();
		WebElement registerTitle=driver.findElement(By.xpath("//table[@width='492']//tr[1]//td[1]//img"));
		
		Boolean actual=registerTitle.isDisplayed();
		Assert.assertTrue(actual);
	}
	@Test
	public void verifyTheOneWayRadioButtonIsSelectedByDefault()
	{
		//WebElement flights=driver.findElement(By.xpath("//a[text()='Flights']"));
		//flights.click();
		driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");
		WebElement oneWayButton=driver.findElement(By.xpath("//input[@value='oneway']"));
		Boolean actual=oneWayButton.isSelected();
		Assert.assertFalse(actual);
	}
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/index.php"); 
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
