Feature: Validar o endpoint https://reqres.in/api/users/{id}

  Background:
    Given que o id informado é 1

  Scenario: Validar campos do response
    When eu faço uma requisição GET para "/users/{id}"
    Then o status da resposta é 200
    And o campo "data.id" é igual a 1
    And o campo "data.email" é igual a "george.bluth@reqres.in"
    And o campo "data.first_name" é igual a "George"
    And o campo "data.last_name" é igual a "Bluth"
    And o campo "data.avatar" é igual a "https://reqres.in/img/faces/1-image.jpg"
    And o campo "support.url" é igual a "https://reqres.in/#support-heading"
    And o campo "support.text" é igual a "To keep ReqRes free, contributions towards server costs are appreciated!"