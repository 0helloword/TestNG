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
		appquery.click();//���������ѯ
		

		Thread.sleep(2000);
		driver.findElement(By.className("btn btn-primary")).click();//�����ѯ
		Thread.sleep(2000);
		driver.findElement(By.linkText("��һҳ")).click();//�����һҳ
		Thread.sleep(2000);
		driver.findElement(By.linkText("���һҳ")).click();//������һҳ
		Thread.sleep(2000);
		driver.findElement(By.id("pageInput")).sendKeys("20");;//������תҳ��Ϊ20
		driver.findElement(By.linkText("go")).click();//���go,��ת��20ҳ
		Thread.sleep(2000);
		driver.findElement(By.linkText("��һҳ")).click();//�����һҳ
		Thread.sleep(2000);
		driver.findElement(By.linkText("��һҳ")).click();//�����һҳ
	}
	

		
		
		
	
	
	
	
	
}
	




 