package assignmentsSelenium;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AssignmentPrgm3 {
	WebDriver driver;
	Select select;
	@Test(priority = 1)
	public void verifySuccessfulLogin() {
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton=driver.findElement(By.xpath("//button[text()='Login']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		WebElement carolThomas=driver.findElement(By.className("dropdown-toggle"));
		String expectedText="CAROL THOMAS";
		String actualText=carolThomas.getText();
		Assert.assertEquals(actualText,expectedText);

	}
	@Test(priority = 2)
	public void verifyUnsuccessfulLogin() {
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("12345");
		WebElement loginButton=driver.findElement(By.xpath("//button[text()='Login']"));
		loginButton.click();
		WebElement msgForIncorrectLogin=driver.findElement(By.xpath("//p[contains(text(),'Incorrect username ')]"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Incorrect username ')]")));
		wait.until(ExpectedConditions.textToBePresentInElement(msgForIncorrectLogin, "Incorrect username or password."));
		Boolean actual=msgForIncorrectLogin.isDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority = 3)
	public void verifyTheDashboardPageIsDisplayedAfterLogin() {
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton=driver.findElement(By.xpath("//button[text()='Login']"));
		loginButton.click();
		WebElement welcomeText=driver.findElement(By.xpath("//p[text()='Welcome to Payroll Application']"));
		Boolean actual=welcomeText.isDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority = 4)
	public void verifyTheCreationOfNewClient()
	{
		WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
		userName.sendKeys("carol");
		WebElement password=driver.findElement(By.xpath("//input[@id='loginform-password']"));
		password.sendKeys("1q2w3e4r");
		WebElement loginButton=driver.findElement(By.xpath("//button[text()='Login']"));
		loginButton.click();
		WebElement clients=driver.findElement(By.xpath("//a[text()='Clients']"));
		clients.click();
		WebElement createClient=driver.findElement(By.xpath("//a[text()='Create Client']"));
		createClient.click();
		WebElement branchDropdown=driver.findElement(By.name("Client[branch_id]"));
		branchDropdown.click();
		select=new Select(branchDropdown);
		select.selectByValue("1");
		WebElement divisionDropdown=driver.findElement(By.name("Client[division_id]"));
		divisionDropdown.click();
		select=new Select(divisionDropdown);
		select.selectByVisibleText("NewAlpha");
		WebElement clientName=driver.findElement(By.name("Client[client_name]"));
		clientName.sendKeys("zera");
		WebElement clientAddress=driver.findElement(By.name("Client[client_address]"));
		clientAddress.sendKeys("Flat No:123");
		WebElement postCode=driver.findElement(By.name("Client[postcode]"));
		postCode.sendKeys("695021");
		WebElement invoiceContact=driver.findElement(By.name("Client[invoice_contact]"));
		invoiceContact.sendKeys("luca");
		WebElement phone=driver.findElement(By.name("Client[phone]"));
		phone.sendKeys("9876098900");
		WebElement email=driver.findElement(By.name("Client[email]"));
		email.sendKeys("zera2345@gmail.com");
		WebElement companyReg=driver.findElement(By.name("Client[company_reg]"));
		companyReg.sendKeys("newyork healthcare");
		WebElement invoiceOrder=driver.findElement(By.xpath("//select[@name='Client[invoice_order]']"));
		invoiceOrder.click();
		select=new Select(invoiceOrder);
		select.selectByIndex(2);
		WebElement invoiceDeliveryMthod=driver.findElement(By.name("Client[invoice_delivery_method]"));
		invoiceDeliveryMthod.click();
		select=new Select(invoiceDeliveryMthod);
		select.selectByIndex(2);
		WebElement masterDocument=driver.findElement(By.name("Client[master_document]"));
		masterDocument.click();
		select=new Select(masterDocument);
		select.selectByValue("PDF");
		WebElement settlementDay=driver.findElement(By.name("Client[settilement_days]"));
		settlementDay.sendKeys("50");
		WebElement vatRate=driver.findElement(By.name("Client[vat_rate]"));
		vatRate.click();
		select=new Select(vatRate);
		select.selectByVisibleText("VAT 15.00%");
		WebElement saveButton=driver.findElement(By.xpath("//button[text()='Save']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", saveButton);
		saveButton.click();
		WebElement newClientNamezera=driver.findElement(By.xpath("//table[@id='w0']//tr[3]"));
		Boolean actual=newClientNamezera.isDisplayed();
		Assert.assertTrue(actual);



	}
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://qabible.in/payrollapp/site/login "); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
