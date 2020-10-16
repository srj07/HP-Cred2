package login;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProvider {
	WebDriver driver;
	WebDriverWait wait;
	DesiredCapabilities dc;

	@FindBy(xpath = "//span[contains(text(),'Administration')]")
	WebElement adm;
	@FindBy(xpath = "//a[@id='administrationProvidersNav']")
	WebElement prov;
	@FindBy(xpath = "//a[@id='newProvider']")
	WebElement newprov;

	@FindBy(xpath = "//div[@class='profile-info-value div-padding-left']//input[@id='clinics']")
	WebElement clinic_prov;

	@FindBy(xpath = "//a[contains(text(),'Ronak J Patel MD PLLC')]")
	WebElement ln;

	@FindBy(xpath = "//span[@id='firstname']")
	WebElement txt;

	@FindBy(css = "#firstname_editable")
	WebElement first;

	@FindBy(xpath = "//span[@id='lastname']")
	WebElement txt2;

	@FindBy(how = How.ID, using = "lastname_editable")
	WebElement last;

	@FindBy(xpath = "//span[@id='addressline1']")
	WebElement addrs;

	@FindBy(xpath = "//input[@id='addressline1_editable']")
	WebElement txt3;

	@FindBy(xpath = "//span[@id='phone']")
	WebElement ph;

	@FindBy(xpath = "//input[@id='phone_editable']")
	WebElement txt4;

	@FindBy(xpath = "//span[@id='email']")
	WebElement mail;

	@FindBy(xpath = "//input[@id='email_editable']")
	WebElement txt5;

	@FindBy(xpath = "//span[@id='preAddressline1']")
	WebElement pr_add;

	@FindBy(xpath = "//input[@id='addressline1_editable']")
	WebElement txt6;

	@FindBy(xpath = "//span[@id='prePhone']")
	WebElement pr_ph;

	@FindBy(xpath = "//input[@id='phone_editable']")
	WebElement txt7;

	@FindBy(xpath = "//span[@id='preEmail']")
	WebElement prv_mail;

	@FindBy(css = "#saveProviderInfo")
	WebElement sub;

	@FindBy(css = "#email_editable")
	WebElement mail_txt;

	@FindBy(xpath = "//button[@class='btn btn-primary']//parent::div")
	WebElement alert;

	public AddProvider(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);

	}

	public void addProvider() throws InterruptedException {
		adm.click();
		prov.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		newprov.click();

		WebElement ele = clinic_prov;
		ele.sendKeys("Ronak J Patel MD PLLC");
		ele.sendKeys(Keys.ENTER);
		ln.click();

	}

	public void providerDetails() {

		txt.click();

		WebElement ele1 = first;
		ele1.sendKeys("test");
		ele1.sendKeys(Keys.ENTER);

		txt2.click();
		WebElement ele2 = last;
		ele2.sendKeys("Jest");
		ele2.sendKeys(Keys.ENTER);

	}

	public void HomeAddress() {

		addrs.click();
		WebElement txt = txt3;
		txt.sendKeys("test1 ");
		txt.sendKeys(Keys.ENTER);

		ph.click();
		WebElement txt1 = txt4;
		txt1.sendKeys("111111111111111 ");
		txt1.sendKeys(Keys.ENTER);

		mail.click();
		WebElement txt2 = txt5;
		txt2.sendKeys("sreeraj@iris-llc.com ");
		txt2.sendKeys(Keys.ENTER);

	}

	public void previousHome() throws InterruptedException {
		pr_add.click();
		WebElement txt3 = txt6;
		txt3.sendKeys("tst2 ");
		txt3.sendKeys(Keys.ENTER);

		pr_ph.click();
		WebElement txt4 = txt7;
		txt4.sendKeys("111111111111111");
		txt4.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		prv_mail.click();
		WebElement txt8 = mail_txt;
		txt8.sendKeys("sreeraj@iris-llc.com ");
		txt8.sendKeys(Keys.ENTER);

	}

	public void submitProvider() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		sub.click();

	}

	public void alertTest() {
		// driver.switchTo().alert().accept();
		alert.click();
	}

}
