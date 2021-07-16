package pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.base;

public class POManager extends base{
    private WebDriver driver;
    private Landingpage l;
    private PDP PDP;
    private Cart cart;

 

    public POManager(WebDriver wd)
    {
        this.driver=wd;
    }
    
    public Landingpage getHomePage()
    {
        return (l == null) ? l = new Landingpage(driver) : l;
    }
    public PDP getPDP()
    {
        return (PDP == null) ? PDP = new PDP(driver) : PDP;
    }
    public Cart getCart()
    {
        return (cart == null) ? cart = new Cart(driver) : cart;
    }
    public void navigatetoLogin()
    {
        l.login().click();    
    }
public void login(String username,String pass) {
    
    l.Username().sendKeys(username);
    l.password().sendKeys(pass);
    
    l.login().click();
    
}
public void alertaccept(WebDriver wd)
{
    wd.switchTo().alert().accept();
}
public void logout() {
    l.logOut().click();
}
public String getUserName() {
    return l.Welcomeuser().getText();
    
}
public void CreateTestCase(String TestID)
{
    test=extent.createTest(TestID);
}
public void performImplicitWait(WebDriver wd) {
    wd.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
    
}
public void performExplictwait(WebDriver wd,By xpath)
{
    WebDriverWait wait = new WebDriverWait(wd,1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
}

 

    
public By getlogoutxpath() {
    return l.logout;
}
public void NavigatetoContact() {
    l.contact().click();
}
public void EnterContactDetails(String ContactEmail,String ContactName,String Message)
{
    l.Email().sendKeys(ContactEmail);
    
    l.contact().sendKeys(ContactName);
    
    l.Message().sendKeys(Message);
    
}
public void SendMessage() {
    l.Message().click();
}
}
