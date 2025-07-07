package co.com.screenplay.project.runners;

import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"co.com.screenplay.project.stepdefinitions"},
        snippets = SnippetType.CAMELCASE,
        tags = "@BACKOFFICE_RIESGOS",
        plugin = {"pretty"}
)

public class RunnerOpenWeb {

}
