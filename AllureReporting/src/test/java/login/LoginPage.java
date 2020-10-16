package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class LoginPage {
	public WebDriver driver;

	By user = By.xpath("//input[@id='Username']");
	By pass = By.name("Password");
	By log = By.xpath("//button[@id='loginbtn']");

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	// TODO Auto-generated constructor stub

	public void logoPresence() throws InterruptedException {
		boolean dispStatus = driver.findElement(By.xpath("//div[@class='navbar-brand']//img")).isDisplayed();
		Assert.assertEquals(dispStatus, true);
	}

	public void loginTest() throws InterruptedException {
		driver.findElement(user).sendKeys("iris");
		driver.findElement(pass).sendKeys("iris");
		driver.findElement(log).click();
        Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), "Credentialing Application");

	}

	public void registrationTest() {
		throw new SkipException("Skipping this Test");
	}

}
