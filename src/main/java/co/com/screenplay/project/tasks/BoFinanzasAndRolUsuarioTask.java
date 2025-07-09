package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.Value;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.screenplay.project.ui.BoSecurityUi.*;
import static co.com.screenplay.project.ui.BoSecurityUi.BTN_EDIT_FINANZA;
import static co.com.screenplay.project.ui.BoSecurityUi.BTN_FILTRAR;
import static co.com.screenplay.project.ui.BoSecurityUi.BTN_FILTRO;
import static co.com.screenplay.project.ui.BoSecurityUi.FIELD_EMAIL_FILTRO;
import static co.com.screenplay.project.utils.BoFinanzas.CORREO;
import static co.com.screenplay.project.utils.BoSecurity.urlSecurity;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BoFinanzasAndRolUsuarioTask implements Task {
    //instanciado el objeto para obtener el valor de
    // 1. Declara la variable de instancia para almacenar el rolUsuario
    private final String rolUsuario;

    // 2. Define un constructor que acepte el rolUsuario (y CORREO si es necesario)

    public BoFinanzasAndRolUsuarioTask(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("BO_Finanzas_And_Task - 02 - cambiar el rol de usuario - "+actor+" - "+this.rolUsuario);
        //primero modificar el perfil del usuario y luego acceder a finanzas para validar accesos
        actor.attemptsTo(
                Open.url(urlSecurity),
                Click.on(BTN_INICIO_SESION_SECURITY),
                LoginBase.accessLogin(),
                Click.on(BTN_GESTION_PLATAFORMA),
                Click.on(BTN_MANTTO_USUARIOS),
                Click.on(BTN_FILTRAR),
                WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                Click.on(BTN_FILTRO),
                Click.on(BTN_EDIT_FINANZA),
                Click.on(BTN_LIST_DESPLEGABLE)
        );
        System.out.println("desplegar la lista");
        String valorDelCampo = Value.of(CAMPO_ROL_USUARIO)
                .viewedBy(actor) // El actor "ve" el elemento
                .asString();
        System.out.println("valor: "+valorDelCampo);
        System.out.println("rol - "+this.rolUsuario+" - ");
        if(this.rolUsuario.equals("G_SIS_BO_FINANZAS_SUPERVISOR")) {
            System.out.println("es igual - G_SIS_BO_FINANZAS_SUPERVISOR");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_ROL_G_SIS_BO_FINANZAS_SUPERVISOR),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_TESORERIA_ANALISTA")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_TESORERIA_ANALISTA");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_ROL_G_SIS_BO_FINANZAS_TESORERIA_ANALISTA),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );

        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_TESORERIA_SUPERVISOR")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_TESORERIA_SUPERVISOR");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_G_SIS_BO_FINANZAS_TESORERIA_SUPERVISOR),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_REASEGURO_ANALISTA")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_REASEGURO_ANALISTA");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_G_SIS_BO_FINANZAS_REASEGURO_ANALISTA),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_COASEGURO_ANALISTA")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_COASEGURO_ANALISTA");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_G_SIS_BO_FINANZAS_COASEGURO_ANALISTA),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_ANALISTA")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_ANALISTA");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_G_SIS_BO_FINANZAS_ANALISTA),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_CONTABILIDAD_CONSULTA")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_CONTABILIDAD_CONSULTA");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_G_SIS_BO_FINANZAS_CONTABILIDAD_CONSULTA),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_REASEGURO_ANALISTA_NOAUTORIZADOR")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_REASEGURO_ANALISTA_NOAUTORIZADOR");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_G_SIS_BO_FINANZAS_REASEGURO_ANALISTA_NOAUTORIZADOR),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_SOATEV_ANALISTA_TESORERIA")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_SOATEV_ANALISTA_TESORERIA");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_G_SIS_BO_FINANZAS_SOATEV_ANALISTA_TESORERIA),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        } else if (this.rolUsuario.equals("G_SIS_BO_FINANZAS_SOATEV_ANALISTA_CONFIGURADOR")){
            System.out.println("es igual - G_SIS_BO_FINANZAS_SOATEV_ANALISTA_CONFIGURADOR");
            actor.attemptsTo(
                    WaitUntil.the(LI_ROL_BO_FINANZAS_FIRST, isVisible()).forNoMoreThan(20).seconds(),
                    Scroll.to(LI_ROL_BO_FINANZAS_FIRST).andAlignToBottom(),
                    Scroll.to(CAMPO_ROL_USUARIO),
                    WaitUntil.the(CAMPO_ROL_USUARIO, isVisible()).forNoMoreThan(20).seconds(),
                    Click.on(BTN_G_SIS_BO_FINANZAS_SOATEV_ANALISTA_CONFIGURADOR),
                    Click.on(BTN_ACTUALIZAR),
                    Click.on(BTN_FILTRAR),
                    WaitUntil.the(FIELD_EMAIL_FILTRO, isVisible()).forNoMoreThan(30).seconds(),
                    Enter.theValue(CORREO).into(FIELD_EMAIL_FILTRO),
                    Click.on(BTN_FILTRO)
            );
        }
        System.out.println("saliendo de task rol de usuario");
        //cambio de rol de usuario en el mmodulo de seguridad antes de loguearse con BO FINANZA
    }
    //Encapsulamiento
    public static BoFinanzasAndRolUsuarioTask configRolUsuario(String rolUsuario){
        System.out.println("BO_Finanzas_And_Task - Rol usuario - 01");
        return Tasks.instrumented(BoFinanzasAndRolUsuarioTask.class, rolUsuario);
    }
}