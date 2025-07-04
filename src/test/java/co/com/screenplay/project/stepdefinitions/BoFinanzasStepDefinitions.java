package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.BoFinanzasQuestions;
import co.com.screenplay.project.tasks.BoFinanzasAndRolUsuarioTask;
import co.com.screenplay.project.tasks.BoFinanzasWhenTask;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;
import static co.com.screenplay.project.utils.BoFinanzas.TITLE_RIMAC;
import static co.com.screenplay.project.utils.Constants.*;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@Slf4j
public class BoFinanzasStepDefinitions {

    public String roleUser;
    @Given("^'(.*)' abre el sitio web de plataforma rimac$")
    public void rimacAbreElSitioWebDePlataformaRimac(String actor) {
        OnStage.setTheStage(new OnlineCast());
        System.out.println("abreElSitioWebDePlataformaRimac");
        theActorCalled(actor).attemptsTo(
                Open.url(UrlFinanzas)
        );
        System.out.println("BO_FINANZAS Step - 2");
        waiting(TIME_SHORT);
        System.out.println("BO_FINANZAS Step - 3");
        theActorInTheSpotlight().should(
                seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_RIMAC)
                )
        );
        System.out.println("BO_FINANZAS Step - 4");
    }

    @And("^configurar el rol de usuario \"([^\"]*)\"$")
    public void configurarElRolDeUsuario(String rolUsuario){
        roleUser = rolUsuario;
        System.out.println("BO_FINANZAS Step - AND - 5");
        theActorInTheSpotlight().attemptsTo(
                BoFinanzasAndRolUsuarioTask.configRolUsuario(rolUsuario) // Task para acceder al módulo
        );
        System.out.println("BO_FINANZAS Step - AND - 6");
    }

    @When("^acceder al modulo de finanzas$")
    public void accederAlModuloDeFinanzas() {
        System.out.println("BO_FINANZAS Step - 7");
        theActorInTheSpotlight().attemptsTo(
                BoFinanzasWhenTask.accessFinanzas()
        );
        System.out.println("BO_FINANZAS Step - 8");
    }

    @Then("^visualizar las funcionalidades del rol para este modulo finanzas$")
    public void visualizarLasFuncionalidadesDelRolParaEsteModuloFinanzas(){
        System.out.println("BO_FINANZAS Step - 11");
        theActorInTheSpotlight().should(
                seeThat(BoFinanzasQuestions.witchParameters(roleUser))
        );
        System.out.println("BO_FINANZAS Step FINISH - 12 "+"- "+roleUser);
    }

}
