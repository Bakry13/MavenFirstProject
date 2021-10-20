package MavenTest.MavenFirstProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	ChromeDriver driver;
//	FirefoxDriver driver;
	String driverPath = "C:\\Users\\Mohamed\\Desktop\\Course\\MavenFirstProject\\resources\\chromedriver.exe";
//	static String driverPath = System.getProperty("user.dir")+"/resources/";
	
	@Test
	void login()
	{
		try {
			System.setProperty("webdriver.chrome.driver", driverPath);
//			System.setProperty("webdriver.chrome.driver", driverPath+"ChromeDriver.exe");
//			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/");
			driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
			driver.findElement(By.id("email")).sendKeys("test@moakt.cc");
			driver.findElement(By.id("passwd")).sendKeys("Test@123");
			driver.findElement(By.name("SubmitLogin")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
