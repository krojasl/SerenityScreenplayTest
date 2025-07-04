package co.com.screenplay.project.ui;

import net.thucydides.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI extends PageObject {

    public static final Target ID_CARD_ELEMENTS = Target.the("Boton elementos").located(By.xpath("//*[@id='app']/div/div/div[2]/div/div[1]/div/div[3]"));

    public static final Target BTN_ELEMENTS= Target.the("Boton elementos")
            .located(By.xpath("//div[@class='header-wrapper']//div[contains(text(),'Elements')]"));

    /* Este elemento BTN_LIST_ELEMENTS se deja parametrizado **/
    public static final Target BTN_LIST_ELEMENTS = Target.the("boton lista opciones elementos")
            .locatedBy("//div[@class='element-list collapse show']/ul/li[@id='item-1']/span");

    //texto por parte de la vista HOME
    public static final Target TXT_HOME = Target.the("texto random, del nombre de los botones")
            .located(By.xpath("//div[@id='root']/div/div/div/div[2]/span"));

}