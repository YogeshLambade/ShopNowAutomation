package StepDefination;

import io.cucumber.java.en.Then;

public class CloseStep extends BaseClass{

	@Then("Close The browser")
	public void close_the_browser() {
	    driver.quit();
	    log.info("browser closed");
	}
}
