package co.com.screenplay.project.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.screenplay.project.ui.HomeUI.TXT_HOME;
import static co.com.screenplay.project.utils.LoginUtil.HOME_PAGE_TITLE_EXPECTED;


public class LoginQuestions implements Question<Boolean> {
    //comparamos si el texto 'products' esta en la vista home, como indicador que si se logueo

    String TxtHome;

    @Override
    public Boolean answeredBy(Actor actor){
        TxtHome = TXT_HOME.resolveFor(actor).getText();
        System.out.println("variable convertida "+TxtHome);
        System.out.println("variable constant "+HOME_PAGE_TITLE_EXPECTED);
        if(TxtHome.equals(HOME_PAGE_TITLE_EXPECTED)){
            System.out.println("LoginQuestion--2 ");
            return true;
        }
        else {
            System.out.println("LoginQuestion--3 ");
            return false;
        }
    }

    public static LoginQuestions displayed(){
        System.out.println("LoginQuestion--1 ");
        return new LoginQuestions();
    }
}
