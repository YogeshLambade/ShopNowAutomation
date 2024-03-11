package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutAndOrderpage {


WebDriver ldriver;
	
	public CheckoutAndOrderpage(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(id = "cart-icon-bubble")
	WebElement carticon;
	
	@FindBy(xpath="//a[@class=\"header__heading-link link link--text focus-inset\"]")
	WebElement shopbowbtn;
	
	@FindBy(id = "checkout")
	WebElement chkoutbtn;
	
	@FindBy(xpath="//button[@class=\"button button--primary button--full-width\"]")
	WebElement chkoutbtnvwmycrt;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(xpath="//input[@id=\"TextField0\"]")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id=\"TextField1\"]")
	WebElement lastname;
	 
	@FindBy(xpath="//input[@id=\"TextField2\"]")
	WebElement houseno;
	
	@FindBy(xpath="//input[@id=\"TextField3\"]")
	WebElement address;
	
	@FindBy(xpath="//input[@id=\"TextField4\"]")
	WebElement city;
	
	@FindBy(xpath="//input[@id=\"TextField5\"]")
	WebElement pincode;
	
	@FindBy(xpath="//input[@id=\"TextField6\"]")
	WebElement phoneno;
	
	@FindBy(xpath="//select[@id=\"Select1\"]")
	WebElement state;
	
	public void clkoncartbtn() {
		carticon.click();
	}
	
	public void clkonshpnowbtn() {
		shopbowbtn.click();
	}
	
	public void clkoncheckoutbtn() {
		chkoutbtn.click();
	}
	
	public void clkoncheckoutbtnvwmycart() {
		chkoutbtnvwmycrt.click();
	}
	
	public void enteremail(String uemail) {
		email.sendKeys(uemail);
	}
	
	public void enterfname(String ufname) {
		firstname.sendKeys(ufname);
	}
	
	public void enterlname(String ulname) {
		lastname.sendKeys(ulname);
	}
	public void enterhouseno(String hno) {
		houseno.sendKeys(hno);
	}
	
	public void enteraddress(String uaddress) {
		address.sendKeys(uaddress);
	}
	
	public void entercity(String ucity) {
		city.sendKeys(ucity);
	}
	
	public void enterpincode(String upin) {
		pincode.sendKeys(upin);
	}
	
	public void enterphoneno(String uphone) {
		phoneno.sendKeys(uphone);
	}
	
	public void enterstate(String ustate)
	{
		Select drp=new Select(state);
		drp.selectByVisibleText(ustate);
	}

}
