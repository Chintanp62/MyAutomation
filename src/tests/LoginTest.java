package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

public class LoginTest{
	DataFile df= new DataFile();
	
	
LoginPage lp= new LoginPage();


  @BeforeMethod
  public  void beforeMethod() throws IOException {
	lp.openBrowser();
	lp.openLoginPage();
		}

  @AfterMethod
  public void afterMethod() {
lp.closeBrowser();
  }
  @Test(priority=1)
  public void loginWithSpecialCharEmailTest() throws InterruptedException {
	 
	lp.login(df.emailWithSpecialChar, df.wrongPassword);
		
		String expectedError = "Please enter a username or card number without special characters.";
		String actualError=lp.readEmailErr();
		Assert.assertEquals(expectedError, actualError);
		
  }
  @Test(priority=2)
  public void loginWithEmptyEmailTest() throws InterruptedException {
	 lp.login("", df.wrongPassword);
		
		String expectederror= "Please enter your username or card number.";
		String actualError=lp.readEmptyEmailErr();
	  
	  Assert.assertEquals(actualError, expectederror);
		
	  
  }
  @Test(priority=3)
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	  lp.login(df.wrongEmail, "");
		
		String expectederror= "Please enter your password.";
		
		String actualError=lp.readPasswordErr();
	  Assert.assertEquals(expectederror, expectederror);
		
	  
  }
  @Test(priority=4)
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
	 
	lp.login(df.wrongEmail,df.wrongPassword);
		String expectedError = "Please check your card number / username or password and try again.";
		String actualError = lp.readGlobalErr();
		Assert.assertEquals(expectedError, actualError);
		
  }
 
}