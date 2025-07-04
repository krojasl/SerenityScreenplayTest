package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.LoginQuestions;
import co.com.screenplay.project.tasks.LoginTask;
import co.com.screenplay.project.tasks.LoginValidationTask;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static co.com.screenplay.project.utils.Constants.ACTOR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import net.serenitybdd.screenplay.GivenWhenThen; // Para usar should(seeThat(...))
import org.hamcrest.Matchers;

@Slf4j
public class LoginStepDefinitions {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        System.out.println("INICIO");
    }

    @And("^ingresa las credenciales$")
    public void ingresaLasCredenciales(){
        //se desarrolla primera tarea donde se ingresa los valores en los campos correspondientes
        System.out.println("loginStep-1");
        OnStage.theActorCalled(ACTOR).attemptsTo(LoginTask.forLogin());
        System.out.println("loginStep-2");
    }

    @When("^valida el inicio de sesion$")
    public void validaElInicioDeSesion() {
        System.out.println("loginStep-3");
        //se desarrolla otra tarea para validar los datos ingresado del login
        /*
        OnStage.theActorCalled(ACTOR).attemptsTo(
                LoginValidationTask.onTheApplication());
        */
        //opcion B
        theActorInTheSpotlight().attemptsTo(
                LoginValidationTask.onTheApplication());
        System.out.println("loginStep-4");
    }

    @Then("^visualizara la vista home$")
    public void visualizaraLaVistaHome() {
        System.out.println("loginStep-5");
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        LoginQuestions.displayed(), // El actor hace la pregunta: "¿Cuál es el título de la página Home?"
                        Matchers.is(true) // Aserción: Esperamos que la pregunta devuelva TRUE
                )
        );
    }
}