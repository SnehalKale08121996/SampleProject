
package LoginPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import Utils.ExcelUtils;

public class InvalidCredentialsTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {

        driver = BaseClass.setup();
        loginPage = new LoginPage(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws IOException {

        return ExcelUtils.getExcelData(
            "src/test/resources/LoginData.xlsx"
        );
    }

    @Test(dataProvider = "loginData")
    public void invalidcredential(
            String username,
            String password,
            String expectedMessage) {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        loginPage.enterLoginUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickOnSignIn();

        loginPage.verifyIncorrectLoginDetailsErrorMessage(
            expectedMessage
        );
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
