package org.springframework.samples.petclinic;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditOwnerStepDefinition {

	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	@Given("Launch the browser1")
	public void launch_the_browser1() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCert");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);
	}

	@When("Add New Owner1")
	public void add_new_owner1() {
		driver.get("http://localhost:8088/");

		driver.findElement(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a/span[2]")).click();
		driver.findElement(By.linkText("Add Owner")).click();

		driver.findElement(By.id("firstName")).sendKeys("Nurdan");
		driver.findElement(By.id("lastName")).sendKeys("Akman");
		driver.findElement(By.name("address")).sendKeys("Kartal");
		driver.findElement(By.id("city")).sendKeys("İstanbul");
		driver.findElement(By.id("telephone")).sendKeys("05070065939");

		driver.findElement(By.className("btn-default")).click();
	}

	@When("Click Edit Owner Button")
	public void click_the_edit_owner_button() {
		driver.findElement(By.linkText("Edit Owner")).click();
	}

	@And("Clear Address Info")
	public void clear_address_info() {
		driver.findElement(By.id("address")).clear();
	}

	@When("Write New Address Info")
	public void write_new_address_info() {
		driver.findElement(By.id("address")).sendKeys("Kagithane");
	}

	@And("Click Update Owner Button")
	public void click_update_owner_button() {
		driver.findElement(By.className("btn-default")).click();
	}

	@Then("Check The Address is Updated")
	public void check_the_address_is_updated() {
		String ownerInfo = driver.findElement(By.xpath("/html/body/div/div/table[1]/tbody/tr[2]/td")).getText();
		assertEquals(ownerInfo, "Kagithane");

		System.out.println("Test11");
	}

	@After
	public void clean() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		//driver.quit();
	}

}
