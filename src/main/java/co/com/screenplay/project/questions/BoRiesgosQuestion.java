package co.com.screenplay.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.screenplay.project.ui.BoRiesgosUi.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.containsString;


@AllArgsConstructor
@Slf4j
public class BoRiesgosQuestion implements Question<Boolean> {

    private static String roleUsuarioRiesgo;

    @Override
    public Boolean answeredBy(Actor actor) {

        if ((roleUsuarioRiesgo.equals("G_SIS_BO_PLAFT_ADMIN")) || (roleUsuarioRiesgo.equals("G_SIS_BO_RIESGOS_PLAFT_ADMIN"))) {
            System.out.println("accede a " + roleUsuarioRiesgo);
            actor.attemptsTo(
                    WaitUntil.the(BTN_CASOS, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_CASOS),
                    JavaScriptClick.on(BTN_LIST_CASOS)
            );

            System.out.println("validamos el texto de la vista 'Lista de casos'");
            WaitUntil.the(TXT_VIEW_CASOS, isVisible()).forNoMoreThan(30).seconds();
            actor.should(GivenWhenThen.seeThat(
                    WebElementQuestion.the(TXT_VIEW_CASOS),
                    WebElementStateMatchers.containsText("Solicitudes de gestión de casos")
            ));
            //segunda opcion del menu
            actor.attemptsTo(
                    WaitUntil.the(BTN_DESACUERDOS, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_DESACUERDOS),
                    Click.on(BTN_REG_DESACUERDO)
            );
            System.out.println("validamos el texto de la vista 'Registro del desacuerdo'");
            WaitUntil.the(TXT_REG_DESC, isVisible()).forNoMoreThan(60).seconds();
            actor.should(GivenWhenThen.seeThat(
                    WebElementQuestion.the(TXT_REG_DESC),
                    WebElementStateMatchers.containsText("Registro del desacuerdo")
            ));
            actor.attemptsTo(
                    WaitUntil.the(BTN_DESACUERDOS, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_DESACUERDOS),
                    JavaScriptClick.on(BTN_SOL_DESACUERDO)
            );
            System.out.println("validamos el texto de la vista 'Solicitudes de desacuerdos'");
            WaitUntil.the(TXT_SOL_DESC, isVisible()).forNoMoreThan(60).seconds();
            actor.should(GivenWhenThen.seeThat(
                    WebElementQuestion.the(TXT_SOL_DESC),
                    WebElementStateMatchers.containsText("Solicitudes de desacuerdos")
            ));
            //tercera opcion del menu
            actor.attemptsTo(
                    WaitUntil.the(BTN_REPORTES, isVisible()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_REPORTES),
                    JavaScriptClick.on(BTN_REP_CASOS)
            );
            System.out.println("validamos e texto de la vista 'Reportes'");
            WaitUntil.the(TXT_REPORTES, isVisible()).forNoMoreThan(30).seconds();
            actor.should(GivenWhenThen.seeThat(
                    WebElementQuestion.the(TXT_REPORTES),
                    WebElementStateMatchers.containsText("Reportes")
            ));
            System.out.println("saliendo de " + roleUsuarioRiesgo);
            return true;
        }
        return false;
    }

    public static BoRiesgosQuestion validarCondicionesRiesgos(String rolUsuario) {
        roleUsuarioRiesgo = rolUsuario;
        System.out.println("BO RIESGO QUESTION - 1 " + roleUsuarioRiesgo);
        return new BoRiesgosQuestion();
    }
}
