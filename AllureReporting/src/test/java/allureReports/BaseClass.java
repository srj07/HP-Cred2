package allureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseClass {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver initialize_driver() {
		System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
}
