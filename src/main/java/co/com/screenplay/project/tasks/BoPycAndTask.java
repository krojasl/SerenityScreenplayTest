package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoPyCUi.*;
import static co.com.screenplay.project.ui.BoSecurityUi.*;
import static co.com.screenplay.project.ui.ProveedoresPyCUi.BTN_SCROLL;
import static co.com.screenplay.project.ui.ProveedoresPyCUi.BTN_TIPO_STATUS;
import static co.com.screenplay.project.utils.BoFinanzas.CORREO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BoPycAndTask implements Task {

    // 1. Declara la variable de instancia para almacenar el rolUsuario
    private final String rolUsuarioPyC;

    // 2. Define un constructor que acepte el rolUsuario (y CORREO si es necesario)
    public BoPycAndTask(String rolUsuario) {
        this.rolUsuarioPyC = rolUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Bo PyC - Rol usuario - 02");
        //primero modificar el perfil del usuario y luego acceder a finanzas para validar accesos
        actor.attemptsTo(
                Click.on(BTN_BO_Security),
                Click.on(BTN_INICIO_SESION_SECURITY),
                LoginBase.accessLogin(),
                Click.on(BTN_GESTION_PLATAFORMA),
                Click.on(BTN_MANTTO_USUARIOS),
                Click.on(BTN_FILTRAR),
                WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                Click.on(BTN_FILTRO),
                JavaScriptClick.on(BTN_SCROLL),
                Scroll.to(BTN_SCROLL_BO_PYC).andAlignToBottom(),
                Click.on(BTN_EDI_BO_PYC),
                JavaScriptClick.on(BTN_LIST_DESPLEGABLE)
        );
        System.out.println("desplegar la lista");
        //SELECCIONO UN ROL DE LA LISTA DESPLEGABLE DINAMICAMENTE
        if ((this.rolUsuarioPyC.equals("G_SIS_BO_PYC_VEHICULAR_EMISOR")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_RRGG_CONFIGURADOR")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_RRGG_COMERCIAL")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_RRGG_SUSCRIPTOR")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_RRGG_EMISOR")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_REASEGUROS")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_VEHICULAR_SUSCRIPTOR")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_COMERCIAL")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_SUSCRIPCION_EJECUTIVO"))
        ) { //estos roles tienen el mismo menu de <ENDOSO>
            System.out.println("accede " + this.rolUsuarioPyC);
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(30).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    //la sig. linea muestra como elegir el rol de usuario que esta en la variable <this.rolUsuarioPyC> de manera dinamica
                    WaitUntil.the(opcionDeRol(this.rolUsuarioPyC), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(opcionDeRol(this.rolUsuarioPyC)),
                    //indicar estado ACTIVO
                    JavaScriptClick.on(BTN_TIPO_STATUS),
                    //cierre de actualizacion
                    JavaScriptClick.on(BTN_ACTUALIZAR),
                    JavaScriptClick.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    JavaScriptClick.on(BTN_FILTRO)
            );
        }else if ( (this.rolUsuarioPyC.equals("G_SIS_BO_PYC_SUSCRIPTOR")) ||
                (this.rolUsuarioPyC.equals("G_SIS_BOPYC_EJECUTIVO_SALVAMENTO")) ){
            System.out.println("Este usuario: "+this.rolUsuarioPyC+" no se encuentra en la lista desplegable");
        }
    }

    //Encapsulamiento
    public static BoPycAndTask configRolUsuario(String rolUsuario) {
        System.out.println("Bo PyC - Rol usuario - 01");
        return Tasks.instrumented(BoPycAndTask.class, rolUsuario);
    }
}
