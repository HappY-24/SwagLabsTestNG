package com.swagproperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Swagconfigreader {
	
	static Properties pr;
	static FileInputStream fis;
	
	private Properties getData() throws IOException {
		
		File file = new File("C:\\Users\\gayat\\Open_Mrs\\src\\main\\java\\com\\swagpropertiesfile\\swagproperty.Properties");
		
		pr = new Properties();
		
		fis = new FileInputStream(file);
		
		pr.load(fis);
		
		return pr;
	}
	
	public String getBrowsername() throws IOException {
		String browsername = getData().getProperty("browser");
		return browsername;

	}
	
	public String getUrl() throws IOException {
		
		String url = getData().getProperty("url");
		return url; 

	}
	
	public String getUsername() throws IOException {
		
		String userName = getData().getProperty("username");
		return userName;
	}

	public String getPassword() throws IOException {
	
		String Password = getData().getProperty("password");
		return Password;
		
	}
	
	public String getInvalidUsername() throws IOException {
		
		String invalidUserName = getData().getProperty("invalidusername");
		return invalidUserName;
	}
	
	
	public String getinvalidPassword() throws IOException {
		
		String invalidPassword = getData().getProperty("invalidpassword");
		return invalidPassword;
	}
	
	
	public String getfirstName1() throws IOException {
		
		String firstName = getData().getProperty("FirstName1");
		return firstName;
	}
	
	public String getlastName1() throws IOException {
		
		String lastName = getData().getProperty("LastName1");
		return lastName;
	}


	public String getPincode1() throws IOException {
	
	String pinCode1 = getData().getProperty("PinCode1");
	return pinCode1;
}

}
