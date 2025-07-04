package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class BoFinanzasUi extends PageObject {

    //btn de BO FINANZAS en pataforma RIMAC
    public static final Target BTN_BO_FINANZAS = Target.the("Boton de BO Finanzas")
            .located(By.xpath("//div[@id='root']/div[2]/div[4]/div[1]/div/a[4]"));

    //boton de inicio de sesion
    public static final Target BTN_INICIO_SESION = Target.the("INICIO DE SESION")
            .located(By.xpath("//div[@id='root']/div[2]/div[3]/button"));

    //boton para seleccionar 'Usar otra cuenta' y loguearse con el correo indicado
    public static final Target BTN_CREDENCIALES_LOGIN = Target.the("USAR OTRA CUENTA")
            .located(By.xpath("//div[@id='lightbox']/div[3]/div/div/div/div[2]/div/div/div[3]/div"));

    //field campo correo
    public static final Target FIELD_EMAIL = Target.the("Campo de correo")
            .located(By.xpath("//div[@id='lightbox']/div[3]/div/div/div/div[2]/div[2]/div/input[@name='loginfmt']"));

    //btn SIGUIENTE
    public static final Target BTN_SIGUIENTE_LOGIN = Target.the("Boton de Siguiente Formulario EMAIL")
            .located(By.xpath("//*[@id='idSIButton9']"));

    //FIELD PASSWORD
    public static final Target FIELD_PASSWORD = Target.the("Campo de contraseña")
            .located(By.xpath("//input[@id='i0118']"));

    //Boton LOGIN
    public static final Target BTN_LOGIN = Target.the("BTN LOGIN")
            .located(By.xpath("//*[@id='idSIButton9']"));

    //TXT HOME DEL PORTAL BO FINANZAS
    public static final Target TXT_HOME_FINANZAS = Target.the("TXT HOME FINANZAS")
            .located(By.xpath("//div[@id='root']/div[1]/div/div[1]/h6"));

    //FUNCIONALIDADES DEL ROL BO  FINANZAS
    //links para menu y submenus del menú -  ROL: G_SIS_BO_FINANZAS_SUPERVISOR
    //1era opcion
    public static final Target BTN_REASEGURO = Target.the("BTN REASEGURO")
            .locatedBy("//p[contains(text(), 'Reaseguro')]");
    //sub-menus
    public static final Target BTN_CONS_LIQUID = Target.the("CONSULTAR LIQUIDACION")
            .locatedBy("//a[@href='/finanzas/reaseguro/consultar-liquidacion']");
    public static final Target BTN_GENER_LIQUID = Target.the("GENERAR LIQUIDACION")
            .locatedBy("//a[@href='/finanzas/reaseguro/generar-liquidacion']");
    public static final Target BTN_AUTOR_LIQUID = Target.the("AUTORIZAR LIQUIDACION")
            .locatedBy("//a[@href='/finanzas/reaseguro/aprobar-liquidacion']");
    public static final Target BTN_PAGAR_LIQUID = Target.the("PAGAR LIQUIDACION")
            .locatedBy("//a[@href='/finanzas/reaseguro/pagar-liquidacion']");
    //2da opcion
    public static final Target BTN_COASEGURO = Target.the("BTN COASEGURO")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/button"));
    //sub-menus
    public static final Target BTN_dos_CONS_LIQUID = Target.the("CONSULTAR LIQUIDACION")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/div/div/div/a[@href='/finanzas/coaseguro/consultar-liquidacion']"));
    public static final Target BTN_dos_GENER_LIQUID = Target.the("GENERAR LIQUIDACION")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/div/div/div/a[@href='/finanzas/coaseguro/generar-liquidacion']"));

    //3era funcionalidad
    public static final Target BTN_ESPEC_VAL_SOAT = Target.the(" BTN Especies Valoradas SOAT")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/button"));
    //sub-menus
    public static final Target BTN_ESPEC_VAL_SOAT_SUB1 = Target.the(" BTN SUB-MENU Actualización de nodos")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/actualizacion-de-nodos']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB2 = Target.the(" BTN SUB-MENU Arqueo")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/arqueo']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB3 = Target.the(" BTN SUB-MENU Recepción")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/recepcion']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB4 = Target.the(" BTN SUB-MENU Línea de crédito")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/linea-de-credito']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB5 = Target.the(" BTN SUB-MENU Estructura")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/estructura']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB6 = Target.the(" BTN SUB-MENU Cambios de estado y consultas individuales")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/cambio-de-estados-y-consultas-individuales']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB7 = Target.the(" BTN SUB-MENU Cambio de estado masivo")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/cambio-de-estado-masivo']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB8 = Target.the(" BTN SUB-MENU Remesas")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/remesas']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB9 = Target.the(" BTN SUB-MENU Estado certificados")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/estado-certificados']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB10 = Target.the(" BTN SUB-MENU Reporte auditoria")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/reporte-auditoria']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB11 = Target.the(" BTN SUB-MENU Búsqueda de solicitudes cambio de estado de especies valoradas")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/busqueda-solicitudes-cambio-estado-ev']"));
    public static final Target BTN_ESPEC_VAL_SOAT_SUB12 = Target.the(" BTN SUB-MENU Despacho automático")
            .located(By.xpath("//body/div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[@href='/finanzas/soat-ev/despacho-automatico']"));
    //campo scroll
    public static final Target CAMPO_SCROLL_FINANZA = Target.the("valor del campo perfil")
            .located(By.cssSelector("div.px-3.py-6.flex.flex-col.space-y-4.w-fit.rounded-ride-sys-border-radius-container-xlarge"));
}