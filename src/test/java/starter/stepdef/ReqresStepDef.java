package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.w3c.dom.xpath.XPathNamespace;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;
import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list user with parameter page {int}")
    public void getListUserWithParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.LIST_USERS);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {

        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }

    //scenario 2
    @Given("Create user with valid json {string}")
    public void createUserWithValidJson(String json){
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.postCreateUser(jsonFile);
    }

    @When("Send request create new user")
    public void sendRequestCreateNewUser(){
        SerenityRest.when().post(ReqresAPI.CREATE_USER);
    }

    @And("Response body name should be {string} and job is {string}")
    public void responseBodyNameShouldBeAndJobIs(String name, String job) {

        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }
    //scenario 3
    @Given("Update user with valid json {string} and user id {int}")
    public void updateUserWithValidJsonAndUserId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.putUpdateUser(id, jsonFile);
    }

    // scenario 4






    //scenario login
/*
    @Given("login user with valid email and password with json {String}")
    public void loginUserWithValidEmailAndPassword(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.PostloginUser(jsonFile);

    }
*/

/*    @And("Response body should be {int}")
    public void responseBodyShouldBe(int arg0) {
    }*/



    //test case negative login



    //scenario register




    @When("Send request get register")
    public void sendRequestGetRegister() {
        SerenityRest.when().get(ReqresAPI.REGISTER);
    }




    @And("Response body should be {int} and {string}")
    public void responseBodyShouldBeAnd(int id, String token) {
        SerenityRest.when().post(ReqresAPI.REGISTER);
    }




    @And("Response body should be page {int}")
    public void responseBodyShouldBePage(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }


}
