package module1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.Landingpage;
import resources.base;

public class signup extends base {
	SoftAssert s_assert;

	@Test(dataProvider="getData")
	public void signupcheck(String username,String password) throws IOException, InterruptedException{
		
		driver=initializeDriver();
		
		driver.get(prop.getProperty("url"));
		log1.info("Successfully opened the application");
		Landingpage l=new Landingpage(driver);
		l.signup1().click();
		Thread.sleep(2000);
		l.Username1().sendKeys(username);
		l.password1().sendKeys(password);
		l.signup().click();
		
	}
	
	 @AfterMethod
     public void closebrowser()
     {
         driver.close();
     }
	
	@DataProvider

	public Object[][] getData() throws InterruptedException, IOException
	{

        ArrayList<HashMap<String,String>>  td=tcdata("signup");
        Iterator<HashMap<String, String>> itr=td.iterator();
        
        
    int i=0;

    Object colors[][]=new Object[td.size()][2];
    
        while(itr.hasNext())
        {
        
            HashMap<String, String> a=itr.next();
            String base=a.get("Test ID");
            if(base.equals(""))
            {
                break;
            }
            
        
        
        colors[i][0]=a.get("Username");
        colors[i++][1]=a.get("Password");
        }
        
        test=extent.createTest("Check-signup");
        return colors;
	}

	
}