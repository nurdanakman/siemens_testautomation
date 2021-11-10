package org.springframework.samples.petclinic;

import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddPetStepDefinition {

	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}

	@Given("Launch the browser2")
	public void launch_the_browser2() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCert");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);
	}

	@When("Add New Owner2")
	public void add_new_owner2() {
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

	@When("Click Add New Pet Button")
	public void click_add_new_pet_button() {
		driver.findElement(By.linkText("Add New Pet")).click();
	}

	@And("Write New Pet Info")
	public void write_new_pet_info() {
		driver.findElement(By.name("name")).sendKeys("Groot");
		driver.findElement(By.xpath("//*[@id=\"birthDate\"]")).sendKeys("1996-04-14");
	}

	@When("Select Pet Type in DropDown")
	public void select_pet_type_in_dropdown() {
		WebElement testDropDown1 = driver.findElement(By.id("type"));
		Select dropdown = new Select(testDropDown1);
		dropdown.selectByVisibleText("lizard");
	}

	@And("Click Add Pet Button")
	public void click_add_pet_button() {
		driver.findElement(By.xpath("/html/body/div/div/form/div[2]/div/button")).click();
	}

	@Then("Check The Added Pet Info")
	public void check_the_added_pet_info() {
		WebElement ownerInfo = driver.findElement(By.xpath("/html/body/div/div/table[2]/tbody"));
		assertNotNull(ownerInfo);

		System.out.println("Test12");
	}

	@After
	public void clean() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		//driver.quit();
	}

}
