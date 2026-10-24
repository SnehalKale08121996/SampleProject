package LoginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BasePackage.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "inputUsername")
	WebElement enterUserId;

	public void enterUserId(String userName) {

		enterUserId.sendKeys(userName);
	}

	@FindBy(id = "inputUsername")
	WebElement enterLoginUserName;

	public void enterLoginUserName(String userName) {

		enterLoginUserName.sendKeys(userName);
	}

	@FindBy(name = "inputPassword")
	WebElement enterPassword;

	public void enterPassword(String password) {

		enterPassword.sendKeys(password);
	}

	@FindBy(xpath = "//button[contains(@class,'submit')]")
	WebElement clickOnSignIn;

	public void clickOnSignIn() {

		clickOnSignIn.click();
	}
	
	
	@FindBy(xpath = "//*[@class='go-to-login-btn']")
	WebElement clickOnGotoLoginPageButton;

	public void clickOnGotoLoginPageButton() {

		clickOnGotoLoginPageButton.click();
	}

	@FindBy(xpath = "//*[text()='* Incorrect username or password']")
	WebElement verifyIncorrectLoginDetailsErrorMessage;

	public void verifyIncorrectLoginDetailsErrorMessage(String expectedMsg) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String actualMsg = wait.until(ExpectedConditions.visibilityOf(verifyIncorrectLoginDetailsErrorMessage))
				.getText();

		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@FindBy(xpath = "//div[@class='login-container']//h1")
	WebElement verifyLoginSuccessfullyMessage;

	public void verifyLoginSuccessfullyMessage(String expectedMsg) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String actualMsg1 = wait.until(ExpectedConditions.visibilityOf(verifyLoginSuccessfullyMessage)).getText();
		System.out.println("Message: "+actualMsg1);

		Assert.assertEquals(actualMsg1, expectedMsg);
	}

	@FindBy(linkText = "Forgot your password?")
	WebElement clickOnForgotPasswordLink;

	public void clickOnForgotPasswordLink() {

		clickOnForgotPasswordLink.click();
	}
	
	@FindBy(xpath = "//*[@class='logout-btn']")
	WebElement clickOnLogoutButton;

	public void clickOnLogoutButton() {

		clickOnLogoutButton.click();
	}

	@FindBy(xpath = "//*[@class='reset-pwd-btn']")
	WebElement clickOnResetLoginButton;

	public void clickOnResetLoginButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(clickOnResetLoginButton)).click();
	}
	
	@FindBy(xpath = "//h1[normalize-space()='Sign in']")
	WebElement signInHeading;

	public void verifySignInHeading(String expectedText) {

	    WebDriverWait wait =
	            new WebDriverWait(driver, Duration.ofSeconds(10));

	    String actualText = wait.until(
	            ExpectedConditions.visibilityOf(signInHeading)
	    ).getText();
	    System.out.println("actualText: "+actualText);

	    Assert.assertEquals(actualText, expectedText);
	}

	@FindBy(css = "form p")
	WebElement grabPasswordText;

	public String grabPasswordText() {

		String pass = grabPasswordText.getText();
		String[] word = pass.split("'");
		String pass1 = word[1].split("'")[0];
		System.out.println(pass1);
		return pass1;

	}

	public String password(WebDriver driver) {
		driver.findElement(By.linkText("Forgot your password?")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String text2 = driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(text2);
		// Please use temporary password 'rahulshettyacademy' to Login.

		String[] word = text2.split("'");
		String pass = word[1].split("'")[0];
		System.out.println(pass);
		return pass;

	}

}