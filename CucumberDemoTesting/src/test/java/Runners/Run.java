package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Statev\\IdeaProjects\\CucumberDemoTesting\\src\\test\\resources",
        glue = "StepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty",
                "html:test-output"}
)

public class Run {
}
