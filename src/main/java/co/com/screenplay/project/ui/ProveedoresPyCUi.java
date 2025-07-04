package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;

public class ProveedoresPyCUi  extends PageObject {

    public static final Target SECTION_PYC = Target.the("Seccion PyC")
            .locatedBy("//p[contains(text(), 'P&C')]");
    public static final Target BTN_EDI_PROVPYC = Target.the("BTN EDIT PYC")
            .locatedBy("//div[@class='basicTable_basic-table__wrap__IRK1l']/table/tbody/tr[5]/td/div/button[2]");
    public static final Target BTN_ROL_G_SIS_PROVPYC_SALV_USER = Target.the("OPCION ROL G_SIS_PROVPYC_SALV_USER")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div/ul/li[1]"));
    public static final Target BTN_STATUS = Target.the("OPCION ESTADO")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[5]/div/div[2]/ul"));
    public static final Target CAMPO_STATUS = Target.the("CAMPO STATUS")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[5]/div/input[@role='combobox']"));
    public static final Target BTN_TIPO_STATUS = Target.the("OPTION STATUS PORTAL")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[5]/div/div[2]/ul/li[1]"));
    public static final Target BTN_PAGINA_SIGUIENTE = Target.the("BTN PAGINATION SIGUIENTE")
            .located(By.xpath("//button[@class='pagination_arrow__Q0l2Y']"));
    public static final Target BTN_SCROLL = Target.the("BTN SCROLL")
            .located(By.xpath("//div[@id='root']/div[2]/div[2]/div"));
    public static final Target SCROLL_BTN_IZQ = Target.the("BTN A LA IZQ")
            .located(By.xpath("//div[@id='root']/div[2]/div[2]/div/div[2]/div[2]"));
    public static final Target FIELD_USUARIO = Target.the("FIELD USUARIO PYC")
            .locatedBy("//input[@class='\n" +
                    "      w-full h-14 pt-6 pb-2 px-4 peer-focus:border-ride-sys-color-border-extreme bg-ride-sys-color-surface-subtle\n" +
                    "      peer border rounded-lg outline-none border-ride-sys-color-border-medium\n" +
                    "      text-ride-sys-text-label-large-regular placeholder-transparent\n" +
                    "      hover:border-ride-sys-color-border-extreme focus:border-ride-sys-color-border-extreme custom\n" +
                    "    ']");
    public static final Target FIELD_PASS = Target.the("FIELD PASS PYC")
            .locatedBy("//input[@class='\n" +
                    "      w-full h-14 pt-6 pb-2 px-4 peer-focus:border-ride-sys-color-border-extreme bg-ride-sys-color-surface-subtle\n" +
                    "      peer border rounded-lg outline-none border-ride-sys-color-border-medium\n" +
                    "      text-ride-sys-text-label-large-regular placeholder-transparent\n" +
                    "      hover:border-ride-sys-color-border-extreme focus:border-ride-sys-color-border-extreme custom\n" +
                    "     pr-12']");
    public static final Target BTN_INICIAR_SESION_PYC = Target.the("BTN INICIAR SESION PYC")
            .locatedBy("//button[@class='button_button__JXvXX button_button-solid__EMGEf button_button-transitions__UT1q0 button_base-button-bounce-effect__vpqzd border-ride-sys-border-width-container-medium button_button-xlarge__Njw5R mt-10 !inline-block w-full']");
    public static final Target SCROLL_PYC = Target.the("SCROLL PARA BAJAR Y PODER SEECCIONAR RRGG")
            .located(By.xpath("//div[@id='root']/div[2]/div[4]/div[3]"));
    public static final Target BTN_RRGG_PYC = Target.the("BTN PYC RRGG")
            .located(By.xpath("//div[@id='root']/div[2]/div[4]/div[3]/div/a[4]"));
    //opciones con el unico rol de PYC
    public static final Target BTN_FIST_PYC = Target.the("INICIO")
            .locatedBy("//a[@href='/pyc/proveedores/inicio']");
    public static final Target BTN_SECOND_PYC = Target.the("Salvamento Vehicular")
            .locatedBy("//p[contains(text(), 'Salvamento Vehicular')]");
    //sub-menus de la segunda opcion
    public static final Target BTN_GESTION_SAL_VEH = Target.the("BTN GESTION Salvamento Vehicular")
            .locatedBy("//a[@href='/pyc/proveedores/salvamento-vehicular']");
    public static final Target BTN_VALIDATION = Target.the("BTN VALIDACION")
            .locatedBy("//button[@class='button_button__JXvXX button_button-solid__EMGEf button_button-transitions__UT1q0 button_base-button-bounce-effect__vpqzd border-ride-sys-border-width-container-medium button_button-xlarge__Njw5R']");

}