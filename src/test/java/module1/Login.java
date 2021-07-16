package module1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.Landingpage;
import resources.base;

public class Login extends base {
	SoftAssert s_assert;

	@Test(dataProvider="getData")
	public void logincheck(String username,String password) throws IOException, InterruptedException{
		
		driver=initializeDriver();
		
		driver.get(prop.getProperty("url"));
		log1.info("Successfully opened the application");
		Landingpage l=new Landingpage(driver);
		l.login1().click();
		Thread.sleep(2000);
		l.Username().sendKeys(username);
		l.password().sendKeys(password);
		l.login().click();
		
		WebDriverWait w = new WebDriverWait(driver,5);
	    
        System.out.println(l.Welcomeuser().getText());

	}
	
	 @AfterMethod
     public void closebrowser()
     {
         driver.close();
     }
	
	@DataProvider

	public Object[][] getData() throws InterruptedException, IOException
	{

        ArrayList<HashMap<String,String>>  td=tcdata("Login");
        Iterator<HashMap<String, String>> itr=td.iterator();
        
        
    int i=0;

    Object colors[][]=new Object[td.size()][2];
    
        while(itr.hasNext())
        {
        
            HashMap<String, String> a=itr.next();
            String base=a.get("Test Id");
            if(base.equals(""))
            {
                break;
            }
            
        
        
        colors[i][0]=a.get("UserName");
        colors[i++][1]=a.get("Password");
        }
        
        test=extent.createTest("Check-Login");
        return colors;
	}

	
}