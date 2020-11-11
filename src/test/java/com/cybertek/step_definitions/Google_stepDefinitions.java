package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class Google_stepDefinitions {

    @Given("User is on the google search page")
    public void user_is_on_the_google_search_page() {

        Driver.getDriver().get("https://www.google.com");

    }

    @Then("User should see title is Google")
    public void user_should_see_title_is_google() throws InterruptedException {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Google Default Title Verification passed!");

      //  Assert.fail("My assert fail");

        Thread.sleep(1000);

       // Driver.closeDriver();
        //we already have this tearDown in our After method in Hooks class
    }

    //creating an object of search page class at class level so we can use them in all {}
    GoogleSearchPage searchPage = new GoogleSearchPage();

    @When("User searches apple")
    public void userSearchesApple() {

        //sending apple to search box
        searchPage.searchBox.sendKeys("apple"+ Keys.ENTER);
    }

    @Then("User should see apple in title")
    public void userShouldSeeAppleInTitle() throws InterruptedException{

        String expectedInTitle = "apple";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        System.out.println("Google Title Verification passed!");

        Thread.sleep(1000);

        //Driver.closeDriver();
        //we already have this tearDown in our After method in Hooks class
    }


    @When("User searches {string}")
    public void userSearches(String searchValue) {

        searchPage.searchBox.sendKeys(searchValue + Keys.ENTER);
    }

    @Then("User should see {string} in title")
    public void userShouldSeeInTitle(String searchValue) throws InterruptedException{

        String expectedTitle = searchValue + " - Google Search";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));

        System.out.println("Google Title Verification passed!");

        Thread.sleep(1000);

       // Driver.closeDriver();
        //we already have this tearDown in our After method in Hooks class
    }


    @When("User should see About link")
    public void userShouldSeeAboutLink() {

        Assert.assertTrue(searchPage.aboutLink.isDisplayed());
    }

    @And("User clicks About link")
    public void userClicksAboutLink() {

        searchPage.aboutLink.click();
    }

    @Then("User should see title Google - About Google, Our Culture & Company News")
    public void userShouldSeeTitleGoogleAboutGoogleOurCultureCompanyNews() throws InterruptedException {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Google - About Google, Our Culture & Company News";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        System.out.println("Google Title Verification passed!");

        Thread.sleep(1000);

        //Driver.closeDriver();
        //we already have this tearDown in our After method in Hooks class
    }

    // Verify that on the google search page footer contains 6 links

    @Then("User should see six links in the footer")
    public void user_should_see_six_links_in_the_footer(List<String> linksOnFooter)  throws InterruptedException{

        int expectedSize = linksOnFooter.size();
        int actualSize = searchPage.footerLinks.size();

        Assert.assertEquals(expectedSize, actualSize);

        System.out.println("Footer Verification Passed!");

        Thread.sleep(1000);

        //Driver.closeDriver();
       // we already have this tearDown in our After method in Hooks class

    }


    @Then("User should see {string} is in the title")
    public void userShouldSeeIsInTheTitle(String searchValue) throws InterruptedException{

        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = searchValue;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

        System.out.println("Google Search Title Verification Passed!");

        Thread.sleep(1000);

        // Driver.closeDriver();
        //we already have this tearDown in our After method in Hooks class

    }

}
