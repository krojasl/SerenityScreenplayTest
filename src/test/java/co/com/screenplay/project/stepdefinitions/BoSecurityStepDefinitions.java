package co.com.screenplay.project.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import co.com.screenplay.project.tasks.BoSecurityAndTask;
import co.com.screenplay.project.tasks.BoSecurityWhenTask;
import static co.com.screenplay.project.utils.BoFinanzas.TITLE_RIMAC;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import co.com.screenplay.project.questions.BoSecurityQuestions;
import org.hamcrest.Matchers;

@Slf4j
public class BoSecurityStepDefinitions {

    @Given("^'(.*)' abre el sitio web de plataforma rimac con portal Seguridad$")
    public void seguridadAbreElSitioWebDePlataformaRimacConPortalSeguridad(String actor) {
        OnStage.setTheStage(new OnlineCast());
        System.out.println("INICIO DE BO SECURITY");

        theActorCalled(actor).attemptsTo(
               // OpenWeb.browserUrl()
                Open.url("https://feature-boseguridad-new-repo-seguridad.d2tnp7k9a49kwc.amplifyapp.com")
        );

        System.out.println("BO_SECURITY Step - 2");
        waiting(TIME_SHORT);
        System.out.println("BO_SECURITY Step - 3");
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_RIMAC)
                )
        );
        System.out.println("BO_SECURITY Step - 4");
    }

    @And("^acceder al modulo de seguridad$")
    public void accederAlModuloDeSeguridad() {
        System.out.println("BO_SECURITY Step - 5");
        theActorInTheSpotlight().attemptsTo(
                BoSecurityAndTask.accessSecurity() // Task para acceder al módulo
        );
        System.out.println("BO_SECURITY Step - 6");
    }

    @When("^ingrese las credenciales al portal seguridad$")
    public void ingreseLasCredencialesAlPortalSeguridad() {
        System.out.println("BO_SECURITY Step - 7");
        theActorInTheSpotlight().attemptsTo(
                BoSecurityWhenTask.accessLogin()// Task para acceder al módulo
        );
        System.out.println("BO_SECURITY Step - 8");
    }

    @Then("^visualizar las funcionalidades del rol para este modulo seguridad$")
    public void visualizarLasFuncionalidadesDelRolParaEsteModuloSeguridad() {
        System.out.println("BO_SECURITY Step THEN - 9");
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        BoSecurityQuestions.displayed(), // El actor hace la pregunta: "¿Cuál es el título de la página Home?"
                        Matchers.is(true) // Aserción: Esperamos que la pregunta devuelva TRUE
                )
        );
        System.out.println("BO_SECURITY Step THEN - 10");
    }
}
