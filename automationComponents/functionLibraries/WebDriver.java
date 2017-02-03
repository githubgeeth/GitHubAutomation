package functionLibraries;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriver {
public static ChromeDriver driver;
	
	public void initializeDriver(){	
		
	File chromeDriver = new File(System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--start-maximized", "--disable-extensions");
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	driver = new ChromeDriver(capabilities);
	
		/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		File IEDriver = new File("C:/Users/cranganath003/IEDriverServer.exe");	
		System.setProperty("webdriver.ie.driver",IEDriver.getAbsolutePath()); 
		driver = new InternetExplorerDriver(capabilities); */
		
	/*DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
	capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE); 
	driver = new FirefoxDriver(capabilities);*/
}
}