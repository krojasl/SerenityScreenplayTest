package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoSecurityUi.*;
import static co.com.screenplay.project.ui.ProveedoresPyCUi.*;
import static co.com.screenplay.project.utils.BoFinanzas.CORREO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProveedoresPyCAndTask  implements Task {

    // 1. Declara la variable de instancia para almacenar el rolUsuario
    private final String rolUsuario;

    // 2. Define un constructor que acepte el rolUsuario (y CORREO si es necesario)

    public ProveedoresPyCAndTask(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Proveedores PyC - Rol usuario - 02");
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
                Scroll.to(BTN_SCROLL).andAlignToBottom(),
                WaitUntil.the(BTN_PAGINA_SIGUIENTE, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(BTN_PAGINA_SIGUIENTE, isEnabled()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_PAGINA_SIGUIENTE),
                Scroll.to(SCROLL_BTN_IZQ),
                WaitUntil.the(BTN_EDI_PROVPYC, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(BTN_EDI_PROVPYC, isEnabled()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_EDI_PROVPYC),
                JavaScriptClick.on(BTN_LIST_DESPLEGABLE)
        );
        System.out.println("desplegar la lista");
        String valorDelCampo = Value.of(CAMPO_ROL_USUARIO)
                .viewedBy(actor) // El actor "ve" el elemento
                .asString();
        System.out.println("valor: "+valorDelCampo);
        System.out.println("rol - "+this.rolUsuario+" - ");
        if(this.rolUsuario.equals("PROVEEDORES PYC")) {
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_ROL_G_SIS_PROVPYC_SALV_USER),
                    //indicar estado ACTIVO
                    Scroll.to(BTN_STATUS).andAlignToBottom(),
                    Scroll.to(CAMPO_STATUS),
                    WaitUntil.the(CAMPO_STATUS, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_TIPO_STATUS),
                    //cierre de actualizacion
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
            System.out.println("salir");
        }
        System.out.println("Proveedores PyC - Rol usuario - 03");
    }

    //Encapsulamiento
    public static ProveedoresPyCAndTask configRolUsuario(String rolUsuario){
        System.out.println("Proveedores PyC - Rol usuario - 01");
        return Tasks.instrumented(ProveedoresPyCAndTask.class, rolUsuario);
    }
}
