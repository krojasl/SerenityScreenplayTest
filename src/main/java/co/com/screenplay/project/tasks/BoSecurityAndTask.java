package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import static co.com.screenplay.project.ui.BoSecurityUi.BTN_BO_Security;
import static co.com.screenplay.project.ui.BoSecurityUi.BTN_INICIO_SESION_SECURITY;


public class BoSecurityAndTask  implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("BO_SECURITY_And_Task - 02");
        //actor.attemptsTo(Scroll.to(BTN_BO_Security));
        System.out.println("BO_SECURITY_And_Task - despues");
        actor.attemptsTo(
                Click.on(BTN_BO_Security),
                Click.on(BTN_INICIO_SESION_SECURITY)
        );
        System.out.println("BO_SECURITY_And_Task - 03");
        //se dirige a la task BOFINANZASWHENTASK para desarrollar el flujo de logueo
    }

    //Encapsulamiento
    public static BoSecurityAndTask accessSecurity(){
        System.out.println("BoSecurityAndTask - 01");
        return Tasks.instrumented(BoSecurityAndTask.class);
    }
}
