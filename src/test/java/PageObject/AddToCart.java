package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {


WebDriver ldriver;
	
	public AddToCart(WebDriver rDriver)
	{
		ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(xpath = "//summary[@aria-label='Search']//span//*[name()='svg']")
	WebElement searchbtn;
	
	@FindBy(xpath = "//input[@id='Search-In-Modal']")
	WebElement searchinp;
	
	@FindBy(xpath = "//a[@id='CardLink--8050413175061']")
	WebElement productname;
	
	
	@FindBy(xpath = "//button[@name='add']")
	WebElement adtocrtbtn;
	
	@FindBy(xpath = "//a[@class='cart-item__name h4 break']")
	WebElement checkoutpgtitle;
	
	@FindBy(xpath = "//h2[@class=\"cart-notification__heading caption-large text-body\"]")
	WebElement alertitem;
	
	@FindBy(id="cart-notification-button")
	WebElement vwmycrt;
	

	
	
	public void clickOnSearchButton()
	{
		searchbtn.click();
	}
	
	public void searchitem(String itemname) {
		searchinp.sendKeys(itemname);
		searchinp.sendKeys(Keys.ENTER);
	}
	
	public String verifypdname() {
		return productname.getText();
	}
	
	public void clickOnProductName()
	{
		productname.click();
	}
	

	
	public void clickOnAddToCartBtn()
	{
		adtocrtbtn.click();
	}
	
	public String verifycheckoutpg() {
		return checkoutpgtitle.getText();
	}
	
	public String verifyalertadditem() {
		return alertitem.getText();
	}
	public void clickOnviewmycartbtn()
	{
		vwmycrt.click();
	}
}
