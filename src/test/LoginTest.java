package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		// step1: click on log in link
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		// Step2: Enter Username
		WebElement Username = driver.findElement(By.name("user_login"));
		Username.sendKeys("Sanjayydv3765@gmail.com");
		// Step3: Enter Password
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Sajay@123");
		// Step3: click on remember me
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		RememberMe.click();
		// Step3: Click on submit button
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement LogInBtn = driver.findElement(By.name("btn_login"));
		LogInBtn.click();
		WebElement Error = driver.findElement(By.id("msg_box"));
		String ActError = Error.getText();
		String ExpError = "The email or password you have entered is invalid.";
		if (ActError.equals(ExpError)) {
			System.out.println("test case passed");

		} else {
			System.out.println("test case fail");
		}
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of Links are"+Links.size());
		
		for(int i =0; i<Links.size(); i++)	{
			System.out.println(Links.get(i).getAttribute("href"));
		}
		driver.close();

	}

}
