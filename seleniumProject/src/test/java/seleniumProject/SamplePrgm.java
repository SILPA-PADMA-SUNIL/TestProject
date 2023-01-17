package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SamplePrgm {
	public static void main(String [] args)
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sruthi\\eclipse-workspace\\seleniumProject\\src\\main\\resources\\chromedriver.exe");
	   
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php"); 
		driver.manage().window().maximize();
		
		//locator
		WebElement home=driver.findElement(By.className("nav-link"));      //locator-classname
		WebElement inputform=driver.findElement(By.className("nav-link"));
		WebElement inputform1=driver.findElement(By.cssSelector("a.nav-link"));   //cssselector with classname
		WebElement home1=driver.findElement(By.linkText("Home"));                     //linktext
		WebElement alertAndModels=driver.findElement(By.partialLinkText("Modals"));     //partial link text


		
		
		driver.close();
		//driver.quit();

		
	}

}

