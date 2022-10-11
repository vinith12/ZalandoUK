package org.zalando;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZalandoGreens {
	
	public static WebDriver driver;
	@BeforeClass
	public static void beforeclass() {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://www.zalando.co.uk/");
	}
	
	@AfterClass
	public static void afterclass() {
//        driver.quit();
	}
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("Bags" + Keys.ENTER);
		
		List<WebElement> bag = driver.findElements(By.xpath("//h3[@class='_0Qm8W1 u-6V88 FxZV-M pVrzNP ZkIJC- r9BRio qXofat EKabf7 nBq1-s _2MyPg2']"));
		bag.get(5).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='uc-btn uc-btn-primary']")).click();
		driver.findElement(By.xpath("//span[text()='Add to bag']")).click();
		Actions a = new Actions(driver);
		WebElement cart = driver.findElement(By.xpath("//a[@title='Your bag']"));
		a.moveToElement(cart);
		WebElement crt = driver.findElement(By.xpath("//a[@class='z-1-button z-coast-base-primary-accessible undefined z-1-button--primary z-1-button--link']"));
		a.moveToElement(crt).click().perform();
		
	    driver.findElement(By.xpath("//div[text()='Go to checkout']")).click();	
	}
	
	

}
