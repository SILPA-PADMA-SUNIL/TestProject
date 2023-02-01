package testngSample;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class MultipleWindowHandles {
	WebDriver driver;
	@Test
	public void mutltipleWindowHandling() throws InterruptedException {
		String parentWindow= driver.getWindowHandle();
		System.out.println("parent window hande "+ parentWindow);
		
		WebElement openNewWindowButton=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(openNewWindowButton));

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openNewWindowButton);
		
		openNewWindowButton.click();
		
		Set<String> childWindows=driver.getWindowHandles();
		System.out.println("child window handle "+ childWindows);
		
		Iterator<String> iterator=childWindows.iterator();
		
		while(iterator.hasNext())
		{
			String child=iterator.next();
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);      //switch to child
				driver.manage().window().maximize();
				//operations in child window
				WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
				firstName.sendKeys("silpa");
				//Thread.sleep(5000);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);     //switch back to parent window
		//Thread.sleep(5000);
		



	}
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		 driver.quit();
	}

}
