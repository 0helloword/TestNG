package oc;

//OC�˹�������ˣ���xml��ȡ����
//ֱ����eclipse����б�ѡ��xml�ļ�����
//��δ������⣺���ĸ�ҳ���������ԭ�����޷���λԪ��
//������֤��˶�����������
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class oc_check {
	WebDriver driver;

	
	@Parameters({ "url", "username", "password" })
	@Test(priority = 1)
	
	public void login(String url, String username, String password)
			throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();// �������
		driver.findElement(By.id("username")).sendKeys(username);// �����¼�û���
		driver.findElement(By.id("password")).sendKeys(password);// �����¼����
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // �����¼
	}


	
	@Test(priority =2)
	public void check() throws InterruptedException {
		//Thread.sleep(3000);
		//driver.findElement(By.cssSelector("button.ui-dialog-close")).click();// �ر���绰
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[4]/a/span")).click();// �˹����
		Thread.sleep(1000);
		driver.findElement(By.linkText("������ˣ�POS��")).click();
		driver.findElement(By.linkText("�������")).click();
	}

	@Test(priority = 3)
	public void NCIIC_Check() throws Exception {
		/** ���NCIIC�˹���������б��ѡ�� */
		// Ԥ�ڵ�ѡ������StateOptions
		List<String> StateOptions = Arrays.asList(new String[] { "��ѡ��",
				"��Ϣһ�£���Ƭ��һ��", "��Ϣ����Ƭ��һ��", "��Ϣ��һ��", "��Ϣһ�£���NCIIC������Ƭ", "û���ҵ���¼",
				"����NCIICʧ��", "δ��" });
		int size1 = StateOptions.size();
		/** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/
		Thread.sleep(2000);
		Select selectState = new Select(driver.findElement(By.name("MCRG01"))); // ͨ��name���Զ�λ��NCIIC��
		Assert.assertFalse(selectState.isMultiple());// ��֤�����б�֧�ֶ�ѡ
		List<String> act_StateOptions = new ArrayList<String>();
		// �ж�ѡ������
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState.getOptions()) {
			// e.click();
			// ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�
			act_StateOptions.add(e.getText());
		}
		Assert.assertEquals(StateOptions.toArray(), act_StateOptions.toArray());
		System.out.println("NCIIC�˹����--�����б�" + size1 + "�ѡ����ʾ��ȷ");
	}

	@Test(priority = 4)
	public void NCIIC_Pic() throws Exception {
		/** ���NCIIC��Ƭ�Ա������б��ѡ�� */
		// Ԥ�ڵ�ѡ������StateOptions
		List<String> StateOptions2 = Arrays.asList(new String[] { "��ѡ��",
				"��Ƭһ��", "��Ƭ��һ��", "δ��" });
		int size2 = StateOptions2.size();
		/** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/
		Thread.sleep(2000);
		Select selectState2 = new Select(driver.findElement(By.name("MCRG02")));
		Assert.assertFalse(selectState2.isMultiple());// ��֤�����б�֧�ֶ�ѡ
		List<String> act_StateOptions2 = new ArrayList<String>();
		// �ж�ѡ������
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState2.getOptions()) {
			// e.click();
			// ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�
			act_StateOptions2.add(e.getText());
		}
		Assert.assertEquals(StateOptions2.toArray(),
				act_StateOptions2.toArray());
		System.out.println("NCIIC��Ƭ�Ա�--�����б�" + size2 + "�ѡ����ʾ��ȷ");

	}

	
	@Parameters({ "NCIIC", "NCIICp" })
	@Test(priority = 5)
	public void Part1(String NCIIC, String NCIICp) throws Exception {
		new Select(driver.findElement(By.name("MCRG01")))
				.selectByVisibleText(NCIIC);
		new Select(driver.findElement(By.name("MCRG02")))
				.selectByVisibleText(NCIICp);
		Thread.sleep(2000);
	        if ("��Ϣһ�£���Ƭ��һ��".equals(NCIIC) | "û���ҵ���¼".equals(NCIIC)|"��Ϣ��һ��".equals(NCIIC))
	        	{System.out.println("NCIIC=-50");
	        	}
	        else  //((NCIIC=="��Ϣ����Ƭ��һ��")||(NCIIC=="��Ϣһ�£���NCIIC������Ƭ")||(NCIIC=="����NCIICʧ��")|| (NCIIC=="δ��"))
	        	{System.out.println("NCIIC=0");
	        	}
	        driver.findElement(By.linkText("��һ��")).click();
	}

	@Test(priority = 6)
	public void SheBao() throws Exception {
		/** ����籣��Ϣ��ʵ�����б��ѡ�� */
		// Ԥ�ڵ�ѡ������StateOptions
		List<String> StateOptions3 = Arrays.asList(new String[] { "��ѡ��",
				"�籣��λ�����������һ��", "�籣��λ�����������һ��", "���籣", "�޷���֤�籣��Ϣ", "����",
				"��թ����", "δ��" });
		int size1 = StateOptions3.size();
		/** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/
		Thread.sleep(2000);
		Select selectState3 = new Select(driver.findElement(By.name("MCRG03"))); // ͨ��name���Զ�λ���籣ѡ��
		Assert.assertFalse(selectState3.isMultiple());// ��֤�����б�֧�ֶ�ѡ
		List<String> act_StateOptions3 = new ArrayList<String>(); // ʵ����һ��list��
		// �ж�ѡ������
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState3.getOptions()) {
			// e.click();
			// ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�
			act_StateOptions3.add(e.getText());
		}
		Assert.assertEquals(StateOptions3.toArray(),
				act_StateOptions3.toArray());
		System.out.println("�籣��Ϣ��ʵ--�����б�" + size1 + "�ѡ����ʾ��ȷ");
	}

	@Test(priority = 7)
	public void xuexin() throws Exception {
		/** ���ѧ������Ϣ��ʵ�����б��ѡ�� */
		// Ԥ�ڵ�ѡ������StateOptions
		List<String> StateOptions4 = Arrays.asList(new String[] { "��ѡ��", "δ��",
				"ѧ����һ��", "ѧ������һ��", "��ѧ��", "����" });
		int size1 = StateOptions4.size();
		Thread.sleep(2000);
		/** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/
		Select selectState4 = new Select(driver.findElement(By.name("MCRG11")));
		Assert.assertFalse(selectState4.isMultiple());// ��֤�����б�֧�ֶ�ѡ
		List<String> act_StateOptions4 = new ArrayList<String>();
		// �ж�ѡ������
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState4.getOptions()) {
			// e.click();
			// ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�
			act_StateOptions4.add(e.getText());
		}
		Assert.assertEquals(StateOptions4.toArray(),
				act_StateOptions4.toArray());
		System.out.println("ѧ������Ϣ��ʵ--�����б�" + size1 + "�ѡ����ʾ��ȷ");
	}

	@Test(priority = 8)
	public void Sell_Pic() throws Exception {
		/** ���������Ƭ�Ա������б��ѡ�� */
		// Ԥ�ڵ�ѡ������StateOptions
		List<String> StateOptions5 = Arrays.asList(new String[] { "��ѡ��",
				"��Ƭһ��", "��Ƭ��һ��", "�޷��ж�" });
		int size2 = StateOptions5.size();
		Thread.sleep(2000);
		/** ����һ�������б�����ѡ���click����ѡ��ѡ�� **/
		Select selectState5 = new Select(driver.findElement(By.name("PSA01")));
		Assert.assertFalse(selectState5.isMultiple());// ��֤�����б�֧�ֶ�ѡ
		List<String> act_StateOptions5 = new ArrayList<String>();
		// �ж�ѡ������
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState5.getOptions()) {
			// e.click();
			// ��ʵ�ʵ������б�����ע�뵽act_StateOptions�У����бȽϡ�
			act_StateOptions5.add(e.getText());
		}
		Assert.assertEquals(StateOptions5.toArray(),
				act_StateOptions5.toArray());
		System.out.println("������Ƭ�Ա�--�����б�" + size2 + "�ѡ����ʾ��ȷ");
	}

	@Test(priority = 9)
	@Parameters({ "SheBao", "XueXin", "SellPic" })
	public void Part2(String SheBao, String XueXin, String SellPic)
			throws Exception {
		new Select(driver.findElement(By.name("MCRG03")))
				.selectByVisibleText(SheBao);
		new Select(driver.findElement(By.name("MCRG11")))
				.selectByVisibleText(XueXin);
		new Select(driver.findElement(By.name("PSA01")))
				.selectByVisibleText(SellPic);
		Thread.sleep(2000);
		
		if
		("�籣��λ�����������һ��".equals(SheBao) |  "���籣".equals(SheBao)
				| "�޷���֤�籣��Ϣ".equals(SheBao) | "����".equals(SheBao)
				| "δ��".equals(SheBao)) {
			System.out.println("�籣=0");
		} 
		else if ("�籣��λ�����������һ��".equals(SheBao)) {
			System.out.println("�籣=1");
		} 
		else 
		{
			System.out.println("�籣=-50");
		}
		System.out.println("ѧ����=0");
		driver.findElement(By.linkText("��һ��")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("��һ��")).click();
	}
	
		
		
	@Test(priority = 10)//����������Ԫ���޷���λ�������⻹δ���
	@Parameters({"OfficeTelephone","OfficeTelephone1","Phone","Phone1","Check","FamilyPhone","FamilyPhone1",
		"Familytelephone","Otherphone","Otherphone1","ID5" })
	public void Part4(String OfficeTelephone, String OfficeTelephone1,String Phone,String Phone1,String Check,
			String FamilyPhone,String FamilyPhone1,String Familytelephone,String Otherphone,String Otherphone1,String ID5)
			throws Exception {
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.tagName("select")); 
		 int number=elements.size();//��������525ʱ�ܹ���8����С�ڵ���525ʱ��12��
		 //System.out.println(number);
		 String score=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/form/div/div/div/div[9]/div[2]")).getText();
		 int score1=Integer.parseInt(score);
		 //System.out.println(score1);
		 if (score1>525){
			if (number==8){
				System.out.println("��ֿ�����Ϊ"+score1+"���������Ϊ4");
				 Thread.sleep(2000);
				new Select(driver.findElement(By.name("MCRE02"))).selectByVisibleText(OfficeTelephone);
				if (OfficeTelephone.equals("��Ϣ��֤ʧ��")){
					new Select(driver.findElement(By.name("MCRE020401"))).selectByVisibleText(OfficeTelephone1);
				}
				new Select(driver.findElement(By.name("MCRE03"))).selectByVisibleText(Phone);
				if (Phone.equals("��Ϣ��֤ʧ��")){
			    	new Select(driver.findElement(By.name("MCRE030301"))).selectByVisibleText(Phone1);
			    }
				new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText(Check);
				new Select(driver.findElement(By.name("MCRH07"))).selectByVisibleText(FamilyPhone);
				 if (Otherphone.equals("��Ϣ��֤ʧ��")){
			    	 new Select(driver.findElement(By.name("MCRH070301"))).selectByVisibleText(FamilyPhone1);
			    }
			}
		 }
			else
				{if(number==12){
					System.out.println("��ֿ�����Ϊ"+score1+"���������Ϊ7");
					Thread.sleep(2000);
					//���ƹ�����
					//driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/form/div/div[2]")).sendKeys(Keys.UP);
					//Thread.sleep(2000);
					new Select(driver.findElement(By.name("MCRE02"))).selectByVisibleText(OfficeTelephone);//�����˰칫�绰��ʵ:
					Thread.sleep(1000);
					  new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText(Check);//�����жϽ��:
//					if (OfficeTelephone.equals("��Ϣ��֤ʧ��")){
//						new Select(driver.findElement(By.name("MCRE020401"))).selectByVisibleText(OfficeTelephone1);
//					}
					
					
				    new Select(driver.findElement(By.name("MCRE03"))).selectByVisibleText(Phone);//�������ֻ��绰��ʵ:
//				    if (Phone.equals("��Ϣ��֤ʧ��")){
//				    	new Select(driver.findElement(By.name("MCRE030301"))).selectByVisibleText(Phone1);
//				    }
				    new Select(driver.findElement(By.name("MCRG05"))).selectByVisibleText(ID5);//ID5�칫�绰�˲�
				    Thread.sleep(1000);
				    new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText(Check);//�����жϽ��:
				    Thread.sleep(1000);
				    new Select(driver.findElement(By.name("MCRH06"))).selectByVisibleText(Otherphone);//������������ϵ�˵��ֻ��绰��ʵ:
				    if (Otherphone.equals("��Ϣ��֤ʧ��")){
				    	 new Select(driver.findElement(By.name("MCRH060301"))).selectByVisibleText(Otherphone1);
					}
				    new Select(driver.findElement(By.name("MCRH07"))).selectByVisibleText(FamilyPhone);//�����˼�ͥ��Ա�绰��ʵ:
				    if (Otherphone.equals("��Ϣ��֤ʧ��")){
				    	 new Select(driver.findElement(By.name("MCRH070301"))).selectByVisibleText(FamilyPhone1);
				    }
				  
				    new Select(driver.findElement(By.name("MCRM05"))).selectByVisibleText(Familytelephone);//�����˼�ͥ�����绰��ʵ:
				 							}
		 }
		 Thread.sleep(2000);
		    driver.findElement(By.linkText("�ݴ�")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	}
		}


	