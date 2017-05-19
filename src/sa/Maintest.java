package sa;


public class Maintest {
	public static void main(String[]args) throws Exception {
		SIT newsit=new SIT();
		newsit.beforeTest();
		newsit.testlogin();
		newsit.neworder1();
		newsit.neworder2();
		newsit.neworder3();
		newsit.neworder4();		 	
	}

}
