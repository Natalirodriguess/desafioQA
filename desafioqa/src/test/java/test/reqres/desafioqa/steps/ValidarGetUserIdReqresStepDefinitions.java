package test.reqres.desafioqa.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.equalTo;

public class ValidarGetUserIdReqresStepDefinitions {

    private String id;
    private Response response;

    @Given("que o id informado é {int}")
    public void que_o_id_informado_e(Integer id) {
        this.id = String.valueOf(id);
    }

    @When("eu faço uma requisição GET para {string}")
    public void eu_faco_uma_requisicao_GET_para(String endpoint) {
        RestAssured.baseURI = "https://reqres.in/api";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        this.response = request.get(endpoint.replace("{id}", this.id));
    }

    @Then("o status da resposta é {int}")
    public void o_status_da_resposta_e(Integer statusCode) {
        this.response.then().statusCode(statusCode);
    }

    @Then("o campo {string} é igual a {string}")
    public void o_campo_e_igual_a(String campo, String valor) {
        this.response.then().body(campo, equalTo(valor));
    }

    @Then("o campo {string} é igual a {int}")
    public void o_campo_e_igual_a(String campo, Integer valor) {
        this.response.then().body(campo, equalTo(valor));
    }
}





