package LoginPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BasePackage.BaseClass;

public class ForgotPasswordFlowTest {

	WebDriver driver;

	LoginPage loginPage;

	@BeforeClass
	public void setup() {

		driver = BaseClass.setup();
		loginPage = new LoginPage(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}

	@Test
	public void loginUser() throws InterruptedException {

		loginPage.clickOnForgotPasswordLink();
		loginPage.clickOnResetLoginButton();
		String loginText = loginPage.grabPasswordText();
		loginPage.clickOnGotoLoginPageButton();
		Thread.sleep(2000);
		loginPage.enterLoginUserName("Snehal");
		loginPage.enterPassword(loginText);
		loginPage.clickOnSignIn();
		Thread.sleep(2000);
		loginPage.verifyLoginSuccessfullyMessage("Welcome to Rahul Shetty Academy");

	}

	@AfterClass
	public void tearDown() {
		driver.close();

	}
}