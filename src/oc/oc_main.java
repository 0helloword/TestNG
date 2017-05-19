package oc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class oc_main {
	
public static void main(String[] args) throws InterruptedException{
	WebDriver driver;
	driver = new FirefoxDriver();
	//登录
	oc_login oclogin=new oc_login();
	oclogin.login(args[0],args[1],args[2]); //url,username,password
    //工单查询
	oc_app_query ocappquery=new oc_app_query();
	ocappquery.keys(); //翻页按键

	//工单状态查询
	ListSelection appstate=new ListSelection();
	for(int i=3;i<=23;i++){
		appstate.listSelection("appState",args[i]);
	}
	
}
}
