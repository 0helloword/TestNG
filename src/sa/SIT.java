//sit����eclipse�����У���ز���ֻ���ڴ�����ֱ���޸�
//�ɽ��Maintest���ɿ�ִ���ļ������ǲ����̶�

package sa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
public class SIT {
	WebDriver driver;	    
	
	@BeforeTest
	  public void beforeTest() {
			driver = new FirefoxDriver();
			driver.get("http://123.57.56.45:10080/cnsa/initLogin");
			driver.manage().window().maximize();// �������
			//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);//��ʽ�ȴ�,���Driverÿ��ִ��������ִ��ʱ��,Ҳ�������Ϊ��ʱʱ��
	  }
	
	@Test(priority=1)
	public void testlogin() throws Exception {
		driver.findElement(By.id("username")).sendKeys("998866");// �����¼�û���
		driver.findElement(By.id("password")).sendKeys("cyj123");// �����¼����
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // �����¼
		Thread.sleep(5000);// �ȴ�ʱ�䵥λΪ����
		String verify = driver.findElement(By.className("username")).getText();
		assert verify.contains("���");// ������ assertion
  }
	@Test(priority=2)
	public void neworder1() throws InterruptedException{
		//��������
		driver.findElement(By.linkText("��������")).click();
	    new Select(driver.findElement(By.id("storeId"))).selectByVisibleText("�������ŵ�1");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("careerType"))).selectByVisibleText("��ְ��Ա");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("productSeriesId"))).selectByVisibleText("�ֻ�");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.name("goodsReqs[0].cargoType"))).selectByVisibleText("�ֻ�");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("commodityClass_0"))).selectByVisibleText("�ֻ����");

	    Thread.sleep(1000);
	    driver.findElement(By.id("commodityName_0")).clear();
	    driver.findElement(By.id("commodityName_0")).sendKeys("�����");
	    Thread.sleep(1000);
	    driver.findElement(By.id("commodityType_0")).clear();
	    driver.findElement(By.id("commodityType_0")).sendKeys("001");
	    driver.findElement(By.name("goodsReqs[0].commodityPrice")).clear();
	    driver.findElement(By.name("goodsReqs[0].commodityPrice")).sendKeys("5000");
	    Thread.sleep(1000);
	    driver.findElement(By.id("amount")).click();
	    driver.findElement(By.id("downPaymentAmount")).clear();
	    driver.findElement(By.id("downPaymentAmount")).sendKeys("2000");
	    Thread.sleep(1000);
	    driver.findElement(By.id("loanMoney")).click();
	    driver.findElement(By.cssSelector("button.btn.blue-madison")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.name("productId")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("submitBtn")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("ensure_sn")).click();
	}
	@Test(priority=3)
	public void neworder2() throws InterruptedException{
	    //������Ϣ
	    Thread.sleep(2000);
	    driver.findElement(By.id("customerName")).clear();
	    driver.findElement(By.id("customerName")).sendKeys("�ƿ���");//�޸�����--�û���
	    driver.findElement(By.id("cardId")).clear();
	    driver.findElement(By.id("cardId")).sendKeys("411203199106111576");//�޸�����--���֤��
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18178848485");//�޸�����--�绰����
	    new Select(driver.findElement(By.id("repaymentType"))).selectByVisibleText("���д���");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("repaymentBank"))).selectByVisibleText("�й���������");
	    driver.findElement(By.id("repaymentAcc")).clear();
	    driver.findElement(By.id("repaymentAcc")).sendKeys("44442789978423455");//�޸�����--�����˺�
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("province"))).selectByVisibleText("�㶫ʡ");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("city"))).selectByVisibleText("������");
	    driver.findElement(By.id("bankTel")).clear();
	    driver.findElement(By.id("bankTel")).sendKeys("13347221234");
	    driver.findElement(By.cssSelector("button.btn.blue-madison")).click();
	    Thread.sleep(2000);
	}
	@Test(priority=4)
	public void neworder3() throws InterruptedException{
	    //�ϴ�����
		Thread.sleep(3000);
	  	String order=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/div/div[2]/div/div/div/div/p/strong")).getText();
	  	System.out.print("�ö������Ϊ:"+order+"\n\n");
	    Thread.sleep(2000);
	    String s1=driver.findElement(By.xpath("//input[9]")).getAttribute("id");
	    System.out.print(s1+"\n");//��ȡ��һ���ϴ�������id  file_0_35440869_1000001_72
	    String ss1=s1.substring(0,16);//��ȡfile_0_35440869_
	    //System.out.print(ss1+"\n");
	    int ss2=Integer.parseInt(s1.substring(16, 23));//��ȡ1000001
	    //System.out.print(ss2+"\n");
	    int ss4=Integer.parseInt(s1.substring(24,s1.length()));//��ȡ72
	    //System.out.print(ss4+"\n");
	    String s2=ss1+Integer.toString(ss2+1)+"_"+Integer.toString(ss4+1);//�ڶ����ϴ�����id file_0_35440869_1000002_73
	    //System.out.print(s2+"\n");
	    String s3=ss1+Integer.toString(ss2+2)+"_"+Integer.toString(ss4+2);//�������ϴ�����id file_0_35440869_1000003_74
	    String s4=ss1+Integer.toString(ss2+3)+"_"+Integer.toString(ss4+3);//���ĸ��ϴ�����id file_0_35440869_1000004_75
	    driver.findElement(By.id(s1)).sendKeys("E:\\test1.jpg"); 
	    Thread.sleep(3000);
	    driver.findElement(By.id(s2)).sendKeys("E:\\test1.jpg"); 
	    Thread.sleep(3000);
	    driver.findElement(By.id(s3)).sendKeys("E:\\test1.jpg"); 
	    Thread.sleep(3000);
	    driver.findElement(By.id(s4)).sendKeys("E:\\test1.jpg"); 
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("button.btn.blue-madison")).click();
	}
	@Test(priority=5)
	public void neworder4() throws InterruptedException{
		//������Ϣ
	    //��������
		Thread.sleep(3000);
	    driver.findElement(By.name("issuingOrgan")).clear();
	    driver.findElement(By.name("issuingOrgan")).sendKeys("���ڹ�����");
	    Thread.sleep(2000);
	    driver.findElement(By.id("idCardValidity")).click();
	    driver.findElement(By.className("today")).click();
	    new Select(driver.findElement(By.id("degree"))).selectByVisibleText("��");
	    driver.findElement(By.id("emaill")).clear();
	    driver.findElement(By.id("emaill")).sendKeys("5315698@qq.com");//�޸��]��
	    driver.findElement(By.name("qqCode")).clear();
	    driver.findElement(By.name("qqCode")).sendKeys("5114739995");//�޸�QQ����
	    new Select(driver.findElement(By.name("marry"))).selectByVisibleText("δ��");
	    new Select(driver.findElement(By.name("liveCondition"))).selectByVisibleText("�Խ�/���򷿲�");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("householdProv"))).selectByVisibleText("�㶫ʡ");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("householdCity"))).selectByVisibleText("������");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("householdTown"))).selectByVisibleText("�޺���");
	    driver.findElement(By.id("householdZhen")).clear();
	    driver.findElement(By.id("householdZhen")).sendKeys("�����´�");
	    driver.findElement(By.id("householdStr")).clear();
	    driver.findElement(By.id("householdStr")).sendKeys("�Ľ�·");
	    driver.findElement(By.id("householdRidge")).clear();
	    driver.findElement(By.id("householdRidge")).sendKeys("10��");
	    driver.findElement(By.id("householdHome")).clear();
	    driver.findElement(By.id("householdHome")).sendKeys("101");
	    new Select(driver.findElement(By.id("addreRegist"))).selectByVisibleText("��ͬ");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.name("postState"))).selectByVisibleText("����סַ��ͬ");
	    Thread.sleep(2000);
	    //������Ϣ
	    driver.findElement(By.id("monthlyIncome")).clear();
	    driver.findElement(By.id("monthlyIncome")).sendKeys("5000");
	    driver.findElement(By.id("familyIncome")).clear();
	    driver.findElement(By.id("familyIncome")).sendKeys("6000");
	    driver.findElement(By.id("monthlySpending")).clear();
	    driver.findElement(By.id("monthlySpending")).sendKeys("1000");
	    Thread.sleep(2000);
	    //ְҵ��Ϣ
	    driver.findElement(By.id("firstWorktime")).click();//��λ�����б��е����,Ϊ��ҳ�治����ݵ�����ס������д����
	    driver.findElement(By.xpath("/html/body/div[6]/div[3]/table/tbody/tr/td/span[5]")).click();
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("industry"))).selectByVisibleText("��ҵ��λ��������ʩ��ҽ����������ᱣ�Ϻ���ḣ��ҵ");
	    driver.findElement(By.name("unitname")).clear();
	    driver.findElement(By.name("unitname")).sendKeys("���Թ�˾");
	    driver.findElement(By.name("department")).clear();
	    driver.findElement(By.name("department")).sendKeys("���Բ�");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("industryType"))).selectByVisibleText("������ʩ����ҵ");
	    new Select(driver.findElement(By.id("careerType"))).selectByVisibleText("һ��ҽ��������Ա��һ��ҽʦ����ʿ��������Ա");
	    driver.findElement(By.name("unitPhone")).clear();
	    driver.findElement(By.name("unitPhone")).sendKeys("07557895656");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.name("duty"))).selectByVisibleText("�߲������Ա/�ܼ�����/�ּ����ϸɲ�");
	    Thread.sleep(2000);
	    driver.findElement(By.id("unitWorktime")).clear();
	    driver.findElement(By.id("unitWorktime")).sendKeys("10");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("unitAddre"))).selectByVisibleText("�㶫ʡ");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("unitCity"))).selectByVisibleText("������");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("unitTown"))).selectByVisibleText("��ɽ��");
	    driver.findElement(By.id("unitZhen")).clear();
	    driver.findElement(By.id("unitZhen")).sendKeys("��ݴ�");
	    driver.findElement(By.name("unitRidge")).clear();
	    driver.findElement(By.name("unitRidge")).sendKeys("���·");
	    driver.findElement(By.name("unitStr")).clear();
	    driver.findElement(By.name("unitStr")).sendKeys("1��");
	    driver.findElement(By.name("unitHome")).clear();
	    driver.findElement(By.name("unitHome")).sendKeys("101");
	    Thread.sleep(2000);
	    //��ϵ����Ϣ
	    new Select(driver.findElement(By.id("contractType_0"))).selectByVisibleText("����");
	    driver.findElement(By.name("contractInfos[0].contractName")).clear();
	    driver.findElement(By.name("contractInfos[0].contractName")).sendKeys("�º���");
	    driver.findElement(By.name("contractInfos[0].contractPhone")).clear();
	    driver.findElement(By.name("contractInfos[0].contractPhone")).sendKeys("15257891545");//�޸ļ�ͥ��ϵ�˺���
	    driver.findElement(By.name("contractInfos[0].contactWeixin")).clear();
	    driver.findElement(By.name("contractInfos[0].contactWeixin")).sendKeys("526878956");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("contractType_1"))).selectByVisibleText("����");
	    driver.findElement(By.name("contractInfos[1].contractName")).clear();
	    driver.findElement(By.name("contractInfos[1].contractName")).sendKeys("�޴���");
	    driver.findElement(By.name("contractInfos[1].contractPhone")).clear();
	    driver.findElement(By.name("contractInfos[1].contractPhone")).sendKeys("18945894456");//�޸ķǼ�ͥ��ϵ�˺���
	    driver.findElement(By.name("contractInfos[1].contactWeixin")).clear();
	    driver.findElement(By.name("contractInfos[1].contactWeixin")).sendKeys("854697455");
	    Thread.sleep(2000);
	    //Э����Ϣ
	    driver.findElement(By.name("checkApplyInfo")).click();
	    driver.findElement(By.name("mattersNeed")).click();
	    driver.findElement(By.name("checkMobile")).click();
	    driver.findElement(By.name("checkTel")).click();
	    Thread.sleep(2000);
	    //������Ϣ
	    new Select(driver.findElement(By.name("accompany"))).selectByVisibleText("0");
	    driver.findElement(By.name("accApply")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.name("accName")).clear();
	    driver.findElement(By.name("accName")).sendKeys("��ͬ��");
	    driver.findElement(By.name("accMobile")).clear();
	    driver.findElement(By.name("accMobile")).sendKeys("17895645527");
	    Thread.sleep(1000);
	    driver.findElement(By.name("mobileBrand")).clear();
	    driver.findElement(By.name("mobileBrand")).sendKeys("��Ϊ");
	    driver.findElement(By.name("stortFamKm")).clear();
	    driver.findElement(By.name("stortFamKm")).sendKeys("1");
	    driver.findElement(By.name("famComKm")).clear();
	    driver.findElement(By.name("famComKm")).sendKeys("1");
	    driver.findElement(By.name("stortComKm")).clear();
	    driver.findElement(By.name("stortComKm")).sendKeys("1");
	    //��֤��Ϣ
	    new Select(driver.findElement(By.name("userEvaluate"))).selectByVisibleText("1");
	    driver.findElement(By.id("userEvaluateCode")).clear();
	    Thread.sleep(2000);
	    driver.findElement(By.id("userEvaluateCode")).sendKeys("cyj123");//���ݸ��˵�¼������д
	    //driver.findElement(By.id("save_but")).click();
	    driver.findElement(By.id("draft_but")).click();//����ݸ�
	}
	
	
 /* @AfterTest
  public void afterTest() {
	  driver.close();
  }
*/
	
}
