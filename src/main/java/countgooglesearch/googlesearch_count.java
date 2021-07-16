package countgooglesearch;

 

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import resources.base;

 

public class googlesearch_count extends base {
    @Test
    public void resultcount() throws IOException {
        WebDriver wd = initializeDriver();
        wd.get("https://www.google.com/");
        
          By searchbar=By.xpath(
          "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input");
          By result=By.xpath("//div[@id='search']//div[@class=\"g\"]//h3[not(ancestor::div[@class=\"ygGdYd related-question-pair\"])]");
          wd.findElement(searchbar).sendKeys("qualitest");
         wd.findElement(searchbar).sendKeys(Keys.ENTER);
         
          wd.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
          
          List<WebElement> links = wd.findElements(result);
          System.out.println("The number of links is " + links.size());
   
    }

 

}