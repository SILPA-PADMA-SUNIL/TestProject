package assignmentsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondPrgm {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php"); 
		System.out.println("title= " +driver.getTitle());
		System.out.println("url = " +driver.getCurrentUrl());
		driver.navigate().to("https://selenium.obsqurazone.com/simple-form-demo.php");
		WebElement checkboxDemo=driver.findElement(By.xpath("//a[text()='Checkbox Demo']")) ;
		checkboxDemo.click();
		WebElement checkboxOne=driver.findElement(By.xpath("//input[@id='check-box-one']"));
		checkboxOne.click();
		System.out.println("check box one : " +checkboxOne.isSelected());
		WebElement checkboxThree=driver.findElement(By.xpath("//input[@id='check-box-three']"));
		checkboxThree.click();
		System.out.println("chech box three :" +checkboxThree.isSelected());

	}

}
