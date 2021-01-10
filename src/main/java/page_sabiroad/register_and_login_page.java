package page_sabiroad;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

public class register_and_login_page {
	private WebDriver driver = null;

	public static String projectpath= System.getProperty("user.dir");
	
	private static EyesRunner runner;
	private static Eyes eyes;
	private static BatchInfo batch;
	
	public register_and_login_page (WebDriver driver) {
	

		this.driver  = driver;
	}
	
	//browser launching
		public  WebDriver sabi_road_launchbrowser() throws Exception {
			
			
					
			System.setProperty("webdriver.gecko.driver", projectpath+ "\\driver\\geckodriver.exe");
			batch = new BatchInfo("SABI_ROAD Test");
			 
			 runner = new ClassicRunner();
			 eyes = new Eyes(runner);
			 eyes.setApiKey("NCJnDb1X2MQat110111h4se1Hen7KcNOCbXAnX101laxsjIsA110");
			 eyes.setBatch(batch);

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


			System.out.println("browser launched successfully");
			
			driver.get("https://test.sabiroad.net/signin");
			Thread.sleep(2000);
			System.out.println("URL launched successfully");

			return driver;

		}
		
		     //login page
			public  WebDriver sabi_road_log_page(String email, String password, String quote) throws Exception {
				
//				eyes.open(driver, "SabiRoad Test", "Registration Page", new RectangleSize(1800,1800));
//				  eyes.checkWindow("webpage");
//				  eyes.closeAsync();
//				driver.findElement(By.xpath("//a[@id='signInButton']/span")).click();
							
				eyes.open(driver, "SabiRoad Test", "login page"+ quote, new RectangleSize(1800,1800));
				  eyes.checkWindow("loginpage");
				  //eyes.closeAsync();
				  driver.findElement(By.id("emailAddress")).click();
					    driver.findElement(By.id("emailAddress")).clear();
					    driver.findElement(By.id("emailAddress")).sendKeys(email);
					    driver.findElement(By.id("password")).click();
					    driver.findElement(By.id("password")).clear();
					    driver.findElement(By.id("password")).sendKeys(password);
					    driver.findElement(By.cssSelector("path")).click();
					    driver.findElement(By.xpath("//form[@id='signinformcontainer']/button/span")).click();
					    
					    Thread.sleep(4000);
					    //eyes.open(driver, "SabiRoad Test", "page displayed"+ quote, new RectangleSize(1800,1800));
						  eyes.checkWindow("pagedisplayed");
						  eyes.closeAsync();

							return driver;

						}
			
			//registration page
			public  WebDriver sabi_road_reg_page() throws Exception {
				
				
				
				System.setProperty("webdriver.gecko.driver", projectpath+ "\\driver\\geckodriver.exe");

				driver = new FirefoxDriver();

				driver.manage().window().maximize();

				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


				System.out.println("browser launched successfully");

				return driver;

			}
			
			
}
