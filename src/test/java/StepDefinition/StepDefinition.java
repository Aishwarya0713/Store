package StepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObject.Landingpage;
import resources.base;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefinition extends base {

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
     driver = initializeDriver();   
    }
    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        driver.get(strArg1);
    }


    @When("^User enters (.+) and (.+)$")
    public void user_enters_and(String username, String password) throws Throwable {
    	Landingpage l=new Landingpage(driver); 
    	l.Username().sendKeys(username);
		l.password().sendKeys(password);
		
    }

    @Then("^click on login$")
    public void click_on_login() throws Throwable {
    	Landingpage l=new Landingpage(driver); 
    	l.login().click();
    }

}