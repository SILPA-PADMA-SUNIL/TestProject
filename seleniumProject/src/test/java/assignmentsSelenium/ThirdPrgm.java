package assignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThirdPrgm {

	public static void main(String[] args) {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://selenium.obsqurazone.com/index.php"); 
			driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
			WebElement radioButtonDemo=driver.findElement(By.xpath("//a[contains(text(),'Buttons')]"));
			radioButtonDemo.click();
			WebElement femaleButton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
			femaleButton.click();
			WebElement showSelectedValue=driver.findElement(By.xpath("//button[@id='button-one']"));
			showSelectedValue.click();
			System.out.println("female buttton selected : " +femaleButton.isSelected());
			WebElement message=driver.findElement(By.xpath("//div[@id='message-one']"));
			System.out.println("message : " +message.getText());

	}

}
