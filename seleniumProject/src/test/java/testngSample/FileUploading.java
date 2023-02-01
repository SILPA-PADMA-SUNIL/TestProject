package testngSample;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FileUploading {
	WebDriver driver;
  @Test
  public void fileUploadUsingSendKeys() {
	  WebElement chooseFile=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
	
	  chooseFile.sendKeys("C:\\Users\\Sruthi\\Documents\\10 defects in amazon.docx");
	  WebElement acceptTerms=driver.findElement(By.xpath("//input[@id='terms']"));
	  acceptTerms.click();
	  WebElement submitFileButton=driver.findElement(By.id("submitbutton"));
	  submitFileButton.click();
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  WebElement msg=driver.findElement(By.xpath("//h3[@id='res']"));
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@id='res']")));
	  Boolean actual=msg.isDisplayed();
	 SoftAssert soft=new SoftAssert();
	 soft.assertTrue(actual);
	 soft.assertAll();
	  
  }
  @Test
  public void fileUploadUsingRobotClass() throws AWTException, InterruptedException
  {
	 driver.navigate().to("https://resume.naukri.com/resume-quality-score"); 
	 driver.navigate().refresh();
	 
	 WebElement browse=driver.findElement(By.xpath("//*[text()='Browse']"));
	 browse.click();
	 
	 Thread.sleep(3000);
	 
	 Robot rb=new Robot();            //instantiate robot class
	 StringSelection filePath=new StringSelection("C:\\Users\\Sruthi\\Documents\\xpath.docx");   //store file path to string selection
	 
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null); //copy above  path code
	 
	 rb.keyPress(KeyEvent.VK_CONTROL);    //control key pressing
	 Thread.sleep(3000);
	 
	 rb.keyPress(KeyEvent.VK_V);         //v key pressing
	 
	 rb.keyRelease(KeyEvent.VK_CONTROL);   //control key releasing
	 Thread.sleep(3000);
	 rb.keyRelease(KeyEvent.VK_V);  // v key releasing
	 
	 rb.keyPress(KeyEvent.VK_ENTER);   //pressing enter key
	 Thread.sleep(3000);
	 
	 rb.keyRelease(KeyEvent.VK_ENTER);    //releasing enter key
	 
	 System.out.println("file uploaded sucessfully");
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/test/upload/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
