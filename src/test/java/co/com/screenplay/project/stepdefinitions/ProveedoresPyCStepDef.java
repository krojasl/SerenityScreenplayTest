package co.com.screenplay.project.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
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
import co.com.screenplay.project.tasks.ProveedoresPyCWhenTask;
import co.com.screenplay.project.tasks.ProveedoresPyCAndTask;
import org.hamcrest.Matchers;

@Slf4j
public class ProveedoresPyCStepDef {

    public String roleUserPyC;

    @Before
    @Given("^abre sitio web de plataforma rimac a PyC$")
    public void abreSitioWebDePlataformaRimacAPyC() {
        System.out.println("Proveedores PyC Step - 1");
        theActorCalled(ACTOR).attemptsTo(
                Open.url(urlSecurityIni)
        );
        System.out.println("Proveedores PyC Step - 2");
        waiting(TIME_SHORT);
        System.out.println("Proveedores PyC Step - 3");
        theActorInTheSpotlight().should(
                seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_RIMAC)
                )
        );
        System.out.println("Proveedores PyC Step - 4");
    }

    @And("^configurar el rol de usuario \"([^\"]*)\" a P&C$")
    public void configurarElRolDeUsuarioAPC(String rolUser) {
        System.out.println("Proveedores PyC Step - 5");
        roleUserPyC = rolUser;
        theActorInTheSpotlight().attemptsTo(
                ProveedoresPyCAndTask.configRolUsuario(rolUser) // Task para acceder al módulo
        );
        System.out.println("Proveedores PyC Step - 6");
    }

    @When("^acceder al modulo de Proveedores P&C$")
    public void accederAlModuloDeProveedoresPC() {
        System.out.println("Proveedores PyC Step - 7");
        theActorInTheSpotlight().attemptsTo(
               ProveedoresPyCWhenTask.accessPyC()
        );
        System.out.println("Proveedores PyC Step - 8");
    }

    @Then("^visualizar las funcionalidades del rol para este modulo Proveedores P&C$")
    public void visualizarLasFuncionalidadesDelRolParaEsteModuloProveedoresPC() {
        System.out.println("Proveedores PyC Step - 9");

        System.out.println("Proveedores PyC Step - 10");
    }

}
