package oc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ListSelection {
	WebDriver driver;
	
	public void listSelection(String id,String type) throws InterruptedException{
		
		new Select(driver.findElement(By.id(id))).selectByVisibleText(type);//ѡ�񹤵�״̬--δ�ύ
		driver.findElement(By.className("btn btn-primary")).click();//�����ѯ
		Assert.assertEquals(driver.findElement(By.className("label label-sm label-danger")),type);//��֤��ѯ����й���״̬Ϊδ�ύ
		Thread.sleep(2000);

}
	}






	
