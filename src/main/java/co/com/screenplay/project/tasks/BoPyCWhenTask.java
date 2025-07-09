package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoFinanzasUi.BTN_INICIO_SESION;
import static co.com.screenplay.project.ui.BoPyCUi.BTN_BO_PYC;
import static co.com.screenplay.project.ui.BoPyCUi.BTN_SECTION_PYC;
import static co.com.screenplay.project.utils.BoPyC.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BoPyCWhenTask  implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("BO_PyC_And_Task - 02 - Inicio el flujo de BO PYC");
        actor.attemptsTo(
                Open.url(URL_BO_PYC),
                Click.on(BTN_SECTION_PYC),
                WaitUntil.the(BTN_BO_PYC, isVisible()).forNoMoreThan(30).seconds(),
                JavaScriptClick.on(BTN_BO_PYC),
                Click.on(BTN_INICIO_SESION)
        );
    }

    //Encapsulamiento
    public static BoPyCWhenTask accessBoPyC(){
        System.out.println("BO_PyC_And_Task - 01");
        return Tasks.instrumented(BoPyCWhenTask.class);
    }
}
