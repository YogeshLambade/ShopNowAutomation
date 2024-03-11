package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver ldriver;
	
	public LoginPage(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(id = "CustomerEmail")
	WebElement email;
	
	@FindBy(id="CustomerPassword")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(linkText="Shop Now")
	WebElement shopnow;
	
	
	public void enterEmail(String emailAdd)
	{
		
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd)
	{
		
		password.sendKeys(pwd);
	}
	
	public void clickOnSignInButton()
	{
		signInBtn.click();
	}
	
	public String Shopnowtext() {
		return shopnow.getText();
	}
}
