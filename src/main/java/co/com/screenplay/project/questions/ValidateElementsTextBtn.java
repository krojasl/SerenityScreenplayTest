package co.com.screenplay.project.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.screenplay.project.ui.HomeUI.TXT_HOME;


@AllArgsConstructor
@Slf4j
public class ValidateElementsTextBtn implements Question<Boolean> {

    public static String validTextSubElementBtn;

    @Override
    public Boolean answeredBy(Actor actor){
        boolean result;
        System.out.println("validateTextBtn--0");
        Target validTextBtnHeader = TXT_HOME;
        // Ejemplo dentro de tu Question ValidateElementsTextBtn - convertir target a string y obtener el valor
        String textBtn = validTextBtnHeader.resolveFor(actor).getText();
        System.out.println("Texto Real del Elemento: '" + textBtn + "'");
        System.out.println(" >>>" + validTextSubElementBtn + "   " + textBtn);
        if (validTextBtnHeader != null && validTextSubElementBtn.equals(textBtn)){
            System.out.println("validateTextBtn--2");
            log.info(String.valueOf(textBtn));
            System.out.println("validateTextBtn--3");
            result = true;
            System.out.println("validateTextBtn--4");
        } else {
            System.out.println("validateTextBtn--5");
            result = false;
            System.out.println("validateTextBtn--6");
        }
        System.out.println("validateTextBtn--7");
        return result;
    }

    public static ValidateElementsTextBtn witchParams(String validateText){
        validTextSubElementBtn = validateText;
        System.out.println("validateTextBtn--8 "+ validTextSubElementBtn);
        return new ValidateElementsTextBtn();
    }
}
