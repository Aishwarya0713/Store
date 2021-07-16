package module1;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.Landingpage;
import pageObject.PDP;
import resources.base;

public class Category extends base {
	SoftAssert s_assert;
	@Test(dataProvider="category")
    public void category(HashMap<String,String> td) throws IOException, InterruptedException {
        
        boolean flag=false;
        int i=1;
    
        s_assert=new SoftAssert();
        driver=initializeDriver();
        driver.get(prop.getProperty("url"));
        Thread.sleep(5000);
        Landingpage l=new Landingpage(driver);
        for(WebElement w:l.Category())
        {
        	if(w.getText().equals(td.get("Category"))) {
        	w.click();
            for(WebElement we:l.plp())
            {
                if(we.getText().equals(td.get("Product"+i+" Name")))
                {
                    flag=true;
                    we.click();
                    Thread.sleep(5000);
                    PDP pdp=new PDP(driver);
                    s_assert.assertEquals(td.get("Product"+i+" Name"),pdp.pdpName().getText());
                    String arr[]=pdp.pdpPrice().getText().split(" ");
                    float pri=Float.parseFloat(td.get("Product"+i+" Price"));
                    NumberFormat nf = NumberFormat.getNumberInstance();
                    nf.setMaximumFractionDigits(0);
                    String rounded = nf.format(pri);
                    s_assert.assertEquals("$"+rounded, arr[0]);
                    pdp.pdpAddtocart().click();
                    Thread.sleep(5000);
                    s_assert.assertEquals("Product added", driver.switchTo().alert().getText());
                    driver.switchTo().alert().accept();
                    Thread.sleep(4000);
                    i++;
                    break;
                }  
            }
            if(!flag)
            {
                System.out.println("Product not available: "+td.get("Product"+i+" Name"));
            } 
            
            break;
        }
    }
    s_assert.assertAll();
    }
	
	 @AfterMethod
     public void closebrowser()
     {
         driver.close();
     }
	
	@DataProvider
	public Object[][] category() throws IOException
	{
		ArrayList<HashMap<String,String>>  td=tcdata("Category");
		Iterator<HashMap<String, String>> itr=td.iterator();
		Object[][] obj=new Object[td.size()][1];
		int i=0;
		while(itr.hasNext())
		{	
			HashMap<String, String> a=itr.next();
			obj[i++][0]=a;
		}
		test=extent.createTest("Check-Category");
		return obj;         
	}
}
