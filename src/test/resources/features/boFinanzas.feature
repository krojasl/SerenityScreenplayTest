#language: en

Feature: Casos automatizados para feature BO FINANZAS


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

