package assignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownSecondPrgm {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://omayo.blogspot.com/"); 
		driver.manage().window().maximize();
		WebElement multiSelectionBoxDropdown=driver.findElement(By.xpath("//select[@id='multiselect1']"));
		Select select=new Select(multiSelectionBoxDropdown);
		select.selectByIndex(1);
		select.selectByValue("Hyundaix");
		select.selectByVisibleText("Audi");
		select.deselectAll();

	}

}
