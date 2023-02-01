package assignmentsSelenium;

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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MultipleWindowHandlingAssignment {
	WebDriver driver;
	@Test(priority = 1)
	public void verifyCorrectWindowIsOpenedWhileClickingOpenNewWindowButton() {
		String parentWindow= driver.getWindowHandle();

		WebElement openNewWindowButton=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));

		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openNewWindowButton);

		openNewWindowButton.click();

		Set<String> childWindows=driver.getWindowHandles();

		Iterator<String> iterator=childWindows.iterator();
		
		while(iterator.hasNext())
		{
			String child=iterator.next();
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.manage().window().maximize();

		WebElement basicControls=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));

		Boolean actual=basicControls.isDisplayed();
		Assert.assertTrue(actual);
			}
		}
		driver.switchTo().window(parentWindow);
	}
	@Test(priority = 2)
	public void verifyTheRegistrationIsSuccessful ()
	{
		String parentWindow= driver.getWindowHandle();

		WebElement openNewWindowButton=driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openNewWindowButton);
		openNewWindowButton.click();

		Set<String> childWindows=driver.getWindowHandles();
		Iterator<String> iterator=childWindows.iterator();
		while(iterator.hasNext())
		{
			String child=iterator.next();
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.manage().window().maximize();

				WebElement firstName=driver.findElement(By.xpath("//input[@id='firstName']"));
				firstName.sendKeys("silpa");
				WebElement lastName=driver.findElement(By.xpath("//input[@id='lastName']"));
				lastName.sendKeys("PS");
				WebElement femaleRadioButton=driver.findElement(By.xpath("//input[@id='femalerb']"));
				femaleRadioButton.click();
				WebElement languageChekBox=driver.findElement(By.xpath("//input[@id='englishchbx']"));
				languageChekBox.click();
				WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
				email.sendKeys("silpa@gmail.com");
				WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
				password.sendKeys("12345");
				WebElement registerButton=driver.findElement(By.id("registerbtn"));
				registerButton.click();
				WebElement successMsg=driver.findElement(By.xpath("//label[text()='Registration is Successful']"));
				Boolean actual=successMsg.isDisplayed();
				Assert.assertTrue(actual);

				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	@Test(priority = 3)
	public void verifyCorrectWindowIsOpenedWhileClickingOpenNewTabButton()
	{
		String parentWindow= driver.getWindowHandle();

		WebElement openNewTabButton=driver.findElement(By.id("newTabBtn"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openNewTabButton);

		openNewTabButton.click();
		
		Set<String> childWindows=driver.getWindowHandles();

		Iterator<String> iterator=childWindows.iterator();
		while(iterator.hasNext())
		{
			String child=iterator.next();
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.manage().window().maximize();
		
		WebElement alertsDemo=driver.findElement(By.xpath("//h1[@class='post-title entry-title']"));

		Boolean actual=alertsDemo.isDisplayed();
		Assert.assertTrue(actual);
			}
		}
		driver.switchTo().window(parentWindow);

	}
	@Test(priority = 4)
	public void verifySimpleAlertIsAcceptedWhileClickingFirstClickMeButton()
	{
		String parentWindow= driver.getWindowHandle();
		
		WebElement openNewTabButton=driver.findElement(By.id("newTabBtn"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openNewTabButton);

		openNewTabButton.click();
		
		Set<String> childWindows=driver.getWindowHandles();

		Iterator<String> iterator=childWindows.iterator();
		while(iterator.hasNext())
		{
			String child=iterator.next();
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.manage().window().maximize();

				WebElement firstClickMeButton=driver.findElement(By.xpath("//button[@id='alertBox']"));
				firstClickMeButton.click();
				driver.switchTo().alert().accept();

				WebElement popupBoxOutput=driver.findElement(By.xpath("//div[starts-with(text(),'You selected')]"));
				String expectedText="You selected alert popup";
				String actualText=popupBoxOutput.getText();
				Assert.assertEquals(actualText, expectedText);
				
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}
	@Test(priority = 5)
	public void verifyThePropmtAlertIsAcceptedWhileClickingThirdClickMeButton()
	{
		String parentWindow= driver.getWindowHandle();
		
		WebElement openNewTabButton=driver.findElement(By.id("newTabBtn"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", openNewTabButton);

		openNewTabButton.click();
		
		Set<String> childWindows=driver.getWindowHandles();

		Iterator<String> iterator=childWindows.iterator();
		while(iterator.hasNext())
		{
			String child=iterator.next();
			if(!parentWindow.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				driver.manage().window().maximize();

				WebElement clickMeButton=driver.findElement(By.xpath("//button[@id='promptBox']"));
				
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.elementToBeClickable(clickMeButton));

				js.executeScript("arguments[0].scrollIntoView();", clickMeButton);
				
				clickMeButton.click();
				
				driver.switchTo().alert().sendKeys("zera");
				driver.switchTo().alert().accept();
				
				WebElement popupBoxOutput=driver.findElement(By.xpath("//div[@id='output']"));
				Boolean actualText=popupBoxOutput.isDisplayed();
				Assert.assertTrue(actualText);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
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
