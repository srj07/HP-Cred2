package allureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import login.AddProvider;
import login.LoginPage;


@Listeners(allureReports.AllureListener.class)				

public class ProviderRegister {
	public WebDriver driver;
	public WebDriverWait wait;


	@BeforeClass
	public void setUp() {
		// BaseClass bs= new BaseClass();
		// driver = bs.initialize_driver();
		System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://iris/Hospital_Credential_V2/login.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 2, description = "Login Access")
	@Description("Login  Credentials........")
	@Epic("EP001-Login Credentials")
	@Feature("Feature1: Login")
	@Story("Story:Valid login")
	@Step("Verify login")
	public void loginTest() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.loginTest();

	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, dependsOnMethods = { "loginTest" }, description = "PROVIDER")
	@Description("Add new Provider")
	@Epic("EP002-Provider Registration")
	@Feature("Feature1: Provider")
	@Story("Story: Provider Form ")
	@Step("Administrator->Provider")
	public void ProviderClick() throws InterruptedException {

		AddProvider ap = new AddProvider(driver, wait);
		ap.addProvider();
		
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, dependsOnMethods = { "ProviderClick" }, description = "Form-Mandatory Fields")
	@Description("Add new Provider")
	@Epic("EP002-Provider Registration")
	@Feature("Feature2: Form Validation")
	@Story("Story: Provider Form ")
	@Step("Provider ")
	public void ProviderMandatoryFields() throws InterruptedException {

		AddProvider ap = new AddProvider(driver, wait);
		ap.submitProvider();
		String txt = driver.findElement(By.xpath("//span[@id='errorSpan']")).getText();
				if(txt.contains("Please fill all required fields")) {
					System.out.println("Please fill up Provider Form...");
				}
	}


	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, dependsOnMethods = { "ProviderMandatoryFields" }, description = "Provider Form")
	@Description("Add new Provider")
	@Epic("EP002-Provider Registration")
	@Feature("Feature3:Add new Provider")
	@Story("Story: Enter Provider Details")
	@Step("Submit Form")
	public void ProviderForm() throws InterruptedException  {

		AddProvider ap = new AddProvider(driver, wait);
		ap.providerDetails();
		ap.HomeAddress();
		ap.previousHome();
		ap.submitProvider();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
