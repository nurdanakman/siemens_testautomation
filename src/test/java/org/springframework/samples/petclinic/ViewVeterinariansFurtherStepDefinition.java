package org.springframework.samples.petclinic;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ViewVeterinariansFurtherStepDefinition {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}
	
	@Given("Launch the browser4")
	public void launch_the_browser4() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCert");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);
	
		driver.get("http://localhost:8088/");
		Boolean pageControl = driver.findElement(By.cssSelector("img[class='img-responsive']")).isDisplayed();

		assertTrue(pageControl);
	}
	
	
	@When("Click View Veterinarians Button")
	public void click_view_veterinarians_button() {
		driver.findElement(By.cssSelector("[title='veterinarians']")).click();
	}
	
	@When("Click Next Page")
	public void click_next_page() {
		driver.findElement(By.cssSelector("[title='Next']")).click();
	}
	
	@Then("Control Page Number")
	public void control_page_number() {
		Boolean ViewVeterinariansFurther = driver.findElement(By.xpath("/html/body/div/div/div[1]/span[3]/a")).isEnabled();
		assertTrue(ViewVeterinariansFurther);
		System.out.println("test20"); 
	}
	
	@After
	public void clean() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
	//	driver.quit();
	}

}
