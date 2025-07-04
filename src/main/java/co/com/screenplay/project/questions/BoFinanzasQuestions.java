package co.com.screenplay.project.questions;

import com.intuit.karate.driver.WebDriver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static co.com.screenplay.project.ui.BoFinanzasUi.*;
import static co.com.screenplay.project.utils.BoFinanzas.TITLE_HOME_FINANZAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


@AllArgsConstructor
@Slf4j
public class BoFinanzasQuestions implements Question<Boolean> {

    private static String roleUsuario;
    String TXTHOME_FINANZAS;

    @Override
    public Boolean answeredBy(Actor actor) {
        System.out.println("BoFinanzasQuestions - 2 " + roleUsuario);
        WaitUntil.the(TXT_HOME_FINANZAS, isVisible()).forNoMoreThan(30).seconds();
        actor.attemptsTo(WaitUntil.the(TXT_HOME_FINANZAS, isEnabled()).forNoMoreThan(5).seconds());
        TXTHOME_FINANZAS = TXT_HOME_FINANZAS.resolveFor(actor).getText();
        System.out.println("TXT: " + TXTHOME_FINANZAS + " - ");
        WaitUntil.the(TXT_HOME_FINANZAS, isVisible()).forNoMoreThan(30).seconds();
        if (TXTHOME_FINANZAS.equals(TITLE_HOME_FINANZAS)) {
            System.out.println("entro al IF");
            if((roleUsuario.equals("G_SIS_BO_FINANZAS_SUPERVISOR"))||(roleUsuario.equals("G_SIS_BO_FINANZAS_TESORERIA_ANALISTA"))||
                    (roleUsuario.equals("G_SIS_BO_FINANZAS_TESORERIA_SUPERVISOR"))||(roleUsuario.equals("G_SIS_BO_FINANZAS_REASEGURO_ANALISTA"))||
                    (roleUsuario.equals("G_SIS_BO_FINANZAS_COASEGURO_ANALISTA"))||(roleUsuario.equals("G_SIS_BO_FINANZAS_ANALISTA"))){
                        actor.attemptsTo(
                                WaitUntil.the(BTN_REASEGURO, isVisible()).forNoMoreThan(20).seconds(),
                                Click.on(BTN_REASEGURO),
                                Click.on(BTN_CONS_LIQUID),
                                Click.on(BTN_REASEGURO),
                                Click.on(BTN_GENER_LIQUID),
                                Click.on(BTN_REASEGURO),
                                Click.on(BTN_AUTOR_LIQUID),
                                Click.on(BTN_REASEGURO),
                                Click.on(BTN_PAGAR_LIQUID)
                        );
                        System.out.println("SEGUNDO MENU");
                        //2do menu
                        actor.attemptsTo(
                                WaitUntil.the(BTN_COASEGURO, isVisible()).forNoMoreThan(20).seconds(),
                                Click.on(BTN_COASEGURO),
                                Click.on(BTN_dos_CONS_LIQUID),
                                Click.on(BTN_COASEGURO),
                                Click.on(BTN_dos_GENER_LIQUID)
                        );
                System.out.println("roles con permisos iguales");
            } else if (roleUsuario.equals("G_SIS_BO_FINANZAS_CONTABILIDAD_CONSULTA")) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_REASEGURO, isVisible()).forNoMoreThan(20).seconds(),
                        Click.on(BTN_REASEGURO),
                        Click.on(BTN_CONS_LIQUID),
                        Click.on(BTN_COASEGURO),
                        Click.on(BTN_dos_CONS_LIQUID)
                );
                System.out.println("rol: G_SIS_BO_FINANZAS_CONTABILIDAD_CONSULTA");
            } else if (roleUsuario.equals("G_SIS_BO_FINANZAS_REASEGURO_ANALISTA_NOAUTORIZADOR")) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_REASEGURO, isVisible()).forNoMoreThan(20).seconds(),
                        Click.on(BTN_REASEGURO),
                        Click.on(BTN_CONS_LIQUID),
                        Click.on(BTN_REASEGURO),
                        Click.on(BTN_GENER_LIQUID)
                );
                System.out.println("G_SIS_BO_FINANZAS_REASEGURO_ANALISTA_NOAUTORIZADOR");
            } else if (roleUsuario.equals("G_SIS_BO_FINANZAS_SOATEV_ANALISTA_TESORERIA")) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT, isVisible()).forNoMoreThan(30).seconds(),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB1),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB2),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB3),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB4),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB5),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB6),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB7),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB8),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Scroll.to(BTN_ESPEC_VAL_SOAT_SUB9).andAlignToBottom(),
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT_SUB9, isVisible()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT_SUB9, isEnabled()).forNoMoreThan(10).seconds(), // Ensure it's enabled
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB9),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Scroll.to(BTN_ESPEC_VAL_SOAT_SUB10).andAlignToBottom(),
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT_SUB10, isVisible()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT_SUB10, isEnabled()).forNoMoreThan(10).seconds(),
                        JavaScriptClick.on(BTN_ESPEC_VAL_SOAT_SUB10),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Scroll.to(BTN_ESPEC_VAL_SOAT_SUB11).andAlignToBottom(),
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT_SUB11, isVisible()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT_SUB11, isEnabled()).forNoMoreThan(10).seconds(),
                        JavaScriptClick.on(BTN_ESPEC_VAL_SOAT_SUB11),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Scroll.to(BTN_ESPEC_VAL_SOAT_SUB12).andAlignToBottom(),
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT_SUB12, isVisible()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT_SUB12, isEnabled()).forNoMoreThan(10).seconds(),
                        JavaScriptClick.on(BTN_ESPEC_VAL_SOAT_SUB12)
                );
                System.out.println("2da opcion");
                actor.attemptsTo(
                        WaitUntil.the(BTN_COASEGURO, isVisible()).forNoMoreThan(20).seconds(),
                        Click.on(BTN_COASEGURO),
                        Click.on(BTN_dos_CONS_LIQUID),
                        Click.on(BTN_COASEGURO),
                        Click.on(BTN_dos_GENER_LIQUID)
                );
                System.out.println("3ra opcion");
                actor.attemptsTo(
                        WaitUntil.the(BTN_REASEGURO, isVisible()).forNoMoreThan(20).seconds(),
                        JavaScriptClick.on(BTN_REASEGURO),
                        JavaScriptClick.on(BTN_CONS_LIQUID),
                        WaitUntil.the(BTN_REASEGURO, isVisible()).forNoMoreThan(20).seconds(),
                        JavaScriptClick.on(BTN_REASEGURO),
                        JavaScriptClick.on(BTN_GENER_LIQUID),
                        JavaScriptClick.on(BTN_REASEGURO),
                        JavaScriptClick.on(BTN_AUTOR_LIQUID),
                        JavaScriptClick.on(BTN_REASEGURO),
                        JavaScriptClick.on(BTN_PAGAR_LIQUID)
                );
                System.out.println("G_SIS_BO_FINANZAS_SOATEV_ANALISTA_TESORERIA");
            } else if (roleUsuario.equals("G_SIS_BO_FINANZAS_SOATEV_ANALISTA_CONFIGURADOR")) {
                actor.attemptsTo(
                        WaitUntil.the(BTN_ESPEC_VAL_SOAT, isVisible()).forNoMoreThan(20).seconds(),
                        Click.on(BTN_ESPEC_VAL_SOAT),
                        Click.on(BTN_ESPEC_VAL_SOAT_SUB5)
                );
                System.out.println("G_SIS_BO_FINANZAS_SOATEV_ANALISTA_CONFIGURADOR");
            }
            return true;
        } else return false;
    }

    public static BoFinanzasQuestions witchParameters(String rolUsuario) {
        roleUsuario = rolUsuario;
        System.out.println("BoFinanzasQuestions - 1 " + roleUsuario);
        return new BoFinanzasQuestions(roleUsuario);
    }
}
