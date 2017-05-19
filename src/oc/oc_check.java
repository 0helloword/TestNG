package oc;

//OC人工初步审核，从xml获取参数
//直接在eclipse左侧列表选择xml文件运行
//暂未解决问题：第四个页面因滚动条原因导致无法定位元素
//用于验证审核二次评分流程
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
		driver.manage().window().maximize();// 窗口最大化
		driver.findElement(By.id("username")).sendKeys(username);// 输入登录用户名
		driver.findElement(By.id("password")).sendKeys(password);// 输入登录密码
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // 点击登录
	}


	
	@Test(priority =2)
	public void check() throws InterruptedException {
		//Thread.sleep(3000);
		//driver.findElement(By.cssSelector("button.ui-dialog-close")).click();// 关闭软电话
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[4]/a/span")).click();// 人工审核
		Thread.sleep(1000);
		driver.findElement(By.linkText("初步审核（POS）")).click();
		driver.findElement(By.linkText("继续审核")).click();
	}

	@Test(priority = 3)
	public void NCIIC_Check() throws Exception {
		/** 检查NCIIC人工检查下拉列表的选项 */
		// 预期的选项内容StateOptions
		List<String> StateOptions = Arrays.asList(new String[] { "请选择",
				"信息一致，照片不一致", "信息和照片均一致", "信息不一致", "信息一致，但NCIIC中无照片", "没有找到记录",
				"访问NCIIC失败", "未填" });
		int size1 = StateOptions.size();
		/** 遍历一下下拉列表所有选项，用click进行选中选项 **/
		Thread.sleep(2000);
		Select selectState = new Select(driver.findElement(By.name("MCRG01"))); // 通过name属性定位到NCIIC项
		Assert.assertFalse(selectState.isMultiple());// 验证下拉列表不支持多选
		List<String> act_StateOptions = new ArrayList<String>();
		// 判断选择内容
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState.getOptions()) {
			// e.click();
			// 将实际的下拉列表内容注入到act_StateOptions中，进行比较。
			act_StateOptions.add(e.getText());
		}
		Assert.assertEquals(StateOptions.toArray(), act_StateOptions.toArray());
		System.out.println("NCIIC人工检查--下拉列表共" + size1 + "项，选项显示正确");
	}

	@Test(priority = 4)
	public void NCIIC_Pic() throws Exception {
		/** 检查NCIIC照片对比下拉列表的选项 */
		// 预期的选项内容StateOptions
		List<String> StateOptions2 = Arrays.asList(new String[] { "请选择",
				"照片一致", "照片不一致", "未填" });
		int size2 = StateOptions2.size();
		/** 遍历一下下拉列表所有选项，用click进行选中选项 **/
		Thread.sleep(2000);
		Select selectState2 = new Select(driver.findElement(By.name("MCRG02")));
		Assert.assertFalse(selectState2.isMultiple());// 验证下拉列表不支持多选
		List<String> act_StateOptions2 = new ArrayList<String>();
		// 判断选择内容
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState2.getOptions()) {
			// e.click();
			// 将实际的下拉列表内容注入到act_StateOptions中，进行比较。
			act_StateOptions2.add(e.getText());
		}
		Assert.assertEquals(StateOptions2.toArray(),
				act_StateOptions2.toArray());
		System.out.println("NCIIC照片对比--下拉列表共" + size2 + "项，选项显示正确");

	}

	
	@Parameters({ "NCIIC", "NCIICp" })
	@Test(priority = 5)
	public void Part1(String NCIIC, String NCIICp) throws Exception {
		new Select(driver.findElement(By.name("MCRG01")))
				.selectByVisibleText(NCIIC);
		new Select(driver.findElement(By.name("MCRG02")))
				.selectByVisibleText(NCIICp);
		Thread.sleep(2000);
	        if ("信息一致，照片不一致".equals(NCIIC) | "没有找到记录".equals(NCIIC)|"信息不一致".equals(NCIIC))
	        	{System.out.println("NCIIC=-50");
	        	}
	        else  //((NCIIC=="信息和照片均一致")||(NCIIC=="信息一致，但NCIIC中无照片")||(NCIIC=="访问NCIIC失败")|| (NCIIC=="未填"))
	        	{System.out.println("NCIIC=0");
	        	}
	        driver.findElement(By.linkText("下一步")).click();
	}

	@Test(priority = 6)
	public void SheBao() throws Exception {
		/** 检查社保信息核实下拉列表的选项 */
		// 预期的选项内容StateOptions
		List<String> StateOptions3 = Arrays.asList(new String[] { "请选择",
				"社保单位名称与申请表一致", "社保单位名称与申请表不一致", "无社保", "无法验证社保信息", "其他",
				"欺诈嫌疑", "未填" });
		int size1 = StateOptions3.size();
		/** 遍历一下下拉列表所有选项，用click进行选中选项 **/
		Thread.sleep(2000);
		Select selectState3 = new Select(driver.findElement(By.name("MCRG03"))); // 通过name属性定位到社保选项
		Assert.assertFalse(selectState3.isMultiple());// 验证下拉列表不支持多选
		List<String> act_StateOptions3 = new ArrayList<String>(); // 实例化一个list表
		// 判断选择内容
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState3.getOptions()) {
			// e.click();
			// 将实际的下拉列表内容注入到act_StateOptions中，进行比较。
			act_StateOptions3.add(e.getText());
		}
		Assert.assertEquals(StateOptions3.toArray(),
				act_StateOptions3.toArray());
		System.out.println("社保信息核实--下拉列表共" + size1 + "项，选项显示正确");
	}

	@Test(priority = 7)
	public void xuexin() throws Exception {
		/** 检查学信网信息核实下拉列表的选项 */
		// 预期的选项内容StateOptions
		List<String> StateOptions4 = Arrays.asList(new String[] { "请选择", "未填",
				"学信网一致", "学信网不一致", "非学生", "其他" });
		int size1 = StateOptions4.size();
		Thread.sleep(2000);
		/** 遍历一下下拉列表所有选项，用click进行选中选项 **/
		Select selectState4 = new Select(driver.findElement(By.name("MCRG11")));
		Assert.assertFalse(selectState4.isMultiple());// 验证下拉列表不支持多选
		List<String> act_StateOptions4 = new ArrayList<String>();
		// 判断选择内容
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState4.getOptions()) {
			// e.click();
			// 将实际的下拉列表内容注入到act_StateOptions中，进行比较。
			act_StateOptions4.add(e.getText());
		}
		Assert.assertEquals(StateOptions4.toArray(),
				act_StateOptions4.toArray());
		System.out.println("学信网信息核实--下拉列表共" + size1 + "项，选项显示正确");
	}

	@Test(priority = 8)
	public void Sell_Pic() throws Exception {
		/** 检查销售照片对比下拉列表的选项 */
		// 预期的选项内容StateOptions
		List<String> StateOptions5 = Arrays.asList(new String[] { "请选择",
				"照片一致", "照片不一致", "无法判断" });
		int size2 = StateOptions5.size();
		Thread.sleep(2000);
		/** 遍历一下下拉列表所有选项，用click进行选中选项 **/
		Select selectState5 = new Select(driver.findElement(By.name("PSA01")));
		Assert.assertFalse(selectState5.isMultiple());// 验证下拉列表不支持多选
		List<String> act_StateOptions5 = new ArrayList<String>();
		// 判断选择内容
		// Assert.assertEquals("Please select",
		// selectState.getFirstSelectedOption().getText());
		for (WebElement e : selectState5.getOptions()) {
			// e.click();
			// 将实际的下拉列表内容注入到act_StateOptions中，进行比较。
			act_StateOptions5.add(e.getText());
		}
		Assert.assertEquals(StateOptions5.toArray(),
				act_StateOptions5.toArray());
		System.out.println("销售照片对比--下拉列表共" + size2 + "项，选项显示正确");
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
		("社保单位名称与申请表不一致".equals(SheBao) |  "无社保".equals(SheBao)
				| "无法验证社保信息".equals(SheBao) | "其他".equals(SheBao)
				| "未填".equals(SheBao)) {
			System.out.println("社保=0");
		} 
		else if ("社保单位名称与申请表一致".equals(SheBao)) {
			System.out.println("社保=1");
		} 
		else 
		{
			System.out.println("社保=-50");
		}
		System.out.println("学信网=0");
		driver.findElement(By.linkText("下一步")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("下一步")).click();
	}
	
		
		
	@Test(priority = 10)//滚动栏导致元素无法定位，该问题还未解决
	@Parameters({"OfficeTelephone","OfficeTelephone1","Phone","Phone1","Check","FamilyPhone","FamilyPhone1",
		"Familytelephone","Otherphone","Otherphone1","ID5" })
	public void Part4(String OfficeTelephone, String OfficeTelephone1,String Phone,String Phone1,String Check,
			String FamilyPhone,String FamilyPhone1,String Familytelephone,String Otherphone,String Otherphone1,String ID5)
			throws Exception {
		Thread.sleep(2000);
		List<WebElement> elements = driver.findElements(By.tagName("select")); 
		 int number=elements.size();//分数大于525时总共有8个，小于等于525时共12个
		 //System.out.println(number);
		 String score=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/form/div/div/div/div[9]/div[2]")).getText();
		 int score1=Integer.parseInt(score);
		 //System.out.println(score1);
		 if (score1>525){
			if (number==8){
				System.out.println("打分卡分数为"+score1+"下拉框个数为4");
				 Thread.sleep(2000);
				new Select(driver.findElement(By.name("MCRE02"))).selectByVisibleText(OfficeTelephone);
				if (OfficeTelephone.equals("信息验证失败")){
					new Select(driver.findElement(By.name("MCRE020401"))).selectByVisibleText(OfficeTelephone1);
				}
				new Select(driver.findElement(By.name("MCRE03"))).selectByVisibleText(Phone);
				if (Phone.equals("信息验证失败")){
			    	new Select(driver.findElement(By.name("MCRE030301"))).selectByVisibleText(Phone1);
			    }
				new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText(Check);
				new Select(driver.findElement(By.name("MCRH07"))).selectByVisibleText(FamilyPhone);
				 if (Otherphone.equals("信息验证失败")){
			    	 new Select(driver.findElement(By.name("MCRH070301"))).selectByVisibleText(FamilyPhone1);
			    }
			}
		 }
			else
				{if(number==12){
					System.out.println("打分卡分数为"+score1+"下拉框个数为7");
					Thread.sleep(2000);
					//控制滚动栏
					//driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/form/div/div[2]")).sendKeys(Keys.UP);
					//Thread.sleep(2000);
					new Select(driver.findElement(By.name("MCRE02"))).selectByVisibleText(OfficeTelephone);//申请人办公电话核实:
					Thread.sleep(1000);
					  new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText(Check);//主观判断结果:
//					if (OfficeTelephone.equals("信息验证失败")){
//						new Select(driver.findElement(By.name("MCRE020401"))).selectByVisibleText(OfficeTelephone1);
//					}
					
					
				    new Select(driver.findElement(By.name("MCRE03"))).selectByVisibleText(Phone);//申请人手机电话核实:
//				    if (Phone.equals("信息验证失败")){
//				    	new Select(driver.findElement(By.name("MCRE030301"))).selectByVisibleText(Phone1);
//				    }
				    new Select(driver.findElement(By.name("MCRG05"))).selectByVisibleText(ID5);//ID5办公电话核查
				    Thread.sleep(1000);
				    new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText(Check);//主观判断结果:
				    Thread.sleep(1000);
				    new Select(driver.findElement(By.name("MCRH06"))).selectByVisibleText(Otherphone);//申请人其他联系人的手机电话核实:
				    if (Otherphone.equals("信息验证失败")){
				    	 new Select(driver.findElement(By.name("MCRH060301"))).selectByVisibleText(Otherphone1);
					}
				    new Select(driver.findElement(By.name("MCRH07"))).selectByVisibleText(FamilyPhone);//申请人家庭成员电话核实:
				    if (Otherphone.equals("信息验证失败")){
				    	 new Select(driver.findElement(By.name("MCRH070301"))).selectByVisibleText(FamilyPhone1);
				    }
				  
				    new Select(driver.findElement(By.name("MCRM05"))).selectByVisibleText(Familytelephone);//申请人家庭座机电话核实:
				 							}
		 }
		 Thread.sleep(2000);
		    driver.findElement(By.linkText("暂存")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
	}
		}


	