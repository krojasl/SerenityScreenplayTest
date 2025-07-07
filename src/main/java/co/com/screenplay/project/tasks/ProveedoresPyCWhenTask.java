package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoFinanzasUi.BTN_INICIO_SESION;
import static co.com.screenplay.project.ui.ProveedoresPyCUi.*;
import static co.com.screenplay.project.utils.ProveedoresPyC.*;
import static co.com.screenplay.project.utils.Time.waiting;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProveedoresPyCWhenTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("PYC WHEN TASK - 2");
        actor.attemptsTo(
                Open.url(urlPyC),
                Click.on(SECTION_PYC),
                Scroll.to(SCROLL_PYC),
                WaitUntil.the(BTN_RRGG_PYC, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(BTN_RRGG_PYC, isEnabled()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_RRGG_PYC),
                Enter.theValue(user).into(FIELD_USUARIO),
                Enter.theValue(pass).into(FIELD_PASS),
                Click.on(BTN_INICIAR_SESION_PYC)
        );
        // --- INICIO DE LA ESPERA DE 1 MINUTOS ---
        System.out.println("Esperando aprox 3 minutos...");
        waiting(210); //
        System.out.println("Esperando aprox 3 minutos finalizada WHEN");
        // --- FIN DE LA ESPERA DE 2 MINUTOS ---
        //DESPUES DE AQUI PIDE CODIGO QUE LLEGA AL CORREO PARA PODER
        System.out.println("PYC WHEN TASK - 3");
    }

    //Encapsulamiento
    public static ProveedoresPyCWhenTask accessPyC(){
        System.out.println("PYC WHEN - 01");
        return Tasks.instrumented(ProveedoresPyCWhenTask.class);
    }
}
