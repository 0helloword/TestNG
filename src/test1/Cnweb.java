//cnweb�˹��������ҳ����֤,����д���ڴ�����

package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Cnweb {
	WebDriver driver;
	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://123.57.56.45:8080/cnweb/");
		driver.manage().window().maximize();// �������	
	}
	@Test(priority=1)
	public void login() throws Exception {
		driver.findElement(By.name("j_username")).sendKeys("998866");// �����¼�û���
		driver.findElement(By.name("j_password")).sendKeys("cyj111");// �����¼����
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // �����¼
		Thread.sleep(5000);// �ȴ�ʱ�䵥λΪ����
		String verify = driver.findElement(By.className("a1")).getText();
		assert verify.contains("�� ��");// ������ assertion
  }
	@Test(priority=2)
	public void testlogin() throws Exception {
		//driver.findElement(By.className("ui-dialog-close")).click();// �ر���绰����
	    driver.findElement(By.cssSelector("button.ui-dialog-close")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='jqxNavigationBar']/div[7]")).click();//ѡ���ǰ����
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("�˹��������(��)")).click();;//ѡ���˹��������
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("�������")).click();
	    Thread.sleep(2000);
	}
	@Test(priority=3)
	public void NCIIC_Check() throws Exception {
		 /** ���NCIIC�˹���������б��ѡ�� */  
        // Ԥ�ڵ�ѡ������StateOptions  
        List<String> StateOptions = Arrays.asList(new String[] {"��ѡ��","��Ϣһ�£���Ƭ��һ��","��Ϣ����Ƭ��һ��","��Ϣ��һ��","��Ϣһ�£���NCIIC������Ƭ","û���ҵ���¼","����NCIICʧ��","δ��"});
        int size1=StateOptions.size();
        /** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/ 
        Thread.sleep(2000);
        Select selectState = new Select(driver.findElement(By.name("MCRG01"))); //ͨ��name���Զ�λ��NCIIC��
        Assert.assertFalse(selectState.isMultiple());// ��֤�����б�֧�ֶ�ѡ
        List<String> act_StateOptions = new ArrayList<String>();  
        // �ж�ѡ������  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState.getOptions()) {  
            //e.click();  
            // ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�  
            act_StateOptions.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions.toArray(), act_StateOptions.toArray());  
        System.out.println("NCIIC�˹����--�����б�"+size1+"�ѡ����ʾ��ȷ");
        
        selectState.selectByVisibleText("δ��");
        //String selectw= selectState.getFirstSelectedOption().getText();
      
       String selectw="δ��";
        if ((selectw=="��Ϣһ�£���Ƭ��һ��")|| (selectw=="û���ҵ���¼")||(selectw=="��Ϣ��һ��"))
        	{System.out.println("NCIIC=-50");}
        else if ((selectw=="��Ϣ����Ƭ��һ��")||(selectw=="��Ϣһ�£���NCIIC������Ƭ")||(selectw=="����NCIICʧ��")|| (selectw=="δ��"))
        	{System.out.println("NCIIC=0");}
        
	}
	@Test(priority=4)
	public void NCIIC_Pic() throws Exception {
		 /** ���NCIIC��Ƭ�Ա������б��ѡ�� */  
        // Ԥ�ڵ�ѡ������StateOptions  
        List<String> StateOptions2 = Arrays.asList(new String[] {"��ѡ��","��Ƭһ��","��Ƭ��һ��","δ��"});
        int size2=StateOptions2.size();
        /** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/  
        Thread.sleep(2000);
        Select selectState2 = new Select(driver.findElement(By.name("MCRG02"))); 
        Assert.assertFalse(selectState2.isMultiple());// ��֤�����б�֧�ֶ�ѡ
        List<String> act_StateOptions2 = new ArrayList<String>();  
        // �ж�ѡ������  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState2.getOptions()) {  
            //e.click();  
            // ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�  
            act_StateOptions2.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions2.toArray(), act_StateOptions2.toArray());  
        System.out.println("NCIIC��Ƭ�Ա�--�����б�"+size2+"�ѡ����ʾ��ȷ");
        selectState2.selectByVisibleText("��Ƭһ��");
        System.out.println("NCIIC_Pic=0");      
        
	}
	@Test(priority=5)
	public void ps() throws Exception {
		 /** ��˱�ע */ 
	    Thread.sleep(1000);
	    driver.findElement(By.name("MCRG0T")).clear();
	    driver.findElement(By.name("MCRG0T")).sendKeys("test");
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("��һ��")).click();
	}
	@Test(priority=6)
	public void SheBao() throws Exception {
		 /** ����籣��Ϣ��ʵ�����б��ѡ�� */  
        // Ԥ�ڵ�ѡ������StateOptions  
        List<String> StateOptions3 = Arrays.asList(new String[] {"��ѡ��","�籣��λ�����������һ��","�籣��λ�����������һ��","���籣","�޷���֤�籣��Ϣ","����","��թ����","δ��"});
        int size1=StateOptions3.size();
        /** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/  
        Thread.sleep(2000);
        Select selectState3 = new Select(driver.findElement(By.name("MCRG03"))); //ͨ��name���Զ�λ���籣ѡ��
        Assert.assertFalse(selectState3.isMultiple());// ��֤�����б�֧�ֶ�ѡ
        List<String> act_StateOptions3 = new ArrayList<String>();  //ʵ����һ��list��
        // �ж�ѡ������  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState3.getOptions()) {  
            //e.click();  
            // ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�  
            act_StateOptions3.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions3.toArray(), act_StateOptions3.toArray());  
        System.out.println("�籣��Ϣ��ʵ--�����б�"+size1+"�ѡ����ʾ��ȷ");
        
        selectState3.selectByVisibleText("�籣��λ�����������һ��");
        //String selectw= selectState.getFirstSelectedOption().getText();
      
       String selectw="�籣��λ�����������һ��";
        if (selectw=="�籣��λ�����������һ��")
        	{System.out.println("�籣=1");}
        else if ((selectw=="�籣��λ�����������һ��")||(selectw=="���籣")||(selectw=="�޷���֤�籣��Ϣ")||(selectw=="����")||(selectw=="δ��"))
        	{System.out.println("�籣=0");}
        else if (selectw=="��թ����")
        	{System.out.println("�籣=-50");}     
	}
	
	@Test(priority=7)
	public void xuexin() throws Exception {
		 /** ���ѧ������Ϣ��ʵ�����б��ѡ�� */  
        // Ԥ�ڵ�ѡ������StateOptions  
        List<String> StateOptions4 = Arrays.asList(new String[] {"��ѡ��","δ��","ѧ����һ��","ѧ������һ��","��ѧ��","����"});
        int size1=StateOptions4.size();
        Thread.sleep(2000);
        /** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/  
        Select selectState4 = new Select(driver.findElement(By.name("MCRG11"))); 
        Assert.assertFalse(selectState4.isMultiple());// ��֤�����б�֧�ֶ�ѡ
        List<String> act_StateOptions4 = new ArrayList<String>();  
        // �ж�ѡ������  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState4.getOptions()) {  
            //e.click();  
            // ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�  
            act_StateOptions4.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions4.toArray(), act_StateOptions4.toArray());  
        System.out.println("ѧ������Ϣ��ʵ--�����б�"+size1+"�ѡ����ʾ��ȷ");     
        selectState4.selectByVisibleText("ѧ������һ��");
        System.out.println("ѧ����=0");  
	}
	
	@Test(priority=8)
	public void Sell_Pic() throws Exception {
		 /** ���������Ƭ�Ա������б��ѡ�� */  
        // Ԥ�ڵ�ѡ������StateOptions  
        List<String> StateOptions5 = Arrays.asList(new String[] {"��ѡ��","��Ƭһ��","��Ƭ��һ��","�޷��ж�"});
        int size2=StateOptions5.size();
        Thread.sleep(2000);
        /** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/  
        Select selectState5 = new Select(driver.findElement(By.name("PSA01"))); 
        Assert.assertFalse(selectState5.isMultiple());// ��֤�����б�֧�ֶ�ѡ
        List<String> act_StateOptions5 = new ArrayList<String>();  
        // �ж�ѡ������  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState5.getOptions()) {  
            //e.click();  
            // ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�  
            act_StateOptions5.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions5.toArray(), act_StateOptions5.toArray());  
        System.out.println("������Ƭ�Ա�--�����б�"+size2+"�ѡ����ʾ��ȷ");
        selectState5.selectByVisibleText("�޷��ж�");
        System.out.println("������Ƭ�Ա�=0"); 
        Thread.sleep(2000);
	    driver.findElement(By.linkText("��һ��")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("��һ��")).click();
	    Thread.sleep(2000);
        
	}
	@Test(priority=9)
	public void Score() throws Exception {
		//��֤������formҳ���ж��ٸ������򣬻�����ʾ���ٸ�"��ѡ��"��
	
//		 List<WebElement> elements = driver.findElements(By.xpath("//*[text()='��ѡ��']")); 
//		 int number=elements.size();//��������525ʱ�ܹ���8����С�ڵ���525ʱ��12��
//		 System.out.println(number);
//		 Assert.assertEquals(number,12);
		 List<WebElement> elements = driver.findElements(By.tagName("select")); 
		 int number=elements.size();//��������525ʱ�ܹ���8����С�ڵ���525ʱ��12��
		 System.out.println(number);
		 String score=driver.findElement(By.id("SCORE")).getAttribute("value");
		 int score1=Integer.parseInt(score);
		 System.out.println(score1);
		 if (score1>525){
			if (number==8){
				System.out.println("��ֿ�����Ϊ"+score1+"���������Ϊ4");
				 Thread.sleep(2000);
				new Select(driver.findElement(By.name("MCRE02"))).selectByVisibleText("��Ϣ����֤");
				new Select(driver.findElement(By.name("MCRE03"))).selectByVisibleText("��Ϣ����֤");
				new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText("RES01");
				new Select(driver.findElement(By.name("MCRH07"))).selectByVisibleText("��Ϣ����֤");
			}
		 }
			else
				{if(number==12){
					System.out.println("��ֿ�����Ϊ"+score1+"���������Ϊ7");
					Thread.sleep(2000);
					new Select(driver.findElement(By.name("MCRE02"))).selectByVisibleText("��Ϣ��֤ʧ��");//�����˰칫�绰��ʵ:
					new Select(driver.findElement(By.name("MCRE020401"))).selectByVisibleText("�����˲��ڴ˹���");
				    new Select(driver.findElement(By.name("MCRE03"))).selectByVisibleText("��Ϣ����֤");//�������ֻ��绰��ʵ:
				    new Select(driver.findElement(By.name("MCRG05"))).selectByVisibleText("��˾���͵�ַ��һ��");//ID5�칫�绰�˲�
				    new Select(driver.findElement(By.name("MCRH06"))).selectByVisibleText("��Ϣ��֤ʧ��");//������������ϵ�˵��ֻ��绰��ʵ:
				    new Select(driver.findElement(By.name("MCRH060301"))).selectByVisibleText("���벻����������ϵ��");
				    new Select(driver.findElement(By.name("MCRM05"))).selectByVisibleText("��Ϣ��֤ʧ��");//�����˼�ͥ�����绰��ʵ:
				    new Select(driver.findElement(By.name("MCRH07"))).selectByVisibleText("��Ϣ��֤ʧ��");//�����˼�ͥ��Ա�绰��ʵ:
				    new Select(driver.findElement(By.name("MCRH070301"))).selectByVisibleText("����");
				    new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText("RES01");//�����жϽ��:
				}
		 }
		 Thread.sleep(2000);
		    driver.findElement(By.linkText("�ݴ�")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
			}
	


	 
	@AfterTest
	public void afterTest() {
	}

}
