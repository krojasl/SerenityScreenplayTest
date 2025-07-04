package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoFinanzasUi.*;
import static co.com.screenplay.project.ui.BoSecurityUi.*;
import static co.com.screenplay.project.utils.BoFinanzas.CONTRASENA;
import static co.com.screenplay.project.utils.BoFinanzas.CORREO;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BoSecurityWhenTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("BO_SECURITY_WHEN_Task - 02");
        actor.attemptsTo(
                Enter.theValue(CORREO).into(FIELEMAIL),
                Click.on(BTN_SIGUIENTE_LOGIN)
        );
        System.out.println("BO_SECURITY_WHEN_Task - 03");
        actor.attemptsTo(Scroll.to(FIELD_PASSWORD));
        System.out.println("BO_SECURITY_WHEN_Task - 003");
        actor.attemptsTo(
                WaitUntil.the(FIELD_PASSWORD, isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(CONTRASENA).into(FIELD_PASSWORD)
        );
        System.out.println("BO_SECURITY_WHEN_Task - 04");
        actor.attemptsTo(
                Click.on(BTN_LOGIN)
        );
        System.out.println("BO_SECURITY_WHEN_Task - 05");
        // hay que ingresar un codigo del autenticator
        // --- INICIO DE LA ESPERA DE 1 MINUTOS ---
        System.out.println("Esperando 1 minutos...");
        waiting(50); //
        System.out.println("Espera de 1 minutos finalizada.");
        // --- FIN DE LA ESPERA DE 2 MINUTOS ---
        actor.attemptsTo(
                WaitUntil.the(BTN_NO, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(BTN_NO)
        );
        System.out.println("Saliendo despues de click en boton 'NO' - 06");
    }

    //Encapsulamiento
    public static BoSecurityWhenTask accessLogin(){
        System.out.println("BO_Security_WHEN_Task - 01");
        return Tasks.instrumented(BoSecurityWhenTask.class);
    }
}
