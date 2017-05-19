package oc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;



public class oc {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://123.57.56.45:7778/OC/initLogin");
		driver.manage().window().maximize();// 窗口最大化
	}

	@Test(priority=1)
	public void login()//登录
			throws InterruptedException {
	
		driver.findElement(By.id("username")).sendKeys("999111");// 输入登录用户名
		driver.findElement(By.id("password")).sendKeys("cyj111");// 输入登录密码
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // 点击登录
	}
	@Test(priority=2)
		public void oc_app_query_keys() throws InterruptedException{   //工单查询界面按键测试
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[3]/a/span")).click();//点击工单查询
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();//点击查询
			Thread.sleep(4000);
			driver.findElement(By.linkText("下一页")).click();//点击下一页
			Thread.sleep(2000);
			driver.findElement(By.linkText("最后一页")).click();//点击最后一页
			Thread.sleep(2000);
			driver.findElement(By.id("pageInput")).sendKeys("20");//输入跳转页面为20
			driver.findElement(By.linkText("go")).click();//点击go,跳转到20页
			Thread.sleep(2000);
			driver.findElement(By.linkText("上一页")).click();//点击上一页
			Thread.sleep(2000);
			driver.findElement(By.linkText("第一页")).click();//点击第一页
	}
			  
		     // WebElement table = driver.findElement(By.className("portlet-body")); 
		     // int rows = table.findElements(By.tagName("tr")).size();
		    //  List<WebElement> rows = table.findElements(By.tagName("tr")); 
		     // System.out.println(rows);
//	 	      assertEquals(5,rows.size());  
//		      for(WebElement row:rows){  
//		          List<WebElement> cols= row.findElements(By.tagName("td"));  
//		          for(WebElement col:cols){  
//		              System.out.println(col.getText()+"\t");               
//		          }  
//		          System.out.println("");  
//		      }  
		  
			
			
			
//			//工单查询-工单状态验证
//			Thread.sleep(2000);
//			new Select(driver.findElement(By.id("appState"))).selectByVisibleText("未提交");//选择工单状态--未提交
//			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();//点击查询
//			String title1=driver.findElement(By.className("label label-sm label-danger")).getText();
//			Assert.assertEquals(title1,"未提交");//验证查询结果中工单状态为未提交
//			Thread.sleep(2000);
//		}
	
//	@Test(priority=4)
//	public void oc_app_fendan() throws InterruptedException{
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//li[4]/a/span")).click();// 人工审核
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("审核分单（POS）")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.name("id")).sendKeys("10136319");//输入工单号
//		driver.findElement(By.cssSelector("button.btn.blue-madison")).click();//点击查询
//		Thread.sleep(1000);
//		driver.findElement(By.id("allCheck")).click();//勾选订单项
//		Thread.sleep(1000);
//		driver.findElement(By.id("select2-chosen-10")).click();
//		driver.findElement(By.className("select2-input")).sendKeys("小拉");
//		Thread.sleep(1000);
//		driver.findElement(By.className("btn blue btn-ok")).click();
//	}
//		
//
//		
	@AfterTest
	public void afterTest() throws InterruptedException {
		 Thread.sleep(2000);
		  driver.findElement(By.className("icon-logout")).click();
	}


}

