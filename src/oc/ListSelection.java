package oc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ListSelection {
	WebDriver driver;
	
	public void listSelection(String id,String type) throws InterruptedException{
		
		new Select(driver.findElement(By.id(id))).selectByVisibleText(type);//选择工单状态--未提交
		driver.findElement(By.className("btn btn-primary")).click();//点击查询
		Assert.assertEquals(driver.findElement(By.className("label label-sm label-danger")),type);//验证查询结果中工单状态为未提交
		Thread.sleep(2000);

}
	}






	
