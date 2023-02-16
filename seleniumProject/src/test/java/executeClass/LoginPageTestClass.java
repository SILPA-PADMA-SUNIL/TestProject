package executeClass;

import org.testng.annotations.Test;

import elementRepository.LoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import testngSample.DataProviderForLogin;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTestClass {
	WebDriver driver;
	LoginPageClass lp;
	
  @Test
  public void verifyTheLoginPageIsDisplayedByLoadingUrl() {
	  lp=new LoginPageClass(driver);
	  
	  //Boolean actual=lp.is7rmartSuperMarketDisplayed();
	  //Assert.assertTrue(actual);
	  
	  String actual=lp.getTextOf7rmartSuoerMarket();
	  String expected="7rmart supermarket";
	  Assert.assertEquals(actual, expected);
  }
  @Test
  public void verifySuccessfulLogin()
  {
	  lp=new LoginPageClass(driver);
	  lp.enterUserName("admin");
	  lp.enterPassword("admin");
	  lp.clickOnSignInBtn();
	  
	  Boolean actual=lp.isAdminNameDisplayed();
	  Assert.assertTrue(actual);
  }
  
  
  @Test(dataProvider="unSuccessfulLogin",dataProviderClass=DataProviderForLogin.class)
  public void verifyUnSuccessfulLogin(String uname, String pswd)
  {
	  lp=new LoginPageClass(driver);
	  lp.enterUserName(uname);
	  lp.enterPassword(pswd);
	  lp.clickOnSignInBtn();
	  
	  Boolean actual=lp.isAlertMsgDisplayed();
	  Assert.assertTrue(actual);
  }
  
  @Test
  public void verifyRememberMeCheckboxIsSelectedByDefault()
  {
	  lp=new LoginPageClass(driver);
	 Boolean actual= lp.isRememberMeCheckboxSelected();
	 Assert.assertFalse(actual);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://groceryapp.uniqassosiates.com/admin/login"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
