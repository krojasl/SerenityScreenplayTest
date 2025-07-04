package co.com.screenplay.project.stepdefinitions.hook;

import co.com.screenplay.project.hook.OpenWeb;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import org.junit.Before;

import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Constants.TITLE;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^'(.*)' abre el sitio web de pruebas$")
    public void alejandroAbreElSitioWebDePruebas(String actor) {
        System.out.println("alejandroAbreElSitioWebDePruebas");
        OnStage.theActorCalled(actor).attemptsTo(
                OpenWeb.browserUrl()
        );

        System.out.println("despues de ONSTAGE");
        waiting(TIME_SHORT);
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE)
               )
        );

        System.out.println("SALIENDO DEL GIVEN");
    }
}