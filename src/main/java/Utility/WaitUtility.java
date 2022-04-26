package Utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtility {
	
	WebDriver driver;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//**************************** Wait Utils ***************************************//
	
		public List<WebElement> visibilityOfAllElements(By locator, int timeOut){
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
		
		public void getPageLinksText(By locator, int timeOut){
			visibilityOfAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
		}
		
		public WebElement waitForElementToBeLocated(By locator, int timeOut){
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		
		/*
		 * public WebElement waitForElementToBeVisible(By locator, int timeOut){
		 * WebElement element = getElement(locator); WebDriverWait wait = new
		 * WebDriverWait(driver, timeOut); return
		 * wait.until(ExpectedConditions.visibilityOf(element)); }
		 */
		
		public String waitForPageTitlePresent(String titleValue, int timeOut){
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.titleContains(titleValue));
			return driver.getTitle();
		}
		
		public Alert waitForAlertToBePresent(int timeOut){
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			return wait.until(ExpectedConditions.alertIsPresent());
		}
		
		public boolean waitForUrl(String url, int timeOut){
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			return wait.until(ExpectedConditions.urlContains(url));
		}
		
		public void clickWhenReady(By locator, int timeOut){
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		}
		
		public WebElement waitForElementWithFluentWait(By locator, int timeOut, int pollingTime) {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(timeOut))
						.pollingEvery(Duration.ofSeconds(pollingTime))
						.ignoring(NoSuchElementException.class);

			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}

}
