package org.springframework.samples.petclinic;


	import static org.testng.Assert.assertTrue;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class ViewVeterinariansSeleniumWebDriverTest {

		WebDriver driver;

		@BeforeSuite(description = "test ortamı hazırlandı.")
		public void beforeSuite() {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--allow-insecure-localhost");
			options.addArguments("acceptInsecureCert");
			options.addArguments("--ignore-certificate-errors");
			//options.addArguments("--headless");
			 driver = new ChromeDriver(options);
		}
		


		@BeforeTest(description = "siteye giriş yapılabildi mi?")
		public void beforeTest() {
			driver.get("http://localhost:8088/");
			Boolean pageControl = driver.findElement(By.cssSelector("img[class='img-responsive']"))
					.isDisplayed();

			assertTrue(pageControl);
			System.out.println("test00");
		}
		@Test(description = "ViewVeterinariansFurther")
		public void ViewVeterinariansFurther() throws InterruptedException {
			driver.findElement(By.cssSelector("[title='veterinarians']")).click();
			driver.findElement(By.cssSelector("[title='Next']")).click();
			
			      
			Boolean ViewVeterinariansFurther = driver.findElement(By.xpath("/html/body/div/div/div[1]/span[3]/a")).isEnabled();
			assertTrue(ViewVeterinariansFurther);
			System.out.println("test20");  
			
			TimeUnit.SECONDS.sleep(3);
		}
		
		
		@Test(description = "ViewVeteriansBack",dependsOnMethods = "ViewVeterinariansFurther" )
		public void ViewVeteriansBack() {
			driver.findElement(By.cssSelector("[title='veterinarians']")).click();
			driver.findElement(By.cssSelector("[title='Next']")).click();
			driver.findElement(By.cssSelector("[title='Previous']")).click();
			Boolean ViewVeterinariansBack = driver.findElement(By.xpath("/html/body/div/div/div[1]/span[8]/a")).isEnabled();
			assertTrue(ViewVeterinariansBack);
			System.out.println("test30"); 
		}
		
		@Test(description = "ViewVeteriansExample",dependsOnMethods = "ViewVeteriansBack")
		public void ViewVeteriansExample() {
			driver.findElement(By.cssSelector("[title='veterinarians']")).click();
			Boolean ViewVeterinarians = driver.findElement(By.xpath("//*[@id=\"vets\"]/tbody/tr[4]/td[1]")).isDisplayed();
			assertTrue(ViewVeterinarians);
			System.out.println("test40");
		}




		@AfterSuite
		public void afterSuit() throws InterruptedException {
			TimeUnit.SECONDS.sleep(3);
			driver.close();
		}

	}
