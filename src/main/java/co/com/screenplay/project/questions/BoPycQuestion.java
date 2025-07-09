package co.com.screenplay.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoFinanzasUi.BTN_REASEGURO;
import static co.com.screenplay.project.ui.BoPyCUi.*;
import net.serenitybdd.screenplay.actions.*;
import static co.com.screenplay.project.utils.BoPyC.URL_PATH;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
@Slf4j
public class BoPycQuestion  implements Question<Boolean> {

    private static String rolUsuarioPYC;

    @Override
    public Boolean answeredBy(Actor actor) {

        if( (rolUsuarioPYC.equals("G_SIS_BO_PYC_VEHICULAR_EMISOR")) ||
            (rolUsuarioPYC.equals("G_SIS_BO_PYC_RRGG_CONFIGURADOR")) ||
            (rolUsuarioPYC.equals("G_SIS_BO_PYC_RRGG_COMERCIAL")) ||
            (rolUsuarioPYC.equals("G_SIS_BO_PYC_RRGG_SUSCRIPTOR")) ||
            (rolUsuarioPYC.equals("G_SIS_BO_PYC_RRGG_EMISOR")) ||
            (rolUsuarioPYC.equals("G_SIS_BO_PYC_REASEGUROS")) ||
            (rolUsuarioPYC.equals("G_SIS_BO_PYC_VEHICULAR_SUSCRIPTOR")))
        {   //estos roles tienen el mismo menu de <ENDOSO>
            //validamos el TXT que aparece en el home
            System.out.println("1");
            WaitUntil.the(TXT_HOME_ENDOSOS, isVisible()).forNoMoreThan(30).seconds();
            System.out.println("2");
            actor.should(GivenWhenThen.seeThat(
                    WebElementQuestion.the(TXT_HOME_ENDOSOS),
                    WebElementStateMatchers.containsText("Declaraciones")
            ));
            System.out.println("3a");
            //validamos las funcionalidades del rol del usuario
            actor.attemptsTo(
                    WaitUntil.the(BTN_ENDOSO, isVisible()).forNoMoreThan(40).seconds(),
                    Click.on(BTN_ENDOSO),
                    Click.on(BTN_LIST_ENDOSO)
            );
            System.out.println("4");
            WaitUntil.the(TXT_HOME_LIST_ENDOSO, isVisible()).forNoMoreThan(30).seconds();
            System.out.println("5");
            actor.should(GivenWhenThen.seeThat(
                    WebElementQuestion.the(TXT_HOME_LIST_ENDOSO),
                    WebElementStateMatchers.containsText("Listado de endosos")
            ));
            System.out.println("6");
            return true;
        }
        if(rolUsuarioPYC.equals("G_SIS_BO_PYC_COMERCIAL")
        ){  //tienen el mismo permiso de rol de usuario
            //validamos las funcionalidades del rol del usuario
            System.out.println("1");
            actor.attemptsTo(
                    WaitUntil.the(BTN_ENDOSO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_ENDOSO),
                    Click.on(BTN_LIST_ENDOSO),
                    Click.on(BTN_SLIP_AUTO),
                    Click.on(BTN_BUSQ_SLIP)
            );
            System.out.println("2");
            //validamos el TXT que aparece en el home
            WaitUntil.the(TXT_HOME_BUSQ_SLIP, isVisible()).forNoMoreThan(30).seconds();
            System.out.println("3");
            actor.should(GivenWhenThen.seeThat(
                    WebElementQuestion.the(TXT_HOME_BUSQ_SLIP),
                    WebElementStateMatchers.containsText("Hola, ")
            ));
            System.out.println("4");
            return true;
        }
        else if (rolUsuarioPYC.equals("G_SIS_BO_PYC_SUSCRIPCION_EJECUTIVO"))
        {
            System.out.println("1");
            //validamos las funcionalidades del rol del usuario
            actor.attemptsTo(
                    WaitUntil.the(BTN_INICIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_INICIO),
                    Click.on(BTN_DECLARACIONES)
            );
            System.out.println("2");
            //validamos el TXT que aparece en el home
            WaitUntil.the(TXT_HOME_DECLARACIONES, isVisible()).forNoMoreThan(30).seconds();
            System.out.println("3");
            actor.should(GivenWhenThen.seeThat(
                    WebElementQuestion.the(TXT_HOME_DECLARACIONES),
                    WebElementStateMatchers.containsText("Transporte flotante - Evaluación de declaraciones")
            ));
            System.out.println("4");
            //VALIDAMOS LOS DOS BOTONES DE RRGG
            actor.attemptsTo(
                    WaitUntil.the(BTN_RRGG_SLIP, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_RRGG_SLIP),
                    Open.url(URL_PATH),
                    Click.on(BTN_RRGG_ACELERADORES)
            );
            System.out.println("5");
            return true;
        }else if ( (rolUsuarioPYC.equals("G_SIS_BO_PYC_SUSCRIPTOR")) ||
                (rolUsuarioPYC.equals("G_SIS_BOPYC_EJECUTIVO_SALVAMENTO")) )
        {
            System.out.println("Este usuario: "+rolUsuarioPYC+" no se encuentra en la lista desplegable");
            return true;
        }
        return false;
    }


    public static BoPycQuestion validarCondicionBoPyc(String rolUsuario) {
        rolUsuarioPYC = rolUsuario;
        System.out.println("BO PYC QUESTION - 1 " + rolUsuarioPYC);
        return new BoPycQuestion();
    }
}
