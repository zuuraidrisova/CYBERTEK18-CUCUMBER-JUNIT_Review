package com.cybertek.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;

public class DataTable_stepDefinitions {

    @Then("User should see below words displayed")
    public void user_should_see_below_words_displayed(List<String>fruitList) {

        //print the size of fruit list
        System.out.println("fruitList.size() = " + fruitList.size());

        //print the items of fruit list

        for (String eachFruit: fruitList){

            System.out.println("eachFruit = " + eachFruit);
        }
    }

}
