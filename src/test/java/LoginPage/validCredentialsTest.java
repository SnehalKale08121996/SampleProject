package LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseClass;

public class validCredentialsTest {

	WebDriver driver;

	LoginPage loginPage;

	@BeforeClass
	public void setup() {

		driver = BaseClass.setup();
		loginPage = new LoginPage(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}

	@Test
	public void validcredential() throws InterruptedException {

		loginPage.enterLoginUserName("rahul");
		loginPage.enterPassword("rahulshettyacademy");
		loginPage.clickOnSignIn();
		Thread.sleep(2000);
		loginPage.verifyLoginSuccessfullyMessage("Welcome to Rahul Shetty Academy");

	}

	@AfterClass
	public void tearDown() {
		driver.close();

	}
}