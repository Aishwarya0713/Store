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

public class contact extends base {
	SoftAssert s_assert;

	@Test(dataProvider="getData")
	public void contactcheck(HashMap<String,String> td) throws IOException, InterruptedException{
		
		driver=initializeDriver();
		s_assert=new SoftAssert();
		driver.get(prop.getProperty("url"));
		Landingpage l=new Landingpage(driver);
		l.contact().click();
		Thread.sleep(2000);
		l.Email().sendKeys(td.get("Email"));
		l.Name().sendKeys(td.get("Name"));
		l.Message().sendKeys(td.get("Message"));
		Thread.sleep(2000);
		l.contact4().click();
		if(td.get("Email").equals("")||td.get("Name").equals("")||td.get("Message").equals(""))
		{
			s_assert.assertEquals(driver.switchTo().alert().getText().toString(), "Input field is empty");
			driver.switchTo().alert().accept();
		}
		else {
			s_assert.assertEquals(driver.switchTo().alert().getText().toString(), "Thanks for the message!!");
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
		}
		s_assert.assertAll();
	}
	
	 @AfterMethod
     public void closebrowser()
     {
         driver.close();
     }
	
	@DataProvider

	public Object[][] getData() throws InterruptedException, IOException
	{
        ArrayList<HashMap<String,String>>  td=tcdata("contact");
        Iterator<HashMap<String, String>> itr=td.iterator();
        Object[][] obj=new Object[td.size()][1];
        int i=0;
        while(itr.hasNext())
        {
        
            HashMap<String, String> a=itr.next();
            obj[i++][0]=a;
        }
        
        test=extent.createTest("Check-Contact");
        return obj;
	}
}