package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.screenplay.project.ui.LoginUi.*;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static co.com.screenplay.project.utils.LoginUtil.CLAVE;
import static co.com.screenplay.project.utils.LoginUtil.USUARIO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class LoginTask implements Task {

    public String usuario, clave;

    //aqui desarrolla la tarea
    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("validarCredenciales - USUARIO: " + USUARIO);
        System.out.println("validarCredenciales - CLAVE: " + CLAVE);

// aqui se indica el tiempo para ingresar los campos usuario y clave, luego el boton 'LOGIN'
        actor.attemptsTo(Scroll.to(FIELD_USER));
        actor.attemptsTo(WaitUntil.the(FIELD_USER, isEnabled())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(USUARIO).into(FIELD_USER),
                Enter.theValue(CLAVE).into(FIELD_PASSW)
        );

        usuario = FIELD_USER.resolveFor(actor).getValue();
        clave = FIELD_PASSW.resolveFor(actor).getValue();

        System.out.println("credenciales: " + usuario + " " + clave);

        actor.attemptsTo(WaitUntil.the(FIELD_USER, isEnabled())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(BOTTON_LOGIN)
        );
        System.out.println("CLICK EN BOTON LOGIN");

//convertir una variable de TARGET a STRING
      /*
        usuario = FIELD_USER.resolveFor(actor).getText();
        System.out.println("validarCredenciales - USUARIO: " + usuario);
        clave = FIELD_PASSW.resolveFor(actor).getText();
        System.out.println("validarCredenciales - CLAVE: " + clave);
    */
    }

    //Encapsulamiento
    public static LoginTask forLogin(){
        System.out.println("Login withParams - 01");
        return Tasks.instrumented(LoginTask.class);
    }
}