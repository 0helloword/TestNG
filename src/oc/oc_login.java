package oc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class oc_login {
	
	WebDriver driver;
	
	@Parameters({ "url_sa", "username", "password" })
	@Test(priority = 1)
	
	public void login(String url_sa, String username, String password)
			throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get(url_sa);
		driver.manage().window().maximize();// 窗口最大化
		driver.findElement(By.id("username")).sendKeys(username);// 输入登录用户名
		driver.findElement(By.id("password")).sendKeys(password);// 输入登录密码
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // 点击登录
	}

}
