#language: en
@AllTestBackOfficeTest
Feature: Demostracion practico de selenium con patron de diseño POM

  #De acuerdo al match entre roles de PROD y TEST, solo hay uno rol que se encuentra en ambos ambientes.
  @BOSECURITY @listo
  Scenario: Validar el rol G_SIS_BOSECURITY_ADMIN en el modulo BO Seguridad siendo el usuario logueado por primera vez
    Given 'SEGURIDAD' abre el sitio web de plataforma rimac con portal Seguridad
    And acceder al modulo de seguridad
    When ingrese las credenciales al portal seguridad
    Then visualizar las funcionalidades del rol para este modulo seguridad

  @BOFINANZAS @listo
  Scenario Outline: <cp>. Validar el rol <rol_usuario> en el modulo BO Finanzas siendo el usuario logueado por primera vez
    Given '<ACTOR>' abre el sitio web de plataforma rimac
    And configurar el rol de usuario "<rol_usuario>"
    When acceder al modulo de finanzas
    Then visualizar las funcionalidades del rol para este modulo finanzas
    Examples:
      | cp | ACTOR | rol_usuario                                        |
      | 1  | RIMAC | G_SIS_BO_FINANZAS_SUPERVISOR                       |
      | 2  | RIMAC | G_SIS_BO_FINANZAS_TESORERIA_ANALISTA               |
      | 3  | RIMAC | G_SIS_BO_FINANZAS_TESORERIA_SUPERVISOR             |
      | 4  | RIMAC | G_SIS_BO_FINANZAS_REASEGURO_ANALISTA               |
      | 5  | RIMAC | G_SIS_BO_FINANZAS_COASEGURO_ANALISTA               |
      | 6  | RIMAC | G_SIS_BO_FINANZAS_ANALISTA                         |
      | 7  | RIMAC | G_SIS_BO_FINANZAS_CONTABILIDAD_CONSULTA            |
      | 8  | RIMAC | G_SIS_BO_FINANZAS_REASEGURO_ANALISTA_NOAUTORIZADOR |
      | 9  | RIMAC | G_SIS_BO_FINANZAS_SOATEV_ANALISTA_TESORERIA        |
      | 10 | RIMAC | G_SIS_BO_FINANZAS_SOATEV_ANALISTA_CONFIGURADOR     |

  # @BSA ES UNA MFE APARTE, NO CONSIDERADO PARA AUTOMATIZAR, YA QUE NO SE VA A MIGRAR

  @PROVEEDORES_PYC
  Scenario Outline: <cp>. Validar el rol <rol_usuario> en el modulo Proveedores P&C siendo el usuario logueado por primera vez
    Given abre sitio web de plataforma rimac a PyC
    And configurar el rol de usuario "<rol_usuario>" a P&C
    When acceder al modulo de Proveedores P&C
    Then visualizar las funcionalidades del rol para este modulo Proveedores P&C
    Examples:
      | cp | rol_usuario             |
      | 1  | G_SIS_PROVPYC_SALV_USER |



