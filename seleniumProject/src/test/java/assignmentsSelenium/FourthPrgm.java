package assignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FourthPrgm {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php"); 
		WebElement home=driver.findElement(By.xpath("//a[text()='Home']"));
		System.out.println("tag name: " +home.getTagName());
		System.out.println("attribute value = " +home.getAttribute("class"));
		System.out.println("css value = " +home.getCssValue("font-size"));
		
		WebElement logo=driver.findElement(By.xpath("(//img[@alt='logo'])[1]"));
		System.out.println("logo size = " +logo.getSize());

	}

}
