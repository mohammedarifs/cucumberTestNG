package CucumbeTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/Features", glue={"CucumbeTest"},
plugin= {"pretty","html:target/reports/cucmber.html","pretty","junit:target/reports/cucumber.html"}, tags="@Test", monochrome = true)


public class testRunner {

}
