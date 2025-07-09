#language: en

Feature: Casos automatizados para feature BO P&C

  @BACKOFFICE_PYC
  Scenario Outline: <cp>. Validar el rol <rol_usuario_bo_Riesgo> en el modulo BO PYC siendo el usuario logueado por primera vez
    Given abre sitio web de plataforma rimac a BO PYC
    And configurar el rol de usuario "<rol_usuario_bo_Riesgo>" a BO PYC
    When acceder al modulo de BO PYC
    Then visualizar las funcionalidades del rol para este modulo BO PYC
    Examples:
      | cp | rol_usuario_bo_Riesgo              |
      | 1  | G_SIS_BO_PYC_VEHICULAR_EMISOR      |
      | 2  | G_SIS_BO_PYC_RRGG_CONFIGURADOR     |
      | 3  | G_SIS_BO_PYC_RRGG_COMERCIAL        |
      | 4  | G_SIS_BO_PYC_RRGG_SUSCRIPTOR       |
      | 5  | G_SIS_BO_PYC_RRGG_EMISOR           |
      | 6  | G_SIS_BO_PYC_REASEGUROS            |
      | 7  | G_SIS_BO_PYC_SUSCRIPTOR            |
      | 8  | G_SIS_BOPYC_EJECUTIVO_SALVAMENTO   |
      | 9  | G_SIS_BO_PYC_COMERCIAL             |
      | 10 | G_SIS_BO_PYC_VEHICULAR_SUSCRIPTOR  |
      | 11 | G_SIS_BO_PYC_SUSCRIPCION_EJECUTIVO |
