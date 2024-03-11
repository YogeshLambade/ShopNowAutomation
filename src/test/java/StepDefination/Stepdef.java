package StepDefination;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageObject.AddToCart;
import PageObject.CheckoutAndOrderpage;
import PageObject.LoginPage;
import PageObject.RegisterPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Stepdef extends BaseClass {


	
	//Background steps for launching browser
	@Before()
	public void setup()
	{
		
		readConfig = new ReadConfig();
		//initialise logger
				log = LogManager.getLogger("Stepdef");
		System.out.println("Setup2-Regression method executed..");
		
		String browser = readConfig.getBrowser();
		
		
		//launch browser
				switch(browser.toLowerCase())
				{
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;

				case "msedge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;

				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				default:
					driver = null;
					break;

				}



		log.info("Setup executed...");
	}

	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {

		
		loginpg = new LoginPage(driver);
		addtocart = new AddToCart (driver);
		chkordpg = new CheckoutAndOrderpage(driver);
		log.info("Browser Launched");
		
	}

	@When("User Open url {string}")
	public void user_open_url(String url) {
		driver.manage().window().maximize();
	   driver.get(url);
	   log.info("url open");
	}

	
	//Steps for Login to shop now website
	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pass) {
	 
		loginpg.enterEmail(email);
		loginpg.enterPassword(pass);
		  log.info("enter email and password");
	}

	@When("Click on Sign In button")
	public void click_on_sign_in_button() {
    loginpg.clickOnSignInButton();
    log.info("Clicked on SignIn Button");
	}

	
	@Then("Home page  Should contain link {string}")
	public void home_page_should_contain_link(String expText) {
	   String actText=loginpg.Shopnowtext();
	   if(actText.equals(expText)) {
		   log.warn("Test passed: Login feature :Page Link text matched.");
		   Assert.assertTrue(true);
	   }else {
		   log.warn("Test Failed: Login feature- page Link text  not matched.");
		   Assert.assertTrue(false);
	   }
	   
	}

	@AfterStep
	public void addScreenshot(Scenario scenario){

		//validate if scenario has failed
		
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); 
		}
		
	}

	///Steps for Verify Home Page Title
	
	@When("Get the home page title as {string}")
	public void get_the_home_page_title_as(String exptitle) {
	    String acttitle=driver.getTitle();
	    if(acttitle.equals(exptitle)) {
			   log.warn("Test passed: HomeAddToCart feature :Page Title matched.");
			   Assert.assertTrue(true);
		   }else {
			   log.warn("Test passed: HomeAddToCart feature :Page Title not matched.");
			   Assert.assertTrue(false);
		   }
	}
	
	
	///Steps for Add To Cart Method
	
	@When("Click on Search btn")
	public void click_on_search_btn() {
	   addtocart.clickOnSearchButton();
	   try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   log.info("Clicked on search btn");
	}

	@When("enter text as {string} and clicked")
	public void enter_text_as_and_clicked(String item) {
	   addtocart.searchitem(item);
	   try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   log.info("Enter Laptop text and clicked");
	}

	@Then("Seach Product name appear as {string}")
	public void seach_product_name_appear_as(String expPName) {
	   String actPName=addtocart.verifypdname();
	   try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   if(actPName.equals(expPName)) {
		   log.warn("Product name matched");
		   Assert.assertTrue(true);
	   }else {
		   log.warn("Product name matched not matched.");
		   Assert.assertTrue(false);
	   }
	}

	@Then("Again click on item")
	public void again_click_on_item() throws Exception {
	 addtocart.clickOnProductName();
	 log.info("Clicked on Product");
	Thread.sleep(1000);
	}


	@Then("Again click on Add to cart button")
	public void again_click_on_add_to_cart_button() {
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 addtocart.clickOnAddToCartBtn();  
	 log.info("Add to cart btn clicked");
	
	 
	}
	
	@Then("popup appered as {string}")
	public void popup_appered_as(String expalert) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String actalert=addtocart.verifyalertadditem();
		 System.out.println(actalert);
		 if(actalert.equals(expalert)) {
			   log.warn("Item added to cart alert match");
			   Assert.assertTrue(true,"alert match");
		   }else {
			   log.warn("Item added to cart alert match not match");
			   Assert.assertTrue(false,"alert not matched");
		   }
	}
	
	@Then("Click on view my cart btn")
	public void click_on_view_my_cart_btn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    addtocart.clickOnviewmycartbtn();
	}
  
	@Then("Checkout page appear with text {string}")
	public void checkout_page_appear_with_text(String expchekoutttl) {
		String actcheckoutttl=addtocart.verifycheckoutpg();
		System.out.println(actcheckoutttl);
		 if(actcheckoutttl.equals(expchekoutttl)) {
			   log.warn("Checkout page name matched");
			   Assert.assertTrue(true,"checkout page matched");
		   }else {
			   log.warn("Checkout page name not matched");
			   Assert.assertTrue(false,"checkout page not match");
		   }
	}
	
   //Steps for Proceed to checkout scenario
	
	@Then("click on shop now btn")
	public void click_on_shop_now_btn() {
	    chkordpg.clkonshpnowbtn();
	}
	
	@When("click on Cart button")
	public void click_on_cart_button() {
	   chkordpg.clkoncartbtn();
	}



	@Then("click on checkout button")
	public void click_on_checkout_button() {
	    chkordpg.clkoncheckoutbtn();
	}

	@Then("complete order page appear with title {string}")
	public void complete_order_page_appear_with_title(String exptitle) {
		 String acttitle=driver.getTitle();
		    if(acttitle.equals(exptitle)) {
				   log.warn("Test passed: Checkout :Page Title matched.");
				   Assert.assertTrue(true);
			   }else {
				   log.warn("Test failed: Checkout :Page Title not matched.");
				   Assert.assertTrue(false);
			   }
	}
	
	//steps for complete the order
	
	@Then("click on checkout button of view my cart")
	public void click_on_checkout_button_of_view_my_cart() {
	    chkordpg.clkoncheckoutbtnvwmycart();
	}
	
	
	@Then("Enter user detail")
	public void enter_user_detail() {
		chkordpg.enteremail("sqkmcrb7ni@lettershield.com");
		chkordpg.enterfname("John");
		chkordpg.enterlname("Doe");
		chkordpg.enterhouseno("221");
		chkordpg.enteraddress("Vijay Nagar Colony");
		chkordpg.entercity("Indore");
		chkordpg.enterpincode("452010");
		chkordpg.enterphoneno("9921684512");
		chkordpg.enterstate("Madhya Pradesh");
		
	}

	
}
