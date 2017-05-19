package oc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class oc_logout {
	WebDriver driver;
	
  @Test
  public void logout() throws InterruptedException {
	  
	  Thread.sleep(2000);
	  driver.findElement(By.className("icon-logout")).click();
  }
}
