package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtility {
	
	WebDriver driver;

	public ElementUtility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public boolean checkWebElementPresent(By locator){
		int elementCount = driver.findElements(locator).size();
		System.out.println("total elements count: " + elementCount + " for " + locator);
		
		if(elementCount>0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getElementSize(By locator) {
		return driver.findElements(locator).size();
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doActionsClick(By locator){
		WebElement element = getElement(locator);
		Actions action = new Actions(driver);
		action.click(element).perform();
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetAttribute(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}
	
	public void doAlertAction(String reqAction) {
		if(reqAction.equalsIgnoreCase("accept"))
			driver.switchTo().alert().accept();
		else
			driver.switchTo().alert().dismiss();
	}
	
	public void clickOnRequiredItemsFromList(By locator, String reqItems) {
		List<WebElement> eleList = getElements(locator);
		for(WebElement ele : eleList) {
			if(ele.getText().equalsIgnoreCase(reqItems)) {
				ele.click();
			}
		}
	}
	
	public void selectValueInSelectDropdown(By locator, String value) {
		Select objSelect =new Select(getElement(locator));
		objSelect.selectByVisibleText(value);
	}
}
