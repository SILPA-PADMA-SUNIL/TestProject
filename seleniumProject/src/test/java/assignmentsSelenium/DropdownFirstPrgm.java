package assignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownFirstPrgm {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/"); 
		driver.manage().window().maximize();
		WebElement olderNewsletterDropdown=driver.findElement(By.xpath("//select[@id='drop1']"));
		olderNewsletterDropdown.click();
		Select select=new Select(olderNewsletterDropdown);
		//select.selectByVisibleText("doc 2");
		//select.selectByValue("ghi");
		select.selectByIndex(2);
	}

}
