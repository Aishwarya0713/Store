package module1;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import resources.base;

public class Navigate_back_forward extends base{
	@Test(dataProvider = "getData" )
	public void login(String username,String password) throws IOException {
		basepagenavigation(username,password);
		driver.navigate().back();
		driver.navigate().forward();
	}
	
	public void basepagenavigation(String username,String password) throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		log1.info("Successfully opened application");
		Landingpage l = new Landingpage(driver);
		l.Username().sendKeys(username);
		l.password().sendKeys(password);
		l.login().click();
		log1.info("Successfully entered username and password");
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[1][2];
		data[0][1]="aishwarya.kurkoti@qualitestgroup.com";
		data[0][1]="P@ssw0rd";
		return data;
	}
	
	

}
