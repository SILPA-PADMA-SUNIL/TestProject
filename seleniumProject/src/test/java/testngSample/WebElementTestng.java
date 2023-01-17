package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class WebElementTestng {
	WebDriver driver;
	@Test
	public void verifyTheYourMessageTextIsShown()
	{
		WebElement inputForm=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
		inputForm.click();
		WebElement messageTextBox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		messageTextBox.sendKeys("hi");
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		showMessageButton.click();
		WebElement YourMessageText =driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(YourMessageText.getText());
		
	}
	@Test
	public void verifyTheFontFamilyOfInputform()
	{
		WebElement inputForm=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
		System.out.println(inputForm.getCssValue("font-family"));
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


