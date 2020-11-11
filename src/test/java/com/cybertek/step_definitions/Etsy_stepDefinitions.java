package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_stepDefinitions {

    /*
    TC51: Etsy Title Verification
User is on https://www.etsy.com
User sees title is as expected.
Expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
Note: Follow POM
     */
    @Given("User is on the etsy home page")
    public void user_is_on_the_etsy_home_page() {

        Driver.getDriver().get("https://www.etsy.com");
    }

    @Then("User should see title as expected")
    public void user_should_see_title_as_expected() throws InterruptedException{

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        System.out.println("Etsy title verification passed!");

        Thread.sleep(1000);

       // Driver.closeDriver();
        //we already have this tearDown in our After method in Hooks class
    }

    /*
    TC#52: Etsy Search Functionality Title Verification (without parameterization)
User is on https://www.etsy.com
User types Wooden Spoon in the search box
User clicks search button
User sees Wooden Spoon is in the title
Note: Follow POM
     */

    EtsySearchPage etsySearchPage = new EtsySearchPage();

    @When("User types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {

        etsySearchPage.searchBox.sendKeys("Wooden spoon");
    }

    @And("User clicks search box")
    public void userClicksSearchBox() {

        etsySearchPage.searchButton.click();
    }

    @Then("User should see Wooden Spoon is in the title")
    public void userShouldSeeWoodenSpoonIsInTheTitle() throws InterruptedException {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "Wooden spoon";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        System.out.println("Etsy Search Title Verification Passed!");

        Thread.sleep(1000);

       // Driver.closeDriver();
        //we already have this tearDown in our After method in Hooks class
    }

    /*
    TC#53: Etsy Search Functionality Title Verification (with parameterization)
User is on https://www.etsy.com
User types Wooden Spoon in the search box
User clicks search button
User sees Wooden Spoon is in the title
Note: Follow POM
     */
    @When("User types {string} in the search box")
    public void userTypesInTheSearchBox(String searchValue) {

        etsySearchPage.searchBox.sendKeys(searchValue);
    }

    @And("User clicks to search box")
    public void userClicksToSearchBox() {

        etsySearchPage.searchButton.click();
    }




}
