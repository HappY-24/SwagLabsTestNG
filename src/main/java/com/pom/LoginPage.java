package com.pom;

import static org.testng.Assert.assertEquals;

import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage extends BaseClass{

	public WebDriver amazondriver;
	
	public LoginPage(WebDriver driver) {
		
		amazondriver = driver;
		PageFactory.initElements(amazondriver, this);
		
	}
	
	@FindBy(id= "nav-link-accountList")
	private WebElement SignInBtn;
	
	@FindBy(xpath = "//input[@type='email']")
	private WebElement PhoneNo;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement continuebtn;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement SigninBtn1;
	
	@FindBy(xpath="(//div[contains(text(),Invalid email')]")
	private WebElement usernameerror;
	
	@FindBy(xpath ="(//div[contains(text(),is incorrect )")
	private WebElement pwderror;
	
	@FindBy(xpath="(//div[contains(text(),'Enter your')]")
	private WebElement emptypwd;
	
	public boolean validLogin(ExtentTest extenttest) {
		
		try {
		launchingUrl("https://www.amazon.in/");
		implicitWait(30);
		ClickButton(SignInBtn);
		passInput(PhoneNo, "8778966845");
		ClickButton(continuebtn);
		passInput(password, "H4ppy@824");
		ClickButton(SigninBtn1);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		extenttest.log(Status.PASS,"Login Succesfull");
		}catch(AssertionError e) {
			
			extenttest.log(Status.FAIL,"LoginFailed" +e.getMessage());
			return false;
		}
		return true;
	}
	
	public void validUsernameWithInvalidPassword() {
		
		launchingUrl("https://www.amazon.in/");
		implicitWait(30);
		ClickButton(SignInBtn);
		passInput(PhoneNo, "8778966845");
		ClickButton(continuebtn);
		passInput(password, "H4ppy@");
		ClickButton(SigninBtn1);
		Assert.assertEquals(pwderror.getText(), "There was a problem");

	}
	
	
	public void validUsernameWithEmptyPassword() {
				
		launchingUrl("https://www.amazon.in/");
		implicitWait(30);
		ClickButton(SignInBtn);
		passInput(PhoneNo, "8778966845");
		ClickButton(continuebtn);
		passInput(password, "");
		ClickButton(SigninBtn1);
		Assert.assertEquals(emptypwd.getText(), "Enter your password");

	}


	public void InvalidUsernameWithValidPassword() {
	
	launchingUrl("https://www.amazon.in/");
	implicitWait(30);
	ClickButton(SignInBtn);
	passInput(PhoneNo, "+9187789668");
	ClickButton(continuebtn);
	Assert.assertEquals(usernameerror.getText(), "Wrong or Invalid email address or mobile phone number. Please correct and try again.");

	}

}
