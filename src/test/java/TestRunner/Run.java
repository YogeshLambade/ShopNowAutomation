package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {".//Features/LoginFeature.feature",".//Features/HomeAddToCart.feature",".//Features/Proceedcheckoutordercomplete.feature"},
		glue="StepDefination",
		dryRun = false,
		monochrome = true,
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		
				
		)

public class Run extends AbstractTestNGCucumberTests {

}
