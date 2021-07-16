package pageObject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Cart {
    WebDriver driver;
    By Total=By.xpath("//*[@id=\"totalp\"]");
    By PlaceOrder=By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    By TotalNproduct=By.xpath("//*[@id=\"tbodyid\"]/tr");

 

    By Pname=By.xpath("//*[@id=\"name\"]");
    By Pcountry=By.xpath("//*[@id=\"country\"]");
    By Pcity=By.xpath("//*[@id=\"city\"]");
    By Pcreditcard=By.xpath("//*[@id=\"card\"]");
    By Pmonth=By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
    By Pyear=By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
    By Purchase=By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    By Close=By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[1]");
    By OrderC=By.xpath("/html/body/div[10]/p");
    By OrderOk=By.xpath("/html/body/div[10]/div[7]/div/button");
    By Oderdetails=By.xpath("/html/body/div[10]/p");
    
    public Cart(WebDriver wd) {
        super();
        this.driver = wd;
    }
    public WebElement title(int i)
    {
        By Title=By.xpath("//*[@id='tbodyid']/tr["+i+"]/td[2]");
 return driver.findElement(Title);        
    }
    public WebElement price(int i)
    {
        By Price=By.xpath("//*[@id='tbodyid']/tr["+i+"]/td[3]");
 return driver.findElement(Price);        
    }
    public WebElement delete(int i)
    {
        By delete=By.xpath("//*[@id='tbodyid']/tr["+i+"]/td[4]");
 return driver.findElement(delete);        
    }
    public WebElement total()
    {
 return driver.findElement(Total);        
    }
    public WebElement placeOrder()
    {
 return driver.findElement(PlaceOrder);        
    }
    public int totalNproduct()
    { 
        List<WebElement> tp=driver.findElements(TotalNproduct);
 return tp.size();        
    }

 

    public WebElement pname()
    {
 return driver.findElement(Pname);        
    }
    public WebElement pcountry()
    {
 return driver.findElement(Pcountry);        
    }
    public WebElement pCity()
    {
 return driver.findElement(Pcity);        
    }
    public WebElement creditcard()
    {
 return driver.findElement(Pcreditcard);        
    }
    public WebElement pMonth()
    {
 return driver.findElement(Pmonth);        
    }
    public WebElement pYear()
    {
 return driver.findElement(Pyear);        
    }
    public WebElement purchase()
    {
 return driver.findElement(Purchase);        
    }
    public WebElement colse()
    {
 return driver.findElement(Close);        
    }
    public WebElement orederc()
    {
 return driver.findElement(OrderC);        
    }
    public WebElement orderOk()
    {
 return driver.findElement(OrderOk);        
    }
    public WebElement orderDetails()
    {
 return driver.findElement(Oderdetails);        
    }
}