package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.screenplay.project.ui.BoFinanzasUi.*;
import static co.com.screenplay.project.utils.BoFinanzas.URL_FINANZAS;

public class BoFinanzasWhenTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("BO_Finanzas_And_Task - 03 - validar el flujo de finanzas");
        actor.attemptsTo(
                Open.url(URL_FINANZAS),
                //Click.on(BTN_BO_FINANZAS),
                Click.on(BTN_INICIO_SESION)
        );
    }

    //Encapsulamiento
    public static BoFinanzasWhenTask accessFinanzas(){
        System.out.println("BO_Finanzas_And_Task - 01");
        return Tasks.instrumented(BoFinanzasWhenTask.class);
    }

}
