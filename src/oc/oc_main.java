package oc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class oc_main {
	
public static void main(String[] args) throws InterruptedException{
	WebDriver driver;
	driver = new FirefoxDriver();
	//��¼
	oc_login oclogin=new oc_login();
	oclogin.login(args[0],args[1],args[2]); //url,username,password
    //������ѯ
	oc_app_query ocappquery=new oc_app_query();
	ocappquery.keys(); //��ҳ����

	//����״̬��ѯ
	ListSelection appstate=new ListSelection();
	for(int i=3;i<=23;i++){
		appstate.listSelection("appState",args[i]);
	}
	
}
}
