package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signInButton;
	
	@FindBy(id = "globalError")
    public WebElement globalErr;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement emailErr;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordErr;

	
public void openBrowser() throws IOException {
	FileInputStream f = new FileInputStream("C:\\Selenium\\testing\\prop.properties");
	Properties prop = new Properties();
	prop.load(f);

	
	String browser = prop.getProperty("browser");
	if(browser.equals("Firefox"))
	
	{
System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\SeleniumJars\\geckodriver.exe");
		
		 driver = new FirefoxDriver();

}else if (browser.equals("Chrome")) {
System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\SeleniumJars\\chromedriver.exe");
	
	 driver = new ChromeDriver();
}else {
System.setProperty("webdriver.safari.driver", "C:\\Selenium\\SeleniumJars\\safaridriver.exe");
	
	 driver = new SafariDriver();
}
	PageFactory.initElements(driver, this);

	
}

public void openLoginPage() {
	driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=QM-ZkAg5gDc&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiUU0tWmtBZzVnRGMiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY2Mjg0MDUxNywiaWF0IjoxNjYyODM5MzE3LCJqdGkiOiJmMWYxYWFjMS0xYWQ3LTQyM2QtODQ4Ni00MWU2MDMxMWM4NjUiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.pNwBAsO48ErO2H8LwswwqGGt64cI3KXBMbFL223qfZV_jthC2rY7Dy1rtGf0nuZ0WZXE_81hpqEqsA98q0HjZhGhie6YkWbQhRXQ2QO3yu4bSQ8X6K61aJuGDmwlyaxx-9Vu96ESL3q-z8l9SgLqy8TM8jb1q9TsFDFAY1x7gkDvK11J--G8t0Xsm2veIPY25ne5Wz7212bxxwpyRSetcPVliqRaqfrN2eTnFaeD4SlH5DiPJ235CfVjQsZyP1RhnzFHFbydjptKAwAbGTRUBf8jwAN-oRQt2dAvJ15rSxuvYv-vFkuS_Yaa8tuyj2HaZT8-EjE0LW-gYMKg97uYiQ&preferred_environment=");
	
	
}

public void closeBrowser() {
	driver.quit();
}

public void login(String a, String b) throws InterruptedException {
	email.sendKeys(a);
	password.sendKeys(b);
	signInButton.click();
	Thread.sleep(3000);
}
public String readEmailErr() {
	String actualError =emailErr.getText();
	System.out.println(actualError);
	return actualError;
	
}
public String readEmptyEmailErr() {
	String actualError = emailErr.getText();
	System.out.println(actualError);
	return actualError;
	
}
public String readPasswordErr() {
	String actualerror= passwordErr.getText();
	  System.out.println(actualerror);
	  return actualerror;
}
public String readGlobalErr() {
	String actualError = globalErr.getText();
	System.out.println(actualError);
	return actualError;
}
}
