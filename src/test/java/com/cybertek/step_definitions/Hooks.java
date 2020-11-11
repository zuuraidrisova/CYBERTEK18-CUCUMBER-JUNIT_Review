package com.cybertek.step_definitions;


import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(order = 2)
    public void setUpScenario(){

        System.out.println("Before annotation:Setting up Browser");
    }

    @Before(value = "@db", order = 1)
    public void setUpDataBaseConnection(){

        System.out.println("Before annotation: DB Connection is created");
    }

    @After
    public void tearDownScenario(Scenario scenario){

        System.out.println("After annotation: Closing Browser");

     //   Scenario class coming from Cucumber allow us to have information about the currently
      //          running scenario
        System.out.println("scenario.getName() = " + scenario.getName());
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        System.out.println("scenario.isFailed() = " + scenario.isFailed());


        /* getScreenshotAs: to be able to use this method we have to cast our
                          driver type to TakesScreenshot
   byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
         */
        if(scenario.isFailed()){ //if scenario is failed , only then take screenshot

            //(TakesScreenshot) is an interface coming from Selenium , which has getScreenshotAs method
                                         //cast our  driver type to TakesScreenshot
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            //#2 we are going to attach it into our report(scenario): using attach method
            //attach method accepts 3 args. #1:Screenshot #2: image type #3 current scenario's name

            scenario.attach(screenshot,"image/png", scenario.getName());
        }


        Driver.closeDriver();
    }

    @After("@db")
    public void closeDBConnection(){

        System.out.println("After annotation: DB Connection is close");
    }

    @BeforeStep
    public void setUpStep(){

      //  System.out.println("====> BEFORE STEP: TAKING SCREENSHOT <====");
    }

    @AfterStep
    public void tearDownStep(){

     //   System.out.println("====> AFTER STEP: TAKING SCREENSHOT <====");
    }



}
