package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoRiesgosUi.*;
import static co.com.screenplay.project.ui.BoSecurityUi.*;
import static co.com.screenplay.project.ui.ProveedoresPyCUi.*;
import static co.com.screenplay.project.utils.BoFinanzas.CORREO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BoRiesgosAndTask implements Task {

    // 1. Declara la variable de instancia para almacenar el rolUsuario
    private final String rolUsuario;

    // 2. Define un constructor que acepte el rolUsuario (y CORREO si es necesario)
    public BoRiesgosAndTask(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Bo Riesgos - Rol usuario - 02");
        //primero modificar el perfil del usuario y luego acceder a finanzas para validar accesos
        actor.attemptsTo(
                Click.on(BTN_BO_Security),
                Click.on(BTN_INICIO_SESION_SECURITY),
                BoFinanzasAndTask.accessLogin(),
                Click.on(BTN_GESTION_PLATAFORMA),
                Click.on(BTN_MANTTO_USUARIOS),
                Click.on(BTN_FILTRAR),
                WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                Click.on(BTN_FILTRO),
                JavaScriptClick.on(BTN_SCROLL),
                Scroll.to(BTN_SCROLL_RIESGOS).andAlignToBottom(),
                Click.on(BTN_EDI_BO_RIESGO),
                JavaScriptClick.on(BTN_LIST_DESPLEGABLE)
        );
        System.out.println("desplegar la lista");
        String valorDelCampo = Value.of(CAMPO_ROL_USUARIO)
                .viewedBy(actor) // El actor "ve" el elemento
                .asString();
        System.out.println("valor: "+valorDelCampo);
        System.out.println("rol - "+this.rolUsuario+" - ");
        if(this.rolUsuario.equals("G_SIS_BO_PLAFT_ADMIN")) {
            System.out.println("accede G_SIS_BO_PLAFT_ADMIN");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(30).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    JavaScriptClick.on(ROL_G_SIS_BO_PLAFT_ADMIN),
                    //indicar estado ACTIVO
                    JavaScriptClick.on(BTN_TIPO_STATUS),
                    //cierre de actualizacion
                    JavaScriptClick.on(BTN_ACTUALIZAR),
                    JavaScriptClick.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    JavaScriptClick.on(BTN_FILTRO)
            );
            System.out.println("salir G_SIS_BO_PLAFT_ADMIN");
        } else if (this.rolUsuario.equals("G_SIS_BO_RIESGOS_PLAFT_ADMIN")) {
            System.out.println("accede G_SIS_BO_RIESGOS_PLAFT_ADMIN");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    JavaScriptClick.on(ROL_G_SIS_BO_RIESGOS_PLAFT_ADMIN),
                    //indicar estado ACTIVO
                    JavaScriptClick.on(BTN_TIPO_STATUS),
                    //cierre de actualizacion
                    JavaScriptClick.on(BTN_ACTUALIZAR),
                    JavaScriptClick.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    JavaScriptClick.on(BTN_FILTRO)
            );
            System.out.println("salir G_SIS_BO_RIESGOS_PLAFT_ADMIN");
        }
        System.out.println("Bo Riesgos - Rol usuario - END - 03");
    }

    //Encapsulamiento
    public static BoRiesgosAndTask configRolUsuario(String rolUsuario){
        System.out.println("Bo Riesgos - Rol usuario - 01");
        return Tasks.instrumented(BoRiesgosAndTask.class, rolUsuario);
    }
}
