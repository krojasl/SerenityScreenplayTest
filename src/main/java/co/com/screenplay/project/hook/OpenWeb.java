package co.com.screenplay.project.hook;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.screenplay.project.utils.Constants.WEB_URL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenWeb implements Task{

    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        //variables de environment
        String pathWebUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(WEB_URL);
        System.out.println("Attempting to open URL: " + pathWebUrl);
        // Check if the URL is null or empty before trying to open it (good practice)
        if (pathWebUrl == null || pathWebUrl.trim().isEmpty()) {
            throw new IllegalStateException("The 'webdriver.base.url' property is not defined or is empty in serenity.conf. Cannot open browser.");
        }
        // Perform the action to open the URL
        actor.attemptsTo(
                Open.url(pathWebUrl) // Pass the retrieved, valid URL string
        );
        System.out.println("paso linea actor");

    }

    //aplicamos Encapsulamiento
    public static Performable browserUrl(){
        return instrumented(OpenWeb.class);
    }

}
