package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementCommand {

	public static void main(String[] args) {
       
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php"); 
		driver.manage().window().maximize();
		WebElement inputForm=driver.findElement(By.xpath("//a[contains(text(),'Input Form')]"));
		System.out.println(inputForm.getCssValue("font-family"));
		inputForm.click();
		
		WebElement messageTextBox=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		messageTextBox.sendKeys("hi");
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		showMessageButton.click();
		
		messageTextBox.clear();
		
		WebElement YourMessageText =driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(YourMessageText.getText());
		System.out.println(YourMessageText.getAttribute("class"));
		WebElement checkBoxDemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']"));
		checkBoxDemo.click();
		WebElement checkBox=driver.findElement(By.xpath("(//input[@id='gridCheck'])[1]"));
		//checkBox.click();
		System.out.println(checkBox.isSelected());
		//driver.close();
		
	}

}
