package test1;

//测试从xml获取参数，但是xml中如果有中文，会报错，该问题还未解决
//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class p {
	WebDriver driver;

	@Test
	@Parameters({ "url", "username", "password", "storeId" })
	public void login(String url, String username, String password,
			String storeId) throws InterruptedException {

		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();// 窗口最大化
		// driver.manage().timeouts().implicitlyWait(1,
		// TimeUnit.SECONDS);//隐式等待,针对Driver每次执行命令的最长执行时间,也可以理解为超时时间

		driver.findElement(By.id("username")).sendKeys(username);// 输入登录用户名
		driver.findElement(By.id("password")).sendKeys(password);// 输入登录密码
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // 点击登录
		
	}
}