package co.com.screenplay.project.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static co.com.screenplay.project.ui.HomeUI.TXT_HOME;
import static co.com.screenplay.project.utils.Constants.TIME_SHORT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginValidationTask implements Task {
    //valida la carga de la vista
    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("LoginValidationTask-2");
        actor.attemptsTo(
                WaitUntil.the(TXT_HOME, isVisible()) // Espera que TXT_HOME esté visible
                        .forNoMoreThan(TIME_SHORT).seconds() // Con un tiempo máximo de espera
        );
        System.out.println("LoginValidationTask-3");
    }

   //Encapsulamiento
    public static LoginValidationTask onTheApplication(){
        System.out.println("LoginValidationTask-1");
        return Tasks.instrumented(LoginValidationTask.class);
    }
}
