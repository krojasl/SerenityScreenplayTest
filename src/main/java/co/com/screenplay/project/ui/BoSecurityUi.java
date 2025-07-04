package co.com.screenplay.project.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class BoSecurityUi extends PageObject {

    public static final Target BTN_BO_Security = Target.the("Boton de BO Security [Identidad]")
            .located(By.xpath("//div[@id='root']/div[2]/div[4]/div[1]/div/a[1]"));

    public static final Target BTN_INICIO_SESION_SECURITY = Target.the("Boton de inicio de sesion por portal Seguridad")
            .located(By.xpath("//div[@id='root']/div[2]/div[3]/button"));

    public static final Target FIELEMAIL = Target.the("Campo de correo")
            .located(By.xpath("//input[@id='i0116']"));
    public static final Target BTN_NO = Target.the("Boton 'NO'")
            .located(By.xpath("//div[@class='position-buttons']/div[2]/div/div/div[1]/input"));

    //validar el texto de la primera opcion, su xpath es:
    public static final Target TXT_GESTION_PLATAFORMA = Target.the("")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[1]/button/div/p"));
    //links para menu y submenus del menú
    //1era opcion
    public static final Target BTN_GESTION_PLATAFORMA = Target.the("BTN GESTION PLATAFORMA")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[1]/button"));
    //sub-menus de la primera opcion
    public static final Target BTN_MANTTO_USUARIOS = Target.the("1. BTN SUB-MENU DE GESTION DE PLATAFORMA")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[1]"));
    public static final Target BTN_MANTTO_MENUS = Target.the("2. BTN SUB-MENU DE GESTION DE PLATAFORMA")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[2]"));
    public static final Target BTN_MANTTO_PERFILES = Target.the("3. BTN SUB-MENU DE GESTION DE PLATAFORMA")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[3]"));
    public static final Target BTN_MANTTO_OPCIONES = Target.the("4. BTN SUB-MENU DE GESTION DE PLATAFORMA")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[4]"));
    public static final Target BTN_MANTTO_PORTALES = Target.the("5. BTN SUB-MENU DE GESTION DE PLATAFORMA")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[1]/div/div/div/a[5]"));
    //2da opcion
    public static final Target BTN_GESTION_RIMAC_SALUD = Target.the("BTN GESTION DE RIMAC SALUD")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/button"));
    //sub-menus de la primera opcion
    public static final Target BTN_RIMAC_MANTTO_USUARIOS = Target.the("1. BTN SUB-MENU DE GESTION RIMAC SALUD")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/div/div/div/a[1]"));
    public static final Target BTN_RIMAC_MANTTO_PERFILES = Target.the("2. BTN SUB-MENU DE GESTION RIMAC SALUD")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/div/div/div/a[2]"));
    public static final Target BTN_RIMAC_MANTTO_OPCIONES = Target.the("3. BTN SUB-MENU DE GESTION RIMAC SALUD")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/div/div/div/a[3]"));
    public static final Target BTN_MANTTO_ROLES = Target.the("4. BTN SUB-MENU DE GESTION RIMAC SALUD")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/div/div/div/a[4]"));
    public static final Target BTN_MANTTO_APLICACIONES = Target.the("5. BTN SUB-MENU DE GESTION RIMAC SALUD")
            .located(By.xpath("//div[@id='root']/div[2]/div[1]/div/div[2]/div/div/div/a[5]"));

    //BTN_FILTRAR
    public static final Target BTN_FILTRAR = Target.the("BTN FILTRAR")
            .located(By.xpath("//div[@id='root']/div[2]/div[2]/div/div[2]/div[1]/button"));
    //campo correo
    public static final Target FIELD_EMAIL_FILTRO = Target.the("FIEL EMAIL FORM FILTRO")
            .located(By.xpath("//body/div[2]/div[3]/div/div/div[2]/div/div/div[4]/div/div/div[1]/div/input"));
    //btn filtro
    public static final Target BTN_FILTRO = Target.the("BTN PARA FILTRAR")
            .located(By.xpath("//body/div[2]/div[3]/div/div/div[2]/div/div/div[5]/button[2]"));
    //BTN EDITAR DE BO FINANZAS
    public static final Target BTN_EDIT_FINANZA = Target.the("BTN EDITAR DE BO FINANZAS")
            .located(By.xpath("//div[@class='basicTable_basic-table__wrap__IRK1l']/table/tbody/tr[5]/td[7]/div/button[2]"));

    //Localizador al seleccionar una lista desplegable:
    public static final Target BTN_LIST_DESPLEGABLE = Target.the("BTN LISTA DESPLEGABLE")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div"));
    //ROL DE BO FINANZAS
    public static final Target LI_ROL_BO_FINANZAS_FIRST = Target.the("G_SIS_BO_FINANZAS_SUPERVISOR")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul"));
    public static final Target CAMPO_ROL_USUARIO = Target.the("valor del campo perfil")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/input[@role='combobox']"));
    public static final Target BTN_ROL_G_SIS_BO_FINANZAS_SUPERVISOR = Target.the("BTN G_SIS_BO_FINANZAS_SUPERVISOR")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[6]"));
    public static final Target BTN_ACTUALIZAR = Target.the("BTN ACTUALIZAR EL EDITAR CAMBIO DE ROL DE USUARIO")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[5]/button"));
    //btn de roles de finanzas
    public static final Target BTN_ROL_G_SIS_BO_FINANZAS_TESORERIA_ANALISTA = Target.the("BTN G_SIS_BO_FINANZAS_TESORERIA_ANALISTA")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[1]"));
    public static final Target BTN_G_SIS_BO_FINANZAS_TESORERIA_SUPERVISOR = Target.the("BTN G_SIS_BO_FINANZAS_TESORERIA_SUPERVISOR")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[2]"));
    public static final Target BTN_G_SIS_BO_FINANZAS_REASEGURO_ANALISTA = Target.the("BTN G_SIS_BO_FINANZAS_REASEGURO_ANALISTA")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[3]"));
    public static final Target BTN_G_SIS_BO_FINANZAS_COASEGURO_ANALISTA = Target.the("BTN G_SIS_BO_FINANZAS_COASEGURO_ANALISTA")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[4]"));
    public static final Target BTN_G_SIS_BO_FINANZAS_ANALISTA = Target.the("BTN G_SIS_BO_FINANZAS_ANALISTA")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[5]"));
    public static final Target BTN_G_SIS_BO_FINANZAS_CONTABILIDAD_CONSULTA = Target.the("BTN G_SIS_BO_FINANZAS_CONTABILIDAD_CONSULTA")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[7]"));
    public static final Target BTN_G_SIS_BO_FINANZAS_REASEGURO_ANALISTA_NOAUTORIZADOR = Target.the("BTN G_SIS_BO_FINANZAS_REASEGURO_ANALISTA_NOAUTORIZADOR")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[8]"));
    public static final Target BTN_G_SIS_BO_FINANZAS_SOATEV_ANALISTA_TESORERIA = Target.the("BTN G_SIS_BO_FINANZAS_SOATEV_ANALISTA_TESORERIA")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[9]"));
    public static final Target BTN_G_SIS_BO_FINANZAS_SOATEV_ANALISTA_CONFIGURADOR = Target.the("BTN G_SIS_BO_FINANZAS_SOATEV_ANALISTA_CONFIGURADOR")
            .located(By.xpath("//body/div[2]/div[4]/div/div/div[2]/div/div/div[4]/div/div/div[4]/div/div[2]/ul/li[10]"));
}