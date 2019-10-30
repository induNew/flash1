//package com.testpom;
//	import java.util.concurrent.TimeUnit;
//	import com.pom.EnterTimeTrack;
//import com.pom.LoginPage;
//import com.generic.*;
//
//	public class TestLogin extends BaseTest{
//
//		
//		public static void main(String[] args) throws InterruptedException {
//			
//			
//			LoginPage sh=new LoginPage(driver);
//			Thread.sleep(1000);
//			sh.sendUsername(ss);
//			
//	}
//
//	}
//}
package com.testpom;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.generic.Excel;
import com.pom.EnterTimeTrack;
import com.pom.LoginPage;

public class TestLogin extends BaseTest {
	@Test
	public static void validLogin() throws EncryptedDocumentException, InvalidFormatException {
		String un = Excel.getData(XL_PATH, SHEET_NAME, 2, 0);
		String pwd = Excel.getData(XL_PATH, SHEET_NAME, 2, 1);
		String title = Excel.getData(XL_PATH, SHEET_NAME, 1, 2);
		// Excel.storeValue(XL_PATH,SHEET_NAME, 0, 3, "Status");
		System.out.println(un + " " + pwd + " " + title);

		LoginPage l = new LoginPage(driver);
		l.sendUsername(un);
		l.sendPwd(pwd);
		l.LoginButton();

		EnterTimeTrack eTT = new EnterTimeTrack(driver);
		eTT.verifyHomePageIsDisplayed(driver, 5, title);

	}

}
