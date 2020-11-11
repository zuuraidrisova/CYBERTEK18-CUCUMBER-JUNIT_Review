package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",   //generates html type of report
                   "json:target/cucumber.json",         //generates json type of report
                    "rerun:target/rerun.txt"},
        features = "src/test/resources/features",       //connects our feature files
        glue = "com/cybertek/step_definitions",         //connects our step definitions
        dryRun = false,
        tags = "@smartBearScenarioOutline"                           //specifies which scenario should run

)
public class CukesRunner {

}
