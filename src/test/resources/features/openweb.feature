#language: en
@successful
Feature: Demostracion practico de selenium con patron de diseño POM
  Yo como alejandro
  Quiero realizar una prueba de abrir una pagina web
  Para comprobar la robustez y control de errores de la aplicacion o pagina web

  Background:
    Given 'alejandro' abre el sitio web de pruebas

  Scenario: abrir con el navegador chrome la pagina web x
    When ingrese al navegador chrome
    Then visualizara el titulo de la pagina 'cucumber'

  @successful2
  Scenario: abrir con el navegador chrome la pagina web x
    And desea validar la funcion de la cartera de elementos
    When selecciona aleatoriamente alguna de las subfunciones
    Then visualizara en la cabecera el nombre de la opcion elegida

  @successful3
  Scenario: abrir con el navegador chrome la pagina web x
    And ingresa las credenciales
    When valida el inicio de sesion
    Then visualizara la vista home













