#language: en

Feature: Casos automatizados para feature BO SECURITY

  #De acuerdo al match entre roles de PROD y TEST, solo hay uno rol que se encuentra en ambos ambientes.
  @BOSECURITY
  Scenario: Validar el rol G_SIS_BOSECURITY_ADMIN en el modulo BO Seguridad siendo el usuario logueado por primera vez
    Given 'SEGURIDAD' abre el sitio web de plataforma rimac con portal Seguridad
    And acceder al modulo de seguridad
    When ingrese las credenciales al portal seguridad
    Then visualizar las funcionalidades del rol para este modulo seguridad

