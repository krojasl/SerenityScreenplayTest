package co.com.screenplay.project.stepdefinitions;

import co.com.screenplay.project.questions.ValidateElementsTextBtn;
import co.com.screenplay.project.tasks.ChooseRandomTask;
import co.com.screenplay.project.tasks.FuntionsElementsTask;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static co.com.screenplay.project.utils.Constants.ACTOR;
import static co.com.screenplay.project.utils.Constants.REMEMBER_TEXT_BTN_SUB_ELEMENTS;
import static co.com.screenplay.project.utils.DataFaker.fakerNumberOneAndNine;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

@Slf4j
public class OpenWebStep {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        System.out.println("hola ");
    }

    @When("ingrese al navegador chrome")
    public void ingreseAlNavegadorChrome() {
        System.out.println("ingrese al navegador chrome");

    }

    @Then("^visualizara el titulo de la pagina '(.*)'$")
    public void visualizaraElTituloDeLaPagina(String cucumber) {
        System.out.println("visualizara el titulo de la pagina");

    }

    @And("^desea validar la funcion de la cartera de elementos$")
    public void deseaValidarLaFuncionDeLaCarteraDeElementos() {
        System.out.println("desea validar la funcion de la cartera de elementos");
        OnStage.theActorCalled(ACTOR).attemptsTo(FuntionsElementsTask.choose());
        System.out.println("FIN-desea validar la funcion de la cartera de elementos");
    }

    @When("^selecciona aleatoriamente alguna de las subfunciones$")
    public void randomlySelectsOneOfTheSubfunctions() {
        System.out.println("INI-selecciona aleatoriamente alguna de las subfunciones");
        OnStage.theActorCalled(ACTOR).attemptsTo(ChooseRandomTask.witchParams(fakerNumberOneAndNine()));
        System.out.println("selecciona aleatoriamente alguna de las subfunciones");
    }

    @Then("^visualizara en la cabecera el nombre de la opcion elegida$")
    public void WillDisplayInTheHeaderTheNameOfTheChosenOption() {
        System.out.println("visualizara en la cabecera el nombre de la opcion elegida");
        String validateText = OnStage.theActor(ACTOR).recall(REMEMBER_TEXT_BTN_SUB_ELEMENTS);
        System.out.println("visualizara--1");
        if (validateText != null){
            System.out.println("visualizara--2");
            log.info(validateText);
            System.out.println("visualizara--3");
        }
        System.out.println("visualizara--4 - "+validateText);
        theActorInTheSpotlight().should(seeThat(
                ValidateElementsTextBtn.witchParams(validateText))
        );
        System.out.println("visualizara--5");
    }
}
