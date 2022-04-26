package Factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import Utility.Browser;
import Utility.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Factory.OptionsManager;
import Utility.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory{

	public WebDriver driver;
//	public static String highlight = "true";
	private static Browser browserName;
	private OptionsManager optionsManager;

	public static ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<RemoteWebDriver>();
	public CapabilityFactory capabilityFactory = new CapabilityFactory();

	/**
	 * This method is used to initialize the threadlocal driver on the basis of
	 * given browser
	 * 
	 * @param broserName
	 * @return this will return tlDriver
	 * @throws MalformedURLException 
	 */
	public RemoteWebDriver init_driver(String broserName) throws MalformedURLException {

		System.out.println("Inside Chrome");
		//ChromeOptions options = new ChromeOptions();
		remoteDriver.set(new RemoteWebDriver(new URL(Constants.WEB_CONFIG.REMOTE_CHROME_URL), capabilityFactory.getCapabilities(broserName)));

		//remoteDriver.set(new RemoteWebDriver(new URL(Constants.WEB_CONFIG.NODE_URL), capabilityFactory.getCapabilities(broserName)));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return getDriver();
	}

	/**
	 * this is used to get the driver with threadLocal
	 * @return
	 */
	public static synchronized RemoteWebDriver getDriver() {
		return remoteDriver.get();
	}
}
