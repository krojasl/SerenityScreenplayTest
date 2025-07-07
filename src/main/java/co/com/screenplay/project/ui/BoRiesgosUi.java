package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;

public class BoRiesgosUi extends PageObject {

    //BTN BO RIESGOS
    public static final Target BTN_RIESGOS= Target.the("BTN BO RIESGOS DESDE PLATAFORMA")
            .located(By.xpath("//div[@id='root']/div[2]/div[4]/div/div/a[6]"));
    //vista filtro - BTN BO RIESGOS
    public static final Target BTN_EDI_BO_RIESGO = Target.the("BTN EDIT BO RIESGOSC")
            .locatedBy("//div[@class='basicTable_basic-table__wrap__IRK1l']/table/tbody/tr[9]/td[7]");
    //rol usuario de lista desplegable en filtro de bo seguridad
    public static final Target ROL_G_SIS_BO_PLAFT_ADMIN = Target.the("ROL G_SIS_BO_PLAFT_ADMIN")
            .locatedBy("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div/ul/li[1]");
    public static final Target ROL_G_SIS_BO_RIESGOS_PLAFT_ADMIN = Target.the("ROL G_SIS_BO_RIESGOS_PLAFT_ADMIN")
            .locatedBy("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div/ul/li[2]");

    public static final Target BTN_SCROLL_RIESGOS = Target.the("Scroll para que se habilite la opcion de riesgos")
            .locatedBy("//div[@id='root']/div[2]/div[2]/div/div");

    //menu de OPCIONES con RIESGOS
    public static final Target BTN_CASOS = Target.the("BTN CASOS")
            .locatedBy("//div[@id='root']/div[2]/div[1]/div/div[1]/button");
    //SUBMENU - CASOS
    public static final Target BTN_LIST_CASOS = Target.the("BTN LIST CASOS")
            .locatedBy("//div[@id='root']/div[2]/div/div/div/div/div/div/a");
    //texto de la vista de 'Lista de casos'
    public static final Target TXT_VIEW_CASOS = Target.the("Solicitudes de gestión de casos")
            .located(By.xpath("//*[contains(text(), 'Solicitudes de gestión de casos')]"));

    public static final Target BTN_DESACUERDOS = Target.the("BTN DESACUERDOS")
            .locatedBy("//div[@id='root']/div[2]/div[1]/div/div[2]/button");
    //submenus
    public static final Target BTN_REG_DESACUERDO = Target.the("BTN SUB-MENU  REG. DESACUERDO")
            .locatedBy("//a[@href='/riesgos/backoffice/plaft/registro-desacuerdo/']");
        public static final Target TXT_REG_DESC = Target.the("TXT Registro del desacuerdo")
             .located(By.xpath("//*[contains(text(), 'Registro del desacuerdo')]"));

    public static final Target BTN_SOL_DESACUERDO = Target.the("BTN SUB-MENU SOL. DESACUERDO")
            .locatedBy("//a[@href='/riesgos/backoffice/plaft/solicitudes-desacuerdo/']");
        public static final Target TXT_SOL_DESC = Target.the("TXT Solicitudes de desacuerdos")
            .located(By.xpath("//*[contains(text(), 'Solicitudes de desacuerdos')]"));

    public static final Target BTN_REPORTES = Target.the("BTN REPORTES")
            .locatedBy("//div[@id='root']/div[2]/div[1]/div/div[3]/button");
    //SUBMENU
    public static final Target BTN_REP_CASOS = Target.the("BTN Reporte de Casos")
            .locatedBy("//a[@href='/riesgos/backoffice/plaft/reportes/']");
        public static final Target TXT_REPORTES = Target.the("TXT ")
                .located(By.xpath("//*[contains(text(), 'Reportes')]"));









}
