package demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        //for plugin check https://cucumber.io/docs/cucumber/reporting/
        plugin = {
                "json:build/cucumber-ios.json",
                "pretty",
                "html:build/result"
        },
        features = "src/test/resources/features",
        tags = "",
        monochrome = true)
public class CucumberRunner {

}
