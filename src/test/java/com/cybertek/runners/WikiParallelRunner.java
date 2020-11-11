package com.cybertek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumber3.json",
        features = "src/test/resources/features/WikipediaSearch.feature",
        glue = "com/cybertek/step_definitions"
)
public class WikiParallelRunner {
}
