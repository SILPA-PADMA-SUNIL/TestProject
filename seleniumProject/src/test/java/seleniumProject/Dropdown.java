package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/select-input.php"); 
		driver.manage().window().maximize();
		WebElement selectColorDropdown=driver.findElement(By.xpath("//select[@id='single-input-field']"));
		selectColorDropdown.click();
		Select select=new Select(selectColorDropdown);
		//select.selectByIndex(2);
		//select.selectByValue("Red");
		select.selectByVisibleText("Green");
		WebElement msg=driver.findElement(By.xpath("//div[@id='message-one']"));
		System.out.println(msg.getText());
		//driver.quit();

	}

}
