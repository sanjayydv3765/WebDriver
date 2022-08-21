package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement CreateNewAccount = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		CreateNewAccount.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		WebElement FirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		FirstName.sendKeys("Tester");
		WebElement SurName = driver.findElement(By.xpath("//input[@name='lastname']"));
		SurName.sendKeys("Last");
		WebElement EmailPhone = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		EmailPhone.sendKeys("839939993");
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		Password.sendKeys("test");
		
		WebElement BBDay = driver.findElement(By.name("birthday_day"));
		Select ddDay = new Select(BBDay);
		ddDay.selectByVisibleText("15");
		
		WebElement Month = driver.findElement(By.name("birthday_month"));
		Select ddMonth = new Select(Month);
		ddMonth.selectByVisibleText("Aug");
		System.out.println("Get first selected option "+ddMonth.getFirstSelectedOption().getText());
	
		List<WebElement> Months = ddMonth.getOptions();
		for (WebElement ele : Months) {
			System.out.println(ele.getText());
		}
		
//		List <WebElement> AllMonths = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));
//		for (WebElement ele : AllMonths) {
//			System.out.println(ele.getText());
//		}
		WebElement BBYear = driver.findElement(By.name("birthday_year"));
		Select ddYear = new Select(BBYear);
		ddYear.selectByVisibleText("1992");
		String Gender ="Male";
		WebElement Male =driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		WebElement FeMale =driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		WebElement Other =driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
		
		String Xpath="//Label[text()='"+Gender+"']/following-sibling::input";
		   WebElement GendgerRadioBtn = driver.findElement(By.xpath(Xpath));
	        GendgerRadioBtn.click();
//		Male.click();
//		if(Gender.equals("Male")) {
//			Male.click();
//		}
//		if(Gender.equals("FeMale")) {
//			FeMale.click();
//		}
//		if(Gender.equals("Other")) {
//			Other.click();
//		}
		driver.close();
		driver.quit();

	}

}
