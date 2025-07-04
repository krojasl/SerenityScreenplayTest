package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginUi extends PageObject {

    //ubicamos los elementos del login
    public static final Target FIELD_USER = Target.the("CAMPO USUARIO")
            .located(By.xpath("//div[@class='login-box']/form/div/input[@id='user-name']"));

    public static final Target FIELD_PASSW = Target.the("CAMPO CONTRASEÑA")
            .located(By.xpath("//input[@id='password']"));

    public static final Target BOTTON_LOGIN = Target.the("INICIO DE SESION")
            .located(By.xpath("//div[@class='login-box']/form/input"));

    public static final Target MESSAGE_ERROR = Target.the("Mensaje de error")
            .located(By.xpath("//div[@class='login-box']/form/div[3]/h3"));
}
