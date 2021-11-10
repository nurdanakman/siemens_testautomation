package org.springframework.samples.petclinic;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindOwnersSeleniumWebDriverTest {

	WebDriver driver;

	@BeforeSuite(description = "test ortamı hazırlandı.")
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCert");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);
	}

	@BeforeTest(description = "siteye giriş yapılabildi mi?")
	public void beforeTest() {
		driver.get("http://localhost:8088/");
		Boolean pageControl = driver.findElement(By.cssSelector("img[class='img-responsive']")).isDisplayed();

		assertTrue(pageControl);
		System.out.println("test00");
	}

	@Test(description = "owner eklenebiliyor mu?", enabled = true)
	public void addOwner() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a/span[2]")).click();
		driver.findElement(By.linkText("Add Owner")).click();

		driver.findElement(By.id("firstName")).sendKeys("Nurdan");
		driver.findElement(By.id("lastName")).sendKeys("Akman");
		driver.findElement(By.name("address")).sendKeys("Kartal");
		driver.findElement(By.id("city")).sendKeys("İstanbul");
		driver.findElement(By.id("telephone")).sendKeys("05070065939");

		driver.findElement(By.className("btn-default")).click();
		
		WebElement ownerInfo = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));
		assertTrue(ownerInfo.isDisplayed());
		
		System.out.println("Test10");
	}	
	
	@Test(description = "owner editlenebiliyor mu?", enabled = true,  dependsOnMethods = {"addNewPet" })
	public void editOwner() throws InterruptedException {
		driver.navigate().back();
		driver.findElement(By.linkText("Edit Owner")).click();
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("Kagithane");

		driver.findElement(By.className("btn-default")).click();
		
		String ownerInfo = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")).getText();
		assertEquals(ownerInfo, "Kagithane");
		
		System.out.println("Test11");
	}	
	
	@Test(description = "owner pet eklenebiliyor mu?", enabled = true, dependsOnMethods = {"addOwner"})
	public void addNewPet() throws InterruptedException {
		driver.findElement(By.linkText("Add New Pet")).click();
		
		driver.findElement(By.name("name")).sendKeys("Groot");
		driver.findElement(By.xpath("//*[@id=\"birthDate\"]")).sendKeys("1996-04-14");
		
		WebElement testDropDown1 = driver.findElement(By.id("type"));
		Select dropdown = new Select(testDropDown1);
		dropdown.selectByVisibleText("lizard");
		
		WebElement ownerInfo = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button"));
		assertTrue(ownerInfo.isDisplayed());
		
		System.out.println("Test12");
	}	



}
