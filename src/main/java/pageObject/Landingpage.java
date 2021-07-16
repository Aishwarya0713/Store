package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage{

	public WebDriver driver;
	
	By login0=By.xpath("//*[@id=\"login2\"]");
	By login=By.xpath("//*[@id=\"loginusername\"]");
	By login1=By.xpath("//*[@id=\"loginpassword\"]");
	By login2=By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
	By login3=By.xpath("//*[@id=\"nameofuser\"]");
	By signup1=By.xpath("//*[@id=\"signin2\"]");
	By signup2=By.xpath("//*[@id=\"sign-username\"]");
	By signup3=By.xpath("//*[@id=\"sign-password\"]");
	By signup4=By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
	By contact=By.xpath("//*[@data-target=\"#exampleModal\"]");
	By contact1=By.xpath("//*[@id=\"recipient-email\"]");
	By contact2=By.xpath("//*[@id=\"recipient-name\"]");
	By contact3=By.xpath("//*[@id=\"message-text\"]");
	By contact4=By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");
	
	By Category=By.xpath("//*[@id='itemc']");
	By plp=By.xpath("//*[@id='tbodyid']/child::*/child::div/div/h4/a");
	
	public Landingpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public List<WebElement> Category()
    {
 return driver.findElements(Category);       
    }
	public List<WebElement> plp() {
		return driver.findElements(plp);
	}
	
	
	public WebElement contact() {
		return driver.findElement(contact);
	}
	
	public WebElement Email() {
		return driver.findElement(contact1);
	}
	
	public WebElement Name() {
		return driver.findElement(contact2);
	}
	
	public WebElement Message() {
		return driver.findElement(contact3);
	}
	
	public WebElement contact4() {
		return driver.findElement(contact4);
	}
	
	public WebElement signup1() {
		return driver.findElement(signup1);
	}
	
	public WebElement Username1() {
		return driver.findElement(signup2);
	}
	
	public WebElement password1() {
		return driver.findElement(signup3);
	}
	
	public WebElement signup() {
		return driver.findElement(signup4);
	}
	
	public WebElement login1() {
		return driver.findElement(login0);
	}
	public WebElement Username() {
		return driver.findElement(login);
	}
	public WebElement password() {
		return driver.findElement(login1);
		}
	public WebElement login() {
		return driver.findElement(login2);
	}

	public WebElement Welcomeuser() {
		
		return driver.findElement(login3);
	}
	
	
}
