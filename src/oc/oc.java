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
		driver.manage().window().maximize();// �������
	}

	@Test(priority=1)
	public void login()//��¼
			throws InterruptedException {
	
		driver.findElement(By.id("username")).sendKeys("999111");// �����¼�û���
		driver.findElement(By.id("password")).sendKeys("cyj111");// �����¼����
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // �����¼
	}
	@Test(priority=2)
		public void oc_app_query_keys() throws InterruptedException{   //������ѯ���水������
			Thread.sleep(2000);
			driver.findElement(By.xpath("//li[3]/a/span")).click();//���������ѯ
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();//�����ѯ
			Thread.sleep(4000);
			driver.findElement(By.linkText("��һҳ")).click();//�����һҳ
			Thread.sleep(2000);
			driver.findElement(By.linkText("���һҳ")).click();//������һҳ
			Thread.sleep(2000);
			driver.findElement(By.id("pageInput")).sendKeys("20");//������תҳ��Ϊ20
			driver.findElement(By.linkText("go")).click();//���go,��ת��20ҳ
			Thread.sleep(2000);
			driver.findElement(By.linkText("��һҳ")).click();//�����һҳ
			Thread.sleep(2000);
			driver.findElement(By.linkText("��һҳ")).click();//�����һҳ
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
		  
			
			
			
//			//������ѯ-����״̬��֤
//			Thread.sleep(2000);
//			new Select(driver.findElement(By.id("appState"))).selectByVisibleText("δ�ύ");//ѡ�񹤵�״̬--δ�ύ
//			driver.findElement(By.cssSelector("button.btn.btn-primary")).click();//�����ѯ
//			String title1=driver.findElement(By.className("label label-sm label-danger")).getText();
//			Assert.assertEquals(title1,"δ�ύ");//��֤��ѯ����й���״̬Ϊδ�ύ
//			Thread.sleep(2000);
//		}
	
//	@Test(priority=4)
//	public void oc_app_fendan() throws InterruptedException{
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//li[4]/a/span")).click();// �˹����
//		Thread.sleep(1000);
//		driver.findElement(By.linkText("��˷ֵ���POS��")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.name("id")).sendKeys("10136319");//���빤����
//		driver.findElement(By.cssSelector("button.btn.blue-madison")).click();//�����ѯ
//		Thread.sleep(1000);
//		driver.findElement(By.id("allCheck")).click();//��ѡ������
//		Thread.sleep(1000);
//		driver.findElement(By.id("select2-chosen-10")).click();
//		driver.findElement(By.className("select2-input")).sendKeys("С��");
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

