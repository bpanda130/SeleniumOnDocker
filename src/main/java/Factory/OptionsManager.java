package Factory;

import java.util.Properties;

import Utility.Constants;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager implements Constants {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	/*public OptionsManager(Properties prop) {
		this.prop = prop;
	}*/
	
	public static ChromeOptions getChromeOptions() {
/*		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
		return co;*/

		ChromeOptions options = new ChromeOptions();
		options.addArguments(WEB_CONFIG.WINDOW_START_STATE);
		options.addArguments(CHROME_CONFIG.SANDBOX_FLAG);
		//options.addArguments(WEB_CONFIG.EXECUTION_MODE);
		options.addArguments(CHROME_CONFIG.CERTIFICATE_ERROR);
		options.addArguments(CHROME_CONFIG.POP_UP_DISABLE);
		options.addArguments(CHROME_CONFIG.WINDOW_SIZE);
		options.addArguments(CHROME_CONFIG.NOTIFICATION_DISABLE);
		return options;

	}
	
	public static FirefoxOptions getFirefoxOptions() {
/*		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) fo.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) fo.addArguments("--incognito");
		return fo;*/

		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(FIREFOX_CONFIG.ACCEPT_FLAG);
		options.setHeadless(FIREFOX_CONFIG.ACCEPT_FLAG);
		options.addArguments(WEB_CONFIG.WINDOW_START_STATE);
		profile.setAssumeUntrustedCertificateIssuer(FIREFOX_CONFIG.DECLINE_FLAG);
		options.addArguments(FIREFOX_CONFIG.WINDOW_WIDTH);
		options.addArguments(FIREFOX_CONFIG.WINDOW_HEIGHT);
		profile.setPreference(FIREFOX_CONFIG.NETWORK_PROXY, 0);
		options.setCapability(FirefoxDriver.PROFILE, profile);
		return options;
	}

}
