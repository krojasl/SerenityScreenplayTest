package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.BoPycQuestion;
import co.com.screenplay.project.questions.BoRiesgosQuestion;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import static co.com.screenplay.project.utils.BoFinanzas.TITLE_RIMAC;
import static co.com.screenplay.project.utils.BoSecurity.urlSecurityIni;
import static co.com.screenplay.project.utils.Constants.ACTOR;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import co.com.screenplay.project.tasks.BoPyCWhenTask;
import co.com.screenplay.project.tasks.BoPycAndTask;
import net.serenitybdd.screenplay.actions.Open;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;

public class BoPyCStepDefinitions {

    public String roleUserBoPyC;

    @Given("^abre sitio web de plataforma rimac a BO PYC$")
    public void abreSitioWebDePlataformaRimacABOPYC() {
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
        System.out.println("Saliendo a la funcion GIVEN");
    }

    @And("^configurar el rol de usuario \"([^\"]*)\" a BO PYC$")
    public void configurarElRolDeUsuarioABOPYC(String rolUser) {
        System.out.println("accede a la funcion AND");
        roleUserBoPyC = rolUser;
        theActorInTheSpotlight().attemptsTo(
                BoPycAndTask.configRolUsuario(rolUser) // Task para acceder al módulo
        );
        System.out.println("Saliendo a la funcion AND");
    }

    @When("^acceder al modulo de BO PYC$")
    public void accederAlModuloDeBOPYC() {
        System.out.println("accede a la funcion WHEN");
        theActorInTheSpotlight().attemptsTo(
                BoPyCWhenTask.accessBoPyC()
        );
        System.out.println("Saliendo a la funcion WHEN");
    }

    @Then("^visualizar las funcionalidades del rol para este modulo BO PYC$")
    public void visualizarLasFuncionalidadesDelRolParaEsteModuloBOPYC() {
        System.out.println("accede a la funcion THEN");
        theActorInTheSpotlight().should(
                seeThat(BoPycQuestion.validarCondicionBoPyc(roleUserBoPyC))
        );
        System.out.println("Saliendo a la funcion THEN");
    }
}
