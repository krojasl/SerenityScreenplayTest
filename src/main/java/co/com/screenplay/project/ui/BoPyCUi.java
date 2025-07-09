package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class BoPyCUi extends PageObject {

    public static final Target BTN_SCROLL_BO_PYC = Target.the("Scroll para que se habilite la opcion de BO PYC")
            .locatedBy("//div[@id='root']/div[2]/div[2]/div/div[2]/div[2]");
    public static final Target BTN_EDI_BO_PYC = Target.the("BTN EDIT BO PYC")
            .locatedBy("//div[@class='basicTable_basic-table__wrap__IRK1l']/table/tbody/tr[7]/td[7]/div/button[2]");

    // Un método para crear un Target dinámico para cada opción de rol (cada LI)
    // Asume que el texto del rol está directamente dentro del LI
    public static Target opcionDeRol(String rolText) {
        return Target.the("Opción de rol: " + rolText)
                .locatedBy("//ul[contains(@class, '_ride-menu-option_1qdrl_46')]/li[contains(., '{0}')]")
                .of(rolText); // "{0}" se reemplazará por el texto del rol
    }

    //BTN SECCION PYC
    public static final Target BTN_SECTION_PYC = Target.the("SECCION PYC")
            .locatedBy("//p[contains(text(), 'P&C')]");
    //BTN BO PYC
    public static final Target BTN_BO_PYC = Target.the("BTN BO PYC")
            .locatedBy("//div[@id='root']/div[2]/div[4]/div[3]/div/a[1]");
    //TXT HOME BO PYC
    public static final Target TXT_HOME_ENDOSOS = Target.the("Declaraciones")
            .locatedBy("//*[contains(text(), 'Declaraciones')]");
    //BTN ENDOSO
    public static final Target BTN_ENDOSO = Target.the("BTN ENDOSO")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div/button"));
    //sub-menu de ENDOSO
    public static final Target BTN_LIST_ENDOSO = Target.the("BTN LISTADO DE ENDOSO")
            .locatedBy("//a[@href='/pyc/backoffice/endosos']");
    public static final Target TXT_HOME_LIST_ENDOSO = Target.the("TXT EN HOME DE LISTADO ENDOSO")
            .locatedBy("//*[contains(text(), 'Listado de endosos')]");
    //opcion SLIPS AUTOMATICO
    public static final Target BTN_SLIP_AUTO = Target.the("Slips Automáticos")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[1]/button"));
    //sub-menu
    public static final Target BTN_BUSQ_SLIP = Target.the("Busqueda Slips")
            .located(By.xpath("//a[@href='/pyc/backoffice/slips-automaticos']"));
    public static final Target TXT_HOME_BUSQ_SLIP = Target.the("TXT HOME OPCION BUSQ SLIP")
            .locatedBy("//*[contains(text(), 'Hola, ')]");

    //menu INICIO
    public static final Target BTN_INICIO = Target.the("BTN INICIO")
            .located(By.xpath("//a[@href='/pyc/backoffice/']"));
    //menu DECLARACIONES
    public static final Target BTN_DECLARACIONES = Target.the("BTN DECLARACIONES")
            .located(By.xpath("//a[@href='/pyc/backoffice/declaraciones']"));
    public static final Target TXT_HOME_DECLARACIONES = Target.the("BTN HOME DECLARACIONES")
            .located(By.xpath("//div[@id='root']/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div/div/div"));
    //RENOV RRGG - PARTE 1
    public static final Target BTN_RRGG_SLIP = Target.the("BTN RRGG SLIP")
            .located(By.xpath("//a[@href='/pyc/renovacion/rrgg/slip']"));
    //RENOV RRGG - PARTE 1
    public static final Target BTN_RRGG_ACELERADORES = Target.the("BTN RRGG ACELERADORES")
            .located(By.xpath("//a[@href='/pyc/renovacion/rrgg/aceleradores']"));

}