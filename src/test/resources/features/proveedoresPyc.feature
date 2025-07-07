#language: en
@AllTestBackOfficeTest
Feature: Demostracion practico de selenium con patron de diseño POM

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




