package BasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	protected WebDriver driver;

	public static WebDriver setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\snehal.kale\\eclipse-workspace\\SeleniumFrameWorkTest\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public void closeBrowser() {
		driver.quit();
	}
}
