package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	
	WebDriver ldriver;
	
	public RegisterPage(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(id = "RegisterForm-FirstName")
	WebElement FirstName;
	
	@FindBy(id="RegisterForm-LastName")
	WebElement LastName;
	
	@FindBy(id = "RegisterForm-email")
	WebElement email;
	
	@FindBy(id="RegisterForm-password")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement createBtn;
	
	public void enterfirstName(String firstName)
	{
		
		FirstName.sendKeys(firstName);
	}
	
	public void enterlastName(String lastName)
	{
		
		LastName.sendKeys(lastName);
	}
	
	public void enterEmail(String emailAdd)
	{
		
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd)
	{
		
		password.sendKeys(pwd);
	}
	
	public void clickOnCreateButton()
	{
		createBtn.click();
	}
	
}
