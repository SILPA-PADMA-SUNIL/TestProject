package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Prgm3 {
	WebDriver driver;
	@Test
	public void navigationToOtherUrl() {
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
	}
	@Test
	public void verifyTheRadioButtonDemoIsClickable()
	{
		WebElement inputForm=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
		inputForm.click();
		WebElement radioButtonDemo=driver.findElement(By.xpath("//a[contains(text(),'Buttons')]"));
		radioButtonDemo.click();
		WebElement maleButton=driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
        maleButton.click();
        WebElement showSelectedValue=driver.findElement(By.xpath("//button[@id='button-one']"));
        showSelectedValue.click();
        WebElement msg=driver.findElement(By.xpath("//div[@id='message-one']"));
        System.out.println(msg.getText());
        
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
