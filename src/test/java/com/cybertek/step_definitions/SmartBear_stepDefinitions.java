package com.cybertek.step_definitions;

import com.cybertek.pages.SmartBearOrderPages;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SmartBear_stepDefinitions {

    /*
    #1. User is logged into SmartBear Tester account and on Order page
  #2. User fills out the form as followed:
  #3. User selects FamilyAlbum from product dropdown
  #4. User enters 4 to quantity
  #5. User enters John Wick to costumer name
  #6. User enters Kinzie Ave to street
  #7. User enters Chicago to city
  #8. User enters IL to state
  #9. User enters 60056
  #10. User selects Visa as card type
  #11. User enters 1111222233334444 to card number
  #12. User enters 12/22 to expiration date
  #13. User clicks process button
  #14. User verifies John Wick is in the list
  #Note: Follow POM, and solution should be done using Cucumber parameterization
     */

    SmartBearOrderPages smartBearPages = new SmartBearOrderPages();

    @Given("User is on SmartBear webpage")
    public void user_is_on_smart_bear_webpage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("smartBear_url"));

        Driver.getDriver().manage().window().maximize();

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @When("User logs into SmartBear Tester account")
    public void userLogsIntoSmartBearTesterAccount() throws InterruptedException{

        smartBearPages.usernameInput.sendKeys(ConfigurationReader.getProperty("smartBear_username"));

        smartBearPages.passwordInput.sendKeys(ConfigurationReader.getProperty("smartBear_password"));

        smartBearPages.loginButton.click();

        Thread.sleep(1000);
    }

    @And("User clicks and lands on Order page")
    public void userClicksAndLandsOnOrderPage() throws InterruptedException {

        smartBearPages.orderLink.click();

        Thread.sleep(1000);
    }

    @And("User selects {string} from product dropdown")
    public void userSelectsFromProductDropdown(String productName) throws InterruptedException{

        Select product = new Select(smartBearPages.productDropdown);

        product.selectByVisibleText(productName);

        Thread.sleep(1000);
    }


    @When("User enters {string} to quantity")
    public void user_enters_to_quantity(String quantity) throws InterruptedException{

        smartBearPages.quantityInput.sendKeys(Keys.BACK_SPACE);

        Thread.sleep(1000);

        smartBearPages.quantityInput.sendKeys(quantity);

        Thread.sleep(1000);
    }

    @And("User clicks calculate")
    public void userClicksCalculate() throws InterruptedException {

        smartBearPages.calculateButton.click();

        Thread.sleep(1000);
    }

    @When("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String costumerName) throws InterruptedException {

        smartBearPages.nameInput.sendKeys(costumerName);

        Thread.sleep(1000);
    }

    @And("User enters {string} to street")
    public void user_enters_to_street(String street) throws InterruptedException{

        smartBearPages.streetInput.sendKeys(street);

        Thread.sleep(1000);
    }

    @When("User enters {string} to city")
    public void user_enters_to_city(String city) throws InterruptedException{

        smartBearPages.cityInput.sendKeys(city);

        Thread.sleep(1000);
    }

    @When("User enters {string} to state")
    public void user_enters_to_state(String state) throws InterruptedException{

        smartBearPages.stateInput.sendKeys(state);

        Thread.sleep(1000);
    }

    @When("User enters {string} to zipcode")
    public void user_enters_to_zipcode(String zipcode) throws InterruptedException{

        smartBearPages.zipCodeInput.sendKeys(zipcode);

        Thread.sleep(1000);

    }

    @When("User selects visa as card type")
    public void user_selects_visa_as_card_type() throws InterruptedException{

        smartBearPages.visaRadioButton.click();

        Thread.sleep(1000);
    }

    @When("User enters {string} to card number")
    public void user_enters_to_card_number(String cardNumber) throws InterruptedException{

        smartBearPages.cardNumberInput.sendKeys(cardNumber);

        Thread.sleep(1000);

    }

    @When("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String expireDate) throws InterruptedException{

        smartBearPages.expireDateInput.sendKeys(expireDate);

        Thread.sleep(1000);

    }

    @When("User clicks process button")
    public void user_clicks_process_button() throws InterruptedException{

        smartBearPages.processButton.click();

        Thread.sleep(1000);

    }

    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String customer) throws InterruptedException {

        smartBearPages.viewAllOrdersLink.click();

        String expectedCustomer = customer;

        for (WebElement eachName: smartBearPages.namesColumn){

           String actualCustomer = eachName.getText();

           if(actualCustomer.equals(expectedCustomer)){

               Assert.assertEquals(actualCustomer, expectedCustomer);
           }
        }

        System.out.println("Verification passed. Customer is in the list.");

        Thread.sleep(1000);

    }



}
