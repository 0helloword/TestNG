package test1;

//���Դ�xml��ȡ����������xml����������ģ��ᱨ�������⻹δ���
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
		driver.manage().window().maximize();// �������
		// driver.manage().timeouts().implicitlyWait(1,
		// TimeUnit.SECONDS);//��ʽ�ȴ�,���Driverÿ��ִ��������ִ��ʱ��,Ҳ�������Ϊ��ʱʱ��

		driver.findElement(By.id("username")).sendKeys(username);// �����¼�û���
		driver.findElement(By.id("password")).sendKeys(password);// �����¼����
		Thread.sleep(2000);
		driver.findElement(By.id("loginButton")).click(); // �����¼
		
	}
}