package co.com.screenplay.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.ProveedoresPyCUi.*;
import static co.com.screenplay.project.ui.ProveedoresPyCUi.BTN_GESTION_SAL_VEH;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;


@AllArgsConstructor
@Slf4j
public class ProvPyCQuestion implements Question<Boolean> {

    private static String roleUsuario;

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println("entrando a funcion de question");
        if(roleUsuario.equals("G_SIS_PROVPYC_SALV_USER")){
            //VALIDAR LAS OPCIONES SIGUIENTES, POR AHORA COLOCARE UNA ESPERA
            actor.attemptsTo(
                    WaitUntil.the(BTN_VALIDATION, isEnabled()).forNoMoreThan(30).seconds(), //AQUI coloco el codigo mientras se cumple esta espera
                    Click.on(BTN_VALIDATION),
                    WaitUntil.the(BTN_FIST_PYC, isEnabled()).forNoMoreThan(30).seconds(), //AQUI coloco el codigo mientras se cumple esta espera
                    Click.on(BTN_FIST_PYC),
                    Click.on(BTN_SECOND_PYC),
                    Click.on(BTN_GESTION_SAL_VEH)
            );
        }
        System.out.println("saliendo  de funcion Question");
        return true;
    }

    public static ProvPyCQuestion validarCCondicionesPyC(String rolUsuario) {
        roleUsuario = rolUsuario;
        System.out.println("Proveedores PyC Question - 1 " + roleUsuario);
        return new ProvPyCQuestion();
    }
}
