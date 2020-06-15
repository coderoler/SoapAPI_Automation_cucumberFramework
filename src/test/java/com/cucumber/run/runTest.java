package com.cucumber.run;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/APIfeatures"},
glue = {"com.cucumberframework.runsteps"},
plugin = {"html:target/cucumber","json:target/cucumber.json",
		"pretty"}
)
public class runTest {

}
