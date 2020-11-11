package com.cybertek.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",       //connects our feature files
        glue = "com/cybertek/step_definitions"   //connects our step definitions"


)
public class FailedTestRunner {

}
