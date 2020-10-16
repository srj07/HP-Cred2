package login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ClinicLaunch {
	
	public WebDriver driver;
	By adm = By.xpath("//span[contains(text(),'Administration')]");
	By clinic = By.xpath("//a[@id='administrationClinicsNav']");
	By clinic_option = By.xpath("//a[contains(text(),'Ronak J Patel MD PLLC')]");
	By disable = By.xpath("//input[@id='active']//following::span ");
	By hospital = By.xpath("//a[contains(text(),'Hospital List')]");
	By tt = By.xpath("//i[@class='ace-icon fa fa-save']");
	By tab = By.xpath("//a[contains(text(),'Hospital List')]");
	By payer = By.xpath("//a[contains(text(),'Payer List')]");
	By prv = By.xpath("//a[contains(text(),'Provider List')]");
	public ClinicLaunch(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void admModule() {
		driver.findElement(adm).click();
	
		driver.findElement(clinic).click();
		driver.findElement(clinic_option).click();
	}
	public boolean msgPresent() throws InterruptedException {

		try {
			Alert a = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
			if (a != null) {
				System.out.println("Alert is present");
				driver.switchTo().alert().accept();
				return true;

			} else {
				throw new Throwable();
			}
		} catch (Throwable e) {
			driver.findElement(disable).click();

			System.err.println("Alert isn't present!!");
			return false;
		}

	}
	public void CheckActive() {
		WebElement button = driver.findElement(disable);
		String classes = button.getAttribute("class");
		boolean isDisabled = classes.contains("ace ace-switch ace-switch-2 btn-rotate");
		if (isDisabled = true) {
			driver.findElement(disable).click();
			driver.findElement(tt).click();

		} else {
			driver.findElement(hospital).click();

		}
	}
	
	public void HospitalPresent() {
		WebElement t = driver.findElement(tab);
		String name = t.getText();
		if(name.contains("Hospital List")) {
			Assert.assertTrue(true, "Hospital tab is here...");
			driver.findElement(hospital).click();
		}
		else {
			Assert.fail("Hospital Tab is not Found");
		}
	}
	
	public void payerPresent() {
		WebElement t = driver.findElement(payer);
		String name = t.getText();
		if(name.contains("Payer List")) {
			Assert.assertTrue(true, "Payer tab is Here...");
			driver.findElement(payer).click();
		}
		else {
			Assert.fail("Payer Tab is not Found");
		}
	}
	
	
	public void providerPresent() {
		WebElement t = driver.findElement(prv);
		String name = t.getText();
		if(name.contains("Provider List")) {
			Assert.assertTrue(true, "Provider tab is Here...");
			driver.findElement(prv).click();
		}
		else {
			Assert.fail("Provider Tab is not Found");
		}
	}
	

}
