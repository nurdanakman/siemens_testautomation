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

public class ViewVeterinariansExampleStepDefinition {
	
	WebDriver driver;
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
	}
	
	@Given("Launch the browser6")
	public void launch_the_browser6() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--allow-insecure-localhost");
		options.addArguments("acceptInsecureCert");
		options.addArguments("--ignore-certificate-errors");

		driver = new ChromeDriver(options);
	
		driver.get("http://localhost:8088/");
		Boolean pageControl = driver.findElement(By.cssSelector("img[class='img-responsive']")).isDisplayed();

		assertTrue(pageControl);
	}
	
	
	@When("Click View Veterinarians Button6")
	public void click_view_veterinarians_button6() {
		driver.findElement(By.cssSelector("[title='veterinarians']")).click();
	}
	
	@Then("Control Veterinarian Member")
	public void control_veterinarian_member() {
		Boolean ViewVeterinarians = driver.findElement(By.xpath("//*[@id=\"vets\"]/tbody/tr[4]/td[1]")).isDisplayed();
		assertTrue(ViewVeterinarians);
		System.out.println("test40");
	}
	
	@After
	public void clean() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
	//	driver.quit();
	}

}
