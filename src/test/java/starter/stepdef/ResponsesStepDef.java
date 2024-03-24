package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import io.restassured.module.jsv.JsonSchemaValidator;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResponsesStepDef {
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);

    }

    @And("Validate json schema {string}")
    public void validateJsonSchema(String json) {
        File jsonFile = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Then("Status should be {int}")
    public void statusShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

/*    @And("Response body should be {string}")
    public void responseBodyShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }*/

/*    @And("Response body should be {string}")
    public void responseBodyShouldBeAnd(int id, String token) {
        SerenityRest.and().body(ReqresResponses.ID, equalTo(id))
                .and().body(ReqresResponses.TOKEN,equalTo(token));
    }*/

    @And("Response body should be shown error {string}")
    public void responseBodyShouldBeShownError(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(error));
    }


    @And("Response body should be show {string}")
    public void responseBodyShouldBeShow(String token) {

        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Response body should be shown error messages {string}")
    public void responseBodyShouldBeShownErrorMessages(String error) {

        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(error));
    }



    @And("Response body name should be name {} and job is {}")
    public void responseBodyNameShouldBeNameAndJobIs(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Response body should be data id {int}")
    public void responseBodyShouldBeData(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID, equalTo(id));
    }

    @And("Response body should shown error {string}")
    public void responseBodyShouldShownError(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(error));
    }

    /*@And("Response body should be {}")
    public void responseBodyShouldBe(String nocontent) {
        SerenityRest.and().body(ReqresResponses.NODATA, equalTo(nocontent));
    }*/
}
