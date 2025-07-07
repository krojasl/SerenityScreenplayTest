package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoFinanzasUi.BTN_INICIO_SESION;
import static co.com.screenplay.project.ui.BoRiesgosUi.*;
import static co.com.screenplay.project.ui.BoSecurityUi.FIELD_EMAIL_FILTRO;
import static co.com.screenplay.project.utils.BoRiesgos.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BoRiesgosWhenTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("BO_Riesgos_And_Task - 02 - validar el flujo de riesgos");
        actor.attemptsTo(
                Open.url(URL_RIESGO),
                WaitUntil.the(BTN_RIESGOS, isVisible()).forNoMoreThan(30).seconds(),
                JavaScriptClick.on(BTN_RIESGOS),
                Click.on(BTN_INICIO_SESION)
        );
    }

    //Encapsulamiento
    public static BoRiesgosWhenTask accessBoRiesgos(){
        System.out.println("BO_Riesgos_And_Task - 01");
        return Tasks.instrumented(BoRiesgosWhenTask.class);
    }
}
