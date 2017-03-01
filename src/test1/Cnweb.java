//cnweb人工初步审核页面验证,参数写死在代码中

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
		driver.manage().window().maximize();// 窗口最大化	
	}
	@Test(priority=1)
	public void login() throws Exception {
		driver.findElement(By.name("j_username")).sendKeys("998866");// 输入登录用户名
		driver.findElement(By.name("j_password")).sendKeys("cyj111");// 输入登录密码
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // 点击登录
		Thread.sleep(5000);// 等待时间单位为毫秒
		String verify = driver.findElement(By.className("a1")).getText();
		assert verify.contains("退 出");// 做断言 assertion
  }
	@Test(priority=2)
	public void testlogin() throws Exception {
		//driver.findElement(By.className("ui-dialog-close")).click();// 关闭软电话窗口
	    driver.findElement(By.cssSelector("button.ui-dialog-close")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//div[@id='jqxNavigationBar']/div[7]")).click();//选择贷前管理
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("人工初步审核(新)")).click();;//选择人工初步审核
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("继续审核")).click();
	    Thread.sleep(2000);
	}
	@Test(priority=3)
	public void NCIIC_Check() throws Exception {
		 /** 检查NCIIC人工检查下拉列表的选项 */  
        // 预期的选项内容StateOptions  
        List<String> StateOptions = Arrays.asList(new String[] {"请选择","信息一致，照片不一致","信息和照片均一致","信息不一致","信息一致，但NCIIC中无照片","没有找到记录","访问NCIIC失败","未填"});
        int size1=StateOptions.size();
        /** 遍历一下下拉列表所有选项，用click进行选中选项 **/ 
        Thread.sleep(2000);
        Select selectState = new Select(driver.findElement(By.name("MCRG01"))); //通过name属性定位到NCIIC项
        Assert.assertFalse(selectState.isMultiple());// 验证下拉列表不支持多选
        List<String> act_StateOptions = new ArrayList<String>();  
        // 判断选择内容  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState.getOptions()) {  
            //e.click();  
            // 将实际的下拉列表内容注入到act_StateOptions中，进行比较。  
            act_StateOptions.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions.toArray(), act_StateOptions.toArray());  
        System.out.println("NCIIC人工检查--下拉列表共"+size1+"项，选项显示正确");
        
        selectState.selectByVisibleText("未填");
        //String selectw= selectState.getFirstSelectedOption().getText();
      
       String selectw="未填";
        if ((selectw=="信息一致，照片不一致")|| (selectw=="没有找到记录")||(selectw=="信息不一致"))
        	{System.out.println("NCIIC=-50");}
        else if ((selectw=="信息和照片均一致")||(selectw=="信息一致，但NCIIC中无照片")||(selectw=="访问NCIIC失败")|| (selectw=="未填"))
        	{System.out.println("NCIIC=0");}
        
	}
	@Test(priority=4)
	public void NCIIC_Pic() throws Exception {
		 /** 检查NCIIC照片对比下拉列表的选项 */  
        // 预期的选项内容StateOptions  
        List<String> StateOptions2 = Arrays.asList(new String[] {"请选择","照片一致","照片不一致","未填"});
        int size2=StateOptions2.size();
        /** 遍历一下下拉列表所有选项，用click进行选中选项 **/  
        Thread.sleep(2000);
        Select selectState2 = new Select(driver.findElement(By.name("MCRG02"))); 
        Assert.assertFalse(selectState2.isMultiple());// 验证下拉列表不支持多选
        List<String> act_StateOptions2 = new ArrayList<String>();  
        // 判断选择内容  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState2.getOptions()) {  
            //e.click();  
            // 将实际的下拉列表内容注入到act_StateOptions中，进行比较。  
            act_StateOptions2.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions2.toArray(), act_StateOptions2.toArray());  
        System.out.println("NCIIC照片对比--下拉列表共"+size2+"项，选项显示正确");
        selectState2.selectByVisibleText("照片一致");
        System.out.println("NCIIC_Pic=0");      
        
	}
	@Test(priority=5)
	public void ps() throws Exception {
		 /** 审核备注 */ 
	    Thread.sleep(1000);
	    driver.findElement(By.name("MCRG0T")).clear();
	    driver.findElement(By.name("MCRG0T")).sendKeys("test");
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("下一步")).click();
	}
	@Test(priority=6)
	public void SheBao() throws Exception {
		 /** 检查社保信息核实下拉列表的选项 */  
        // 预期的选项内容StateOptions  
        List<String> StateOptions3 = Arrays.asList(new String[] {"请选择","社保单位名称与申请表一致","社保单位名称与申请表不一致","无社保","无法验证社保信息","其他","欺诈嫌疑","未填"});
        int size1=StateOptions3.size();
        /** 遍历一下下拉列表所有选项，用click进行选中选项 **/  
        Thread.sleep(2000);
        Select selectState3 = new Select(driver.findElement(By.name("MCRG03"))); //通过name属性定位到社保选项
        Assert.assertFalse(selectState3.isMultiple());// 验证下拉列表不支持多选
        List<String> act_StateOptions3 = new ArrayList<String>();  //实例化一个list表
        // 判断选择内容  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState3.getOptions()) {  
            //e.click();  
            // 将实际的下拉列表内容注入到act_StateOptions中，进行比较。  
            act_StateOptions3.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions3.toArray(), act_StateOptions3.toArray());  
        System.out.println("社保信息核实--下拉列表共"+size1+"项，选项显示正确");
        
        selectState3.selectByVisibleText("社保单位名称与申请表一致");
        //String selectw= selectState.getFirstSelectedOption().getText();
      
       String selectw="社保单位名称与申请表一致";
        if (selectw=="社保单位名称与申请表一致")
        	{System.out.println("社保=1");}
        else if ((selectw=="社保单位名称与申请表不一致")||(selectw=="无社保")||(selectw=="无法验证社保信息")||(selectw=="其他")||(selectw=="未填"))
        	{System.out.println("社保=0");}
        else if (selectw=="欺诈嫌疑")
        	{System.out.println("社保=-50");}     
	}
	
	@Test(priority=7)
	public void xuexin() throws Exception {
		 /** 检查学信网信息核实下拉列表的选项 */  
        // 预期的选项内容StateOptions  
        List<String> StateOptions4 = Arrays.asList(new String[] {"请选择","未填","学信网一致","学信网不一致","非学生","其他"});
        int size1=StateOptions4.size();
        Thread.sleep(2000);
        /** 遍历一下下拉列表所有选项，用click进行选中选项 **/  
        Select selectState4 = new Select(driver.findElement(By.name("MCRG11"))); 
        Assert.assertFalse(selectState4.isMultiple());// 验证下拉列表不支持多选
        List<String> act_StateOptions4 = new ArrayList<String>();  
        // 判断选择内容  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState4.getOptions()) {  
            //e.click();  
            // 将实际的下拉列表内容注入到act_StateOptions中，进行比较。  
            act_StateOptions4.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions4.toArray(), act_StateOptions4.toArray());  
        System.out.println("学信网信息核实--下拉列表共"+size1+"项，选项显示正确");     
        selectState4.selectByVisibleText("学信网不一致");
        System.out.println("学信网=0");  
	}
	
	@Test(priority=8)
	public void Sell_Pic() throws Exception {
		 /** 检查销售照片对比下拉列表的选项 */  
        // 预期的选项内容StateOptions  
        List<String> StateOptions5 = Arrays.asList(new String[] {"请选择","照片一致","照片不一致","无法判断"});
        int size2=StateOptions5.size();
        Thread.sleep(2000);
        /** 遍历一下下拉列表所有选项，用click进行选中选项 **/  
        Select selectState5 = new Select(driver.findElement(By.name("PSA01"))); 
        Assert.assertFalse(selectState5.isMultiple());// 验证下拉列表不支持多选
        List<String> act_StateOptions5 = new ArrayList<String>();  
        // 判断选择内容  
       // Assert.assertEquals("Please select", selectState.getFirstSelectedOption().getText());  
        for (WebElement e : selectState5.getOptions()) {  
            //e.click();  
            // 将实际的下拉列表内容注入到act_StateOptions中，进行比较。  
            act_StateOptions5.add(e.getText());  
        }  
        Assert.assertEquals(StateOptions5.toArray(), act_StateOptions5.toArray());  
        System.out.println("销售照片对比--下拉列表共"+size2+"项，选项显示正确");
        selectState5.selectByVisibleText("无法判断");
        System.out.println("销售照片对比=0"); 
        Thread.sleep(2000);
	    driver.findElement(By.linkText("下一步")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("下一步")).click();
	    Thread.sleep(2000);
        
	}
	@Test(priority=9)
	public void Score() throws Exception {
		//验证审核情况form页面有多少个下拉框，或者显示多少个"请选择"框
	
//		 List<WebElement> elements = driver.findElements(By.xpath("//*[text()='请选择']")); 
//		 int number=elements.size();//分数大于525时总共有8个，小于等于525时共12个
//		 System.out.println(number);
//		 Assert.assertEquals(number,12);
		 List<WebElement> elements = driver.findElements(By.tagName("select")); 
		 int number=elements.size();//分数大于525时总共有8个，小于等于525时共12个
		 System.out.println(number);
		 String score=driver.findElement(By.id("SCORE")).getAttribute("value");
		 int score1=Integer.parseInt(score);
		 System.out.println(score1);
		 if (score1>525){
			if (number==8){
				System.out.println("打分卡分数为"+score1+"下拉框个数为4");
				 Thread.sleep(2000);
				new Select(driver.findElement(By.name("MCRE02"))).selectByVisibleText("信息已验证");
				new Select(driver.findElement(By.name("MCRE03"))).selectByVisibleText("信息已验证");
				new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText("RES01");
				new Select(driver.findElement(By.name("MCRH07"))).selectByVisibleText("信息已验证");
			}
		 }
			else
				{if(number==12){
					System.out.println("打分卡分数为"+score1+"下拉框个数为7");
					Thread.sleep(2000);
					new Select(driver.findElement(By.name("MCRE02"))).selectByVisibleText("信息验证失败");//申请人办公电话核实:
					new Select(driver.findElement(By.name("MCRE020401"))).selectByVisibleText("申请人不在此工作");
				    new Select(driver.findElement(By.name("MCRE03"))).selectByVisibleText("信息已验证");//申请人手机电话核实:
				    new Select(driver.findElement(By.name("MCRG05"))).selectByVisibleText("公司名和地址均一致");//ID5办公电话核查
				    new Select(driver.findElement(By.name("MCRH06"))).selectByVisibleText("信息验证失败");//申请人其他联系人的手机电话核实:
				    new Select(driver.findElement(By.name("MCRH060301"))).selectByVisibleText("号码不属于其他联系人");
				    new Select(driver.findElement(By.name("MCRM05"))).selectByVisibleText("信息验证失败");//申请人家庭座机电话核实:
				    new Select(driver.findElement(By.name("MCRH07"))).selectByVisibleText("信息验证失败");//申请人家庭成员电话核实:
				    new Select(driver.findElement(By.name("MCRH070301"))).selectByVisibleText("其它");
				    new Select(driver.findElement(By.name("MCRG07"))).selectByVisibleText("RES01");//主观判断结果:
				}
		 }
		 Thread.sleep(2000);
		    driver.findElement(By.linkText("暂存")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
			}
	


	 
	@AfterTest
	public void afterTest() {
	}

}
