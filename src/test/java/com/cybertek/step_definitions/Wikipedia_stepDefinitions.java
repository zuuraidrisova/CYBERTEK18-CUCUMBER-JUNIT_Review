package com.cybertek.step_definitions;

import com.cybertek.pages.WikipediaSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wikipedia_stepDefinitions {

    /*
    TC25: Wikipedia Search Functionality Title Verification
        1. User is on Wikipedia home page: https://www.wikipedia.com
        2. User types Steve Jobs in the wiki search box
        3. User clicks wiki search button
        4. User sees Steve Jobs is in the wiki title
    #Note: Follow POM
     */
    WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();

    @Given("User is on the Wikipedia home page")
    public void user_is_on_the_wikipedia_home_page() {

        Driver.getDriver().get("https://www.wikipedia.com");
    }

    @When("User types {string} in the wiki search")
    public void user_types_in_the_wiki_search(String searchValue) {

        wikipediaSearchPage.searchBox.sendKeys(searchValue);

    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {

        wikipediaSearchPage.searchButton.click();
    }

    @Then("User should see {string} is in the wiki title")
    public void user_should_see_is_in_the_wiki_title(String searchValue) throws InterruptedException {

        String expectedInTitle = searchValue;
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        System.out.println("Wikipedia Title Verification Passed!");

        Thread.sleep(1000);

       // Driver.closeDriver(); we already have this tearDown in our After method in Hooks class
    }

    /*
    TC#26: Wikipedia Search Functionality Header Verification
        1. User is on Wikipedia home page
        2. User types Steve Jobs in the wiki search box
        3. User clicks wiki search button
        4. User sees Steve Jobs is in the main header
    Note: Follow POM
     we are implementing only last Then part, because other steps have already been implemented
     */

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String searchValue) throws InterruptedException {

        String actualHeaderText = wikipediaSearchPage.mainHeader.getText();
        String expectedHeaderText = searchValue;

        Assert.assertEquals(actualHeaderText, expectedHeaderText);

        System.out.println("Wikipedia Search Functionality Header Verification Passed!");

        Thread.sleep(1000);

       // Driver.closeDriver(); we already have this tearDown in our After method in Hooks class

    }

     /*
    TC#27: Wikipedia Search Functionality Image Header Verification
        1. User is on Wikipedia home page
        2. User types Steve Jobs in the wiki search box
        3. User clicks wiki search button
        4. User sees Steve Jobs is in the image header
    Note: Follow POM
         we are implementing only last Then part, because other steps have already been implemented
     */

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String searchValue) throws InterruptedException{

        String actualHeaderText = wikipediaSearchPage.imageHeader.getText();
        String expectedHeaderText = searchValue;

        Assert.assertEquals(actualHeaderText, expectedHeaderText);

        System.out.println("Wikipedia Search Functionality Image Header Verification Passed!");

        Thread.sleep(1000);

       // Driver.closeDriver(); we already have this tearDown in our After method in Hooks class
    }








}
