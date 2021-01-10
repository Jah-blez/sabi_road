package action_sabiroad;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import page_sabiroad.register_and_login_page;



public class register_and_login {
static WebDriver driver;
	
	@Test
	public void login() throws Exception {
		
		register_and_login_page rl = new register_and_login_page(driver);
		driver = rl.sabi_road_launchbrowser();
		
		//login with invalid credentials
		rl.sabi_road_log_page("customer@sabiroad.com", "", ", when no password is entered");
		rl.sabi_road_log_page("customer@sabiroad.com", " ", ", when space is used as password");
		driver.findElement(By.xpath("//div[3]/button/span")).click();
		rl.sabi_road_log_page(" ", "password",", when space is used as email");
		rl.sabi_road_log_page(" ", " ", ", when space is used as email and password");
		rl.sabi_road_log_page("customer@sabiroad", "wrong password", ", when an invalid password is entered");
		
		driver.findElement(By.xpath("//div[3]/button/span")).click();
		
		rl.sabi_road_log_page("wrong_email@sabiroad.com", "password", ", when an invalid email is entered");
		driver.findElement(By.xpath("//div[3]/button/span")).click();
		
		//login with valid credentials
		rl.sabi_road_log_page("customer@sabiroad.com", "password",", when valid credential for customer is entered");
		
		Thread.sleep(4000);
		
//		driver.findElement(By.xpath("//div[@id='root']/div/div/header/div/div[2]/button[3]/span/div")).click();
//	    driver.findElement(By.xpath("//div[@id='primary-search-account-menu']/div[3]/ul/li[2]")).click();
//		
//		rl.sabi_road_log_page("transporter@sabiroad.com", "password",",when valid credential for transporter is entered");
//		Thread.sleep(4000);
//		
//		driver.findElement(By.xpath("//div[@id='root']/div/div/header/div/div[2]/button[3]/span/div")).click();
//	    driver.findElement(By.xpath("//div[@id='primary-search-account-menu']/div[3]/ul/li[2]")).click();
		
		
		
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();

	}
}
