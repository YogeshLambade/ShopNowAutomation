package StepDefination;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

import org.apache.logging.log4j.*;

import PageObject.AddToCart;
import PageObject.CheckoutAndOrderpage;
import PageObject.LoginPage;
import Utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginpg;
	public static Logger log;
	public ReadConfig readConfig;
	public AddToCart addtocart;
	public CheckoutAndOrderpage chkordpg;
}
