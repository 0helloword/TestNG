//sit仅在eclipse中运行，相关参数只能在代码中直接修改
//可结合Maintest生成可执行文件，但是参数固定

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
			driver.manage().window().maximize();// 窗口最大化
			//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);//隐式等待,针对Driver每次执行命令的最长执行时间,也可以理解为超时时间
	  }
	
	@Test(priority=1)
	public void testlogin() throws Exception {
		driver.findElement(By.id("username")).sendKeys("998866");// 输入登录用户名
		driver.findElement(By.id("password")).sendKeys("cyj123");// 输入登录密码
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // 点击登录
		Thread.sleep(5000);// 等待时间单位为毫秒
		String verify = driver.findElement(By.className("username")).getText();
		assert verify.contains("你好");// 做断言 assertion
  }
	@Test(priority=2)
	public void neworder1() throws InterruptedException{
		//新增申请
		driver.findElement(By.linkText("新增工单")).click();
	    new Select(driver.findElement(By.id("storeId"))).selectByVisibleText("竹子林门店1");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("careerType"))).selectByVisibleText("在职人员");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("productSeriesId"))).selectByVisibleText("手机");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.name("goodsReqs[0].cargoType"))).selectByVisibleText("手机");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("commodityClass_0"))).selectByVisibleText("手机配件");

	    Thread.sleep(1000);
	    driver.findElement(By.id("commodityName_0")).clear();
	    driver.findElement(By.id("commodityName_0")).sendKeys("充电器");
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
	    //贷款信息
	    Thread.sleep(2000);
	    driver.findElement(By.id("customerName")).clear();
	    driver.findElement(By.id("customerName")).sendKeys("黄看豆");//修改数据--用户姓
	    driver.findElement(By.id("cardId")).clear();
	    driver.findElement(By.id("cardId")).sendKeys("411203199106111576");//修改数据--身份证号
	    driver.findElement(By.id("mobile")).clear();
	    driver.findElement(By.id("mobile")).sendKeys("18178848485");//修改数据--电话号码
	    new Select(driver.findElement(By.id("repaymentType"))).selectByVisibleText("银行代扣");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("repaymentBank"))).selectByVisibleText("中国工商银行");
	    driver.findElement(By.id("repaymentAcc")).clear();
	    driver.findElement(By.id("repaymentAcc")).sendKeys("44442789978423455");//修改数据--银行账号
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("province"))).selectByVisibleText("广东省");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("city"))).selectByVisibleText("深圳市");
	    driver.findElement(By.id("bankTel")).clear();
	    driver.findElement(By.id("bankTel")).sendKeys("13347221234");
	    driver.findElement(By.cssSelector("button.btn.blue-madison")).click();
	    Thread.sleep(2000);
	}
	@Test(priority=4)
	public void neworder3() throws InterruptedException{
	    //上传资料
		Thread.sleep(3000);
	  	String order=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/div/div[2]/div/div/div/div/p/strong")).getText();
	  	System.out.print("该订单编号为:"+order+"\n\n");
	    Thread.sleep(2000);
	    String s1=driver.findElement(By.xpath("//input[9]")).getAttribute("id");
	    System.out.print(s1+"\n");//获取第一个上传按键的id  file_0_35440869_1000001_72
	    String ss1=s1.substring(0,16);//获取file_0_35440869_
	    //System.out.print(ss1+"\n");
	    int ss2=Integer.parseInt(s1.substring(16, 23));//获取1000001
	    //System.out.print(ss2+"\n");
	    int ss4=Integer.parseInt(s1.substring(24,s1.length()));//获取72
	    //System.out.print(ss4+"\n");
	    String s2=ss1+Integer.toString(ss2+1)+"_"+Integer.toString(ss4+1);//第二个上传按键id file_0_35440869_1000002_73
	    //System.out.print(s2+"\n");
	    String s3=ss1+Integer.toString(ss2+2)+"_"+Integer.toString(ss4+2);//第三个上传按键id file_0_35440869_1000003_74
	    String s4=ss1+Integer.toString(ss2+3)+"_"+Integer.toString(ss4+3);//第四个上传按键id file_0_35440869_1000004_75
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
		//基础信息
	    //个人资料
		Thread.sleep(3000);
	    driver.findElement(By.name("issuingOrgan")).clear();
	    driver.findElement(By.name("issuingOrgan")).sendKeys("深圳公安局");
	    Thread.sleep(2000);
	    driver.findElement(By.id("idCardValidity")).click();
	    driver.findElement(By.className("today")).click();
	    new Select(driver.findElement(By.id("degree"))).selectByVisibleText("大本");
	    driver.findElement(By.id("emaill")).clear();
	    driver.findElement(By.id("emaill")).sendKeys("5315698@qq.com");//修改郵箱
	    driver.findElement(By.name("qqCode")).clear();
	    driver.findElement(By.name("qqCode")).sendKeys("5114739995");//修改QQ号码
	    new Select(driver.findElement(By.name("marry"))).selectByVisibleText("未婚");
	    new Select(driver.findElement(By.name("liveCondition"))).selectByVisibleText("自建/购买房产");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("householdProv"))).selectByVisibleText("广东省");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("householdCity"))).selectByVisibleText("深圳市");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("householdTown"))).selectByVisibleText("罗湖区");
	    driver.findElement(By.id("householdZhen")).clear();
	    driver.findElement(By.id("householdZhen")).sendKeys("湖贝新村");
	    driver.findElement(By.id("householdStr")).clear();
	    driver.findElement(By.id("householdStr")).sendKeys("文锦路");
	    driver.findElement(By.id("householdRidge")).clear();
	    driver.findElement(By.id("householdRidge")).sendKeys("10栋");
	    driver.findElement(By.id("householdHome")).clear();
	    driver.findElement(By.id("householdHome")).sendKeys("101");
	    new Select(driver.findElement(By.id("addreRegist"))).selectByVisibleText("相同");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.name("postState"))).selectByVisibleText("与现住址相同");
	    Thread.sleep(2000);
	    //收入信息
	    driver.findElement(By.id("monthlyIncome")).clear();
	    driver.findElement(By.id("monthlyIncome")).sendKeys("5000");
	    driver.findElement(By.id("familyIncome")).clear();
	    driver.findElement(By.id("familyIncome")).sendKeys("6000");
	    driver.findElement(By.id("monthlySpending")).clear();
	    driver.findElement(By.id("monthlySpending")).sendKeys("1000");
	    Thread.sleep(2000);
	    //职业信息
	    driver.findElement(By.id("firstWorktime")).click();//定位下拉列表中的年份,为了页面不将年份弹窗挡住，先填写该项
	    driver.findElement(By.xpath("/html/body/div[6]/div[3]/table/tbody/tr/td/span[5]")).click();
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("industry"))).selectByVisibleText("事业单位、公共设施、医疗卫生、社会保障和社会福利业");
	    driver.findElement(By.name("unitname")).clear();
	    driver.findElement(By.name("unitname")).sendKeys("测试公司");
	    driver.findElement(By.name("department")).clear();
	    driver.findElement(By.name("department")).sendKeys("测试部");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("industryType"))).selectByVisibleText("公共设施管理业");
	    new Select(driver.findElement(By.id("careerType"))).selectByVisibleText("一般医务行政人员、一般医师及护士、病理检查员");
	    driver.findElement(By.name("unitPhone")).clear();
	    driver.findElement(By.name("unitPhone")).sendKeys("07557895656");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.name("duty"))).selectByVisibleText("高层管理人员/总监以上/局级以上干部");
	    Thread.sleep(2000);
	    driver.findElement(By.id("unitWorktime")).clear();
	    driver.findElement(By.id("unitWorktime")).sendKeys("10");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("unitAddre"))).selectByVisibleText("广东省");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("unitCity"))).selectByVisibleText("深圳市");
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("unitTown"))).selectByVisibleText("南山区");
	    driver.findElement(By.id("unitZhen")).clear();
	    driver.findElement(By.id("unitZhen")).sendKeys("茶馆村");
	    driver.findElement(By.name("unitRidge")).clear();
	    driver.findElement(By.name("unitRidge")).sendKeys("茶光路");
	    driver.findElement(By.name("unitStr")).clear();
	    driver.findElement(By.name("unitStr")).sendKeys("1栋");
	    driver.findElement(By.name("unitHome")).clear();
	    driver.findElement(By.name("unitHome")).sendKeys("101");
	    Thread.sleep(2000);
	    //联系人信息
	    new Select(driver.findElement(By.id("contractType_0"))).selectByVisibleText("父亲");
	    driver.findElement(By.name("contractInfos[0].contractName")).clear();
	    driver.findElement(By.name("contractInfos[0].contractName")).sendKeys("陈浩明");
	    driver.findElement(By.name("contractInfos[0].contractPhone")).clear();
	    driver.findElement(By.name("contractInfos[0].contractPhone")).sendKeys("15257891545");//修改家庭联系人号码
	    driver.findElement(By.name("contractInfos[0].contactWeixin")).clear();
	    driver.findElement(By.name("contractInfos[0].contactWeixin")).sendKeys("526878956");
	    Thread.sleep(2000);
	    new Select(driver.findElement(By.id("contractType_1"))).selectByVisibleText("亲属");
	    driver.findElement(By.name("contractInfos[1].contractName")).clear();
	    driver.findElement(By.name("contractInfos[1].contractName")).sendKeys("罗大佑");
	    driver.findElement(By.name("contractInfos[1].contractPhone")).clear();
	    driver.findElement(By.name("contractInfos[1].contractPhone")).sendKeys("18945894456");//修改非家庭联系人号码
	    driver.findElement(By.name("contractInfos[1].contactWeixin")).clear();
	    driver.findElement(By.name("contractInfos[1].contactWeixin")).sendKeys("854697455");
	    Thread.sleep(2000);
	    //协审信息
	    driver.findElement(By.name("checkApplyInfo")).click();
	    driver.findElement(By.name("mattersNeed")).click();
	    driver.findElement(By.name("checkMobile")).click();
	    driver.findElement(By.name("checkTel")).click();
	    Thread.sleep(2000);
	    //其他信息
	    new Select(driver.findElement(By.name("accompany"))).selectByVisibleText("0");
	    driver.findElement(By.name("accApply")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.name("accName")).clear();
	    driver.findElement(By.name("accName")).sendKeys("陪同人");
	    driver.findElement(By.name("accMobile")).clear();
	    driver.findElement(By.name("accMobile")).sendKeys("17895645527");
	    Thread.sleep(1000);
	    driver.findElement(By.name("mobileBrand")).clear();
	    driver.findElement(By.name("mobileBrand")).sendKeys("华为");
	    driver.findElement(By.name("stortFamKm")).clear();
	    driver.findElement(By.name("stortFamKm")).sendKeys("1");
	    driver.findElement(By.name("famComKm")).clear();
	    driver.findElement(By.name("famComKm")).sendKeys("1");
	    driver.findElement(By.name("stortComKm")).clear();
	    driver.findElement(By.name("stortComKm")).sendKeys("1");
	    //验证信息
	    new Select(driver.findElement(By.name("userEvaluate"))).selectByVisibleText("1");
	    driver.findElement(By.id("userEvaluateCode")).clear();
	    Thread.sleep(2000);
	    driver.findElement(By.id("userEvaluateCode")).sendKeys("cyj123");//根据个人登录密码填写
	    //driver.findElement(By.id("save_but")).click();
	    driver.findElement(By.id("draft_but")).click();//保存草稿
	}
	
	
 /* @AfterTest
  public void afterTest() {
	  driver.close();
  }
*/
	
}
