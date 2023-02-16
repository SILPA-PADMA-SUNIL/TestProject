package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	WebDriver driver;

	@FindBy(name="username")
	WebElement userName;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInBtn;
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement title7rmartSuoerMarket;
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	WebElement adminName;
	
	@FindBy(xpath="//h5[contains(text(),' Alert!')]")
	WebElement alertMsg;
	
	@FindBy(name="remember_me")
	WebElement rememberCheckbox;
	
	public LoginPageClass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String uname)
	{
		userName.sendKeys(uname);
	}
	
	public void enterPassword(String pswd)
	{
		password.sendKeys(pswd);
	}
	
	public void clickOnSignInBtn()
	{
		signInBtn.click();
	}
	
	public Boolean is7rmartSuperMarketDisplayed()
	{
		return title7rmartSuoerMarket.isDisplayed();
	}
	
	public String getTextOf7rmartSuoerMarket()
	{
		return title7rmartSuoerMarket.getText();
	}
	
	public Boolean isAdminNameDisplayed()
	{
		return adminName.isDisplayed();
	}
	
	public Boolean isAlertMsgDisplayed()
	{
		return alertMsg.isDisplayed();
	}
	
	public Boolean isRememberMeCheckboxSelected()
	{
		return rememberCheckbox.isSelected();
	}
}


