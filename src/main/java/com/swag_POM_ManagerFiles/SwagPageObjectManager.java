package com.swag_POM_ManagerFiles;

import org.base.BaseClass;

import com.Swagpom.SwagLoginPage;
import com.swagproperty.Swagconfigreader;

public class SwagPageObjectManager extends BaseClass{
	
	private SwagLoginPage swaglogin;
	private Swagconfigreader reader;
	
	public SwagLoginPage getLoginPage() {
		
		if(swaglogin == null) {
			
			swaglogin = new SwagLoginPage(driver);
		}
		return swaglogin;
	}
	
	public Swagconfigreader getSwagConfigData() {
		
		if(reader == null) {
			
			reader = new Swagconfigreader();
		}
		
		return reader;
	}

}
