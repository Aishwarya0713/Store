package pageObject;

 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

 

public class PDP {
    WebDriver driver;
    By PDPname=By.xpath("//*[@id=\"tbodyid\"]/h2");
    By PDPprice=By.xpath("//*[@id=\"tbodyid\"]/h3");
    By PDPAddtocart=By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    public PDP(WebDriver wd) {
        this.driver = wd;
    }
    public WebElement pdpName()
    {
        return driver.findElement(PDPname);
        
    }
    public WebElement pdpPrice()
    {
        return driver.findElement(PDPprice);
        
    }
    public WebElement pdpAddtocart()
    {
        return driver.findElement(PDPAddtocart);
        
    }
    
}