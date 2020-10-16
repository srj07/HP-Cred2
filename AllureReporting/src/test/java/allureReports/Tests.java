package allureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
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
import login.ClinicLaunch;
import login.LoginPage;


@Listeners(allureReports.AllureListener.class)				
public class Tests {

	public WebDriver driver;

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

	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1, description = "Verify Logo presence on Home Page")
	@Description("Verify Logo presence on Home Page........")
	@Epic("EP001- Logo")
	@Feature("Feature1: Logo")
	@Story("Story:Logo Presence")
	@Step("Verify logo Presence")
	public void TestLogin() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.logoPresence();
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 2, description = "Verify login")
	@Description("Verify login with Valid Credentials........")
	@Epic("EP002-Login Credentials")
	@Feature("Feature1: Login")
	@Story("Story:Valid login")
	@Step("Verify login")
	public void loginTest() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.loginTest();

	}
	
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, dependsOnMethods = { "loginTest" }, description = "Clinic-Screen")
	@Description("Verify Whether Alert is present")
	@Epic("EP003-Clinic Tabs ")
	@Feature("Feature1: Clinic-Screen")
	@Story("Story:Clinic-alert ")
	@Step("Verify Alert and save")
	public void clinicAlertPresent() throws InterruptedException {

		ClinicLaunch cc = new ClinicLaunch(driver);
		cc.admModule();
		cc.msgPresent();
		cc.CheckActive();
		
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, dependsOnMethods = { "clinicAlertPresent" }, description = "Clinic-Hospital")
	@Description("Verify Whether Payer tab is active")
	@Epic("EP003-Clinic ")
	@Feature("Feature2: Clinic-Screen")
	@Story("Story:Clinic-Hospital Screen ")
	@Step("Verify Hospital")
	public void clinicPage() throws InterruptedException {

		ClinicLaunch cc = new ClinicLaunch(driver);
		cc.HospitalPresent();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4, dependsOnMethods = { "clinicPage" }, description = "Clinic-payer")
	@Description("Verify Whether Payer tab is active")
	@Epic("EP003-Clinic ")
	@Feature("Feature3: Clinic-Screen")
	@Story("Story:Clinic-Payer ")
	@Step("Verify Payer Tab")
	public void activeHospitalTab() {
		ClinicLaunch cc = new ClinicLaunch(driver);
		cc.payerPresent();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 4, dependsOnMethods = { "clinicPage" }, description = "Clinic-provider")
	@Description("Verify Whether Provider tab is active")
	@Epic("EP003-Clinic ")
	@Feature("Feature2: Clinic-Screen")
	@Story("Story:Clinic-Provider ")
	@Step("Verify Provider Tab")
	public void activeProviderTab() {
		ClinicLaunch cc = new ClinicLaunch(driver);
		cc.providerPresent();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
