package testRunners;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="test/testFeatures",glue="")
public class TestRunner_CreateDeleteUser {
	
}
