#language: en

Feature: Casos automatizados para feature BO RIESGOS

@BACKOFFICE_RIESGOS
Scenario Outline: <cp>. Validar el rol <rol_usuario_bo_Riesgo> en el modulo BO RIESGOS siendo el usuario logueado por primera vez
Given abre sitio web de plataforma rimac a BO RIESGOS
And configurar el rol de usuario "<rol_usuario_bo_Riesgo>" a BO RIESGOS
When acceder al modulo de BO RIESGOS
Then visualizar las funcionalidades del rol para este modulo BO RIESGOS
Examples:
| cp | rol_usuario_bo_Riesgo        |
| 1  | G_SIS_BO_PLAFT_ADMIN         |
| 2  | G_SIS_BO_RIESGOS_PLAFT_ADMIN |