package applicationHooks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

import Factory.DriverFactory;
import Utility.Browser;
import Utility.BrowserUtility;
import Utility.ConfigReader;
import Utility.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;


public class ApplicationHooks implements Constants {
	
	private DriverFactory driverFactory;
	private RemoteWebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	BrowserUtility browserUtil;
	Logger log = Logger.getLogger(ApplicationHooks.class);
	
	@Before(order = 0)
	public void getProperty(){
		System.out.println("Application Hook GetProperty Method");
		configReader = new ConfigReader();
		prop = configReader.init_prop(WEB_CONFIG.CONFIG_FILEPATH);
	}
	
	@Before(order = 1)
	public void lunchBrowser() throws MalformedURLException{
		log.info("Driver Intialization for required Browser");

		System.out.println("Application Hook lunchBrowser Method");
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			log.error("Capturing Screenshot for Failed Test cases.");
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			//scenario.embed(sourcePath, "image/png", screenshotName);
			//scenario.embed(sourcePath, "image/png");
		}
	}
}
