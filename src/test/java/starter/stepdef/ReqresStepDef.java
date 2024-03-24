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

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(ReqresAPI.UPDATE_USER);
    }
    // scenario 4
    @Given("Delete user with user id {int}")
    public void deleteUserWithUserId(int id) {
    reqresAPI.deleteUser(id);
    }



    @When("Send request delete user")
    public void sendRequestDeleteUser(){
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

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

    @Given("login user with valid email and password with json {string}")
    public void loginUserWithValidEmailAndPasswordWithJson(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.PostloginUser(jsonFile);
    }


    @Given("login username without password with json {string}")
    public void loginUsernameWithoutPasswordWithJson(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.PostloginUser(jsonFile);
    }

    @When("send request post login")
    public void sendRequestPostLogin() {

        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    //test case negative login

    @Given("login user without input email and password with json {string}")
    public void loginUserWithoutInputEmailAndPasswordWithJson(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.PostloginUser(jsonFile);
    }


    //scenario register
    @Given("User register with valid email and password {string}")
    public void userRegisterWithValidEmailAndPassword(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.RegisterUser(jsonFile);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(ReqresAPI.REGISTER);
    }


    //register negative
    @Given("User register with invalid email and valid password {string}")
    public void userRegisterWithInvalidEmail(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.RegisterUser(jsonFile);
    }

    @When("Send request get register")
    public void sendRequestGetRegister() {
        SerenityRest.when().get(ReqresAPI.REGISTER);
    }

    @Given("User register without input password {string}")
    public void userRegisterWithoutInputPassword(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.RegisterUser(jsonFile);
    }


    //delete negative scenario
    @Given("Delete user with invalid user {string}")
    public void deleteUserWithInvalidUser(String a) {
        reqresAPI.deleteInvalidUser(a);

    }

    @And("Response body should be {int} and {string}")
    public void responseBodyShouldBeAnd(int id, String token) {
        SerenityRest.when().post(ReqresAPI.REGISTER);
    }

    @And("Response body should shown an error message {string}")
    public void responseBodyShouldShownAnErrorMessage(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR,equalTo(error));
    }

    @Given("Patch user with valid json {string} and user id {int}")
    public void PatchUserWithValidJsonAndUserId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.patchUpdateUser(id, jsonFile);
    }


    @When("Send request patch user")
    public void sendRequestPatchUser() {
        SerenityRest.when().patch(ReqresAPI.UPDATE_USER);
    }

    @When("Send request get list resources")
    public void sendRequestGetListResources() {
        SerenityRest.when().get(ReqresAPI.LIST_RESOURCE);
    }

    @Given("Get list resource correctly")
    public void getListResourceCorrectly() {
        SerenityRest.given().get(ReqresAPI.LIST_RESOURCE);

    }

    @And("Response body should be page {int}")
    public void responseBodyShouldBePage(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE,equalTo(page));
    }

    @Given("Get list single user")
    public void getListSingleUser() {
        SerenityRest.given().get(ReqresAPI.LIST_SINGLE);
    }

    @When("Send request get list single user")
    public void sendRequestGetListSingleUser() {
        SerenityRest.given().get(ReqresAPI.LIST_SINGLE);
    }

    @Given("Get list single user with invalid page")
    public void getListSingleUserWithInvalidPage() {
        SerenityRest.given().get(ReqresAPI.SINGLE_NOT_FOUND);
    }

    @When("Send request get list single user invalid page")
    public void sendRequestGetListSingleUserInvalidPage() {
        SerenityRest.given().get(ReqresAPI.SINGLE_NOT_FOUND);
    }

    @Given("Update user with invalid json {string} and user id {}")
    public void updateUserWithInvalidJsonAndUserId(String json, int id) {
            File jsonFile = new File(Constants.REQ_BODY+json);
            reqresAPI.putUpdateUser(id, jsonFile);
    }
}
