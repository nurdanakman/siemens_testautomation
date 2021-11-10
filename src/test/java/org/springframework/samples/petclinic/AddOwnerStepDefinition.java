package org.springframework.samples.petclinic;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddOwnerStepDefinition {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}
	
	@Given("Launch the browser")
	public void launch_the_browser() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCert");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);
	}
	
	@When("Open Spring Clinic on the browser")
	public void open_spring_clinic_on_the_browser() {
		driver.get("http://localhost:8088/");
		Boolean pageControl = driver.findElement(By.cssSelector("img[class='img-responsive']")).isDisplayed();

		assertTrue(pageControl);
	}
	
	
	@When("Click The Find Owner Button")
	public void click_the_find_owner_button() {
		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a/span[2]")).click();
	}
	
	@When("Click The Add Owner Button")
	public void click_the_add_owner_button() {
		driver.findElement(By.linkText("Add Owner")).click();
	}
	
	@When("Fill Owner Info")
	public void fill_owner_info() {
		driver.findElement(By.id("firstName")).sendKeys("Nurdan");
		driver.findElement(By.id("lastName")).sendKeys("Akman");
		driver.findElement(By.name("address")).sendKeys("Kartal");
		driver.findElement(By.id("city")).sendKeys("İstanbul");
		driver.findElement(By.id("telephone")).sendKeys("05070065939");
	}
	
	@When("Click The Add Inside Owner Button")
	public void click_the_add_inside_owner_button() {
		driver.findElement(By.className("btn-default")).click();
	}
	
	@Then("Check Find New Owner Info")
	public void check_find_new_owner_info() {
		WebElement ownerInfo = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[1]/td/b"));
		assertTrue(ownerInfo.isDisplayed());

		System.out.println("Test10");
	}
	
	@After
	public void clean() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
	//	driver.quit();
	}

}
