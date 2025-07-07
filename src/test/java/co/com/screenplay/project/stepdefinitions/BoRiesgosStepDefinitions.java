package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.BoRiesgosQuestion;
import co.com.screenplay.project.questions.ProvPyCQuestion;
import co.com.screenplay.project.tasks.BoRiesgosAndTask;
import co.com.screenplay.project.tasks.BoRiesgosWhenTask;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import static co.com.screenplay.project.utils.BoFinanzas.TITLE_RIMAC;
import static co.com.screenplay.project.utils.BoSecurity.urlSecurityIni;
import static co.com.screenplay.project.utils.Constants.ACTOR;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.hamcrest.Matchers;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BoRiesgosStepDefinitions {

    public String roleUserRiesgos;

    @Given("^abre sitio web de plataforma rimac a BO RIESGOS$")
    public void abreSitioWebDePlataformaRimacABORIESGOS() {
        System.out.println("accede a la funcion GIVEN");
        theActorCalled(ACTOR).attemptsTo(
                Open.url(urlSecurityIni)
        );
        System.out.println("GIVEN - 2");
        waiting(TIME_SHORT);
        System.out.println("GIVEN - 3");
        theActorInTheSpotlight().should(
                seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_RIMAC)
                )
        );
        System.out.println("Salida a la funcion GIVEN");
    }

    @And("^configurar el rol de usuario \"([^\"]*)\" a BO RIESGOS$")
    public void configurarElRolDeUsuarioABORIESGOS(String rolUser) {
        System.out.println("accede a la funcion AND");
        roleUserRiesgos = rolUser;
        theActorInTheSpotlight().attemptsTo(
                BoRiesgosAndTask.configRolUsuario(rolUser) // Task para acceder al módulo
        );
        System.out.println("Salida a la funcion AND");
    }

    @When("^acceder al modulo de BO RIESGOS$")
    public void accederAlModuloDeBORIESGOS() {
        System.out.println("accede a la funcion WHEN");
        theActorInTheSpotlight().attemptsTo(
                BoRiesgosWhenTask.accessBoRiesgos()
        );
        System.out.println("Salida a la funcion WHEN");
    }

    @Then("^visualizar las funcionalidades del rol para este modulo BO RIESGOS$")
    public void visualizarLasFuncionalidadesDelRolParaEsteModuloBORIESGOS() {
        System.out.println("accede a la funcion THEN");
        theActorInTheSpotlight().should(
                seeThat(BoRiesgosQuestion.validarCondicionesRiesgos(roleUserRiesgos))
        );
        System.out.println("Salida a la funcion THEN");
    }
}