package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.screenplay.project.ui.BoSecurityUi.*;
import static co.com.screenplay.project.utils.BoSecurity.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BoSecurityQuestions implements Question<Boolean> {
    String TXT_PRIMERA_FUNCIONALIDAD;
    //valido los las funcionalidades por rol en este portal y sus sub-menus
    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println("click en primer flujo de la primera opcion con el primer sub-menu");
        WaitUntil.the(TXT_GESTION_PLATAFORMA, isVisible()).forNoMoreThan(30).seconds();
        actor.attemptsTo(WaitUntil.the(TXT_GESTION_PLATAFORMA, isEnabled()).forNoMoreThan(5).seconds());
        System.out.println("paso por la espera");
        // Espera también que tenga texto (opcionalmente un texto específico)
        TXT_PRIMERA_FUNCIONALIDAD = TXT_GESTION_PLATAFORMA.resolveFor(actor).getText();
        System.out.println("Texto: "+TXT_PRIMERA_FUNCIONALIDAD);
        if (TXT_PRIMERA_FUNCIONALIDAD.equals(TXT_PRIMERA_OPCION_FUNCIONALIDAD)){
            actor.attemptsTo(
                    WaitUntil.the(BTN_GESTION_PLATAFORMA, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_GESTION_PLATAFORMA),
                    Click.on(BTN_MANTTO_USUARIOS),
                    Click.on(BTN_GESTION_PLATAFORMA),
                    Click.on(BTN_MANTTO_MENUS),
                    Click.on(BTN_GESTION_PLATAFORMA),
                    Click.on(BTN_MANTTO_PERFILES),
                    Click.on(BTN_GESTION_PLATAFORMA),
                    Click.on(BTN_MANTTO_OPCIONES),
                    Click.on(BTN_GESTION_PLATAFORMA),
                    Click.on(BTN_MANTTO_PORTALES)

            );
            System.out.println("saliendo del primer menu con sus opciones de sub-menu");
            actor.attemptsTo(
                    WaitUntil.the(BTN_GESTION_RIMAC_SALUD, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_GESTION_RIMAC_SALUD),
                    Click.on(BTN_RIMAC_MANTTO_USUARIOS),
                    Click.on(BTN_GESTION_RIMAC_SALUD),
                    Click.on(BTN_RIMAC_MANTTO_PERFILES),
                    Click.on(BTN_GESTION_RIMAC_SALUD),
                    Click.on(BTN_RIMAC_MANTTO_OPCIONES),
                    Click.on(BTN_GESTION_RIMAC_SALUD),
                    Click.on(BTN_MANTTO_ROLES),
                    Click.on(BTN_GESTION_RIMAC_SALUD),
                    Click.on(BTN_MANTTO_APLICACIONES)
            );
            return true;
        }
        else return false;
    }

    public static BoSecurityQuestions displayed(){
        System.out.println("BoSecurityQuestions - 1 ");
        return new BoSecurityQuestions();
    }
}
