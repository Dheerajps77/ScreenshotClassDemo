package ExtentReportsDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstReport 
{
	
	WebDriver driver;
	
	@BeforeClass
	public void OpeningBroswer()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("==================================");
	}

	
	
	@Test
	public void Login() throws InterruptedException, IOException
	{
		
		driver.findElement(By.xpath("//input[@data-testid='royal_email']")).sendKeys("DheerajPratapSingh@gmail.com");
		driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("Password1");
		driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
		Thread.sleep(3000);
		
		TakesScreenshot screen=(TakesScreenshot)driver;
		File path_of=screen.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\hp\\workspace\\ReportsDemo\\Screenshot\\fb1.png");
		FileUtils.copyFile(path_of, des);		
	
		System.out.println("Test Script execution succeed");
		

		System.out.println("==================================");
		String current_URL=driver.getCurrentUrl();
		System.out.println(driver.getTitle());
		Assert.assertEquals(current_URL, "dshttps://www.facebook.com/login.php?login_attempt=1&lwv=110");
		System.out.println("Test case has been failed");
		
	}
	
	@AfterClass
	public void CloseBrowser(){
		
		driver.close();
		
	}

}
