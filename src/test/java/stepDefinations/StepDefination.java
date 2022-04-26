package stepDefinations;

import java.util.Arrays;
import java.util.List;

import Factory.DriverFactory;

import io.cucumber.java.en.*;
import pages.WelcomePage;

public class StepDefination {
	
	WelcomePage welcomepage = new WelcomePage(DriverFactory.getDriver());
	
	@Given("Launch {string}")
	public void launch_url(String url) {
		DriverFactory.getDriver().get(url);
	}

	@Then("verify the Welcome page appears")
	public void verify_the_welcome_page_appears() {
	    System.out.println("Test");
	}
	
	@When("Click on Populate button")
	public void click_On_populate() {
	    welcomepage.clickOnPopulateBtn();
	}
	
	@When("click on OK button on Confirmation pop up")
	public void click_OK_On_Popup() {
	    welcomepage.clickOKOnPopup();
	}
	
	@Then("Verify default name {string} appeared on the page")
	public void verify_default_name(String defaultName) {
	    System.out.println(welcomepage.validatePopulatedName());
	}
	
	@When("select {string} option on the page")
	public void select_option_on_the_page(String features) {
	    String[] featureArr = features.split(",");
	    List<String> featureList = Arrays.asList(featureArr);
	    welcomepage.selectDeviceFeatures(featureList);
	    
	}
	
	@When("select os as {string}")
	public void select_os_as(String os) {
		welcomepage.selectReqOS(os);
	}
	
	@When("select Testcafe interface as {string}")
	public void select_interface_as(String os) {
		welcomepage.selectReqOS(os);
	}

}
