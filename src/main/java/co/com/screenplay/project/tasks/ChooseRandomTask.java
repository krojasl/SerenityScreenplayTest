package co.com.screenplay.project.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import static co.com.screenplay.project.ui.HomeUI.BTN_ELEMENTS;
import static co.com.screenplay.project.ui.HomeUI.BTN_LIST_ELEMENTS;
import static co.com.screenplay.project.utils.Constants.REMEMBER_TEXT_BTN_SUB_ELEMENTS;

@AllArgsConstructor
public class ChooseRandomTask implements Task {

    private String numberRamdonBtn;

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("Choose--1");
        String number = numberRamdonBtn;
        System.out.println("Choose--2 - number: "+number);
        System.out.println("Choose--2 - BTN_ELEMENTS: "+BTN_ELEMENTS);
        System.out.println("Choose--2 - BTN_LIST_ELEMENTS: "+BTN_LIST_ELEMENTS);
        actor.attemptsTo(Scroll.to(BTN_ELEMENTS),
                Click.on(BTN_LIST_ELEMENTS.of(
                        number))
        );
        System.out.println("Choose--3");
        String textBtn = BTN_LIST_ELEMENTS.of(
                number).resolveFor(actor).getText();
        System.out.println("Choose--4");
        actor.remember(REMEMBER_TEXT_BTN_SUB_ELEMENTS, textBtn);
        System.out.println("Choose--5");

    }

    //Encapsulamiento
    public static ChooseRandomTask witchParams(String numberRamdonBtn){
        System.out.println("Choose--6");
        return Tasks.instrumented(ChooseRandomTask.class,numberRamdonBtn);
    }
}
