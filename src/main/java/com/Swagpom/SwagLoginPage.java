package com.Swagpom;

import java.io.IOException;
import java.time.Duration;

import org.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.swag_POM_ManagerFiles.SwagPageObjectManager;

public class SwagLoginPage extends BaseClass implements LoginPageInterface {
	
	public static WebDriver swagdriver;
	
	 @FindBy(id = username_id)
	 private WebElement Username;
	 
	 @FindBy(id = pass_id)
	 private WebElement password;
	 
	 @FindBy(id = login_id)
	 private WebElement loginBtn;
	 
	 @FindBy(xpath = invalid_username)
	 private WebElement invalidusername;
	 
	 @FindBy(id = productone_id)
	 private WebElement ProductOne;
	 
	 @FindBy(xpath = cart)
	 private WebElement Cart;
	 
	 @FindBy(id = checkout_id)
	 private WebElement checkOut;
	 
	 @FindBy(id = firstname1_id)
	 private WebElement firstName1;
	 
	 @FindBy(id = lastname1_id)
	 private WebElement LastName1;
	 
	 @FindBy(id = pincode1_id)
	 private WebElement pinCode1; 
	 
	 @FindBy(id= continueBtn_id)
	 private WebElement continueBtn;
	 
	 @FindBy(id= finishBtn_id)
	 private WebElement FinishBtn;
	 
	 @FindBy(xpath = orderstatus_xpath)
	 private WebElement orderconfirmation;
	 
	 @FindBy(id = backtohome_id)
	 private WebElement BacktoHome;
	 
	 @FindBy(id = itemtwo_id)
	 private WebElement itemTwo;
	 
	 @FindBy(id = itemthree_id)
	 private WebElement itemThree;
	 
	 @FindBy(id = itemfour_id)
	 private WebElement itemFour;
	 
	 @FindBy(id = itemfive_id)
	 private WebElement itemFive;
	 
	 
	 public SwagLoginPage(WebDriver driver) {
		 
		 swagdriver = driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	 public boolean getLoginElements(ExtentTest extenttest) throws IOException {
		 
		 SwagPageObjectManager pom = new SwagPageObjectManager();
		
		 try {
			launchingUrl(pom.getSwagConfigData().getUrl());
			inputPassing(swagdriver, Username, pom.getSwagConfigData().getUsername());
			inputPassing(swagdriver, password, pom.getSwagConfigData().getPassword());
			ClickElement(swagdriver, loginBtn);
			 String title = "Swag Labs";
			 Assert.assertEquals(title, "Swag Labs");
			 extenttest.log(Status.PASS, "Login Successfull");
			 
		} catch (AssertionError e) {
	
			extenttest.log(Status.FAIL,"Login Failed" +e.getMessage());
			return false; 
		}
		 return true;
	 }
	 
	 public void getInValidLoginElements() throws IOException {
		 
		 SwagPageObjectManager pom = new SwagPageObjectManager();
		 launchingUrl(pom.getSwagConfigData().getUrl());
		 inputPassing(swagdriver, Username, pom.getSwagConfigData().getInvalidUsername());
		 inputPassing(swagdriver, password, pom.getSwagConfigData().getPassword());
		 ClickElement(swagdriver, loginBtn);
		 Assert.assertEquals(invalidusername.getText(), "Epic sadface: Username and password do not match any user in this service");
		  
	 }
	 
	 public void getProductOne() throws IOException {
		 
		 SwagPageObjectManager pom = new SwagPageObjectManager();
		 ClickElement(swagdriver, ProductOne);
		 ClickElement(swagdriver,Cart);
		 ClickElement(swagdriver,checkOut);
		 inputPassing(swagdriver, firstName1, pom.getSwagConfigData().getfirstName1());
		 inputPassing(swagdriver, LastName1, pom.getSwagConfigData().getlastName1());
		 inputPassing(swagdriver, pinCode1, pom.getSwagConfigData().getPincode1());
		 ClickElement(swagdriver, continueBtn);		 
		 ClickElement(swagdriver, FinishBtn);
		 String text1 = orderconfirmation.getText();
		 Assert.assertEquals(text1, "Thank you for your order!");
		
	}
	 
public void getProductTwo() throws IOException {
		 
		 SwagPageObjectManager pom = new SwagPageObjectManager();
		 ClickElement(swagdriver, BacktoHome);
		 ClickElement(swagdriver, itemTwo);
		 ClickElement(swagdriver,Cart);
		 ClickElement(swagdriver,checkOut);
		 inputPassing(swagdriver, firstName1, pom.getSwagConfigData().getfirstName1());
		 inputPassing(swagdriver, LastName1, pom.getSwagConfigData().getlastName1());
		 inputPassing(swagdriver, pinCode1, pom.getSwagConfigData().getPincode1());
		 ClickElement(swagdriver, continueBtn);
		 ClickElement(swagdriver, FinishBtn);
		 String text1 = orderconfirmation.getText();
		 Assert.assertEquals(text1, "Thank you for your order!");
		
	}

	public void getProductThree() throws IOException {
	 
	 SwagPageObjectManager pom = new SwagPageObjectManager();
	 ClickElement(swagdriver, BacktoHome);
	 ClickElement(swagdriver, itemThree);
	 ClickElement(swagdriver,Cart);
	 ClickElement(swagdriver,checkOut);
	 inputPassing(swagdriver, firstName1, pom.getSwagConfigData().getfirstName1());
	 inputPassing(swagdriver, LastName1, pom.getSwagConfigData().getlastName1());
	 inputPassing(swagdriver, pinCode1, pom.getSwagConfigData().getPincode1());
	 ClickElement(swagdriver, continueBtn);
	 ClickElement(swagdriver, FinishBtn);
	 String text1 = orderconfirmation.getText();
	 Assert.assertEquals(text1, "Thank you for your order!");
	
	}

	public void getProductFour() throws IOException {
	 
	 SwagPageObjectManager pom = new SwagPageObjectManager();
	 ClickElement(swagdriver, BacktoHome);
	 ClickElement(swagdriver, itemFour);
	 ClickElement(swagdriver,Cart);
	 ClickElement(swagdriver,checkOut);
	 inputPassing(swagdriver, firstName1, pom.getSwagConfigData().getfirstName1());
	 inputPassing(swagdriver, LastName1, pom.getSwagConfigData().getlastName1());
	 inputPassing(swagdriver, pinCode1, pom.getSwagConfigData().getPincode1());
	 ClickElement(swagdriver, continueBtn);
	 ClickElement(swagdriver, FinishBtn);
	 String text1 = orderconfirmation.getText();
	 Assert.assertEquals(text1, "Thank you for your order!");
	
	}

	public void getProductFive() throws IOException {
	 
	 SwagPageObjectManager pom = new SwagPageObjectManager();
	 ClickElement(swagdriver, BacktoHome);
	 ClickElement(swagdriver, itemFive);
	 ClickElement(swagdriver,Cart);
	 ClickElement(swagdriver,checkOut);
	 inputPassing(swagdriver, firstName1, pom.getSwagConfigData().getfirstName1());
	 inputPassing(swagdriver, LastName1, pom.getSwagConfigData().getlastName1());
	 inputPassing(swagdriver, pinCode1, pom.getSwagConfigData().getPincode1());
	 ClickElement(swagdriver, continueBtn);
	 ClickElement(swagdriver, FinishBtn);
	 String text1 = orderconfirmation.getText();
	 Assert.assertEquals(text1, "Thank you for your order!");

}


}
