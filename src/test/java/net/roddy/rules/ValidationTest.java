package net.roddy.rules;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumber_html/validation/",
                            "json:target/json-validation.json",
                            "junit:target/junit-validation.xml"},
                 glue = {"net.roddy.rules"},
                 features = "src/test/resources/features/Validation.feature")
public class ValidationTest {

}