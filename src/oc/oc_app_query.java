package oc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class oc_app_query {
	WebDriver driver;
	WebElement appquery=null;
	
	public void keys() throws InterruptedException{
		
		Thread.sleep(2000);
	
		appquery=driver.findElement(By.xpath("//li[3]/a/span"));
		System.out.println(appquery);
		appquery.click();//点击工单查询
		

		Thread.sleep(2000);
		driver.findElement(By.className("btn btn-primary")).click();//点击查询
		Thread.sleep(2000);
		driver.findElement(By.linkText("下一页")).click();//点击下一页
		Thread.sleep(2000);
		driver.findElement(By.linkText("最后一页")).click();//点击最后一页
		Thread.sleep(2000);
		driver.findElement(By.id("pageInput")).sendKeys("20");;//输入跳转页面为20
		driver.findElement(By.linkText("go")).click();//点击go,跳转到20页
		Thread.sleep(2000);
		driver.findElement(By.linkText("上一页")).click();//点击上一页
		Thread.sleep(2000);
		driver.findElement(By.linkText("第一页")).click();//点击第一页
	}
	

		
		
		
	
	
	
	
	
}
	




 