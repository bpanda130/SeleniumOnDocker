package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utility.ElementUtility;

public class WelcomePage {
	
private RemoteWebDriver driver;
	
	ElementUtility elementutility;
	
	private By input_name = By.xpath("//input[@name='name']");
	private By input_button_populate = By.xpath("//input[@value='Populate']");
	private By input_remote = By.xpath("//input[@name='remote']");
	private By input_re_using = By.xpath("//input[@name='re-using']");
	
	private By input_background = By.xpath("//input[@name='background']");
	private By input_continuous_integration_embedding = By.xpath("//input[@name='CI']");
	private By input_analysis = By.xpath("//input[@name='analysis']");
	private By input_radio_windows = By.xpath("//input[@value='Windows']");
	private By input_radio_macos = By.xpath("//input[@value='MacOS']");
	private By input_radio_linux = By.xpath("//input[@value='Linux']");
	
	private By input_tried_test_cafe = By.xpath("//input[@name='tried-test-cafe']");
	private By button_submit = By.xpath("//button[text()='Submit']");
	private By textarea_comments = By.xpath("//textarea[@name='comments']");
	
	private By osList = By.xpath("//fieldset[legend[text()='What is your primary Operating System:']]//label");
	private By preferredInterface = By.id("preferred-interface");
	
	public WelcomePage(RemoteWebDriver driver){
		this.driver = driver;
		elementutility = new ElementUtility(driver);
	}
	
	public void clickOnPopulateBtn() {
		elementutility.doClick(input_button_populate);
	}
	
	public void clickOKOnPopup() {
		elementutility.doAlertAction("accept");
	}
	
	public String validatePopulatedName() {
		return elementutility.doGetAttribute(input_name,".value");
	}
	
	public void selectDeviceFeatures(List<String> deviceFeatures) {
		for(String feature : deviceFeatures) {
			if(feature.equalsIgnoreCase("Remote Access"))
				elementutility.doClick(input_remote);
			
			else if(feature.equalsIgnoreCase("Re-using"))
				elementutility.doClick(input_re_using);
			
			else if(feature.equalsIgnoreCase("Background"))
				elementutility.doClick(input_background);
			
			else if(feature.equalsIgnoreCase("CI"))
				elementutility.doClick(input_continuous_integration_embedding);
			
			else if(feature.equalsIgnoreCase("Analysis"))
				elementutility.doClick(input_analysis);
		}
	}
	
	public void selectReqOS(String osName) {
		elementutility.clickOnRequiredItemsFromList(osList, osName);
	}
	
	public void selectReqInterface(String interfaceName) {
		elementutility.selectValueInSelectDropdown(preferredInterface, interfaceName);
	}

}
